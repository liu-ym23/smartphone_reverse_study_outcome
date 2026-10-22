package com.larus.uaigc.createpage.component.mediaselector.imageselector;

import android.view.View;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.uaigc.impl.databinding.LarusFragmentCreationPageBinding;
import com.tencent.open.log.TraceLevel;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.component.mediaselector.imageselector.ImageSelectorComponent$bindObservers$1", f = "ImageSelectorComponent.kt", i = {}, l = {629}, m = "invokeSuspend", n = {}, s = {})
final class ImageSelectorComponent$bindObservers$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ImageSelectorComponent this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ ImageSelectorComponent a;

        public a(ImageSelectorComponent r1) {
            this.a = r1;
        }

        public final Object emit(Object r3, Continuation r4) {
            boolean r5 = ((Boolean) r3).booleanValue();
            View r6 = this.a.F2();
            boolean r1 = false;
            if ((!r5) == false) goto L5;
            int r0 = 0;
        L6:
            r6.setVisibility(r0);
            if (r5 == false) goto L18;
            uy9.a r7 = this.a.e4();
            if (r7 != null) goto L11;
        L13:
            if (r1 == false) goto L18;
            LarusFragmentCreationPageBinding r8 = this.a.d4();
            if (r8 == null) goto L18;
            NovaTitleBarEx.Y5(r8.j, "", null, null, 6);
            goto L18
        L11:
            if (r7.Ah() != true) goto L13;
            r1 = true;
        L18:
            return Unit.INSTANCE;
        L5:
            r0 = 8;
            goto L6
        }
    }

    public ImageSelectorComponent$bindObservers$1(ImageSelectorComponent r1, Continuation<? super ImageSelectorComponent$bindObservers$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ImageSelectorComponent$bindObservers$1(this.this$0, r3);
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
    L16:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        ImageSelectorComponent r6 = this.this$0;
        Lazy<Long> r2 = ImageSelectorComponent.X;
        uy9.a r7 = r6.e4();
        if (r7 == null) goto L18;
        kotlinx.coroutines.flow.b1 r8 = r7.gT();
        if (r8 == null) goto L18;
        a r3 = new a(this.this$0);
        this.label = 1;
        if (r8.collect(r3, this) != r0) goto L16;
        return r0;
    L18:
        return Unit.INSTANCE;
    }
}
