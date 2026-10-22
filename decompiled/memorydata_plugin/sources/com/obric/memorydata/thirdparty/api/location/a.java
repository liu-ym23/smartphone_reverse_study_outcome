package com.obric.memorydata.thirdparty.api.location;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0006H\u0016J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J'\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/obric/memorydata/thirdparty/api/location/GeoPoint;", "", "latitude", "", "longitude", "radius", "", "<init>", "(DDI)V", "getLatitude", "()D", "getLongitude", "getRadius", "()I", "equals", "", "other", "hashCode", "component1", "component2", "component3", "copy", "toString", "", "thirdparty_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final double f12973a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final double f12974b;
    private final int c;

    public final double a() {
        return this.f12973a;
    }

    public final double b() {
        return this.f12974b;
    }

    public boolean equals(Object r8) {
        if (r8 != null) goto L5;
        return false;
    L5:
        if (ZeusTransformUtils.instanceOf(r8, a.class) == true) goto L8;
        return false;
    L8:
        if (this.f12973a != ((a) ZeusTransformUtils.preCheckCast(r8, a.class, "com.obric.memorydata.plugin")).f12973a) goto L10;
        boolean r2 = true;
    L11:
        if (r2 == true) goto L13;
        return false;
    L13:
        if (this.f12974b != ((a) ZeusTransformUtils.preCheckCast(r8, a.class, "com.obric.memorydata.plugin")).f12974b) goto L15;
        boolean r7 = true;
    L16:
        if (r7 == true) goto L18;
        return false;
    L18:
        return true;
    L15:
        r7 = false;
        goto L16
    L10:
        r2 = false;
        goto L11
    }

    public int hashCode() {
        return Objects.hash(new Object[]{Double.valueOf(this.f12973a), Double.valueOf(this.f12974b)});
    }

    public String toString() {
        return "GeoPoint(latitude=" + this.f12973a + ", longitude=" + this.f12974b + ", radius=" + this.c + ')';
    }
}
