package com.larus.voicecall.impl.ui;

import com.obric.assistant.spi.audio.IObricRealtimeCallExtService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class b implements Function0 {
    public /* synthetic */ b() {
    }

    public final Object invoke() {
        int r0 = RealtimeCallActivity.l;
        return (IObricRealtimeCallExtService) ServiceManager.get().getService(IObricRealtimeCallExtService.class);
    }
}
