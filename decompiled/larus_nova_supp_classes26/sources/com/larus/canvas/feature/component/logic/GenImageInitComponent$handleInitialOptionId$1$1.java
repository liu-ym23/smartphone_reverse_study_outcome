package com.larus.canvas.feature.component.logic;

import com.larus.canvas.feature.component.instruction.model.InstructionTabState;
import com.larus.canvas.feature.component.instruction.model.TabUIState;
import com.larus.canvas.service.bean.InstructionTab;
import com.larus.canvas.service.bean.OptionItem;
import java.util.Iterator;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.canvas.feature.component.logic.GenImageInitComponent$handleInitialOptionId$1$1", f = "GenImageInitComponent.kt", i = {}, l = {151}, m = "invokeSuspend", n = {}, s = {})
final class GenImageInitComponent$handleInitialOptionId$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $optionId;
    final /* synthetic */ String $tabLabel;
    int label;
    final /* synthetic */ GenImageInitComponent this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ GenImageInitComponent a;
        public final /* synthetic */ String b;
        public final /* synthetic */ int c;

        public a(GenImageInitComponent r1, String r2, int r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final Object emit(Object r11, Continuation r12) {
            InstructionTabState r13 = (InstructionTabState) r11;
            if (this.a.v == false) goto L32;
            if (r13.getTabUiState() != TabUIState.STATE_SHOW) goto L32;
            this.a.v = false;
            List<InstructionTab> r14 = r13.getInstructionTabList();
            GenImageInitComponent r15 = this.a;
            String r1 = this.b;
            int r2 = this.c;
            Iterator<T> r16 = r14.iterator();
        L8:
            if (r16.hasNext() == false) goto L12;
            T r3 = r16.next();
            if (Intrinsics.areEqual(((InstructionTab) r3).getTabLabel(), r1) == false) goto L8;
        L13:
            InstructionTab r4 = r3;
            if (r4 == null) goto L32;
            List<OptionItem> r17 = r4.getOptionList();
            if (r17 == null) goto L28;
            Iterator<T> r18 = r17.iterator();
        L19:
            if (r18.hasNext() == false) goto L26;
            T r5 = r18.next();
            if (((OptionItem) r5).getId() != r2) goto L23;
            boolean r6 = true;
        L24:
            if (r6 == false) goto L19;
        L27:
            OptionItem r7 = r5;
        L29:
            if (r7 == null) goto L32;
            GenImageInitComponent.Y2(r15, new GenImageInitComponent$handleInitialOptionId$1$1$1$1$1(r15, r4, r7, null));
            goto L32
        L23:
            r6 = false;
            goto L24
        L26:
            r5 = (T) null;
            goto L27
        L28:
            r7 = null;
            goto L29
        L12:
            r3 = (T) null;
        L32:
            return Unit.INSTANCE;
        }
    }

    public GenImageInitComponent$handleInitialOptionId$1$1(GenImageInitComponent r1, String r2, int r3, Continuation<? super GenImageInitComponent$handleInitialOptionId$1$1> r4) {
        this.this$0 = r1;
        this.$tabLabel = r2;
        this.$optionId = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new GenImageInitComponent$handleInitialOptionId$1$1(this.this$0, this.$tabLabel, this.$optionId, r5);
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
        if (r1 != 1) goto L6;
        ResultKt.throwOnFailure(r7);
    L16:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        fy8.h r8 = (fy8.h) this.this$0.s.getValue();
        if (r8 == null) goto L18;
        kotlinx.coroutines.flow.b1 r9 = r8.i70();
        if (r9 == null) goto L18;
        a r2 = new a(this.this$0, this.$tabLabel, this.$optionId);
        this.label = 1;
        if (r9.collect(r2, this) != r0) goto L16;
        return r0;
    L18:
        return Unit.INSTANCE;
    }
}
