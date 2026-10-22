package com.obric.memorydata.awareness.cae;

import com.obric.cae.libs.location.geofence.StarGeofence;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J8\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\u000b¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/awareness/cae/HomeCompanyFenceSelector;", "", "<init>", "()V", "selectCurrentFence", "Lcom/obric/cae/libs/location/geofence/StarGeofence;", "homeFence", "extraHomeFence", "companyFence", "transportHubCompanyFence", "companyFenceHandledByTransportHubAoi", "", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f8573a = null;

    static {
        f8573a = new e();
    }

    private e() {
    }

    public final StarGeofence a(StarGeofence r3, StarGeofence r4, StarGeofence r5, StarGeofence r6, boolean r7) {
        if (r3 == null) goto L5;
        StarGeofence.GeoState r0 = r3.getGeoState();
    L7:
        if (r0 == StarGeofence.GeoState.INSIDE) goto L34;
        if (r4 == null) goto L11;
        StarGeofence.GeoState r8 = r4.getGeoState();
    L13:
        if (r8 == StarGeofence.GeoState.INSIDE) goto L31;
        if (r7 == false) goto L24;
        if (r6 == null) goto L33;
        if (r6.getGeoState() != StarGeofence.GeoState.INSIDE) goto L20;
        boolean r9 = true;
    L21:
        if (r9 == false) goto L33;
        return r6;
    L20:
        r9 = false;
    L33:
        return null;
    L24:
        if (r5 == null) goto L26;
        StarGeofence.GeoState r10 = r5.getGeoState();
    L28:
        if (r10 != StarGeofence.GeoState.INSIDE) goto L33;
        return r5;
    L26:
        r10 = null;
        goto L28
    L31:
        return r4;
    L11:
        r8 = null;
        goto L13
    L34:
        return r3;
    L5:
        r0 = null;
        goto L7
    }
}
