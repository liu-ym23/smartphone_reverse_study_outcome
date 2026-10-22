package com.larus.dora.impl.ota.g2;

import java.security.MessageDigest;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class j0 {
    private static final int G2_OTA_ADVERTISEMENT_DEVICE_ID_LENGTH = 8;
    public static final long G2_OTA_DISCONNECT_WATCHDOG_MS = 30000;
    public static final int G2_OTA_GLASSES_BATTERY_MIN = 30;
    public static final long G2_OTA_INSTALL_COOLDOWN_MS = 1800000;
    public static final long G2_OTA_MANUAL_REARM_DELAY_MS = 7200000;
    public static final long G2_OTA_NO_UPDATE_TTL_MS = 1800000;
    public static final long G2_OTA_PARTIAL_TTL_MS = 604800000;
    public static final int G2_OTA_PHONE_BATTERY_MIN = 20;
    public static final String G2_OTA_PROVISIONAL_SN = "11223344";
    public static final long G2_OTA_RECONNECT_TIMEOUT_MS = 1800000;
    public static final long G2_OTA_RECOVERY_BLOCK_FOREVER = Long.MAX_VALUE;
    public static final long G2_OTA_SPACE_CHECK_BYTES = 104857600;
    public static final long G2_OTA_SPACE_RESERVE_BYTES = 2147483648L;
    public static final long G2_OTA_TRANSFER_WATCHDOG_MS = 1800000;
    public static final long G2_OTA_TYPE_DECLARE_RETRY_MS = 5000;
    private static final Set<InstallPhase> PRE_OWNER_INSTALL_PHASES = null;

    static {
        PRE_OWNER_INSTALL_PHASES = SetsKt.setOf(new InstallPhase[]{InstallPhase.CHECKING, InstallPhase.QUEUED, InstallPhase.ENABLING_WIFI});
    }

    public static final Set<InstallPhase> a() {
        return PRE_OWNER_INSTALL_PHASES;
    }

    public static final boolean b(e r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return c(r1.b());
    }

    public static final boolean c(String r5) {
        if (r5 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L11;
        return false;
    L11:
        if (Intrinsics.areEqual(r5, G2_OTA_PROVISIONAL_SN) == false) goto L13;
        return false;
    L13:
        if (r5.length() != 8) goto L47;
        int r3 = 0;
    L16:
        if (r3 >= r5.length()) goto L44;
        char r4 = r5.charAt(r3);
        if ('0' <= r4) goto L20;
    L22:
        boolean r6 = false;
    L23:
        if (r6 == false) goto L25;
    L40:
        boolean r7 = true;
    L41:
        if (r7 == false) goto L42;
        r3 = r3 + 1;
        goto L16
    L42:
        boolean r8 = false;
    L45:
        if (r8 == false) goto L47;
        boolean r9 = true;
    L48:
        if (r9 == true) goto L55;
        return true;
    L55:
        return false;
    L25:
        if ('A' <= r4) goto L27;
    L29:
        boolean r10 = false;
    L30:
        if (r10 == true) goto L40;
        if ('a' <= r4) goto L34;
    L36:
        boolean r11 = false;
    L37:
        if (r11 == true) goto L40;
        r7 = false;
        goto L41
    L34:
        if (r4 >= 'g') goto L36;
        r11 = true;
        goto L37
    L27:
        if (r4 >= 'G') goto L29;
        r10 = true;
        goto L30
    L20:
        if (r4 >= ':') goto L22;
        r6 = true;
        goto L23
    L44:
        r8 = true;
    L47:
        r9 = false;
        goto L48
    L5:
        if (StringsKt.isBlank(r5) == true) goto L8;
        r2 = false;
        goto L9
    }

    public static final String d(e r9) {
        Intrinsics.checkNotNullParameter(r9, "<this>");
        byte[] r10 = MessageDigest.getInstance("SHA-256").digest(("dora_g2_ota_device_v1:" + r9.a() + ':' + r9.b()).getBytes(Charsets.UTF_8));
        Intrinsics.checkNotNull(r10);
        return CollectionsKt.joinToString$default(ArraysKt.take(r10, 16), "", null, null, 0, null, new i0(), 30, null);
    }

    public static final String e(q r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if ((r1 instanceof q.f) == false) goto L6;
        return "Dispatch";
    L6:
        if ((r1 instanceof q.b) == false) goto L9;
        return "CheckLatest";
    L9:
        if ((r1 instanceof q.i) == false) goto L12;
        return "PrepareDownload";
    L12:
        if ((r1 instanceof q.l) == false) goto L15;
        return "StartDownload";
    L15:
        if ((r1 instanceof q.h) == false) goto L18;
        return "PauseDownload";
    L18:
        if ((r1 instanceof q.a) == false) goto L21;
        return "CheckDownloadSpace";
    L21:
        if ((r1 instanceof q.d) == false) goto L24;
        return "DeclareType";
    L24:
        if ((r1 instanceof q.g) == false) goto L27;
        return "EnableWifi";
    L27:
        if ((r1 instanceof q.j) == false) goto L30;
        return "ReleaseWifi";
    L30:
        if ((r1 instanceof q.c) == false) goto L33;
        return "ConnectP2p";
    L33:
        if ((r1 instanceof q.m) == false) goto L36;
        return "StartUpload";
    L36:
        if ((r1 instanceof q.n) == false) goto L39;
        return "StopUpload";
    L39:
        if ((r1 instanceof q.e) == false) goto L42;
        return "DeletePackage";
    L42:
        if ((r1 instanceof q.k) == false) goto L46;
        return "Report";
    L46:
        throw new NoWhenBranchMatchedException();
    }

    public static final String f(s r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if ((r1 instanceof s.b) == false) goto L6;
        return "Bound";
    L6:
        if ((r1 instanceof s.j0) == false) goto L9;
        return "Unbound";
    L9:
        if ((r1 instanceof s.f0) == false) goto L12;
        return "SwitchChanged";
    L12:
        if ((r1 instanceof s.o) == false) goto L15;
        return "FeatureChanged";
    L15:
        if ((r1 instanceof s.a) == false) goto L18;
        return "AbilityChanged";
    L18:
        if ((r1 instanceof s.g0) == false) goto L21;
        return "SwitchExposureRequested";
    L21:
        if ((r1 instanceof s.l) == false) goto L24;
        return "EnvironmentChanged";
    L24:
        if ((r1 instanceof s.e) == false) goto L27;
        return "DeviceVersionChanged";
    L27:
        if ((r1 instanceof s.p0) == false) goto L30;
        return "WindowChanged";
    L30:
        if ((r1 instanceof s$n) == false) goto L33;
        return "EvaluatePredownload";
    L33:
        if ((r1 instanceof s$y) == false) goto L36;
        return "ManualCheck";
    L36:
        if ((r1 instanceof s$z) == false) goto L39;
        return "ManualDownload";
    L39:
        if ((r1 instanceof s$t) == false) goto L42;
        return "LegacyDownloadRequested";
    L42:
        if ((r1 instanceof s$s) == false) goto L45;
        return "LegacyDownloadReleased";
    L45:
        if ((r1 instanceof s$r) == false) goto L48;
        return "LatestChecked";
    L48:
        if ((r1 instanceof s$h) == false) goto L51;
        return "DownloadPrepared";
    L51:
        if ((r1 instanceof s$i) == false) goto L54;
        return "DownloadProgress";
    L54:
        if ((r1 instanceof s$j) == false) goto L57;
        return "DownloadSpaceChecked";
    L57:
        if ((r1 instanceof s$g) == false) goto L60;
        return "DownloadPaused";
    L60:
        if ((r1 instanceof s$k) == false) goto L63;
        return "DownloadSucceeded";
    L63:
        if ((r1 instanceof s$f) == false) goto L66;
        return "DownloadFailed";
    L66:
        if ((r1 instanceof s$p) == false) goto L69;
        return "FilesCleaned";
    L69:
        if ((r1 instanceof s$a0) == false) goto L72;
        return "ManualPageEntered";
    L72:
        if ((r1 instanceof s$b0) == false) goto L75;
        return "ManualPageExited";
    L75:
        if ((r1 instanceof s$m) == false) goto L78;
        return "EvaluateInstall";
    L78:
        if ((r1 instanceof s$w) == false) goto L81;
        return "LegacyInstallRequested";
    L81:
        if ((r1 instanceof s$u) == false) goto L84;
        return "LegacyInstallCommitted";
    L84:
        if ((r1 instanceof s$v) == false) goto L87;
        return "LegacyInstallReleased";
    L87:
        if ((r1 instanceof s$x) == false) goto L90;
        return "LegacySilentChanged";
    L90:
        if ((r1 instanceof s$q) == false) goto L93;
        return "InstallTypeDeclared";
    L93:
        if ((r1 instanceof s$c0) == false) goto L96;
        return "P2pConnected";
    L96:
        if ((r1 instanceof s$o0) == false) goto L99;
        return "WifiEnableResult";
    L99:
        if ((r1 instanceof s$m0) == false) goto L102;
        return "UploadStartRequested";
    L102:
        if ((r1 instanceof s$l0) == false) goto L105;
        return "UploadProgress";
    L105:
        if ((r1 instanceof s.k0) == false) goto L108;
        return "UploadFinished";
    L108:
        if ((r1 instanceof s$d0) == false) goto L111;
        return "P2pDisconnected";
    L111:
        if ((r1 instanceof s$d) == false) goto L114;
        return "DeviceStage";
    L114:
        if ((r1 instanceof s$n0) == false) goto L117;
        return "VersionObserved";
    L117:
        if ((r1 instanceof s.c) == false) goto L120;
        return "Deadline";
    L120:
        if ((r1 instanceof s$i0) == false) goto L123;
        return "TerminalDispatched";
    L123:
        if ((r1 instanceof s$h0) == false) goto L126;
        return "TerminalDispatchFailed";
    L126:
        if ((r1 instanceof s$e0) == false) goto L130;
        return "SilentOtaCompletionAcknowledged";
    L130:
        throw new NoWhenBranchMatchedException();
    }
}
