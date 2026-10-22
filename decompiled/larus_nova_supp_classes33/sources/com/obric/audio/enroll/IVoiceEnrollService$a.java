package com.obric.audio.enroll;

import com.ss.android.ugc.aweme.framework.services.ServiceManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class IVoiceEnrollService$a {
    public static final /* synthetic */ IVoiceEnrollService$a a = null;

    static {
        a = new IVoiceEnrollService$a();
    }

    public IVoiceEnrollService$a() {
    }

    public static IVoiceEnrollService a() {
        return (IVoiceEnrollService) ServiceManager.get().getService(IVoiceEnrollService.class, false, false);
    }
}
