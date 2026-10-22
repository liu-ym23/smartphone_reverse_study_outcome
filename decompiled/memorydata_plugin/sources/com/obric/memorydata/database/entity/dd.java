package com.obric.memorydata.database.entity;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/obric/memorydata/database/entity/MemorySourceImageStatus;", "", "sourceImageHash", "", "rememberedTime", "", "<init>", "(Ljava/lang/String;J)V", "getSourceImageHash", "()Ljava/lang/String;", "getRememberedTime", "()J", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class dd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f9014a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f9015b;

    public dd(String r2, long r3) {
        Intrinsics.checkNotNullParameter(r2, "sourceImageHash");
        this.f9014a = r2;
        this.f9015b = r3;
    }

    public final String a() {
        return this.f9014a;
    }

    public final long b() {
        return this.f9015b;
    }

    public boolean equals(Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r7, dd.class) == true) goto L8;
        return false;
    L8:
        dd r8 = (dd) ZeusTransformUtils.preCheckCast(r7, dd.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f9014a, r8.f9014a) == true) goto L12;
        return false;
    L12:
        if (this.f9015b == r8.f9015b) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.f9014a.hashCode() * 31) + Long.hashCode(this.f9015b);
    }

    public String toString() {
        return "MemorySourceImageStatus(sourceImageHash=" + this.f9014a + ", rememberedTime=" + this.f9015b + ')';
    }
}
