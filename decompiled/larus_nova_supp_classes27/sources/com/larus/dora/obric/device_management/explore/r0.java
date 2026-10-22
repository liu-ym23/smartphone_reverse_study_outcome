package com.larus.dora.obric.device_management.explore;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class r0 {
    public final String a;
    public final DoraObricGlassesExploreDetailType b;
    public final d1 c;
    public final d1 d;
    public final x0 e;
    public final x0 f;
    public final List<d1> g;
    public final d1 h;
    public final List<d1> i;
    public final List<d1> j;
    public final b0 k;
    public final String l;
    public final List<z> m;

    public r0() {
        throw null;
    }

    public r0(String r16, DoraObricGlassesExploreDetailType r17, d1 r18, d1 r110, x0 r20, x0 r21, d1 r22, List r23, List r24, b0 r25, String r26, List r27, int r28) {
        if ((r28 & 2) == 0) goto L5;
        DoraObricGlassesExploreDetailType r7 = DoraObricGlassesExploreDetailType.INTRODUCTION;
    L6:
        b0 r9 = null;
        if ((r28 & 32) == 0) goto L9;
        x0 r8 = null;
    L11:
        if ((r28 & 128) == 0) goto L13;
        List<d1> r10 = CollectionsKt.emptyList();
    L15:
        if ((r28 & 256) == 0) goto L17;
        d1 r11 = null;
    L19:
        if ((r28 & 512) == 0) goto L21;
        List r12 = CollectionsKt.emptyList();
    L23:
        if ((r28 & 1024) == 0) goto L25;
        List r13 = CollectionsKt.emptyList();
    L27:
        if ((r28 & 2048) != 0) goto L31;
        r9 = r25;
    L31:
        if ((r28 & 8192) == 0) goto L33;
        List r6 = CollectionsKt.emptyList();
    L34:
        Intrinsics.checkNotNullParameter(r16, "key");
        Intrinsics.checkNotNullParameter(r7, "detailType");
        Intrinsics.checkNotNullParameter(r18, "title");
        Intrinsics.checkNotNullParameter(r110, "description");
        Intrinsics.checkNotNullParameter(r20, "image");
        Intrinsics.checkNotNullParameter(r10, "querySpecs");
        Intrinsics.checkNotNullParameter(r12, "detailDescriptionSpecs");
        Intrinsics.checkNotNullParameter(r13, "detailQuerySpecs");
        Intrinsics.checkNotNullParameter(r26, "cardContentType");
        Intrinsics.checkNotNullParameter(r6, "basicItemSpecs");
        this.a = r16;
        this.b = r7;
        this.c = r18;
        this.d = r110;
        this.e = r20;
        this.f = r8;
        this.g = r10;
        this.h = r11;
        this.i = r12;
        this.j = r13;
        this.k = r9;
        this.l = r26;
        this.m = r6;
        return;
    L33:
        r6 = r27;
        goto L34
    L25:
        r13 = r24;
        goto L27
    L21:
        r12 = r23;
        goto L23
    L17:
        r11 = r22;
        goto L19
    L13:
        r10 = null;
        goto L15
    L9:
        r8 = r21;
        goto L11
    L5:
        r7 = r17;
        goto L6
    }
}
