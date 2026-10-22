package com.obric.memorydata.datatransport.api;

import android.content.Context;
import com.bytedance.news.common.service.manager.IService;
import com.obric.capabilitykit.common.Ext;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&J\b\u0010\f\u001a\u00020\u0003H&J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000fH&J\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000fH&J$\u0010\u0011\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015H&R\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0002\u0010\u0004\"\u0004\b\u0005\u0010\u0006¨\u0006\u0016"}, d2 = {"Lcom/obric/memorydata/datatransport/api/DataTransportManagerApi;", "Lcom/bytedance/news/common/service/manager/IService;", "isUTDataCollectEnabled", "", "()Z", "setUTDataCollectEnabled", "(Z)V", "register", "", "extension", "Lcom/obric/memorydata/datatransport/api/DataTransportExtension;", "unregister", "isDataExportEntryEnabled", "startExportActivity", "context", "Landroid/content/Context;", "startMemoryBuildDataPackageActivity", "exportBuildMemoryPackage", Ext.KEY_REQUEST, "Lcom/obric/memorydata/datatransport/api/MemoryBuildExportRequest;", "callback", "Lcom/obric/memorydata/datatransport/api/MemoryBuildExportCallback;", "data_transport_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface DataTransportManagerApi extends IService {
    void exportBuildMemoryPackage(Context r1, MemoryBuildExportRequest r2, e r3);

    boolean isDataExportEntryEnabled();

    boolean isUTDataCollectEnabled();

    void register(b r1);

    void setUTDataCollectEnabled(boolean r1);

    void startExportActivity(Context r1);

    void startMemoryBuildDataPackageActivity(Context r1);

    void unregister(b r1);
}
