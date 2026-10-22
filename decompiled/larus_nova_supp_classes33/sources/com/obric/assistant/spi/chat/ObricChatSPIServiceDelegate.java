package com.obric.assistant.spi.chat;

import android.content.Intent;
import android.os.Bundle;
import com.larus.im.bean.message.Message;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import iga.c;
import iga.d;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import t1a.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u0006\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u0007\u001a\u00020\u0005H\u0096\u0001J\t\u0010\b\u001a\u00020\u0005H\u0096\u0001J4\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00052\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u000eH\u0096A¢\u0006\u0002\u0010\u000fJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0096\u0001J\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u0015\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u0016\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0096\u0001J\u0019\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u000bH\u0096\u0001J\u0011\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020 H\u0096\u0001J\u0011\u0010!\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\"H\u0096\u0001J\u0011\u0010#\u001a\u00020\u00052\u0006\u0010$\u001a\u00020 H\u0096\u0001J\u0011\u0010%\u001a\u00020\u00182\u0006\u0010&\u001a\u00020\u000bH\u0096\u0001J%\u0010'\u001a\u00020\u00052\u0006\u0010(\u001a\u00020)2\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u00180+H\u0096\u0001¨\u0006,"}, d2 = {"Lcom/obric/assistant/spi/chat/ObricChatSPIServiceDelegate;", "Lcom/obric/assistant/spi/chat/IObricChatSPIService;", "<init>", "()V", "enableCameraCommandOpt", "", "enableCameraOpenResultPage", "enableCameraSuggestedToDeferred", "enableLiveTutorAsrOpt", "ensureContextSafe", "cvsId", "", "canRetry", "extra", "", "(Ljava/lang/String;ZLjava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCachedMainChatSnapshot", "Lcom/obric/assistant/spi/chat/ObricMainChatSnapshot;", "getWindowInboxBackgroundStyle", "Lcom/obric/assistant/spi/chat/ObricWindowInboxBackgroundStyle;", "isDarkMode", "isBluetoothHeadSetConnected", "isEnabledAssistantOpenPageMethod", "markChatListBottomReached", "", "vContext", "Lcom/larus/ui/arch/context/external/VContext;", "onCheckAsrContentRelative", "taskid", "asrContent", "onReGenerate", "questionMsg", "Lcom/larus/im/bean/message/Message;", "openChatWindowForCameraResult", "Landroid/os/Bundle;", "shouldSkipAsLatestRegenerateMessage", "message", "tryBreakLatestAnswer", "curCvsId", "tryLaunchFilePicker", "defaultIntent", "Landroid/content/Intent;", "launch", "Lkotlin/Function1;", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricChatSPIServiceDelegate implements IObricChatSPIService {
    public static final ObricChatSPIServiceDelegate b = null;
    public final /* synthetic */ IObricChatSPIService a;

    static {
        b = new ObricChatSPIServiceDelegate();
    }

    @Override // com.obric.assistant.spi.chat.IObricChatSPIService
    public final boolean a() {
        return this.a.a();
    }

    @Override // com.obric.assistant.spi.chat.IObricChatSPIService
    public final void b(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "questionMsg");
        this.a.b(r2);
    }

    @Override // com.obric.assistant.spi.chat.IObricChatSPIService
    public final c c() {
        return this.a.c();
    }

    @Override // com.obric.assistant.spi.chat.IObricChatSPIService
    public final boolean d() {
        return this.a.d();
    }

    @Override // com.obric.assistant.spi.chat.IObricChatSPIService
    public final d e(boolean r2) {
        return this.a.e(r2);
    }

    @Override // com.obric.assistant.spi.chat.IObricChatSPIService
    public final boolean f(Intent r2, li8.c r3) {
        Intrinsics.checkNotNullParameter(r2, "defaultIntent");
        Intrinsics.checkNotNullParameter(r3, "launch");
        return this.a.f(r2, r3);
    }

    @Override // com.obric.assistant.spi.chat.IObricChatSPIService
    public final void g(String r2) {
        Intrinsics.checkNotNullParameter(r2, "curCvsId");
        this.a.g(r2);
    }

    @Override // com.obric.assistant.spi.chat.IObricChatSPIService
    public final boolean h(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "message");
        return this.a.h(r2);
    }

    @Override // com.obric.assistant.spi.chat.IObricChatSPIService
    public final boolean i() {
        return this.a.i();
    }

    @Override // com.obric.assistant.spi.chat.IObricChatSPIService
    public final boolean j() {
        return this.a.j();
    }

    @Override // com.obric.assistant.spi.chat.IObricChatSPIService
    public final void k(b r2) {
        Intrinsics.checkNotNullParameter(r2, "vContext");
        this.a.k(r2);
    }

    @Override // com.obric.assistant.spi.chat.IObricChatSPIService
    public final boolean l() {
        return this.a.l();
    }

    @Override // com.obric.assistant.spi.chat.IObricChatSPIService
    public final boolean m(Bundle r2) {
        Intrinsics.checkNotNullParameter(r2, "extra");
        return this.a.m(r2);
    }

    @Override // com.obric.assistant.spi.chat.IObricChatSPIService
    public final Object n(String r2, boolean r3, Map<String, String> r4, Continuation<? super Boolean> r5) {
        return this.a.n(r2, r3, r4, r5);
    }

    private ObricChatSPIServiceDelegate() {
        IObricChatSPIService r0 = (IObricChatSPIService) ServiceManager.get().getService(IObricChatSPIService.class);
        if (r0 != null) goto L5;
        r0 = new DefaultObricChatSPIServiceImpl();
    L5:
        this.a = r0;
    }
}
