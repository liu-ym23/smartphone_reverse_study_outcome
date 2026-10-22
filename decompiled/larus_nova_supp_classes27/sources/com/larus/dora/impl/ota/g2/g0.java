package com.larus.dora.impl.ota.g2;

import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class g0 {
    private static final Set<DownloadPhase> ACTIVE_HOME_CARD_DOWNLOAD_PHASES = null;
    private static final Set<InstallPhase> ACTIVE_HOME_CARD_INSTALL_PHASES = null;

    static {
        ACTIVE_HOME_CARD_DOWNLOAD_PHASES = SetsKt.setOf(new DownloadPhase[]{DownloadPhase.QUEUED, DownloadPhase.PREPARING, DownloadPhase.RUNNING, DownloadPhase.PAUSING});
        ACTIVE_HOME_CARD_INSTALL_PHASES = SetsKt.setOf(new InstallPhase[]{InstallPhase.CHECKING, InstallPhase.QUEUED, InstallPhase.ENABLING_WIFI, InstallPhase.DECLARING_TYPE, InstallPhase.CONNECTING, InstallPhase.TRANSFERRING, InstallPhase.CANCELLING, InstallPhase.DEVICE_OWNED, InstallPhase.AWAITING_RECONNECT});
    }

    public static final h0 a(b5 r12, e r13) {
        Intrinsics.checkNotNullParameter(r12, "state");
        Intrinsics.checkNotNullParameter(r13, "key");
        if (j0.b(r13) == true) goto L5;
    L123:
        return null;
    L5:
        if (o59.a.m(Integer.valueOf(r13.a())) == false) goto L123;
        f r0 = (f) r12.c().get(r13);
        if (r0 == null) goto L123;
        boolean r3 = false;
        if (r0.b().a() == true) goto L12;
    L14:
        boolean r2 = false;
    L15:
        if (r2 == true) goto L18;
        r0 = null;
    L18:
        if (r0 == null) goto L123;
        h5 r4 = r12.l();
        if (r4 != null) goto L22;
    L27:
        TerminalResult r5 = null;
    L28:
        TerminalResult r6 = TerminalResult.SUCCESS;
        if (r5 != r6) goto L31;
        return null;
    L31:
        boolean r7 = ACTIVE_HOME_CARD_DOWNLOAD_PHASES.contains(r0.c().j());
        if (ACTIVE_HOME_CARD_INSTALL_PHASES.contains(r0.f().j()) == true) goto L34;
    L37:
        boolean r8 = false;
    L39:
        if (r5 != TerminalResult.FAILURE) goto L41;
    L57:
        G2OtaHomeCardAction r9 = G2OtaHomeCardAction.UPDATE;
    L58:
        if (r8 == false) goto L81;
        t4 r14 = r12.h();
        if (r14 != null) goto L62;
    L71:
        e5 r15 = r0.h();
        if (r15 == null) goto L76;
        d5 r16 = r15.h();
        if (r16 == null) goto L76;
        String r17 = r16.f();
    L110:
        if (r17 == null) goto L123;
        String r18 = StringsKt.trim(r17).toString();
        if (r18.length() != 0) goto L114;
        r3 = true;
    L114:
        if (r3 == false) goto L117;
        r18 = null;
    L120:
        if (r18 == null) goto L123;
        return new h0(r18, r9);
    L117:
        if (StringsKt.startsWith(r18, "v", true) == true) goto L120;
        r18 = "v".concat(r18);
    L76:
        e5 r110 = r0.l().h();
        if (r110 == null) goto L109;
        d5 r111 = r110.h();
        if (r111 == null) goto L109;
        r17 = r111.f();
    L109:
        r17 = null;
        goto L110
    L62:
        if (Intrinsics.areEqual(r14.c(), r13) == true) goto L65;
        r14 = null;
    L65:
        if (r14 == null) goto L71;
        d5 r112 = r14.g();
        if (r112 == null) goto L71;
        r17 = r112.f();
        if (r17 == null) goto L71;
    L81:
        if (r7 == false) goto L96;
        d5 r113 = r0.c().k();
        if (r113 == null) goto L86;
        r17 = r113.f();
        if (r17 != null) goto L110;
    L86:
        e5 r114 = r0.h();
        if (r114 == null) goto L91;
        d5 r115 = r114.h();
        if (r115 == null) goto L91;
        r17 = r115.f();
    L91:
        e5 r116 = r0.l().h();
        if (r116 == null) goto L109;
        d5 r117 = r116.h();
        if (r117 == null) goto L109;
        r17 = r117.f();
        goto L110
    L96:
        g5 r118 = r0.c().l();
        if (r118 == null) goto L104;
        e5 r119 = r118.f();
        if (r119 == null) goto L104;
        d5 r120 = r119.h();
        if (r120 == null) goto L104;
        r17 = r120.f();
        if (r17 != null) goto L110;
    L104:
        e5 r121 = r0.h();
        if (r121 == null) goto L109;
        d5 r122 = r121.h();
        if (r122 == null) goto L109;
        r17 = r122.f();
        goto L110
    L41:
        if (r5 == TerminalResult.UNKNOWN) goto L57;
        if (r8 == false) goto L45;
        r9 = G2OtaHomeCardAction.INSTALLING;
        goto L58
    L45:
        if (r7 == false) goto L48;
        r9 = G2OtaHomeCardAction.DOWNLOADING;
        goto L58
    L48:
        if (r0.m().g() <= 0) goto L50;
        return null;
    L50:
        s5 r10 = r0.r();
        if (r10 == null) goto L53;
        TerminalResult r11 = r10.b();
    L54:
        if (r11 != r6) goto L56;
        return null;
    L56:
        r9 = G2OtaHomeCardAction.UPDATE;
        goto L58
    L53:
        r11 = null;
        goto L54
    L34:
        if (j0.a().contains(r0.f().j()) == false) goto L36;
        if (r7 == true) goto L37;
    L36:
        r8 = true;
        goto L39
    L22:
        if (Intrinsics.areEqual(r4.b(), r13) == true) goto L25;
        r4 = null;
    L25:
        if (r4 == null) goto L27;
        r5 = r4.f();
        goto L28
    L12:
        if (r0.d().b() == false) goto L14;
        r2 = true;
        goto L15
    }
}
