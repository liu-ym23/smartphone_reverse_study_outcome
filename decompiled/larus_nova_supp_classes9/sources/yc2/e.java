package yc2;

import com.bytedance.android.livehostapi.business.IHostBusiness;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import jc1.k;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@XBridgeMethod(biz = "webcast", name = "showPoiInfoDialogForAudience")
public final class e extends com.bytedance.ies.web.jsbridge2.g<JSONObject, Unit> {
    public e() {
    }

    public final Object invoke(Object r4, CallContext r5) {
        JSONObject r6 = (JSONObject) r4;
        Intrinsics.checkNotNullParameter(r6, "params");
        Intrinsics.checkNotNullParameter(r5, "context");
        String r0 = r6.optString("user_id");
        String r1 = r6.optString("poi_id_str");
        String r7 = r6.optString("room_id");
        IHostBusiness r2 = k.f(IHostBusiness.class);
        if (r2 == null) goto L6;
        r2.showPoiInfoDialogForAudience(r5.getContext(), r1, r0, r7);
    L6:
        return Unit.INSTANCE;
    }
}
