package com.obric.memorydata.personalcontext.api;

import com.bytedance.news.common.service.manager.IService;
import com.bytedance.news.common.service.manager.ext.ServiceManagerExtKt;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0096A¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/obric/memorydata/personalcontext/api/EntitySearchHelper;", "Lcom/obric/memorydata/personalcontext/api/IEntitySearchHelper;", "<init>", "()V", "search", "", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "searchType", "", "quResult", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "personal_context_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class EntitySearchHelper implements IEntitySearchHelper {
    public static final EntitySearchHelper INSTANCE = null;
    private final /* synthetic */ IEntitySearchHelper $$delegate_0;

    static {
        INSTANCE = new EntitySearchHelper();
    }

    private EntitySearchHelper() {
        IService r0 = ServiceManagerExtKt.impl(Reflection.getOrCreateKotlinClass(IEntitySearchHelper.class));
        Intrinsics.checkNotNull(r0);
        this.$$delegate_0 = (IEntitySearchHelper) ZeusTransformUtils.preCheckCast(r0, IEntitySearchHelper.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.personalcontext.api.IEntitySearchHelper
    public Object search(String r3, String r4, Continuation<? super List<? extends AppEntity>> r5) {
        Continuation<? super List<? extends AppEntity>> r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        return this.$$delegate_0.search(r3, r4, r6);
    }
}
