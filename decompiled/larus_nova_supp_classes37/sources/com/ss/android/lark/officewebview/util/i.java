package com.ss.android.lark.officewebview.util;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class i {
    public final Handler a;

    public static class a {
        public static final i a = null;

        static {
            a = new i();
        }
    }

    public i() {
        this.a = new Handler(Looper.getMainLooper());
    }

    public static boolean a() {
        if (Looper.myLooper() != Looper.getMainLooper()) goto L5;
        return true;
    L5:
        return false;
    }

    public final void b(Runnable r2) {
        this.a.post(r2);
    }
}
