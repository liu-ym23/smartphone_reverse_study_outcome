package vv8;

import android.os.Bundle;
import com.bytedance.apm.ApmAgent;
import com.bytedance.router.SmartRouter;
import com.bytedance.router.i;
import com.larus.applog.api.IApplog;
import com.larus.business.debug.base.DebugConstants$DebugTools$DebugToolsType;
import com.larus.business.debug.base.controller.libra.d;
import com.larus.business.debug.base.register.EntranceGroup;
import com.larus.common.apphost.AppHost;
import com.larus.common.larksso.api.ILarkSSOService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a extends zv8.a {
    @Override // zv8.e
    public final String c() {
        return AppHost.a.getApplication().getString(2131901335);
    }

    @Override // zv8.a
    public final void f() {
        AppHost.Companion r0 = AppHost.a;
        if (r0.a().getCurrentActivity() == null) goto L11;
        String r1 = d.a;
        int r2 = xv8.a.a;
        String r3 = DebugConstants$DebugTools$DebugToolsType.LIBRA.getType();
        Intrinsics.checkNotNullParameter(r3, "toolTypeStr");
        Intrinsics.checkNotNullParameter("libra critical", "toolName");
        JSONObject r4 = new JSONObject();
        r4.put("flow_tools_type", r3);
        r4.put("flow_tools_name", "libra critical");
        r4.put("flow_tools_did", IApplog.a.getDeviceId());
        ILarkSSOService r5 = (ILarkSSOService) ServiceManager.get().getService(ILarkSSOService.class);
        if (r5 == null) goto L8;
        String r6 = Boolean.valueOf(r5.b()).toString();
        if (r6 == null) goto L8;
    L9:
        r4.put("flow_tools_lark_sso_authed", r6);
        ApmAgent.monitorEvent("flow_dev_tools_event", r4, new JSONObject(), new JSONObject());
        i r7 = SmartRouter.buildRoute(r0.getApplication(), "//flow/webview");
        Bundle r8 = new Bundle();
        r8.putString("link_url", d.a + "&hide_nav_bar=1");
        r7.c.putExtras(r8);
        r7.d();
        return;
    L8:
        r6 = "false";
        goto L9
    }

    @Override // zv8.e
    public final List<String> e() {
        return CollectionsKt.listOf("wanglixin.ralf");
    }

    public a() {
    }

    @Override // zv8.e
    public final EntranceGroup b() {
        return EntranceGroup.PMO;
    }
}
