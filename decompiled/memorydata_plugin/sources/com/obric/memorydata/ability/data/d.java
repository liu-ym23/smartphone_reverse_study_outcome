package com.obric.memorydata.ability.data;

import com.obric.memorydata.database.entity.ax;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\f\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\nH\u0016J\b\u0010\u000e\u001a\u00020\u0004H\u0016J\t\u0010\u000f\u001a\u00020\u0004HÆ\u0003J\u0013\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\nHÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/obric/memorydata/ability/data/DeviceBootStandardData;", "Lcom/obric/memorydata/ability/data/IStandardData;", "Lcom/obric/memorydata/ability/IStorageCollectData;", "timestamp", "", "<init>", "(J)V", "getTimestamp", "()J", "dataId", "", "dataVersion", "getDataId", "getDataVersion", "collectNewData", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "ability_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class d implements h, com.obric.memorydata.ability.m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f8323a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f8324b;
    private final int c;

    public d(long r1) {
        this.f8323a = r1;
        this.f8324b = 100001005;
        this.c = 1;
    }

    public int a() {
        return this.c;
    }

    @Override // com.obric.memorydata.ability.m
    public long collectNewData() {
        return MemoryDbEngine.INSTANCE.getGlobalDbEngine().getDeviceBootDao().insert(new ax(getDataId(), a(), this.f8323a, 0, 8, null));
    }

    public boolean equals(Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r7, d.class) == true) goto L8;
        return false;
    L8:
        d r8 = (d) ZeusTransformUtils.preCheckCast(r7, d.class, "com.obric.memorydata.plugin");
        if (this.f8323a == r8.f8323a) goto L11;
        return false;
    L11:
        return true;
    }

    @Override // com.obric.memorydata.ability.data.h
    public int getDataId() {
        return this.f8324b;
    }

    public int hashCode() {
        return Long.hashCode(this.f8323a);
    }

    public String toString() {
        return "DeviceBootStandardData(timestamp=" + this.f8323a + ')';
    }
}
