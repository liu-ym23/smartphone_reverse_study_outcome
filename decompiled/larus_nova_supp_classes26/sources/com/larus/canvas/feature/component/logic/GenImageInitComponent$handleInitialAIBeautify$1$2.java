package com.larus.canvas.feature.component.logic;

import com.larus.canvas.feature.component.instruction.model.InstructionTabState;
import com.larus.canvas.feature.component.instruction.model.TabUIState;
import com.larus.canvas.service.bean.InstructionTab;
import com.larus.canvas.service.bean.OptionItem;
import com.larus.utils.logger.FLogger;
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
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.canvas.feature.component.logic.GenImageInitComponent$handleInitialAIBeautify$1$2", f = "GenImageInitComponent.kt", i = {}, l = {197}, m = "invokeSuspend", n = {}, s = {})
final class GenImageInitComponent$handleInitialAIBeautify$1$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $aiBeautifyId;
    int label;
    final /* synthetic */ GenImageInitComponent this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ GenImageInitComponent a;
        public final /* synthetic */ int b;

        public a(GenImageInitComponent r1, int r2) {
            this.a = r1;
            this.b = r2;
        }

        public final Object emit(Object r14, Continuation r15) {
            InstructionTabState r16 = (InstructionTabState) r14;
            if (this.a.v == false) goto L61;
            if (r16.getTabUiState() != TabUIState.STATE_SHOW) goto L61;
            this.a.v = false;
            List<InstructionTab> r17 = r16.getInstructionTabList();
            int r18 = this.b;
            GenImageInitComponent r1 = this.a;
            FLogger.a.i("GenImageInitComponent", "handleInitialInstructionTabInfo tabList size: " + r17.size());
            List<InstructionTab> r19 = r17;
            Iterator<T> r2 = r19.iterator();
        L8:
            if (r2.hasNext() == false) goto L25;
            T r3 = r2.next();
            InstructionTab r7 = (InstructionTab) r3;
            Integer r8 = r7.getTabType();
            if (r8 != null) goto L13;
        L22:
            boolean r9 = false;
        L23:
            if (r9 == false) goto L8;
        L26:
            InstructionTab r4 = r3;
            if (r4 == null) goto L29;
            FLogger.a.i("GenImageInitComponent", "handleInitialInstructionTabInfo success, initialMsgInstructionId: " + r18);
            GenImageInitComponent.Y2(r1, new GenImageInitComponent$handleInitialAIBeautify$1$2$1$1$1(r1, r4, null));
            goto L61
        L29:
            Iterator<T> r110 = r19.iterator();
        L31:
            if (r110.hasNext() == false) goto L41;
            T r5 = r110.next();
            Integer r10 = ((InstructionTab) r5).getTabType();
            if (r10 != null) goto L36;
        L38:
            boolean r11 = false;
        L39:
            if (r11 == false) goto L31;
        L42:
            InstructionTab r6 = r5;
            if (r6 == null) goto L61;
            List<OptionItem> r111 = r6.getOptionList();
            if (r111 == null) goto L57;
            Iterator<T> r112 = r111.iterator();
        L48:
            if (r112.hasNext() == false) goto L55;
            T r12 = r112.next();
            if (((OptionItem) r12).getId() != r18) goto L52;
            boolean r13 = true;
        L53:
            if (r13 == false) goto L48;
        L56:
            OptionItem r20 = r12;
        L58:
            if (r20 == null) goto L61;
            FLogger.a.i("GenImageInitComponent", "handleInitialInstructionTabInfo success, initialMsgInstructionId: " + r18);
            GenImageInitComponent.Y2(r1, new GenImageInitComponent$handleInitialAIBeautify$1$2$1$1$2(r1, r6, r20, null));
            goto L61
        L52:
            r13 = false;
            goto L53
        L55:
            r12 = (T) null;
            goto L56
        L57:
            r20 = null;
            goto L58
        L36:
            if (r10.intValue() != 3) goto L38;
            r11 = true;
            goto L39
        L41:
            r5 = (T) null;
            goto L42
        L13:
            if (r8.intValue() != 4) goto L22;
            OptionItem r21 = r7.getSingleOption();
            if (r21 != null) goto L17;
        L19:
            boolean r22 = false;
        L20:
            if (r22 == false) goto L22;
            r9 = true;
            goto L23
        L17:
            if (r21.getId() != r18) goto L19;
            r22 = true;
            goto L20
        L25:
            r3 = (T) null;
        L61:
            return Unit.INSTANCE;
        }
    }

    public GenImageInitComponent$handleInitialAIBeautify$1$2(GenImageInitComponent r1, int r2, Continuation<? super GenImageInitComponent$handleInitialAIBeautify$1$2> r3) {
        this.this$0 = r1;
        this.$aiBeautifyId = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new GenImageInitComponent$handleInitialAIBeautify$1$2(this.this$0, this.$aiBeautifyId, r4);
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
        if (r1 != 1) goto L6;
        ResultKt.throwOnFailure(r6);
    L16:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        fy8.h r7 = (fy8.h) this.this$0.s.getValue();
        if (r7 == null) goto L18;
        kotlinx.coroutines.flow.b1 r8 = r7.i70();
        if (r8 == null) goto L18;
        a r2 = new a(this.this$0, this.$aiBeautifyId);
        this.label = 1;
        if (r8.collect(r2, this) != r0) goto L16;
        return r0;
    L18:
        return Unit.INSTANCE;
    }
}
