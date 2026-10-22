package com.bytedance.android.annie.service.userinfo;

import android.app.Activity;
import com.bytedance.android.annie.bridge.method.v0;
import com.bytedance.android.annie.bridge.method.x0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a implements IUserInfoService {
    public a() {
    }

    @Override // com.bytedance.android.annie.service.userinfo.IUserInfoService
    public final void getUserId() {
    }

    @Override // com.bytedance.android.annie.service.userinfo.IUserInfoService
    public final void hasLogin() {
    }

    @Override // com.bytedance.android.annie.service.userinfo.IUserInfoService
    public final void z(Activity r10, x0 r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
        Intrinsics.checkNotNullParameter(r11, "logoutStatusCallback");
        r11.onFail("DefaultUserInfoService默认返回");
    }

    @Override // com.bytedance.android.annie.service.userinfo.IUserInfoService
    public final void z1(Activity r10, v0 r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
        Intrinsics.checkNotNullParameter(r11, "loginStatusCallback");
        r11.onFail();
    }

    @Override // com.bytedance.android.annie.service.userinfo.IUserInfoService
    public final void U(Activity r10, v0 r11, IUserInfoService.LoginParamsExt r12) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
        Intrinsics.checkNotNullParameter(r11, "loginStatusCallback");
        Intrinsics.checkNotNullParameter(r12, "params");
        r11.onFail();
    }
}
