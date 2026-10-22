package com.obric.memorydata.middleware.api.device;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0006J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\bHÆ\u0003J-\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00122\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001d"}, d2 = {"Lcom/obric/memorydata/middleware/api/device/SelfCollectionConfig;", "", "supportType", "Lcom/obric/memorydata/middleware/api/device/SelfCollectionSupportType;", "supportedEntityTypes", "", "", "packageSpec", "Lcom/obric/memorydata/middleware/api/device/SelfCollectionPackageSpec;", "<init>", "(Lcom/obric/memorydata/middleware/api/device/SelfCollectionSupportType;Ljava/util/Set;Lcom/obric/memorydata/middleware/api/device/SelfCollectionPackageSpec;)V", "getSupportType", "()Lcom/obric/memorydata/middleware/api/device/SelfCollectionSupportType;", "getSupportedEntityTypes", "()Ljava/util/Set;", "getPackageSpec", "()Lcom/obric/memorydata/middleware/api/device/SelfCollectionPackageSpec;", "isSupport", "", "type", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "", "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SelfCollectionSupportType f11606a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Set<Integer> f11607b;
    private final b c;

    public a(SelfCollectionSupportType r3, Set<Integer> r4, b r5) {
        Set<Integer> r6 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "supportType");
        Intrinsics.checkNotNullParameter(r6, "supportedEntityTypes");
        Intrinsics.checkNotNullParameter(r5, "packageSpec");
        this.f11606a = r3;
        this.f11607b = r6;
        this.c = r5;
    }

    public /* synthetic */ a(SelfCollectionSupportType r10, Set r11, b r12, int r13, DefaultConstructorMarker r14) {
        Set r15 = (Set) ZeusTransformUtils.wrapperContextForParams(r11, Set.class, "com.obric.memorydata.plugin");
        if ((r13 & 2) == 0) goto L6;
        r15 = SetsKt.emptySet();
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = new b(null, null, null, null, null, null, 63, null);
    L8:
        this(r10, r15, r12);
    }

    public final SelfCollectionSupportType a() {
        return this.f11606a;
    }

    public final boolean a(int r3) {
        if (this.f11606a != SelfCollectionSupportType.NONE) goto L7;
        return false;
    L7:
        return this.f11607b.contains(Integer.valueOf(r3));
    }

    public final Set<Integer> b() {
        return this.f11607b;
    }

    public final b c() {
        return this.c;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
        return false;
    L8:
        a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
        if (this.f11606a == r6.f11606a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f11607b, r6.f11607b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((this.f11606a.hashCode() * 31) + this.f11607b.hashCode()) * 31) + this.c.hashCode();
    }

    public String toString() {
        return "SelfCollectionConfig(supportType=" + this.f11606a + ", supportedEntityTypes=" + this.f11607b + ", packageSpec=" + this.c + ')';
    }
}
