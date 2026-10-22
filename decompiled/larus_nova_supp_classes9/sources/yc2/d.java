package yc2;

import android.content.Context;
import com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import jc1.k;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@XBridgeMethod(biz = "webcast", name = "showManagePoiDialog")
public final class d extends com.bytedance.ies.web.jsbridge2.g<JSONObject, Unit> {
    public d() {
    }

    public final Object invoke(Object r10, CallContext r11) {
        JSONObject r13 = (JSONObject) r10;
        Intrinsics.checkNotNullParameter(r13, "params");
        Intrinsics.checkNotNullParameter(r11, "context");
        int r0 = r13.optInt("is_in_room", 0);
        String r14 = r13.optString("room_id");
        IMiddlewareHostBusiness r3 = k.f(IMiddlewareHostBusiness.class);
        if (r3 == null) goto L14;
        Context r4 = r11.getContext();
        if (r0 != 1) goto L7;
        boolean r5 = true;
    L8:
        Long r15 = StringsKt.toLongOrNull(r14);
        if (r15 == null) goto L11;
        long r16 = r15.longValue();
    L12:
        r3.showManagePoiDialog(r4, r5, r16, null);
        goto L14
    L11:
        r16 = 0;
        goto L12
    L7:
        r5 = false;
    L14:
        return Unit.INSTANCE;
    }
}
