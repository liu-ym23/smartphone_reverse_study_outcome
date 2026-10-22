package com.bytedance.android.live.revlink.impl.pk.scopeservice;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lyy0/c;", "", "invoke", "(Lyy0/c;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
final class PkLynxInfoImpl$createLynxCard$1 extends Lambda implements Function1<yy0.c, Unit> {
    final /* synthetic */ PkLynxInfoImpl this$0;

    public PkLynxInfoImpl$createLynxCard$1(PkLynxInfoImpl r1) {
        this.this$0 = r1;
        super(1);
    }

    public final void invoke(yy0.c r2) {
        Intrinsics.checkNotNullParameter(r2, "$receiver");
        r2.d(new AnonymousClass1(this));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((yy0.c) r1);
        return Unit.INSTANCE;
    }
}
