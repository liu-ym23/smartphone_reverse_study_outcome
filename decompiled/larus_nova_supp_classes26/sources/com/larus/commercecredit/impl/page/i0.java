package com.larus.commercecredit.impl.page;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class i0 implements Function1 {
    public final /* synthetic */ CommerceInviteFriendsFragment a;
    public final /* synthetic */ Function1 b;

    public /* synthetic */ i0(CommerceInviteFriendsFragment r1, Function1 r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke(Object r3) {
        CommerceInviteFriendsFragment r0 = this.a;
        Function1 r1 = this.b;
        qz8.l r4 = (qz8.l) r3;
        r0.h = r4;
        r1.invoke(r4);
        return Unit.INSTANCE;
    }
}
