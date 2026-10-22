package com.bytedance.android.live.broadcast.live.newstream;

import com.bytedance.android.live.core.utils.StateMachine;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u0004*\u0014\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/bytedance/android/live/core/utils/StateMachine$GraphBuilder;", "Lqv0/b;", "Lcom/bytedance/android/live/broadcast/live/newstream/d;", "Lcom/bytedance/android/live/broadcast/live/newstream/e;", "", "invoke", "(Lcom/bytedance/android/live/core/utils/StateMachine$GraphBuilder;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class NewLiveStreamStateMachine$stateMachine$1 extends Lambda implements Function1<StateMachine.GraphBuilder<qv0.b, d, e>, Unit> {
    final /* synthetic */ f this$0;

    public NewLiveStreamStateMachine$stateMachine$1(f r1) {
        this.this$0 = r1;
        super(1);
    }

    public final void invoke(StateMachine.GraphBuilder<qv0.b, d, e> r3) {
        Intrinsics.checkNotNullParameter(r3, "$receiver");
        r3.a(qv0.b.c.b);
        AnonymousClass1 r0 = AnonymousClass1.INSTANCE;
        int r1 = StateMachine.Matcher.c;
        r3.c(StateMachine.Matcher.a.a(qv0.b.c.class), r0);
        AnonymousClass2 r2 = AnonymousClass2.INSTANCE;
        r3.c(StateMachine.Matcher.a.a(qv0.b.a.class), r2);
        AnonymousClass3 r4 = AnonymousClass3.INSTANCE;
        r3.c(StateMachine.Matcher.a.a(qv0.b.b.class), r4);
        AnonymousClass4 r5 = AnonymousClass4.INSTANCE;
        r3.c(StateMachine.Matcher.a.a(qv0.b.e.class), r5);
        AnonymousClass5 r6 = AnonymousClass5.INSTANCE;
        r3.c(StateMachine.Matcher.a.a(qv0.b.d.class), r6);
        AnonymousClass6 r7 = AnonymousClass6.INSTANCE;
        r3.c(StateMachine.Matcher.a.a(qv0.b.f.class), r7);
        r3.b(new AnonymousClass7(this));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((StateMachine.GraphBuilder) r1);
        return Unit.INSTANCE;
    }
}
