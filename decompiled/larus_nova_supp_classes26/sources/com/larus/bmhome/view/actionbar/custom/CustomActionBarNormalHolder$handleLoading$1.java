package com.larus.bmhome.view.actionbar.custom;

import android.content.Context;
import android.graphics.Rect;
import androidx.core.content.ContextCompat;
import com.larus.utils.logger.FLogger;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.view.actionbar.custom.CustomActionBarNormalHolder$handleLoading$1", f = "CustomActionBarHolder.kt", i = {}, l = {350}, m = "invokeSuspend", n = {}, s = {})
final class CustomActionBarNormalHolder$handleLoading$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.larus.bmhome.actionbar.model.z0 $data;
    int label;
    final /* synthetic */ CustomActionBarNormalHolder this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ CustomActionBarNormalHolder a;

        public a(CustomActionBarNormalHolder r1) {
            this.a = r1;
        }

        public final Object emit(Object r4, Continuation r5) {
            boolean r6 = ((Boolean) r4).booleanValue();
            FLogger.a.d("CustomActionBarNormalHolder", "loadingStatus:" + r6);
            if (r6 == false) goto L10;
            CustomActionBarNormalHolder r7 = this.a;
            if (r7.u != null) goto L9;
            Context r8 = r7.a.getContext();
            if (r8 == null) goto L9;
            CustomActionBarNormalHolder r0 = this.a;
            r0.u = ContextCompat.getDrawable(r8, 2131240795);
            Rect r9 = r0.j.getIndeterminateDrawable().getBounds();
            r0.j.setIndeterminateDrawable(r0.u);
            r0.j.getIndeterminateDrawable().setBounds(r9);
        L9:
            this.a.j.setVisibility(0);
            this.a.i.setVisibility(4);
        L12:
            return Unit.INSTANCE;
        L10:
            CustomActionBarNormalHolder r10 = this.a;
            int r1 = CustomActionBarNormalHolder.v;
            r10.j.setVisibility(8);
            r10.i.setVisibility(0);
            goto L12
        }
    }

    public CustomActionBarNormalHolder$handleLoading$1(CustomActionBarNormalHolder r1, com.larus.bmhome.actionbar.model.z0 r2, Continuation<? super CustomActionBarNormalHolder$handleLoading$1> r3) {
        this.this$0 = r1;
        this.$data = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new CustomActionBarNormalHolder$handleLoading$1(this.this$0, this.$data, r4);
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
    L14:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        kotlinx.coroutines.flow.i1<Boolean> r6 = this.this$0.c.c(String.valueOf(this.$data.a));
        if (r6 == null) goto L16;
        a r2 = new a(this.this$0);
        this.label = 1;
        if (r6.collect(r2, this) != r0) goto L14;
        return r0;
    L16:
        return Unit.INSTANCE;
    }
}
