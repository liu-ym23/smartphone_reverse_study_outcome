package com.obric.assistant.state.api.multitask;

import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import zga.b;
import zga.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH\u0096\u0001J\u0011\u0010\n\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0096\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0096\u0001¨\u0006\r"}, d2 = {"Lcom/obric/assistant/state/api/multitask/ObricInteractionProjectionDelegate;", "Lcom/obric/assistant/state/api/multitask/IObricInteractionProjectionService;", "<init>", "()V", "observe", "", "botId", "", "observer", "Lcom/obric/assistant/state/api/multitask/InteractionProjectionObserver;", "removeObserver", "snapshot", "Lcom/obric/assistant/state/api/multitask/InteractionProjection;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricInteractionProjectionDelegate implements IObricInteractionProjectionService {
    public static final ObricInteractionProjectionDelegate b = null;
    public final /* synthetic */ IObricInteractionProjectionService a;

    static {
        b = new ObricInteractionProjectionDelegate();
    }

    public final b a(String r2) {
        return this.a.a(r2);
    }

    public final void b(String r2, c r3) {
        Intrinsics.checkNotNullParameter(r3, "observer");
        this.a.b(r2, r3);
    }

    public final void c(c r2) {
        Intrinsics.checkNotNullParameter(r2, "observer");
        this.a.c(r2);
    }

    private ObricInteractionProjectionDelegate() {
        this.a = (IObricInteractionProjectionService) ServiceManager.get().getService(IObricInteractionProjectionService.class);
    }
}
