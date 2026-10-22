package com.obric.assistant.reporter.utils;

import com.bytedance.ai.api.AppletExtService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final /* synthetic */ class a implements Function0 {
    public /* synthetic */ a() {
    }

    public final Object invoke() {
        return (AppletExtService) ServiceManager.get().getService(AppletExtService.class);
    }
}
