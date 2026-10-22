package com.larus.dora.impl.ota.g2;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class v2 implements Function1 {
    public final /* synthetic */ BlockReason a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ u4 c;
    public final /* synthetic */ s$m d;
    public final /* synthetic */ boolean e;
    public final /* synthetic */ b5 f;

    public /* synthetic */ v2(BlockReason r1, boolean r2, u4 r3, s$m r4, boolean r5, b5 r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }

    public final Object invoke(Object r41) {
        BlockReason r14 = this.a;
        boolean r1 = this.b;
        u4 r2 = this.c;
        s$m r15 = this.d;
        boolean r3 = this.e;
        b5 r13 = this.f;
        f r11 = (f) r41;
        Intrinsics.checkNotNullParameter(r11, "it");
        BlockReason r12 = BlockReason.GLOBAL_SERIAL_BUSY;
        if (r14 == r12) goto L20;
        if (r1 == true) goto L20;
        v4 r4 = r11.f();
        if (r3 == false) goto L9;
        InstallPhase r5 = InstallPhase.IDLE;
    L10:
        OtaMode r6 = r11.f().e();
        OtaMode r7 = OtaMode.MANUAL;
        if (r6 != r7) goto L14;
        boolean r36 = r11.f().c();
    L19:
        BlockReason r30 = r14;
        s$m r31 = r15;
        v4 r8 = v4.a(r4, r5, 0, null, 0, 0, false, null, null, 0, 0, 0, r30, null, r36, 12286);
    L36:
        if (r31.d() != OtaMode.SILENT_G2) goto L54;
        BlockReason r9 = r30;
        if (r9 == BlockReason.OUTSIDE_WINDOW) goto L54;
        if (r9 == BlockReason.FAILURE_COOLDOWN) goto L54;
        if (r9 == r12) goto L54;
        if (r9 == BlockReason.NEARBY_PERMISSION_DENIED) goto L54;
        if (r9 == BlockReason.LOCATION_PERMISSION_DENIED) goto L54;
        if (r9 == BlockReason.MANUAL_ENTERED_TONIGHT) goto L54;
        if (r9 == BlockReason.MANUAL_ONLY) goto L54;
        if (r9 == BlockReason.ABILITY_UNRESOLVED) goto L54;
        j5 r10 = r11.m();
        c4 r16 = c4.INSTANCE;
        long r17 = r31.e();
        r16.getClass();
        j5 r18 = j5.a(r10, 0, null, 0, 0, 0, c4.E(r13, r17), 31);
    L55:
        v4 r27 = r8;
        return f.a(r11, null, null, null, null, null, null, null, null, null, null, r27, null, null, r18, null, null, null, 243711);
    L54:
        r18 = r11.m();
        goto L55
    L14:
        if (r15.d() == r7) goto L16;
    L18:
        r36 = false;
        goto L19
    L16:
        if (r15.b() == false) goto L18;
        r36 = true;
        goto L19
    L9:
        r5 = r11.f().j();
    L20:
        r30 = r14;
        r31 = r15;
        InstallPhase r20 = InstallPhase.QUEUED;
        if (r2 == null) goto L24;
        OtaMode r21 = r2.d();
        if (r21 == null) goto L24;
    L25:
        OtaMode r22 = r21;
        if (r2 == null) goto L29;
        boolean r23 = r2.a();
    L34:
        r8 = new v4(r20, null, 0, r22, r30, r23, 12278);
        goto L36
    L29:
        if (r31.d() == OtaMode.MANUAL) goto L31;
    L33:
        r23 = false;
        goto L34
    L31:
        if (r31.b() == false) goto L33;
        r23 = true;
    L24:
        r21 = r31.d();
        goto L25
    }
}
