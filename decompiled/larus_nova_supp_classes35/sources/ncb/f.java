package ncb;

import com.ss.android.lark.opmonitor.model.OPMonitorCode;
import com.ss.android.lark.opmonitor.model.OPMonitorLevel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class f extends OPMonitorCode {
    public static final /* synthetic */ int a = 0;

    static {
        new f(OPMonitorLevel.NORMAL);
    }

    public f(OPMonitorLevel r4) {
        super("client.security_compliance.universal", 10000, r4, "scs_universal_log");
    }
}
