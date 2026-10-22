package com.obric.memorydata.database.entity;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0019\u001a\u00020\bHÆ\u0003J\t\u0010\u001a\u001a\u00020\bHÆ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÆ\u0003JE\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0006HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\n\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011¨\u0006#"}, d2 = {"Lcom/obric/memorydata/database/entity/BssidCalcCacheEntity;", "", OaidModel.KEY_ID, "", "timestamp", "bssid", "", "longitude", "", "latitude", EventBody.KEY_VALUE, "<init>", "(JJLjava/lang/String;DDLjava/lang/String;)V", "getId", "()J", "getTimestamp", "getBssid", "()Ljava/lang/String;", "getLongitude", "()D", "getLatitude", "getValue", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ag {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f8875a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f8876b;
    private final String c;
    private final double d;
    private final double e;
    private final String f;

    public ag(long r2, long r4, String r6, double r7, double r9, String r11) {
        Intrinsics.checkNotNullParameter(r6, "bssid");
        Intrinsics.checkNotNullParameter(r11, EventBody.KEY_VALUE);
        this.f8875a = r2;
        this.f8876b = r4;
        this.c = r6;
        this.d = r7;
        this.e = r9;
        this.f = r11;
    }

    public final long a() {
        return this.f8875a;
    }

    public final long b() {
        return this.f8876b;
    }

    public final String c() {
        return this.c;
    }

    public final double d() {
        return this.d;
    }

    public final double e() {
        return this.e;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, ag.class) == true) goto L8;
        return false;
    L8:
        ag r10 = (ag) ZeusTransformUtils.preCheckCast(r9, ag.class, "com.obric.memorydata.plugin");
        if (this.f8875a == r10.f8875a) goto L12;
        return false;
    L12:
        if (this.f8876b == r10.f8876b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r10.c) == true) goto L18;
        return false;
    L18:
        if (Double.compare(this.d, r10.d) == 0) goto L21;
        return false;
    L21:
        if (Double.compare(this.e, r10.e) == 0) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r10.f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final String f() {
        return this.f;
    }

    public int hashCode() {
        return (((((((((Long.hashCode(this.f8875a) * 31) + Long.hashCode(this.f8876b)) * 31) + this.c.hashCode()) * 31) + Double.hashCode(this.d)) * 31) + Double.hashCode(this.e)) * 31) + this.f.hashCode();
    }

    public String toString() {
        return "BssidCalcCacheEntity(id=" + this.f8875a + ", timestamp=" + this.f8876b + ", bssid=" + this.c + ", longitude=" + this.d + ", latitude=" + this.e + ", value=" + this.f + ')';
    }
}
