package com.bytedance.badger.collect.impl.network.interfaces;

import com.bytedance.badger.collect.impl.model.TTRequest;
import com.bytedance.badger.collect.impl.model.TTResponse;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public interface IChainHandler {

    /* JADX INFO: renamed from: com.bytedance.badger.collect.impl.network.interfaces.IChainHandler$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static long $default$getRetryDelay(IChainHandler r0, int r1) {
            return 1000;
        }

        public static boolean $default$shouldRetry(IChainHandler r0, TTResponse r1, int r2) {
            return false;
        }
    }

    public interface IChain {
        TTRequest getRequest();

        TTResponse process(TTRequest r1);
    }

    long getRetryDelay(int r1);

    TTResponse handle(IChain r1) throws Exception;

    boolean shouldRetry(TTResponse r1, int r2);
}
