package com.obric.memorydata.database.entity;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J;\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0016\u0010\b\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000f¨\u0006\u001e"}, d2 = {"Lcom/obric/memorydata/database/entity/DeviceShutdownEntity;", "", "dataId", "", "dataVersion", "timestamp", "", "duration", OaidModel.KEY_ID, "<init>", "(IIJJJ)V", "getDataId", "()I", "getDataVersion", "getTimestamp", "()J", "getDuration", "getId", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ay {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f8909a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f8910b;
    private final long c;
    private final long d;
    private final long e;

    public ay(int r1, int r2, long r3, long r5, long r7) {
        this.f8909a = r1;
        this.f8910b = r2;
        this.c = r3;
        this.d = r5;
        this.e = r7;
    }

    public /* synthetic */ ay(int r12, int r13, long r14, long r16, long r18, int r20, DefaultConstructorMarker r21) {
        if ((r20 & 16) == 0) goto L5;
        long r9 = 0;
    L6:
        this(r12, r13, r14, r16, r9);
        return;
    L5:
        r9 = r18;
        goto L6
    }

    public final int a() {
        return this.f8909a;
    }

    public final int b() {
        return this.f8910b;
    }

    public final long c() {
        return this.c;
    }

    public final long d() {
        return this.d;
    }

    public final long e() {
        return this.e;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, ay.class) == true) goto L8;
        return false;
    L8:
        ay r10 = (ay) ZeusTransformUtils.preCheckCast(r9, ay.class, "com.obric.memorydata.plugin");
        if (this.f8909a == r10.f8909a) goto L12;
        return false;
    L12:
        if (this.f8910b == r10.f8910b) goto L15;
        return false;
    L15:
        if (this.c == r10.c) goto L18;
        return false;
    L18:
        if (this.d == r10.d) goto L21;
        return false;
    L21:
        if (this.e == r10.e) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        return (((((((Integer.hashCode(this.f8909a) * 31) + Integer.hashCode(this.f8910b)) * 31) + Long.hashCode(this.c)) * 31) + Long.hashCode(this.d)) * 31) + Long.hashCode(this.e);
    }

    public String toString() {
        return "DeviceShutdownEntity(dataId=" + this.f8909a + ", dataVersion=" + this.f8910b + ", timestamp=" + this.c + ", duration=" + this.d + ", id=" + this.e + ')';
    }
}
