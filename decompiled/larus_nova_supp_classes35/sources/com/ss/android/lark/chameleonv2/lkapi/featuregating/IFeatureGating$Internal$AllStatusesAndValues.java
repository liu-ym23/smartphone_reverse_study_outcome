package com.ss.android.lark.chameleonv2.lkapi.featuregating;

import com.bytedance.ee.util.io.NonProguard;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\"\u0010\u0002\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005`\u0006\u0012\"\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u0006¢\u0006\u0004\b\b\u0010\tJ%\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005`\u0006HÆ\u0003J%\u0010\u000e\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u0006HÆ\u0003JU\u0010\u000f\u001a\u00020\u00002$\b\u0002\u0010\u0002\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005`\u00062$\b\u0002\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u0006HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0004HÖ\u0001R-\u0010\u0002\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005`\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR-\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/featuregating/IFeatureGating$Internal$AllStatusesAndValues;", "Lcom/bytedance/ee/util/io/NonProguard;", "statuses", "Ljava/util/HashMap;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "Lkotlin/collections/HashMap;", "values", "<init>", "(Ljava/util/HashMap;Ljava/util/HashMap;)V", "getStatuses", "()Ljava/util/HashMap;", "getValues", "component1", "component2", "copy", "equals", "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", "larkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IFeatureGating$Internal$AllStatusesAndValues implements NonProguard {
    private final HashMap<String, Boolean> statuses;
    private final HashMap<String, String> values;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ IFeatureGating$Internal$AllStatusesAndValues copy$default(IFeatureGating$Internal$AllStatusesAndValues r0, HashMap r1, HashMap r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.statuses;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.values;
    L9:
        return r0.copy(r1, r2);
    }

    public final HashMap<String, Boolean> component1() {
        return this.statuses;
    }

    public final HashMap<String, String> component2() {
        return this.values;
    }

    public final IFeatureGating$Internal$AllStatusesAndValues copy(HashMap<String, Boolean> r2, HashMap<String, String> r3) {
        Intrinsics.checkNotNullParameter(r2, "statuses");
        Intrinsics.checkNotNullParameter(r3, "values");
        return new IFeatureGating$Internal$AllStatusesAndValues(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof IFeatureGating$Internal$AllStatusesAndValues) == true) goto L8;
        return false;
    L8:
        IFeatureGating$Internal$AllStatusesAndValues r6 = (IFeatureGating$Internal$AllStatusesAndValues) r5;
        if (Intrinsics.areEqual(this.statuses, r6.statuses) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.values, r6.values) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.statuses.hashCode() * 31) + this.values.hashCode();
    }

    public String toString() {
        return "AllStatusesAndValues(statuses=" + this.statuses + ", values=" + this.values + ')';
    }

    public final HashMap<String, Boolean> getStatuses() {
        return this.statuses;
    }

    public final HashMap<String, String> getValues() {
        return this.values;
    }

    public IFeatureGating$Internal$AllStatusesAndValues(HashMap<String, Boolean> r2, HashMap<String, String> r3) {
        Intrinsics.checkNotNullParameter(r2, "statuses");
        Intrinsics.checkNotNullParameter(r3, "values");
        this.statuses = r2;
        this.values = r3;
    }
}
