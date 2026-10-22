package com.obric.assistant.audio.service;

import com.larus.audio.IFlowTtsClientService;
import com.larus.bmhome.chat.model.repo.IConversationRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.utils.logger.FLogger;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.audio.f;
import com.obric.audio.tts.IObricChainTtsService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\b"}, d2 = {"Lcom/obric/assistant/audio/service/ObricAssistantBaseServiceImpl;", "Lcom/obric/assistant/audio/service/IObricAssistantBaseService;", "<init>", "()V", "interruptCurrentConversation", NameKeys.UnloadStrategy_No_Strategy, "interruptTts", "Companion", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricAssistantBaseServiceImpl implements IObricAssistantBaseService {

    public static final class a {
    }

    static {
    }

    public ObricAssistantBaseServiceImpl() {
    }

    @Override // com.obric.assistant.audio.service.IObricAssistantBaseService
    public final void a() {
        int r0 = f.a;
        IFlowTtsClientService.a.getClass();
        IFlowTtsClientService.a.a().f("InterruptService.interruptTts");
        IObricChainTtsService.a.getClass();
        IObricChainTtsService r1 = IObricChainTtsService.a.a();
        if (r1 == null) goto L6;
        r1.c("InterruptService.interruptTts");
        return;
    }

    @Override // com.obric.assistant.audio.service.IObricAssistantBaseService
    public final void b() {
        int r0 = f.a;
        FLogger.a.d("InterruptService", "interruptCurrentConversation:");
        Intrinsics.checkNotNullParameter(NameKeys.UnloadStrategy_No_Strategy, "conversationId");
        IConversationRepoService.a.f(RepoDispatcherDelegate.b.f(), NameKeys.UnloadStrategy_No_Strategy, true, false, null, 8);
    }
}
