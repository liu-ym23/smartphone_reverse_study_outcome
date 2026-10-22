package com.larus.bmhome.chat.component.list;

import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class g7 implements Function1 {
    public final /* synthetic */ com.larus.bmhome.social.page.datasource.event.c a;
    public final /* synthetic */ boolean b;

    public /* synthetic */ g7(com.larus.bmhome.social.page.datasource.event.c r1, boolean r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke(Object r3) {
        return ChatListComponentViewModel.Oo(this.a, this.b, (ChatListComponentState) r3);
    }
}
