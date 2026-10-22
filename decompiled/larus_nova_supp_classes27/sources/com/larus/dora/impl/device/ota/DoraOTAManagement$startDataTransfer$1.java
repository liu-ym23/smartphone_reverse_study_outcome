package com.larus.dora.impl.device.ota;

import android.text.TextUtils;
import com.bes.sdk.device.HmDevice;
import com.bes.sdk.utils.OTAStatus;
import com.bytedance.dora.device.DoraDevice;
import com.larus.dora.api.model.FlowDoraConnectReason;
import com.larus.dora.impl.log.engine.OTALogReason;
import com.larus.dora.impl.settings.DoraSetting;
import com.larus.dora.impl.trace.DarEvent;
import java.util.LinkedHashMap;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class DoraOTAManagement$startDataTransfer$1 implements x1.c {
    public final /* synthetic */ DoraDevice a;
    public final /* synthetic */ z39.a b;
    public final /* synthetic */ String c;

    public final void b(boolean r3, HmDevice r4) {
        g49.d.d("DoraOTAManagement", "ota<" + DoraOTAManagement.c + ">: onTotaConnectState sate = " + r3 + ", " + r4);
    }

    public final void c(int r12, HmDevice r13) {
        g49.d.d("DoraOTAManagement", "ota<" + DoraOTAManagement.c + ">: onSuccessMessage msg = " + r12 + ", " + r13);
        DoraOTAReporter.a.f.d = EventTypeOTAStatus.INSTALL_COMPLETED.getCode();
        DoraOTAReporter.d();
        DoraOTAManagement.p.set(false);
        DoraOTAManagement.r = null;
        DoraSetting.a.getClass();
        if (DoraSetting.j().f() == false) goto L5;
        DoraOTAManagement.m = null;
    L5:
        DoraOTAManagement.R = 0;
        String r2 = DoraOTABuryPointManager.l;
        DoraOTABuryPointManager.s = 0;
        DoraOTAManagement r0 = DoraOTAManagement.a;
        if (DoraOTAManagement.H == false) goto L8;
        int r1 = DoraOTAManagement.K;
    L9:
        DoraOTABuryPointManager.j(true, FlowDoraConnectReason.SUCCESS, "", r1);
        DoraOTAManagement.H();
        int r3 = DoraOTAManagement.c;
        z39.a r4 = this.b;
        DoraDevice r5 = this.a;
        g49.d.d("DoraOTAManagement", "ota<" + r3 + ">: budsProcessData");
        BuildersKt.launch$default(DoraOTAManagement.d, null, null, new DoraOTAManagement$budsProcessData$1(r4, r3, r5, null), 3, null);
        if (e.a() == false) goto L13;
        e.b(true);
        return;
    L13:
        return;
    L8:
        r1 = DoraOTAManagement.J;
        goto L9
    }

    public final void d(int r14, HmDevice r15) {
        String r0 = "onErrorMessage msg = " + r14;
        g49.d.b("DoraOTAManagement", "ota<" + DoraOTAManagement.c + ">: " + r0 + ", " + r15);
        DoraOTAManagement r2 = DoraOTAManagement.a;
        DoraOTAManagement$RetryStatus r16 = DoraOTAManagement.g(r0, this.a);
        String r6 = OTALogReason.ERROR_MESSAGE_MSG.getMessage() + '_' + r14;
        if (r14 == 2372) goto L5;
    L13:
        if (r14 != 2372) goto L29;
        if (r16 != DoraOTAManagement$RetryStatus.PackageRetry) goto L29;
        if (DoraOTAManagement.H == false) goto L19;
        int r17 = DoraOTAManagement.M;
    L20:
        DoraOTABuryPointManager.s = r17;
        g49.d.d("DoraOTAManagement", "onErrorMessage PackageRetry: packageTypeRetryCount = " + r17);
        DoraOTAManagement.A(r2, DoraOTAManagement.c, this.b, r0, r6, this.a, true, 32);
        DoraSetting.a.getClass();
        if (DoraSetting.j().e() == false) goto L27;
        DarEvent r18 = DarEvent.OtaRetry;
        LinkedHashMap r1 = new LinkedHashMap();
        if (DoraOTAManagement.H == false) goto L25;
        String r3 = "manual";
    L26:
        r1.put("update_method", r3);
        r1.put("status", "total");
        r18.setMessage("from beginning retry");
        r18.setExtra(r1);
        com.larus.dora.impl.trace.a.a(r18);
        goto L27
    L25:
        r3 = "automatic";
    L27:
        BuildersKt.launch$default(DoraOTAManagement.d, null, null, new DoraOTAManagement$startDataTransfer$1$onErrorMessage$1(this.a, r17, null), 3, null);
        return;
    L19:
        r17 = DoraOTAManagement.L;
    L29:
        if (r14 != 2476) goto L31;
    L40:
        DoraSetting.a.getClass();
        if (DoraSetting.j().d() == false) goto L43;
        DoraOTAManagement.b(r14, r0, this.b, this.a);
        return;
    L43:
        String r110 = DoraOTABuryPointManager.l;
        DoraOTABuryPointManager.k("ota_biz_custom_monitor", MapsKt.mapOf(new Pair[]{TuplesKt.to("biz_type", "bes_error"), TuplesKt.to("message", "ota_bes_error_message_msg_" + r14)}));
        return;
    L31:
        if (r14 == 2477) goto L40;
        if (r14 != 2449) goto L39;
        g49.d.d("DoraOTAManagement", "onErrorMessage: msg = " + r14 + "， isSettingsSingleBudOTAFeatureEnabled=" + DoraOTAManagement.x());
        if (DoraOTAManagement.x() == false) goto L38;
        BuildersKt.launch$default(DoraOTAManagement.d, null, null, new DoraOTAManagement$startDataTransfer$1$onErrorMessage$2(this.b, r0, r6, this.a, null), 3, null);
        return;
    L38:
        DoraOTAManagement.b(r14, r0, this.b, this.a);
        return;
    L39:
        DoraOTAManagement.b(r14, r0, this.b, this.a);
        return;
    L5:
        if (r16 != DoraOTAManagement$RetryStatus.TransferRetry) goto L13;
        DoraOTAManagement.A(r2, DoraOTAManagement.c, this.b, r0, r6, this.a, true, 32);
        String r111 = DoraOTAManagement.q(this.a);
        DoraDevice r4 = this.a;
        DoraOTAManagement.p().storeString(r4.mac + "_dora_ota_LastOtaFile", "");
        StringBuilder r5 = new StringBuilder("onErrorMessage TransferRetry: msg = ");
        r5.append(r0);
        g49.d.d("DoraOTAManagement", r5.toString());
        DoraSetting.a.getClass();
        if (DoraSetting.j().f() == true) goto L9;
        DoraOTAManagement.f(this.a, r111, this.b);
        return;
    L9:
        if (TextUtils.isEmpty(r111) == false) goto L11;
        DoraOTAManagement.b(r14, r0, this.b, this.a);
        return;
    L11:
        DoraOTAManagement.f(this.a, r111, this.b);
    }

    public DoraOTAManagement$startDataTransfer$1(DoraDevice r1, z39.a r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void a(int r21, String r22, HmDevice r23) {
        g49.d.d("DoraOTAManagement", "ota<" + DoraOTAManagement.c + ">: onStateChangedMessage msg = " + r21 + ", msgStr = " + r22 + ", " + r23);
        if (r21 == 444) goto L15;
        if (r21 != 666) goto L7;
        DoraOTABuryPointManager.b(null, null);
        return;
    L7:
        if (r21 != 2307) goto L9;
        g49.d.d("DoraOTAManagement", "startDataTransfer2");
        DoraOTAManagement.a.j(this.a, this.c, this.b);
        return;
    L9:
        if (r21 != 2328) goto L54;
        String r1 = DoraOTABuryPointManager.l;
        DoraOTABuryPointManager.g(null, null);
        return;
    L54:
        return;
    L15:
        if (DoraOTAManagement.P == false) goto L19;
        g49.d.d("DoraOTAManagement", "bes connect error due to app disconnect, skip");
        return;
    L19:
        if (DoraOTAManagement.G != null) goto L27;
        StringBuilder r2 = new StringBuilder("bes connect error(");
        w1.b r7 = DoraOTAManagement.b;
        if (r7 == null) goto L25;
        OTAStatus r8 = r7.n;
        if (r8 == null) goto L25;
        String r9 = r8.name();
    L26:
        r2.append(r9);
        r2.append(')');
        String r3 = r2.toString();
    L28:
        StringBuilder r6 = new StringBuilder();
        OTALogReason r10 = OTALogReason.BES_CONNECT_ERROR_OTA_STATUS;
        r6.append(r10.getMessage());
        r6.append('_');
        r6.append(r21);
        String r11 = r6.toString();
        DoraOTAManagement r12 = DoraOTAManagement.a;
        if (DoraOTAManagement.g(r3, this.a) != DoraOTAManagement$RetryStatus.TransferRetry) goto L32;
        DoraOTAManagement.A(r12, DoraOTAManagement.c, this.b, r3, r11, this.a, true, 32);
        g49.d.d("DoraOTAManagement", "BES_CONNECT_ERROR TransferRetry: msg = " + r3);
        DoraDevice r4 = this.a;
        DoraOTAManagement.f(r4, DoraOTAManagement.q(r4), this.b);
        return;
    L32:
        if (DoraOTAManagement.g(r3, this.a) == DoraOTAManagement$RetryStatus.PackageRetry) goto L34;
        String r13 = r10.getMessage() + "dora_link_disconnect_" + DoraOTAManagement.G;
        String r5 = DoraOTABuryPointManager.l;
        Intrinsics.checkNotNullParameter(r3, "errorMsg");
        Intrinsics.checkNotNullParameter(r13, "newErrorMessage");
        if (DoraOTABuryPointManager.b == 0) goto L42;
        DoraOTABuryPointManager.b(r3, r13);
    L47:
        DoraOTAManagement.A(r12, DoraOTAManagement.c, this.b, r3, r13, this.a, false, 96);
        DoraOTAReporter.c(r22);
        return;
    L42:
        if (DoraOTABuryPointManager.c == 0) goto L45;
        DoraOTABuryPointManager.f(r3, r13);
        goto L47
    L45:
        if (DoraOTABuryPointManager.d == 0) goto L47;
        DoraOTABuryPointManager.g(r3, r13);
        goto L47
    L34:
        if (DoraOTAManagement.H == false) goto L36;
        int r14 = DoraOTAManagement.M;
    L37:
        DoraOTABuryPointManager.s = r14;
        g49.d.d("DoraOTAManagement", "BES_CONNECT_ERROR PackageRetry: packageTypeRetryCount msg = " + r14);
        DoraOTAManagement.A(r12, DoraOTAManagement.c, this.b, r3, r11, this.a, true, 32);
        BuildersKt.launch$default(DoraOTAManagement.d, null, null, new DoraOTAManagement$startDataTransfer$1$onStateChangedMessage$1(this.a, this.b, r14, null), 3, null);
        return;
    L36:
        r14 = DoraOTAManagement.L;
    L25:
        r9 = null;
        goto L26
    L27:
        r3 = "bes connect error(doraLinkDisconnect_" + DoraOTAManagement.G + ')';
        goto L28
    }
}
