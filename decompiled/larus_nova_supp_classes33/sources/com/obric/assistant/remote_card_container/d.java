package com.obric.assistant.remote_card_container;

import com.larus.im.bean.message.Message;
import com.obric.assistant.remote_card_container.cache.m;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class d implements Runnable {
    public final /* synthetic */ Message a;

    public /* synthetic */ d(Message r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Message r0 = this.a;
        int r1 = RemoteCardImpl.c;
        ufa.a.a.getClass();
        Intrinsics.checkNotNullParameter(r0, "message");
        xca.b.a.getClass();
        final com.obric.assistant.remote_card_container.widget.a r2 = ufa.a.a(r0, xca.b.a.a(r0));
        if (r2 == null) goto L7;
        m.a.b(r2.a, new e(r2));
        return;
    }
}
