package com.larus.audio.call.plugins;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.audio.call.dora.CommandStatus;
import com.larus.audio.call.mgr.AVKitCoreStates$Recognizing;
import com.larus.audio.call.mgr.AVKitDuplexState;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.larus.audio.call.plugins.CommonCallTimingPlugin$createCallStateObserver$1", f = "CommonCallTimingPlugin.kt", i = {}, l = {141}, m = "invokeSuspend", n = {}, s = {})
public final class CommonCallTimingPlugin$createCallStateObserver$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ CommonCallTimingPlugin<C> this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ CommonCallTimingPlugin<C> a;

        public a(CommonCallTimingPlugin<C> r1) {
            this.a = r1;
        }

        public final Object emit(Object r9, Continuation r10) {
            AVKitDuplexState r11 = (AVKitDuplexState) r9;
            CommonCallTimingPlugin<C> r12 = this.a;
            r12.getClass();
            boolean r0 = r11.getUpState() instanceof AVKitCoreStates$Recognizing;
            boolean r1 = d0.a(r11);
            if (com.larus.audio.call.f.d().s == true) goto L5;
        L27:
            if (r1 == false) goto L29;
            com.larus.audio.call.util.e.a.i(r12.T2(), "[handleDuplexState] " + r11.toSimpleString() + ", try start wait trigger timer");
            r12.q.b();
        L31:
            return Unit.INSTANCE;
        L29:
            r12.q.a();
            goto L31
        L5:
            if (r0 == true) goto L15;
            if (r1 == true) goto L15;
            if (r12.s == false) goto L27;
            com.larus.audio.call.util.e.a.i(r12.T2(), "[processHangUpDuplex] 2.remove");
            Job r2 = r12.h;
            if (r2 == null) goto L13;
            Job.DefaultImpls.cancel$default(r2, null, 1, null);
        L13:
            r12.s = false;
        L15:
            if (r12.s == true) goto L22;
            if (r1 == false) goto L27;
            com.larus.audio.call.util.e.a.i(r12.T2(), "[processHangUpDuplex] post");
            CoroutineScope r3 = com.larus.audio.call.util.r.a;
            Long r4 = com.larus.audio.call.f.d().w;
            if (r4 == null) goto L20;
            long r5 = r4.longValue();
        L21:
            r12.h = com.larus.audio.call.util.r.a(r5 * ((long) CommandStatus.DORA_TRACE), r12.t);
            r12.s = true;
            goto L27
        L20:
            r5 = 0;
            goto L21
        L22:
            if (r0 == false) goto L27;
            com.larus.audio.call.util.e.a.i(r12.T2(), "[processHangUpDuplex] 1.remove");
            Job r6 = r12.h;
            if (r6 == null) goto L26;
            Job.DefaultImpls.cancel$default(r6, null, 1, null);
        L26:
            r12.s = false;
            goto L27
        }
    }

    public CommonCallTimingPlugin$createCallStateObserver$1(CommonCallTimingPlugin<C> r1, Continuation<? super CommonCallTimingPlugin$createCallStateObserver$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new CommonCallTimingPlugin$createCallStateObserver$1(this.this$0, r3);
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
        if (r1 != 1) goto L6;
        ResultKt.throwOnFailure(r5);
    L12:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        kotlinx.coroutines.flow.i1<AVKitDuplexState> r6 = this.this$0.getContext().a().y();
        a r2 = new a(this.this$0);
        this.label = 1;
        if (r6.collect(r2, this) != r0) goto L12;
        return r0;
    }
}
