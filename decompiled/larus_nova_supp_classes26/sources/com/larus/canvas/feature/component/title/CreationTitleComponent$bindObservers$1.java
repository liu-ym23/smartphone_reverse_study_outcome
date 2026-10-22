package com.larus.canvas.feature.component.title;

import android.widget.ProgressBar;
import com.larus.canvas.feature.component.title.widget.CanvasTitleView;
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
import kotlinx.coroutines.flow.b1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.canvas.feature.component.title.CreationTitleComponent$bindObservers$1", f = "CreationTitleComponent.kt", i = {}, l = {138}, m = "invokeSuspend", n = {}, s = {})
final class CreationTitleComponent$bindObservers$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ CreationTitleComponent this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ CreationTitleComponent a;

        public a(CreationTitleComponent r1) {
            this.a = r1;
        }

        public final Object emit(Object r7, Continuation r8) {
            n r9 = (n) r7;
            CreationTitleComponent r10 = this.a;
            int r0 = CreationTitleComponent.v;
            CanvasTitleView r1 = r10.m3();
            if (r1 == null) goto L5;
            r1.setLeftIcon(r9.a);
        L5:
            CanvasTitleView r2 = r10.m3();
            if (r2 == null) goto L21;
            String r3 = r9.e;
            Integer r4 = r9.f;
            int r5 = 0;
            if (r9.g == true) goto L10;
        L12:
            boolean r6 = false;
        L13:
            r2.a.f.setText(r3);
            if (r4 == null) goto L16;
            r4.intValue();
            r2.a.f.setTextColor(r4.intValue());
        L16:
            ProgressBar r11 = r2.a.e;
            if (r6 == true) goto L20;
            r5 = 8;
        L20:
            r11.setVisibility(r5);
            goto L21
        L10:
            if (r9.h == false) goto L12;
            r6 = true;
        L21:
            CanvasTitleView r12 = r10.m3();
            if (r12 == null) goto L24;
            r12.setCenterText(r9.b);
        L24:
            CanvasTitleView r13 = r10.m3();
            if (r13 == null) goto L27;
            r13.setCenterImgResource(r9.c);
        L27:
            CanvasTitleView r14 = r10.m3();
            if (r14 == null) goto L30;
            r14.setCenterVisibility(r9.d);
        L30:
            CanvasTitleView r15 = r10.m3();
            if (r15 == null) goto L34;
            r15.setRightVisibility(r9.h);
        L34:
            return Unit.INSTANCE;
        }
    }

    public CreationTitleComponent$bindObservers$1(CreationTitleComponent r1, Continuation<? super CreationTitleComponent$bindObservers$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new CreationTitleComponent$bindObservers$1(this.this$0, r3);
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
        CreationTitleComponent r6 = this.this$0;
        b1 r2 = r6.n;
        a r3 = new a(r6);
        this.label = 1;
        if (r2.collect(r3, this) != r0) goto L12;
        return r0;
    }
}
