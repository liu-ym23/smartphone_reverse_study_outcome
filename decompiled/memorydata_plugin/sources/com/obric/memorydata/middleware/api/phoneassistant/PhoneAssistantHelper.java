package com.obric.memorydata.middleware.api.phoneassistant;

import com.bytedance.news.common.service.manager.IService;
import com.bytedance.news.common.service.manager.ext.ServiceManagerExtKt;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007H\u0096\u0001J\u0017\u0010\b\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007H\u0096\u0001J\u0017\u0010\t\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007H\u0096\u0001J\u0017\u0010\n\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007H\u0096\u0001¨\u0006\u000b"}, d2 = {"Lcom/obric/memorydata/middleware/api/phoneassistant/PhoneAssistantHelper;", "Lcom/obric/memorydata/middleware/api/phoneassistant/IPhoneAssistantHelper;", "<init>", "()V", "addAssistantExitListener", "", "listener", "Lkotlin/Function0;", "addAssistantInvokeListener", "removeAssistantExitListener", "removeAssistantInvokeListener", "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PhoneAssistantHelper implements IPhoneAssistantHelper {
    public static final PhoneAssistantHelper INSTANCE = null;
    private final /* synthetic */ IPhoneAssistantHelper $$delegate_0;

    static {
        INSTANCE = new PhoneAssistantHelper();
    }

    private PhoneAssistantHelper() {
        IService r0 = ServiceManagerExtKt.impl(Reflection.getOrCreateKotlinClass(IPhoneAssistantHelper.class));
        Intrinsics.checkNotNull(r0);
        this.$$delegate_0 = (IPhoneAssistantHelper) ZeusTransformUtils.preCheckCast(r0, IPhoneAssistantHelper.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.middleware.api.phoneassistant.IPhoneAssistantHelper
    public void addAssistantExitListener(Function0<Unit> r3) {
        Function0<Unit> r4 = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "listener");
        this.$$delegate_0.addAssistantExitListener(r4);
    }

    @Override // com.obric.memorydata.middleware.api.phoneassistant.IPhoneAssistantHelper
    public void addAssistantInvokeListener(Function0<Unit> r3) {
        Function0<Unit> r4 = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "listener");
        this.$$delegate_0.addAssistantInvokeListener(r4);
    }

    @Override // com.obric.memorydata.middleware.api.phoneassistant.IPhoneAssistantHelper
    public void removeAssistantExitListener(Function0<Unit> r3) {
        Function0<Unit> r4 = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "listener");
        this.$$delegate_0.removeAssistantExitListener(r4);
    }

    @Override // com.obric.memorydata.middleware.api.phoneassistant.IPhoneAssistantHelper
    public void removeAssistantInvokeListener(Function0<Unit> r3) {
        Function0<Unit> r4 = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "listener");
        this.$$delegate_0.removeAssistantInvokeListener(r4);
    }
}
