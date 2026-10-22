package com.obric.memorydata.ability.data;

import com.obric.memorydata.database.entity.dr;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0010\u001a\u00020\u0004H\u0016J\b\u0010\u0011\u001a\u00020\u0004H\u0016J\b\u0010\u0012\u001a\u00020\u000fH\u0016J\t\u0010\u0013\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0004HÆ\u0003J'\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0004HÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u000e\u0010\r\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/obric/memorydata/ability/data/NetworkStatusStandardData;", "Lcom/obric/memorydata/ability/data/IStandardData;", "Lcom/obric/memorydata/ability/IStorageCollectData;", "eventType", "", "networkStatus", "activeStatus", "<init>", "(III)V", "getEventType", "()I", "getNetworkStatus", "getActiveStatus", "dataVersion", "timestamp", "", "getDataId", "getDataVersion", "collectNewData", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "", "ability_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class m implements h, com.obric.memorydata.ability.m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f8337a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f8338b;
    private final int c;
    private final int d;
    private final long e;

    public m(int r1, int r2, int r3) {
        this.f8337a = r1;
        this.f8338b = r2;
        this.c = r3;
        this.d = 1;
        this.e = System.currentTimeMillis();
    }

    public final int a() {
        return this.f8338b;
    }

    public final int b() {
        return this.c;
    }

    public int c() {
        return this.d;
    }

    @Override // com.obric.memorydata.ability.m
    public long collectNewData() {
        return MemoryDbEngine.INSTANCE.getGlobalDbEngine().getNetworkStatusDao().insert(new dr(getDataId(), c(), this.e, this.f8337a, this.f8338b, this.c, 0, 64, null));
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, m.class) == true) goto L8;
        return false;
    L8:
        m r6 = (m) ZeusTransformUtils.preCheckCast(r5, m.class, "com.obric.memorydata.plugin");
        if (this.f8337a == r6.f8337a) goto L12;
        return false;
    L12:
        if (this.f8338b == r6.f8338b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L17;
        return false;
    L17:
        return true;
    }

    @Override // com.obric.memorydata.ability.data.h
    public int getDataId() {
        return 100000012;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.f8337a) * 31) + Integer.hashCode(this.f8338b)) * 31) + Integer.hashCode(this.c);
    }

    public String toString() {
        return "NetworkStatusStandardData(eventType=" + this.f8337a + ", networkStatus=" + this.f8338b + ", activeStatus=" + this.c + ')';
    }
}
