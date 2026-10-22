package com.larus.dora.impl.guide.service;

import android.view.View;
import androidx.fragment.app.Fragment;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Result;
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
@DebugMetadata(c = "com.larus.dora.impl.guide.service.GuideSession$dismissGuide$1", f = "DoraGuideServiceImpl.kt", i = {}, l = {499}, m = "invokeSuspend", n = {}, s = {})
final class GuideSession$dismissGuide$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ View $anchorView;
    final /* synthetic */ Fragment $fragment;
    final /* synthetic */ int $guideId;
    int label;
    final /* synthetic */ GuideSession this$0;

    public GuideSession$dismissGuide$1(GuideSession r1, int r2, Fragment r3, View r4, Continuation<? super GuideSession$dismissGuide$1> r5) {
        this.this$0 = r1;
        this.$guideId = r2;
        this.$fragment = r3;
        this.$anchorView = r4;
        super(1, r5);
    }

    public final Continuation<Unit> create(Continuation<?> r8) {
        return new GuideSession$dismissGuide$1(this.this$0, this.$guideId, this.$fragment, this.$anchorView, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Continuation) r1);
    }

    public final Object invoke(Continuation<? super Unit> r2) {
        return create(r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L9;
        if (r1 != 1) goto L8;
        ResultKt.throwOnFailure(r8);     // Catch: Throwable -> L39
    L37:
        Object r9 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L39
    L41:
        GuideSession r2 = this.this$0;
        Throwable r10 = Result.exceptionOrNull-impl(r9);
        if (r10 == null) goto L45;
        g49.d.c(r2.c(), "dismissGuide() exception: " + r10.getMessage(), r10);
        r2.h(GuideSession.GuideSessionState.FINISHED);
    L45:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r8);
        l r11 = this.this$0.i;
        if (r11 != null) goto L12;
    L19:
        CopyOnWriteArrayList<l> r12 = this.this$0.j;
        int r4 = this.$guideId;
        Iterator<T> r13 = r12.iterator();
    L21:
        if (r13.hasNext() == false) goto L28;
        Object r5 = r13.next();
        if (((l) r5).f() != r4) goto L25;
        boolean r6 = true;
    L26:
        if (r6 == false) goto L21;
    L29:
        r11 = (l) r5;
    L30:
        if (r11 != null) goto L33;
        g49.d.b(this.this$0.c(), "dismissGuide failed: target guide not found id=" + this.$guideId);
        return Unit.INSTANCE;
    L33:
        GuideSession r3 = this.this$0;
        Fragment r7 = this.$fragment;
        View r14 = this.$anchorView;
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L39
        GuideSession$dismissGuide$1$1$1 r16 = new GuideSession$dismissGuide$1$1$1(r11, r7, r14, null);     // Catch: Throwable -> L39
        this.label = 1;     // Catch: Throwable -> L39
        r3.getClass();     // Catch: Throwable -> L39
        if (GuideSession.f(r16, this) != r0) goto L37;
        return r0;
    L25:
        r6 = false;
        goto L26
    L28:
        r5 = null;
        goto L29
    L12:
        if (r11.f() != this.$guideId) goto L14;
        boolean r17 = true;
    L15:
        if (r17 == true) goto L18;
        r11 = null;
    L18:
        if (r11 != null) goto L30;
    L14:
        r17 = false;
    L39:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L41
    }
}
