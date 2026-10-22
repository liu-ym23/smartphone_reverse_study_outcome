package com.obric.memorydata.awareness.poi;

import com.obric.memorydata.thirdparty.api.location.LocationManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\r\u001a\u00020\u000eH\u0016J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/obric/memorydata/awareness/poi/PoiLocation;", "", "latitude", "", "longitude", "<init>", "(DD)V", "getLatitude", "()D", "getLongitude", "equals", "", "other", "hashCode", "", "component1", "component2", "copy", "toString", "", "Companion", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f8781a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final double f8782b;
    private final double c;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/awareness/poi/PoiLocation$Companion;", "", "<init>", "()V", "LOCATION_PRECISION", "", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f8781a = new a(null);
    }

    public b(double r1, double r3) {
        this.f8782b = r1;
        this.c = r3;
    }

    public boolean equals(Object r12) {
        if (ZeusTransformUtils.instanceOf(r12, b.class) == false) goto L10;
        if (LocationManager.INSTANCE.getDistance(this.c, this.f8782b, ((b) ZeusTransformUtils.preCheckCast(r12, b.class, "com.obric.memorydata.plugin")).c, ((b) ZeusTransformUtils.preCheckCast(r12, b.class, "com.obric.memorydata.plugin")).f8782b) >= 5.0d) goto L7;
        return true;
    L7:
        return false;
    L10:
        return super.equals(r12);
    }

    public int hashCode() {
        return (Double.hashCode(this.f8782b) * 31) + Double.hashCode(this.c);
    }

    public String toString() {
        return "PoiLocation(latitude=" + this.f8782b + ", longitude=" + this.c + ')';
    }
}
