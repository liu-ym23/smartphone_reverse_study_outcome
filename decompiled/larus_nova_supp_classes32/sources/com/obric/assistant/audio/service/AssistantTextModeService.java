package com.obric.assistant.audio.service;

import com.larus.utils.logger.FLogger;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.state.api.multitask.IObricInteractionModeService;
import com.obric.assistant.state.api.multitask.ObricInteractionModeServiceDelegate;
import com.obric.assistant.state.api.multitask.state.ObricInteractionType;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\r"}, d2 = {"Lcom/obric/assistant/audio/service/AssistantTextModeService;", "Lcom/obric/assistant/audio/service/IAssistantTextModeService;", "<init>", "()V", "start", NameKeys.UnloadStrategy_No_Strategy, "botId", NameKeys.UnloadStrategy_No_Strategy, "conversationId", "hasAttachment", NameKeys.UnloadStrategy_No_Strategy, "stop", "Companion", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AssistantTextModeService implements IAssistantTextModeService {

    public static final class a {
    }

    static {
    }

    public AssistantTextModeService() {
    }

    @Override // com.obric.assistant.audio.service.IAssistantTextModeService
    public final void t8(String r10, String r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r10, "botId");
        Intrinsics.checkNotNullParameter(r11, "conversationId");
        FLogger.a.d("AssistantTextModeService", "start botId:" + r10 + " convId:" + r11 + " hasAttachment:" + r12);
        IObricInteractionModeService.a.b(ObricInteractionModeServiceDelegate.b, r10, r11, ObricInteractionType.TextMode, MapsKt.mapOf(TuplesKt.to("has_attachment", Boolean.valueOf(r12))), 8);
    }
}
