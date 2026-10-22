package com.obric.memorydata.database.entity;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/obric/memorydata/database/entity/HarStateEntity;", "", "state", "", "timestamp", "", OaidModel.KEY_ID, "<init>", "(IJJ)V", "getState", "()I", "getTimestamp", "()J", "getId", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class bz {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f8956a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f8957b;
    private final long c;

    public bz(int r1, long r2, long r4) {
        this.f8956a = r1;
        this.f8957b = r2;
        this.c = r4;
    }

    public /* synthetic */ bz(int r7, long r8, long r10, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 4) == 0) goto L5;
        r10 = 0;
    L5:
        this(r7, r8, r10);
    }

    public final int a() {
        return this.f8956a;
    }

    public final long b() {
        return this.f8957b;
    }

    public final long c() {
        return this.c;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, bz.class) == true) goto L8;
        return false;
    L8:
        bz r10 = (bz) ZeusTransformUtils.preCheckCast(r9, bz.class, "com.obric.memorydata.plugin");
        if (this.f8956a == r10.f8956a) goto L12;
        return false;
    L12:
        if (this.f8957b == r10.f8957b) goto L15;
        return false;
    L15:
        if (this.c == r10.c) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.f8956a) * 31) + Long.hashCode(this.f8957b)) * 31) + Long.hashCode(this.c);
    }

    public String toString() {
        return "HarStateEntity(state=" + this.f8956a + ", timestamp=" + this.f8957b + ", id=" + this.c + ')';
    }
}
