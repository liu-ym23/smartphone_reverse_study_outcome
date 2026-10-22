package com.bytedance.bdlocation.entity;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.cae.location.database.StarLocationDbManager;
import com.qualcomm.qti.qesdk.QesdkUtils;
import ia.b;

/* JADX INFO: loaded from: classes.dex */
public class GeoPoiEntity {

    @b(StarLocationDbManager.GeofenceEntry.ADDRESS)
    public String address;

    @b("area")
    public String area;

    @b("aweme_id")
    public String awemeId;

    @b("businessarea")
    public String businessArea;

    @b("distance")
    public Double distance;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @b("id")
    public String f3806id;

    @b(LocationMonitorConst.LOCATION)
    public String location;

    @b(QesdkUtils.TAGS.JSON_TAG_NAME)
    public String name;

    @b("poiweight")
    public String poiWeight;

    @b(WsConstants.KEY_SESSION_ID)
    public String sId;

    @b("source")
    public String source;

    @b("tel")
    public String tel;

    @b("typecode")
    public String typeCode;

    public GeoPoiEntity() {
    }
}
