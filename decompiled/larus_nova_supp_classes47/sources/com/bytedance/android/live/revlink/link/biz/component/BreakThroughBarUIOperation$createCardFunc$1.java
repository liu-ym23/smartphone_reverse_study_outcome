package com.bytedance.android.live.revlink.link.biz.component;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lyy0/c;", "", "invoke", "(Lyy0/c;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
final class BreakThroughBarUIOperation$createCardFunc$1 extends Lambda implements Function1<yy0.c, Unit> {
    final /* synthetic */ Function1 $configure;
    final /* synthetic */ BreakThroughBarUIOperation this$0;

    public BreakThroughBarUIOperation$createCardFunc$1(BreakThroughBarUIOperation r1, Function1 r2) {
        this.this$0 = r1;
        this.$configure = r2;
        super(1);
    }

    public final void invoke(yy0.c r2) {
        Intrinsics.checkNotNullParameter(r2, "$receiver");
        r2.d(new AnonymousClass1(this));
        Function1 r0 = this.$configure;
        if (r0 == null) goto L6;
        Unit r3 = (Unit) r0.invoke(r2);
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((yy0.c) r1);
        return Unit.INSTANCE;
    }
}
