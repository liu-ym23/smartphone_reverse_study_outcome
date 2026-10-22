package com.obric.assistant.audio.service;

import com.larus.audio.call.mgr.MajorState;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.audio.sessionstate.IAutoHalfDuplexModeService;
import com.obric.assistant.state.api.multitask.IObricInteractionModeService;
import com.obric.assistant.state.api.multitask.ObricInteractionModeServiceDelegate;
import com.obric.assistant.state.api.multitask.state.ModeEndReason;
import com.obric.assistant.state.api.multitask.state.ModeRefreshSource;
import com.obric.assistant.state.api.multitask.state.ObricInteractionType;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0007\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0018\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u000bH\u0016J\u0018\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J(\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0016\b\u0002\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u001bH\u0002¨\u0006\u001e"}, d2 = {"Lcom/obric/assistant/audio/service/AutoHalfDuplexModeService;", "Lcom/obric/assistant/audio/sessionstate/IAutoHalfDuplexModeService;", "<init>", "()V", "start", NameKeys.UnloadStrategy_No_Strategy, "botId", NameKeys.UnloadStrategy_No_Strategy, "conversationId", "stop", "roundEnd", NameKeys.UnloadStrategy_No_Strategy, "onQueryEnd", "onCanceled", "onStarted", "onFailed", "setHasAttachments", "hasAttachment", "onMajorStateChanged", "prev", "Lcom/larus/audio/call/mgr/MajorState;", "current", "onQueryBegin", "nextRound", "endMode", "refreshMode", "ext", NameKeys.UnloadStrategy_No_Strategy, NameKeys.UnloadStrategy_No_Strategy, "Companion", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AutoHalfDuplexModeService implements IAutoHalfDuplexModeService {

    public static final class a {
    }

    static {
    }

    public AutoHalfDuplexModeService() {
    }

    @Override // com.obric.assistant.audio.sessionstate.IAutoHalfDuplexModeService
    public final void e(MajorState r2, MajorState r3) {
        Intrinsics.checkNotNullParameter(r2, "prev");
        Intrinsics.checkNotNullParameter(r3, "current");
    }

    @Override // com.obric.assistant.audio.sessionstate.IAutoHalfDuplexModeService
    public final void f(String r2) {
        Intrinsics.checkNotNullParameter(r2, "botId");
        a(r2, MapsKt.emptyMap());
    }

    @Override // com.obric.assistant.audio.sessionstate.IAutoHalfDuplexModeService
    public final void g(String r2) {
        Intrinsics.checkNotNullParameter(r2, "botId");
        a(r2, MapsKt.emptyMap());
    }

    @Override // com.obric.assistant.audio.sessionstate.IAutoHalfDuplexModeService
    public final void stop(String r4) {
        Intrinsics.checkNotNullParameter(r4, "botId");
        ObricInteractionModeServiceDelegate r0 = ObricInteractionModeServiceDelegate.b;
        zga.a r5 = r0.c(r4);
        if (r5 != null) goto L5;
        return;
    L5:
        if (r5.d != ObricInteractionType.AutoHalfDuplex) goto L7;
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

    public static void a(String r3, Map r4) {
        ObricInteractionModeServiceDelegate r0 = ObricInteractionModeServiceDelegate.b;
        zga.a r5 = r0.c(r3);
        if (r5 != null) goto L5;
        return;
    L5:
        if (r5.d != ObricInteractionType.AutoHalfDuplex) goto L7;
        boolean r1 = true;
    L9:
        if (r1 == true) goto L12;
        r5 = null;
    L12:
        if (r5 == null) goto L16;
        r0.a(r5.c, ModeRefreshSource.BUSINESS, null, r4);
        return;
    L16:
        return;
    L7:
        r1 = false;
        goto L9
    }

    @Override // com.obric.assistant.audio.sessionstate.IAutoHalfDuplexModeService
    public final void h(String r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "botId");
        a(r2, MapsKt.mapOf(TuplesKt.to("has_attachment", Boolean.valueOf(r3))));
    }

    @Override // com.obric.assistant.audio.sessionstate.IAutoHalfDuplexModeService
    public final void start(String r8, String r9) {
        Intrinsics.checkNotNullParameter(r8, "botId");
        IObricInteractionModeService.a.b(ObricInteractionModeServiceDelegate.b, r8, r9, ObricInteractionType.AutoHalfDuplex, null, 24);
    }
}
