package com.obric.memorydata.middleware.api.feedback;

import android.os.Bundle;
import com.bytedance.news.common.service.manager.IService;
import com.bytedance.news.common.service.manager.ext.ServiceManagerExtKt;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J#\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\tH\u0096\u0001¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/middleware/api/feedback/FeedbackManager;", "Lcom/obric/memorydata/middleware/api/feedback/IFeedbackManager;", "<init>", "()V", "triggerFeedback", "Landroid/os/Bundle;", "problemDesc", "", "customFilePathList", "", "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class FeedbackManager implements IFeedbackManager {
    public static final FeedbackManager INSTANCE = null;
    private final /* synthetic */ IFeedbackManager $$delegate_0;

    static {
        INSTANCE = new FeedbackManager();
    }

    private FeedbackManager() {
        IService r0 = ServiceManagerExtKt.impl(Reflection.getOrCreateKotlinClass(IFeedbackManager.class));
        Intrinsics.checkNotNull(r0);
        this.$$delegate_0 = (IFeedbackManager) ZeusTransformUtils.preCheckCast(r0, IFeedbackManager.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.middleware.api.feedback.IFeedbackManager
    public Bundle triggerFeedback(String r3, List<String> r4) {
        List<String> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "problemDesc");
        return this.$$delegate_0.triggerFeedback(r3, r5);
    }
}
