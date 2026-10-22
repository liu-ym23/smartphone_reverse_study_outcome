package com.obric.memorydata.ability.data;

import com.obric.memorydata.database.entity.aw;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\t\u001a\u00020\u0004H\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\t\u0010\r\u001a\u00020\u0004HÆ\u0003J\u0013\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u000bHÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0016"}, d2 = {"Lcom/obric/memorydata/ability/data/DeviceAlarmStandardData;", "Lcom/obric/memorydata/ability/data/IStandardData;", "Lcom/obric/memorydata/ability/IStorageCollectData;", "timestamp", "", "<init>", "(J)V", "getTimestamp", "()J", "collectNewData", "getDataId", "", "getDataVersion", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "ability_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class c implements h, com.obric.memorydata.ability.m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f8322a;

    public c(long r1) {
        this.f8322a = r1;
    }

    public int a() {
        return 1;
    }

    @Override // com.obric.memorydata.ability.m
    public long collectNewData() {
        return MemoryDbEngine.INSTANCE.getGlobalDbEngine().getAlarmDao().insert(new aw(getDataId(), a(), this.f8322a, 0, 8, null));
    }

    public boolean equals(Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r7, c.class) == true) goto L8;
        return false;
    L8:
        c r8 = (c) ZeusTransformUtils.preCheckCast(r7, c.class, "com.obric.memorydata.plugin");
        if (this.f8322a == r8.f8322a) goto L11;
        return false;
    L11:
        return true;
    }

    @Override // com.obric.memorydata.ability.data.h
    public int getDataId() {
        return 100001009;
    }

    public int hashCode() {
        return Long.hashCode(this.f8322a);
    }

    public String toString() {
        return "DeviceAlarmStandardData(timestamp=" + this.f8322a + ')';
    }
}
