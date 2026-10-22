package com.bytedance.apm.util;

import android.content.Context;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.n;
import l9.l;
import l9.o;
import org.json.JSONObject;
import sj.k;
import ym.m;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3907a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Throwable f3908b;

    public /* synthetic */ b(int r5, Throwable r10) {
        this.f3907a = r5;
        this.f3908b = r10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch(this.f3907a) {
            case 0: goto L19;
            default: goto L4;
        };
    L4:
        Context r5 = n.f4057a;
        long r10 = System.currentTimeMillis();
        if (r10 != 0) goto L7;
        r10 = System.currentTimeMillis();
    L7:
        z8.c r11 = new z8.c();
        JSONObject r12 = r11.f23416a;
        mh.e.g(1, "isJava", r12);
        mh.e.g(com.bytedance.crash.util.h.a(this.f3908b), "data", r12);
        mh.e.g(Long.valueOf(r10), "crash_time", r12);
        mh.e.g(m.o(r5), "process_name", r12);
        if (m.q(r5) == true) goto L10;
        mh.e.g(1, "remote_process", r12);
    L10:
        mh.e.g(1, "userdefine", r12);
        z8.c r13 = l.f().g(CrashType.CUSTOM_JAVA, r11, null, false);
        if (r13 == null) goto L21;
        k.g().getClass();
        JSONObject r14 = r13.f23416a;
        if (r14 != null) goto L15;
        return;
    L15:
        if (r14.length() == 0) goto L23;
        o.e().b(new com.bytedance.apm.a(r14));
        return;
    L23:
        return;
    L21:
        return;
    L19:
        f9.a r15 = com.bytedance.apm.k.f3892a;
        Throwable r16 = this.f3908b;
        r15.getClass();
        f9.a.i(r16);
    }
}
