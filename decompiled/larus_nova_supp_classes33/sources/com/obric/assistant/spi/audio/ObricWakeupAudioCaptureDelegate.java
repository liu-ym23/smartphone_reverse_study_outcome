package com.obric.assistant.spi.audio;

import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import com.obric.capabilitykit.common.Ext;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import hga.c;
import hga.e;
import hga.f;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u0006\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0096\u0001J\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eH\u0096\u0001¨\u0006\u000f"}, d2 = {"Lcom/obric/assistant/spi/audio/ObricWakeupAudioCaptureDelegate;", "Lcom/obric/assistant/spi/audio/IObricWakeupAudioCaptureService;", "<init>", "()V", "hasActiveCapture", "", "isCaptureEnabled", "onWakeupTrigger", "", WindowEvent.Params.TRIGGER, "Lcom/obric/assistant/spi/audio/WakeupAudioCaptureTrigger;", "openReader", "Lcom/obric/assistant/spi/audio/IObricWakeupAudioCaptureReader;", Ext.KEY_REQUEST, "Lcom/obric/assistant/spi/audio/WakeupAudioCaptureReadRequest;", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricWakeupAudioCaptureDelegate implements IObricWakeupAudioCaptureService {
    public static final ObricWakeupAudioCaptureDelegate b = null;
    public final /* synthetic */ IObricWakeupAudioCaptureService a;

    static {
        b = new ObricWakeupAudioCaptureDelegate();
    }

    @Override // com.obric.assistant.spi.audio.IObricWakeupAudioCaptureService
    public final boolean a() {
        return this.a.a();
    }

    @Override // com.obric.assistant.spi.audio.IObricWakeupAudioCaptureService
    public final void b(f r2) {
        Intrinsics.checkNotNullParameter(r2, WindowEvent.Params.TRIGGER);
        this.a.b(r2);
    }

    @Override // com.obric.assistant.spi.audio.IObricWakeupAudioCaptureService
    public final c c(e r2) {
        Intrinsics.checkNotNullParameter(r2, Ext.KEY_REQUEST);
        return this.a.c(r2);
    }

    private ObricWakeupAudioCaptureDelegate() {
        this.a = (IObricWakeupAudioCaptureService) ServiceManager.get().getService(IObricWakeupAudioCaptureService.class);
    }
}
