package com.larus.chat.gallery.impl.preview.toolbar.action;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class h0 implements Function0 {
    public final /* synthetic */ Ref.BooleanRef a;
    public final /* synthetic */ Function0 b;

    public /* synthetic */ h0(Ref.BooleanRef r1, Function0 r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke() {
        Ref.BooleanRef r0 = this.a;
        Function0 r1 = this.b;
        if (r0.element == true) goto L6;
        r0.element = true;
        r1.invoke();
    L6:
        return Unit.INSTANCE;
    }
}
