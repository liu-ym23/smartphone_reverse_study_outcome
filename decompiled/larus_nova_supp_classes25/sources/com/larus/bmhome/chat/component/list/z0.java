package com.larus.bmhome.chat.component.list;

import com.larus.bmhome.view.ChatMessageList;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class z0 implements Function0 {
    public final /* synthetic */ ChatMessageList a;
    public final /* synthetic */ int b;
    public final /* synthetic */ int c;

    public /* synthetic */ z0(ChatMessageList r1, int r2, int r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final Object invoke() {
        ChatMessageList r0 = this.a;
        int r1 = this.b;
        int r2 = this.c;
        int r3 = ChatListComponent.W3;
        r0.d0(r1, r2, true);
        return Unit.INSTANCE;
    }
}
