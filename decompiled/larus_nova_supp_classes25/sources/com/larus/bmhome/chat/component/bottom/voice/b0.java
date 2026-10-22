package com.larus.bmhome.chat.component.bottom.voice;

import com.larus.bmhome.view.ChatConstraintLayout;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class b0 implements Function2 {
    public final /* synthetic */ b a;
    public final /* synthetic */ c0 b;

    public /* synthetic */ b0(b r1, c0 r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke(Object r12, Object r13) {
        b r0 = this.a;
        c0 r1 = this.b;
        int r14 = ((Integer) r12).intValue();
        Intrinsics.checkNotNullParameter((String) r13, "<unused var>");
        va8.o r15 = r0.w0();
        boolean r2 = true;
        boolean r3 = false;
        if (r15 != null) goto L5;
    L7:
        boolean r16 = false;
    L8:
        if (r16 == true) goto L55;
        int r17 = RangesKt.coerceAtLeast(r1.e, r14);
        r1.e = r17;
        if (r1.c == false) goto L14;
        r1.f.invoke(Integer.valueOf(r17 - r1.a()));
    L53:
        r3 = r1.b;
        goto L55
    L14:
        if (r1.d == false) goto L25;
        va8.o r18 = r0.w0();
        if (r18 == null) goto L18;
        boolean r19 = r18.w();
    L19:
        if (r19 == true) goto L21;
    L24:
        r1.d = r2;
        r1.f.invoke(Integer.valueOf(r1.e - r1.a()));
        goto L53
    L21:
        if (r14 != r1.e) goto L24;
        r2 = false;
        goto L24
    L18:
        r19 = false;
        goto L19
    L25:
        int r110 = r14 - r1.a();
        r1.f.invoke(Integer.valueOf(r110));
        if (r1.b == false) goto L38;
        if (r110 != 0) goto L38;
        va8.o r111 = r0.w0();
        if (r111 != null) goto L31;
    L33:
        boolean r112 = false;
    L34:
        if (r112 == false) goto L38;
        ChatConstraintLayout r113 = r1.a;
        if (r113 == null) goto L38;
        int r4 = r1.a();
        int r5 = r113.getPaddingStart();
        int r6 = r113.getPaddingTop();
        int r7 = r113.getPaddingEnd();
        FLogger.a.i("updatePaddingRelative", "view:" + r113.getClass().getSimpleName() + ",source:VoiceMixInputHeightManager,start:" + r5 + ",top:" + r6 + ",end:" + r7 + ",bottom:" + r4);
        r113.setPaddingRelative(r5, r6, r7, r4);
        goto L38
    L31:
        if (r111.w() == true) goto L33;
        r112 = true;
    L38:
        if (r110 != 0) goto L49;
        va8.o r114 = r0.w0();
        if (r114 != null) goto L42;
    L44:
        r2 = false;
    L45:
        if (r2 == false) goto L49;
        va8.o r115 = r0.w0();
        if (r115 == null) goto L53;
        r115.ra();
        goto L53
    L42:
        if (r114.w() == true) goto L44;
    L49:
        if (r110 <= 0) goto L53;
        va8.o r116 = r0.w0();
        if (r116 == null) goto L53;
        r116.E40();
    L55:
        return Boolean.valueOf(r3);
    L5:
        if (r15.ZL() != true) goto L7;
        r16 = true;
        goto L8
    }
}
