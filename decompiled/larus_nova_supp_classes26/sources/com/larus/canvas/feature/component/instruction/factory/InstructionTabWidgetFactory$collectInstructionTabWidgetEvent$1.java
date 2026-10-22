package com.larus.canvas.feature.component.instruction.factory;

import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.larus.canvas.feature.component.instruction.InstructionTabEventType;
import com.larus.canvas.service.bean.InstructionTab;
import com.larus.utils.i;
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
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.a1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.canvas.feature.component.instruction.factory.InstructionTabWidgetFactory$collectInstructionTabWidgetEvent$1", f = "InstructionTabWidgetFactory.kt", i = {}, l = {110}, m = "invokeSuspend", n = {}, s = {})
final class InstructionTabWidgetFactory$collectInstructionTabWidgetEvent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ InstructionTabWidgetFactory this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ InstructionTabWidgetFactory a;

        /* JADX INFO: renamed from: com.larus.canvas.feature.component.instruction.factory.InstructionTabWidgetFactory$collectInstructionTabWidgetEvent$1$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C0090a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[InstructionTabEventType.values().length];
                r0[InstructionTabEventType.NONE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
            L23:
                r0[InstructionTabEventType.EVENT_INSTRUCTION_TAB_SELECTED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
            L35:
                r0[InstructionTabEventType.EVENT_INSTRUCTION_TAB_UN_SELECTED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
            L25:
                r0[InstructionTabEventType.EVENT_DROP_DOWN_BOX_SELECTED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
            L27:
                r0[InstructionTabEventType.EVENT_MSG_INSTRUCTION_TAB_CLICK.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
            L21:
                r0[InstructionTabEventType.EVENT_INSTRUCTION_OPTION_CLICK.ordinal()] = 6;     // Catch: NoSuchFieldError -> L18
            L29:
                r0[InstructionTabEventType.EVENT_SELECTOR_PANEL_STATUS_SELECTED.ordinal()] = 7;     // Catch: NoSuchFieldError -> L19
            L31:
                r0[InstructionTabEventType.EVENT_SELECTOR_PANEL_STATUS_UNSELECTED.ordinal()] = 8;     // Catch: NoSuchFieldError -> L20
            L11:
                a = r0;
            }
        }

        public a(InstructionTabWidgetFactory r1) {
            this.a = r1;
        }

        public final Object emit(Object r12, Continuation r13) {
            com.larus.canvas.feature.component.instruction.c r14 = (com.larus.canvas.feature.component.instruction.c) r12;
            ViewGroup r8 = null;
            ViewGroup r9 = null;
            ViewGroup r10 = null;
            Integer r11 = null;
            switch(C0090a.a[r14.a.ordinal()]) {
                case 1: goto L90;
                case 2: goto L33;
                case 3: goto L12;
                case 4: goto L10;
                case 5: goto L9;
                case 6: goto L8;
                case 7: goto L7;
                case 8: goto L6;
                default: goto L5;
            };
        L6:
            this.a.h = true;
            goto L90
        L7:
            this.a.h = true;
            goto L90
        L8:
            this.a.h = true;
            goto L90
        L9:
            this.a.h = true;
            goto L90
        L10:
            this.a.h = true;
            goto L90
        L33:
            InstructionTab r15 = r14.b;
            if (r15 == null) goto L88;
            final InstructionTabWidgetFactory r16 = this.a;
            boolean r17 = r14.d;
            com.larus.canvas.feature.component.instruction.b r18 = r16.e.get(r15);
            if (r18 == null) goto L88;
            View r19 = r18.b();
            if (r19 == null) goto L88;
            ViewGroup r110 = r16.c;
            if (r110 != null) goto L43;
            Intrinsics.throwUninitializedPropertyAccessException("customAreaContainer");
            r110 = null;
        L43:
            if (r110.getHeight() != 0) goto L73;
            if (r17 == true) goto L73;
            ViewGroup r111 = r16.c;
            if (r111 != null) goto L48;
            Intrinsics.throwUninitializedPropertyAccessException("customAreaContainer");
            r111 = null;
        L48:
            r111.removeAllViews();
            ViewGroup r112 = r16.c;
            if (r112 != null) goto L51;
            Intrinsics.throwUninitializedPropertyAccessException("customAreaContainer");
            r112 = null;
        L51:
            r112.addView(r19);
            ViewGroup r113 = r16.c;
            if (r113 != null) goto L54;
            Intrinsics.throwUninitializedPropertyAccessException("customAreaContainer");
            r113 = null;
        L54:
            Integer r114 = Integer.valueOf(r113.getWidth());
            if (r114.intValue() <= 0) goto L57;
            boolean r5 = true;
        L58:
            if (r5 == true) goto L61;
            r114 = null;
        L61:
            if (r114 == null) goto L63;
            int r115 = r114.intValue();
        L72:
            r19.measure(View.MeasureSpec.makeMeasureSpec(r115, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
            ValueAnimator r116 = ValueAnimator.ofInt(new int[]{0, r19.getMeasuredHeight()});
            r116.setDuration(200);
            r116.addUpdateListener(new b(r16));
            r116.addListener(new c(r16));
            r16.i = r116;
            r116.start();
            goto L88
        L63:
            Fragment r117 = r16.a;
            if (r117 != null) goto L66;
            Intrinsics.throwUninitializedPropertyAccessException("fragment");
            r117 = null;
        L66:
            Context r118 = r117.getContext();
            if (r118 == null) goto L69;
            r11 = Integer.valueOf(i.d(r118));
        L69:
            if (r11 == null) goto L71;
            r115 = r11.intValue();
            goto L72
        L71:
            r115 = 0;
            goto L72
        L57:
            r5 = false;
        L73:
            ViewGroup r119 = r16.c;
            if (r119 != null) goto L76;
            Intrinsics.throwUninitializedPropertyAccessException("customAreaContainer");
            r119 = null;
        L76:
            ViewGroup.LayoutParams r1 = r119.getLayoutParams();
            if (r1 == null) goto L87;
            r1.height = -2;
            r119.setLayoutParams(r1);
            ViewGroup r120 = r16.c;
            if (r120 != null) goto L81;
            Intrinsics.throwUninitializedPropertyAccessException("customAreaContainer");
            r120 = null;
        L81:
            r120.removeAllViews();
            ViewGroup r121 = r16.c;
            if (r121 != null) goto L84;
            Intrinsics.throwUninitializedPropertyAccessException("customAreaContainer");
        L85:
            r8.addView(r19);
            goto L88
        L84:
            r8 = r121;
            goto L85
        L87:
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        L88:
            this.a.h = true;
            goto L90
        L5:
            throw new NoWhenBranchMatchedException();
        L12:
            if (r14.b == null) goto L32;
            final InstructionTabWidgetFactory r122 = this.a;
            if (r14.d == false) goto L27;
            ViewGroup r123 = r122.c;
            if (r123 != null) goto L18;
            Intrinsics.throwUninitializedPropertyAccessException("customAreaContainer");
            r123 = null;
        L18:
            ViewGroup.LayoutParams r2 = r123.getLayoutParams();
            if (r2 == null) goto L26;
            r2.height = -2;
            r123.setLayoutParams(r2);
            ViewGroup r124 = r122.c;
            if (r124 != null) goto L23;
            Intrinsics.throwUninitializedPropertyAccessException("customAreaContainer");
        L24:
            r9.removeAllViews();
            goto L32
        L23:
            r9 = r124;
            goto L24
        L26:
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        L27:
            ViewGroup r125 = r122.c;
            if (r125 != null) goto L30;
            Intrinsics.throwUninitializedPropertyAccessException("customAreaContainer");
        L31:
            ValueAnimator r126 = ValueAnimator.ofInt(new int[]{r10.getHeight(), 0});
            r126.setDuration(200);
            r126.addUpdateListener(new com.larus.canvas.feature.component.instruction.factory.a(r122));
            r126.addListener(new d(r122));
            r122.i = r126;
            r126.start();
            goto L32
        L30:
            r10 = r125;
        L32:
            this.a.h = true;
        L90:
            return Unit.INSTANCE;
        }
    }

    public InstructionTabWidgetFactory$collectInstructionTabWidgetEvent$1(InstructionTabWidgetFactory r1, Continuation<? super InstructionTabWidgetFactory$collectInstructionTabWidgetEvent$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new InstructionTabWidgetFactory$collectInstructionTabWidgetEvent$1(this.this$0, r3);
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
        a1 r6 = com.larus.canvas.feature.component.instruction.d.b;
        a r2 = new a(this.this$0);
        this.label = 1;
        if (r6.collect(r2, this) != r0) goto L12;
        return r0;
    }
}
