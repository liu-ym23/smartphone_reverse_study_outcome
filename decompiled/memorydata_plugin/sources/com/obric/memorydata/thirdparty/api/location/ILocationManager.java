package com.obric.memorydata.thirdparty.api.location;

import com.bytedance.news.common.service.manager.IService;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J(\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005H&J \u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0005H&¨\u0006\u0011"}, d2 = {"Lcom/obric/memorydata/thirdparty/api/location/ILocationManager;", "Lcom/bytedance/news/common/service/manager/IService;", "isLatLonValid", "", "latitude", "", "longitude", "getDistance", "longitude1", "latitude1", "longitude2", "latitude2", "isInRange", "geoPoint1", "Lcom/obric/memorydata/thirdparty/api/location/GeoPoint;", "geoPoint2", "distance", "thirdparty_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface ILocationManager extends IService {
    double getDistance(double r1, double r3, double r5, double r7);

    boolean isInRange(a r1, a r2, double r3);

    boolean isLatLonValid(double r1, double r3);
}
