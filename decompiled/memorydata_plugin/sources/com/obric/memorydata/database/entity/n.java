package com.obric.memorydata.database.entity;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\bHÆ\u0003J\t\u0010\u001e\u001a\u00020\nHÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\nHÆ\u0003JO\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\nHÆ\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020\bHÖ\u0001J\t\u0010&\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010R\u0016\u0010\f\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017¨\u0006'"}, d2 = {"Lcom/obric/memorydata/database/entity/AppUsageEntity;", "", ObricMemoryConstants.KEY_PACKAGE_NAME, "", "longitude", "", "latitude", "connectionType", "", "timestamp", "", "state", OaidModel.KEY_ID, "<init>", "(Ljava/lang/String;DDIJLjava/lang/String;J)V", "getPackageName", "()Ljava/lang/String;", "getLongitude", "()D", "getLatitude", "getConnectionType", "()I", "getTimestamp", "()J", "getState", "getId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f9284a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final double f9285b;
    private final double c;
    private final int d;
    private final long e;
    private final String f;
    private final long g;

    public n(String r2, double r3, double r5, int r7, long r8, String r10, long r11) {
        Intrinsics.checkNotNullParameter(r2, ObricMemoryConstants.KEY_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(r10, "state");
        this.f9284a = r2;
        this.f9285b = r3;
        this.c = r5;
        this.d = r7;
        this.e = r8;
        this.f = r10;
        this.g = r11;
    }

    public final String a() {
        return this.f9284a;
    }

    public final double b() {
        return this.f9285b;
    }

    public final double c() {
        return this.c;
    }

    public final int d() {
        return this.d;
    }

    public final long e() {
        return this.e;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, n.class) == true) goto L8;
        return false;
    L8:
        n r10 = (n) ZeusTransformUtils.preCheckCast(r9, n.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f9284a, r10.f9284a) == true) goto L12;
        return false;
    L12:
        if (Double.compare(this.f9285b, r10.f9285b) == 0) goto L15;
        return false;
    L15:
        if (Double.compare(this.c, r10.c) == 0) goto L18;
        return false;
    L18:
        if (this.d == r10.d) goto L21;
        return false;
    L21:
        if (this.e == r10.e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r10.f) == true) goto L27;
        return false;
    L27:
        if (this.g == r10.g) goto L29;
        return false;
    L29:
        return true;
    }

    public final String f() {
        return this.f;
    }

    public final long g() {
        return this.g;
    }

    public int hashCode() {
        return (((((((((((this.f9284a.hashCode() * 31) + Double.hashCode(this.f9285b)) * 31) + Double.hashCode(this.c)) * 31) + Integer.hashCode(this.d)) * 31) + Long.hashCode(this.e)) * 31) + this.f.hashCode()) * 31) + Long.hashCode(this.g);
    }

    public String toString() {
        return "AppUsageEntity(packageName=" + this.f9284a + ", longitude=" + this.f9285b + ", latitude=" + this.c + ", connectionType=" + this.d + ", timestamp=" + this.e + ", state=" + this.f + ", id=" + this.g + ')';
    }
}
