package com.obric.assistant.state.api.multitask;

import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import com.obric.assistant.state.api.multitask.state.ModeEndReason;
import com.obric.assistant.state.api.multitask.state.ModeRefreshSource;
import com.obric.assistant.state.api.multitask.state.ObricInteractionType;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import zga.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J/\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bH\u0096\u0001J\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0007H\u0096\u0001J>\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bH\u0096\u0001¢\u0006\u0002\u0010\u0015JH\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bH\u0096\u0001¢\u0006\u0002\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/obric/assistant/state/api/multitask/ObricInteractionModeServiceDelegate;", "Lcom/obric/assistant/state/api/multitask/IObricInteractionModeService;", "<init>", "()V", "endMode", "", "sessionId", "", WindowEvent.Params.REASON, "Lcom/obric/assistant/state/api/multitask/state/ModeEndReason;", "ext", "", "", "getActiveMode", "Lcom/obric/assistant/state/api/multitask/ActiveModeSnapshot;", "botId", "refreshMode", "source", "Lcom/obric/assistant/state/api/multitask/state/ModeRefreshSource;", "timeoutMillis", "", "(Ljava/lang/String;Lcom/obric/assistant/state/api/multitask/state/ModeRefreshSource;Ljava/lang/Long;Ljava/util/Map;)V", "startMode", "conversationId", "interactionType", "Lcom/obric/assistant/state/api/multitask/state/ObricInteractionType;", "(Ljava/lang/String;Ljava/lang/String;Lcom/obric/assistant/state/api/multitask/state/ObricInteractionType;Ljava/lang/Long;Ljava/util/Map;)Ljava/lang/String;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricInteractionModeServiceDelegate implements IObricInteractionModeService {
    public static final ObricInteractionModeServiceDelegate b = null;
    public final /* synthetic */ IObricInteractionModeService a;

    static {
        b = new ObricInteractionModeServiceDelegate();
    }

    public final void a(String r2, ModeRefreshSource r3, Long r4, Map<String, ? extends Object> r5) {
        Intrinsics.checkNotNullParameter(r2, "sessionId");
        Intrinsics.checkNotNullParameter(r3, "source");
        Intrinsics.checkNotNullParameter(r5, "ext");
        this.a.a(r2, r3, r4, r5);
    }

    public final void b(String r2, ModeEndReason r3, Map<String, ? extends Object> r4) {
        Intrinsics.checkNotNullParameter(r2, "sessionId");
        Intrinsics.checkNotNullParameter(r3, WindowEvent.Params.REASON);
        Intrinsics.checkNotNullParameter(r4, "ext");
        this.a.b(r2, r3, r4);
    }

    public final a c(String r2) {
        Intrinsics.checkNotNullParameter(r2, "botId");
        return this.a.c(r2);
    }

    public final String d(String r8, String r9, ObricInteractionType r10, Long r11, Map<String, ? extends Object> r12) {
        Intrinsics.checkNotNullParameter(r8, "botId");
        Intrinsics.checkNotNullParameter(r10, "interactionType");
        Intrinsics.checkNotNullParameter(r12, "ext");
        return this.a.d(r8, r9, r10, r11, r12);
    }

    private ObricInteractionModeServiceDelegate() {
        this.a = (IObricInteractionModeService) ServiceManager.get().getService(IObricInteractionModeService.class);
    }
}
