package com.larus.bmhome.view.actionbar.edit.kmp;

import android.content.Context;
import android.widget.LinearLayout;
import androidx.fragment.app.CompatKt;
import androidx.fragment.app.Fragment;
import com.larus.bmhome.instruction.core.model.widget.PanelState;
import com.larus.bmhome.instruction.kmp.AbsKmpInstructionWidget;
import com.larus.utils.logger.FLogger;
import cq8.a0;
import cq8.b0;
import cq8.y0;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.view.actionbar.edit.kmp.KmpInstructionEditorViewFactory$observeInstructionWidgetRenderModel$1", f = "KmpInstructionEditorViewFactory.kt", i = {}, l = {399}, m = "invokeSuspend", n = {}, s = {})
final class KmpInstructionEditorViewFactory$observeInstructionWidgetRenderModel$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ LinearLayout $container;
    int label;
    final /* synthetic */ KmpInstructionEditorViewFactory this$0;

    /* JADX INFO: renamed from: com.larus.bmhome.view.actionbar.edit.kmp.KmpInstructionEditorViewFactory$observeInstructionWidgetRenderModel$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "renderModel", "Lcom/larus/bmhome/instruction/core/model/widget/InstructionWidgetRenderModel;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.view.actionbar.edit.kmp.KmpInstructionEditorViewFactory$observeInstructionWidgetRenderModel$1$1", f = "KmpInstructionEditorViewFactory.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<b0, Continuation<? super Unit>, Object> {
        final /* synthetic */ LinearLayout $container;
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ KmpInstructionEditorViewFactory this$0;

        /* JADX INFO: renamed from: com.larus.bmhome.view.actionbar.edit.kmp.KmpInstructionEditorViewFactory$observeInstructionWidgetRenderModel$1$1$a */
        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[PanelState.values().length];
                r0[PanelState.IDLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
            L9:
                r0[PanelState.RENDER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
            L5:
                a = r0;
            }
        }

        public AnonymousClass1(KmpInstructionEditorViewFactory r1, LinearLayout r2, Continuation<? super AnonymousClass1> r3) {
            this.this$0 = r1;
            this.$container = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            AnonymousClass1 r0 = new AnonymousClass1(this.this$0, this.$container, r5);
            r0.L$0 = r4;
            return r0;
        }

        public final Object invoke(b0 r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((b0) r1, (Continuation) r2);
        }

        /* JADX WARN: Type inference failed for: r3v3, types: [android.view.View, com.larus.bmhome.instruction.kmp.AbsKmpInstructionWidget, java.lang.Object] */
        /* JADX WARN: Type inference incomplete: some casts might be missing */
        public final Object invokeSuspend(Object r9) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L36;
            ResultKt.throwOnFailure(r9);
            b0 r10 = (b0) this.L$0;
            FLogger.a.i("KmpInstructionEditorViewFactory", "renderModel: " + r10);
            int r0 = a.a[r10.c.ordinal()];
            if (r0 != 1) goto L7;
            this.this$0.p(true);
        L34:
            return Unit.INSTANCE;
        L7:
            if (r0 != 2) goto L31;
            KmpInstructionEditorViewFactory r1 = this.this$0;
            LinearLayout r2 = this.$container;
            int r3 = KmpInstructionEditorViewFactory.p;
            r1.p(false);
            Iterator r11 = r10.b.iterator();
        L10:
            if (r11.hasNext() == false) goto L34;
            y0 r4 = (y0) r11.next();
            a0 r5 = (a0) r4.c.getValue();
            if (r5 == null) goto L10;
            o r6 = o.a;
            Context r7 = r2.getContext();
            r6.getClass();
            ?? r8 = o.a(r7, r5);
            Object r12 = null;
            if ((r8 instanceof com.larus.bmhome.instruction.kmp.b) == false) goto L17;
            com.larus.bmhome.instruction.kmp.b r13 = (com.larus.bmhome.instruction.kmp.b) r8;
        L18:
            if (r13 == null) goto L20;
            r13.L4(r1.l);
        L20:
            t1a.b r14 = s1a.d.a(r1.a);
            Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L23
            Object r16 = Result.constructor-impl(CompatKt.findFragment(r2));     // Catch: Throwable -> L23
        L26:
            if (Result.isFailure-impl(r16) == true) goto L29;
            r12 = r16;
        L29:
            r8.U5(r14, (Fragment) r12, r4.c, r1.b);
            ((ArrayList) r1.f).add(r8);
            r1.g.put(r4.a, (AbsKmpInstructionWidget) r8);
            r2.addView(r8);
        L23:
            th = move-exception;
            Result.Companion r17 = Result.Companion;
            r16 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L26
        L17:
            r13 = null;
            goto L18
        L31:
            throw new NoWhenBranchMatchedException();
        L36:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public KmpInstructionEditorViewFactory$observeInstructionWidgetRenderModel$1(KmpInstructionEditorViewFactory r1, LinearLayout r2, Continuation<? super KmpInstructionEditorViewFactory$observeInstructionWidgetRenderModel$1> r3) {
        this.this$0 = r1;
        this.$container = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new KmpInstructionEditorViewFactory$observeInstructionWidgetRenderModel$1(this.this$0, this.$container, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        KmpInstructionEditorViewFactory r8 = this.this$0;
        int r2 = KmpInstructionEditorViewFactory.p;
        i1 r9 = r8.q().Jf(this.this$0.c);
        AnonymousClass1 r3 = new AnonymousClass1(this.this$0, this.$container, null);
        this.label = 1;
        if (kotlinx.coroutines.flow.e.i(r9, r3, this) != r0) goto L12;
        return r0;
    }
}
