package com.obric.assistant.frontier;

import com.larus.im.IInstantMessenger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final /* synthetic */ class a implements Function0 {
    public /* synthetic */ a() {
    }

    public final Object invoke() {
        IInstantMessenger r0 = (IInstantMessenger) ServiceManager.get().getService(IInstantMessenger.class);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.a(0);
    }
}
