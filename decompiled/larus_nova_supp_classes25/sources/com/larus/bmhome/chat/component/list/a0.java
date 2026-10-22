package com.larus.bmhome.chat.component.list;

import android.view.MotionEvent;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class a0 implements Function1 {
    public final /* synthetic */ Function1 a;

    public /* synthetic */ a0(Function1 r1) {
        this.a = r1;
    }

    public final Object invoke(Object r3) {
        Function1 r0 = this.a;
        MotionEvent r4 = (MotionEvent) r3;
        int r1 = ChatListComponent.W3;
        Intrinsics.checkNotNullParameter(r4, "it");
        r0.invoke(r4);
        return Boolean.FALSE;
    }
}
