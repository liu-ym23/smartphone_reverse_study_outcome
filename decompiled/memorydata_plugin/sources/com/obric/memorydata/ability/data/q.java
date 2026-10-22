package com.obric.memorydata.ability.data;

import com.bytedance.crash.entity.EventBody;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.memorydata.database.entity.im;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0010\u001a\u00020\u0006H\u0016J\b\u0010\u0011\u001a\u00020\u0006H\u0016J\b\u0010\u0012\u001a\u00020\u000fH\u0016J\t\u0010\u0013\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\u001d\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0004HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/obric/memorydata/ability/data/SettingsChangedStandardData;", "Lcom/obric/memorydata/ability/data/IStandardData;", "Lcom/obric/memorydata/ability/IStorageCollectData;", ActivityLifecycle.NAME, "", EventBody.KEY_VALUE, "", "<init>", "(Ljava/lang/String;I)V", "getName", "()Ljava/lang/String;", "getValue", "()I", "dataVersion", "timestamp", "", "getDataId", "getDataVersion", "collectNewData", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "ability_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class q implements h, com.obric.memorydata.ability.m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f8344a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f8345b;
    private final int c;
    private final long d;

    public q(String r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, ActivityLifecycle.NAME);
        this.f8344a = r2;
        this.f8345b = r3;
        this.c = 1;
        this.d = System.currentTimeMillis();
    }

    public int a() {
        return this.c;
    }

    @Override // com.obric.memorydata.ability.m
    public long collectNewData() {
        return MemoryDbEngine.INSTANCE.getGlobalDbEngine().getSettingsChangedDao().insert(new im(getDataId(), a(), this.d, this.f8344a, this.f8345b, 0, 32, null));
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, q.class) == true) goto L8;
        return false;
    L8:
        q r6 = (q) ZeusTransformUtils.preCheckCast(r5, q.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f8344a, r6.f8344a) == true) goto L12;
        return false;
    L12:
        if (this.f8345b == r6.f8345b) goto L14;
        return false;
    L14:
        return true;
    }

    @Override // com.obric.memorydata.ability.data.h
    public int getDataId() {
        return 100001007;
    }

    public int hashCode() {
        return (this.f8344a.hashCode() * 31) + Integer.hashCode(this.f8345b);
    }

    public String toString() {
        return "SettingsChangedStandardData(name=" + this.f8344a + ", value=" + this.f8345b + ')';
    }
}
