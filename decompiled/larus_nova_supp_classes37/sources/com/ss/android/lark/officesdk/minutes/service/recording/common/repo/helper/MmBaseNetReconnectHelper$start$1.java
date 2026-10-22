package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.helper;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.helper.MmBaseNetReconnectHelper$start$1", f = "MmBaseNetReconnectHelper.kt", i = {}, l = {62}, m = "invokeSuspend", n = {}, s = {})
public final class MmBaseNetReconnectHelper$start$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ MmBaseNetReconnectHelper this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ MmBaseNetReconnectHelper a;

        public a(MmBaseNetReconnectHelper r1) {
            this.a = r1;
        }

        public final Object emit(Object r9, Continuation r10) {
            boolean r11 = ((Boolean) r9).booleanValue();
            MmBaseNetReconnectHelper r12 = this.a;
            if (r12.d == r11) goto L16;
            r12.d = r11;
            if (r11 == false) goto L11;
            lvb.a.e(r12.e(), "onNetworkStatusChanged, available, start debounce: " + r12.c() + " ms");
            Job r13 = r12.f;
            if (r13 == null) goto L10;
            Job.DefaultImpls.cancel$default(r13, null, 1, null);
        L10:
            r12.f = BuildersKt.launch$default(r12.b, null, null, new MmBaseNetReconnectHelper$onNetworkStatusChanged$1(r12, null), 3, null);
            goto L16
        L11:
            Job r14 = r12.f;
            if (r14 == null) goto L14;
            Job.DefaultImpls.cancel$default(r14, null, 1, null);
        L14:
            r12.f();
        L16:
            return Unit.INSTANCE;
        }
    }

    public MmBaseNetReconnectHelper$start$1(MmBaseNetReconnectHelper r1, Continuation<? super MmBaseNetReconnectHelper$start$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new MmBaseNetReconnectHelper$start$1(this.this$0, r3);
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
        MmBaseNetReconnectHelper r6 = this.this$0;
        i1<Boolean> r2 = r6.a;
        a r3 = new a(r6);
        this.label = 1;
        if (r2.collect(r3, this) != r0) goto L12;
        return r0;
    }
}
