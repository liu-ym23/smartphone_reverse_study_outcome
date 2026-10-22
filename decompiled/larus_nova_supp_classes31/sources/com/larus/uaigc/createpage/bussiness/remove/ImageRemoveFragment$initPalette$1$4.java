package com.larus.uaigc.createpage.bussiness.remove;

import android.widget.FrameLayout;
import android.widget.TextView;
import com.larus.bmhome.view.NovaTitleBarEx;
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
@DebugMetadata(c = "com.larus.uaigc.createpage.bussiness.remove.ImageRemoveFragment$initPalette$1$4", f = "ImageRemoveFragment.kt", i = {}, l = {565}, m = "invokeSuspend", n = {}, s = {})
final class ImageRemoveFragment$initPalette$1$4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ LarusFragmentImageRemoveBinding $this_run;
    int label;
    final /* synthetic */ ImageRemoveFragment this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ LarusFragmentImageRemoveBinding a;
        public final /* synthetic */ ImageRemoveFragment b;

        public a(LarusFragmentImageRemoveBinding r1, ImageRemoveFragment r2) {
            this.a = r1;
            this.b = r2;
        }

        public final Object emit(Object r4, Continuation r5) {
            boolean r6 = ((Boolean) r4).booleanValue();
            PaletteControllerView r7 = this.a.b;
            r7.a.d.setEnabled(r6);
            FrameLayout r8 = r7.a.d;
            float r0 = 1.0f;
            if (r6 == false) goto L5;
            float r2 = 1.0f;
        L6:
            r8.setAlpha(r2);
            this.a.d.setEnabled(r6);
            TextView r9 = this.a.d;
            if (r6 == true) goto L10;
            r0 = 0.3f;
        L10:
            r9.setAlpha(r0);
            if (r6 == false) goto L15;
            ImageRemoveFragment r10 = this.b;
            int r11 = ImageRemoveFragment.v;
            if ((!r10.aa0().a) == false) goto L15;
            LarusFragmentImageRemoveBinding r12 = this.a;
            NovaTitleBarEx r13 = r12.l;
            String r14 = r12.k.getContext().getString(2131906334);
            int r1 = v19.c.b(2130972079, this.b.getContext(), 2131103136);
            final LarusFragmentImageRemoveBinding r3 = this.a;
            r13.n6(r14, r1, new v(r3));
        L17:
            return Unit.INSTANCE;
        L15:
            NovaTitleBarEx.o6(this.a.l, "", new dg5.d());
            goto L17
        L5:
            r2 = 0.3f;
            goto L6
        }
    }

    public ImageRemoveFragment$initPalette$1$4(LarusFragmentImageRemoveBinding r1, ImageRemoveFragment r2, Continuation<? super ImageRemoveFragment$initPalette$1$4> r3) {
        this.$this_run = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ImageRemoveFragment$initPalette$1$4(this.$this_run, this.this$0, r4);
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
        i1<Boolean> r7 = this.$this_run.h.getEnableUndo();
        a r2 = new a(this.$this_run, this.this$0);
        this.label = 1;
        if (r7.collect(r2, this) != r0) goto L12;
        return r0;
    }
}
