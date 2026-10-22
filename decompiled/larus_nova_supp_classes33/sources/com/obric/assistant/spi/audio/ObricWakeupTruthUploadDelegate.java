package com.obric.assistant.spi.audio;

import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import hga.g;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0096\u0001J\t\u0010\t\u001a\u00020\nH\u0096\u0001J\u0011\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rH\u0096\u0001J\u0011\u0010\u000e\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0096\u0001J\u0019\u0010\u000f\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\nH\u0096\u0001J\u0011\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0013H\u0096\u0001J\t\u0010\u0014\u001a\u00020\u0005H\u0096\u0001¨\u0006\u0015"}, d2 = {"Lcom/obric/assistant/spi/audio/ObricWakeupTruthUploadDelegate;", "Lcom/obric/assistant/spi/audio/IObricWakeupTruthUploadService;", "<init>", "()V", "clearRegisterDataIdForUid", "", "uid", "", WindowEvent.Params.REASON, "consumeFirstWakeupAfterVoiceprintRecord", "", "consumeWakeupPocketMode", "wakeupId", "", "markVoiceprintRecordedForNextWakeup", "markWakeupPocketMode", "pocketMode", "onVoiceWakeupAudioCaptured", "data", "Lcom/obric/assistant/spi/audio/WakeupTruthUploadData;", "onVoiceWakeupCaptureStarted", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricWakeupTruthUploadDelegate implements IObricWakeupTruthUploadService {
    public static final ObricWakeupTruthUploadDelegate b = null;
    public final /* synthetic */ IObricWakeupTruthUploadService a;

    static {
        b = new ObricWakeupTruthUploadDelegate();
    }

    @Override // com.obric.assistant.spi.audio.IObricWakeupTruthUploadService
    public final void a() {
        Intrinsics.checkNotNullParameter("voiceprint enroll success", WindowEvent.Params.REASON);
        this.a.a();
    }

    @Override // com.obric.assistant.spi.audio.IObricWakeupTruthUploadService
    public final void b() {
        this.a.b();
    }

    @Override // com.obric.assistant.spi.audio.IObricWakeupTruthUploadService
    public final boolean c() {
        return this.a.c();
    }

    @Override // com.obric.assistant.spi.audio.IObricWakeupTruthUploadService
    public final void d(int r2, boolean r3) {
        this.a.d(r2, r3);
    }

    @Override // com.obric.assistant.spi.audio.IObricWakeupTruthUploadService
    public final void e(g r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        this.a.e(r2);
    }

    @Override // com.obric.assistant.spi.audio.IObricWakeupTruthUploadService
    public final void f(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "uid");
        Intrinsics.checkNotNullParameter(r3, WindowEvent.Params.REASON);
        this.a.f(r2, r3);
    }

    @Override // com.obric.assistant.spi.audio.IObricWakeupTruthUploadService
    public final boolean g(int r2) {
        return this.a.g(r2);
    }

    private ObricWakeupTruthUploadDelegate() {
        this.a = (IObricWakeupTruthUploadService) ServiceManager.get().getService(IObricWakeupTruthUploadService.class);
    }
}
