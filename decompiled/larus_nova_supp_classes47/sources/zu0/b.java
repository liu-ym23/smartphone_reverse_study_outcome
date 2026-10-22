package zu0;

import com.bytedance.android.live.profit.profitCheck.jsbridge.ReportProfitCheckTaskDataResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import zu0.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public abstract class b<P extends h, R extends ReportProfitCheckTaskDataResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public final void onTerminate() {
    }

    public b() {
    }

    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
