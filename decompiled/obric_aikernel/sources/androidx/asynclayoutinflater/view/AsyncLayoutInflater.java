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
import java.util.Objects;
import java.util.concurrent.ArrayBlockingQueue;

/* JADX INFO: loaded from: classes.dex */
public final class AsyncLayoutInflater {
    private static final String TAG = "AsyncLayoutInflater";
    Handler mHandler;
    private Handler.Callback mHandlerCallback;
    InflateThread mInflateThread;
    LayoutInflater mInflater;

    private static class BasicInflater extends LayoutInflater {
        private static final String[] sClassPrefixList = null;

        static {
            sClassPrefixList = new String[]{"android.widget.", "android.webkit.", "android.app."};
        }

        BasicInflater(Context r10) {
            super(r10);
        }

        @Override // android.view.LayoutInflater
        public LayoutInflater cloneInContext(Context r10) {
            return new BasicInflater(r10);
        }

        @Override // android.view.LayoutInflater
        protected View onCreateView(String r10, AttributeSet r11) {
            String[] r12 = sClassPrefixList;
            int r13 = r12.length;
            int r14 = 0;
        L3:
            if (r14 >= r13) goto L10;
            View r15 = createView(r10, r12[r14], r11);     // Catch: ClassNotFoundException -> L11
            if (r15 == null) goto L8;
            return r15;
        L8:
            r14 = r14 + 1;
            goto L3
        L10:
            return super.onCreateView(r10, r11);
        }
    }

    private static class InflateRequest {
        OnInflateFinishedListener callback;
        AsyncLayoutInflater inflater;
        ViewGroup parent;
        int resid;
        View view;

        InflateRequest() {
        }
    }

    private static class InflateThread extends Thread {
        private static final InflateThread sInstance = null;
        private ArrayBlockingQueue<InflateRequest> mQueue;
        private Pools.SynchronizedPool<InflateRequest> mRequestPool;

        static {
            InflateThread r10 = new InflateThread();
            sInstance = r10;
            r10.start();
        }

        private InflateThread() {
            this.mQueue = new ArrayBlockingQueue(10);
            this.mRequestPool = new Pools.SynchronizedPool(10);
        }

        public static InflateThread getInstance() {
            return sInstance;
        }

        public void enqueue(InflateRequest r10) {
            this.mQueue.put(r10);     // Catch: InterruptedException -> L4
            return;
        L4:
            e = move-exception;
            throw new RuntimeException("Failed to enqueue async inflate request", e);
        }

        public InflateRequest obtainRequest() {
            InflateRequest r10 = this.mRequestPool.acquire();
            if (r10 == null) goto L5;
            return r10;
        L5:
            return new InflateRequest();
        }

        public void releaseRequest(InflateRequest r10) {
            r10.callback = null;
            r10.inflater = null;
            r10.parent = null;
            r10.resid = 0;
            r10.view = null;
            this.mRequestPool.release(r10);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
        L2:
            runInner();
            goto L2
        }

        public void runInner() {
            InflateRequest r10 = this.mQueue.take();     // Catch: InterruptedException -> L11
            r10.view = r10.inflater.mInflater.inflate(r10.resid, r10.parent, false);     // Catch: RuntimeException -> L7
        L9:
            Message.obtain(r10.inflater.mHandler, 0, r10).sendToTarget();
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
        void onInflateFinished(@NonNull View r10, @LayoutRes int r11, @Nullable ViewGroup r12);
    }

    public AsyncLayoutInflater(@NonNull Context r10) {
        this.mHandlerCallback = new AnonymousClass1(this);
        this.mInflater = new BasicInflater(r10);
        this.mHandler = new Handler(this.mHandlerCallback);
        this.mInflateThread = InflateThread.getInstance();
    }

    @UiThread
    public void inflate(@LayoutRes int r10, @Nullable ViewGroup r11, @NonNull OnInflateFinishedListener r12) {
        Objects.requireNonNull(r12, "callback argument may not be null!");
        InflateRequest r13 = this.mInflateThread.obtainRequest();
        r13.inflater = this;
        r13.resid = r10;
        r13.parent = r11;
        r13.callback = r12;
        this.mInflateThread.enqueue(r13);
    }
}
