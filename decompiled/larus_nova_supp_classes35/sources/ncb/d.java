package ncb;

import com.ss.android.lark.opmonitor.model.OPMonitorCode;
import com.ss.android.lark.opmonitor.model.OPMonitorLevel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d extends OPMonitorCode {
    public static final d a = null;

    static {
        a = new d(OPMonitorLevel.NORMAL);
    }

    public d(OPMonitorLevel r4) {
        super("client.open_platform.infra.storage", 10000, r4, "sp_creation_failed_monitor");
    }
}
