package com.obric.memorydata.union.build.storage;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/obric/memorydata/union/build/storage/SemanticProducerFields;", "", "description", "", "confidence", "", "<init>", "(Ljava/lang/String;F)V", "getDescription", "()Ljava/lang/String;", "getConfidence", "()F", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "memory_build_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f13137a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f13138b;

    public r(String r2, float r3) {
        Intrinsics.checkNotNullParameter(r2, "description");
        this.f13137a = r2;
        this.f13138b = r3;
    }

    public final String a() {
        return this.f13137a;
    }

    public final float b() {
        return this.f13138b;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, r.class) == true) goto L8;
        return false;
    L8:
        r r6 = (r) ZeusTransformUtils.preCheckCast(r5, r.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f13137a, r6.f13137a) == true) goto L12;
        return false;
    L12:
        if (Float.compare(this.f13138b, r6.f13138b) == 0) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.f13137a.hashCode() * 31) + Float.hashCode(this.f13138b);
    }

    public String toString() {
        return "SemanticProducerFields(description=" + this.f13137a + ", confidence=" + this.f13138b + ')';
    }
}
