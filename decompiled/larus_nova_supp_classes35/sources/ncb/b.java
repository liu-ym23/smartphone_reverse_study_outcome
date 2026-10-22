package ncb;

import com.ss.android.lark.chameleon.bridge.BridgeReport;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.android.lark.opmonitor.model.OPMonitorCode;
import com.ss.android.lark.opmonitor.model.OPMonitorLevel;
import com.ss.ttvideoengine.utils.Error;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b extends OPMonitorCode {
    public static final b a = null;
    public static final b b = null;
    public static final b c = null;
    public static final b d = null;
    public static final b e = null;
    public static final b f = null;

    static {
        OPMonitorLevel r1 = OPMonitorLevel.NORMAL;
        a = new b(0, r1, ChameleonOpenTracker.OpenResult.SUCCESS);
        OPMonitorLevel r2 = OPMonitorLevel.ERROR;
        new b(Error.Timeout, r2, "internal_error");
        new b(Error.MDLFetcherListenerEmpty, r2, "param_invalid");
        b = new b(Error.FallbackApiEmpty, r2, "fetch_block_entity_network_error");
        c = new b(Error.FileHashInvalid, r2, "fetch_block_entity_biz_error");
        new b(10000, r1, "unmount_block");
        new b(10001, r1, "start_mount_block");
        new b(10002, r1, "start_block_entity");
        d = new b(BridgeReport.CODE_API_AUTH_FAILED, r1, "start_fetch_block_entity");
        e = new b(BridgeReport.CODE_NO_API_HANDLER, r1, "fetch_block_entity_success");
        f = new b(BridgeReport.CODE_CALLBACKID_IS_NULL_OR_EMPTY, r1, "block_entity_result");
    }

    public b(int r2, OPMonitorLevel r3, String r4) {
        super("client.open_platform.blockit.mount.entity", r2, r3, r4);
    }
}
