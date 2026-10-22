package com.bytedance.android.livesdk.jsbridge.methods;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livesdk.gift.model.CardLockInfo;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.annotations.SerializedName;
import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@XBridgeMethod(biz = "webcast", name = "login")
public final class z1 extends com.bytedance.ies.web.jsbridge2.f<a, Object> {
    public Disposable a;

    public static class a {

        @SerializedName("action_type")
        String actionType;

        @SerializedName("enter_from")
        String enterFrom;

        @SerializedName("from_type")
        int fromType;

        @SerializedName(sz1.a.KEY_LOCAL_ICON_BITMAP)
        String imageUrl;

        @SerializedName("loginDesc")
        String loginDesc;

        @SerializedName("msg")
        String msg;

        @SerializedName("source")
        String source;

        @SerializedName("themeId")
        String themeId;

        @SerializedName("through_aweme")
        boolean useSaaSAuthInfo;

        @SerializedName("user_agree_auth")
        boolean userAgreeAuth;

        @SerializedName("version")
        int version;

        public a() {
            this.useSaaSAuthInfo = true;
        }
    }

    public static final class b {

        @SerializedName("status")
        int status;

        public b() {
        }

        public b(int r1) {
            this.status = r1;
        }
    }

    public final void onTerminate() {
        Disposable r0 = this.a;
        if (r0 == null) goto L6;
        r0.dispose();
        return;
    }

    public z1() {
    }

    public final void invoke(Object r7, CallContext r8) throws Exception {
        a r9 = (a) r7;
        Activity r0 = ContextUtil.contextToActivity(r8.getContext());
        boolean r2 = true;
        if (r9.version != 1) goto L5;
        boolean r1 = true;
    L6:
        if (r0 != null) goto L9;
        finishWithFailure();
    L9:
        if (r9.useSaaSAuthInfo == false) goto L29;
        if (jc1.k.f(IUserService.class).user().isLogin() == false) goto L15;
        if (r1 == false) goto L14;
        finishWithResult(new b(0));
        return;
    L14:
        finishWithSuccess();
        return;
    L15:
        Bundle r3 = new Bundle();
        if (TextUtils.isEmpty(r9.themeId) == true) goto L19;
        r3.putString("themeId", r9.themeId);
    L19:
        if (TextUtils.isEmpty(r9.loginDesc) == true) goto L21;
        r3.putString("loginDesc", r9.loginDesc);
    L21:
        String r4 = r9.source;
        if (r4 != null) goto L24;
        r4 = CardLockInfo.sUNKNOWN;
    L24:
        com.bytedance.android.livesdk.user.f r5 = jc1.k.f(IUserService.class).user();
        Context r10 = r8.getContext();
        com.bytedance.android.livesdk.user.l.a r6 = new com.bytedance.android.livesdk.user.l.a();
        String r11 = r9.msg;
        if (r11 != null) goto L27;
        r11 = com.bytedance.android.live.core.utils.s1.B(2131920130);
    L27:
        r6.a = r11;
        r6.b = r9.imageUrl;
        r6.c = r9.fromType;
        r6.d = r4;
        r6.e = r9.enterFrom;
        r6.g = r9.actionType;
        r6.i = r9.userAgreeAuth;
        r6.h = r3;
        r5.login(r10, new com.bytedance.android.livesdk.user.l(r6)).subscribe(new x1(this, r1));
        return;
    L29:
        if (r9.version == 1) goto L33;
        r2 = false;
    L33:
        if (TTLiveSDK.hostService().user().hostUserId() == 0) goto L37;
        if (r2 == false) goto L36;
        finishWithResult(new b(0));
        return;
    L36:
        finishWithSuccess();
        return;
    L37:
        FragmentActivity r13 = r8.getContext();
        if ((r13 instanceof FragmentActivity) == false) goto L41;
        FragmentActivity r14 = r13;
    L45:
        TTLiveSDK.hostService().user().hostUserLogin(r14, new y1(this, r2));
        return;
    L41:
        if ((r13 instanceof ContextWrapper) == false) goto L48;
        ContextWrapper r15 = (ContextWrapper) r13;
        if ((r15.getBaseContext() instanceof FragmentActivity) == false) goto L48;
        r14 = r15.getBaseContext();
    L48:
        throw new IllegalArgumentException("Argument \"context\" cannot be transformed to FragmentActivity in UserCenter.login() method. ");
    L5:
        r1 = false;
        goto L6
    }
}
