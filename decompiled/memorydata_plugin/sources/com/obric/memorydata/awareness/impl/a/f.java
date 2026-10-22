package com.obric.memorydata.awareness.impl.a;

import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/obric/memorydata/awareness/impl/policy/PackageFeatureEventPolicyRegistration;", "", "feature", "", ObricMemoryConstants.KEY_PACKAGE_NAME, "policy", "Lcom/obric/memorydata/awareness/impl/policy/FeatureEventPolicy;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/obric/memorydata/awareness/impl/policy/FeatureEventPolicy;)V", "getFeature", "()Ljava/lang/String;", "getPackageName", "getPolicy", "()Lcom/obric/memorydata/awareness/impl/policy/FeatureEventPolicy;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f8626a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f8627b;
    private final b c;

    public f(String r3, String r4, b r5) {
        b r6 = (b) ZeusTransformUtils.wrapperContextForParams(r5, b.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "feature");
        Intrinsics.checkNotNullParameter(r4, ObricMemoryConstants.KEY_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(r6, "policy");
        this.f8626a = r3;
        this.f8627b = r4;
        this.c = r6;
    }

    public static /* synthetic */ f a(f r1, String r2, String r3, b r4, int r5, Object r6) {
        b r7 = (b) ZeusTransformUtils.wrapperContextForParams(r4, b.class, "com.obric.memorydata.plugin");
        if ((r5 & 1) == 0) goto L6;
        r2 = r1.f8626a;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = r1.f8627b;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r7 = r1.c;
    L12:
        return r1.a(r2, r3, r7);
    }

    public final f a(String r2, String r3, b r4) {
        b r1 = (b) ZeusTransformUtils.wrapperContextForParams(r4, b.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "feature");
        Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(r1, "policy");
        return new f(r2, r3, r1);
    }

    public final String a() {
        return this.f8626a;
    }

    public final String b() {
        return this.f8627b;
    }

    public final b c() {
        return this.c;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, f.class) == true) goto L8;
        return false;
    L8:
        f r6 = (f) ZeusTransformUtils.preCheckCast(r5, f.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f8626a, r6.f8626a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f8627b, r6.f8627b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((this.f8626a.hashCode() * 31) + this.f8627b.hashCode()) * 31) + this.c.hashCode();
    }

    public String toString() {
        return "PackageFeatureEventPolicyRegistration(feature=" + this.f8626a + ", packageName=" + this.f8627b + ", policy=" + this.c + ')';
    }
}
