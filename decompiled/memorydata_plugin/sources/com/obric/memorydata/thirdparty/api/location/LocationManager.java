package com.obric.memorydata.thirdparty.api.location;

import com.bytedance.news.common.service.manager.IService;
import com.bytedance.news.common.service.manager.ext.ServiceManagerExtKt;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J)\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H\u0096\u0001J!\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0005H\u0096\u0001J\u0019\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0005H\u0096\u0001¨\u0006\u0013"}, d2 = {"Lcom/obric/memorydata/thirdparty/api/location/LocationManager;", "Lcom/obric/memorydata/thirdparty/api/location/ILocationManager;", "<init>", "()V", "getDistance", "", "longitude1", "latitude1", "longitude2", "latitude2", "isInRange", "", "geoPoint1", "Lcom/obric/memorydata/thirdparty/api/location/GeoPoint;", "geoPoint2", "distance", "isLatLonValid", "latitude", "longitude", "thirdparty_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LocationManager implements ILocationManager {
    public static final LocationManager INSTANCE = null;
    private final /* synthetic */ ILocationManager $$delegate_0;

    static {
        INSTANCE = new LocationManager();
    }

    private LocationManager() {
        IService r0 = ServiceManagerExtKt.impl(Reflection.getOrCreateKotlinClass(ILocationManager.class));
        Intrinsics.checkNotNull(r0);
        this.$$delegate_0 = (ILocationManager) ZeusTransformUtils.preCheckCast(r0, ILocationManager.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.thirdparty.api.location.ILocationManager
    public double getDistance(double r10, double r12, double r14, double r16) {
        return this.$$delegate_0.getDistance(r10, r12, r14, r16);
    }

    @Override // com.obric.memorydata.thirdparty.api.location.ILocationManager
    public boolean isInRange(a r2, a r3, double r4) {
        Intrinsics.checkNotNullParameter(r2, "geoPoint1");
        Intrinsics.checkNotNullParameter(r3, "geoPoint2");
        return this.$$delegate_0.isInRange(r2, r3, r4);
    }

    @Override // com.obric.memorydata.thirdparty.api.location.ILocationManager
    public boolean isLatLonValid(double r1, double r3) {
        return this.$$delegate_0.isLatLonValid(r1, r3);
    }
}
