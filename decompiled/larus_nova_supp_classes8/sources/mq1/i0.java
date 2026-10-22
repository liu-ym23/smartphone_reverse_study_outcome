package mq1;

import com.bytedance.android.livesdk.chatroom.vs_base.VSDataCenterScopeUtil;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class i0 {
    public static final h0 a(DataCenter r1, Widget r2) {
        ju2.a r3 = VSDataCenterScopeUtil.b(r1, r2);
        if (r3 != null) goto L7;
        return null;
    L7:
        return (h0) com.bytedance.android.scope.m.e.d(r3, h0.class);
    }
}
