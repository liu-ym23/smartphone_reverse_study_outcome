package ncb;

import com.ss.android.lark.chameleon.bridge.BridgeReport;
import com.ss.android.lark.opmonitor.model.OPMonitorCode;
import com.ss.android.lark.opmonitor.model.OPMonitorLevel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a extends OPMonitorCode {
    public static final a a = null;

    static {
        OPMonitorLevel r1 = OPMonitorLevel.NORMAL;
        new a(10002, r1, "native_receive_invoke");
        new a(BridgeReport.CODE_API_AUTH_FAILED, r1, "native_callback_invoke");
        new a(BridgeReport.CODE_NO_API_HANDLER, r1, "native_invoke_start");
        new a(BridgeReport.CODE_CALLBACKID_IS_NULL_OR_EMPTY, r1, "native_invoke_result");
        new a(BridgeReport.CODE_BRIDGE_IS_BAN, r1, "native_pm_invoke_start");
        new a(BridgeReport.CODE_DATA_MORE_THAN_2M, r1, "native_pm_invoke_result");
        new a(10008, r1, "plugin_silent_checker");
        new a(10009, r1, "plugin_paramtype_checker");
        a = new a(10010, r1, "plugin_input_checker");
    }

    public a(int r2, OPMonitorLevel r3, String r4) {
        super("client.open_platform.api.common", r2, r3, r4);
    }
}
