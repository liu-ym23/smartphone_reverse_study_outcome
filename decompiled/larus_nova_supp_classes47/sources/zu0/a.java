package zu0;

import com.bytedance.android.live.profit.profitCheck.jsbridge.GetProfitReportConfigResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import zu0.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public abstract class a<P extends d, R extends GetProfitReportConfigResultModel> extends com.bytedance.ies.web.jsbridge2.f<P, R> {
    public final void onTerminate() {
    }

    public a() {
    }

    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
