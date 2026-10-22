package com.larus.bmhome.double_post.drag_panel;

import com.larus.bmhome.chat.component.list.u7;
import com.larus.bmhome.databinding.LarusPageChatBinding;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class h implements Runnable {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ ChatAwemeFeedComponent b;
    public final /* synthetic */ boolean c;

    public /* synthetic */ h(boolean r1, ChatAwemeFeedComponent r2) {
        this.a = r1;
        this.b = r2;
        this.c = false;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean r0 = this.a;
        ChatAwemeFeedComponent r1 = this.b;
        boolean r2 = this.c;
        int r3 = ChatAwemeFeedComponent.V;
        if (r0 == false) goto L7;
        u7 r4 = r1.B3();
        if (r4 == null) goto L7;
        r4.TP(false);
    L7:
        LarusPageChatBinding r5 = r1.p3();
        if (r5 == null) goto L13;
        ChatAwemeNestedContainer r6 = r5.b;
        if (r6 == null) goto L14;
        r6.h(r2);
        return;
    L14:
        return;
    }
}
