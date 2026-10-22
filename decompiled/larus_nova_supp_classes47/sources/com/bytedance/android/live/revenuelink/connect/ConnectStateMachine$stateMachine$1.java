package com.bytedance.android.live.revenuelink.connect;

import com.bytedance.live.kmp.statemachine.StateMachine;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u0004*\u0014\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/bytedance/live/kmp/statemachine/StateMachine$GraphBuilder;", "Ley/f;", "Ley/e;", "Ley/l;", "", "invoke", "(Lcom/bytedance/live/kmp/statemachine/StateMachine$GraphBuilder;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class ConnectStateMachine$stateMachine$1 extends Lambda implements Function1<StateMachine.GraphBuilder<ey.f, ey.e, ey.l>, Unit> {
    final /* synthetic */ Function1 $listener;
    final /* synthetic */ ConnectStateMachine this$0;

    public ConnectStateMachine$stateMachine$1(ConnectStateMachine r1, Function1 r2) {
        this.this$0 = r1;
        this.$listener = r2;
        super(1);
    }

    public final void invoke(StateMachine.GraphBuilder<ey.f, ey.e, ey.l> r3) {
        Intrinsics.checkNotNullParameter(r3, "$receiver");
        ey.f.d r0 = new ey.f.d(0);
        r3.getClass();
        Intrinsics.checkNotNullParameter(r0, "initialState");
        r3.a = r0;
        Function1<StateMachine.GraphBuilder<ey.f, ey.e, ey.l>.StateDefinitionBuilder<ey.f.d>, Unit> r1 = new AnonymousClass1(this);
        int r2 = StateMachine.Matcher.c;
        r3.b(StateMachine.Matcher.a.a(Reflection.getOrCreateKotlinClass(ey.f.d.class)), r1);
        Function1<StateMachine.GraphBuilder<ey.f, ey.e, ey.l>.StateDefinitionBuilder<ey.f.e>, Unit> r4 = new AnonymousClass2(this);
        r3.b(StateMachine.Matcher.a.a(Reflection.getOrCreateKotlinClass(ey.f.e.class)), r4);
        AnonymousClass3 r5 = AnonymousClass3.INSTANCE;
        r3.b(StateMachine.Matcher.a.a(Reflection.getOrCreateKotlinClass(ey.f.b.class)), r5);
        AnonymousClass4 r6 = AnonymousClass4.INSTANCE;
        r3.b(StateMachine.Matcher.a.a(Reflection.getOrCreateKotlinClass(ey.f.a.class)), r6);
        AnonymousClass5 r7 = AnonymousClass5.INSTANCE;
        r3.b(StateMachine.Matcher.a.a(Reflection.getOrCreateKotlinClass(ey.f.f.class)), r7);
        r3.a(this.$listener);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((StateMachine.GraphBuilder) r1);
        return Unit.INSTANCE;
    }
}
