package xv8;

import com.bytedance.apm.ApmAgent;
import com.larus.applog.api.IApplog;
import com.larus.business.debug.base.DebugConstants$DebugTools$DebugToolsType;
import com.larus.common.larksso.api.ILarkSSOService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(DebugConstants$DebugTools$DebugToolsType r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "toolType");
        Intrinsics.checkNotNullParameter(r3, "toolName");
        JSONObject r0 = new JSONObject();
        r0.put("flow_tools_type", r2.getType());
        r0.put("flow_tools_name", r3);
        r0.put("flow_tools_did", IApplog.a.getDeviceId());
        ILarkSSOService r4 = (ILarkSSOService) ServiceManager.get().getService(ILarkSSOService.class);
        if (r4 == null) goto L6;
        String r5 = Boolean.valueOf(r4.b()).toString();
        if (r5 == null) goto L6;
    L7:
        r0.put("flow_tools_lark_sso_authed", r5);
        ApmAgent.monitorEvent("flow_dev_tools_event", r0, new JSONObject(), new JSONObject());
        return;
    L6:
        r5 = "false";
        goto L7
    }
}
