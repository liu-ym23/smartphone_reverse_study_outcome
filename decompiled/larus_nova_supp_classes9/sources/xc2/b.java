package xc2;

import com.bytedance.android.live.base.model.user.IUser;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.jsbridge.methods.account.LiveCanSwitchAccountResultModel;
import com.bytedance.android.livesdk.user.f;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.google.gson.JsonObject;
import jc1.k;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import py.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b extends a<JsonObject, LiveCanSwitchAccountResultModel> {
    public b() {
    }

    public final void invoke(Object r2, CallContext r3) {
        Intrinsics.checkNotNullParameter((JsonObject) r2, "params");
        Intrinsics.checkNotNullParameter(r3, "context");
        IUserService r4 = k.f(IUserService.class);
        if (r4 == null) goto L11;
        f r5 = r4.user();
        if (r5 == null) goto L11;
        IUser r6 = r5.b();
        if (r6 == null) goto L11;
        d r7 = r6.getUserHonor();
        if (r7 == null) goto L11;
        int r8 = r7.getLevel();
    L12:
        LiveCanSwitchAccountResultModel r9 = new LiveCanSwitchAccountResultModel();
        r9.a(LiveCanSwitchAccountResultModel.Code.Success);
        r9.b(Boolean.valueOf(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.helper.a.a(r8)));
        Unit r10 = Unit.INSTANCE;
        finishWithResult(r9);
        return;
    L11:
        r8 = 0;
        goto L12
    }
}
