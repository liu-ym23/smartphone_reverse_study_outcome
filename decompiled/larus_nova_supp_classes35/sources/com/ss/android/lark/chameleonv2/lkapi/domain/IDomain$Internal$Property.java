package com.ss.android.lark.chameleonv2.lkapi.domain;

import com.bytedance.ee.util.io.NonProguard;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u008f\u0001\u0012B\u0010\u0002\u001a>\u0012\u0004\u0012\u00020\u0004\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00040\u0005j\b\u0012\u0004\u0012\u00020\u0004`\u00060\u0003j\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00040\u0005j\b\u0012\u0004\u0012\u00020\u0004`\u0006`\u0007\u0012B\u0010\b\u001a>\u0012\u0004\u0012\u00020\u0004\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00040\u0005j\b\u0012\u0004\u0012\u00020\u0004`\u00060\u0003j\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00040\u0005j\b\u0012\u0004\u0012\u00020\u0004`\u0006`\u0007¢\u0006\u0004\b\t\u0010\nJE\u0010\u000e\u001a>\u0012\u0004\u0012\u00020\u0004\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00040\u0005j\b\u0012\u0004\u0012\u00020\u0004`\u00060\u0003j\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00040\u0005j\b\u0012\u0004\u0012\u00020\u0004`\u0006`\u0007HÆ\u0003JE\u0010\u000f\u001a>\u0012\u0004\u0012\u00020\u0004\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00040\u0005j\b\u0012\u0004\u0012\u00020\u0004`\u00060\u0003j\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00040\u0005j\b\u0012\u0004\u0012\u00020\u0004`\u0006`\u0007HÆ\u0003J\u0095\u0001\u0010\u0010\u001a\u00020\u00002D\b\u0002\u0010\u0002\u001a>\u0012\u0004\u0012\u00020\u0004\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00040\u0005j\b\u0012\u0004\u0012\u00020\u0004`\u00060\u0003j\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00040\u0005j\b\u0012\u0004\u0012\u00020\u0004`\u0006`\u00072D\b\u0002\u0010\b\u001a>\u0012\u0004\u0012\u00020\u0004\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00040\u0005j\b\u0012\u0004\u0012\u00020\u0004`\u00060\u0003j\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00040\u0005j\b\u0012\u0004\u0012\u00020\u0004`\u0006`\u0007HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0004HÖ\u0001RM\u0010\u0002\u001a>\u0012\u0004\u0012\u00020\u0004\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00040\u0005j\b\u0012\u0004\u0012\u00020\u0004`\u00060\u0003j\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00040\u0005j\b\u0012\u0004\u0012\u00020\u0004`\u0006`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fRM\u0010\b\u001a>\u0012\u0004\u0012\u00020\u0004\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00040\u0005j\b\u0012\u0004\u0012\u00020\u0004`\u00060\u0003j\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00040\u0005j\b\u0012\u0004\u0012\u00020\u0004`\u0006`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/domain/IDomain$Internal$Property;", "Lcom/bytedance/ee/util/io/NonProguard;", "packageConfigs", "Ljava/util/HashMap;", BuildConfig.FLAVOR, "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Lkotlin/collections/HashMap;", "runtimeConfigs", "<init>", "(Ljava/util/HashMap;Ljava/util/HashMap;)V", "getPackageConfigs", "()Ljava/util/HashMap;", "getRuntimeConfigs", "component1", "component2", "copy", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", "larkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IDomain$Internal$Property implements NonProguard {
    private final HashMap<String, ArrayList<String>> packageConfigs;
    private final HashMap<String, ArrayList<String>> runtimeConfigs;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ IDomain$Internal$Property copy$default(IDomain$Internal$Property r0, HashMap r1, HashMap r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.packageConfigs;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.runtimeConfigs;
    L9:
        return r0.copy(r1, r2);
    }

    public final HashMap<String, ArrayList<String>> component1() {
        return this.packageConfigs;
    }

    public final HashMap<String, ArrayList<String>> component2() {
        return this.runtimeConfigs;
    }

    public final IDomain$Internal$Property copy(HashMap<String, ArrayList<String>> r2, HashMap<String, ArrayList<String>> r3) {
        Intrinsics.checkNotNullParameter(r2, "packageConfigs");
        Intrinsics.checkNotNullParameter(r3, "runtimeConfigs");
        return new IDomain$Internal$Property(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof IDomain$Internal$Property) == true) goto L8;
        return false;
    L8:
        IDomain$Internal$Property r6 = (IDomain$Internal$Property) r5;
        if (Intrinsics.areEqual(this.packageConfigs, r6.packageConfigs) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.runtimeConfigs, r6.runtimeConfigs) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.packageConfigs.hashCode() * 31) + this.runtimeConfigs.hashCode();
    }

    public String toString() {
        return "Property(packageConfigs=" + this.packageConfigs + ", runtimeConfigs=" + this.runtimeConfigs + ')';
    }

    public final HashMap<String, ArrayList<String>> getPackageConfigs() {
        return this.packageConfigs;
    }

    public final HashMap<String, ArrayList<String>> getRuntimeConfigs() {
        return this.runtimeConfigs;
    }

    public IDomain$Internal$Property(HashMap<String, ArrayList<String>> r2, HashMap<String, ArrayList<String>> r3) {
        Intrinsics.checkNotNullParameter(r2, "packageConfigs");
        Intrinsics.checkNotNullParameter(r3, "runtimeConfigs");
        this.packageConfigs = r2;
        this.runtimeConfigs = r3;
    }
}
