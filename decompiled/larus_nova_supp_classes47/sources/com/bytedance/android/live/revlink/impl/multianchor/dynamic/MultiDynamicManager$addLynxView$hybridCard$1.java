package com.bytedance.android.live.revlink.impl.multianchor.dynamic;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lyy0/c;", "", "invoke", "(Lyy0/c;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class MultiDynamicManager$addLynxView$hybridCard$1 extends Lambda implements Function1<yy0.c, Unit> {
    final /* synthetic */ MultiDynamicManager.a $cardRef;
    final /* synthetic */ boolean $centralInit;
    final /* synthetic */ com.bytedance.android.live.revlink.impl.lynxcontainer.b $lynxViewParams;
    final /* synthetic */ Function2 $onLoadResult;
    final /* synthetic */ MultiDynamicManager this$0;

    public MultiDynamicManager$addLynxView$hybridCard$1(MultiDynamicManager r1, com.bytedance.android.live.revlink.impl.lynxcontainer.b r2, Function2 r3, MultiDynamicManager.a r4, boolean r5) {
        this.this$0 = r1;
        this.$lynxViewParams = r2;
        this.$onLoadResult = r3;
        this.$cardRef = r4;
        this.$centralInit = r5;
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
