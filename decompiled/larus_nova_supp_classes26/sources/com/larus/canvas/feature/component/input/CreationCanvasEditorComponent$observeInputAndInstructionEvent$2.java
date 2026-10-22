package com.larus.canvas.feature.component.input;

import com.larus.bmhome.chat.tips.GuidePriority;
import com.larus.canvas.feature.ability.CanvasEditorEventType;
import com.larus.canvas.feature.component.instruction.InstructionTabEventType;
import com.larus.canvas.service.bean.InstructionTab;
import com.larus.canvas.service.bean.OptionItem;
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
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.a1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.canvas.feature.component.input.CreationCanvasEditorComponent$observeInputAndInstructionEvent$2", f = "CreationCanvasEditorComponent.kt", i = {}, l = {GuidePriority.VLM_REALTIME_CALL_PRIORITY}, m = "invokeSuspend", n = {}, s = {})
final class CreationCanvasEditorComponent$observeInputAndInstructionEvent$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ CreationCanvasEditorComponent this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ CreationCanvasEditorComponent a;

        /* JADX INFO: renamed from: com.larus.canvas.feature.component.input.CreationCanvasEditorComponent$observeInputAndInstructionEvent$2$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C0089a {
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

        public a(CreationCanvasEditorComponent r1) {
            this.a = r1;
        }

        public final Object emit(Object r13, Continuation r14) {
            com.larus.canvas.feature.component.instruction.c r15 = (com.larus.canvas.feature.component.instruction.c) r13;
            InstructionTabEventType r0 = r15.a;
            String r1 = "";
            switch(C0089a.a[r0.ordinal()]) {
                case 1: goto L96;
                case 2: goto L84;
                case 3: goto L73;
                case 4: goto L62;
                case 5: goto L51;
                case 6: goto L40;
                case 7: goto L23;
                case 8: goto L6;
                default: goto L5;
            };
        L6:
            CreationCanvasEditorComponent r2 = this.a;
            MutableSharedFlow<fy8.d> r3 = r2.o;
            CanvasEditorEventType r4 = CanvasEditorEventType.EVENT_SELECTOR_PANEL_STATUS_CHANGE;
            fy8.f r5 = r2.Y2();
            if (r5 == null) goto L12;
            String r6 = r5.getPrompt();
            if (r6 == null) goto L12;
            String r7 = r6;
        L13:
            InstructionTab r8 = r15.b;
            OptionItem r16 = r15.c;
            if (r16 == null) goto L19;
            String r17 = r16.getDisplayText();
            if (r17 == null) goto L19;
            r1 = r17;
        L19:
            Object r18 = r3.emit(new fy8.d(r4, r7, r8, null, null, new fy8.m(false, r1), 56), r14);
            if (r18 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L97;
            return r18;
        L97:
            return Unit.INSTANCE;
        L12:
            r7 = "";
            goto L13
        L23:
            CreationCanvasEditorComponent r9 = this.a;
            MutableSharedFlow<fy8.d> r10 = r9.o;
            CanvasEditorEventType r11 = CanvasEditorEventType.EVENT_SELECTOR_PANEL_STATUS_CHANGE;
            fy8.f r12 = r9.Y2();
            if (r12 == null) goto L29;
            String r19 = r12.getPrompt();
            if (r19 == null) goto L29;
            String r20 = r19;
        L30:
            InstructionTab r21 = r15.b;
            OptionItem r22 = r15.c;
            if (r22 == null) goto L36;
            String r110 = r22.getDisplayText();
            if (r110 == null) goto L36;
            r1 = r110;
        L36:
            Object r111 = r10.emit(new fy8.d(r11, r20, r21, r22, null, new fy8.m(true, r1), 48), r14);
            if (r111 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L98;
            return r111;
        L98:
            return Unit.INSTANCE;
        L29:
            r20 = "";
            goto L30
        L40:
            CreationCanvasEditorComponent r23 = this.a;
            MutableSharedFlow<fy8.d> r24 = r23.o;
            CanvasEditorEventType r25 = CanvasEditorEventType.EVENT_INSTRUCTION_OPTION_CLICK;
            fy8.f r26 = r23.Y2();
            if (r26 == null) goto L46;
            String r27 = r26.getPrompt();
            if (r27 == null) goto L46;
            String r28 = r27;
        L47:
            Object r112 = r24.emit(new fy8.d(r25, r28, r15.b, r15.c, null, null, 112), r14);
            if (r112 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L99;
            return r112;
        L99:
            return Unit.INSTANCE;
        L46:
            r28 = "";
            goto L47
        L51:
            CreationCanvasEditorComponent r29 = this.a;
            MutableSharedFlow<fy8.d> r30 = r29.o;
            CanvasEditorEventType r31 = CanvasEditorEventType.EVENT_MSG_INSTRUCTION_TAB_CLICK;
            fy8.f r32 = r29.Y2();
            if (r32 == null) goto L57;
            String r33 = r32.getPrompt();
            if (r33 == null) goto L57;
            String r34 = r33;
        L58:
            Object r113 = r30.emit(new fy8.d(r31, r34, r15.b, null, null, null, 120), r14);
            if (r113 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L100;
            return r113;
        L100:
            return Unit.INSTANCE;
        L57:
            r34 = "";
            goto L58
        L62:
            CreationCanvasEditorComponent r35 = this.a;
            MutableSharedFlow<fy8.d> r36 = r35.o;
            CanvasEditorEventType r37 = CanvasEditorEventType.EVENT_DROP_DOWN_BOX_SELECTED;
            fy8.f r38 = r35.Y2();
            if (r38 == null) goto L68;
            String r39 = r38.getPrompt();
            if (r39 == null) goto L68;
            String r40 = r39;
        L69:
            Object r114 = r36.emit(new fy8.d(r37, r40, r15.b, r15.c, null, null, 112), r14);
            if (r114 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L101;
            return r114;
        L101:
            return Unit.INSTANCE;
        L68:
            r40 = "";
            goto L69
        L73:
            CreationCanvasEditorComponent r41 = this.a;
            MutableSharedFlow<fy8.d> r42 = r41.o;
            CanvasEditorEventType r43 = CanvasEditorEventType.EVENT_INSTRUCTION_TAB_UN_SELECTED;
            fy8.f r44 = r41.Y2();
            if (r44 == null) goto L79;
            String r45 = r44.getPrompt();
            if (r45 == null) goto L79;
            String r46 = r45;
        L80:
            Object r115 = r42.emit(new fy8.d(r43, r46, r15.b, null, null, null, 120), r14);
            if (r115 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L102;
            return r115;
        L102:
            return Unit.INSTANCE;
        L79:
            r46 = "";
            goto L80
        L84:
            CreationCanvasEditorComponent r47 = this.a;
            MutableSharedFlow<fy8.d> r48 = r47.o;
            CanvasEditorEventType r49 = CanvasEditorEventType.EVENT_INSTRUCTION_TAB_SELECTED;
            fy8.f r50 = r47.Y2();
            if (r50 == null) goto L90;
            String r51 = r50.getPrompt();
            if (r51 == null) goto L90;
            String r52 = r51;
        L91:
            Object r116 = r48.emit(new fy8.d(r49, r52, r15.b, null, null, null, 120), r14);
            if (r116 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L103;
            return r116;
        L103:
            return Unit.INSTANCE;
        L90:
            r52 = "";
            goto L91
        L5:
            throw new NoWhenBranchMatchedException();
        L96:
            return Unit.INSTANCE;
        }
    }

    public CreationCanvasEditorComponent$observeInputAndInstructionEvent$2(CreationCanvasEditorComponent r1, Continuation<? super CreationCanvasEditorComponent$observeInputAndInstructionEvent$2> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new CreationCanvasEditorComponent$observeInputAndInstructionEvent$2(this.this$0, r3);
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
