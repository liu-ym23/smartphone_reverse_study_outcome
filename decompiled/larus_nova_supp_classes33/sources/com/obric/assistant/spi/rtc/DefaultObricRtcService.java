package com.obric.assistant.spi.rtc;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\b"}, d2 = {"Lcom/obric/assistant/spi/rtc/DefaultObricRtcService;", "Lcom/obric/assistant/spi/rtc/IObricRtcService;", "<init>", "()V", "collectRealtimeCallServicePlugins", "", "", "context", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DefaultObricRtcService implements IObricRtcService {
    public DefaultObricRtcService() {
    }

    @Override // com.obric.assistant.spi.rtc.IObricRtcService
    public final List<Object> a(Object r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return null;
    }
}
