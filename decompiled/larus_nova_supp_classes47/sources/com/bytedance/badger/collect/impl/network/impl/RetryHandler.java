package com.bytedance.badger.collect.impl.network.impl;

import android.os.Handler;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.badger.collect.impl.model.TTRequest;
import com.bytedance.badger.collect.impl.model.TTResponse;
import com.bytedance.badger.collect.impl.network.interfaces.IChainHandler;
import com.bytedance.badger.collect.impl.utils.ExecutorManager;
import com.bytedance.badger.collect.impl.utils.KLog;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public class RetryHandler implements IChainHandler {
    private static final int MAX_RETRY_COUNT = 3;
    private final Handler retryHandler;

    public class RetryCallback {
        private final IChainHandler.IChain chain;
        private boolean completed;
        private TTResponse finalResponse;
        private final TTRequest request;
        private int retryCount;
        final /* synthetic */ RetryHandler this$0;

        public synchronized TTResponse getFinalResponse() {
            monitor-enter(this);
            TTResponse r0 = this.finalResponse;     // Catch: Throwable -> L6
            monitor-exit(this);
            return r0;
        L6:
            th = move-exception;
            throw th;
        }

        public synchronized boolean isCompleted() {
            monitor-enter(this);
            boolean r0 = this.completed;     // Catch: Throwable -> L6
            monitor-exit(this);
            return r0;
        L6:
            th = move-exception;
            throw th;
        }

        public void retry() {
            RetryHandler.access$300(this.this$0).post(new AnonymousClass1(this));
        }

        public static /* synthetic */ TTRequest access$000(RetryCallback r0) {
            return r0.request;
        }

        public static /* synthetic */ IChainHandler.IChain access$100(RetryCallback r0) {
            return r0.chain;
        }

        public static /* synthetic */ int access$200(RetryCallback r0) {
            return r0.retryCount;
        }

        public static /* synthetic */ int access$208(RetryCallback r2) {
            int r0 = r2.retryCount;
            r2.retryCount = r0 + 1;
            return r0;
        }

        public static /* synthetic */ TTResponse access$402(RetryCallback r0, TTResponse r1) {
            r0.finalResponse = r1;
            return r1;
        }

        public static /* synthetic */ boolean access$502(RetryCallback r0, boolean r1) {
            r0.completed = r1;
            return r1;
        }

        public RetryCallback(RetryHandler r1, IChainHandler.IChain r2, TTRequest r3) {
            this.this$0 = r1;
            this.finalResponse = null;
            this.retryCount = 0;
            this.completed = false;
            this.chain = r2;
            this.request = r3;
        }
    }

    public RetryHandler() {
        this.retryHandler = ExecutorManager.getInstance().getHandler();
    }

    public static /* synthetic */ Handler access$300(RetryHandler r0) {
        return r0.retryHandler;
    }

    @Override // com.bytedance.badger.collect.impl.network.interfaces.IChainHandler
    public long getRetryDelay(int r5) {
        return ((long) Math.pow(2.0d, r5)) * 1000;
    }

    @Override // com.bytedance.badger.collect.impl.network.interfaces.IChainHandler
    public TTResponse handle(IChainHandler.IChain r3) throws Exception {
        RetryCallback r1 = new RetryCallback(this, r3, r3.getRequest());
        r1.retry();
        monitor-enter(r1);
    L13:
    L10:
        th = move-exception;
        throw th;
    L5:
        if (r1.isCompleted() == true) goto L7;
        r1.wait();     // Catch: Throwable -> L10
        goto L13
    L7:
        monitor-exit(r1);     // Catch: Throwable -> L10
        return r1.getFinalResponse();
    }

    @Override // com.bytedance.badger.collect.impl.network.interfaces.IChainHandler
    public boolean shouldRetry(TTResponse r3, int r4) {
        KLog.w(Constants.TAGS.NETWORK, "RetryHandler# request failed, need retry...... ");
        if (r3 == null) goto L7;
        if (r3.getStatusCode() != 200) goto L7;
    L9:
        return false;
    L7:
        if (r4 >= 3) goto L9;
        return true;
    }
}
