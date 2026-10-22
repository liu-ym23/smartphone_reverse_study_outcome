package com.obric.matrix.platform.sdk.ones.account;

import android.os.Bundle;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class b {
    public static final a a(a r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "bundle");
        r10.g(r11.getBoolean("loginState", false));
        r10.i(r11.getInt("logoutScene", 0));
        String r12 = r11.getString("secUserId", "");
        Intrinsics.checkNotNullExpressionValue(r12, "bundle.getString(Account…undleKey.SEC_USER_ID, \"\")");
        r10.m(r12);
        String r13 = r11.getString("userId", "");
        Intrinsics.checkNotNullExpressionValue(r13, "bundle.getString(AccountInfoBundleKey.USER_ID, \"\")");
        r10.p(r13);
        r10.k(r11.getInt("odinUserType", 0));
        String r14 = r11.getString("token", "");
        Intrinsics.checkNotNullExpressionValue(r14, "bundle.getString(AccountInfoBundleKey.TOKEN, \"\")");
        r10.t(r14);
        String r15 = r11.getString("innerSsoToken", "");
        Intrinsics.checkNotNullExpressionValue(r15, "bundle.getString(Account…eKey.INNER_SSO_TOKEN, \"\")");
        r10.e(r15);
        String r16 = r11.getString("avatarUrl", "");
        Intrinsics.checkNotNullExpressionValue(r16, "bundle.getString(Account…BundleKey.AVATAR_URL, \"\")");
        r10.b(r16);
        r10.c(r11.getInt("countryCode", 86));
        String r17 = r11.getString("userName", "");
        Intrinsics.checkNotNullExpressionValue(r17, "bundle.getString(Account…oBundleKey.USER_NAME, \"\")");
        r10.r(r17);
        String r18 = r11.getString("screenName", "");
        Intrinsics.checkNotNullExpressionValue(r18, "bundle.getString(Account…undleKey.SCREEN_NAME, \"\")");
        r10.l(r18);
        String r19 = r11.getString("userEmail", "");
        Intrinsics.checkNotNullExpressionValue(r19, "bundle.getString(Account…BundleKey.USER_EMAIL, \"\")");
        r10.n(r19);
        String r20 = r11.getString("userMobile", "");
        Intrinsics.checkNotNullExpressionValue(r20, "bundle.getString(Account…undleKey.USER_MOBILE, \"\")");
        r10.q(r20);
        r10.d(r11.getBoolean("hasPassword", false));
        r10.o(r11.getInt("userGender", 0));
        r10.j(r11.getBoolean("isNewUser", false));
        String r21 = r11.getString("userSession", "");
        Intrinsics.checkNotNullExpressionValue(r21, "bundle.getString(Account…ndleKey.USER_SESSION, \"\")");
        r10.s(r21);
        r10.h(r11.getLong("loginUtcTime", 0));
        String r22 = r11.getString("loginPhoneNumber", "");
        Intrinsics.checkNotNullExpressionValue(r22, "bundle.getString(Account…y.LOGIN_PHONE_NUMBER, \"\")");
        r10.f(r22);
        return r10;
    }
}
