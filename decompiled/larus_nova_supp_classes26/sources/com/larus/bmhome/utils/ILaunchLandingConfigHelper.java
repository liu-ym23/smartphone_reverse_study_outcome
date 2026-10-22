package com.larus.bmhome.utils;

import android.content.Context;
import android.os.Bundle;
import com.larus.bmhome.auth.LandingConfig;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H&J&\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH¦@¢\u0006\u0002\u0010\u000eJ\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H&J\u0012\u0010\u0013\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H&¨\u0006\u0017"}, d2 = {"Lcom/larus/bmhome/utils/ILaunchLandingConfigHelper;", "", "getLandingConfig", "Lcom/larus/bmhome/auth/LandingConfig;", "setLandingConfig", "", "config", "findOrCreateConversationByBot", "Lcom/larus/bmhome/utils/SimpleConvInfo;", "botId", "", "conversationInfo", "Lcom/larus/network/http/Async;", "Lcom/larus/im/bean/conversation/Conversation;", "(Ljava/lang/String;Lcom/larus/network/http/Async;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkIsFromUgArguments", "", "arguments", "Landroid/os/Bundle;", "tryHandleLaunchLandingScheme", "context", "Landroid/content/Context;", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ILaunchLandingConfigHelper {
    void a(Context r1);

    LandingConfig b();

    boolean c(Bundle r1);

    Object d(String r1, Continuation r2);

    void e(LandingConfig r1);
}
