package com.obric.memorydata.ability.data;

import com.bytedance.bdinstall.Api;
import com.obric.memorydata.database.entity.jj;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002BC\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0004\u0012\b\b\u0002\u0010\t\u001a\u00020\u0004\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0019\u001a\u00020\u0006H\u0016J\b\u0010\u001a\u001a\u00020\u0004H\u0016J\b\u0010\u001b\u001a\u00020\u0004H\u0016J\u0006\u0010\u001c\u001a\u00020\u001dJ\b\u0010\u001e\u001a\u00020\u0018H\u0016J\t\u0010\u001f\u001a\u00020\u0004HÆ\u0003J\t\u0010 \u001a\u00020\u0006HÆ\u0003J\t\u0010!\u001a\u00020\u0006HÆ\u0003J\t\u0010\"\u001a\u00020\u0004HÆ\u0003J\t\u0010#\u001a\u00020\u0004HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0006HÆ\u0003JG\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010&\u001a\u00020\u001d2\b\u0010'\u001a\u0004\u0018\u00010(HÖ\u0003J\t\u0010)\u001a\u00020\u0004HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u000e\u0010\u0015\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/obric/memorydata/ability/data/WifiStandardData;", "Lcom/obric/memorydata/ability/data/IStandardData;", "Lcom/obric/memorydata/ability/IStorageCollectData;", "action", "", "bssid", "", Api.KEY_SSID, "wifiLevel", "wifiRssi", "lastSsid", "<init>", "(ILjava/lang/String;Ljava/lang/String;IILjava/lang/String;)V", "getAction", "()I", "getBssid", "()Ljava/lang/String;", "getSsid", "getWifiLevel", "getWifiRssi", "getLastSsid", "dataId", "dataVersion", "timestamp", "", "toString", "getDataId", "getDataVersion", "bssidIsRight", "", "collectNewData", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "", "hashCode", "ability_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class u implements h, com.obric.memorydata.ability.m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f8352a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f8353b;
    private final String c;
    private final int d;
    private final int e;
    private final String f;
    private final int g;
    private final int h;
    private final long i;

    public u(int r2, String r3, String r4, int r5, int r6, String r7) {
        Intrinsics.checkNotNullParameter(r3, "bssid");
        Intrinsics.checkNotNullParameter(r4, Api.KEY_SSID);
        this.f8352a = r2;
        this.f8353b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = 100000002;
        this.h = 1;
        this.i = System.currentTimeMillis();
    }

    public /* synthetic */ u(int r6, String r7, String r8, int r9, int r10, String r11, int r12, DefaultConstructorMarker r13) {
        String r1 = "";
        if ((r12 & 2) == 0) goto L5;
        String r0 = "";
    L7:
        if ((r12 & 4) != 0) goto L10;
        r1 = r8;
    L10:
        int r3 = -1;
        if ((r12 & 8) == 0) goto L13;
        int r2 = -1;
    L15:
        if ((r12 & 16) != 0) goto L19;
        r3 = r10;
    L19:
        if ((r12 & 32) == 0) goto L21;
        String r4 = null;
    L22:
        this(r6, r0, r1, r2, r3, r4);
        return;
    L21:
        r4 = r11;
        goto L22
    L13:
        r2 = r9;
        goto L15
    L5:
        r0 = r7;
        goto L7
    }

    public final int a() {
        return this.f8352a;
    }

    public final String b() {
        return this.f8353b;
    }

    public final String c() {
        return this.c;
    }

    @Override // com.obric.memorydata.ability.m
    public long collectNewData() {
        return MemoryDbEngine.INSTANCE.getGlobalDbEngine().getWifiDao().insert(new jj(this.g, this.h, this.i, this.f8352a, this.f8353b, this.c, this.d, this.e, 0, 256, null));
    }

    public final boolean d() {
        if (((CharSequence) ZeusTransformUtils.preCheckCast(this.f8353b, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, u.class) == true) goto L8;
        return false;
    L8:
        u r6 = (u) ZeusTransformUtils.preCheckCast(r5, u.class, "com.obric.memorydata.plugin");
        if (this.f8352a == r6.f8352a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f8353b, r6.f8353b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    @Override // com.obric.memorydata.ability.data.h
    public int getDataId() {
        return this.g;
    }

    public int hashCode() {
        int r0 = ((((((((Integer.hashCode(this.f8352a) * 31) + this.f8353b.hashCode()) * 31) + this.c.hashCode()) * 31) + Integer.hashCode(this.d)) * 31) + Integer.hashCode(this.e)) * 31;
        String r2 = this.f;
        if (r2 != null) goto L5;
        int r3 = 0;
    L7:
        return r0 + r3;
    L5:
        r3 = r2.hashCode();
        goto L7
    }

    public String toString() {
        return "WifiStandardData(action=" + this.f8352a + ", wifiLevel=" + this.d + ", wifiRssi=" + this.e + ')';
    }
}
