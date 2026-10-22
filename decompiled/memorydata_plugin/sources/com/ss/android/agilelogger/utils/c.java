package com.ss.android.agilelogger.utils;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.UnknownHostException;

/* JADX INFO: loaded from: classes4.dex */
public class c {

    private static class a extends StringWriter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f15016a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f15017b;

        public a() {
            this.f15016a = 0;
            this.f15017b = false;
        }

        @Override // java.io.StringWriter, java.io.Writer
        public void write(String r4, int r5, int r6) {
            if (this.f15017b == false) goto L5;
            return;
        L5:
            int r0 = this.f15016a;
            if ((r0 + r6) <= 4000) goto L9;
            this.f15017b = true;
            return;
        L9:
            this.f15016a = r0 + r6;
            super.write(r4, r5, r6);
        }
    }

    public static String a(Throwable r2) {
        if (r2 != null) goto L5;
        return "";
    L5:
        Throwable r0 = r2;
    L6:
        if (r0 == null) goto L12;
        if (ZeusTransformUtils.instanceOf(r0, UnknownHostException.class) == true) goto L9;
        r0 = r0.getCause();
        goto L6
    L9:
        return "ALOG:UnknownHostException";
    L12:
        a r1 = new a();
        PrintWriter r3 = new PrintWriter(r1);
        r2.printStackTrace(r3);     // Catch: Throwable -> L16
    L14:
        r3.flush();
        return r1.toString();
    }
}
