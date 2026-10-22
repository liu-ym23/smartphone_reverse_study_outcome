package com.bytedance.android.live.liveinteract.plantform.commonwindow;

import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.List;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class t extends h {
    public final List<Integer> l;
    public final List<Integer> m;

    public t() {
        throw null;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.h
    public final List<Integer> a() {
        return this.m;
    }

    public t(int r16, List r17, int r18, boolean r19, int r20, boolean r21, pn0.i r22, Triple r23, List r24, DataCenter r25, int r26) {
        if ((r26 & 4) == 0) goto L5;
        int r3 = 0;
    L7:
        if ((r26 & 8) == 0) goto L9;
        j r5 = new j(new StringBuilder());
    L11:
        if ((r26 & 16) == 0) goto L13;
        boolean r6 = true;
    L15:
        if ((r26 & 64) == 0) goto L17;
        boolean r7 = false;
    L19:
        if ((r26 & 128) == 0) goto L21;
        pn0.i r8 = null;
    L23:
        if ((r26 & 512) == 0) goto L25;
        List r14 = null;
    L26:
        Intrinsics.checkNotNullParameter(r5, "traceInfo");
        Intrinsics.checkNotNullParameter(r23, "mAbsContainerWHAndReason");
        super(r16, r3, r5, r6, r20, r7, r8, r23, r14, null, r25, 512);
        this.l = r17;
        this.m = r14;
        return;
    L25:
        r14 = r24;
        goto L26
    L21:
        r8 = r22;
        goto L23
    L17:
        r7 = r21;
        goto L19
    L13:
        r6 = r19;
        goto L15
    L9:
        r5 = null;
        goto L11
    L5:
        r3 = r18;
        goto L7
    }
}
