package com.obric.matrix.platform.sdk.ones.account;

import android.os.Bundle;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class b {
    public static final void a(a r6, Bundle r7) {
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Intrinsics.checkNotNullParameter(r7, "bundle");
        r6.a = r7.getBoolean("loginState", false);
        r6.b = r7.getInt("logoutScene", 0);
        String r0 = r7.getString("secUserId", "");
        Intrinsics.checkNotNullParameter(r0, "<set-?>");
        r6.c = r0;
        String r1 = r7.getString("userId", "");
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        r6.d = r1;
        r6.e = r7.getInt("odinUserType", 0);
        String r2 = r7.getString("token", "");
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        r6.f = r2;
        String r3 = r7.getString("innerSsoToken", "");
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        r6.g = r3;
        String r4 = r7.getString("avatarUrl", "");
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        r6.h = r4;
        r6.i = r7.getInt("countryCode", 86);
        String r5 = r7.getString("userName", "");
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        r6.j = r5;
        String r8 = r7.getString("screenName", "");
        Intrinsics.checkNotNullParameter(r8, "<set-?>");
        r6.k = r8;
        String r9 = r7.getString("userEmail", "");
        Intrinsics.checkNotNullParameter(r9, "<set-?>");
        r6.l = r9;
        String r10 = r7.getString("userMobile", "");
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        r6.m = r10;
        r6.n = r7.getBoolean("hasPassword", false);
        r6.o = r7.getInt("userGender", 0);
        r6.p = r7.getBoolean("isNewUser", false);
        String r11 = r7.getString("userSession", "");
        Intrinsics.checkNotNullParameter(r11, "<set-?>");
        r6.q = r11;
        r6.r = r7.getLong("loginUtcTime", 0);
        String r12 = r7.getString("loginPhoneNumber", "");
        Intrinsics.checkNotNullParameter(r12, "<set-?>");
        r6.s = r12;
    }
}
