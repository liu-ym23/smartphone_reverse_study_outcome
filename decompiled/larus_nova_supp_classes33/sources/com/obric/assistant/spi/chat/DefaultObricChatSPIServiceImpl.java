package com.obric.assistant.spi.chat;

import android.content.Intent;
import android.os.Bundle;
import com.larus.im.bean.message.Message;
import iga.c;
import iga.d;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import t1a.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 ,2\u00020\u0001:\u0001,B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007H\u0016J4\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\t2\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0010H\u0096@¢\u0006\u0002\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0014H\u0016J\u0010\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\tH\u0016J\b\u0010\u001b\u001a\u00020\tH\u0016J\b\u0010\u001c\u001a\u00020\tH\u0016J\b\u0010\u001d\u001a\u00020\tH\u0016J\b\u0010\u001e\u001a\u00020\tH\u0016J\b\u0010\u001f\u001a\u00020\tH\u0016J\u0010\u0010 \u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020!H\u0016J\n\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u0012\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010&\u001a\u00020\tH\u0016J$\u0010'\u001a\u00020\t2\u0006\u0010(\u001a\u00020)2\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u00050+H\u0016¨\u0006-"}, d2 = {"Lcom/obric/assistant/spi/chat/DefaultObricChatSPIServiceImpl;", "Lcom/obric/assistant/spi/chat/IObricChatSPIService;", "<init>", "()V", "tryBreakLatestAnswer", "", "curCvsId", "", "onCheckAsrContentRelative", "", "taskid", "asrContent", "ensureContextSafe", "cvsId", "canRetry", "extra", "", "(Ljava/lang/String;ZLjava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onReGenerate", "questionMsg", "Lcom/larus/im/bean/message/Message;", "shouldSkipAsLatestRegenerateMessage", "message", "markChatListBottomReached", "vContext", "Lcom/larus/ui/arch/context/external/VContext;", "isEnabledAssistantOpenPageMethod", "isBluetoothHeadSetConnected", "enableLiveTutorAsrOpt", "enableCameraCommandOpt", "enableCameraSuggestedToDeferred", "enableCameraOpenResultPage", "openChatWindowForCameraResult", "Landroid/os/Bundle;", "getCachedMainChatSnapshot", "Lcom/obric/assistant/spi/chat/ObricMainChatSnapshot;", "getWindowInboxBackgroundStyle", "Lcom/obric/assistant/spi/chat/ObricWindowInboxBackgroundStyle;", "isDarkMode", "tryLaunchFilePicker", "defaultIntent", "Landroid/content/Intent;", "launch", "Lkotlin/Function1;", "Companion", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DefaultObricChatSPIServiceImpl implements IObricChatSPIService {

    public static final class a {
    }

    static {
    }

    public DefaultObricChatSPIServiceImpl() {
    }

    @Override // com.obric.assistant.spi.chat.IObricChatSPIService
    public final boolean a() {
        return false;
    }

    @Override // com.obric.assistant.spi.chat.IObricChatSPIService
    public final void b(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "questionMsg");
    }

    @Override // com.obric.assistant.spi.chat.IObricChatSPIService
    public final c c() {
        return null;
    }

    @Override // com.obric.assistant.spi.chat.IObricChatSPIService
    public final boolean d() {
        return false;
    }

    @Override // com.obric.assistant.spi.chat.IObricChatSPIService
    public final d e(boolean r1) {
        return null;
    }

    @Override // com.obric.assistant.spi.chat.IObricChatSPIService
    public final boolean f(Intent r2, li8.c r3) {
        Intrinsics.checkNotNullParameter(r2, "defaultIntent");
        Intrinsics.checkNotNullParameter(r3, "launch");
        return false;
    }

    @Override // com.obric.assistant.spi.chat.IObricChatSPIService
    public final void g(String r2) {
        Intrinsics.checkNotNullParameter(r2, "curCvsId");
    }

    @Override // com.obric.assistant.spi.chat.IObricChatSPIService
    public final boolean h(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "message");
        return false;
    }

    @Override // com.obric.assistant.spi.chat.IObricChatSPIService
    public final boolean i() {
        return false;
    }

    @Override // com.obric.assistant.spi.chat.IObricChatSPIService
    public final boolean j() {
        return false;
    }

    @Override // com.obric.assistant.spi.chat.IObricChatSPIService
    public final void k(b r2) {
        Intrinsics.checkNotNullParameter(r2, "vContext");
    }

    @Override // com.obric.assistant.spi.chat.IObricChatSPIService
    public final boolean l() {
        return false;
    }

    @Override // com.obric.assistant.spi.chat.IObricChatSPIService
    public final boolean m(Bundle r2) {
        Intrinsics.checkNotNullParameter(r2, "extra");
        return false;
    }

    @Override // com.obric.assistant.spi.chat.IObricChatSPIService
    public final Object n(String r1, boolean r2, Map<String, String> r3, Continuation<? super Boolean> r4) {
        return Boxing.boxBoolean(true);
    }
}
