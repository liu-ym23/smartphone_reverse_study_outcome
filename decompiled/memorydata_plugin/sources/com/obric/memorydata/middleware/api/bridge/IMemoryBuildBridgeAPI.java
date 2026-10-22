package com.obric.memorydata.middleware.api.bridge;

import com.bytedance.news.common.service.manager.IService;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import java.util.Set;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\"\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u0007H&J\u001f\u0010\r\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H&¢\u0006\u0002\u0010\u0011J\"\u0010\u0012\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0010H&J\u0017\u0010\u0016\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0017\u001a\u00020\u0003H&¢\u0006\u0002\u0010\u0018J)\u0010\u0019\u001a\u0004\u0018\u00010\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u0003H&¢\u0006\u0002\u0010\u001cJ\u000e\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\u001eH&J\b\u0010\u001f\u001a\u00020\tH&J\u0010\u0010 \u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u0003H&J\u0012\u0010\"\u001a\u0004\u0018\u00010\u00032\u0006\u0010#\u001a\u00020\u0003H&J*\u0010\"\u001a\u0004\u0018\u00010\u00032\u0006\u0010#\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0010H&J\u0018\u0010'\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0007H&J\u0010\u0010(\u001a\u00020\t2\u0006\u0010)\u001a\u00020\u0003H&¨\u0006*"}, d2 = {"Lcom/obric/memorydata/middleware/api/bridge/IMemoryBuildBridgeAPI;", "Lcom/bytedance/news/common/service/manager/IService;", "executeMemoryBuild", "", "modelName", "requestBody", "imageId", "", "useCloud", "", "getImageBase64", "unbindImage", "", "bindImage", "fileEntityJson", "maxBitmapKB", "", "(Ljava/lang/String;I)Ljava/lang/Long;", "downloadImageToDir", "imageUrl", "path", "timeoutMs", "indexMemoryEntity", "memoryJson", "(Ljava/lang/String;)Ljava/lang/Long;", "indexMemoryEntityWithCalendars", "entityType", "entityUUID", "(Ljava/lang/String;ILjava/lang/String;)Ljava/lang/Long;", "getEnableExtractPackageName", "", "getCalendarFromMemoryEnabled", "searchMemory", "quResult", "takeScreenshot", ObricMemoryConstants.KEY_PACKAGE_NAME, "resizeFactor", "", "compressQuality", "capturePageContext", "showCalendar", "entityId", "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface IMemoryBuildBridgeAPI extends IService {
    Long bindImage(String r1, int r2);

    String capturePageContext(String r1, long r2);

    String downloadImageToDir(String r1, String r2, int r3);

    String executeMemoryBuild(String r1, String r2, long r3, boolean r5);

    boolean getCalendarFromMemoryEnabled();

    Set<String> getEnableExtractPackageName();

    String getImageBase64(long r1);

    Long indexMemoryEntity(String r1);

    Long indexMemoryEntityWithCalendars(String r1, int r2, String r3);

    String searchMemory(String r1);

    boolean showCalendar(String r1);

    String takeScreenshot(String r1);

    String takeScreenshot(String r1, String r2, float r3, int r4);

    void unbindImage(long r1);
}
