package com.obric.assistant.audio.service;

import com.obric.aivoice.core.data.NameKeys;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u0006\u001a\u00020\u0005H\u0096\u0001¨\u0006\u0007"}, d2 = {"Lcom/obric/assistant/audio/service/ObricAssistantBaseServiceDelegate;", "Lcom/obric/assistant/audio/service/IObricAssistantBaseService;", "<init>", "()V", "interruptCurrentConversation", NameKeys.UnloadStrategy_No_Strategy, "interruptTts", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricAssistantBaseServiceDelegate implements IObricAssistantBaseService {
    public static final ObricAssistantBaseServiceDelegate b = null;
    public final /* synthetic */ IObricAssistantBaseService a;

    static {
        b = new ObricAssistantBaseServiceDelegate();
    }

    @Override // com.obric.assistant.audio.service.IObricAssistantBaseService
    public final void a() {
        this.a.a();
    }

    @Override // com.obric.assistant.audio.service.IObricAssistantBaseService
    public final void b() {
        this.a.b();
    }

    private ObricAssistantBaseServiceDelegate() {
        this.a = (IObricAssistantBaseService) ServiceManager.get().getService(IObricAssistantBaseService.class);
    }
}
