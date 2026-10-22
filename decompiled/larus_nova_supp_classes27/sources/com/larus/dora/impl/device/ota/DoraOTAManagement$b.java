package com.larus.dora.impl.device.ota;

import com.bes.sdk.device.HmDevice;
import com.bes.sdk.utils.OTAStatus;
import com.bytedance.dora.device.DoraDevice;
import com.larus.dora.impl.log.engine.OTALogReason;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class DoraOTAManagement$b implements a2.b {
    public final /* synthetic */ z39.a a;
    public final /* synthetic */ DoraDevice b;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[OTAStatus.values().length];
            r0[OTAStatus.STATUS_UNKNOWN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
        L27:
            r0[OTAStatus.STATUS_STARTED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
        L43:
            r0[OTAStatus.STATUS_CANCELED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L17
        L31:
            r0[OTAStatus.STATUS_FAILED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L18
        L35:
            r0[OTAStatus.STATUS_PAUSED.ordinal()] = 5;     // Catch: NoSuchFieldError -> L19
        L25:
            r0[OTAStatus.STATUS_REBOOT.ordinal()] = 6;     // Catch: NoSuchFieldError -> L20
        L37:
            r0[OTAStatus.STATUS_SUCCEED.ordinal()] = 7;     // Catch: NoSuchFieldError -> L21
        L39:
            r0[OTAStatus.STATUS_VERIFIED.ordinal()] = 8;     // Catch: NoSuchFieldError -> L22
        L29:
            r0[OTAStatus.STATUS_VERIFYING.ordinal()] = 9;     // Catch: NoSuchFieldError -> L23
        L33:
            r0[OTAStatus.STATUS_UPDATING.ordinal()] = 10;     // Catch: NoSuchFieldError -> L24
        L13:
            a = r0;
        }
    }

    public final void a(int r6) {
        if (r6 != 100) goto L8;
        String r0 = DoraOTABuryPointManager.l;
        DoraOTABuryPointManager.f(null, null);
        if (DoraOTABuryPointManager.d != 0) goto L8;
        DoraOTABuryPointManager.d = System.currentTimeMillis();
        DoraOTABuryPointManager.k("ota_update_verify", MapsKt.mapOf(TuplesKt.to("step", "start")));
    L8:
        int r7 = (int) ((((double) r6) * 0.79d) + ((double) 1));
        DoraOTAManagement.e(DoraOTAManagement.c, this.a, r7);
    }

    public DoraOTAManagement$b(z39.a r1, DoraDevice r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void b(OTAStatus r9, HmDevice r10) {
        g49.d.d("DoraOTAManagement", "ota<" + DoraOTAManagement.c + ">: data transfer onOTAStatusChanged newStatus = " + r9 + ", " + r10);
        if (r9 != null) goto L5;
        int r11 = -1;
    L6:
        switch(r11) {
            case -1: goto L12;
            case 0: goto L8;
            case 1: goto L12;
            case 2: goto L12;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L12;
            case 6: goto L12;
            case 7: goto L12;
            case 8: goto L12;
            case 9: goto L12;
            case 10: goto L12;
            default: goto L8;
        };
    L9:
        DoraOTAReporter.c("ota status failed");
        return;
    L10:
        String r4 = OTALogReason.TASK_CANCELED.getMessage();
        String r12 = DoraOTABuryPointManager.l;
        DoraOTABuryPointManager.f("ota status cancel", r4);
        DoraOTAManagement.A(DoraOTAManagement.a, DoraOTAManagement.c, this.a, "ota status cancel", r4, this.b, false, 96);
        DoraOTAReporter.c("ota status cancel");
        return;
    L12:
        return;
    L8:
        throw new NoWhenBranchMatchedException();
    L5:
        r11 = a.a[r9.ordinal()];
        goto L6
    }
}
