package com.ss.android.lark.officesdk.minutes.ui.record.recording.p000float;

import com.ss.android.lark.officesdk.minutes.service.recording.common.core.MmRecordingSession;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c;
import com.ss.android.lark.officesdk.minutes.ui.record.recording.base.j;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
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
import kotlinx.coroutines.flow.b1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.recording.float.MmFloatView$bindSession$4", f = "MmFloatView.kt", i = {}, l = {134}, m = "invokeSuspend", n = {}, s = {})
public final class MmFloatView$bindSession$4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isD1204Recording;
    final /* synthetic */ MmRecordingSession $session;
    int label;
    final /* synthetic */ MmFloatView this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ MmFloatView a;
        public final /* synthetic */ boolean b;

        public a(MmFloatView r1, boolean r2) {
            this.a = r1;
            this.b = r2;
        }

        public final Object emit(Object r3, Continuation r4) {
            Pair r5 = (Pair) r3;
            MmFloatView r6 = this.a;
            if (this.b == true) goto L5;
        L8:
            boolean r0 = true;
        L9:
            r6.c = r0;
            MmFloatView.T5(this.a, j.a((c) r5.getSecond()));
            return Unit.INSTANCE;
        L5:
            if (Intrinsics.areEqual(r5.getSecond(), c.k.c) == false) goto L8;
            r0 = false;
            goto L9
        }
    }

    public MmFloatView$bindSession$4(MmRecordingSession r1, MmFloatView r2, boolean r3, Continuation<? super MmFloatView$bindSession$4> r4) {
        this.$session = r1;
        this.this$0 = r2;
        this.$isD1204Recording = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new MmFloatView$bindSession$4(this.$session, this.this$0, this.$isD1204Recording, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L6;
        ResultKt.throwOnFailure(r6);
    L12:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        b1 r7 = this.$session.t;
        a r2 = new a(this.this$0, this.$isD1204Recording);
        this.label = 1;
        if (r7.collect(r2, this) != r0) goto L12;
        return r0;
    }
}
