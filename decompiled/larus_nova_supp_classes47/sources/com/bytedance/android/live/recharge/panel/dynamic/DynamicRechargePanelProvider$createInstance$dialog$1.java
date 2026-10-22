package com.bytedance.android.live.recharge.panel.dynamic;

import io.reactivex.disposables.CompositeDisposable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lyy0/d;", "", "invoke", "(Lyy0/d;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
final class DynamicRechargePanelProvider$createInstance$dialog$1 extends Lambda implements Function1<yy0.d, Unit> {
    final /* synthetic */ CompositeDisposable $cd;
    final /* synthetic */ com.bytedance.android.live.recharge.trace.session.a $session;
    final /* synthetic */ DynamicRechargePanelProvider this$0;

    public DynamicRechargePanelProvider$createInstance$dialog$1(DynamicRechargePanelProvider r1, CompositeDisposable r2, com.bytedance.android.live.recharge.trace.session.a r3) {
        this.this$0 = r1;
        this.$cd = r2;
        this.$session = r3;
        super(1);
    }

    public final void invoke(yy0.d r2) {
        Intrinsics.checkNotNullParameter(r2, "$receiver");
        r2.b(new AnonymousClass1(this));
        r2.d(new AnonymousClass2(this));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((yy0.d) r1);
        return Unit.INSTANCE;
    }
}
