package com.bytedance.crash.upload;

import android.text.TextUtils;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.MonitorCrash;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class j implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f4132a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f4133b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f4134c;
    public final /* synthetic */ Throwable d;
    public final /* synthetic */ StackTraceElement[] e;
    public final /* synthetic */ int f;
    public final /* synthetic */ String g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ MonitorCrash f4135h;

    public j(boolean r5, String r10, String r11, Throwable r12, StackTraceElement[] r13, int r14, String r15, MonitorCrash r16) {
        this.f4132a = r5;
        this.f4133b = r10;
        this.f4134c = r11;
        this.d = r12;
        this.e = r13;
        this.f = r14;
        this.g = r15;
        this.f4135h = r16;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (com.bytedance.crash.p.f4081a == true) goto L7;
        l9.o.e().c(this, 500);
        return;
    L7:
        if (n.f() == true) goto L77;
        String r5 = this.f4133b;
        boolean r10 = this.f4132a;
        if (r10 == true) goto L12;
    L19:
        String r11 = null;
    L20:
        int r12 = this.f;
        StackTraceElement[] r13 = this.e;
        Throwable r14 = this.d;
        if (r14 != null) goto L28;
        if (r13 == null) goto L72;
    L26:
        th = move-exception;
        io.reactivex.exceptions.a.j(th);
        return;
    L24:
        if (r13.length > (r12 + 1)) goto L28;
        return;
    L72:
        return;
    L28:
        if (r13 != null) goto L30;
        r13 = r14.getStackTrace();     // Catch: Throwable -> L26
    L30:
        StackTraceElement r15 = r13[r12];     // Catch: Throwable -> L26
        if (r15 == null) goto L74;
        if (r14 == null) goto L36;
        String r16 = com.bytedance.crash.util.h.a(r14);     // Catch: Throwable -> L26
    L43:
        String r17 = r16;
    L45:
        if (TextUtils.isEmpty(r17) == true) goto L75;
        String r18 = this.f4134c;     // Catch: Throwable -> L26
        if (com.bytedance.crash.n.f4074w == false) goto L54;
        if (r10 == false) goto L54;
        String r19 = com.bytedance.crash.util.d.b(r17);     // Catch: Throwable -> L26
        l9.i r20 = l9.i.a();     // Catch: Throwable -> L26
        if (r20.d(r19, r20.d, false) == false) goto L76;
        String r110 = r19;
    L55:
        z8.f r21 = z8.f.q(r15, r17, this.f4133b, r18, this.g, "core_exception_monitor", r110);     // Catch: Throwable -> L26
        MonitorCrash r111 = this.f4135h;
        JSONObject r22 = r21.f23416a;
        if (r111 == null) goto L59;
        ConcurrentLinkedQueue r23 = z8.d.f23418a;     // Catch: Throwable -> L26
        mh.e.g(null, "exception_line_num", r22);     // Catch: Throwable -> L26
    L59:
        if (r11 == null) goto L67;
        mh.e.g(r11, "message_md5", r22);     // Catch: Throwable -> L26
    L67:
        new JSONObject();     // Catch: Throwable -> L66
    L62:
        l9.l.f().g(CrashType.ENSURE, r21, null, false);     // Catch: Throwable -> L26
        n.c(r111, r21);     // Catch: Throwable -> L26
        io.reactivex.exceptions.a.c("[reportException] " + r5);     // Catch: Throwable -> L26
        return;
    L76:
        return;
    L54:
        r110 = null;
        goto L55
    L75:
        return;
    L36:
        if (r13.length > 0) goto L38;
        r17 = null;
        goto L45
    L38:
        StringBuilder r24 = new StringBuilder();     // Catch: Throwable -> L26
    L40:
        if (r12 >= r13.length) goto L42;
        StackTraceElement r25 = r13[r12];     // Catch: Throwable -> L26
        int r112 = com.bytedance.crash.util.h.f4186a;     // Catch: Throwable -> L26
        String r113 = r25.getClassName();     // Catch: Throwable -> L26
        r24.append("  at ");     // Catch: Throwable -> L26
        r24.append(r113);     // Catch: Throwable -> L26
        r24.append(".");     // Catch: Throwable -> L26
        r24.append(r25.getMethodName());     // Catch: Throwable -> L26
        r24.append("(");     // Catch: Throwable -> L26
        r24.append(r25.getFileName());     // Catch: Throwable -> L26
        r24.append(":");     // Catch: Throwable -> L26
        r24.append(r25.getLineNumber());     // Catch: Throwable -> L26
        r24.append(")\n");     // Catch: Throwable -> L26
        r12 = r12 + 1;     // Catch: Throwable -> L26
        goto L40
    L42:
        r16 = r24.toString();     // Catch: Throwable -> L26
        goto L43
    L74:
        return;
    L12:
        if (com.bytedance.crash.n.f4074w == false) goto L19;
        if (r5 == null) goto L15;
        r11 = com.bytedance.crash.util.d.b(r5);
    L16:
        l9.i r26 = l9.i.a();
        if (r26.d(r11, r26.e, false) == true) goto L20;
        return;
    L15:
        r11 = null;
        goto L16
    }
}
