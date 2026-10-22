package com.obric.assistant.audio.service;

import com.obric.aivoice.core.data.NameKeys;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\u0011\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\u0019\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H\u0096\u0001J\u0019\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H\u0096\u0001J\u0011\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J!\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0011H\u0096\u0001J!\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0011H\u0096\u0001J\u0011\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\u0011\u0010\u0014\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0007H\u0096\u0001¨\u0006\u0015"}, d2 = {"Lcom/obric/assistant/audio/service/ManualHalfDuplexModeServiceDelegate;", "Lcom/obric/assistant/audio/service/IManualHalfDuplexModeService;", "<init>", "()V", "onCanceled", NameKeys.UnloadStrategy_No_Strategy, "botId", NameKeys.UnloadStrategy_No_Strategy, "onFailed", "onQueryEnd", "text", "onQueryEndSession", "sessionId", "onStarted", "start", "conversationId", "hasAttachment", NameKeys.UnloadStrategy_No_Strategy, "startSession", "stop", "stopSession", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ManualHalfDuplexModeServiceDelegate implements IManualHalfDuplexModeService {
    public static final ManualHalfDuplexModeServiceDelegate b = null;
    public final /* synthetic */ IManualHalfDuplexModeService a;

    static {
        b = new ManualHalfDuplexModeServiceDelegate();
    }

    @Override // com.obric.assistant.audio.service.IManualHalfDuplexModeService
    public final void a(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "sessionId");
        Intrinsics.checkNotNullParameter(r3, "text");
        this.a.a(r2, r3);
    }

    @Override // com.obric.assistant.audio.service.IManualHalfDuplexModeService
    public final void b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "sessionId");
        this.a.b(r2);
    }

    @Override // com.obric.assistant.audio.service.IManualHalfDuplexModeService
    public final String c(String r2, String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "botId");
        Intrinsics.checkNotNullParameter(r3, "conversationId");
        return this.a.c(r2, r3, r4);
    }

    @Override // com.obric.assistant.audio.service.IManualHalfDuplexModeService
    public final void d(String r2) {
        Intrinsics.checkNotNullParameter(r2, "botId");
        this.a.d(r2);
    }

    @Override // com.obric.assistant.audio.service.IManualHalfDuplexModeService
    public final void stop(String r2) {
        Intrinsics.checkNotNullParameter(r2, "botId");
        this.a.stop(r2);
    }

    private ManualHalfDuplexModeServiceDelegate() {
        this.a = (IManualHalfDuplexModeService) ServiceManager.get().getService(IManualHalfDuplexModeService.class);
    }
}
