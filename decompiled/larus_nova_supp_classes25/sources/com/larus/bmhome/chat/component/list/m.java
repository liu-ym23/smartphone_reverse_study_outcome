package com.larus.bmhome.chat.component.list;

import android.view.MotionEvent;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class m implements Function1 {
    public final /* synthetic */ ChatListComponent a;

    public /* synthetic */ m(ChatListComponent r1) {
        this.a = r1;
    }

    public final Object invoke(Object r3) {
        ChatListComponent r0 = this.a;
        int r1 = ChatListComponent.W3;
        Intrinsics.checkNotNullParameter((MotionEvent) r3, "it");
        r0.a4();
        return Boolean.FALSE;
    }
}
