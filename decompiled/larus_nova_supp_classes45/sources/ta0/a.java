package ta0;

import com.bytedance.android.live.incentive.exchange.jsb.RevenueNotifyIncomeExchangeResultResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import com.bytedance.ies.web.jsbridge2.f;
import ta0.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class a<P extends c, R extends RevenueNotifyIncomeExchangeResultResultModel> extends f<P, R> {
    public final void onTerminate() {
    }

    public a() {
    }

    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PRIVATE;
    }
}
