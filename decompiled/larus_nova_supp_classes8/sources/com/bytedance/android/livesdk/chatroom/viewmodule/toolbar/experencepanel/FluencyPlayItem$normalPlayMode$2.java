package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.experencepanel;

import io.reactivex.disposables.CompositeDisposable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lnp1/f;", "", "invoke", "(Lnp1/f;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class FluencyPlayItem$normalPlayMode$2 extends Lambda implements Function1<np1.f, Unit> {
    final /* synthetic */ np1.g $this_normalPlayMode;
    final /* synthetic */ g this$0;

    public FluencyPlayItem$normalPlayMode$2(g r1, np1.g r2) {
        this.this$0 = r1;
        this.$this_normalPlayMode = r2;
        super(1);
    }

    public final void invoke(final np1.f r4) {
        Intrinsics.checkNotNullParameter(r4, "$receiver");
        final Ref.ObjectRef r0 = new Ref.ObjectRef();
        CompositeDisposable r1 = new CompositeDisposable();
        this.this$0.a.add(r1);
        Unit r2 = Unit.INSTANCE;
        r0.element = r1;
        this.$this_normalPlayMode.a(new AnonymousClass1(this, r4, r0));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((np1.f) r1);
        return Unit.INSTANCE;
    }
}
