package com.larus.avlink.plugins;

import com.larus.bmhome.auth.douyin.IAiChatOpenDouyinAuthService;
import com.larus.im.bean.message.Message;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class v0 implements ya8.a {
    public final /* synthetic */ DoraFirstPartyAuthPlugin a;

    public v0(DoraFirstPartyAuthPlugin r1) {
        this.a = r1;
    }

    @Override // ya8.a
    public final void a(boolean r3, Message r4) {
        IAiChatOpenDouyinAuthService r5 = this.a.o3();
        if (r5 == null) goto L5;
        r5.g();
    L5:
        com.larus.avlink.n1.d(this.a.f, "Douyin auth result: " + r3 + ", " + this.a.h);
        this.a.getClass();
        if (r3 == false) goto L8;
        DoraFirstPartyAuthPlugin.k3(this.a);
    L8:
        DoraFirstPartyAuthPlugin r6 = this.a;
        r6.h = null;
        r6.g = false;
        if (r6.i3() == true) goto L12;
        this.a.v3();
        return;
    }
}
