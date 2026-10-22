package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.broadcast.api.gamepromote.GamePromoteDataContext;
import com.bytedance.android.livesdkapi.hybridapi.ILiveHybridContainer;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "webcastSdk.setSideslip")
public final class jc extends com.bytedance.ies.web.jsbridge2.g<JSONObject, Object> {
    public final ILiveHybridContainer a;

    public jc(ILiveHybridContainer r1) {
        this.a = r1;
    }

    public final Object invoke(Object r11, CallContext r12) {
        JSONObject r13 = (JSONObject) r11;
        Intrinsics.checkNotNullParameter(r13, "params");
        Intrinsics.checkNotNullParameter(r12, "context");
        ILiveHybridContainer r14 = this.a;
        if ((r14 instanceof v40.c) == false) goto L18;
        String r15 = r13.optString("forbid_right_back", "");
        if (r15 == null) goto L42;
        int r16 = r15.hashCode();
        if (r16 == 48) goto L15;
        if (r16 == 49) goto L12;
        return null;
    L12:
        if (r15.equals(GamePromoteDataContext.GAME_TYPE_MOBILE) == false) goto L34;
        ((v40.c) this.a).setCloseByGesture(false);
        return null;
    L34:
        return null;
    L15:
        if (r15.equals("0") == false) goto L36;
        ((v40.c) this.a).setCloseByGesture(true);
        return null;
    L36:
        return null;
    L42:
        return null;
    L18:
        if ((r14 instanceof v40.b) == false) goto L38;
        String r17 = r13.optString("forbid_right_back", "");
        if (r17 == null) goto L44;
        int r18 = r17.hashCode();
        if (r18 == 48) goto L30;
        if (r18 == 49) goto L27;
        return null;
    L27:
        if (r17.equals(GamePromoteDataContext.GAME_TYPE_MOBILE) == false) goto L39;
        ((v40.b) this.a).setCloseByGesture(false);
        return null;
    L39:
        return null;
    L30:
        if (r17.equals("0") == false) goto L41;
        ((v40.b) this.a).setCloseByGesture(true);
        return null;
    L41:
        return null;
    L44:
        return null;
    L38:
        return null;
    }
}
