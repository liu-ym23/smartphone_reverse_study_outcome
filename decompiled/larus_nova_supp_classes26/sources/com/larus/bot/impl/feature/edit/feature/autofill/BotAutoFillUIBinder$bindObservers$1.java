package com.larus.bot.impl.feature.edit.feature.autofill;

import android.widget.LinearLayout;
import com.larus.bot.impl.common.propertyconfig.Visibility;
import com.larus.bot.impl.databinding.LarusLayoutAutoFillBtnBinding;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
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
@DebugMetadata(c = "com.larus.bot.impl.feature.edit.feature.autofill.BotAutoFillUIBinder$bindObservers$1", f = "BotAutoFillUIBinder.kt", i = {}, l = {89}, m = "invokeSuspend", n = {}, s = {})
final class BotAutoFillUIBinder$bindObservers$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ BotAutoFillUIBinder this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ BotAutoFillUIBinder a;

        public a(BotAutoFillUIBinder r1) {
            this.a = r1;
        }

        public final Object emit(Object r5, Continuation r6) {
            c r7 = (c) r5;
            BotAutoFillUIBinder r8 = this.a;
            int r0 = BotAutoFillUIBinder.f;
            r8.getClass();
            Visibility r1 = r7.a.a;
            int r2 = BotAutoFillUIBinder.b.a[r1.ordinal()];
            boolean r3 = true;
            if (r2 != 1) goto L5;
        L11:
            r8.b.b();
            LarusLayoutAutoFillBtnBinding r9 = (LarusLayoutAutoFillBtnBinding) r8.b.c;
            if (r9 == null) goto L22;
            LinearLayout r4 = r9.a;
            if (r7.a.a == Visibility.VISIBLE) goto L17;
            r3 = false;
        L17:
            r4.setEnabled(r3);
            r9.b.setText(r7.a.b.toString(r9.a.getContext()));
            if (r7.a.a != Visibility.DISABLE) goto L20;
            r9.a.setAlpha(0.3f);
            goto L22
        L20:
            r9.a.setAlpha(1.0f);
        L22:
            return Unit.INSTANCE;
        L5:
            if (r2 == 2) goto L11;
            if (r2 != 3) goto L10;
            r8.b.a();
            goto L22
        L10:
            throw new NoWhenBranchMatchedException();
        }
    }

    public BotAutoFillUIBinder$bindObservers$1(BotAutoFillUIBinder r1, Continuation<? super BotAutoFillUIBinder$bindObservers$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new BotAutoFillUIBinder$bindObservers$1(this.this$0, r3);
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
        i1<c> r6 = this.this$0.c.getUiState();
        a r2 = new a(this.this$0);
        this.label = 1;
        if (r6.collect(r2, this) != r0) goto L12;
        return r0;
    }
}
