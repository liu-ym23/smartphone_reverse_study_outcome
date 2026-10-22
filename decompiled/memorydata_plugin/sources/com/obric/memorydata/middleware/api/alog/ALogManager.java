package com.obric.memorydata.middleware.api.alog;

import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.news.common.service.manager.IService;
import com.bytedance.news.common.service.manager.ext.ServiceManagerExtKt;
import com.obric.memorydata.memory.ui.automemory.settings.MemoryInfoSectionEditActivity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0005H\u0096\u0001J)\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0096\u0001¨\u0006\r"}, d2 = {"Lcom/obric/memorydata/middleware/api/alog/ALogManager;", "Lcom/obric/memorydata/middleware/api/alog/IALogManager;", "<init>", "()V", CommonConsts.APM_INNER_EVENT_COST_INIT, "", "upload", "startTimeSec", "", "endTimeSec", MemoryInfoSectionEditActivity.KIND_SCENE, "", "uploadId", "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ALogManager implements IALogManager {
    public static final ALogManager INSTANCE = null;
    private final /* synthetic */ IALogManager $$delegate_0;

    static {
        INSTANCE = new ALogManager();
    }

    private ALogManager() {
        IService r0 = ServiceManagerExtKt.impl(Reflection.getOrCreateKotlinClass(IALogManager.class));
        Intrinsics.checkNotNull(r0);
        this.$$delegate_0 = (IALogManager) ZeusTransformUtils.preCheckCast(r0, IALogManager.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.middleware.api.alog.IALogManager
    public void init() {
        this.$$delegate_0.init();
    }

    @Override // com.obric.memorydata.middleware.api.alog.IALogManager
    public void upload(long r9, long r11, String r13, String r14) {
        Intrinsics.checkNotNullParameter(r13, MemoryInfoSectionEditActivity.KIND_SCENE);
        Intrinsics.checkNotNullParameter(r14, "uploadId");
        this.$$delegate_0.upload(r9, r11, r13, r14);
    }
}
