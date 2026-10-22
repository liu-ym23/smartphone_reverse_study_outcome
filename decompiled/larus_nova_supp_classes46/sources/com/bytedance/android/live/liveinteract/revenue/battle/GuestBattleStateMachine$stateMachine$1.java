package com.bytedance.android.live.liveinteract.revenue.battle;

import com.bytedance.android.live.core.utils.StateMachine;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u0004*\u0014\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/bytedance/android/live/core/utils/StateMachine$GraphBuilder;", "Lcom/bytedance/android/live/liveinteract/revenue/battle/GuestBattleStateMachine$c;", "Lcom/bytedance/android/live/liveinteract/revenue/battle/GuestBattleStateMachine$a;", "Lcom/bytedance/android/live/liveinteract/revenue/battle/GuestBattleStateMachine$b;", "", "invoke", "(Lcom/bytedance/android/live/core/utils/StateMachine$GraphBuilder;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class GuestBattleStateMachine$stateMachine$1 extends Lambda implements Function1<StateMachine.GraphBuilder<GuestBattleStateMachine.c, GuestBattleStateMachine.a, GuestBattleStateMachine.b>, Unit> {
    final /* synthetic */ GuestBattleStateMachine this$0;

    public GuestBattleStateMachine$stateMachine$1(GuestBattleStateMachine r1) {
        this.this$0 = r1;
        super(1);
    }

    public final void invoke(StateMachine.GraphBuilder<GuestBattleStateMachine.c, GuestBattleStateMachine.a, GuestBattleStateMachine.b> r3) {
        Intrinsics.checkNotNullParameter(r3, "$receiver");
        r3.a(GuestBattleStateMachine.c.b.c);
        AnonymousClass1 r0 = AnonymousClass1.INSTANCE;
        int r1 = StateMachine.Matcher.c;
        r3.c(StateMachine.Matcher.a.a(GuestBattleStateMachine.c.b.class), r0);
        Function1<StateMachine.GraphBuilder<GuestBattleStateMachine.c, GuestBattleStateMachine.a, GuestBattleStateMachine.b>.StateDefinitionBuilder<GuestBattleStateMachine.c.C0068c>, Unit> r2 = new AnonymousClass2(this);
        r3.c(StateMachine.Matcher.a.a(GuestBattleStateMachine.c.C0068c.class), r2);
        Function1<StateMachine.GraphBuilder<GuestBattleStateMachine.c, GuestBattleStateMachine.a, GuestBattleStateMachine.b>.StateDefinitionBuilder<GuestBattleStateMachine.c.e>, Unit> r4 = new AnonymousClass3(this);
        r3.c(StateMachine.Matcher.a.a(GuestBattleStateMachine.c.e.class), r4);
        Function1<StateMachine.GraphBuilder<GuestBattleStateMachine.c, GuestBattleStateMachine.a, GuestBattleStateMachine.b>.StateDefinitionBuilder<GuestBattleStateMachine.c.a>, Unit> r5 = new AnonymousClass4(this);
        r3.c(StateMachine.Matcher.a.a(GuestBattleStateMachine.c.a.class), r5);
        Function1<StateMachine.GraphBuilder<GuestBattleStateMachine.c, GuestBattleStateMachine.a, GuestBattleStateMachine.b>.StateDefinitionBuilder<GuestBattleStateMachine.c.d>, Unit> r6 = new AnonymousClass5(this);
        r3.c(StateMachine.Matcher.a.a(GuestBattleStateMachine.c.d.class), r6);
        r3.b(new AnonymousClass6(this));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((StateMachine.GraphBuilder) r1);
        return Unit.INSTANCE;
    }
}
