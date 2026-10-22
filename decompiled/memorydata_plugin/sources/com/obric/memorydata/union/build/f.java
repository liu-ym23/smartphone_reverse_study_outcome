package com.obric.memorydata.union.build;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001\u000eB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0002\u0010\nJ'\u0010\u000b\u001a\u00020\f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0002\u0010\r¨\u0006\u000f"}, d2 = {"Lcom/obric/memorydata/union/build/MemoryBuildProductTypeResolver;", "", "<init>", "()V", "resolveDbProductType", "", "businessType", "", "oldProductType", "mappedProductType", "(Ljava/lang/String;Ljava/lang/Integer;I)I", "resolveRuntimeAndDbProductTypes", "Lcom/obric/memorydata/union/build/MemoryBuildProductTypeResolver$ProductTypes;", "(Ljava/lang/String;Ljava/lang/Integer;I)Lcom/obric/memorydata/union/build/MemoryBuildProductTypeResolver$ProductTypes;", "ProductTypes", "memory_build_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f13087a = null;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/obric/memorydata/union/build/MemoryBuildProductTypeResolver$ProductTypes;", "", "runtimeProductType", "", "dbProductType", "<init>", "(II)V", "getRuntimeProductType", "()I", "getDbProductType", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "memory_build_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f13088a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f13089b;

        public a(int r1, int r2) {
            this.f13088a = r1;
            this.f13089b = r2;
        }

        public final int a() {
            return this.f13088a;
        }

        public final int b() {
            return this.f13089b;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
            if (this.f13088a == r6.f13088a) goto L12;
            return false;
        L12:
            if (this.f13089b == r6.f13089b) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (Integer.hashCode(this.f13088a) * 31) + Integer.hashCode(this.f13089b);
        }

        public String toString() {
            return "ProductTypes(runtimeProductType=" + this.f13088a + ", dbProductType=" + this.f13089b + ')';
        }
    }

    static {
        f13087a = new f();
    }

    private f() {
    }

    public final int a(String r1, Integer r2, int r3) {
        if (Intrinsics.areEqual(r1, "screenObservation") == false) goto L5;
        return 1001;
    L5:
        if (r2 != null) goto L7;
        return r3;
    L7:
        return r2.intValue();
    }

    public final a b(String r3, Integer r4, int r5) {
        if (Intrinsics.areEqual(r3, "screenObservation") == false) goto L5;
        int r1 = 1001;
    L7:
        return new a(r1, a(r3, r4, r5));
    L5:
        r1 = r5;
        goto L7
    }
}
