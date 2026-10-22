package com.obric.memorydata.middleware.api.bridge;

import com.bytedance.crash.entity.EventBody;
import com.bytedance.news.common.service.manager.IService;
import java.util.Set;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u000b\n\u0002\u0010\u0011\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH&J \u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\nH&J \u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\fH&J \u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u000eH&J \u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0010H&J \u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H&J&\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u0013H&J \u0010\u0014\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\nH&J \u0010\u0016\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\fH&J \u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u000eH&J \u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0010H&J \u0010\u0019\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\bH&J \u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0005H&J,\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00132\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u0013H&J\u0010\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u001d\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\u001b\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00050\u001f2\u0006\u0010\u0004\u001a\u00020\u0005H&¢\u0006\u0002\u0010 ¨\u0006!"}, d2 = {"Lcom/obric/memorydata/middleware/api/bridge/IStoreBridgeAPI;", "Lcom/bytedance/news/common/service/manager/IService;", "saveBoolean", "", "repoName", "", "key", EventBody.KEY_VALUE, "", "saveInt", "", "saveLong", "", "saveFloat", "", "saveDouble", "", "saveString", "saveStringSet", "", "getInt", "default", "getLong", "getFloat", "getDouble", "getBoolean", "getString", "getStringSet", "clearAll", "remove", "allKeys", "", "(Ljava/lang/String;)[Ljava/lang/String;", "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface IStoreBridgeAPI extends IService {
    String[] allKeys(String r1);

    void clearAll(String r1);

    boolean getBoolean(String r1, String r2, boolean r3);

    double getDouble(String r1, String r2, double r3);

    float getFloat(String r1, String r2, float r3);

    int getInt(String r1, String r2, int r3);

    long getLong(String r1, String r2, long r3);

    String getString(String r1, String r2, String r3);

    Set<String> getStringSet(String r1, String r2, Set<String> r3);

    boolean remove(String r1, String r2);

    void saveBoolean(String r1, String r2, boolean r3);

    void saveDouble(String r1, String r2, double r3);

    void saveFloat(String r1, String r2, float r3);

    void saveInt(String r1, String r2, int r3);

    void saveLong(String r1, String r2, long r3);

    void saveString(String r1, String r2, String r3);

    void saveStringSet(String r1, String r2, Set<String> r3);
}
