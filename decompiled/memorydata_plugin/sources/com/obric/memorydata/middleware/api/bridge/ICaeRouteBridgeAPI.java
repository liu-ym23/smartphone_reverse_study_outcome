package com.obric.memorydata.middleware.api.bridge;

import com.bytedance.news.common.service.manager.IService;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001JJ\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u00032\u0006\u0010\r\u001a\u00020\nH&JB\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u00032\u0006\u0010\r\u001a\u00020\nH&¨\u0006\u0010"}, d2 = {"Lcom/obric/memorydata/middleware/api/bridge/ICaeRouteBridgeAPI;", "Lcom/bytedance/news/common/service/manager/IService;", "searchDirection", "Lorg/json/JSONObject;", "oriLat", "", "oriLng", "destLat", "destLng", "inCoordType", "", "outCoordType", "extraInfos", "directionType", "searchDirectionByAddress", "destAddress", "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface ICaeRouteBridgeAPI extends IService {
    JSONObject searchDirection(double r1, double r3, double r5, double r7, String r9, String r10, JSONObject r11, String r12);

    JSONObject searchDirectionByAddress(double r1, double r3, String r5, String r6, String r7, JSONObject r8, String r9);
}
