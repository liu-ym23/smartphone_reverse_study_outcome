package com.bytedance.sdk.xbridge.cn.auth;

import androidx.room.RoomDatabase;
import com.bytedance.sdk.xbridge.cn.auth.bean.AuthErrorCode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import li.k;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    public static final li.h d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f7297a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap f7298b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public mi.b f7299c;

    static {
        d = new li.h(RoomDatabase.MAX_BIND_PARAMETER_CNT, 1000);
    }

    public a(d r5) {
        Intrinsics.checkNotNullParameter(r5, "feAuthConfig");
        this.f7297a = r5;
        this.f7298b = new HashMap();
        this.f7299c = new com.lynx.tasm.behavior.d(7);
    }

    public final AuthErrorCode a(Map r16, li.e r17) {
        if (r16 != null) goto L5;
        Map r5 = MapsKt.emptyMap();
    L6:
        String r10 = r17.f19652a;
        k r11 = (k) r5.get(r10);
        if (r11 != null) goto L9;
        return null;
    L9:
        String r12 = r17.d;
        ArrayList r13 = r11.f19670c;
        if (r13 != null) goto L12;
    L17:
        boolean r14 = true;
    L18:
        if (r14 == false) goto L20;
        HashMap r15 = this.f7298b;
        li.d r18 = (li.d) r15.get(r10);
        if (r18 == null) goto L84;
        int r19 = r11.f19668a.intValue();
        int r110 = r18.f19650b;
        if (r19 == 0) goto L28;
        if (r19 > r110) goto L28;
        this.f7299c.a("AuthV2VerifyHelper", r10 + " is in call limit times,limit:" + r19);
        return AuthErrorCode.f7310j;
    L28:
        String r20 = r11.f19669b;
        if (r20 != null) goto L85;
    L67:
        li.h r21 = null;
    L68:
        if (r21 == null) goto L82;
        if (Intrinsics.areEqual(r21, d) == true) goto L82;
        long r111 = r18.f19649a.longValue();
        long r112 = System.currentTimeMillis() - r111;
        long r22 = r21.f19661a;
        if (r112 > r22) goto L79;
        int r23 = r18.f19651c;
        int r24 = r21.f19662b;
        if (r23 < r24) goto L79;
        this.f7299c.a("AuthV2VerifyHelper", r10 + " is in call limit frequency,has called " + r110 + " but limit " + r24 + " in " + r22 + "ms");
        return AuthErrorCode.f7309i;
    L79:
        if ((System.currentTimeMillis() - r111) <= r22) goto L81;
        r15.put(r10, new li.d(Long.valueOf(System.currentTimeMillis()), r110, 0));
        this.f7299c.a("AuthV2VerifyHelper", "bridge:" + r10 + ",reset call record");
    L81:
        return null;
    L82:
        return null;
    L85:
        List r25 = StringsKt.K(r20, new String[]{"/"}, 0, 6);     // Catch: Throwable -> L48
        if (r25 == null) goto L67;
        int r26 = Integer.parseInt((String) r25.get(0));     // Catch: Throwable -> L48
        String r27 = (String) r25.get(1);     // Catch: Throwable -> L48
        if (r27 == null) goto L62;
        int r28 = r27.hashCode();     // Catch: Throwable -> L48
        if (r28 == 100) goto L59;
        if (r28 == 104) goto L55;
        if (r28 == 109) goto L51;
        if (r28 != 115) goto L62;
        if (r27.equals("s") == false) goto L62;
        Long r29 = 1000L;     // Catch: Throwable -> L48
    L63:
        if (r29 == null) goto L67;
        r21 = new li.h(r26, r29.longValue());     // Catch: Throwable -> L48
        goto L68
    L51:
        if (r27.equals("m") == false) goto L62;
        r29 = Long.valueOf(60000);     // Catch: Throwable -> L48
        goto L63
    L55:
        if (r27.equals("h") == false) goto L62;
        r29 = Long.valueOf(3600000);     // Catch: Throwable -> L48
        goto L63
    L59:
        if (r27.equals("d") == false) goto L62;
        r29 = Long.valueOf(86400000);     // Catch: Throwable -> L48
    L62:
        r29 = null;
    L48:
        th = move-exception;
        this.f7299c.a("AuthV2VerifyHelper", androidx.room.jarjarred.org.antlr.runtime.a.x(th, new StringBuilder("parse limit error:")));
        goto L67
    L84:
        return null;
    L20:
        return AuthErrorCode.f7308h;
    L12:
        if (r13.isEmpty() == true) goto L17;
        if (r12 != null) goto L16;
        r14 = false;
        goto L18
    L16:
        r14 = com.lynx.tasm.utils.d.m(r12, r13);
        goto L18
    L5:
        r5 = r16;
        goto L6
    }

    public final void b(li.c r5, li.e r10) {
        if (r5.f19640a == false) goto L10;
        HashMap r11 = this.f7298b;
        String r12 = r10.f19652a;
        li.d r13 = (li.d) r11.get(r12);
        if (r13 == null) goto L7;
        li.d r14 = new li.d(Long.valueOf(System.currentTimeMillis()), r13.f19650b + 1, r13.f19651c + 1);
    L8:
        r11.put(r12, r14);
        return;
    L7:
        r14 = new li.d(Long.valueOf(System.currentTimeMillis()), 1, 1);
        goto L8
    }
}
