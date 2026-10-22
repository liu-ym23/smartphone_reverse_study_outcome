package com.bytedance.als;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class ThreadUtility {
    public static final Handler a = null;

    public static class IncorrectThreadException extends RuntimeException {
        public IncorrectThreadException(String r1) {
            super(r1);
        }
    }

    static {
        a = new Handler(Looper.getMainLooper());
    }
}
