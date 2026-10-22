package com.bytedance.android.live.recharge.model;

import com.bytedance.android.live.saas.middleware.fresco.DefaultConfig;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d {
    public static final d p = null;
    public final boolean a;
    public final String b;
    public final String c;
    public final long d;
    public final boolean e;
    public final int f;
    public final int g;
    public final String h;
    public final String i;
    public final b j;
    public final f k;
    public final String l;
    public final Map<String, String> m;
    public String n;
    public final String o;

    public static final class a {
    }

    static {
        p = new d(true, "", null, 0, false, 0, 0, null, null, null, null, null, null, 32764);
    }

    public /* synthetic */ d(boolean r20, String r22, String r23, long r24, boolean r25, int r26, int r27, String r28, String r29, b r30, f r32, String r33, String r34, int r35) {
        if ((r35 & 4) == 0) goto L5;
        String r5 = "live_detail";
    L7:
        if ((r35 & 8) == 0) goto L9;
        long r6 = 0;
    L11:
        if ((r35 & 16) != 0) goto L13;
        boolean r8 = r25;
    L19:
        if ((r35 & 32) == 0) goto L21;
        int r9 = -1;
    L23:
        if ((r35 & 64) == 0) goto L25;
        int r10 = -1;
    L27:
        if ((r35 & 128) == 0) goto L29;
        String r12 = "";
    L31:
        if ((r35 & DefaultConfig.MAX_CACHE_ENTRIES) == 0) goto L33;
        String r13 = "";
    L35:
        if ((r35 & 512) == 0) goto L37;
        b r14 = null;
    L39:
        if ((r35 & 1024) == 0) goto L41;
        f r15 = null;
    L43:
        if ((r35 & 2048) == 0) goto L45;
        String r16 = null;
    L47:
        if ((r35 & 8192) == 0) goto L49;
        String r17 = "";
    L51:
        if ((r35 & 16384) == 0) goto L53;
        String r18 = "";
    L54:
        this(r20, r22, r5, r6, r8, r9, r10, r12, r13, r14, r15, r16, null, r17, r18);
        return;
    L53:
        r18 = r34;
        goto L54
    L49:
        r17 = null;
        goto L51
    L45:
        r16 = r33;
        goto L47
    L41:
        r15 = r32;
        goto L43
    L37:
        r14 = r30;
        goto L39
    L33:
        r13 = r29;
        goto L35
    L29:
        r12 = r28;
        goto L31
    L25:
        r10 = r27;
        goto L27
    L21:
        r9 = r26;
        goto L23
    L13:
        if (r6 <= 0) goto L15;
        boolean r1 = true;
    L16:
        r8 = r1;
        goto L19
    L15:
        r1 = false;
        goto L16
    L9:
        r6 = r24;
        goto L11
    L5:
        r5 = r23;
        goto L7
    }

    public d(boolean r8, String r9, String r10, long r12, boolean r13, int r14, int r15, String r16, String r17, b r18, f r19, String r20, Map<String, String> r22, String r23, String r24) {
        Intrinsics.checkNotNullParameter(r9, "chargeReason");
        Intrinsics.checkNotNullParameter(r10, "requestPage");
        Intrinsics.checkNotNullParameter(r16, "chargeScene");
        Intrinsics.checkNotNullParameter(r17, "showType");
        Intrinsics.checkNotNullParameter(r24, "couponIdV2");
        this.a = r8;
        this.b = r9;
        this.c = r10;
        this.d = r12;
        this.e = r13;
        this.f = r14;
        this.g = r15;
        this.h = r16;
        this.i = r17;
        this.j = r18;
        this.k = r19;
        this.l = r20;
        this.m = r22;
        this.n = r23;
        this.o = r24;
    }
}
