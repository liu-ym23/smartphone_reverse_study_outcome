package com.obric.assistant.live.service;

import android.content.Context;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.live.api.j;
import com.obric.assistant.live.event.Event;
import com.obric.assistant.state.api.v2.core.bean.ObricIslandStateType;
import com.obric.assistant.state.api.v2.core.bean.ObricState;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.live.service.ObricLiveService$setupEventReceiveChannel$1", f = "ObricLiveService.kt", i = {}, l = {573}, m = "invokeSuspend", n = {}, s = {})
final class ObricLiveService$setupEventReceiveChannel$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ObricLiveService this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ ObricLiveService a;

        public a(ObricLiveService r1) {
            this.a = r1;
        }

        public final Object emit(Object r5, Continuation r6) {
            Event.b r7 = (Event) r5;
            FLogger.a.i("ObricLiveService", "receive event:" + r7 + " and update live show");
            ObricLiveService r8 = this.a;
            int r0 = ObricLiveService.u;
            r8.getClass();
            boolean r1 = true;
            if ((r7 instanceof Event.b) == false) goto L25;
            Event.b r9 = r7;
            if (ObricLiveService.b.b[r9.a.ordinal()] != 1) goto L11;
            ObricState r10 = r9.b;
            j r2 = j.a;
            Context r11 = r8.a;
            if (r11 != null) goto L9;
            r11 = AppHost.a.getApplication().getApplicationContext();
        L9:
            Intrinsics.checkNotNull(r11);
            r2.h(r11, r10);
        L41:
            return Unit.INSTANCE;
        L11:
            if (com.obric.assistant.live.api.b.a(r9.b) == false) goto L14;
            ObricState r12 = r9.b;
        L19:
            if (r12 == null) goto L41;
            j r3 = j.a;
            Context r13 = r8.a;
            if (r13 != null) goto L23;
            r13 = AppHost.a.getApplication().getApplicationContext();
        L23:
            Intrinsics.checkNotNull(r13);
            r3.h(r13, r12);
            goto L41
        L14:
            if (r9.b.getCurrentIslandState() != ObricIslandStateType.CLICK_TALK_START) goto L16;
        L18:
            r12 = null;
            goto L19
        L16:
            if (r9.b.getCurrentIslandState() == ObricIslandStateType.CLICK_TALK_ASR_START) goto L18;
            r12 = r9.b;
            goto L19
        L25:
            if ((r7 instanceof Event.a) == false) goto L43;
            Event.a r14 = (Event.a) r7;
            if (r14.b.getCurrentIslandState() == ObricIslandStateType.MSG_END) goto L29;
        L31:
            int r4 = r14.a.ordinal();
            if (com.obric.assistant.live.api.b.a(r14.b) == false) goto L34;
        L39:
            r8.d(r4, r1, r14.b.getConversationId());
            goto L41
        L34:
            if (r14.b.getCurrentIslandState() == ObricIslandStateType.CLICK_TALK_END) goto L39;
            if (r14.b.getCurrentIslandState() == ObricIslandStateType.CLICK_TALK_ASR_END) goto L39;
            r1 = false;
            goto L39
        L29:
            if (r8.s(ObricLiveService.y(r14.b), r14.b.getConversationId()) == r14.b) goto L31;
        L43:
            throw new NoWhenBranchMatchedException();
        }
    }

    public ObricLiveService$setupEventReceiveChannel$1(ObricLiveService r1, Continuation<? super ObricLiveService$setupEventReceiveChannel$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ObricLiveService$setupEventReceiveChannel$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        kotlinx.coroutines.flow.b r6 = e.A(this.this$0.d);
        a r2 = new a(this.this$0);
        this.label = 1;
        if (r6.collect(r2, this) != r0) goto L12;
        return r0;
    }
}
