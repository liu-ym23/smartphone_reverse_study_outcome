package com.bytedance.android.live.liveinteract.videotalk.utils;

import android.graphics.Path;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class h extends c {
    public final pn0.f b;
    public final int c;
    public final int d;

    @Override // com.bytedance.android.live.liveinteract.videotalk.utils.c
    public final Path b(int r13, int r14, int r15) {
        int r0 = this.b.d.size();
        if (r13 < 0) goto L17;
        if (r13 >= r0) goto L17;
        pn0.f r1 = this.b;
        pn0.f.b r2 = r1.c;
        int r3 = r2.a;
        if (r3 > 0) goto L10;
        r3 = 0;
    L10:
        int r4 = r2.b;
        if (r4 > 0) goto L14;
        r4 = 0;
    L14:
        pn0.f.c r5 = (pn0.f.c) ListProtector.get(r1.d, r13);
        int r6 = ((r5.c + r3) + this.c) + r14;
        int r16 = ((r5.d + r4) + this.d) + r15;
        int r17 = r5.e + r6;
        int r7 = r5.f + r16;
        boolean r8 = gh0.b.a;
        gh0.b.a("LayoutConfigV2", "[MultiLinkCommonClipStrategyV2] call getPathFromPosition: " + r13 + ", rect[" + r6 + ", " + r16 + ", " + r17 + ", " + r7 + "], seatItem[" + r5.c + ", " + r5.d + ", " + r5.e + ", " + r5.f + "], originOffset[" + r3 + ", " + r4 + ']', false);
        Path r18 = new Path();
        r18.addRect((float) r6, (float) r16, (float) r17, (float) r7, Path.Direction.CW);
        return r18;
    L17:
        return new Path();
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.utils.c
    public final Path c(int r20, float r21, float r22) {
        int r2 = this.b.d.size();
        if (r20 < 0) goto L22;
        if (r20 >= r2) goto L22;
        pn0.f r3 = this.b;
        pn0.f.b r4 = r3.c;
        int r5 = r4.a;
        if (r5 > 0) goto L10;
        r5 = 0;
    L10:
        int r6 = r4.b;
        if (r6 > 0) goto L14;
        r6 = 0;
    L14:
        pn0.f.c r7 = (pn0.f.c) ListProtector.get(r3.d, r20);
        int r8 = (r7.c + r5) + this.c;
        int r9 = (r7.d + r6) + this.d;
        int r10 = r7.e + r8;
        int r11 = r7.f + r9;
        boolean r12 = gh0.b.a;
        gh0.b.a("LayoutConfigV2", "[MultiLinkCommonClipStrategyV2] call getPathFromPosition: " + r20 + ", rect[" + r8 + ", " + r9 + ", " + r10 + ", " + r11 + "], seatItem[" + r7.c + ", " + r7.d + ", " + r7.e + ", " + r7.f + "], originOffset[" + r5 + ", " + r6 + "], rx=" + r21 + ", ry=" + r22, false);
        Path r18 = new Path();
        if (r21 == 0.0f) goto L17;
    L19:
        r18.addRoundRect(r8, r9, r10, r11, r21, r22, Path.Direction.CW);
    L20:
        return r18;
    L17:
        if (r22 != 0.0f) goto L19;
        r18.addRect(r8, r9, r10, r11, Path.Direction.CW);
    L22:
        return new Path();
    }

    public h(int r3, int r4, int r5, com.bytedance.android.live.liveinteract.plantform.commonwindow.m r6) {
        Intrinsics.checkNotNullParameter(r6, "layoutConfig");
        this.c = 0;
        this.d = r3;
        pn0.f r7 = r6.d;
        if (r7 != null) goto L5;
        int r8 = x8.a.a;
        x8.a.c("ttlive_link", new Exception("MultiLinkCommonClipStrategyV2 layoutConfigV2Result is null"), false);
        Pair r9 = ug0.b.a();
        ln0.a r0 = yg0.h.a;
        this.b = yg0.h.a(r6, new Triple(Integer.valueOf(r4), Integer.valueOf(r5), "init MultiLinkCommonClipStrategyV2#backup"), r9);
        return;
    L5:
        Intrinsics.checkNotNull(r7);
        this.b = r7;
    }
}
