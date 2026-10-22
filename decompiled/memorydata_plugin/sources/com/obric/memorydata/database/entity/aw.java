package com.obric.memorydata.database.entity;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcom/obric/memorydata/database/entity/DeviceAlarmEntity;", "", "dataId", "", "dataVersion", "timestamp", "", OaidModel.KEY_ID, "<init>", "(IIJJ)V", "getDataId", "()I", "getDataVersion", "getTimestamp", "()J", "getId", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class aw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f8905a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f8906b;
    private final long c;
    private final long d;

    public aw(int r1, int r2, long r3, long r5) {
        this.f8905a = r1;
        this.f8906b = r2;
        this.c = r3;
        this.d = r5;
    }

    public /* synthetic */ aw(int r8, int r9, long r10, long r12, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 8) == 0) goto L5;
        r12 = 0;
    L5:
        this(r8, r9, r10, r12);
    }

    public final int a() {
        return this.f8905a;
    }

    public final int b() {
        return this.f8906b;
    }

    public final long c() {
        return this.c;
    }

    public final long d() {
        return this.d;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, aw.class) == true) goto L8;
        return false;
    L8:
        aw r10 = (aw) ZeusTransformUtils.preCheckCast(r9, aw.class, "com.obric.memorydata.plugin");
        if (this.f8905a == r10.f8905a) goto L12;
        return false;
    L12:
        if (this.f8906b == r10.f8906b) goto L15;
        return false;
    L15:
        if (this.c == r10.c) goto L18;
        return false;
    L18:
        if (this.d == r10.d) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.f8905a) * 31) + Integer.hashCode(this.f8906b)) * 31) + Long.hashCode(this.c)) * 31) + Long.hashCode(this.d);
    }

    public String toString() {
        return "DeviceAlarmEntity(dataId=" + this.f8905a + ", dataVersion=" + this.f8906b + ", timestamp=" + this.c + ", id=" + this.d + ')';
    }
}
