package com.obric.memorydata.middleware.api.bridge;

import com.bytedance.news.common.service.manager.IService;
import com.bytedance.news.common.service.manager.ext.ServiceManagerExtKt;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u000e\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0096\u0001¢\u0006\u0002\u0010\nJ\u0019\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0005H\u0096\u0001J#\u0010\u000e\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\tH\u0096\u0001J+\u0010\u0011\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0016H\u0096\u0001J\t\u0010\u0017\u001a\u00020\u0016H\u0096\u0001J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00070\u0019H\u0096\u0001J\u0011\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0005H\u0096\u0001J\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001c\u001a\u00020\u0007H\u0096\u0001¢\u0006\u0002\u0010\u001dJ*\u0010\u001e\u001a\u0004\u0018\u00010\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001f\u001a\u00020\t2\u0006\u0010 \u001a\u00020\u0007H\u0096\u0001¢\u0006\u0002\u0010!J\u0011\u0010\"\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u0007H\u0096\u0001J\u0011\u0010$\u001a\u00020\u00162\u0006\u0010%\u001a\u00020\u0007H\u0096\u0001J\u0013\u0010&\u001a\u0004\u0018\u00010\u00072\u0006\u0010\f\u001a\u00020\u0007H\u0096\u0001J+\u0010&\u001a\u0004\u0018\u00010\u00072\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\tH\u0096\u0001J\u0011\u0010*\u001a\u00020+2\u0006\u0010\u0014\u001a\u00020\u0005H\u0096\u0001¨\u0006,"}, d2 = {"Lcom/obric/memorydata/middleware/api/bridge/MemoryBuildBridgeAPI;", "Lcom/obric/memorydata/middleware/api/bridge/IMemoryBuildBridgeAPI;", "<init>", "()V", "bindImage", "", "fileEntityJson", "", "maxBitmapKB", "", "(Ljava/lang/String;I)Ljava/lang/Long;", "capturePageContext", ObricMemoryConstants.KEY_PACKAGE_NAME, "timeoutMs", "downloadImageToDir", "imageUrl", "path", "executeMemoryBuild", "modelName", "requestBody", "imageId", "useCloud", "", "getCalendarFromMemoryEnabled", "getEnableExtractPackageName", "", "getImageBase64", "indexMemoryEntity", "memoryJson", "(Ljava/lang/String;)Ljava/lang/Long;", "indexMemoryEntityWithCalendars", "entityType", "entityUUID", "(Ljava/lang/String;ILjava/lang/String;)Ljava/lang/Long;", "searchMemory", "quResult", "showCalendar", "entityId", "takeScreenshot", "resizeFactor", "", "compressQuality", "unbindImage", "", "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MemoryBuildBridgeAPI implements IMemoryBuildBridgeAPI {
    public static final MemoryBuildBridgeAPI INSTANCE = null;
    private final /* synthetic */ IMemoryBuildBridgeAPI $$delegate_0;

    static {
        INSTANCE = new MemoryBuildBridgeAPI();
    }

    private MemoryBuildBridgeAPI() {
        IService r0 = ServiceManagerExtKt.impl(Reflection.getOrCreateKotlinClass(IMemoryBuildBridgeAPI.class));
        Intrinsics.checkNotNull(r0);
        this.$$delegate_0 = (IMemoryBuildBridgeAPI) ZeusTransformUtils.preCheckCast(r0, IMemoryBuildBridgeAPI.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IMemoryBuildBridgeAPI
    public Long bindImage(String r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "fileEntityJson");
        return this.$$delegate_0.bindImage(r2, r3);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IMemoryBuildBridgeAPI
    public String capturePageContext(String r2, long r3) {
        Intrinsics.checkNotNullParameter(r2, ObricMemoryConstants.KEY_PACKAGE_NAME);
        return this.$$delegate_0.capturePageContext(r2, r3);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IMemoryBuildBridgeAPI
    public String downloadImageToDir(String r2, String r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "imageUrl");
        Intrinsics.checkNotNullParameter(r3, "path");
        return this.$$delegate_0.downloadImageToDir(r2, r3, r4);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IMemoryBuildBridgeAPI
    public String executeMemoryBuild(String r8, String r9, long r10, boolean r12) {
        Intrinsics.checkNotNullParameter(r8, "modelName");
        Intrinsics.checkNotNullParameter(r9, "requestBody");
        return this.$$delegate_0.executeMemoryBuild(r8, r9, r10, r12);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IMemoryBuildBridgeAPI
    public boolean getCalendarFromMemoryEnabled() {
        return this.$$delegate_0.getCalendarFromMemoryEnabled();
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IMemoryBuildBridgeAPI
    public Set<String> getEnableExtractPackageName() {
        return this.$$delegate_0.getEnableExtractPackageName();
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IMemoryBuildBridgeAPI
    public String getImageBase64(long r1) {
        return this.$$delegate_0.getImageBase64(r1);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IMemoryBuildBridgeAPI
    public Long indexMemoryEntity(String r2) {
        Intrinsics.checkNotNullParameter(r2, "memoryJson");
        return this.$$delegate_0.indexMemoryEntity(r2);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IMemoryBuildBridgeAPI
    public Long indexMemoryEntityWithCalendars(String r2, int r3, String r4) {
        Intrinsics.checkNotNullParameter(r4, "entityUUID");
        return this.$$delegate_0.indexMemoryEntityWithCalendars(r2, r3, r4);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IMemoryBuildBridgeAPI
    public String searchMemory(String r2) {
        Intrinsics.checkNotNullParameter(r2, "quResult");
        return this.$$delegate_0.searchMemory(r2);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IMemoryBuildBridgeAPI
    public boolean showCalendar(String r2) {
        Intrinsics.checkNotNullParameter(r2, "entityId");
        return this.$$delegate_0.showCalendar(r2);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IMemoryBuildBridgeAPI
    public String takeScreenshot(String r2) {
        Intrinsics.checkNotNullParameter(r2, ObricMemoryConstants.KEY_PACKAGE_NAME);
        return this.$$delegate_0.takeScreenshot(r2);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IMemoryBuildBridgeAPI
    public String takeScreenshot(String r2, String r3, float r4, int r5) {
        Intrinsics.checkNotNullParameter(r2, ObricMemoryConstants.KEY_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(r3, "path");
        return this.$$delegate_0.takeScreenshot(r2, r3, r4, r5);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IMemoryBuildBridgeAPI
    public void unbindImage(long r1) {
        this.$$delegate_0.unbindImage(r1);
    }
}
