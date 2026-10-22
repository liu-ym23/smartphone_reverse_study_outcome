package com.obric.assistant.audio.service;

import com.obric.aivoice.core.data.NameKeys;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0096\u0001J\u0011\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001¨\u0006\f"}, d2 = {"Lcom/obric/assistant/audio/service/AssistantTextModeServiceDelegate;", "Lcom/obric/assistant/audio/service/IAssistantTextModeService;", "<init>", "()V", "start", NameKeys.UnloadStrategy_No_Strategy, "botId", NameKeys.UnloadStrategy_No_Strategy, "conversationId", "hasAttachment", NameKeys.UnloadStrategy_No_Strategy, "stop", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AssistantTextModeServiceDelegate implements IAssistantTextModeService {
    public static final AssistantTextModeServiceDelegate b = null;
    public final /* synthetic */ IAssistantTextModeService a;

    static {
        b = new AssistantTextModeServiceDelegate();
    }

    @Override // com.obric.assistant.audio.service.IAssistantTextModeService
    public final void t8(String r2, String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "botId");
        Intrinsics.checkNotNullParameter(r3, "conversationId");
        this.a.t8(r2, r3, r4);
    }

    private AssistantTextModeServiceDelegate() {
        this.a = (IAssistantTextModeService) ServiceManager.get().getService(IAssistantTextModeService.class);
    }
}
