package com.obric.memorydata.database.entity;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/obric/memorydata/database/entity/NetworkTypeEntity;", "", "connectionType", "", "timestamp", "", OaidModel.KEY_ID, "<init>", "(IJJ)V", "getConnectionType", "()I", "getTimestamp", "()J", "getId", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ds {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f9042a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f9043b;
    private final long c;

    public ds(int r1, long r2, long r4) {
        this.f9042a = r1;
        this.f9043b = r2;
        this.c = r4;
    }

    public final int a() {
        return this.f9042a;
    }

    public final long b() {
        return this.f9043b;
    }

    public final long c() {
        return this.c;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, ds.class) == true) goto L8;
        return false;
    L8:
        ds r10 = (ds) ZeusTransformUtils.preCheckCast(r9, ds.class, "com.obric.memorydata.plugin");
        if (this.f9042a == r10.f9042a) goto L12;
        return false;
    L12:
        if (this.f9043b == r10.f9043b) goto L15;
        return false;
    L15:
        if (this.c == r10.c) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.f9042a) * 31) + Long.hashCode(this.f9043b)) * 31) + Long.hashCode(this.c);
    }

    public String toString() {
        return "NetworkTypeEntity(connectionType=" + this.f9042a + ", timestamp=" + this.f9043b + ", id=" + this.c + ')';
    }
}
