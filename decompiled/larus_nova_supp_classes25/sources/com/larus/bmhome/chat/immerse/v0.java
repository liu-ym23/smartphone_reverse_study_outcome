package com.larus.bmhome.chat.immerse;

import androidx.core.graphics.Insets;
import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class v0 implements Function1 {
    public final /* synthetic */ Ref.IntRef a;
    public final /* synthetic */ MessageListMaskWrapper b;

    public /* synthetic */ v0(Ref.IntRef r1, MessageListMaskWrapper r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke(Object r5) {
        Ref.IntRef r0 = this.a;
        MessageListMaskWrapper r1 = this.b;
        Intrinsics.checkNotNullParameter((Insets) r5, "it");
        r0.element = r1.e().a;
        r1.k = r1.b.n.getHeight() - r0.element;
        if (Intrinsics.areEqual(r1.l, Boolean.TRUE) == false) goto L5;
        r1.a(r1.k);
    L5:
        FLogger.a.d(r1.g, "watchOnImeInsetsAnimation: onProgress immerseHeight=" + r1.k);
        return Unit.INSTANCE;
    }
}
