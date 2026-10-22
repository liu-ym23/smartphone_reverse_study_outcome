package com.bytedance.android.live.liveinteract.revenue.linkroomfight.core;

import com.bytedance.android.live.core.utils.StateMachine;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u0004*\u0014\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/bytedance/android/live/core/utils/StateMachine$GraphBuilder;", "Lcom/bytedance/android/live/liveinteract/revenue/linkroomfight/core/c$b;", "Lcom/bytedance/android/live/liveinteract/revenue/linkroomfight/core/c$a;", "", "", "invoke", "(Lcom/bytedance/android/live/core/utils/StateMachine$GraphBuilder;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
final class LinkRoomFightStateMachine$stateMachine$1 extends Lambda implements Function1<StateMachine.GraphBuilder<c.b, c.a, Object>, Unit> {
    final /* synthetic */ c this$0;

    public LinkRoomFightStateMachine$stateMachine$1(c r1) {
        super(1);
    }

    public final void invoke(StateMachine.GraphBuilder<c.b, c.a, Object> r3) {
        Intrinsics.checkNotNullParameter(r3, "$receiver");
        r3.a(c.b.C0093c.c);
        AnonymousClass1 r0 = AnonymousClass1.INSTANCE;
        int r1 = StateMachine.Matcher.c;
        r3.c(StateMachine.Matcher.a.a(c.b.C0093c.class), r0);
        Function1<StateMachine.GraphBuilder<c.b, c.a, Object>.StateDefinitionBuilder<c.b.a>, Unit> r2 = new AnonymousClass2(this);
        r3.c(StateMachine.Matcher.a.a(c.b.a.class), r2);
        AnonymousClass3 r4 = AnonymousClass3.INSTANCE;
        r3.c(StateMachine.Matcher.a.a(c.b.f.class), r4);
        AnonymousClass4 r5 = AnonymousClass4.INSTANCE;
        r3.c(StateMachine.Matcher.a.a(c.b.e.class), r5);
        AnonymousClass5 r6 = AnonymousClass5.INSTANCE;
        r3.c(StateMachine.Matcher.a.a(c.b.d.class), r6);
        AnonymousClass6 r7 = AnonymousClass6.INSTANCE;
        r3.c(StateMachine.Matcher.a.a(c.b.C0092b.class), r7);
        r3.b(new AnonymousClass7(this));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((StateMachine.GraphBuilder) r1);
        return Unit.INSTANCE;
    }
}
