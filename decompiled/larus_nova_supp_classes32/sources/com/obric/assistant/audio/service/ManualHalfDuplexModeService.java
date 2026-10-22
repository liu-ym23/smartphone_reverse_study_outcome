package com.obric.assistant.audio.service;

import com.larus.utils.logger.FLogger;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.state.api.multitask.IObricInteractionModeService;
import com.obric.assistant.state.api.multitask.ObricInteractionModeServiceDelegate;
import com.obric.assistant.state.api.multitask.state.ModeEndReason;
import com.obric.assistant.state.api.multitask.state.ModeRefreshSource;
import com.obric.assistant.state.api.multitask.state.ObricInteractionType;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0016J \u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0007H\u0016J\u0018\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0007H\u0016J\u0018\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0007H\u0016J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\u0016"}, d2 = {"Lcom/obric/assistant/audio/service/ManualHalfDuplexModeService;", "Lcom/obric/assistant/audio/service/IManualHalfDuplexModeService;", "<init>", "()V", "start", NameKeys.UnloadStrategy_No_Strategy, "botId", NameKeys.UnloadStrategy_No_Strategy, "conversationId", "hasAttachment", NameKeys.UnloadStrategy_No_Strategy, "startSession", "stop", "stopSession", "sessionId", "onQueryEnd", "text", "onQueryEndSession", "onCanceled", "onStarted", "onFailed", "Companion", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ManualHalfDuplexModeService implements IManualHalfDuplexModeService {

    public static final class a {
    }

    static {
    }

    public ManualHalfDuplexModeService() {
    }

    @Override // com.obric.assistant.audio.service.IManualHalfDuplexModeService
    public final void b(String r4) {
        Intrinsics.checkNotNullParameter(r4, "sessionId");
        FLogger.a.d("ManualHalfDuplexModeService", "onObricModeStop sessionId:".concat(r4));
        IObricInteractionModeService.a.a(ObricInteractionModeServiceDelegate.b, r4, ModeEndReason.NORMAL);
    }

    @Override // com.obric.assistant.audio.service.IManualHalfDuplexModeService
    public final void d(String r3) {
        Intrinsics.checkNotNullParameter(r3, "botId");
        FLogger.a.d("ManualHalfDuplexModeService", "ObricMode onStarted");
    }

    @Override // com.obric.assistant.audio.service.IManualHalfDuplexModeService
    public final void stop(String r4) {
        Intrinsics.checkNotNullParameter(r4, "botId");
        FLogger.a.d("ManualHalfDuplexModeService", "onObricModeStop");
        ObricInteractionModeServiceDelegate r0 = ObricInteractionModeServiceDelegate.b;
        zga.a r5 = r0.c(r4);
        if (r5 != null) goto L5;
        return;
    L5:
        if (r5.d != ObricInteractionType.ManualHalfDuplex) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == true) goto L11;
        r5 = null;
    L11:
        if (r5 == null) goto L15;
        IObricInteractionModeService.a.a(r0, r5.c, ModeEndReason.NORMAL);
        return;
    L15:
        return;
    L7:
        r1 = false;
        goto L8
    }

    @Override // com.obric.assistant.audio.service.IManualHalfDuplexModeService
    public final void a(String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "sessionId");
        Intrinsics.checkNotNullParameter(r5, "text");
        FLogger.a.d("ManualHalfDuplexModeService", "ObricMode onQueryEnd");
        ObricInteractionModeServiceDelegate.b.a(r4, ModeRefreshSource.BUSINESS, null, MapsKt.emptyMap());
    }

    @Override // com.obric.assistant.audio.service.IManualHalfDuplexModeService
    public final String c(String r10, String r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r10, "botId");
        Intrinsics.checkNotNullParameter(r11, "conversationId");
        FLogger.a.d("ManualHalfDuplexModeService", "onObricModeStart");
        return IObricInteractionModeService.a.b(ObricInteractionModeServiceDelegate.b, r10, r11, ObricInteractionType.ManualHalfDuplex, MapsKt.mapOf(TuplesKt.to("has_attachment", Boolean.valueOf(r12))), 8);
    }
}
