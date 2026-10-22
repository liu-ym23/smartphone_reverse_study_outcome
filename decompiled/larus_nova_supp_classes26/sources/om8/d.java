package om8;

import android.content.Context;
import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.router.SmartRouter;
import com.bytedance.router.i;
import com.larus.bmhome.chat.standarduikit.miaodaartifact.viewmodel.MiaodaArtifactVMData;
import com.larus.home.impl.sdk.x1;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.LarkConnectorArtifactService;
import com.larus.platform.service.q;
import com.larus.platform.service.z2;
import com.larus.utils.AppLocaleUtils;
import com.larus.utils.b0;
import com.larus.utils.f;
import com.larus.utils.y0;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class d implements c {

    public static final class a {
    }

    static {
    }

    public d() {
    }

    @Override // om8.c
    public final void b(String r3) {
        Intrinsics.checkNotNullParameter(r3, "resourceId");
        if (r3.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        return;
    L9:
        if (z2.a.enableMiaodaPrewarm() == true) goto L11;
        return;
    L11:
        IFlowSdkDepend r1 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r1 == null) goto L15;
        r1.D();
        x1.a.l(r3);
        return;
    L15:
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Override // om8.c
    public final void a(Context r8, MiaodaArtifactVMData r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r9, "data");
        String r0 = r9.b;
        if (r0 != null) goto L5;
    L8:
        boolean r3 = true;
    L9:
        if (r3 == false) goto L11;
        return;
    L11:
        Uri.Builder r1 = UriProtector.parse("https://miaoda.feishu.cn/doubao/app/" + r0).buildUpon().appendQueryParameter("op_platform_service", "hide_navigator");
        if (AccountService.a.isEnterpriseAccount() == false) goto L14;
        r1.appendQueryParameter("enterprise_mode", "1");
    L14:
        String r2 = r1.build().toString();
        boolean r10 = LarkConnectorArtifactService.a.c(r9.a);
        if (r10 == false) goto L17;
    L21:
        Uri r4 = UriProtector.parse(r2);
        String r5 = b0.a;
        AppLocaleUtils.a.getClass();
        String r6 = "zh-Hant";
        if (Intrinsics.areEqual(b0.c(AppLocaleUtils.c()), "zh-Hant") == true) goto L25;
        r6 = "zh";
    L25:
        q.a.e(r8, f.c(new Pair[]{TuplesKt.to("link_url", y0.l(y0.l(r4, "locale", r6), "use_miaoda_header", "1").toString()), TuplesKt.to("hide_title_bar", "1"), TuplesKt.to("bundle_need_lark_auth_cookie_sync", Boolean.valueOf(!r10)), TuplesKt.to("bundle_clear_lark_auth_cookies_once", Boolean.valueOf(r10)), TuplesKt.to("bundle_disable_forest", Boolean.valueOf(r10))}), null);
        return;
    L17:
        if (z2.a.enableMiaodaArtifactCommonWebContainer() == true) goto L21;
        i r11 = SmartRouter.buildRoute(r8, "//flow/miaoda_artifact_preview");
        r11.c.putExtra("miaoda_artifact_preview_url", r2);
        r11.d();
        return;
    L5:
        if (r0.length() == 0) goto L8;
        r3 = false;
        goto L9
    }
}
