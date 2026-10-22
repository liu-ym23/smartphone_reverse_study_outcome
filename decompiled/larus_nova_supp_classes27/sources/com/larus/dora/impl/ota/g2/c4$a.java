package com.larus.dora.impl.ota.g2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public /* synthetic */ class c4$a {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;
    public static final /* synthetic */ int[] $EnumSwitchMapping$1 = null;
    public static final /* synthetic */ int[] $EnumSwitchMapping$2 = null;
    public static final /* synthetic */ int[] $EnumSwitchMapping$3 = null;
    public static final /* synthetic */ int[] $EnumSwitchMapping$4 = null;

    static {
        int[] r0 = new int[DownloadPhase.values().length];
        r0[DownloadPhase.CHECKING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L40
    L82:
        r0[DownloadPhase.QUEUED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L41
    L92:
        r0[DownloadPhase.PREPARING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L42
    L100:
        r0[DownloadPhase.RUNNING.ordinal()] = 4;     // Catch: NoSuchFieldError -> L43
    L102:
        r0[DownloadPhase.PAUSING.ordinal()] = 5;     // Catch: NoSuchFieldError -> L44
    L12:
        $EnumSwitchMapping$0 = r0;
        int[] r1 = new int[CheckPurpose.values().length];
        r1[CheckPurpose.INSTALL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L45
    L66:
        r1[CheckPurpose.PREDOWNLOAD.ordinal()] = 2;     // Catch: NoSuchFieldError -> L46
    L74:
        r1[CheckPurpose.RESUME.ordinal()] = 3;     // Catch: NoSuchFieldError -> L47
    L80:
        r1[CheckPurpose.MANUAL_CHECK.ordinal()] = 4;     // Catch: NoSuchFieldError -> L48
    L88:
        r1[CheckPurpose.MANUAL_DOWNLOAD.ordinal()] = 5;     // Catch: NoSuchFieldError -> L49
    L94:
        r1[CheckPurpose.MANUAL_HANDOFF.ordinal()] = 6;     // Catch: NoSuchFieldError -> L50
    L20:
        $EnumSwitchMapping$1 = r1;
        int[] r2 = new int[InstallPhase.values().length];
        r2[InstallPhase.CANCELLING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L51
    L114:
        r2[InstallPhase.CONNECTING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L52
    L68:
        r2[InstallPhase.TRANSFERRING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L53
    L24:
        $EnumSwitchMapping$2 = r2;
        int[] r3 = new int[DeadlineType.values().length];
        r3[DeadlineType.DOWNLOAD_RETRY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L54
    L98:
        r3[DeadlineType.INSTALL_COOLDOWN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L55
    L104:
        r3[DeadlineType.PACKAGE_EXPIRY.ordinal()] = 3;     // Catch: NoSuchFieldError -> L56
    L108:
        r3[DeadlineType.PACKAGE_CLEANUP.ordinal()] = 4;     // Catch: NoSuchFieldError -> L57
    L116:
        r3[DeadlineType.MANUAL_REARM.ordinal()] = 5;     // Catch: NoSuchFieldError -> L58
    L70:
        r3[DeadlineType.RECONNECT.ordinal()] = 6;     // Catch: NoSuchFieldError -> L59
    L78:
        r3[DeadlineType.LEGACY_INSTALL.ordinal()] = 7;     // Catch: NoSuchFieldError -> L60
    L84:
        r3[DeadlineType.TYPE_DECLARE.ordinal()] = 8;     // Catch: NoSuchFieldError -> L61
    L86:
        r3[DeadlineType.TRANSFER.ordinal()] = 9;     // Catch: NoSuchFieldError -> L62
    L96:
        r3[DeadlineType.DISCONNECT.ordinal()] = 10;     // Catch: NoSuchFieldError -> L63
    L110:
        r3[DeadlineType.TERMINAL_RETRY.ordinal()] = 11;     // Catch: NoSuchFieldError -> L64
    L36:
        $EnumSwitchMapping$3 = r3;
        int[] r4 = new int[FailureReason.values().length];
        r4[FailureReason.PERIPHERAL_LOW_BATTERY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L65
    L38:
        $EnumSwitchMapping$4 = r4;
    }
}
