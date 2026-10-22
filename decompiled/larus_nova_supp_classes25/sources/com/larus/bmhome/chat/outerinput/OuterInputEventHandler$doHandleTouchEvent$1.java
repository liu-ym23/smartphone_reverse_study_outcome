package com.larus.bmhome.chat.outerinput;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.bytedance.services.apm.api.EnsureManager;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.utils.logger.FLogger;
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
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.outerinput.OuterInputEventHandler$doHandleTouchEvent$1", f = "OuterInputEventHandler.kt", i = {}, l = {241}, m = "invokeSuspend", n = {}, s = {})
public final class OuterInputEventHandler$doHandleTouchEvent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ View $currentView;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ OuterInputEventHandler this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ View a;
        public final /* synthetic */ OuterInputEventHandler b;
        public final /* synthetic */ CoroutineScope c;

        public a(View r1, OuterInputEventHandler r2, CoroutineScope r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final Object emit(Object r11, Continuation r12) {
            OuterInputEventBus.OuterInputEvent r13 = (OuterInputEventBus.OuterInputEvent) r11;
            FLogger.a.i("OuterInputEventHandler", "handleTouchEvent, flowEvent:" + r13);
            if (r13.a == 0) goto L13;
            View r14 = this.a;
            if (r14 == null) goto L23;
            r14.setTag(2131365544, TuplesKt.to(Boxing.boxFloat(r13.d), Boxing.boxFloat(r13.e)));
        L23:
            View r15 = this.a;     // Catch: Exception -> L11
            if (r15 == null) goto L13;
            MutableSharedFlow<Integer> r0 = OuterInputEventBus.a;     // Catch: Exception -> L11
            Intrinsics.checkNotNullParameter(r13, "<this>");     // Catch: Exception -> L11
            Boxing.boxBoolean(r15.dispatchTouchEvent(MotionEvent.obtain(System.currentTimeMillis(), System.currentTimeMillis(), r13.a, r13.b, r13.c, 0)));     // Catch: Exception -> L11
        L11:
            e = move-exception;
            FLogger.a.e("OuterInputEventHandler", "dispatchTouchEvent error:", e);
            EnsureManager.ensureNotReachHere(e, "OuterInputEventHandler dispatchTouchEvent error");
        L13:
            int r16 = r13.a;
            if (r16 != 1) goto L16;
        L17:
            OuterInputEventHandler r17 = this.b;
            int r1 = OuterInputEventHandler.i;
            ICoreInputAbility r18 = (ICoreInputAbility) r17.h.getValue();
            if (r18 == null) goto L20;
            r18.s3(ViewConfiguration.getLongPressTimeout());
        L20:
            CoroutineScopeKt.cancel$default(this.c, null, 1, null);
        L22:
            return Unit.INSTANCE;
        L16:
            if (r16 != 3) goto L22;
            goto L17
        }
    }

    public OuterInputEventHandler$doHandleTouchEvent$1(OuterInputEventHandler r1, View r2, Continuation<? super OuterInputEventHandler$doHandleTouchEvent$1> r3) {
        this.this$0 = r1;
        this.$currentView = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        OuterInputEventHandler$doHandleTouchEvent$1 r0 = new OuterInputEventHandler$doHandleTouchEvent$1(this.this$0, this.$currentView, r5);
        r0.L$0 = r4;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L6;
        ResultKt.throwOnFailure(r7);
    L12:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        CoroutineScope r8 = (CoroutineScope) this.L$0;
        MutableSharedFlow<Integer> r2 = OuterInputEventBus.a;
        MutableSharedFlow r3 = OuterInputEventBus.b(this.this$0.d);
        a r4 = new a(this.$currentView, this.this$0, r8);
        this.label = 1;
        if (r3.collect(r4, this) != r0) goto L12;
        return r0;
    }
}
