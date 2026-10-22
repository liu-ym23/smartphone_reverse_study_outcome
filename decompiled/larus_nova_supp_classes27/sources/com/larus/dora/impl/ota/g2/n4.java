package com.larus.dora.impl.ota.g2;

import com.larus.dora.api.model.FlowDoraConnectReason;
import com.larus.dora.impl.ota.tracker.DoraOTACheckReason;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class n4 {
    public static final n4 INSTANCE = null;
    private static final Set<CheckPurpose> PREDOWNLOAD_PURPOSES = null;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1 = null;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2 = null;
        public static final /* synthetic */ int[] $EnumSwitchMapping$3 = null;

        static {
            int[] r0 = new int[CheckPurpose.values().length];
            r0[CheckPurpose.INSTALL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L28
        L64:
            r0[CheckPurpose.MANUAL_CHECK.ordinal()] = 2;     // Catch: NoSuchFieldError -> L29
        L78:
            r0[CheckPurpose.MANUAL_HANDOFF.ordinal()] = 3;     // Catch: NoSuchFieldError -> L30
        L8:
            $EnumSwitchMapping$0 = r0;
            int[] r1 = new int[BlockReason.values().length];
            r1[BlockReason.USER_INTENT_OFF.ordinal()] = 1;     // Catch: NoSuchFieldError -> L31
        L68:
            r1[BlockReason.FEATURE_DISABLED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L32
        L80:
            r1[BlockReason.OUTSIDE_WINDOW.ordinal()] = 3;     // Catch: NoSuchFieldError -> L33
        L46:
            r1[BlockReason.DEVICE_DISCONNECTED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L34
        L52:
            r1[BlockReason.GLASSES_WEARING.ordinal()] = 5;     // Catch: NoSuchFieldError -> L35
        L60:
            r1[BlockReason.GLASSES_NOT_CHARGING.ordinal()] = 6;     // Catch: NoSuchFieldError -> L36
        L72:
            r1[BlockReason.GLASSES_BATTERY_LOW.ordinal()] = 7;     // Catch: NoSuchFieldError -> L37
        L56:
            r1[BlockReason.PHONE_BATTERY_LOW.ordinal()] = 8;     // Catch: NoSuchFieldError -> L38
        L66:
            r1[BlockReason.WIFI_UNAVAILABLE.ordinal()] = 9;     // Catch: NoSuchFieldError -> L39
        L70:
            r1[BlockReason.PACKAGE_MISSING.ordinal()] = 10;     // Catch: NoSuchFieldError -> L40
        L48:
            r1[BlockReason.PACKAGE_INVALID.ordinal()] = 11;     // Catch: NoSuchFieldError -> L41
        L20:
            $EnumSwitchMapping$1 = r1;
            int[] r2 = new int[Trigger.values().length];
            r2[Trigger.DEVICE_RECONNECTED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L42
        L50:
            r2[Trigger.APP_FOREGROUND.ordinal()] = 2;     // Catch: NoSuchFieldError -> L43
        L23:
            $EnumSwitchMapping$2 = r2;
            int[] r3 = new int[FailureReason.values().length];
            r3[FailureReason.NONE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L44
        L76:
            r3[FailureReason.PERIPHERAL_LOW_BATTERY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L45
        L26:
            $EnumSwitchMapping$3 = r3;
        }
    }

    public n4() {
    }

    static {
        INSTANCE = new n4();
        PREDOWNLOAD_PURPOSES = SetsKt.setOf(new CheckPurpose[]{CheckPurpose.PREDOWNLOAD, CheckPurpose.RESUME});
    }

    public static String e(Trigger r2) {
        int r0 = a.$EnumSwitchMapping$2[r2.ordinal()];
        if (r0 != 1) goto L5;
        return "device_reconnect";
    L5:
        if (r0 != 2) goto L10;
        return "app_foreground";
    L10:
        return r2.name().toLowerCase(Locale.ROOT);
    }

    public static String f(BlockReason r2) {
        switch(a.$EnumSwitchMapping$1[r2.ordinal()]) {
            case 1: goto L14;
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L12;
            case 5: goto L11;
            case 6: goto L10;
            case 7: goto L9;
            case 8: goto L8;
            case 9: goto L7;
            case 10: goto L6;
            case 11: goto L5;
            default: goto L16;
        };
    L5:
        return "package_stale";
    L6:
        return "package_missing";
    L7:
        return "wifi_required";
    L8:
        return "phone_battery_low";
    L9:
        return "glasses_battery_low";
    L10:
        return "glasses_not_charging";
    L11:
        return "glasses_worn";
    L12:
        return "device_not_connected";
    L13:
        return "window_not_open";
    L14:
        return "switch_off";
    L16:
        return r2.name().toLowerCase(Locale.ROOT);
    }

    public static String g(FailureReason r2) {
        int r0 = a.$EnumSwitchMapping$3[r2.ordinal()];
        if (r0 != 1) goto L5;
        return "";
    L5:
        if (r0 != 2) goto L10;
        return DoraOTACheckReason.LOW_BATTERY;
    L10:
        return r2.name().toLowerCase(Locale.ROOT);
    }

    public static List a(b5 r30, s r31, b5 r32) {
        Intrinsics.checkNotNullParameter(r30, "old");
        Intrinsics.checkNotNullParameter(r31, "event");
        Intrinsics.checkNotNullParameter(r32, "new");
        List r3 = CollectionsKt.createListBuilder();
        String r13 = "fail_reason";
        String r6 = "end";
        String r8 = "result";
        String r17 = null;
        if ((r31 instanceof s.f0) == false) goto L6;
        n4 r4 = INSTANCE;
        e r1 = ((s.f0) r31).b();
        r4.getClass();
        List r2 = CollectionsKt.listOf(d(r32, r1, "user"));
    L29:
        List r21 = r3;
        String r23 = "ota_update_check";
        String r9 = "end";
        String r24 = "ota_update_upload";
        r8 = "result";
        String r25 = "fail_reason";
        String r110 = "failure";
        Object r7 = "start";
    L379:
        List r0 = r21;
        r0.addAll(r2);
        Iterator r5 = r32.c().entrySet().iterator();
    L381:
        if (r5.hasNext() == false) goto L407;
        Map.Entry r10 = (Map.Entry) r5.next();
        e r11 = (e) r10.getKey();
        f r12 = (f) r10.getValue();
        f r14 = (f) r30.c().get(r11);
        if (r14 == null) goto L385;
        v4 r15 = r14.f();
    L386:
        if (r15 == null) goto L388;
        InstallPhase r16 = r15.j();
    L390:
        if (r16 != InstallPhase.TRANSFERRING) goto L405;
        InstallPhase r18 = InstallPhase.CANCELLING;
        if (SetsKt.setOf(new InstallPhase[]{r18, InstallPhase.TERMINAL_PENDING_ACK}).contains(r12.f().j()) == false) goto L405;
        if (r12.f().j() != r18) goto L396;
        boolean r20 = true;
    L397:
        n4 r22 = INSTANCE;
        OtaMode r111 = r15.i();
        if (r111 != null) goto L400;
        r111 = r15.e();
    L400:
        Pair[] r112 = new Pair[5];
        r112[0] = TuplesKt.to("step", r9);
        String r113 = r110;
        String r114 = r8;
        r112[1] = TuplesKt.to(r114, r113);
        FailureReason r26 = r12.f().d();
        r22.getClass();
        String r27 = r25;
        r112[2] = TuplesKt.to(r27, g(r26));
        if (r20 == false) goto L403;
        String r28 = "app";
    L404:
        r112[3] = TuplesKt.to("interrupt_actor", r28);
        r112[4] = TuplesKt.to("interrupt_phase", "transfer");
        String r33 = r24;
        r0.add(b(r33, r32, r11, r111, r112));
    L406:
        r24 = r33;
        r25 = r27;
        r110 = r113;
        r8 = r114;
        goto L381
    L403:
        r28 = "device";
        goto L404
    L396:
        r20 = false;
    L405:
        r113 = r110;
        r33 = r24;
        r27 = r25;
        r114 = r8;
        goto L406
    L388:
        r16 = null;
        goto L390
    L385:
        r15 = null;
        goto L386
    L407:
        t4 r34 = r32.h();
        if (r34 == null) goto L420;
        if (r34.d() == InstallOwnerKind.G1_MANUAL) goto L420;
        t4 r35 = r30.h();
        if (r35 == null) goto L415;
        r17 = r35.e();
    L415:
        if (Intrinsics.areEqual(r17, r34.e()) == true) goto L420;
        n4 r36 = INSTANCE;
        e r37 = r34.c();
        Pair[] r38 = {TuplesKt.to("step", r7)};
        r36.getClass();
        r0.add(c("ota_update_begin", r32, r37, r38));
        if (r32.b(r34.c()).f().j() != InstallPhase.DECLARING_TYPE) goto L420;
        r0.add(c(r23, r32, r34.c(), new Pair[]{TuplesKt.to("step", r7)}));
    L420:
        List r40 = CollectionsKt.build(r0);
        ArrayList r41 = new ArrayList();
        Iterator r42 = r40.iterator();
    L422:
        if (r42.hasNext() == false) goto L436;
        Object r43 = r42.next();
        q r44 = (q) r43;
        if ((r44 instanceof q.k) == false) goto L433;
        e r45 = ((q.k) r44).b().a();
        if (r45 != null) goto L428;
    L430:
        boolean r46 = false;
    L431:
        if (r46 == false) goto L433;
        boolean r47 = true;
    L434:
        if (r47 == true) goto L422;
        r41.add(r43);
        goto L422
    L428:
        if (j0.b(r45) == true) goto L430;
        r46 = true;
    L433:
        r47 = false;
        goto L434
    L436:
        return r41;
    L6:
        if ((r31 instanceof s.a) == false) goto L15;
        s.a r48 = (s.a) r31;
        Boolean r50 = r30.b(r48.b()).o().c();
        Boolean r115 = r32.b(r48.b()).o().c();
        if (r50 == null) goto L13;
        if (r115 == null) goto L13;
        if (Intrinsics.areEqual(r50, r115) == true) goto L13;
        n4 r51 = INSTANCE;
        e r52 = r48.b();
        r51.getClass();
        r2 = CollectionsKt.listOf(d(r32, r52, "ability"));
    L13:
        r2 = CollectionsKt.emptyList();
        goto L29
    L15:
        if ((r31 instanceof s.g0) == false) goto L18;
        n4 r53 = INSTANCE;
        s.g0 r54 = (s.g0) r31;
        e r116 = r54.a();
        Trigger r55 = r54.c();
        r53.getClass();
        r2 = CollectionsKt.listOf(d(r32, r116, e(r55)));
        goto L29
    L18:
        if ((r31 instanceof s.o) == false) goto L30;
        Set r56 = r32.c().keySet();
        ArrayList r57 = new ArrayList();
        Iterator r58 = r56.iterator();
    L21:
        if (r58.hasNext() == false) goto L28;
        e r117 = (e) r58.next();
        if (Intrinsics.areEqual(r30.b(r117).o(), r32.b(r117).o()) == false) goto L25;
        q.k r60 = null;
    L26:
        if (r60 == null) goto L21;
        r57.add(r60);
        goto L21
    L25:
        INSTANCE.getClass();
        r60 = d(r32, r117, "settings");
        goto L26
    L28:
        r2 = r57;
        goto L29
    L30:
        String r118 = "blocked";
        r110 = "failure";
        if ((r31 instanceof s.l) == false) goto L42;
        s.l r61 = (s.l) r31;
        BlockReason r62 = r30.b(r61.b()).c().b();
        r21 = r3;
        l r63 = r32.b(r61.b()).c();
        String r210 = "ota_update_upload";
        OtaMode r64 = r63.g();
        r23 = "ota_update_check";
        OtaMode r65 = OtaMode.SILENT_G2;
        if (r64 == r65) goto L35;
    L40:
        r2 = CollectionsKt.emptyList();
    L41:
        Object r211 = "start";
    L89:
        r9 = "end";
        r7 = r211;
    L90:
        r25 = r13;
    L91:
        r24 = r210;
        goto L379
    L35:
        if (r62 == r63.b()) goto L40;
        if (r63.b() == BlockReason.NONE) goto L40;
        n4 r66 = INSTANCE;
        e r67 = r61.b();
        Trigger r68 = Trigger.CONDITION_CHANGED;
        r66.getClass();
        r2 = CollectionsKt.listOf(b("ota_predownload_precheck", r32, r67, r65, new Pair[]{TuplesKt.to("trigger", e(r68)), TuplesKt.to("result", "blocked"), TuplesKt.to("reason", r63.b().name().toLowerCase(Locale.ROOT))}));
        goto L41
    L42:
        r21 = r3;
        r23 = "ota_update_check";
        r210 = "ota_update_upload";
        r13 = "fail_reason";
        if ((r31 instanceof s$n) == false) goto L55;
        s$n r70 = (s$n) r31;
        BlockReason r71 = r30.b(r70.a()).c().b();
        BlockReason r72 = r32.b(r70.a()).c().b();
        if (Intrinsics.areEqual(r30, r32) == true) goto L54;
        if (r71 == r72) goto L48;
    L50:
        n4 r73 = INSTANCE;
        e r74 = r70.a();
        OtaMode r119 = r70.b();
        r211 = "start";
        Pair[] r75 = new Pair[3];
        Trigger r76 = r70.e();
        r73.getClass();
        r75[0] = TuplesKt.to("trigger", e(r76));
        if (r72 != BlockReason.NONE) goto L53;
        r118 = "pass";
    L53:
        r75[1] = TuplesKt.to("result", r118);
        r75[2] = TuplesKt.to("reason", r72.name().toLowerCase(Locale.ROOT));
        r2 = CollectionsKt.listOf(b("ota_predownload_precheck", r32, r74, r119, r75));
        goto L89
    L48:
        if (r72 == BlockReason.NONE) goto L50;
    L54:
        r211 = "start";
        r2 = CollectionsKt.emptyList();
        goto L89
    L55:
        r211 = "start";
        String r77 = "1";
        if ((r31 instanceof s$m) == false) goto L76;
        s$m r78 = (s$m) r31;
        BlockReason r80 = r30.b(r78.c()).f().b();
        BlockReason r81 = r32.b(r78.c()).f().b();
        if (Intrinsics.areEqual(r30, r32) == true) goto L74;
        if (r80 != r81) goto L64;
        if (r81 != BlockReason.NONE) goto L74;
    L64:
        if (r32.b(r78.c()).f().j() != InstallPhase.ENABLING_WIFI) goto L66;
        boolean r82 = true;
    L67:
        Pair[] r120 = new Pair[2];
        if (r81 != BlockReason.NONE) goto L70;
        r118 = "pass";
    L70:
        r120[0] = TuplesKt.to("result", r118);
        r120[1] = TuplesKt.to("reason", r81.name().toLowerCase(Locale.ROOT));
        List r83 = CollectionsKt.mutableListOf(r120);
        if (r82 == false) goto L73;
        r83.add(TuplesKt.to("wifi_auto_enable", "1"));
    L73:
        n4 r84 = INSTANCE;
        e r85 = r78.c();
        OtaMode r86 = r78.d();
        Pair[] r87 = (Pair[]) r83.toArray(new Pair[0]);
        Pair[] r88 = (Pair[]) Arrays.copyOf(r87, r87.length);
        r84.getClass();
        r2 = CollectionsKt.listOf(b("ota_install_precheck", r32, r85, r86, r88));
        goto L89
    L66:
        r82 = false;
    L74:
        r2 = CollectionsKt.emptyList();
        goto L89
    L76:
        if ((r31 instanceof s$o0) == false) goto L92;
        s$o0 r90 = (s$o0) r31;
        if (r30.b(r90.a()).f().j() == InstallPhase.ENABLING_WIFI) goto L80;
    L82:
        boolean r91 = false;
    L83:
        if (r91 == true) goto L85;
    L88:
        r2 = CollectionsKt.emptyList();
        goto L89
    L85:
        if (r90.e() == true) goto L88;
        n4 r92 = INSTANCE;
        e r93 = r90.a();
        OtaMode r94 = OtaMode.SILENT_G2;
        Pair[] r95 = {TuplesKt.to("result", "blocked"), TuplesKt.to("reason", "WIFI_ENABLE_FAILED".toLowerCase(Locale.ROOT))};
        r92.getClass();
        r2 = CollectionsKt.listOf(b("ota_install_precheck", r32, r93, r94, r95));
        goto L89
    L80:
        if (r30.b(r90.a()).f().g() != r90.c()) goto L82;
        r91 = true;
        goto L83
    L92:
        boolean r96 = r31 instanceof s$y;
        if (r96 == false) goto L95;
    L367:
        r9 = "end";
        r8 = "result";
        r7 = r211;
        r25 = r13;
        r24 = r210;
        INSTANCE.getClass();
        if (r96 == false) goto L371;
        e r97 = ((s$y) r31).b();
    L374:
        if (r97 == null) goto L376;
        r2 = CollectionsKt.listOf(b("ota_update_prepare", r32, r97, OtaMode.MANUAL, new Pair[]{TuplesKt.to("step", r7)}));
    L377:
        if (r2 != null) goto L379;
        r2 = CollectionsKt.emptyList();
        goto L379
    L376:
        r2 = null;
        goto L377
    L371:
        if ((r31 instanceof s$z) == false) goto L373;
        r97 = ((s$z) r31).b();
        goto L374
    L373:
        r97 = null;
        goto L374
    L95:
        if ((r31 instanceof s$z) == true) goto L367;
        if ((r31 instanceof s$r) == false) goto L174;
        s$r r98 = (s$r) r31;
        f r100 = r30.b(r98.a());
        if (r100.i().a() == true) goto L102;
    L172:
        r2 = CollectionsKt.emptyList();
    L173:
        r7 = r211;
    L186:
        r8 = "result";
        r25 = r13;
        r9 = r6;
        goto L91
    L102:
        if (r100.i().c() != r98.c()) goto L172;
        CheckPurpose r101 = r100.i().d();
        if (r101 != null) goto L107;
        int r102 = -1;
    L109:
        if (r102 != 1) goto L111;
        OtaMode r103 = r100.f().e();
    L117:
        g5 r104 = r32.b(r98.a()).c().l();
        if (r104 == null) goto L155;
        e5 r105 = r104.f();
        if (r105 == null) goto L155;
        if (CollectionsKt.contains(PREDOWNLOAD_PURPOSES, r100.i().d()) == true) goto L124;
    L151:
        boolean r106 = false;
    L153:
        if (Boolean.valueOf(r106).booleanValue() == false) goto L155;
    L156:
        q.k[] r107 = new q.k[2];
        n4 r121 = INSTANCE;
        e r122 = r98.a();
        Pair[] r123 = new Pair[2];
        r123[0] = TuplesKt.to("step", "end");
        x4 r108 = r98.d();
        if (Intrinsics.areEqual(r108, x4.c.INSTANCE) == false) goto L160;
        String r109 = "latest";
    L165:
        r123[1] = TuplesKt.to("result", r109);
        r121.getClass();
        r107[0] = b("ota_update_pre_check", r32, r122, r103, r123);
        if (r105 == null) goto L168;
        q.k r124 = b("ota_predownload_precheck", r32, r98.a(), OtaMode.SILENT_G2, new Pair[]{TuplesKt.to("trigger", e(Trigger.VERSION_CHANGED)), TuplesKt.to("result", "pass"), TuplesKt.to("reason", "NONE".toLowerCase(Locale.ROOT)), TuplesKt.to("package_id", String.valueOf(r105.h().c()))});
    L169:
        r107[1] = r124;
        r2 = CollectionsKt.listOfNotNull(r107);
        goto L173
    L168:
        r124 = null;
        goto L169
    L160:
        if ((r108 instanceof x4.a) == false) goto L163;
        r109 = "available";
        goto L165
    L163:
        if ((r108 instanceof x4.b) == false) goto L171;
        r109 = r110;
        goto L165
    L171:
        throw new NoWhenBranchMatchedException();
    L124:
        if (r100.c().g() != OtaMode.SILENT_G2) goto L151;
        t4 r125 = r30.h();
        if (r125 == null) goto L128;
        e r126 = r125.c();
    L130:
        if (Intrinsics.areEqual(r126, r98.a()) == true) goto L151;
        g5 r127 = r100.c().l();
        if (r127 == null) goto L136;
        e5 r128 = r127.f();
        if (r128 == null) goto L136;
        d5 r129 = r128.h();
    L138:
        if (Intrinsics.areEqual(r129, r105.h()) == true) goto L151;
        d5 r130 = r105.h();
        x4 r131 = r98.d();
        if ((r131 instanceof x4.a) == false) goto L142;
        x4.a r132 = (x4.a) r131;
    L143:
        if (r132 == null) goto L147;
        e5 r133 = r132.a();
        if (r133 == null) goto L147;
        d5 r134 = r133.h();
    L149:
        if (Intrinsics.areEqual(r130, r134) == false) goto L151;
        r106 = true;
    L147:
        r134 = null;
        goto L149
    L142:
        r132 = null;
    L136:
        r129 = null;
        goto L138
    L128:
        r126 = null;
    L155:
        r105 = null;
        goto L156
    L111:
        if (r102 != 2) goto L113;
    L115:
        r103 = OtaMode.MANUAL;
        goto L117
    L113:
        if (r102 == 3) goto L115;
        r103 = r100.c().g();
        goto L117
    L107:
        r102 = a.$EnumSwitchMapping$0[r101.ordinal()];
        goto L109
    L174:
        r6 = "end";
        if ((r31 instanceof s$h) == false) goto L187;
        s$h r135 = (s$h) r31;
        l r136 = r30.b(r135.b()).c();
        l r137 = r32.b(r135.b()).c();
        if (r136.j() == DownloadPhase.PREPARING) goto L179;
    L185:
        r7 = r211;
        r2 = CollectionsKt.emptyList();
        goto L186
    L179:
        if (r136.i() != r135.d()) goto L185;
        if (r137.j() != DownloadPhase.RUNNING) goto L185;
        if (r137.i() != r135.d()) goto L185;
        n4 r138 = INSTANCE;
        e r139 = r135.b();
        r7 = r211;
        Pair[] r140 = {TuplesKt.to("step", r7)};
        r138.getClass();
        r2 = CollectionsKt.listOf(c("ota_update_download", r32, r139, r140));
        goto L186
    L187:
        r7 = r211;
        if ((r31 instanceof s$k) == false) goto L200;
        s$k r141 = (s$k) r31;
        if (r30.b(r141.a()).c().i() == r141.c()) goto L192;
    L198:
        r9 = r6;
        r2 = CollectionsKt.emptyList();
        goto L90
    L192:
        if (SetsKt.setOf(new DownloadPhase[]{DownloadPhase.RUNNING, DownloadPhase.PAUSING, DownloadPhase.PAUSED}).contains(r30.b(r141.a()).c().j()) == false) goto L198;
        if (r32.b(r141.a()).c().j() != DownloadPhase.IDLE) goto L198;
        if (r32.b(r141.a()).l().f() != PackagePhase.READY) goto L198;
        n4 r142 = INSTANCE;
        e r143 = r141.a();
        r9 = r6;
        Pair[] r144 = {TuplesKt.to("step", r9)};
        r142.getClass();
        r2 = CollectionsKt.listOf(c("ota_update_download", r32, r143, r144));
        goto L90
    L200:
        r9 = r6;
        if ((r31 instanceof s$f) == false) goto L209;
        s$f r145 = (s$f) r31;
        if (r30.b(r145.b()).c().i() == r145.d()) goto L205;
    L207:
        String r146 = r13;
        r2 = CollectionsKt.emptyList();
    L208:
        String r147 = r210;
        String r148 = r23;
    L295:
        r8 = "result";
        r24 = r147;
        r25 = r146;
        r23 = r148;
        goto L379
    L205:
        if (r32.b(r145.b()).c().j() != DownloadPhase.FAILED) goto L207;
        n4 r149 = INSTANCE;
        e r150 = r145.b();
        Pair[] r151 = {TuplesKt.to("step", r9), TuplesKt.to(r13, r145.e().name().toLowerCase(Locale.ROOT))};
        r149.getClass();
        r2 = CollectionsKt.listOf(c("ota_update_download", r32, r150, r151));
        r8 = "result";
        r25 = r13;
        goto L91
    L209:
        r146 = r13;
        if ((r31 instanceof s$a0) == false) goto L218;
        s$a0 r152 = (s$a0) r31;
        OtaMode r153 = r30.b(r152.b()).f().i();
        OtaMode r154 = OtaMode.MANUAL;
        if (r153 != r154) goto L214;
    L216:
        r2 = CollectionsKt.emptyList();
        goto L208
    L214:
        if (r32.b(r152.b()).f().i() != r154) goto L216;
        n4 r155 = INSTANCE;
        e r156 = r152.b();
        r155.getClass();
        r2 = CollectionsKt.listOf(h(r32, r156, r154));
        goto L208
    L218:
        if ((r31 instanceof s.c) == false) goto L229;
        s.c r157 = (s.c) r31;
        if (r157.getType() == DeadlineType.TYPE_DECLARE) goto L222;
    L228:
        r2 = CollectionsKt.emptyList();
        goto L208
    L222:
        if (r157.a() == null) goto L228;
        OtaMode r158 = r32.b(r157.a()).f().i();
        OtaMode r159 = OtaMode.MANUAL;
        if (r158 != r159) goto L228;
        if (r32.b(r157.a()).f().m() <= r30.b(r157.a()).f().m()) goto L228;
        n4 r160 = INSTANCE;
        e r161 = r157.a();
        r160.getClass();
        r2 = CollectionsKt.listOf(h(r32, r161, r159));
        goto L208
    L229:
        boolean r162 = r31 instanceof s$q;
        String r163 = FlowDoraConnectReason.SUCCESS;
        if (r162 == true) goto L232;
        r148 = r23;
        if ((r31 instanceof s$c0) == false) goto L261;
        s$c0 r164 = (s$c0) r31;
        if (r164.e() == true) goto L245;
    L260:
        r147 = r210;
        r2 = CollectionsKt.emptyList();
        goto L295
    L245:
        if (Intrinsics.areEqual(r30.b(r164.a()).f().h(), r164.d()) == false) goto L260;
        if (r30.b(r164.a()).f().g() != r164.c()) goto L260;
        if (r30.b(r164.a()).f().j() != InstallPhase.CONNECTING) goto L260;
        if (Intrinsics.areEqual(r32.b(r164.a()).f().h(), r164.d()) == false) goto L260;
        if (r32.b(r164.a()).f().g() != r164.c()) goto L260;
        if (r32.b(r164.a()).f().j() != InstallPhase.TRANSFERRING) goto L260;
        n4 r165 = INSTANCE;
        e r166 = r164.a();
        OtaMode r167 = r30.b(r164.a()).f().i();
        if (r167 != null) goto L259;
        r167 = r30.b(r164.a()).f().e();
    L259:
        Pair[] r168 = {TuplesKt.to("step", r7)};
        r165.getClass();
        r147 = r210;
        r2 = CollectionsKt.listOf(b(r147, r32, r166, r167, r168));
        goto L295
    L261:
        r147 = r210;
        if ((r31 instanceof s.k0) == false) goto L280;
        s.k0 r169 = (s.k0) r31;
        if (r169.f() == true) goto L266;
    L278:
        r2 = CollectionsKt.emptyList();
        goto L295
    L266:
        if (Intrinsics.areEqual(r30.b(r169.a()).f().h(), r169.d()) == false) goto L278;
        if (r30.b(r169.a()).f().g() != r169.c()) goto L278;
        if (r30.b(r169.a()).f().j() != InstallPhase.TRANSFERRING) goto L278;
        if (Intrinsics.areEqual(r32.b(r169.a()).f().h(), r169.d()) == false) goto L278;
        if (r32.b(r169.a()).f().g() != r169.c()) goto L278;
        if (r32.b(r169.a()).f().j() != InstallPhase.DEVICE_OWNED) goto L278;
        n4 r170 = INSTANCE;
        e r171 = r169.a();
        Pair[] r172 = {TuplesKt.to("step", r9), TuplesKt.to("result", FlowDoraConnectReason.SUCCESS)};
        r170.getClass();
        r2 = CollectionsKt.listOf(c(r147, r32, r171, r172));
        goto L295
    L280:
        if ((r31 instanceof s$d) == false) goto L297;
        s$d r173 = (s$d) r31;
        INSTANCE.getClass();
        if (r30.b(r173.a()).f().l() != r32.b(r173.a()).f().l()) goto L284;
        r2 = CollectionsKt.emptyList();
        goto L295
    L284:
        int r174 = r173.e();
        if (r174 != 4) goto L287;
        List r175 = CollectionsKt.listOf(c("ota_update_upgrade", r32, r173.a(), new Pair[]{TuplesKt.to("step", r7)}));
    L294:
        r2 = r175;
        goto L295
    L287:
        if (r174 != 5) goto L289;
        r175 = CollectionsKt.listOf(new q.k[]{c("ota_update_upgrade", r32, r173.a(), new Pair[]{TuplesKt.to("step", r9)}), c("ota_update_device_reboot", r32, r173.a(), new Pair[]{TuplesKt.to("step", r7)})});
        goto L294
    L289:
        if (r174 == 9) goto L291;
        r2 = CollectionsKt.emptyList();
        goto L295
    L291:
        r2 = CollectionsKt.listOf(c("ota_update_device_reboot", r32, r173.a(), new Pair[]{TuplesKt.to("step", r9)}));
        goto L295
    L297:
        if ((r31 instanceof s.p0) == true) goto L299;
        r8 = "result";
        r24 = r147;
        r25 = r146;
        r23 = r148;
        r2 = CollectionsKt.emptyList();
        goto L379
    L299:
        if (r30.p().i() == true) goto L301;
    L365:
        r8 = "result";
        r24 = r147;
        r25 = r146;
        r23 = r148;
        r2 = CollectionsKt.emptyList();
        goto L379
    L301:
        if (r32.p().i() == true) goto L365;
        Collection r176 = r30.c().values();
        ArrayList r177 = new ArrayList();
        Iterator r178 = r176.iterator();
    L304:
        if (r178.hasNext() == false) goto L315;
        Object r179 = r178.next();
        f r180 = (f) r179;
        if (r180.b().a() == true) goto L308;
    L312:
        boolean r181 = false;
    L313:
        if (r181 == false) goto L304;
        r177.add(r179);
        goto L304
    L308:
        if (r180.b().c() == true) goto L312;
        if (Intrinsics.areEqual(r180.o().c(), Boolean.TRUE) == false) goto L312;
        r181 = true;
        goto L313
    L315:
        ArrayList r182 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r177, 10));
        Iterator r183 = r177.iterator();
    L317:
        if (r183.hasNext() == false) goto L364;
        f r184 = (f) r183.next();
        e r185 = r184.g();
        Iterator r310 = r183;
        int r186 = ((Number) r30.p().b().getOrDefault(r185, 0)).intValue();
        String r212 = r77;
        String r213 = r148;
        if (r30.p().j().contains(r185) == false) goto L321;
        String r187 = "succeeded";
    L328:
        int r188 = r187.hashCode();
        String r214 = r146;
        String r215 = "window_expired";
        if (r188 == (-1309235419)) goto L348;
        String r189 = "";
        if (r188 == 634841008) goto L339;
        if (r188 == 945734241) goto L336;
    L349:
        BlockReason r190 = (BlockReason) r30.p().f().get(r185);
        if (r190 == null) goto L355;
        INSTANCE.getClass();
        String r191 = f(r190);
        if (r191 == null) goto L355;
        r189 = r191;
    L356:
        n4 r192 = INSTANCE;
        OtaMode r193 = OtaMode.SILENT_G2;
        Pair[] r194 = new Pair[8];
        String r216 = r8;
        r194[0] = TuplesKt.to("stage", "window_close");
        r194[1] = TuplesKt.to("action", r9);
        r194[2] = TuplesKt.to("window_id", r30.p().e());
        r194[3] = TuplesKt.to("window_outcome", r187);
        r194[4] = TuplesKt.to("window_outcome_reason", r189);
        r194[5] = TuplesKt.to("window_attempt_count", String.valueOf(r186));
        String r195 = "0";
        if (r30.p().d().contains(r185) == false) goto L359;
        String r196 = r212;
    L360:
        r194[6] = TuplesKt.to("window_had_available_update", r196);
        if (r184.o().e() == false) goto L363;
        r195 = r212;
    L363:
        r194[7] = TuplesKt.to("window_intent_on", r195);
        r192.getClass();
        r182.add(b("ota_install_precheck", r32, r185, r193, r194));
        r183 = r310;
        r77 = r212;
        r148 = r213;
        r147 = r147;
        r146 = r214;
        r8 = r216;
        goto L317
    L359:
        r196 = "0";
    L355:
        r189 = r215;
        goto L356
    L336:
        if (r187.equals("succeeded") == false) goto L349;
    L339:
        if (r187.equals("attempted_failed") == false) goto L349;
        FailureReason r197 = (FailureReason) r30.p().g().get(r185);
        if (r197 == null) goto L344;
        INSTANCE.getClass();
        r215 = g(r197);
    L345:
        if (r215 != null) goto L355;
    L344:
        r215 = null;
        goto L345
    L348:
        if (r187.equals("expired") == true) goto L355;
    L321:
        if (r186 <= 0) goto L325;
        r187 = "attempted_failed";
        goto L328
    L325:
        if (r30.p().f().get(r185) != null) goto L327;
        r187 = "expired";
        goto L328
    L327:
        r187 = "intercepted";
        goto L328
    L364:
        r8 = r8;
        r24 = r147;
        r25 = r146;
        r23 = r148;
        r2 = r182;
        goto L379
    L232:
        if (Intrinsics.areEqual(r30, r32) == true) goto L238;
        n4 r198 = INSTANCE;
        s$q r199 = (s$q) r31;
        e r200 = r199.a();
        OtaMode r201 = r199.b();
        boolean r202 = r199.e();
        r198.getClass();
        Intrinsics.checkNotNullParameter(r32, "state");
        Intrinsics.checkNotNullParameter(r200, "key");
        Intrinsics.checkNotNullParameter(r201, "mode");
        Pair[] r1100 = new Pair[2];
        r1100[0] = TuplesKt.to("step", r9);
        if (r202 == true) goto L237;
        r163 = r110;
    L237:
        r1100[1] = TuplesKt.to("result", r163);
        r148 = r23;
        r2 = CollectionsKt.listOf(b(r148, r32, r200, r201, r1100));
    L239:
        r147 = r210;
        goto L295
    L238:
        r148 = r23;
        r2 = CollectionsKt.emptyList();
        goto L239
    }

    public static q.k d(b5 r10, e r11, String r12) {
        o5 r0 = r10.b(r11).o();
        if (r0.f() == UserChoice.OFF) goto L5;
        boolean r1 = true;
    L6:
        String r5 = "on";
        if (r0.g() == true) goto L9;
        String r2 = "unavailable";
    L13:
        if (r0.c() != null) goto L16;
        String r7 = "ability_unresolved";
    L24:
        Pair[] r8 = new Pair[13];
        r8[0] = TuplesKt.to("trigger", r12);
        r8[1] = TuplesKt.to("sync_trigger", r12);
        if (r1 == false) goto L27;
        Object r13 = "on";
    L28:
        r8[2] = TuplesKt.to("status", r13);
        String r3 = "1";
        if (Intrinsics.areEqual(r0.c(), Boolean.TRUE) == false) goto L31;
        Object r14 = "1";
    L32:
        r8[3] = TuplesKt.to("ability_supported", r14);
        r8[4] = TuplesKt.to("user_choice", r0.f().name().toLowerCase(Locale.ROOT));
        if (r0.d() == false) goto L35;
        Object r15 = "1";
    L36:
        r8[5] = TuplesKt.to("feature_enabled", r15);
        if (r0.g() == false) goto L39;
        Object r16 = "1";
    L40:
        r8[6] = TuplesKt.to("switch_visible", r16);
        if (r0.g() == true) goto L44;
        r3 = "0";
    L44:
        r8[7] = TuplesKt.to("switch_operable", r3);
        if (r1 == true) goto L48;
        r5 = "off";
    L48:
        r8[8] = TuplesKt.to("intent_state", r5);
        if (r0.f() != UserChoice.UNSET) goto L51;
        String r17 = "default";
    L52:
        r8[9] = TuplesKt.to("intent_source", r17);
        r8[10] = TuplesKt.to("persist_result", FlowDoraConnectReason.SUCCESS);
        r8[11] = TuplesKt.to("ui_state", r2);
        r8[12] = TuplesKt.to("not_enabled_reason", r7);
        return c("silent_ota_switch", r10, r11, r8);
    L51:
        r17 = "user";
        goto L52
    L39:
        r16 = "0";
        goto L40
    L35:
        r15 = "0";
        goto L36
    L31:
        r14 = "0";
        goto L32
    L27:
        r13 = "off";
        goto L28
    L16:
        if (Intrinsics.areEqual(r0.c(), Boolean.FALSE) == false) goto L19;
        r7 = "ability_unsupported";
        goto L24
    L19:
        if (r0.d() == true) goto L21;
        r7 = "feature_disabled";
        goto L24
    L21:
        if (r1 == true) goto L23;
        r7 = "user_choice_off";
        goto L24
    L23:
        r7 = "";
        goto L24
    L9:
        if (r1 == false) goto L11;
        r2 = "on";
        goto L13
    L11:
        r2 = "off";
        goto L13
    L5:
        r1 = false;
        goto L6
    }

    public static q.k h(b5 r3, e r4, OtaMode r5) {
        Intrinsics.checkNotNullParameter(r3, "state");
        Intrinsics.checkNotNullParameter(r4, "key");
        Intrinsics.checkNotNullParameter(r5, "mode");
        return b("ota_update_check", r3, r4, r5, new Pair[]{TuplesKt.to("step", "start")});
    }

    public static q.k c(String r1, b5 r2, e r3, Pair... r4) {
        return b(r1, r2, r3, null, (Pair[]) Arrays.copyOf(r4, r4.length));
    }

    public static q.k b(String r5, b5 r6, e r7, OtaMode r8, Pair... r9) {
        f r10 = r6.b(r7);
        if (r8 == null) goto L5;
    L33:
        Pair[] r2 = new Pair[5];
        if (r8 != OtaMode.MANUAL) goto L36;
        String r11 = "manual";
    L37:
        r2[0] = TuplesKt.to("update_method", r11);
        r2[1] = TuplesKt.to("trace_id", r10.q().c());
        r2[2] = TuplesKt.to("window_id", r10.q().d());
        r2[3] = TuplesKt.to("attempt_id", r10.q().b());
        e5 r12 = r10.l().h();
        if (r12 == null) goto L43;
        d5 r13 = r12.h();
        if (r13 == null) goto L43;
        String r14 = Long.valueOf(r13.c()).toString();
        if (r14 == null) goto L43;
    L44:
        r2[4] = TuplesKt.to("package_id", r14);
        return new q.k(new p5(r5, r7, MapsKt.plus(MapsKt.mapOf(r2), r9)), false);
    L43:
        r14 = "";
        goto L44
    L36:
        r11 = "silent_g2";
        goto L37
    L5:
        switch(r5.hashCode()) {
            case -1429758180: goto L18;
            case -1352540133: goto L15;
            case -478791711: goto L11;
            case 1115961108: goto L8;
            default: goto L22;
        };
    L8:
        if (r5.equals("ota_update_prepare") == false) goto L22;
    L20:
        r8 = r10.c().g();
        goto L33
    L11:
        if (r5.equals("silent_ota_switch") == false) goto L22;
        r8 = OtaMode.SILENT_G2;
        goto L33
    L15:
        if (r5.equals("ota_update_download") == true) goto L20;
    L18:
        if (r5.equals("ota_predownload_precheck") == true) goto L20;
    L22:
        if (r10.f().j() == InstallPhase.IDLE) goto L24;
    L30:
        r8 = r10.f().i();
        if (r8 != null) goto L33;
        r8 = r10.f().e();
        goto L33
    L24:
        if (r10.f().h().length() <= 0) goto L26;
        boolean r15 = true;
    L27:
        if (r15 == true) goto L30;
        r8 = r10.c().g();
        goto L33
    L26:
        r15 = false;
        goto L27
    }
}
