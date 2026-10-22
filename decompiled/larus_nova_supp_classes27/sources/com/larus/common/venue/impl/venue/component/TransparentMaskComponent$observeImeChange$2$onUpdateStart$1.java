package com.larus.common.venue.impl.venue.component;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.larus.common.venue.impl.venue.viewmodel.TransparentViewModel;
import com.larus.common_ui.utils.ViewExtKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.common.venue.impl.venue.component.TransparentMaskComponent$observeImeChange$2$onUpdateStart$1", f = "TransparentMaskComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class TransparentMaskComponent$observeImeChange$2$onUpdateStart$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ View $chatRoot;
    int label;
    final /* synthetic */ TransparentMaskComponent this$0;

    public TransparentMaskComponent$observeImeChange$2$onUpdateStart$1(View r1, TransparentMaskComponent r2, Continuation<? super TransparentMaskComponent$observeImeChange$2$onUpdateStart$1> r3) {
        this.$chatRoot = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new TransparentMaskComponent$observeImeChange$2$onUpdateStart$1(this.$chatRoot, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L23;
        ResultKt.throwOnFailure(r3);
        TransparentMaskComponent r4 = this.this$0;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L7
        Object r5 = Result.constructor-impl(s1a.a.getActivity(r4));     // Catch: Throwable -> L7
    L10:
        if (Result.isFailure-impl(r5) == false) goto L12;
        r5 = null;
    L12:
        FragmentActivity r6 = (FragmentActivity) r5;
        if (r6 == null) goto L17;
        boolean r1 = true;
        if (r6.isFinishing() != true) goto L17;
    L18:
        if (r1 == true) goto L21;
        boolean r7 = ViewExtKt.h(this.$chatRoot);
        TransparentMaskComponent r2 = this.this$0;
        int r8 = TransparentMaskComponent.p;
        ((TransparentViewModel) r2.n.getValue()).setHasShowIme(r7);
    L21:
        return Unit.INSTANCE;
    L17:
        r1 = false;
    L7:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    L23:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
