package com.obric.assistant.state.api.multitask;

import com.obric.assistant.state.api.multitask.state.VoiceCaptureScene;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J4\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0096\u0001¢\u0006\u0002\u0010\rJ4\u0010\u000e\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0096\u0001¢\u0006\u0002\u0010\rJ4\u0010\u000f\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0096\u0001¢\u0006\u0002\u0010\rJ<\u0010\u0010\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\f2\b\u0010\n\u001a\u0004\u0018\u00010\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0096\u0001¢\u0006\u0002\u0010\u0012J>\u0010\u0013\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0007H\u0096\u0001¢\u0006\u0002\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/obric/assistant/state/api/multitask/VoiceCaptureStateProducerDelegate;", "Lcom/obric/assistant/state/api/multitask/IVoiceCaptureStateProducerService;", "<init>", "()V", "end", "", "conversationId", "", "scene", "Lcom/obric/assistant/state/api/multitask/state/VoiceCaptureScene;", "sessionId", "sourceType", "", "(Ljava/lang/String;Lcom/obric/assistant/state/api/multitask/state/VoiceCaptureScene;Ljava/lang/String;Ljava/lang/Integer;)V", "onAsrEnd", "onAsrStart", "onCallStateChanged", "callState", "(Ljava/lang/String;Lcom/obric/assistant/state/api/multitask/state/VoiceCaptureScene;ILjava/lang/String;Ljava/lang/Integer;)V", "start", "botId", "(Ljava/lang/String;Lcom/obric/assistant/state/api/multitask/state/VoiceCaptureScene;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VoiceCaptureStateProducerDelegate implements IVoiceCaptureStateProducerService {
    public static final VoiceCaptureStateProducerDelegate b = null;
    public final /* synthetic */ IVoiceCaptureStateProducerService a;

    static {
        b = new VoiceCaptureStateProducerDelegate();
    }

    @Override // com.obric.assistant.state.api.multitask.IVoiceCaptureStateProducerService
    public final void a(String r8, VoiceCaptureScene r9, int r10, String r11, Integer r12) {
        Intrinsics.checkNotNullParameter(r9, "scene");
        this.a.a(r8, r9, r10, r11, r12);
    }

    @Override // com.obric.assistant.state.api.multitask.IVoiceCaptureStateProducerService
    public final void b(String r8, VoiceCaptureScene r9, String r10, Integer r11, String r12) {
        Intrinsics.checkNotNullParameter(r9, "scene");
        this.a.b(r8, r9, r10, r11, r12);
    }

    @Override // com.obric.assistant.state.api.multitask.IVoiceCaptureStateProducerService
    public final void c(String r2, VoiceCaptureScene r3, String r4, Integer r5) {
        Intrinsics.checkNotNullParameter(r3, "scene");
        this.a.c(r2, r3, r4, r5);
    }

    @Override // com.obric.assistant.state.api.multitask.IVoiceCaptureStateProducerService
    public final void d(String r2, VoiceCaptureScene r3, String r4, Integer r5) {
        Intrinsics.checkNotNullParameter(r3, "scene");
        this.a.d(r2, r3, r4, r5);
    }

    @Override // com.obric.assistant.state.api.multitask.IVoiceCaptureStateProducerService
    public final void e(String r2, VoiceCaptureScene r3, String r4, Integer r5) {
        Intrinsics.checkNotNullParameter(r3, "scene");
        this.a.e(r2, r3, r4, r5);
    }

    private VoiceCaptureStateProducerDelegate() {
        this.a = (IVoiceCaptureStateProducerService) ServiceManager.get().getService(IVoiceCaptureStateProducerService.class);
    }
}
