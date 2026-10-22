package com.bytedance.android.livesdk.jsbridge.methods;

import android.text.TextUtils;
import com.bytedance.android.live.base.model.user.IUser;
import com.bytedance.android.live.base.model.user.UserAttr;
import com.bytedance.android.live.browser.jsbridge.base.UserInfoResultModel;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livehostapi.platform.depend.user.HostUserDetail;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import w20.e7;
import w20.rf;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@XBridgeMethod(biz = "webcast", name = "userInfo")
public final class f5 extends e7<rf, UserInfoResultModel> {
    public f5() {
    }

    public final void invoke(Object r8, CallContext r9) throws Exception {
        rf r10 = (rf) r8;
        int r0 = 1;
        if (r10.a() == null) goto L5;
        boolean r11 = r10.a().booleanValue();
    L7:
        if (r11 == false) goto L21;
        com.bytedance.android.livesdk.user.f r13 = jc1.k.f(IUserService.class).user();
        UserAttr r2 = r13.b().getUserAttr();
        IUser r3 = r13.b();
        UserInfoResultModel r4 = new UserInfoResultModel();
        if (r13.isLogin() == false) goto L11;
        r4.g(1);
    L13:
        if (r13.isLogin() == false) goto L15;
        r4.e(String.valueOf(r3.getShortId()));
        r4.f(r3.getIdString());
        r4.d(r3.getCastSecUid());
        r4.c(r3.getRealNickName());
    L15:
        if (r2 != null) goto L17;
    L19:
        r0 = 0;
    L20:
        r4.h(Integer.valueOf(r0));
        r4.b(UserInfoResultModel.Code.Success);
        finishWithResult(r4);
        return;
    L17:
        if (r2.isMuted() == false) goto L19;
    L11:
        r4.g(0);
        goto L13
    L21:
        UserInfoResultModel r14 = new UserInfoResultModel();
        long r5 = TTLiveSDK.hostService().user().hostUserId();
        if (r5 == 0) goto L24;
        r14.g(1);
    L25:
        if (r5 == 0) goto L27;
        r14.f(String.valueOf(r5));
    L27:
        HostUserDetail r15 = TTLiveSDK.hostService().user().hostUserDetail();
        if (r15 != null) goto L30;
    L38:
        r14.b(UserInfoResultModel.Code.Success);
        finishWithResult(r14);
        return;
    L30:
        if (TextUtils.isEmpty(r15.nickName) == true) goto L33;
        r14.c(r15.nickName);
    L33:
        if (TextUtils.isEmpty(r15.secUid) == true) goto L36;
        r14.d(r15.secUid);
    L36:
        if (TextUtils.isEmpty(r15.avatarURL) == true) goto L38;
        r14.a(r15.avatarURL);
        goto L38
    L24:
        r14.g(0);
        goto L25
    L5:
        r11 = true;
        goto L7
    }
}
