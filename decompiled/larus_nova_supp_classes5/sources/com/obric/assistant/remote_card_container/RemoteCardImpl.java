package com.obric.assistant.remote_card_container;

import android.app.Application;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import androidx.core.content.pm.PackageInfoCompat;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant_card.provider_core.c;
import com.obric.assistant.IRemoteCard;
import com.obric.assistant.chat.IObricChatService;
import com.obric.assistant.chat.impl.MessageObserverImpl;
import com.obric.assistant.remote_card_container.cache.CardCacheManager;
import com.obric.assistant.remote_card_container.cardhost.CardHostIPCApi;
import com.obric.assistant.remote_card_container.manager.RemoteCardManager;
import com.obric.assistant.remote_card_container.manager.f;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import p9a.b;
import p9a.e;
import rfa.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\b\u0007\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0012\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010\u0017\u001a\u00020\bH\u0002J\u0010\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\f\u0010\u001b\u001a\u00020\u001c*\u00020\u001aH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e²\u0006\f\u0010\u001f\u001a\u0004\u0018\u00010 X\u008a\u0084\u0002"}, d2 = {"Lcom/obric/assistant/remote_card_container/RemoteCardImpl;", "Lcom/obric/assistant/IRemoteCard;", "<init>", "()V", "ioScope", "Lkotlinx/coroutines/CoroutineScope;", "mainScope", "init", "", "notifyCardChanged", "params", "Landroid/os/Bundle;", "onAppUpdated", "intent", "Landroid/content/Intent;", "onAppUninstall", "onAppChanged", "showDialog", "dialogBean", "Lcom/obric/aiagent/assistant_card/provider_core/bean/DialogBean;", "showMenu", "menuBean", "Lcom/obric/aiagent/assistant_card/provider_core/bean/MenuBean;", "observeMessageList", "saveRemoteCardInfo", "message", "Lcom/larus/im/bean/message/Message;", "isRemoteCardMessage", "", "Companion", "card_mainlandRelease", "chatListAbility", "Lcom/larus/bmhome/chat/component/list/IChatListComponentAbility;"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RemoteCardImpl implements IRemoteCard {
    public static final /* synthetic */ int c = 0;
    public final CoroutineScope a;
    public final CoroutineScope b;

    static {
    }

    public final void init() {
        b.a("RemoteCardImpl", "init");
        RemoteCardManager.d = new AnonymousClass1(this);
        ConcurrentHashMap r1 = c.a;
        Application r2 = AppHost.a.getApplication();
        f r3 = new f();
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "logger");
        c.d = r2.getApplicationContext();
        Intrinsics.checkNotNullParameter(r3, "logger");
        b.a = r3;
        b.a("CardProviderManager", "init: packageName = " + r2.getPackageName() + ", logger = " + r3);
        PackageInfo r4 = r2.getPackageManager().getPackageInfo(r2.getPackageName(), 0);
        String r5 = r4.versionName;
        PackageInfoCompat.getLongVersionCode(r4);
        IObricChatService.a.getClass();
        IObricChatService r6 = IObricChatService.a.a();
        if (r6 == null) goto L5;
        r6.l();
        MessageObserverImpl r7 = MessageObserverImpl.a;
    L6:
        if (r7 != null) goto L8;
        FLogger.a.w("RemoteCardImpl", "observeMessageList: messageObserver is null");
    L9:
        CardCacheManager r0 = CardCacheManager.a;
        CardCacheManager.a();
        return;
    L8:
        r7.f(new RemoteCardImpl$observeMessageList$1(this));
        goto L9
    L5:
        r7 = null;
        goto L6
    }

    public RemoteCardImpl() {
        this.a = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        this.b = CoroutineScopeKt.MainScope();
    }

    public final void a(Intent r3) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        int r1 = a.a;
        Intrinsics.checkNotNullParameter(r3, "intent");
        String r4 = a.a(r3);
        if (r4 != null) goto L5;
    L8:
        boolean r0 = true;
    L9:
        if (r0 == true) goto L13;
        e r2 = b.a;
        b.a("AppChangeHandler", "onAppChanged: " + r4);
        CardCacheManager r5 = CardCacheManager.a;
        Intrinsics.checkNotNullParameter(r4, "pkgName");
        CardCacheManager.b(new com.obric.assistant.remote_card_container.cache.e(r4));
        return;
    L13:
        return;
    L5:
        if (r4.length() == 0) goto L8;
        r0 = false;
        goto L9
    }

    public final void b(Intent r3) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        int r1 = a.a;
        Intrinsics.checkNotNullParameter(r3, "intent");
        String r4 = a.a(r3);
        if (r4 != null) goto L5;
    L8:
        boolean r0 = true;
    L9:
        if (r0 == true) goto L13;
        e r2 = b.a;
        b.a("AppChangeHandler", "onAppUpdated: " + r4);
        CardCacheManager r5 = CardCacheManager.a;
        Intrinsics.checkNotNullParameter(r4, "pkgName");
        CardCacheManager.b(new com.obric.assistant.remote_card_container.cache.e(r4));
        return;
    L13:
        return;
    L5:
        if (r4.length() == 0) goto L8;
        r0 = false;
        goto L9
    }

    public final void c(Intent r3) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        int r1 = a.a;
        Intrinsics.checkNotNullParameter(r3, "intent");
        String r4 = a.a(r3);
        if (r4 != null) goto L5;
    L8:
        boolean r0 = true;
    L9:
        if (r0 == true) goto L13;
        e r2 = b.a;
        b.a("AppChangeHandler", "onAppUninstall: " + r4);
        CardCacheManager r5 = CardCacheManager.a;
        Intrinsics.checkNotNullParameter(r4, "pkgName");
        CardCacheManager.b(new com.obric.assistant.remote_card_container.cache.e(r4));
        return;
    L13:
        return;
    L5:
        if (r4.length() == 0) goto L8;
        r0 = false;
        goto L9
    }

    public final void notifyCardChanged(Bundle r2) {
        CardHostIPCApi.INSTANCE.notifyCardChanged(r2);
    }
}
