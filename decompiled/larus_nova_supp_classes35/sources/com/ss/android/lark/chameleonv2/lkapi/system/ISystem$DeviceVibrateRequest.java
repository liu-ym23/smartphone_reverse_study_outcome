package com.ss.android.lark.chameleonv2.lkapi.system;

import com.bytedance.ee.util.io.NonProguard;
import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/system/ISystem$DeviceVibrateRequest;", "Lcom/bytedance/ee/util/io/NonProguard;", IPortraitService.TYPE, "Lcom/ss/android/lark/chameleonv2/lkapi/system/ISystem$DeviceVibrateType;", "<init>", "(Lcom/ss/android/lark/chameleonv2/lkapi/system/ISystem$DeviceVibrateType;)V", "getType", "()Lcom/ss/android/lark/chameleonv2/lkapi/system/ISystem$DeviceVibrateType;", "component1", "copy", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", BuildConfig.FLAVOR, "larkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ISystem$DeviceVibrateRequest implements NonProguard {
    private final ISystem$DeviceVibrateType type;

    public static /* synthetic */ ISystem$DeviceVibrateRequest copy$default(ISystem$DeviceVibrateRequest r0, ISystem$DeviceVibrateType r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.type;
    L6:
        return r0.copy(r1);
    }

    public final ISystem$DeviceVibrateType component1() {
        return this.type;
    }

    public final ISystem$DeviceVibrateRequest copy(ISystem$DeviceVibrateType r2) {
        Intrinsics.checkNotNullParameter(r2, IPortraitService.TYPE);
        return new ISystem$DeviceVibrateRequest(r2);
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof ISystem$DeviceVibrateRequest) == true) goto L9;
        return false;
    L9:
        if (this.type == ((ISystem$DeviceVibrateRequest) r4).type) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.type.hashCode();
    }

    public String toString() {
        return "DeviceVibrateRequest(type=" + this.type + ')';
    }

    public final ISystem$DeviceVibrateType getType() {
        return this.type;
    }

    public ISystem$DeviceVibrateRequest(ISystem$DeviceVibrateType r2) {
        Intrinsics.checkNotNullParameter(r2, IPortraitService.TYPE);
        this.type = r2;
    }
}
