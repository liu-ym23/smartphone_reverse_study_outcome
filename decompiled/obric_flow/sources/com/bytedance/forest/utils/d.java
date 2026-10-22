package com.bytedance.forest.utils;

import android.os.Handler;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes2.dex */
public final class d {
    public static final SimpleDateFormat e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function3 f4616a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f4617b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f4618c;
    public final String d;

    static {
        e = new SimpleDateFormat("MM-dd HH:mm:ss.SSS");
    }

    public d() {
        this.f4617b = "";
        this.f4618c = "";
        StringBuilder r5 = new StringBuilder();
        r5.append(hashCode());
        r5.append('-');
        r5.append(System.currentTimeMillis());
        this.d = r5.toString();
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [T, java.lang.String] */
    public static void b(d r12, int r13, String r14, String r15, boolean r16, Throwable r17, String r18, int r19) {
        if ((r19 & 2) == 0) goto L5;
        String r10 = null;
    L7:
        if ((r19 & 8) == 0) goto L9;
        boolean r11 = false;
    L11:
        if ((r19 & 16) == 0) goto L13;
        Throwable r110 = null;
    L15:
        if ((r19 & 32) == 0) goto L17;
        String r20 = "";
    L18:
        r12.getClass();
        long r5 = System.currentTimeMillis();
        Ref.ObjectRef r21 = new Ref.ObjectRef();
        StringBuilder r22 = new StringBuilder("[");
        String r23 = r12.d;
        r22.append(r23);
        r22.append("][");
        r22.append(Thread.currentThread().getName());
        r22.append(']');
        r22.append(r15);
        r21.element = r22.toString();
        HashMap r24 = new HashMap();
        r24.put("request_id", r23);
        r24.put("session_id", r12.f4617b);
        r24.put("url", r12.f4618c);
        ((Handler) q.f4658c.getValue()).post(new b(r12, r5, r21, r13, r10, r11, r20, r24, r110));
        return;
    L17:
        r20 = r18;
        goto L18
    L13:
        r110 = r17;
        goto L15
    L9:
        r11 = r16;
        goto L11
    L5:
        r10 = r14;
        goto L7
    }

    public static /* synthetic */ void c(d r10, int r11, String r12, Throwable r13, String r14, Function0 r15, int r16) {
        if ((r16 & 4) == 0) goto L6;
        boolean r5 = false;
    L5:
        boolean r17 = r5;
        if ((r16 & 8) == 0) goto L10;
        r13 = null;
    L10:
        Throwable r18 = r13;
        if ((r16 & 16) == 0) goto L13;
        r14 = "";
    L13:
        r10.a(r11, r12, r17, r18, r14, r15);
        return;
    L6:
        r5 = true;
        goto L5
    }

    public final void a(int r14, String r15, boolean r16, Throwable r17, String r18, Function0 r19) {
        long r5 = System.currentTimeMillis();
        StringBuilder r10 = new StringBuilder("[");
        String r11 = this.d;
        r10.append(r11);
        r10.append("][");
        r10.append(Thread.currentThread().getName());
        r10.append(']');
        String r12 = r10.toString();
        HashMap r13 = new HashMap();
        r13.put("request_id", r11);
        r13.put("session_id", this.f4617b);
        r13.put("url", this.f4618c);
        c r110 = new c(this, r5, r12, r19, r14, r15, r16, r18, r13, r17);
        ((Handler) q.f4658c.getValue()).post(r110);
    }
}
