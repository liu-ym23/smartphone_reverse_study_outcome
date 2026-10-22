package com.obric.assistant.remote_card_container.cache;

import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final /* synthetic */ class b implements Function0 {
    public /* synthetic */ b() {
    }

    public final Object invoke() {
        PthreadHandlerThreadV2 r0 = new PthreadHandlerThreadV2("obric_card_cache");
        ThreadMethodProxy.start(r0);
        return r0;
    }
}
