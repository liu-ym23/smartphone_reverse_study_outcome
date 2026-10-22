package com.bytedance.android.ec.common.impl.hybrid.bridges;

import com.bytedance.android.ec.common.api.usertracker.IECUserTrackerService;
import com.bytedance.android.ec.common.api.usertracker.PostActionType;
import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import com.bytedance.android.ec.sdk.ECSdk;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/ec/common/impl/hybrid/bridges/ECPostActionMethod;", "Lcom/bytedance/android/ec/host/api/hybrid/ECBaseBridgeMethod;", "<init>", "()V", "ec-common-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECPostActionMethod extends ECBaseBridgeMethod {
    public final String e;

    public ECPostActionMethod() {
        this.e = "ecPostAction";
    }

    public final String getName() {
        return this.e;
    }

    public final void c(JSONObject r10, ECBaseBridgeMethod.a r11) {
        Intrinsics.checkNotNullParameter(r10, "params");
        Intrinsics.checkNotNullParameter(r11, "iReturn");
        String r0 = r10.optString("action", "");
        int r12 = r10.optInt("type", 0);
        String r13 = r10.optString(a.KEY_PAGE_ID, "");
        if (r12 != 0) goto L5;
        int r1 = ECSdk.a;
        IECUserTrackerService r14 = (IECUserTrackerService) ECSdk.a(IECUserTrackerService.class);
        if (r14 == null) goto L26;
        of.a r15 = r14.getMarketingService();
        if (r15 == null) goto L26;
        r15.a(r0, PostActionType.DO, r13);
    L26:
        r11.onSuccess(new JSONObject());
        return;
    L5:
        if (r12 != 1) goto L7;
        int r16 = ECSdk.a;
        IECUserTrackerService r17 = (IECUserTrackerService) ECSdk.a(IECUserTrackerService.class);
        if (r17 == null) goto L20;
        of.a r18 = r17.getMarketingService();
        if (r18 == null) goto L20;
        r18.a(r0, PostActionType.START_DURATION, r13);
    L20:
        r11.onSuccess(new JSONObject());
        return;
    L7:
        if (r12 == 2) goto L9;
        r11.onFailed(0, "error type");
        return;
    L9:
        int r19 = ECSdk.a;
        IECUserTrackerService r20 = (IECUserTrackerService) ECSdk.a(IECUserTrackerService.class);
        if (r20 == null) goto L14;
        of.a r21 = r20.getMarketingService();
        if (r21 == null) goto L14;
        r21.a(r0, PostActionType.END_DURATION, r13);
    L14:
        r11.onSuccess(new JSONObject());
    }
}
