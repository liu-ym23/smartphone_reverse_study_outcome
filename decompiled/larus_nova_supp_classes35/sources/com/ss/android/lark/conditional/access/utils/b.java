package com.ss.android.lark.conditional.access.utils;

import com.bytedance.lark.pb.security.v1.CustomDisplayHandler;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b {
    public static final List<String> a = null;

    static {
        a = CollectionsKt.listOf(new String[]{"CustomLink", "CustomAppLink", "DeviceApply", "DeviceAuth", "Cancel", "RetryAccess", "MFA", "UserConfirm", "DeviceCertAuth", "DeviceTokenClaimsChallenge", "GeoAuth", "VerifyLocation", "SkipVerify"});
    }

    public static final boolean a(CustomDisplayHandler r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if (a.contains(r2.type) == true) goto L5;
        return false;
    L5:
        LarkAppContext.Companion.getClass();
        if (LarkAppContext.access$getInstance$cp().buildConfig().isOfficeSDK() == true) goto L8;
    L9:
        return true;
    L8:
        if (Intrinsics.areEqual(r2.type, "GeoAuth") == false) goto L9;
        return false;
    }
}
