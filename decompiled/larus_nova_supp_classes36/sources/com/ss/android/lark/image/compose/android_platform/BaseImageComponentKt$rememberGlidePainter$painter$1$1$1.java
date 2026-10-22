package com.ss.android.lark.image.compose.android_platform;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.image.compose.common.avatar.c;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.b1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.image.compose.android_platform.BaseImageComponentKt$rememberGlidePainter$painter$1$1$1", f = "BaseImageComponent.kt", i = {}, l = {234}, m = "invokeSuspend", n = {}, s = {})
final class BaseImageComponentKt$rememberGlidePainter$painter$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<c, Unit> $onState;
    final /* synthetic */ GlidePainter $this_apply;
    int label;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ Function1<c, Unit> a;

        /* JADX WARN: Multi-variable type inference failed */
        public a(Function1<? super c, Unit> r1) {
            this.a = r1;
        }

        public final Object emit(Object r1, Continuation r2) {
            c r3 = (c) r1;
            Function1<c, Unit> r4 = this.a;
            if (r4 == null) goto L6;
            r4.invoke(r3);
        L6:
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BaseImageComponentKt$rememberGlidePainter$painter$1$1$1(GlidePainter r1, Function1<? super c, Unit> r2, Continuation<? super BaseImageComponentKt$rememberGlidePainter$painter$1$1$1> r3) {
        this.$this_apply = r1;
        this.$onState = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new BaseImageComponentKt$rememberGlidePainter$painter$1$1$1(this.$this_apply, this.$onState, r4);
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
        b1 r6 = this.$this_apply.l;
        a r2 = new a(this.$onState);
        this.label = 1;
        if (r6.collect(r2, this) != r0) goto L12;
        return r0;
    }
}
