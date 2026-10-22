package com.bytedance.android.live.liveinteract.plantform.commonwindow;

import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.List;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public class h {
    public final int a;
    public final int b;
    public final j c;
    public final boolean d;
    public final int e;
    public final boolean f;
    public final pn0.i g;
    public final Triple<Integer, Integer, String> h;
    public final List<Integer> i;
    public final Long j;
    public final DataCenter k;

    public List<Integer> a() {
        return this.i;
    }

    public h(int r2, int r3, j r4, boolean r5, int r6, boolean r7, pn0.i r8, Triple<Integer, Integer, String> r9, List<Integer> r10, Long r11, DataCenter r12) {
        Intrinsics.checkNotNullParameter(r4, "traceInfo");
        Intrinsics.checkNotNullParameter(r9, "absContainerWHAndReason");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
        this.j = r11;
        this.k = r12;
    }

    public /* synthetic */ h(int r16, int r17, j r18, boolean r19, int r20, boolean r21, pn0.i r22, Triple r23, List r24, Long r25, DataCenter r26, int r27) {
        if ((r27 & 2) == 0) goto L5;
        int r5 = 0;
    L7:
        if ((r27 & 4) == 0) goto L9;
        j r6 = new j(new StringBuilder());
    L11:
        if ((r27 & 8) == 0) goto L13;
        boolean r7 = true;
    L15:
        if ((r27 & 16) == 0) goto L17;
        int r8 = 0;
    L19:
        if ((r27 & 32) == 0) goto L21;
        boolean r9 = false;
    L23:
        if ((r27 & 64) == 0) goto L25;
        pn0.i r10 = null;
    L27:
        if ((r27 & 256) == 0) goto L29;
        List r12 = null;
    L31:
        if ((r27 & 512) == 0) goto L33;
        Long r13 = null;
    L34:
        this(r16, r5, r6, r7, r8, r9, r10, r23, r12, r13, r26);
        return;
    L33:
        r13 = r25;
        goto L34
    L29:
        r12 = r24;
        goto L31
    L25:
        r10 = r22;
        goto L27
    L21:
        r9 = r21;
        goto L23
    L17:
        r8 = r20;
        goto L19
    L13:
        r7 = r19;
        goto L15
    L9:
        r6 = r18;
        goto L11
    L5:
        r5 = r17;
        goto L7
    }
}
