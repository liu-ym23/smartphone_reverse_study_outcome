package com.obric.memorydata.database.entity;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001a"}, d2 = {"Lcom/obric/memorydata/database/entity/UnionUserInsightEntity;", "", OaidModel.KEY_ID, "", "summary", "", "description", "createTime", "<init>", "(ILjava/lang/String;Ljava/lang/String;I)V", "getId", "()I", "getSummary", "()Ljava/lang/String;", "getDescription", "getCreateTime", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class iw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f9243a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f9244b;
    private final String c;
    private final int d;

    public iw(int r2, String r3, String r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "summary");
        Intrinsics.checkNotNullParameter(r4, "description");
        this.f9243a = r2;
        this.f9244b = r3;
        this.c = r4;
        this.d = r5;
    }

    public /* synthetic */ iw(int r1, String r2, String r3, int r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L5;
        r1 = 0;
    L5:
        this(r1, r2, r3, r4);
    }

    public final int a() {
        return this.f9243a;
    }

    public final String b() {
        return this.f9244b;
    }

    public final String c() {
        return this.c;
    }

    public final int d() {
        return this.d;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, iw.class) == true) goto L8;
        return false;
    L8:
        iw r6 = (iw) ZeusTransformUtils.preCheckCast(r5, iw.class, "com.obric.memorydata.plugin");
        if (this.f9243a == r6.f9243a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f9244b, r6.f9244b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.f9243a) * 31) + this.f9244b.hashCode()) * 31) + this.c.hashCode()) * 31) + Integer.hashCode(this.d);
    }

    public String toString() {
        return "UnionUserInsightEntity(id=" + this.f9243a + ", summary=" + this.f9244b + ", description=" + this.c + ", createTime=" + this.d + ')';
    }
}
