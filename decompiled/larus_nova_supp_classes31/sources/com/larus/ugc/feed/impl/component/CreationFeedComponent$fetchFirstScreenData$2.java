package com.larus.ugc.feed.impl.component;

import com.larus.ugc.feed.api.model.UserCreationModelKmp;
import com.larus.ugc.feed.impl.ability.CreationFeedAbilityImpl;
import com.tencent.open.log.TraceLevel;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.StateFlowImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.ugc.feed.impl.component.CreationFeedComponent$fetchFirstScreenData$2", f = "CreationFeedComponent.kt", i = {0}, l = {210, 213}, m = "invokeSuspend", n = {"hasData"}, s = {"I$0"})
final class CreationFeedComponent$fetchFirstScreenData$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $disableInitialAutoRefreshOnce;
    final /* synthetic */ Ref.BooleanRef $hasRefresh;
    int I$0;
    int label;
    final /* synthetic */ CreationFeedComponent this$0;

    public CreationFeedComponent$fetchFirstScreenData$2(CreationFeedComponent r1, boolean r2, Ref.BooleanRef r3, Continuation<? super CreationFeedComponent$fetchFirstScreenData$2> r4) {
        this.this$0 = r1;
        this.$disableInitialAutoRefreshOnce = r2;
        this.$hasRefresh = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new CreationFeedComponent$fetchFirstScreenData$2(this.this$0, this.$disableInitialAutoRefreshOnce, this.$hasRefresh, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r4 = true;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r12);
    L47:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        int r2 = this.I$0;
        ResultKt.throwOnFailure(r12);
    L28:
        Boolean r13 = (Boolean) r12;
    L29:
        if (r2 == 0) goto L47;
        if (this.$disableInitialAutoRefreshOnce == true) goto L47;
        if (this.$hasRefresh.element == false) goto L41;
        zp9.f r14 = this.this$0.v;
        if (r14 != null) goto L37;
    L39:
        r4 = false;
    L40:
        if (r4 == false) goto L47;
    L37:
        if (r14.a != true) goto L39;
    L41:
        CreationFeedComponent r15 = this.this$0;
        int r3 = CreationFeedComponent.H;
        CreationFeedAbilityImpl r16 = r15.B3();
        if (r16 == null) goto L47;
        this.label = 2;
        if (r16.q("onResume", false) != r0) goto L47;
        return r0;
    L10:
        ResultKt.throwOnFailure(r12);
        CreationFeedComponent r17 = this.this$0;
        int r5 = CreationFeedComponent.H;
        CreationFeedAbilityImpl r18 = r17.B3();
        if (r18 == null) goto L21;
        StateFlowImpl r19 = r18.b.a;
        if (r19 == null) goto L21;
        n0a.a r110 = (n0a.a) r19.getValue();
        if (r110 == null) goto L21;
        List<UserCreationModelKmp> r111 = r110.a;
        if (r111 == null) goto L21;
        if ((!r111.isEmpty()) != true) goto L21;
        r2 = 1;
    L22:
        if (r2 != 0) goto L29;
        CreationFeedAbilityImpl r6 = this.this$0.B3();
        if (r6 == null) goto L29;
        boolean r8 = !CreationFeedComponent.m3(this.this$0);
        this.I$0 = r2;
        this.label = 1;
        r12 = g0a.g.a.a(r6, true, false, r8, this, 2);
        if (r12 != r0) goto L28;
        return r0;
    L21:
        r2 = 0;
        goto L22
    }
}
