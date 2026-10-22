package wc2;

import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.live.user.api.IUserServiceV2;
import com.bytedance.android.live.user.api.UserSetting;
import com.bytedance.android.livesdk.user.h;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.ies.web.jsbridge2.f;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import io.reactivex.Single;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@XBridgeMethod(biz = "webcast", name = "updateUserInfo")
public final class d extends f<JSONObject, Object> {
    public final void onTerminate() {
    }

    public d() {
    }

    public final void invoke(Object r2, CallContext r3) {
        Intrinsics.checkNotNullParameter((JSONObject) r2, "p0");
        Intrinsics.checkNotNullParameter(r3, "p1");
        if (UserSetting.b() == false) goto L9;
        IUserServiceV2 r4 = k.f(IUserServiceV2.class);
        if (r4 == null) goto L10;
        Single r5 = r4.updateCurrentUser(null, "UpdateUserInfoMethod");
        if (r5 == null) goto L10;
        r5.subscribe(new h());
    L10:
        finishWithResult(new JSONObject());
        return;
    L9:
        k.n(IMiddlewareUserService.class).user().j().subscribe(new h());
        goto L10
    }
}
