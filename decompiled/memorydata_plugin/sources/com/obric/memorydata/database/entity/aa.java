package com.obric.memorydata.database.entity;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0019\u001a\u00020\bHÆ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003JE\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\bHÖ\u0001J\t\u0010!\u001a\u00020\u0006HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\t\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000e¨\u0006\""}, d2 = {"Lcom/obric/memorydata/database/entity/AutoMemoryProSnapShotEntity;", "", OaidModel.KEY_ID, "", "autoMemoryProId", "entityId", "", "version", "", "snapshotJson", "snapshotTime", "<init>", "(JJLjava/lang/String;ILjava/lang/String;J)V", "getId", "()J", "getAutoMemoryProId", "getEntityId", "()Ljava/lang/String;", "getVersion", "()I", "getSnapshotJson", "getSnapshotTime", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class aa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f8863a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f8864b;
    private final String c;
    private final int d;
    private final String e;
    private final long f;

    public aa(long r2, long r4, String r6, int r7, String r8, long r9) {
        Intrinsics.checkNotNullParameter(r6, "entityId");
        Intrinsics.checkNotNullParameter(r8, "snapshotJson");
        this.f8863a = r2;
        this.f8864b = r4;
        this.c = r6;
        this.d = r7;
        this.e = r8;
        this.f = r9;
    }

    public /* synthetic */ aa(long r13, long r15, String r17, int r18, String r19, long r20, int r22, DefaultConstructorMarker r23) {
        if ((r22 & 1) == 0) goto L5;
        long r3 = 0;
    L6:
        this(r3, r15, r17, r18, r19, r20);
        return;
    L5:
        r3 = r13;
        goto L6
    }

    public final long a() {
        return this.f8863a;
    }

    public final long b() {
        return this.f8864b;
    }

    public final String c() {
        return this.c;
    }

    public final int d() {
        return this.d;
    }

    public final String e() {
        return this.e;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, aa.class) == true) goto L8;
        return false;
    L8:
        aa r10 = (aa) ZeusTransformUtils.preCheckCast(r9, aa.class, "com.obric.memorydata.plugin");
        if (this.f8863a == r10.f8863a) goto L12;
        return false;
    L12:
        if (this.f8864b == r10.f8864b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r10.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r10.d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r10.e) == true) goto L24;
        return false;
    L24:
        if (this.f == r10.f) goto L26;
        return false;
    L26:
        return true;
    }

    public final long f() {
        return this.f;
    }

    public int hashCode() {
        return (((((((((Long.hashCode(this.f8863a) * 31) + Long.hashCode(this.f8864b)) * 31) + this.c.hashCode()) * 31) + Integer.hashCode(this.d)) * 31) + this.e.hashCode()) * 31) + Long.hashCode(this.f);
    }

    public String toString() {
        return "AutoMemoryProSnapShotEntity(id=" + this.f8863a + ", autoMemoryProId=" + this.f8864b + ", entityId=" + this.c + ", version=" + this.d + ", snapshotJson=" + this.e + ", snapshotTime=" + this.f + ')';
    }
}
