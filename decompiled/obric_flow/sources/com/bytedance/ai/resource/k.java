package com.bytedance.ai.resource;

import cn.nubia.neopush.commons.Constant;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public class k {
    private String appId;
    private String packageName;

    public k(String r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, Constant.APPID);
        Intrinsics.checkNotNullParameter(r10, "packageName");
        this.appId = r5;
        this.packageName = r10;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L5;
        return true;
    L5:
        Class<?> r10 = getClass();
        if (r5 == null) goto L8;
        Class<?> r11 = r5.getClass();
    L10:
        if (Intrinsics.areEqual(r10, r11) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type com.bytedance.ai.resource.AIPackageManager.AIPackageItem");
        k r12 = (k) r5;
        if (Intrinsics.areEqual(this.appId, r12.appId) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.packageName, r12.packageName) == true) goto L18;
        return false;
    L18:
        return true;
    L8:
        r11 = null;
        goto L10
    }

    public final String getAppId() {
        return this.appId;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public int hashCode() {
        int r5 = this.appId.hashCode() * 31;
        return this.packageName.hashCode() + r5;
    }

    public final void setAppId(String r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.appId = r5;
    }

    public final void setPackageName(String r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.packageName = r5;
    }
}
