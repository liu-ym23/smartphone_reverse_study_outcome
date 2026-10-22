package com.ttnet.org.chromium.base;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
@FunctionalInterface
public interface Callback<T> {

    public static abstract class Helper {
        public Helper() {
        }

        static void onBooleanResultFromNative(Callback r2, boolean r3) {
            ((Callback) ZeusTransformUtils.wrapperContextForParams(r2, Callback.class, "com.obric.memorydata.plugin")).onResult(Boolean.valueOf(r3));
        }

        static void onIntResultFromNative(Callback r2, int r3) {
            ((Callback) ZeusTransformUtils.wrapperContextForParams(r2, Callback.class, "com.obric.memorydata.plugin")).onResult(Integer.valueOf(r3));
        }

        static void onLongResultFromNative(Callback r2, long r3) {
            ((Callback) ZeusTransformUtils.wrapperContextForParams(r2, Callback.class, "com.obric.memorydata.plugin")).onResult(Long.valueOf(r3));
        }

        static void onObjectResultFromNative(Callback r2, Object r3) {
            ((Callback) ZeusTransformUtils.wrapperContextForParams(r2, Callback.class, "com.obric.memorydata.plugin")).onResult(r3);
        }

        static void onTimeResultFromNative(Callback r2, long r3) {
            ((Callback) ZeusTransformUtils.wrapperContextForParams(r2, Callback.class, "com.obric.memorydata.plugin")).onResult(Long.valueOf(r3));
        }

        static void runRunnable(Runnable r2) {
            ((Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.memorydata.plugin")).run();
        }
    }

    static /* synthetic */ void lambda$bind$0(Callback r0, Object r1) {
        r0.onResult(r1);
    }

    default Runnable bind(final T r2) {
        return new $$Lambda$Callback$OYff4I1q7HITldj7BhL2u76mbs(this, r2);
    }

    void onResult(T r1);
}
