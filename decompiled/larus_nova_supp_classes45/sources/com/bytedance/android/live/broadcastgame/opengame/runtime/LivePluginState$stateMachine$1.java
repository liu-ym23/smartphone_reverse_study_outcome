package com.bytedance.android.live.broadcastgame.opengame.runtime;

import com.bytedance.android.live.core.utils.StateMachine;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u0004*\u0014\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/bytedance/android/live/core/utils/StateMachine$GraphBuilder;", "Lcom/bytedance/android/live/broadcastgame/opengame/runtime/y$d;", "Lcom/bytedance/android/live/broadcastgame/opengame/runtime/y$b;", "Lcom/bytedance/android/live/broadcastgame/opengame/runtime/y$c;", "", "invoke", "(Lcom/bytedance/android/live/core/utils/StateMachine$GraphBuilder;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class LivePluginState$stateMachine$1 extends Lambda implements Function1<StateMachine.GraphBuilder<y.d, y.b, y.c>, Unit> {
    final /* synthetic */ y this$0;

    public LivePluginState$stateMachine$1(y r1) {
        this.this$0 = r1;
        super(1);
    }

    public final void invoke(StateMachine.GraphBuilder<y.d, y.b, y.c> r3) {
        Intrinsics.checkNotNullParameter(r3, "$receiver");
        r3.a(y.d.c.a);
        AnonymousClass1 r0 = AnonymousClass1.INSTANCE;
        int r1 = StateMachine.Matcher.c;
        r3.c(StateMachine.Matcher.a.a(y.d.c.class), r0);
        AnonymousClass2 r2 = AnonymousClass2.INSTANCE;
        r3.c(StateMachine.Matcher.a.a(y.d.C0082d.class), r2);
        AnonymousClass3 r4 = AnonymousClass3.INSTANCE;
        r3.c(StateMachine.Matcher.a.a(y.d.e.class), r4);
        AnonymousClass4 r5 = AnonymousClass4.INSTANCE;
        r3.c(StateMachine.Matcher.a.a(y.d.a.class), r5);
        AnonymousClass5 r6 = AnonymousClass5.INSTANCE;
        r3.c(StateMachine.Matcher.a.a(y.d.g.class), r6);
        Function1<StateMachine.GraphBuilder<y.d, y.b, y.c>.StateDefinitionBuilder<y.d.f>, Unit> r7 = new AnonymousClass6(this);
        r3.c(StateMachine.Matcher.a.a(y.d.f.class), r7);
        AnonymousClass7 r8 = AnonymousClass7.INSTANCE;
        r3.c(StateMachine.Matcher.a.a(y.d.b.class), r8);
        AnonymousClass8 r9 = AnonymousClass8.INSTANCE;
        r3.c(StateMachine.Matcher.a.a(y.d.h.class), r9);
        r3.b(new AnonymousClass9(this));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((StateMachine.GraphBuilder) r1);
        return Unit.INSTANCE;
    }
}
