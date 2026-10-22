package com.ss.android.lark.passport;

import android.content.SharedPreferences;
import com.ss.android.lark.officesdk.api.init.IOfficeSDKTokenProvider;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Singleton
public final class OfficeTokenServiceImpl implements com.ss.android.lark.passport.dpop.b {
    public static final Lazy<SharedPreferences> b = null;
    public final IOfficeSDKTokenProvider a;

    public static final class a {
        public a() {
        }
    }

    static {
        new a();
        b = LazyKt.lazy(OfficeTokenServiceImpl$Companion$mPreference$2.INSTANCE);
    }

    @Override // com.ss.android.lark.passport.dpop.b
    public final boolean isDoubaoBUser() {
        return this.a.isDoubaoBUser();
    }

    @Override // com.ss.android.lark.passport.dpop.b
    public final String getAccessToken() {
        if (com.ss.android.lark.passport.a.a() == false) goto L26;
        Lazy<SharedPreferences> r0 = b;
        SharedPreferences r1 = (SharedPreferences) r0.getValue();
        int r2 = -1;
        if (r1 == null) goto L7;
        r2 = r1.getInt("custom_env_value", -1);
    L7:
        boolean r3 = false;
        if (r2 != 2) goto L10;
        boolean r4 = true;
    L11:
        if (r4 == false) goto L26;
        SharedPreferences r5 = (SharedPreferences) r0.getValue();
        if (r5 == null) goto L26;
        String r6 = r5.getString("o_access_token", "");
        if (r6 == null) goto L26;
        if (r6.length() <= 0) goto L19;
        r3 = true;
    L19:
        if (r3 == true) goto L22;
        r6 = null;
    L22:
        if (r6 == null) goto L26;
        return "Bearer ".concat(r6);
    L10:
        r4 = false;
    L26:
        return this.a.getAuthSchema() + ' ' + this.a.getAccessToken();
    }

    @Inject
    public OfficeTokenServiceImpl(IOfficeSDKTokenProvider r2) {
        Intrinsics.checkNotNullParameter(r2, "tokenProvider");
        this.a = r2;
    }
}
