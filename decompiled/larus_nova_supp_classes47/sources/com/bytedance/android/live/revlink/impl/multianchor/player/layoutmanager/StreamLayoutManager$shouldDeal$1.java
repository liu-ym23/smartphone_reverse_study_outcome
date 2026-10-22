package com.bytedance.android.live.revlink.impl.multianchor.player.layoutmanager;

import com.bytedance.android.live.revlink.impl.player.h;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import rc0.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/player/h;", "p1", "", "invoke", "(Lcom/bytedance/android/live/revlink/impl/player/h;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final /* synthetic */ class StreamLayoutManager$shouldDeal$1 extends FunctionReferenceImpl implements Function1<h, Unit> {
    public StreamLayoutManager$shouldDeal$1(StreamLayoutManager r8) {
        super(1, r8, StreamLayoutManager.class, "relayoutPlayer", "relayoutPlayer(Lcom/bytedance/android/live/revlink/impl/player/PlayerLayout;)V", 0);
    }

    public final void invoke(h r6) {
        Intrinsics.checkNotNullParameter(r6, "p1");
        Function1<p, Unit> r0 = ((StreamLayoutManager) ((CallableReference) this).receiver).l;
        Intrinsics.checkNotNullParameter(r6, "$this$toExternal");
        r0.invoke(new p(r6.a, r6.b, r6.c, r6.d));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((h) r1);
        return Unit.INSTANCE;
    }
}
