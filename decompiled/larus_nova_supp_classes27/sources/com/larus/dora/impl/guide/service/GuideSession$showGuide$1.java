package com.larus.dora.impl.guide.service;

import android.view.View;
import androidx.fragment.app.Fragment;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
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
@DebugMetadata(c = "com.larus.dora.impl.guide.service.GuideSession$showGuide$1", f = "DoraGuideServiceImpl.kt", i = {}, l = {471}, m = "invokeSuspend", n = {}, s = {})
final class GuideSession$showGuide$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ View $anchorView;
    final /* synthetic */ Fragment $fragment;
    final /* synthetic */ int $guideId;
    int label;
    final /* synthetic */ GuideSession this$0;

    /* JADX INFO: renamed from: com.larus.dora.impl.guide.service.GuideSession$showGuide$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.guide.service.GuideSession$showGuide$1$1", f = "DoraGuideServiceImpl.kt", i = {}, l = {471}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ View $anchorView;
        final /* synthetic */ Fragment $fragment;
        final /* synthetic */ l $target;
        int label;

        public AnonymousClass1(l r1, Fragment r2, View r3, Continuation<? super AnonymousClass1> r4) {
            this.$target = r1;
            this.$fragment = r2;
            this.$anchorView = r3;
            super(1, r4);
        }

        public final Continuation<Unit> create(Continuation<?> r5) {
            return new AnonymousClass1(this.$target, this.$fragment, this.$anchorView, r5);
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
            if (r6.e(r2, r3, this) != r0) goto L12;
            return r0;
        }
    }

    public GuideSession$showGuide$1(GuideSession r1, int r2, Fragment r3, View r4, Continuation<? super GuideSession$showGuide$1> r5) {
        this.this$0 = r1;
        this.$guideId = r2;
        this.$fragment = r3;
        this.$anchorView = r4;
        super(1, r5);
    }

    public final Continuation<Unit> create(Continuation<?> r8) {
        return new GuideSession$showGuide$1(this.this$0, this.$guideId, this.$fragment, this.$anchorView, r8);
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
        ResultKt.throwOnFailure(r8);     // Catch: Exception -> L37
    L40:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r8);
        l r9 = this.this$0.i;     // Catch: Exception -> L37
        if (r9 != null) goto L13;
    L20:
        CopyOnWriteArrayList<l> r10 = this.this$0.j;     // Catch: Exception -> L37
        int r4 = this.$guideId;     // Catch: Exception -> L37
        Iterator<T> r11 = r10.iterator();     // Catch: Exception -> L37
    L22:
        if (r11.hasNext() == false) goto L29;
        Object r5 = r11.next();     // Catch: Exception -> L37
        if (((l) r5).f() != r4) goto L26;
        boolean r6 = true;
    L27:
        if (r6 == false) goto L22;
    L30:
        r9 = (l) r5;     // Catch: Exception -> L37
    L31:
        if (r9 != null) goto L34;
        g49.d.b(this.this$0.c(), "showGuide failed: target guide not found id=" + this.$guideId);     // Catch: Exception -> L37
        return Unit.INSTANCE;
    L34:
        GuideSession r2 = this.this$0;     // Catch: Exception -> L37
        AnonymousClass1 r7 = new AnonymousClass1(r9, this.$fragment, this.$anchorView, null);     // Catch: Exception -> L37
        this.label = 1;     // Catch: Exception -> L37
        r2.getClass();     // Catch: Exception -> L37
        if (GuideSession.f(r7, this) != r0) goto L40;
        return r0;
    L26:
        r6 = false;
        goto L27
    L29:
        r5 = null;
        goto L30
    L13:
        if (r9.f() != this.$guideId) goto L15;
        boolean r12 = true;
    L16:
        if (r12 == true) goto L19;
        r9 = null;
    L19:
        if (r9 != null) goto L31;
    L15:
        r12 = false;
    L37:
        e = move-exception;
        g49.d.c(this.this$0.c(), "showGuide() exception: " + e.getMessage(), e);
        this.this$0.h(GuideSession.GuideSessionState.FINISHED);
        goto L40
    }
}
