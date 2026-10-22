package com.bytedance.android.live.liveinteract.revenue.fight;

import com.bytedance.android.live.core.utils.StateMachine;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u0004*\u0014\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/bytedance/android/live/core/utils/StateMachine$GraphBuilder;", "Lcom/bytedance/android/live/liveinteract/revenue/fight/e$b;", "Lcom/bytedance/android/live/liveinteract/revenue/fight/e$a;", "", "", "invoke", "(Lcom/bytedance/android/live/core/utils/StateMachine$GraphBuilder;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
final class TeamFightStateMachine$stateMachine$1 extends Lambda implements Function1<StateMachine.GraphBuilder<e.b, e.a, Object>, Unit> {
    final /* synthetic */ e this$0;

    public TeamFightStateMachine$stateMachine$1(e r1) {
        super(1);
    }

    public final void invoke(StateMachine.GraphBuilder<e.b, e.a, Object> r3) {
        Intrinsics.checkNotNullParameter(r3, "$receiver");
        r3.a(e.b.c.c);
        AnonymousClass1 r0 = AnonymousClass1.INSTANCE;
        int r1 = StateMachine.Matcher.c;
        r3.c(StateMachine.Matcher.a.a(e.b.c.class), r0);
        AnonymousClass2 r2 = AnonymousClass2.INSTANCE;
        r3.c(StateMachine.Matcher.a.a(e.b.d.class), r2);
        Function1<StateMachine.GraphBuilder<e.b, e.a, Object>.StateDefinitionBuilder<e.b.a>, Unit> r4 = new AnonymousClass3(this);
        r3.c(StateMachine.Matcher.a.a(e.b.a.class), r4);
        Function1<StateMachine.GraphBuilder<e.b, e.a, Object>.StateDefinitionBuilder<e.b.C0081e>, Unit> r5 = new AnonymousClass4(this);
        r3.c(StateMachine.Matcher.a.a(e.b.C0081e.class), r5);
        AnonymousClass5 r6 = AnonymousClass5.INSTANCE;
        r3.c(StateMachine.Matcher.a.a(e.b.C0080b.class), r6);
        r3.b(new AnonymousClass6(this));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((StateMachine.GraphBuilder) r1);
        return Unit.INSTANCE;
    }
}
