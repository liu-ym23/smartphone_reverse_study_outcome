package com.larus.audio.call.plugins;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.audio.call.mgr.AVKitDuplexState;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.larus.audio.call.plugins.CommonUIStatePlugin$onStart$1", f = "CommonUIStatePlugin.kt", i = {}, l = {329}, m = "invokeSuspend", n = {}, s = {})
public final class CommonUIStatePlugin$onStart$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ CommonUIStatePlugin<C> this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ CommonUIStatePlugin<C> a;

        public a(CommonUIStatePlugin<C> r1) {
            this.a = r1;
        }

        public final Object emit(Object r3, Continuation r4) {
            AVKitDuplexState r5 = (AVKitDuplexState) r3;
            Integer r6 = this.a.p3(r5);
            if (r6 == null) goto L5;
            int r7 = r6.intValue();
        L15:
            this.a.m3().setValue(TuplesKt.to(r5, Boxing.boxInt(r7)));
            return Unit.INSTANCE;
        L5:
            CommonUIStatePlugin<C> r8 = this.a;
            Integer r0 = r8.n;
            String r1 = null;
            if (r0 == null) goto L8;
            r0.intValue();
            r8.n = null;
        L9:
            if (r0 == null) goto L11;
            r7 = r0.intValue();
            goto L15
        L11:
            this.a.getClass();
            com.larus.audio.call.n r9 = com.larus.audio.call.f.c().g();
            if (r9 == null) goto L14;
            r1 = r9.a;
        L14:
            r7 = m0.b(r5, Intrinsics.areEqual(r1, "interpret_v2"));
            goto L15
        L8:
            r0 = null;
            goto L9
        }
    }

    public CommonUIStatePlugin$onStart$1(CommonUIStatePlugin<C> r1, Continuation<? super CommonUIStatePlugin$onStart$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new CommonUIStatePlugin$onStart$1(this.this$0, r3);
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
