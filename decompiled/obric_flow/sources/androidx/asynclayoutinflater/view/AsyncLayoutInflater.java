package androidx.asynclayoutinflater.view;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.core.util.Pools;
import java.util.concurrent.ArrayBlockingQueue;

/* JADX INFO: loaded from: classes.dex */
public final class AsyncLayoutInflater {
    private static final String TAG = "AsyncLayoutInflater";
    Handler mHandler;
    private Handler.Callback mHandlerCallback;
    InflateThread mInflateThread;
    LayoutInflater mInflater;

    public static class BasicInflater extends LayoutInflater {
        private static final String[] sClassPrefixList = null;

        static {
            sClassPrefixList = new String[]{"android.widget.", "android.webkit.", "android.app."};
        }

        public BasicInflater(Context r5) {
            super(r5);
        }

        @Override // android.view.LayoutInflater
        public LayoutInflater cloneInContext(Context r5) {
            return new BasicInflater(r5);
        }

        @Override // android.view.LayoutInflater
        public View onCreateView(String r5, AttributeSet r10) throws ClassNotFoundException {
            String[] r11 = sClassPrefixList;
            int r12 = r11.length;
            int r13 = 0;
        L3:
            if (r13 >= r12) goto L10;
            View r14 = createView(r5, r11[r13], r10);     // Catch: ClassNotFoundException -> L11
            if (r14 == null) goto L8;
            return r14;
        L8:
            r13 = r13 + 1;
            goto L3
        L10:
            return super.onCreateView(r5, r10);
        }
    }

    public static class InflateRequest {
        OnInflateFinishedListener callback;
        AsyncLayoutInflater inflater;
        ViewGroup parent;
        int resid;
        View view;

        public InflateRequest() {
        }
    }

    public static class InflateThread extends Thread {
        private static final InflateThread sInstance = null;
        private ArrayBlockingQueue<InflateRequest> mQueue;
        private Pools.SynchronizedPool<InflateRequest> mRequestPool;

        static {
            InflateThread r5 = new InflateThread();
            sInstance = r5;
            r5.start();
        }

        private InflateThread() {
            this.mQueue = new ArrayBlockingQueue(10);
            this.mRequestPool = new Pools.SynchronizedPool(10);
        }

        public static InflateThread getInstance() {
            return sInstance;
        }

        public void enqueue(InflateRequest r5) {
            this.mQueue.put(r5);     // Catch: InterruptedException -> L4
            return;
        L4:
            e = move-exception;
            throw new RuntimeException("Failed to enqueue async inflate request", e);
        }

        public InflateRequest obtainRequest() {
            InflateRequest r5 = this.mRequestPool.acquire();
            if (r5 == null) goto L5;
            return r5;
        L5:
            return new InflateRequest();
        }

        public void releaseRequest(InflateRequest r5) {
            r5.callback = null;
            r5.inflater = null;
            r5.parent = null;
            r5.resid = 0;
            r5.view = null;
            this.mRequestPool.release(r5);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
        L2:
            runInner();
            goto L2
        }

        public void runInner() {
            InflateRequest r5 = this.mQueue.take();     // Catch: InterruptedException -> L11
            r5.view = r5.inflater.mInflater.inflate(r5.resid, r5.parent, false);     // Catch: RuntimeException -> L7
        L9:
            Message.obtain(r5.inflater.mHandler, 0, r5).sendToTarget();
            return;
        L7:
            e = move-exception;
            Log.w(AsyncLayoutInflater.TAG, "Failed to inflate resource in the background! Retrying on the UI thread", e);
        L11:
            e = move-exception;
            Log.w(AsyncLayoutInflater.TAG, e);
        }
    }

    public interface OnInflateFinishedListener {
        void onInflateFinished(@NonNull View r5, @LayoutRes int r10, @Nullable ViewGroup r11);
    }

    public AsyncLayoutInflater(@NonNull Context r5) {
        this.mHandlerCallback = new AnonymousClass1(this);
        this.mInflater = new BasicInflater(r5);
        this.mHandler = new Handler(this.mHandlerCallback);
        this.mInflateThread = InflateThread.getInstance();
    }

    @UiThread
    public void inflate(@LayoutRes int r5, @Nullable ViewGroup r10, @NonNull OnInflateFinishedListener r11) {
        if (r11 == null) goto L6;
        InflateRequest r12 = this.mInflateThread.obtainRequest();
        r12.inflater = this;
        r12.resid = r5;
        r12.parent = r10;
        r12.callback = r11;
        this.mInflateThread.enqueue(r12);
        return;
    L6:
        throw new NullPointerException("callback argument may not be null!");
    }
}
