package com.larus.bmhome.utils;

import android.content.Context;
import android.os.Bundle;
import com.larus.bmhome.auth.LandingConfig;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0096\u0001J&\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rH\u0096A¢\u0006\u0002\u0010\u000fJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0096\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0011H\u0096\u0001J\u0013\u0010\u0015\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0096\u0001¨\u0006\u0018"}, d2 = {"Lcom/larus/bmhome/utils/LaunchLandingConfigHelperDelegate;", "Lcom/larus/bmhome/utils/ILaunchLandingConfigHelper;", "<init>", "()V", "checkIsFromUgArguments", "", "arguments", "Landroid/os/Bundle;", "findOrCreateConversationByBot", "Lcom/larus/bmhome/utils/SimpleConvInfo;", "botId", "", "conversationInfo", "Lcom/larus/network/http/Async;", "Lcom/larus/im/bean/conversation/Conversation;", "(Ljava/lang/String;Lcom/larus/network/http/Async;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLandingConfig", "Lcom/larus/bmhome/auth/LandingConfig;", "setLandingConfig", "", "config", "tryHandleLaunchLandingScheme", "context", "Landroid/content/Context;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LaunchLandingConfigHelperDelegate implements ILaunchLandingConfigHelper {
    public static final LaunchLandingConfigHelperDelegate b = null;
    public final /* synthetic */ ILaunchLandingConfigHelper a;

    static {
        b = new LaunchLandingConfigHelperDelegate();
    }

    @Override // com.larus.bmhome.utils.ILaunchLandingConfigHelper
    public final void a(Context r2) {
        this.a.a(r2);
    }

    @Override // com.larus.bmhome.utils.ILaunchLandingConfigHelper
    public final LandingConfig b() {
        return this.a.b();
    }

    @Override // com.larus.bmhome.utils.ILaunchLandingConfigHelper
    public final boolean c(Bundle r2) {
        return this.a.c(r2);
    }

    @Override // com.larus.bmhome.utils.ILaunchLandingConfigHelper
    public final Object d(String r2, Continuation r3) {
        return this.a.d(r2, r3);
    }

    @Override // com.larus.bmhome.utils.ILaunchLandingConfigHelper
    public final void e(LandingConfig r2) {
        this.a.e(r2);
    }

    private LaunchLandingConfigHelperDelegate() {
        ILaunchLandingConfigHelper r0 = (ILaunchLandingConfigHelper) ServiceManager.get().getService(ILaunchLandingConfigHelper.class);
        if (r0 != null) goto L5;
        r0 = new LaunchLandingConfigHelperNoop();
    L5:
        this.a = r0;
    }
}
