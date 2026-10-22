package com.tencent.open.b;

import android.os.Bundle;
import com.tencent.open.utils.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public class e {
    protected static e a;

    public void a(int r1, String r2, String r3, String r4, String r5, Long r6, int r7, int r8, String r9) {
    }

    public static synchronized e a() {
        monitor-enter(e.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (a != null) goto L7;
        a = new e();     // Catch: Throwable -> L10
    L7:
        e r1 = a;     // Catch: Throwable -> L10
        monitor-exit(e.class);
        return r1;
    }

    public e() {
    }

    public void a(String r7, String r8, String r9, String r10, String r11, String r12) {
        Bundle r13 = m.a(r7, r9, r10, r11, r8, r12);
        h.a().a(r13, r8, true);
    }

    public void a(String r13, String r14, String r15, String r16, String r17, String r18, String r19, String r20) {
        Bundle r0 = m.a(r13, r16, r17, r15, r14, r18, "", r19, r20, "", "", "");
        h.a().a(r0, r14, false);
    }

    public void a(String r13, String r14, String r15, String r16, String r17, String r18, String r19, String r20, String r21, String r22) {
        Bundle r0 = m.a(r13, r16, r17, r15, r14, r18, r19, "", "", r20, r21, r22);
        h.a().a(r0, r14, false);
    }
}
