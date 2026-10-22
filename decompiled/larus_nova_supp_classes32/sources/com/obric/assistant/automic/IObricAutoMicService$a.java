package com.obric.assistant.automic;

import com.ss.android.ugc.aweme.framework.services.ServiceManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class IObricAutoMicService$a {
    public static final /* synthetic */ IObricAutoMicService$a a = null;

    static {
        a = new IObricAutoMicService$a();
    }

    public IObricAutoMicService$a() {
    }

    public static IObricAutoMicService a() {
        return (IObricAutoMicService) ServiceManager.get().getService(IObricAutoMicService.class, false, false);
    }
}
