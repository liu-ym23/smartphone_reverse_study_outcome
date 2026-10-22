package com.larus.dora.impl.ota.g2;

import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class f0 {

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1 = null;

        static {
            int[] r0 = new int[InstallOwnerKind.values().length];
            r0[InstallOwnerKind.G1_MANUAL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L18
        L32:
            r0[InstallOwnerKind.G2_MANUAL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L19
        L42:
            r0[InstallOwnerKind.G2_SILENT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L20
        L8:
            $EnumSwitchMapping$0 = r0;
            int[] r1 = new int[DownloadPhase.values().length];
            r1[DownloadPhase.CHECKING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L21
        L34:
            r1[DownloadPhase.QUEUED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L22
        L44:
            r1[DownloadPhase.PREPARING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L23
        L28:
            r1[DownloadPhase.RUNNING.ordinal()] = 4;     // Catch: NoSuchFieldError -> L24
        L36:
            r1[DownloadPhase.PAUSING.ordinal()] = 5;     // Catch: NoSuchFieldError -> L25
        L30:
            r1[DownloadPhase.PAUSED.ordinal()] = 6;     // Catch: NoSuchFieldError -> L26
        L38:
            r1[DownloadPhase.FAILED.ordinal()] = 7;     // Catch: NoSuchFieldError -> L27
        L16:
            $EnumSwitchMapping$1 = r1;
        }
    }

    public static final i5 a(boolean r4, int r5, String r6, int r7, t4 r8) {
        boolean r1 = false;
        if (o59.a.m(Integer.valueOf(r5)) == true) goto L5;
    L7:
        boolean r0 = false;
    L8:
        if (r0 == true) goto L10;
        return null;
    L10:
        if (r4 == false) goto L48;
        if (r8 == null) goto L46;
        InstallOwnerKind r9 = r8.d();
        Integer r2 = Integer.valueOf(r8.c().a());
        if (o59.a.m(Integer.valueOf(r5)) == true) goto L16;
    L18:
        boolean r10 = false;
    L19:
        if (r10 == true) goto L21;
    L43:
        if (r1 == false) goto L46;
        return new i5.c(r8);
    L21:
        if (r9 != null) goto L23;
        int r11 = -1;
    L24:
        if (r11 == (-1)) goto L40;
        if (r11 != 1) goto L27;
        if (r7 != 0) goto L40;
    L39:
        boolean r12 = true;
    L41:
        if (r12 == false) goto L43;
        r1 = true;
        goto L43
    L27:
        if (r11 != 2) goto L29;
    L33:
        if (r2 == null) goto L40;
        if (r2.intValue() != r5) goto L40;
    L29:
        if (r11 == 3) goto L33;
        throw new NoWhenBranchMatchedException();
    L40:
        r12 = false;
        goto L41
    L23:
        r11 = a.$EnumSwitchMapping$0[r9.ordinal()];
        goto L24
    L16:
        if (j0.c(r6) == true) goto L18;
        r10 = true;
    L46:
        return i5.b.INSTANCE;
    L48:
        return i5.a.INSTANCE;
    L5:
        if (j0.c(r6) == true) goto L7;
        r0 = true;
        goto L8
    }
}
