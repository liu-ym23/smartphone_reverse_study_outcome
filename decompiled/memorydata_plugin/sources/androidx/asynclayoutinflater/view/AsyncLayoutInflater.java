package androidx.asynclayoutinflater.view;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.util.Pools;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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

        BasicInflater(Context r3) {
            super(ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin"));
        }

        @Override // android.view.LayoutInflater
        public LayoutInflater cloneInContext(Context r2) {
            return new BasicInflater((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"));
        }

        @Override // android.view.LayoutInflater
        public View onCreateView(String r5, AttributeSet r6) {
            AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r6, AttributeSet.class, "com.obric.memorydata.plugin");
            String[] r0 = sClassPrefixList;
            int r1 = r0.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L10;
            View r3 = createView(r5, r0[r2], r7);     // Catch: ClassNotFoundException -> L11
            if (r3 == null) goto L8;
            return r3;
        L8:
            r2 = r2 + 1;
            goto L3
        L10:
            return super.onCreateView(r5, r7);
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
            InflateThread r0 = new InflateThread();
            sInstance = r0;
            r0.start();
        }

        private InflateThread() {
            this.mQueue = new ArrayBlockingQueue(10);
            this.mRequestPool = new Pools.SynchronizedPool(10);
        }

        public static InflateThread getInstance() {
            return sInstance;
        }

        public void enqueue(InflateRequest r2) {
            this.mQueue.put(r2);     // Catch: InterruptedException -> L4
            return;
        L4:
            e = move-exception;
            throw new RuntimeException("Failed to enqueue async inflate request", e);
        }

        public InflateRequest obtainRequest() {
            InflateRequest r2 = (InflateRequest) ZeusTransformUtils.preCheckCast(this.mRequestPool.acquire(), InflateRequest.class, "com.obric.memorydata.plugin");
            if (r2 == null) goto L5;
            return r2;
        L5:
            return new InflateRequest();
        }

        public void releaseRequest(InflateRequest r3) {
            r3.callback = null;
            r3.inflater = null;
            r3.parent = null;
            r3.resid = 0;
            r3.view = null;
            this.mRequestPool.release(r3);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
        L2:
            runInner();
            goto L2
        }

        public void runInner() {
            InflateRequest r6 = (InflateRequest) ZeusTransformUtils.preCheckCast(this.mQueue.take(), InflateRequest.class, "com.obric.memorydata.plugin");     // Catch: InterruptedException -> L11
            r6.view = ZeusTransformUtils.inflate(r6.inflater.mInflater, r6.resid, r6.parent, false, "com.obric.memorydata.plugin");     // Catch: RuntimeException -> L7
        L9:
            Message.obtain(r6.inflater.mHandler, 0, r6).sendToTarget();
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
        void onInflateFinished(View r1, int r2, ViewGroup r3);
    }

    public AsyncLayoutInflater(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        this.mHandlerCallback = new AnonymousClass1(this);
        this.mInflater = new BasicInflater(r4);
        this.mHandler = new Handler(this.mHandlerCallback);
        this.mInflateThread = InflateThread.getInstance();
    }

    public void inflate(int r3, ViewGroup r4, OnInflateFinishedListener r5) {
        OnInflateFinishedListener r6 = (OnInflateFinishedListener) ZeusTransformUtils.wrapperContextForParams(r5, OnInflateFinishedListener.class, "com.obric.memorydata.plugin");
        Objects.requireNonNull(r6, "callback argument may not be null!");
        InflateRequest r0 = this.mInflateThread.obtainRequest();
        r0.inflater = this;
        r0.resid = r3;
        r0.parent = r4;
        r0.callback = r6;
        this.mInflateThread.enqueue(r0);
    }
}
