package com.larus.bmhome.utils;

import android.content.Context;
import android.os.Bundle;
import com.larus.bmhome.auth.LandingConfig;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0005H\u0016J&\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fH\u0096@¢\u0006\u0002\u0010\u0011J\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0012\u0010\u0016\u001a\u00020\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/larus/bmhome/utils/LaunchLandingConfigHelperNoop;", "Lcom/larus/bmhome/utils/ILaunchLandingConfigHelper;", "<init>", "()V", "landingConfig", "Lcom/larus/bmhome/auth/LandingConfig;", "getLandingConfig", "setLandingConfig", "", "config", "findOrCreateConversationByBot", "Lcom/larus/bmhome/utils/SimpleConvInfo;", "botId", "", "conversationInfo", "Lcom/larus/network/http/Async;", "Lcom/larus/im/bean/conversation/Conversation;", "(Ljava/lang/String;Lcom/larus/network/http/Async;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkIsFromUgArguments", "", "arguments", "Landroid/os/Bundle;", "tryHandleLaunchLandingScheme", "context", "Landroid/content/Context;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LaunchLandingConfigHelperNoop implements ILaunchLandingConfigHelper {
    public LandingConfig a;

    public LaunchLandingConfigHelperNoop() {
    }

    @Override // com.larus.bmhome.utils.ILaunchLandingConfigHelper
    public final void a(Context r1) {
    }

    @Override // com.larus.bmhome.utils.ILaunchLandingConfigHelper
    public final boolean c(Bundle r1) {
        return false;
    }

    @Override // com.larus.bmhome.utils.ILaunchLandingConfigHelper
    public final LandingConfig b() {
        return this.a;
    }

    @Override // com.larus.bmhome.utils.ILaunchLandingConfigHelper
    public final void e(LandingConfig r1) {
        this.a = r1;
    }

    @Override // com.larus.bmhome.utils.ILaunchLandingConfigHelper
    public final Object d(String r1, Continuation r2) {
        return new q3("");
    }
}
