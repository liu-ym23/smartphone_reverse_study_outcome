package com.obric.memorydata.awareness.impl.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/obric/memorydata/awareness/impl/policy/PackageFeatureEventPolicyConflict;", "", "feature", "", "selectedPackageName", "ignoredPackageName", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getFeature", "()Ljava/lang/String;", "getSelectedPackageName", "getIgnoredPackageName", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f8624a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f8625b;
    private final String c;

    public e(String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "feature");
        Intrinsics.checkNotNullParameter(r3, "selectedPackageName");
        Intrinsics.checkNotNullParameter(r4, "ignoredPackageName");
        this.f8624a = r2;
        this.f8625b = r3;
        this.c = r4;
    }

    public final String a() {
        return this.f8624a;
    }

    public final String b() {
        return this.f8625b;
    }

    public final String c() {
        return this.c;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, e.class) == true) goto L8;
        return false;
    L8:
        e r6 = (e) ZeusTransformUtils.preCheckCast(r5, e.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f8624a, r6.f8624a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f8625b, r6.f8625b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((this.f8624a.hashCode() * 31) + this.f8625b.hashCode()) * 31) + this.c.hashCode();
    }

    public String toString() {
        return "PackageFeatureEventPolicyConflict(feature=" + this.f8624a + ", selectedPackageName=" + this.f8625b + ", ignoredPackageName=" + this.c + ')';
    }
}
