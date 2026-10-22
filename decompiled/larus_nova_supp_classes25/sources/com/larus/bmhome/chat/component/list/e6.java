package com.larus.bmhome.chat.component.list;

import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.bmhome.auth.douyin.IAiChatOpenDouyinAuthService;
import com.larus.im.bean.message.Message;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class e6 implements IAiChatOpenDouyinAuthService.c {
    public final /* synthetic */ ChatListComponent a;
    public final /* synthetic */ com.larus.platform.api.g b;
    public final /* synthetic */ com.larus.platform.api.f c;

    @Override // com.larus.bmhome.auth.douyin.IAiChatOpenDouyinAuthService.c
    public final void onResult(boolean r5) {
        if (r5 == false) goto L7;
        ChatListComponent r6 = this.a;
        int r1 = ChatListComponent.W3;
        IAiChatOpenDouyinAuthService r7 = r6.V4();
        if (r7 == null) goto L15;
        IAiChatOpenDouyinAuthService.a.a(r7, UriProtector.parse(this.b.e), this.c.a, false, 4);
        return;
    L15:
        return;
    L7:
        ChatListComponent r8 = this.a;
        q5 r2 = r8.T;
        if (r2 == null) goto L17;
        IAiChatOpenDouyinAuthService r9 = r8.V4();
        if (r9 == null) goto L12;
        Message r10 = r9.i();
    L13:
        r2.a(false, r10);
        return;
    L12:
        r10 = null;
        goto L13
    }

    public e6(ChatListComponent r1, com.larus.platform.api.g r2, com.larus.platform.api.f r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
