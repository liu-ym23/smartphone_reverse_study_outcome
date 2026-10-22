package com.ss.android.lark.chameleonv2.lkapi.featuregating;

import com.bytedance.ee.util.io.NonProguard;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\u001c"}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/featuregating/IFeatureGating$Internal$Property;", "Lcom/bytedance/ee/util/io/NonProguard;", "runtimeConfigs", "Lcom/ss/android/lark/chameleonv2/lkapi/featuregating/IFeatureGating$Internal$AllStatusesAndValues;", "runtimeTimestamp", BuildConfig.FLAVOR, "startupConfigs", "startupTimestamp", "<init>", "(Lcom/ss/android/lark/chameleonv2/lkapi/featuregating/IFeatureGating$Internal$AllStatusesAndValues;ILcom/ss/android/lark/chameleonv2/lkapi/featuregating/IFeatureGating$Internal$AllStatusesAndValues;I)V", "getRuntimeConfigs", "()Lcom/ss/android/lark/chameleonv2/lkapi/featuregating/IFeatureGating$Internal$AllStatusesAndValues;", "getRuntimeTimestamp", "()I", "getStartupConfigs", "getStartupTimestamp", "component1", "component2", "component3", "component4", "copy", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", "toString", BuildConfig.FLAVOR, "larkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IFeatureGating$Internal$Property implements NonProguard {
    private final IFeatureGating$Internal$AllStatusesAndValues runtimeConfigs;
    private final int runtimeTimestamp;
    private final IFeatureGating$Internal$AllStatusesAndValues startupConfigs;
    private final int startupTimestamp;

    public static /* synthetic */ IFeatureGating$Internal$Property copy$default(IFeatureGating$Internal$Property r0, IFeatureGating$Internal$AllStatusesAndValues r1, int r2, IFeatureGating$Internal$AllStatusesAndValues r3, int r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.runtimeConfigs;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.runtimeTimestamp;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.startupConfigs;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.startupTimestamp;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final IFeatureGating$Internal$AllStatusesAndValues component1() {
        return this.runtimeConfigs;
    }

    public final int component2() {
        return this.runtimeTimestamp;
    }

    public final IFeatureGating$Internal$AllStatusesAndValues component3() {
        return this.startupConfigs;
    }

    public final int component4() {
        return this.startupTimestamp;
    }

    public final IFeatureGating$Internal$Property copy(IFeatureGating$Internal$AllStatusesAndValues r2, int r3, IFeatureGating$Internal$AllStatusesAndValues r4, int r5) {
        Intrinsics.checkNotNullParameter(r2, "runtimeConfigs");
        Intrinsics.checkNotNullParameter(r4, "startupConfigs");
        return new IFeatureGating$Internal$Property(r2, r3, r4, r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof IFeatureGating$Internal$Property) == true) goto L8;
        return false;
    L8:
        IFeatureGating$Internal$Property r6 = (IFeatureGating$Internal$Property) r5;
        if (Intrinsics.areEqual(this.runtimeConfigs, r6.runtimeConfigs) == true) goto L12;
        return false;
    L12:
        if (this.runtimeTimestamp == r6.runtimeTimestamp) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.startupConfigs, r6.startupConfigs) == true) goto L18;
        return false;
    L18:
        if (this.startupTimestamp == r6.startupTimestamp) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((this.runtimeConfigs.hashCode() * 31) + this.runtimeTimestamp) * 31) + this.startupConfigs.hashCode()) * 31) + this.startupTimestamp;
    }

    public String toString() {
        return "Property(runtimeConfigs=" + this.runtimeConfigs + ", runtimeTimestamp=" + this.runtimeTimestamp + ", startupConfigs=" + this.startupConfigs + ", startupTimestamp=" + this.startupTimestamp + ')';
    }

    public final IFeatureGating$Internal$AllStatusesAndValues getRuntimeConfigs() {
        return this.runtimeConfigs;
    }

    public final int getRuntimeTimestamp() {
        return this.runtimeTimestamp;
    }

    public final IFeatureGating$Internal$AllStatusesAndValues getStartupConfigs() {
        return this.startupConfigs;
    }

    public final int getStartupTimestamp() {
        return this.startupTimestamp;
    }

    public IFeatureGating$Internal$Property(IFeatureGating$Internal$AllStatusesAndValues r2, int r3, IFeatureGating$Internal$AllStatusesAndValues r4, int r5) {
        Intrinsics.checkNotNullParameter(r2, "runtimeConfigs");
        Intrinsics.checkNotNullParameter(r4, "startupConfigs");
        this.runtimeConfigs = r2;
        this.runtimeTimestamp = r3;
        this.startupConfigs = r4;
        this.startupTimestamp = r5;
    }
}
