package com.larus.bmhome.chat.component.list;

import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class k7 implements Function1 {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ Function1 b;
    public final /* synthetic */ Function1 c;
    public final /* synthetic */ ChatListComponentViewModel d;

    public /* synthetic */ k7(boolean r1, Function1 r2, Function1 r3, ChatListComponentViewModel r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final Object invoke(Object r5) {
        return ChatListComponentViewModel.np(this.a, this.b, this.c, this.d, (ChatListComponentState) r5);
    }
}
