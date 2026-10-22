package com.bytedance.android.live.revlink.impl.multianchor.feed.machine;

import com.bytedance.android.live.core.utils.StateMachine;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00060\u0005\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\n\b\u0001\u0010\u0003\u0018\u0001*\u00020\u0002*\u00028\u00002\u0006\u0010\u0004\u001a\u00028\u0001H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lx21/d;", "STATE", "Lx21/a;", "E", "it", "Lcom/bytedance/android/live/core/utils/StateMachine$b$a$a;", "Lx21/b;", "invoke", "(Lx21/d;Lx21/a;)Lcom/bytedance/android/live/core/utils/StateMachine$b$a$a;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class FeedMultiStateMachine$onMultiEvent$1 extends Lambda implements Function2<x21.d, x21.a, StateMachine.b.a.a<? extends x21.d, ? extends x21.b>> {
    final /* synthetic */ StateMachine.GraphBuilder.StateDefinitionBuilder $this_onMultiEvent;

    public FeedMultiStateMachine$onMultiEvent$1(StateMachine.GraphBuilder.StateDefinitionBuilder r1) {
        this.$this_onMultiEvent = r1;
        super(2);
    }

    public final StateMachine.b.a.a<x21.d, x21.b> invoke(x21.d r3, x21.a r4) {
        Intrinsics.checkNotNullParameter(r3, "$this$on");
        Intrinsics.checkNotNullParameter(r4, "it");
        StateMachine.GraphBuilder.StateDefinitionBuilder r0 = this.$this_onMultiEvent;
        x21.d r1 = r4.a();
        x21.b r5 = r4.b();
        r0.getClass();
        return StateMachine.GraphBuilder.StateDefinitionBuilder.d(r3, r1, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((x21.d) r1, (x21.a) r2);
    }
}
