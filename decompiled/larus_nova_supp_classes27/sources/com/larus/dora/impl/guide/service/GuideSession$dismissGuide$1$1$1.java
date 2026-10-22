package com.larus.dora.impl.guide.service;

import android.view.View;
import androidx.fragment.app.Fragment;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import t39.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.guide.service.GuideSession$dismissGuide$1$1$1", f = "DoraGuideServiceImpl.kt", i = {}, l = {499}, m = "invokeSuspend", n = {}, s = {})
public final class GuideSession$dismissGuide$1$1$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ View $anchorView;
    final /* synthetic */ Fragment $fragment;
    final /* synthetic */ l $target;
    int label;

    public GuideSession$dismissGuide$1$1$1(l r1, Fragment r2, View r3, Continuation<? super GuideSession$dismissGuide$1$1$1> r4) {
        this.$target = r1;
        this.$fragment = r2;
        this.$anchorView = r3;
        super(1, r4);
    }

    public final Continuation<Unit> create(Continuation<?> r5) {
        return new GuideSession$dismissGuide$1$1$1(this.$target, this.$fragment, this.$anchorView, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Continuation) r1);
    }

    public final Object invoke(Continuation<? super Unit> r2) {
        return create(r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        l r6 = this.$target;
        Fragment r2 = this.$fragment;
        View r3 = this.$anchorView;
        this.label = 1;
        if (r6.d(r2, r3, this) != r0) goto L12;
        return r0;
    }
}
