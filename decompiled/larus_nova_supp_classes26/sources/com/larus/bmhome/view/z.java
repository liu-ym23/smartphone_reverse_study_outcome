package com.larus.bmhome.view;

import com.larus.bmhome.share.panel.ShareType;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class z implements Function2 {
    public final /* synthetic */ ChatInputReply a;

    public /* synthetic */ z(ChatInputReply r1) {
        this.a = r1;
    }

    public final Object invoke(Object r2, Object r3) {
        ChatInputReply r0 = this.a;
        String r4 = (String) r2;
        ((Integer) r3).intValue();
        int r5 = ChatInputReply.d;
        Intrinsics.checkNotNullParameter(r4, ShareType.TEXT);
        r0.c.invoke(r4);
        return Unit.INSTANCE;
    }
}
