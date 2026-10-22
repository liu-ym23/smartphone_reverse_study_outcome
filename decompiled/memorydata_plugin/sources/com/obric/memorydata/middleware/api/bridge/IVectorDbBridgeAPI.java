package com.obric.memorydata.middleware.api.bridge;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.news.common.service.manager.IService;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.memorydata.database.entity.ChatMessage;
import java.util.List;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH&J.\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0005H&J$\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH&J.\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0005H&J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\bH&J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u0005H&J \u0010\u000f\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0005H&J\u001a\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0005H&J*\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u0005H&J4\u0010\u001a\u001a\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001eH&JB\u0010\u001f\u001a\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u00052\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00110\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001eH&J\u0010\u0010!\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u0005H&J\u001a\u0010\"\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0005H&J\"\u0010#\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010$\u001a\u0004\u0018\u00010\u0014H&¨\u0006%"}, d2 = {"Lcom/obric/memorydata/middleware/api/bridge/IVectorDbBridgeAPI;", "Lcom/bytedance/news/common/service/manager/IService;", "queryByVector", "", "table", "", "vectorString", "limit", "", "foregroundCallerPkg", "queryByImageVector", "deleteVectorData", "", "rowid", "cleanTable", "insertVectorData", OaidModel.KEY_ID, "", Params.CONTENT, "queryVector", "", "vectorDbName", "key", "insertImageVector", "uri", "sourcePkg", "search", ChatMessage.TYPE_QUERY, "queryType", "extras", "Lorg/json/JSONObject;", "searchWithKeys", "keys", "getVectorDbSize", "searchAndDecrypt", "insertVector", "vector", "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface IVectorDbBridgeAPI extends IService {
    boolean cleanTable(String r1);

    boolean deleteVectorData(String r1, int r2);

    long getVectorDbSize(String r1);

    boolean insertImageVector(String r1, long r2, String r4, String r5);

    boolean insertVector(String r1, long r2, float[] r4);

    boolean insertVectorData(String r1, long r2, String r4);

    List<?> queryByImageVector(String r1, String r2, int r3);

    List<?> queryByImageVector(String r1, String r2, int r3, String r4);

    List<?> queryByVector(String r1, String r2, int r3);

    List<?> queryByVector(String r1, String r2, int r3, String r4);

    float[] queryVector(String r1, String r2);

    List<?> search(String r1, String r2, int r3, String r4, JSONObject r5);

    float[] searchAndDecrypt(String r1, String r2);

    List<?> searchWithKeys(String r1, String r2, List<Long> r3, int r4, String r5, JSONObject r6);
}
