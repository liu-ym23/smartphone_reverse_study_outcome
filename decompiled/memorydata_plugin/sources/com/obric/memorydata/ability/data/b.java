package com.obric.memorydata.ability.data;

import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.memorydata.database.entity.af;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B/\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0017\u001a\u00020\u0004H\u0016J\b\u0010\u0018\u001a\u00020\u0004H\u0016J\b\u0010\u0019\u001a\u00020\u0016H\u0016J\b\u0010\u001a\u001a\u00020\u0016H\u0016J\t\u0010\u001b\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0004HÆ\u0003J;\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u0004HÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$HÖ\u0003J\t\u0010%\u001a\u00020\u0004HÖ\u0001J\t\u0010&\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u000e\u0010\u0013\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/obric/memorydata/ability/data/BluetoothDeviceStandardData;", "Lcom/obric/memorydata/ability/data/IStandardData;", "Lcom/obric/memorydata/ability/IStorageCollectData;", "state", "", "mac", "", ActivityLifecycle.NAME, "type", "enable", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getState", "()I", "getMac", "()Ljava/lang/String;", "getName", "getType", "getEnable", "dataId", "dataVersion", "timestamp", "", "getDataId", "getDataVersion", "getDataTimestamp", "collectNewData", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "toString", "ability_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b implements h, com.obric.memorydata.ability.m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f8320a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f8321b;
    private final String c;
    private final String d;
    private final int e;
    private final int f;
    private final int g;
    private final long h;

    public b(int r2, String r3, String r4, String r5, int r6) {
        Intrinsics.checkNotNullParameter(r3, "mac");
        Intrinsics.checkNotNullParameter(r4, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r5, "type");
        this.f8320a = r2;
        this.f8321b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = 100000007;
        this.g = 1;
        this.h = System.currentTimeMillis();
    }

    public final int a() {
        return this.e;
    }

    @Override // com.obric.memorydata.ability.m
    public long collectNewData() {
        return MemoryDbEngine.INSTANCE.getGlobalDbEngine().getBluetoothDeviceDao().insert(new af(this.f, this.g, this.h, this.f8320a, this.f8321b, this.c, this.d, this.e, 0, 256, null));
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
        return false;
    L8:
        b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin");
        if (this.f8320a == r6.f8320a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f8321b, r6.f8321b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L23;
        return false;
    L23:
        return true;
    }

    @Override // com.obric.memorydata.ability.data.h
    public int getDataId() {
        return this.f;
    }

    public final String getType() {
        return this.d;
    }

    public int hashCode() {
        return (((((((Integer.hashCode(this.f8320a) * 31) + this.f8321b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + Integer.hashCode(this.e);
    }

    public String toString() {
        return "BluetoothDeviceStandardData(state=" + this.f8320a + ", mac=" + this.f8321b + ", name=" + this.c + ", type=" + this.d + ", enable=" + this.e + ')';
    }
}
