package com.obric.memorydata.database.entity;

import com.bytedance.apm6.util.constant.CommonConsts;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/obric/memorydata/database/entity/CollectMemorySourceStat;", "", "sourcePackageName", "", "sourceAppName", "sourceProductType", "", CommonConsts.COUNT_TYPE, "<init>", "(Ljava/lang/String;Ljava/lang/String;II)V", "getSourcePackageName", "()Ljava/lang/String;", "getSourceAppName", "getSourceProductType", "()I", "getCount", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class al {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f8883a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f8884b;
    private final int c;
    private final int d;

    public al(String r2, String r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r2, "sourcePackageName");
        Intrinsics.checkNotNullParameter(r3, "sourceAppName");
        this.f8883a = r2;
        this.f8884b = r3;
        this.c = r4;
        this.d = r5;
    }

    public final String a() {
        return this.f8883a;
    }

    public final String b() {
        return this.f8884b;
    }

    public final int c() {
        return this.c;
    }

    public final int d() {
        return this.d;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, al.class) == true) goto L8;
        return false;
    L8:
        al r6 = (al) ZeusTransformUtils.preCheckCast(r5, al.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f8883a, r6.f8883a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f8884b, r6.f8884b) == true) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((this.f8883a.hashCode() * 31) + this.f8884b.hashCode()) * 31) + Integer.hashCode(this.c)) * 31) + Integer.hashCode(this.d);
    }

    public String toString() {
        return "CollectMemorySourceStat(sourcePackageName=" + this.f8883a + ", sourceAppName=" + this.f8884b + ", sourceProductType=" + this.c + ", count=" + this.d + ')';
    }
}
