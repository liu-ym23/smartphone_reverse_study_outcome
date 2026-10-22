package com.obric.memorydata.middleware.api.app;

import android.content.Context;
import com.bytedance.news.common.service.manager.IService;
import com.bytedance.news.common.service.manager.ext.ServiceManagerExtKt;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00050\tH\u0096\u0001J%\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00050\tH\u0096\u0001¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/middleware/api/app/UserStateManager;", "Lcom/obric/memorydata/middleware/api/app/IUserStateManager;", "<init>", "()V", "requestAgreePrivacy", "", "context", "Landroid/content/Context;", "callback", "Lkotlin/Function1;", "", "requestAgreePrivacyAndLogin", "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class UserStateManager implements IUserStateManager {
    public static final UserStateManager INSTANCE = null;
    private final /* synthetic */ IUserStateManager $$delegate_0;

    static {
        INSTANCE = new UserStateManager();
    }

    private UserStateManager() {
        IService r0 = ServiceManagerExtKt.impl(Reflection.getOrCreateKotlinClass(IUserStateManager.class));
        Intrinsics.checkNotNull(r0);
        this.$$delegate_0 = (IUserStateManager) ZeusTransformUtils.preCheckCast(r0, IUserStateManager.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.middleware.api.app.IUserStateManager
    public void requestAgreePrivacy(Context r3, Function1<? super Boolean, Unit> r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Function1<? super Boolean, Unit> r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r6, "callback");
        this.$$delegate_0.requestAgreePrivacy(r5, r6);
    }

    @Override // com.obric.memorydata.middleware.api.app.IUserStateManager
    public void requestAgreePrivacyAndLogin(Context r3, Function1<? super Boolean, Unit> r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Function1<? super Boolean, Unit> r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r6, "callback");
        this.$$delegate_0.requestAgreePrivacyAndLogin(r5, r6);
    }
}
