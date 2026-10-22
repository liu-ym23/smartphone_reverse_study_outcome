package com.ss.android.lark.chameleonv2.lkapi.app;

import com.bytedance.ee.util.io.NonProguard;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/app/IApp$Property;", "Lcom/bytedance/ee/util/io/NonProguard;", "timeOrigin", BuildConfig.FLAVOR, "<init>", "(D)V", "getTimeOrigin", "()D", "component1", "copy", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", BuildConfig.FLAVOR, "larkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IApp$Property implements NonProguard {
    private final double timeOrigin;

    public static /* synthetic */ IApp$Property copy$default(IApp$Property r0, double r1, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.timeOrigin;
    L6:
        return r0.copy(r1);
    }

    public final double component1() {
        return this.timeOrigin;
    }

    public final IApp$Property copy(double r2) {
        return new IApp$Property(r2);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof IApp$Property) == true) goto L9;
        return false;
    L9:
        if (Double.compare(this.timeOrigin, ((IApp$Property) r8).timeOrigin) == 0) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        long r0 = Double.doubleToLongBits(this.timeOrigin);
        return (int) (r0 ^ (r0 >>> 32));
    }

    public String toString() {
        return "Property(timeOrigin=" + this.timeOrigin + ')';
    }

    public final double getTimeOrigin() {
        return this.timeOrigin;
    }

    public IApp$Property(double r1) {
        this.timeOrigin = r1;
    }
}
