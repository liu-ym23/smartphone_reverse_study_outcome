package com.bytedance.android.ec.base.api.ai;

import com.byted.mgl.merge.service.api.aweme.BdpAwemeConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/ec/base/api/ai/MiniAppConfig;", "", BdpAwemeConstant.KEY_APP_NAME, "", "appKey", "appType", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAppKey", "()Ljava/lang/String;", "getAppName", "getAppType", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "ec-base-api_release"}, k = 1, mv = {1, 4, 3})
public final class MiniAppConfig {
    private final String appKey;
    private final String appName;
    private final String appType;

    public static /* synthetic */ MiniAppConfig copy$default(MiniAppConfig r0, String r1, String r10, String r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r1 = r0.appName;
    L6:
        if ((r12 & 2) == 0) goto L9;
        r10 = r0.appKey;
    L9:
        if ((r12 & 4) == 0) goto L12;
        r11 = r0.appType;
    L12:
        return r0.copy(r1, r10, r11);
    }

    public final String component1() {
        return this.appName;
    }

    public final String component2() {
        return this.appKey;
    }

    public final String component3() {
        return this.appType;
    }

    public final MiniAppConfig copy(String r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, BdpAwemeConstant.KEY_APP_NAME);
        Intrinsics.checkNotNullParameter(r11, "appKey");
        Intrinsics.checkNotNullParameter(r12, "appType");
        return new MiniAppConfig(r10, r11, r12);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L4;
        return true;
    L4:
        if ((r10 instanceof MiniAppConfig) == false) goto L12;
        MiniAppConfig r11 = (MiniAppConfig) r10;
        if (Intrinsics.areEqual(this.appName, r11.appName) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.appKey, r11.appKey) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.appType, r11.appType) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        String r0 = this.appName;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r10 = r0.hashCode();
    L6:
        int r11 = r10 * 31;
        String r12 = this.appKey;
        if (r12 == null) goto L9;
        int r13 = r12.hashCode();
    L10:
        int r14 = (r11 + r13) * 31;
        String r15 = this.appType;
        if (r15 == null) goto L14;
        r1 = r15.hashCode();
    L14:
        return r14 + r1;
    L9:
        r13 = 0;
        goto L10
    L5:
        r10 = 0;
        goto L6
    }

    public String toString() {
        return "MiniAppConfig(appName=" + this.appName + ", appKey=" + this.appKey + ", appType=" + this.appType + ")";
    }

    public final String getAppKey() {
        return this.appKey;
    }

    public final String getAppName() {
        return this.appName;
    }

    public final String getAppType() {
        return this.appType;
    }

    public MiniAppConfig(String r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, BdpAwemeConstant.KEY_APP_NAME);
        Intrinsics.checkNotNullParameter(r11, "appKey");
        Intrinsics.checkNotNullParameter(r12, "appType");
        this.appName = r10;
        this.appKey = r11;
        this.appType = r12;
    }
}
