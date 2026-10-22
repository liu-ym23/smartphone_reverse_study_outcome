package com.obric.assistant.state.api.multitask;

import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0096\u0001J\u0019\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0096\u0001J)\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0096\u0001J!\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\rH\u0096\u0001J\u0019\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0096\u0001J\u0019\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0096\u0001¨\u0006\u0013"}, d2 = {"Lcom/obric/assistant/state/api/multitask/ObricRealtimeCallStateProducerServiceDelegate;", "Lcom/obric/assistant/state/api/multitask/IObricRealtimeCallStateProducerService;", "<init>", "()V", "onCallEntered", "", "botId", "", "conversationId", "onCallExited", "onMajorStateChanged", "callId", "prevState", "", "currentState", "onMuteStateChanged", "state", "onPluginStarted", "onPluginStopped", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricRealtimeCallStateProducerServiceDelegate implements IObricRealtimeCallStateProducerService {
    public static final ObricRealtimeCallStateProducerServiceDelegate b = null;
    public final /* synthetic */ IObricRealtimeCallStateProducerService a;

    static {
        b = new ObricRealtimeCallStateProducerServiceDelegate();
    }

    @Override // com.obric.assistant.state.api.multitask.IObricRealtimeCallStateProducerService
    public final void a(String r2, String r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "callId");
        Intrinsics.checkNotNullParameter(r3, "conversationId");
        this.a.a(r2, r3, r4);
    }

    @Override // com.obric.assistant.state.api.multitask.IObricRealtimeCallStateProducerService
    public final void b(String r2, String r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r2, "callId");
        Intrinsics.checkNotNullParameter(r3, "conversationId");
        this.a.b(r2, r3, r4, r5);
    }

    @Override // com.obric.assistant.state.api.multitask.IObricRealtimeCallStateProducerService
    public final void c(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "botId");
        Intrinsics.checkNotNullParameter(r3, "conversationId");
        this.a.c(r2, r3);
    }

    @Override // com.obric.assistant.state.api.multitask.IObricRealtimeCallStateProducerService
    public final void d(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "botId");
        Intrinsics.checkNotNullParameter(r3, "conversationId");
        this.a.d(r2, r3);
    }

    @Override // com.obric.assistant.state.api.multitask.IObricRealtimeCallStateProducerService
    public final void e(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "callId");
        Intrinsics.checkNotNullParameter(r3, "conversationId");
        this.a.e(r2, r3);
    }

    @Override // com.obric.assistant.state.api.multitask.IObricRealtimeCallStateProducerService
    public final void g(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "callId");
        Intrinsics.checkNotNullParameter(r3, "conversationId");
        this.a.g(r2, r3);
    }

    private ObricRealtimeCallStateProducerServiceDelegate() {
        this.a = (IObricRealtimeCallStateProducerService) ServiceManager.get().getService(IObricRealtimeCallStateProducerService.class);
    }
}
