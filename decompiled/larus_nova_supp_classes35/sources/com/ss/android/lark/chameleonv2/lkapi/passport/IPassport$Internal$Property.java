package com.ss.android.lark.chameleonv2.lkapi.passport;

import com.bytedance.ee.util.io.NonProguard;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/passport/IPassport$Internal$Property;", "Lcom/bytedance/ee/util/io/NonProguard;", "deviceId", BuildConfig.FLAVOR, "userId", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getDeviceId", "()Ljava/lang/String;", "getUserId", "component1", "component2", "copy", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", "larkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IPassport$Internal$Property implements NonProguard {
    private final String deviceId;
    private final String userId;

    public static /* synthetic */ IPassport$Internal$Property copy$default(IPassport$Internal$Property r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.deviceId;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.userId;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component1() {
        return this.deviceId;
    }

    public final String component2() {
        return this.userId;
    }

    public final IPassport$Internal$Property copy(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "deviceId");
        Intrinsics.checkNotNullParameter(r3, "userId");
        return new IPassport$Internal$Property(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof IPassport$Internal$Property) == true) goto L8;
        return false;
    L8:
        IPassport$Internal$Property r6 = (IPassport$Internal$Property) r5;
        if (Intrinsics.areEqual(this.deviceId, r6.deviceId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.userId, r6.userId) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.deviceId.hashCode() * 31) + this.userId.hashCode();
    }

    public String toString() {
        return "Property(deviceId=" + this.deviceId + ", userId=" + this.userId + ')';
    }

    public final String getDeviceId() {
        return this.deviceId;
    }

    public final String getUserId() {
        return this.userId;
    }

    public IPassport$Internal$Property(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "deviceId");
        Intrinsics.checkNotNullParameter(r3, "userId");
        this.deviceId = r2;
        this.userId = r3;
    }
}
