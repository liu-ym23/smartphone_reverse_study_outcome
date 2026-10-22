package com.larus.uaigc.createpage.bussiness.remove;

import android.widget.FrameLayout;
import com.larus.uaigc.createpage.bussiness.remove.widget.PaletteControllerView;
import com.larus.uaigc.impl.databinding.LarusFragmentImageRemoveBinding;
import com.tencent.open.log.TraceLevel;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.bussiness.remove.ImageRemoveFragment$initPalette$1$5", f = "ImageRemoveFragment.kt", i = {}, l = {582}, m = "invokeSuspend", n = {}, s = {})
final class ImageRemoveFragment$initPalette$1$5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ LarusFragmentImageRemoveBinding $this_run;
    int label;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ LarusFragmentImageRemoveBinding a;

        public a(LarusFragmentImageRemoveBinding r1) {
            this.a = r1;
        }

        public final Object emit(Object r2, Continuation r3) {
            boolean r4 = ((Boolean) r2).booleanValue();
            PaletteControllerView r5 = this.a.b;
            r5.a.c.setEnabled(r4);
            FrameLayout r6 = r5.a.c;
            if (r4 == false) goto L5;
            float r7 = 1.0f;
        L6:
            r6.setAlpha(r7);
            return Unit.INSTANCE;
        L5:
            r7 = 0.3f;
            goto L6
        }
    }

    public ImageRemoveFragment$initPalette$1$5(LarusFragmentImageRemoveBinding r1, Continuation<? super ImageRemoveFragment$initPalette$1$5> r2) {
        this.$this_run = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ImageRemoveFragment$initPalette$1$5(this.$this_run, r3);
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
        i1<Boolean> r6 = this.$this_run.h.getEnableRedo();
        a r2 = new a(this.$this_run);
        this.label = 1;
        if (r6.collect(r2, this) != r0) goto L12;
        return r0;
    }
}
