package com.obric.assistant.spi.audio;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0014\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J \u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\n\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016¨\u0006\u0010"}, d2 = {"Lcom/obric/assistant/spi/audio/DefaultObricVadServiceImpl;", "Lcom/obric/assistant/spi/audio/IObricVadService;", "<init>", "()V", "preload", "", "isVoiceActive", "buffer", "", "offsetInBytes", "", "sizeInBytes", "release", "", "getFeatureValues", "", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DefaultObricVadServiceImpl implements IObricVadService {
    public DefaultObricVadServiceImpl() {
    }

    @Override // com.obric.assistant.spi.audio.IObricVadService
    public final float[] a() {
        return null;
    }

    @Override // com.obric.assistant.spi.audio.IObricVadService
    public final boolean b(byte[] r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "buffer");
        return false;
    }

    @Override // com.obric.assistant.spi.audio.IObricVadService
    public final boolean preload() {
        return false;
    }

    @Override // com.obric.assistant.spi.audio.IObricVadService
    public final void release() {
    }
}
