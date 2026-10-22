package com.obric.assistant.spi.audio;

import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0096\u0001J!\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0096\u0001J\t\u0010\r\u001a\u00020\u0007H\u0096\u0001J\t\u0010\u000e\u001a\u00020\u000fH\u0096\u0001¨\u0006\u0010"}, d2 = {"Lcom/obric/assistant/spi/audio/ObricVadDelegate;", "Lcom/obric/assistant/spi/audio/IObricVadService;", "<init>", "()V", "getFeatureValues", "", "isVoiceActive", "", "buffer", "", "offsetInBytes", "", "sizeInBytes", "preload", "release", "", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricVadDelegate implements IObricVadService {
    public static final ObricVadDelegate b = null;
    public final /* synthetic */ IObricVadService a;

    static {
        b = new ObricVadDelegate();
    }

    @Override // com.obric.assistant.spi.audio.IObricVadService
    public final float[] a() {
        return this.a.a();
    }

    @Override // com.obric.assistant.spi.audio.IObricVadService
    public final boolean b(byte[] r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "buffer");
        return this.a.b(r2, r3);
    }

    @Override // com.obric.assistant.spi.audio.IObricVadService
    public final boolean preload() {
        return this.a.preload();
    }

    @Override // com.obric.assistant.spi.audio.IObricVadService
    public final void release() {
        this.a.release();
    }

    private ObricVadDelegate() {
        IObricVadService r0 = (IObricVadService) ServiceManager.get().getService(IObricVadService.class);
        if (r0 != null) goto L5;
        r0 = new DefaultObricVadServiceImpl();
    L5:
        this.a = r0;
    }
}
