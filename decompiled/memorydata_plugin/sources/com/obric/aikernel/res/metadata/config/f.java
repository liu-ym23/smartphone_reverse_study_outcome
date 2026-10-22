package com.obric.aikernel.res.metadata.config;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/obric/aikernel/res/metadata/config/ModelArtifactSpec;", "", "fileName", "", "expectedMd5", "expectedSize", "", "(Ljava/lang/String;Ljava/lang/String;J)V", "getExpectedMd5", "()Ljava/lang/String;", "getExpectedSize", "()J", "getFileName", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "resource_manager_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f6069a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f6070b;
    private final long c;

    public f(String r2, String r3, long r4) {
        Intrinsics.checkNotNullParameter(r2, "fileName");
        Intrinsics.checkNotNullParameter(r3, "expectedMd5");
        this.f6069a = r2;
        this.f6070b = r3;
        this.c = r4;
    }

    public final String a() {
        return this.f6069a;
    }

    public final String b() {
        return this.f6070b;
    }

    public final long c() {
        return this.c;
    }

    public boolean equals(Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r7, f.class) == true) goto L8;
        return false;
    L8:
        f r8 = (f) ZeusTransformUtils.preCheckCast(r7, f.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f6069a, r8.f6069a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f6070b, r8.f6070b) == true) goto L15;
        return false;
    L15:
        if (this.c == r8.c) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((this.f6069a.hashCode() * 31) + this.f6070b.hashCode()) * 31) + Long.hashCode(this.c);
    }

    public String toString() {
        return "ModelArtifactSpec(fileName=" + this.f6069a + ", expectedMd5=" + this.f6070b + ", expectedSize=" + this.c + ')';
    }
}
