package com.obric.memorydata.database.entity;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/obric/memorydata/database/entity/PredictSleepWakeupEntity;", "", "sleepTime", "", "wakeupTime", "timestamp", OaidModel.KEY_ID, "<init>", "(JJJJ)V", "getSleepTime", "()J", "getWakeupTime", "getTimestamp", "getId", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ep {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f9086a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f9087b;
    private final long c;
    private final long d;

    public ep(long r1, long r3, long r5, long r7) {
        this.f9086a = r1;
        this.f9087b = r3;
        this.c = r5;
        this.d = r7;
    }

    public final long a() {
        return this.f9086a;
    }

    public final long b() {
        return this.f9087b;
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
        if (ZeusTransformUtils.instanceOf(r9, ep.class) == true) goto L8;
        return false;
    L8:
        ep r10 = (ep) ZeusTransformUtils.preCheckCast(r9, ep.class, "com.obric.memorydata.plugin");
        if (this.f9086a == r10.f9086a) goto L12;
        return false;
    L12:
        if (this.f9087b == r10.f9087b) goto L15;
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
        return (((((Long.hashCode(this.f9086a) * 31) + Long.hashCode(this.f9087b)) * 31) + Long.hashCode(this.c)) * 31) + Long.hashCode(this.d);
    }

    public String toString() {
        return "PredictSleepWakeupEntity(sleepTime=" + this.f9086a + ", wakeupTime=" + this.f9087b + ", timestamp=" + this.c + ", id=" + this.d + ')';
    }
}
