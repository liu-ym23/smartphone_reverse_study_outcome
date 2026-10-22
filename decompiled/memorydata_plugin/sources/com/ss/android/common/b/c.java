package com.ss.android.common.b;

import android.util.Log;

/* JADX INFO: loaded from: classes6.dex */
public class c {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static boolean f15117a = false;

        static {
        }

        public static void a(String r1) {
            if (f15117a == false) goto L6;
            Log.w("TeaLog_Task", r1);
            return;
        }

        public static void b(String r1) {
            if (f15117a == false) goto L6;
            Log.i("TeaLog_Task", r1);
            return;
        }

        public static void c(String r1) {
            if (f15117a == false) goto L6;
            Log.d("TeaLog_Task", r1);
            return;
        }
    }
}
