package com.larus.setting.impl;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.common.utility.UIUtils;
import com.larus.app.settings.api.IAppSettingsHostService;
import com.larus.applog.api.IApplog;
import com.larus.avlink.api.IDoraAVLinkService;
import com.larus.common.apphost.AppHost;
import com.larus.im.FlowRuntime;
import com.larus.network.HttpConst;
import com.larus.setting.api.CustomAboutApp;
import com.larus.setting.impl.track.SettingTrace;
import com.larus.settings.value.e10;
import com.larus.settings.value.xo;
import com.larus.update.IBitsUpdate;
import com.larus.update.IGpUpdate;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.tencent.open.log.TraceLevel;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\n\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010H\u0016¨\u0006\u0011"}, d2 = {"Lcom/larus/setting/impl/DoubaoAppSettingsHostService;", "Lcom/larus/app/settings/api/IAppSettingsHostService;", "<init>", "()V", "isManualUpdateSupported", "", "checkForUpdate", "", "context", "Landroid/content/Context;", "getAboutAppHostConfig", "Lcom/larus/app/settings/api/AboutAppHostConfig;", "getCustomAboutAppFragment", "Landroidx/fragment/app/Fragment;", "onAboutAppItemClicked", "semanticId", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class DoubaoAppSettingsHostService implements IAppSettingsHostService {
    public DoubaoAppSettingsHostService() {
    }

    public final Fragment a() {
        int r0 = a.a;
        return CustomAboutApp.a.a();
    }

    public final boolean c() {
        z1a.a.a.getClass();
        e10 r0 = e10.a;
        int r1 = com.larus.utils.l0.a;
        if (((Boolean) com.larus.utils.l0.a(Boolean.FALSE, new xo())).booleanValue() == true) goto L6;
        FLogger.a.i(z1a.a.b, "manualUpdateEnable, return false by custom pre install");
    L13:
        return false;
    L6:
        if (AppHost.a.isOversea() == false) goto L10;
        IGpUpdate r2 = (IGpUpdate) ServiceManager.get().getService(IGpUpdate.class);
        if (r2 == null) goto L13;
        return r2.b();
    L10:
        IBitsUpdate r3 = (IBitsUpdate) ServiceManager.get().getService(IBitsUpdate.class);
        if (r3 == null) goto L13;
        return r3.b();
    }

    public final t48.a b() {
        FlowRuntime.a().isOversea();
        HttpConst.a.getClass();
        Map r0 = MapsKt.mapOf(new Pair[]{TuplesKt.to("about.item.user_agreement", HttpConst.L), TuplesKt.to("about.item.privacy_policy_summary", HttpConst.O), TuplesKt.to("about.item.privacy_policy", HttpConst.M), TuplesKt.to("about.item.app_permissions", com.larus.setting.api.u.d), TuplesKt.to("about.item.usage_guidelines", com.larus.setting.api.u.b), TuplesKt.to("about.item.ip_complaint_guide", com.larus.setting.api.u.c), TuplesKt.to("about.item.trust_center", HttpConst.T), TuplesKt.to("about.item.bug_report", com.larus.setting.api.u.a), TuplesKt.to("about.item.business_license", kb9.a.b), TuplesKt.to("about.item.icp_record", kb9.a.c), TuplesKt.to("about.item.doubao_model", com.larus.setting.api.u.f), TuplesKt.to("about.item.network_culture_license", kb9.a.d), TuplesKt.to("about.item.value_added_telecom_license", kb9.a.e), TuplesKt.to("about.item.ecommerce_qualification", HttpConst.h0), TuplesKt.to("about.item.local_life_qualification", HttpConst.j0), TuplesKt.to("about.item.local_life_user_agreement", HttpConst.k0), TuplesKt.to("about.item.local_life_privacy_policy", HttpConst.l0), TuplesKt.to("about.item.local_life_rule_center", HttpConst.m0), TuplesKt.to("about.item.shopping_payment_faq", HttpConst.i0)});
        Set r1 = SetsKt.createSetBuilder();
        e10 r5 = e10.a;
        Boolean r6 = e10.r().b();
        Boolean r7 = Boolean.TRUE;
        if (Intrinsics.areEqual(r6, r7) == true) goto L6;
        r1.add("about.item.network_culture_license");
    L6:
        if (Intrinsics.areEqual(e10.r().a(), r7) == true) goto L8;
        r1.add("about.item.value_added_telecom_license");
    L8:
        Unit r3 = Unit.INSTANCE;
        return new t48.a(false, r0, SetsKt.build(r1));
    }

    public final void d(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        if (NetworkUtils.isNetworkAvailable(r3) == true) goto L6;
        UIUtils.displayToast(r3, r3.getString(2131908080));
        return;
    L6:
        z1a.a.a.getClass();
        if (z1a.a.b(1) == false) goto L11;
        IDoraAVLinkService r0 = (IDoraAVLinkService) ServiceManager.get().getService(IDoraAVLinkService.class);
        if (r0 == null) goto L13;
        r0.J0(1);
        return;
    L13:
        return;
    L11:
        z1a.a.a(false);
    }

    public final void e(String r3) {
        Intrinsics.checkNotNullParameter(r3, "semanticId");
        SettingTrace r0 = new SettingTrace();
        switch(r3.hashCode()) {
            case -1845212432: goto L30;
            case -600386080: goto L26;
            case 833751587: goto L22;
            case 1426045610: goto L18;
            case 1866040714: goto L14;
            case 2039132347: goto L10;
            case 2088593174: goto L6;
            default: goto L40;
        };
    L40:
        return;
    L6:
        if (r3.equals("about.item.ecommerce_qualification") == false) goto L41;
        r0.a();
        return;
    L41:
        return;
    L10:
        if (r3.equals("about.item.usage_guidelines") == false) goto L42;
        r0.e();
        return;
    L42:
        return;
    L14:
        if (r3.equals("about.item.privacy_policy_summary") == false) goto L43;
        IApplog.a.b("click_setting_privacy_abs", com.larus.utils.f.c(new Pair[0]));
        return;
    L43:
        return;
    L18:
        if (r3.equals("about.item.ip_complaint_guide") == false) goto L44;
        r0.c();
        return;
    L44:
        return;
    L22:
        if (r3.equals("about.item.privacy_policy") == false) goto L45;
        r0.d();
        return;
    L45:
        return;
    L26:
        if (r3.equals("about.item.shopping_payment_faq") == false) goto L46;
        r0.g();
        return;
    L46:
        return;
    L30:
        if (r3.equals("about.item.user_agreement") == false) goto L47;
        r0.f();
        return;
    }
}
