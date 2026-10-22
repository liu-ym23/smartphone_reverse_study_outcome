package com.ss.android.lark.chameleonv2.lkapi.system;

import com.bytedance.ee.util.io.NonProguard;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\tHÆ\u0003J1\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\tHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/system/ISystem$Property;", "Lcom/bytedance/ee/util/io/NonProguard;", "platform", BuildConfig.FLAVOR, "deviceType", "Lcom/ss/android/lark/chameleonv2/lkapi/system/ISystem$DeviceType;", "statusBarHeight", BuildConfig.FLAVOR, "totalMemory", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;Lcom/ss/android/lark/chameleonv2/lkapi/system/ISystem$DeviceType;FI)V", "getPlatform", "()Ljava/lang/String;", "getDeviceType", "()Lcom/ss/android/lark/chameleonv2/lkapi/system/ISystem$DeviceType;", "getStatusBarHeight", "()F", "getTotalMemory", "()I", "component1", "component2", "component3", "component4", "copy", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", "toString", "larkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ISystem$Property implements NonProguard {
    private final ISystem$DeviceType deviceType;
    private final String platform;
    private final float statusBarHeight;
    private final int totalMemory;

    public static /* synthetic */ ISystem$Property copy$default(ISystem$Property r0, String r1, ISystem$DeviceType r2, float r3, int r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.platform;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.deviceType;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.statusBarHeight;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.totalMemory;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final String component1() {
        return this.platform;
    }

    public final ISystem$DeviceType component2() {
        return this.deviceType;
    }

    public final float component3() {
        return this.statusBarHeight;
    }

    public final int component4() {
        return this.totalMemory;
    }

    public final ISystem$Property copy(String r2, ISystem$DeviceType r3, float r4, int r5) {
        Intrinsics.checkNotNullParameter(r2, "platform");
        Intrinsics.checkNotNullParameter(r3, "deviceType");
        return new ISystem$Property(r2, r3, r4, r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ISystem$Property) == true) goto L8;
        return false;
    L8:
        ISystem$Property r6 = (ISystem$Property) r5;
        if (Intrinsics.areEqual(this.platform, r6.platform) == true) goto L12;
        return false;
    L12:
        if (this.deviceType == r6.deviceType) goto L15;
        return false;
    L15:
        if (Float.compare(this.statusBarHeight, r6.statusBarHeight) == 0) goto L18;
        return false;
    L18:
        if (this.totalMemory == r6.totalMemory) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((this.platform.hashCode() * 31) + this.deviceType.hashCode()) * 31) + Float.floatToIntBits(this.statusBarHeight)) * 31) + this.totalMemory;
    }

    public String toString() {
        return "Property(platform=" + this.platform + ", deviceType=" + this.deviceType + ", statusBarHeight=" + this.statusBarHeight + ", totalMemory=" + this.totalMemory + ')';
    }

    public final ISystem$DeviceType getDeviceType() {
        return this.deviceType;
    }

    public final String getPlatform() {
        return this.platform;
    }

    public final float getStatusBarHeight() {
        return this.statusBarHeight;
    }

    public final int getTotalMemory() {
        return this.totalMemory;
    }

    public ISystem$Property(String r2, ISystem$DeviceType r3, float r4, int r5) {
        Intrinsics.checkNotNullParameter(r2, "platform");
        Intrinsics.checkNotNullParameter(r3, "deviceType");
        this.platform = r2;
        this.deviceType = r3;
        this.statusBarHeight = r4;
        this.totalMemory = r5;
    }
}
