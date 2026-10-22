package com.larus.camera.impl.ui.component.result.general.viewpager;

import android.widget.ImageView;
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
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.camera.impl.ui.component.result.general.viewpager.ImageFragment$onViewCreated$1$2", f = "ImageFragment.kt", i = {}, l = {36}, m = "invokeSuspend", n = {}, s = {})
public final class ImageFragment$onViewCreated$1$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ImageView $this_apply;
    int label;
    final /* synthetic */ ImageFragment this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ ImageFragment a;
        public final /* synthetic */ ImageView b;

        public a(ImageFragment r1, ImageView r2) {
            this.a = r1;
            this.b = r2;
        }

        public final Object emit(Object r7, Continuation r8) {
            int r9 = ((Number) r7).intValue();
            com.larus.camera.impl.utils.s.a(this.b, r9, this.a.T90().rotation2Scale(this.b.getWidth(), this.b.getHeight(), this.b.getMeasuredWidth(), this.b.getMeasuredHeight(), r9));
            final ImageView r10 = this.b;
            final ImageFragment r11 = this.a;
            r10.post(new g(r11, r10));
            return Unit.INSTANCE;
        }
    }

    public ImageFragment$onViewCreated$1$2(ImageFragment r1, ImageView r2, Continuation<? super ImageFragment$onViewCreated$1$2> r3) {
        this.this$0 = r1;
        this.$this_apply = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ImageFragment$onViewCreated$1$2(this.this$0, this.$this_apply, r4);
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
        i1<Integer> r7 = this.this$0.T90().getRotation();
        a r2 = new a(this.this$0, this.$this_apply);
        this.label = 1;
        if (r7.collect(r2, this) != r0) goto L12;
        return r0;
    }
}
