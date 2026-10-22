package com.larus.chat.gallery.impl.preview.toolbar.action;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class q implements o {
    public final o a;
    public final o b;

    public q() {
        ShareAction r0 = new ShareAction();
        LocalMediaShareAction r1 = new LocalMediaShareAction();
        Intrinsics.checkNotNullParameter(r0, "networkAction");
        Intrinsics.checkNotNullParameter(r1, "localAction");
        this.a = r0;
        this.b = r1;
    }

    @Override // com.larus.chat.gallery.impl.preview.toolbar.action.o
    public final Object a(l0 r2, Continuation<? super Unit> r3) {
        if (r2.a.p != null) goto L5;
        o r0 = this.a;
    L6:
        Object r4 = r0.a(r2, r3);
        if (r4 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L10;
        return r4;
    L10:
        return Unit.INSTANCE;
    L5:
        r0 = this.b;
        goto L6
    }
}
