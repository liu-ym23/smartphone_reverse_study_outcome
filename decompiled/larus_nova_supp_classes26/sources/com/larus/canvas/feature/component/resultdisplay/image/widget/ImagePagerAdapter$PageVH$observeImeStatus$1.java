package com.larus.canvas.feature.component.resultdisplay.image.widget;

import android.view.View;
import android.widget.ImageView;
import com.larus.canvas.feature.component.resultdisplay.image.v;
import com.larus.canvas.feature.component.resultdisplay.image.y;
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
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.canvas.feature.component.resultdisplay.image.widget.ImagePagerAdapter$PageVH$observeImeStatus$1", f = "ImagePagerAdapter.kt", i = {}, l = {450}, m = "invokeSuspend", n = {}, s = {})
final class ImagePagerAdapter$PageVH$observeImeStatus$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ y $data;
    final /* synthetic */ v $saveAction;
    int label;
    final /* synthetic */ ImagePagerAdapter.PageVH this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ ImagePagerAdapter.PageVH a;
        public final /* synthetic */ y b;
        public final /* synthetic */ v c;

        public a(ImagePagerAdapter.PageVH r1, y r2, v r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final Object emit(Object r4, Continuation r5) {
            boolean r6 = ((Boolean) r4).booleanValue();
            ImageView r7 = this.a.j;
            int r0 = 0;
            if (r6 == false) goto L5;
            boolean r1 = false;
        L7:
            if (r1 == false) goto L9;
            int r2 = 0;
        L10:
            r7.setVisibility(r2);
            ImageView r8 = this.a.k;
            if (r6 == false) goto L13;
            boolean r3 = false;
        L14:
            if (r3 == false) goto L16;
            int r9 = 0;
        L17:
            r8.setVisibility(r9);
            View r10 = this.a.l;
            if (r6 == false) goto L20;
        L22:
            boolean r11 = false;
        L23:
            if (r11 == true) goto L26;
            r0 = 8;
        L26:
            r10.setVisibility(r0);
            return Unit.INSTANCE;
        L20:
            if (this.c.b(this.b) == false) goto L22;
            r11 = true;
            goto L23
        L16:
            r9 = 8;
            goto L17
        L13:
            r3 = this.b.i;
            goto L14
        L9:
            r2 = 8;
            goto L10
        L5:
            r1 = this.b.h;
            goto L7
        }
    }

    public ImagePagerAdapter$PageVH$observeImeStatus$1(ImagePagerAdapter.PageVH r1, y r2, v r3, Continuation<? super ImagePagerAdapter$PageVH$observeImeStatus$1> r4) {
        this.this$0 = r1;
        this.$data = r2;
        this.$saveAction = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new ImagePagerAdapter$PageVH$observeImeStatus$1(this.this$0, this.$data, this.$saveAction, r5);
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
        ImagePagerAdapter.PageVH r8 = this.this$0;
        z0<Boolean> r2 = r8.b;
        a r3 = new a(r8, this.$data, this.$saveAction);
        this.label = 1;
        if (r2.collect(r3, this) != r0) goto L12;
        return r0;
    }
}
