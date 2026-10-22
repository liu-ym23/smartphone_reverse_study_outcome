package com.larus.bmhome.chat.component.list;

import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class v6 implements Function1 {
    public final /* synthetic */ ChatListComponentViewModel a;
    public final /* synthetic */ Function1 b;

    public /* synthetic */ v6(ChatListComponentViewModel r1, Function1 r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke(Object r3) {
        return ChatListComponentViewModel.Qo(this.a, this.b, (com.larus.bmhome.social.page.datasource.event.c) r3);
    }
}
