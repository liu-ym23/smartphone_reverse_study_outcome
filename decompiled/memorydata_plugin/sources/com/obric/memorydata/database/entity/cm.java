package com.obric.memorydata.database.entity;

import com.bytedance.bdinstall.Api;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/obric/memorydata/database/entity/MemoryContextSyncPendingEntity;", "", Api.KEY_UUID, "", "operation", "", "sourceUpdateTime", "", "<init>", "(Ljava/lang/String;IJ)V", "getUuid", "()Ljava/lang/String;", "getOperation", "()I", "getSourceUpdateTime", "()J", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class cm {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f8980a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f8981b;
    private final long c;

    public cm(String r2, int r3, long r4) {
        Intrinsics.checkNotNullParameter(r2, Api.KEY_UUID);
        this.f8980a = r2;
        this.f8981b = r3;
        this.c = r4;
    }

    public final String a() {
        return this.f8980a;
    }

    public final int b() {
        return this.f8981b;
    }

    public final long c() {
        return this.c;
    }

    public boolean equals(Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r7, cm.class) == true) goto L8;
        return false;
    L8:
        cm r8 = (cm) ZeusTransformUtils.preCheckCast(r7, cm.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f8980a, r8.f8980a) == true) goto L12;
        return false;
    L12:
        if (this.f8981b == r8.f8981b) goto L15;
        return false;
    L15:
        if (this.c == r8.c) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((this.f8980a.hashCode() * 31) + Integer.hashCode(this.f8981b)) * 31) + Long.hashCode(this.c);
    }

    public String toString() {
        return "MemoryContextSyncPendingEntity(uuid=" + this.f8980a + ", operation=" + this.f8981b + ", sourceUpdateTime=" + this.c + ')';
    }
}
