package com.larus.dora.o.impl.diary;

import com.larus.dora.api.config.IDoraPageConfig;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class d0 {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static IDoraPageConfig a() {
        return (IDoraPageConfig) ServiceManager.get().getService(IDoraPageConfig.class);
    }
}
