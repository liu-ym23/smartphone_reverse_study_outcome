package com.obric.assistant.performance;

import com.larus.audio.IAudioService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final /* synthetic */ class a implements Function0 {
    public /* synthetic */ a() {
    }

    public final Object invoke() {
        return (IAudioService) ServiceManager.get().getService(IAudioService.class);
    }
}
