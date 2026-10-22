package com.obric.assistant.authenticationsession;

import com.larus.im.bean.message.Message;
import com.obric.assistant.AuthenticationType;
import kotlin.Pair;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class e implements Runnable {
    public final /* synthetic */ QueryAuthenticationServiceImpl a;
    public final /* synthetic */ Message b;

    public /* synthetic */ e(QueryAuthenticationServiceImpl r1, Message r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        QueryAuthenticationServiceImpl r0 = this.a;
        Message r1 = this.b;
        int r2 = QueryAuthenticationServiceImpl.i;
        Pair r3 = r0.a();
        boolean r4 = ((Boolean) r3.component1()).booleanValue();
        AuthenticationType r5 = (AuthenticationType) r3.component2();
        if (r4 == false) goto L6;
        r0.e(r1, true, r5);
        return;
    }
}
