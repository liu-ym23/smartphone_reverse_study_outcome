package com.ttnet.org.chromium.base;

import com.ttnet.org.chromium.base.annotations.CalledByNative;

/* JADX INFO: loaded from: classes2.dex */
public interface Callback<T> {

    public static abstract class Helper {
        public Helper() {
        }

        @CalledByNative("Helper")
        public static void onBooleanResultFromNative(Callback r8, boolean r10) {
            r8.onResult(Boolean.valueOf(r10));
        }

        @CalledByNative("Helper")
        public static void onIntResultFromNative(Callback r8, int r10) {
            r8.onResult(Integer.valueOf(r10));
        }

        @CalledByNative("Helper")
        public static void onObjectResultFromNative(Callback r8, Object r10) {
            r8.onResult(r10);
        }

        @CalledByNative("Helper")
        public static void runRunnable(Runnable r8) {
            r8.run();
        }
    }

    void onResult(T r8);
}
