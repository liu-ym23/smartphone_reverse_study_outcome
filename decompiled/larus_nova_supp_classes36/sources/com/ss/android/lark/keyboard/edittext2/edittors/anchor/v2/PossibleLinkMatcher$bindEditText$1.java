package com.ss.android.lark.keyboard.edittext2.edittors.anchor.v2;

import android.text.Editable;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
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
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.keyboard.edittext2.edittors.anchor.v2.PossibleLinkMatcher$bindEditText$1", f = "PossibleLinkMatcher.kt", i = {}, l = {250}, m = "invokeSuspend", n = {}, s = {})
public final class PossibleLinkMatcher$bindEditText$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ PossibleLinkMatcher this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ PossibleLinkMatcher a;

        public a(PossibleLinkMatcher r1) {
            this.a = r1;
        }

        public final Object emit(Object r8, Continuation r9) {
            b r10 = (b) r8;
            if (r10 == null) goto L5;
            Editable r0 = r10.b;
        L6:
            if (r0 == null) goto L9;
            PossibleLinkMatcher r1 = this.a;
            BuildersKt.launch$default(r1.b, null, null, new PossibleLinkMatcher$matchUrl$1(r1, r10.b, null), 3, null);
        L9:
            return Unit.INSTANCE;
        L5:
            r0 = null;
            goto L6
        }
    }

    public PossibleLinkMatcher$bindEditText$1(PossibleLinkMatcher r1, Continuation<? super PossibleLinkMatcher$bindEditText$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new PossibleLinkMatcher$bindEditText$1(this.this$0, r3);
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
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        Flow r7 = kotlinx.coroutines.flow.e.m(this.this$0.a, 300);
        a r2 = new a(this.this$0);
        this.label = 1;
        if (r7.collect(r2, this) != r0) goto L12;
        return r0;
    }
}
