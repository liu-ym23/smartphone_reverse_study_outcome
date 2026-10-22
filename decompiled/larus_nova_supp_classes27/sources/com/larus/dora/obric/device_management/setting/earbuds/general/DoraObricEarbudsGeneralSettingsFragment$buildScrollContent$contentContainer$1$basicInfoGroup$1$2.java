package com.larus.dora.obric.device_management.setting.earbuds.general;

import android.app.Application;
import android.content.ClipData;
import android.os.Handler;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.dora.device.DoraDevice;
import com.larus.common.apphost.AppHost;
import com.larus.dora.impl.device.settings.general.w;
import com.larus.dora.impl.log.engine.OTALogReason;
import com.larus.home.impl.sdk.i1;
import com.larus.platform.IFlowSdkDepend;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class DoraObricEarbudsGeneralSettingsFragment$buildScrollContent$contentContainer$1$basicInfoGroup$1$2 extends FunctionReferenceImpl implements Function0<Unit> {
    public DoraObricEarbudsGeneralSettingsFragment$buildScrollContent$contentContainer$1$basicInfoGroup$1$2(Object r8) {
        super(0, r8, DoraObricEarbudsGeneralSettingsFragment.class, "copySn", "copySn()V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m289invoke() {
        DoraObricEarbudsGeneralSettingsFragment r0 = (DoraObricEarbudsGeneralSettingsFragment) ((CallableReference) this).receiver;
        int r1 = DoraObricEarbudsGeneralSettingsFragment.p;
        Object r2 = r0.ca0().getGeneralSettingsStateFlow().getValue();
        String r3 = null;
        if ((r2 instanceof w.b) == false) goto L5;
        w.b r4 = (w.b) r2;
    L6:
        if (r4 == null) goto L8;
        DoraDevice r5 = r4.b;
    L9:
        if (r5 == null) goto L11;
        r3 = r5.sn;
    L11:
        if (r3 != null) goto L14;
        r3 = "";
    L14:
        if (r3.length() <= 0) goto L16;
        boolean r6 = true;
    L17:
        if (r6 == false) goto L25;
        ClipData r7 = ClipData.newPlainText("text", r3);
        IFlowSdkDepend r8 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r8 == null) goto L21;
        r8.d0();
        i1 r9 = i1.a;
        Application r10 = AppHost.a.getApplication();
        Intrinsics.checkNotNull(r7);
        r9.i(r10, r7, "bpea-dora-settings");
    L21:
        FragmentActivity r11 = r0.getActivity();
        if (r11 == null) goto L25;
        Handler r12 = com.obric.oui.toast.f.n;
        com.obric.oui.toast.f.a.a(r11, r0.getString(2131910467));
    L25:
        if (r0.o == true) goto L28;
        ck4.a.a.a.a(OTALogReason.COPY_SN.getMessage(), false);
        r0.o = true;
        return;
    L28:
        return;
    L16:
        r6 = false;
        goto L17
    L8:
        r5 = null;
        goto L9
    L5:
        r4 = null;
        goto L6
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m289invoke();
        return Unit.INSTANCE;
    }
}
