package com.obric.assistant.audio.sessionstate;

import com.larus.audio.call.mgr.MajorState;
import com.obric.aivoice.core.data.NameKeys;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\u0011\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\u0011\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\u0019\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0096\u0001J\u0011\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\u0011\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\u0011\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\u0019\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0013H\u0096\u0001J\u001b\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0007H\u0096\u0001J\u0011\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\u0019\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0013H\u0096\u0001¨\u0006\u0018"}, d2 = {"Lcom/obric/assistant/audio/sessionstate/AutoHalfDuplexModeServiceDelegate;", "Lcom/obric/assistant/audio/sessionstate/IAutoHalfDuplexModeService;", "<init>", "()V", "nextRound", NameKeys.UnloadStrategy_No_Strategy, "botId", NameKeys.UnloadStrategy_No_Strategy, "onCanceled", "onFailed", "onMajorStateChanged", "prev", "Lcom/larus/audio/call/mgr/MajorState;", "current", "onQueryBegin", "onQueryEnd", "onStarted", "setHasAttachments", "hasAttachment", NameKeys.UnloadStrategy_No_Strategy, "start", "conversationId", "stop", "roundEnd", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AutoHalfDuplexModeServiceDelegate implements IAutoHalfDuplexModeService {
    public static final AutoHalfDuplexModeServiceDelegate b = null;
    public final /* synthetic */ IAutoHalfDuplexModeService a;

    static {
        b = new AutoHalfDuplexModeServiceDelegate();
    }

    @Override // com.obric.assistant.audio.sessionstate.IAutoHalfDuplexModeService
    public final void e(MajorState r2, MajorState r3) {
        Intrinsics.checkNotNullParameter(r2, "prev");
        Intrinsics.checkNotNullParameter(r3, "current");
        this.a.e(r2, r3);
    }

    @Override // com.obric.assistant.audio.sessionstate.IAutoHalfDuplexModeService
    public final void f(String r2) {
        Intrinsics.checkNotNullParameter(r2, "botId");
        this.a.f(r2);
    }

    @Override // com.obric.assistant.audio.sessionstate.IAutoHalfDuplexModeService
    public final void g(String r2) {
        Intrinsics.checkNotNullParameter(r2, "botId");
        this.a.g(r2);
    }

    @Override // com.obric.assistant.audio.sessionstate.IAutoHalfDuplexModeService
    public final void h(String r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "botId");
        this.a.h(r2, r3);
    }

    @Override // com.obric.assistant.audio.sessionstate.IAutoHalfDuplexModeService
    public final void start(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "botId");
        this.a.start(r2, r3);
    }

    @Override // com.obric.assistant.audio.sessionstate.IAutoHalfDuplexModeService
    public final void stop(String r2) {
        Intrinsics.checkNotNullParameter(r2, "botId");
        this.a.stop(r2);
    }

    private AutoHalfDuplexModeServiceDelegate() {
        this.a = (IAutoHalfDuplexModeService) ServiceManager.get().getService(IAutoHalfDuplexModeService.class);
    }
}
