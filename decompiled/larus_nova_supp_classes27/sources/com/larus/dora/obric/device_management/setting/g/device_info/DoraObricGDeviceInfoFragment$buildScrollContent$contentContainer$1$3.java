package com.larus.dora.obric.device_management.setting.g.device_info;

import android.app.Application;
import android.content.ClipData;
import com.bytedance.dora.device.DoraDevice;
import com.larus.common.apphost.AppHost;
import com.larus.dora.impl.device.settings.general.GeneralSettingsViewModel;
import com.larus.dora.impl.device.settings.general.w;
import com.larus.dora.impl.log.engine.OTALogReason;
import com.larus.dora.obric.utils.DoraObricToastUtils;
import com.larus.home.impl.sdk.i1;
import com.larus.platform.IFlowSdkDepend;
import com.obric.oui.toast.f;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class DoraObricGDeviceInfoFragment$buildScrollContent$contentContainer$1$3 extends FunctionReferenceImpl implements Function0<Unit> {
    public DoraObricGDeviceInfoFragment$buildScrollContent$contentContainer$1$3(Object r8) {
        super(0, r8, DoraObricGDeviceInfoFragment.class, "copySn", "copySn()V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m319invoke() {
        DoraObricGDeviceInfoFragment r0 = (DoraObricGDeviceInfoFragment) ((CallableReference) this).receiver;
        int r1 = DoraObricGDeviceInfoFragment.l;
        Object r2 = ((GeneralSettingsViewModel) r0.g.getValue()).getGeneralSettingsStateFlow().getValue();
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
        if (r6 == false) goto L23;
        ClipData r7 = ClipData.newPlainText("text", r3);
        IFlowSdkDepend r8 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r8 == null) goto L21;
        r8.d0();
        i1 r9 = i1.a;
        Application r10 = AppHost.a.getApplication();
        Intrinsics.checkNotNull(r7);
        r9.i(r10, r7, "bpea-dora-settings");
    L21:
        WeakReference<f> r11 = DoraObricToastUtils.a;
        DoraObricToastUtils.d(r0.requireContext());
    L23:
        if (r0.k == true) goto L26;
        ck4.a.a.a.a(OTALogReason.COPY_SN.getMessage(), false);
        r0.k = true;
        return;
    L26:
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
        m319invoke();
        return Unit.INSTANCE;
    }
}
