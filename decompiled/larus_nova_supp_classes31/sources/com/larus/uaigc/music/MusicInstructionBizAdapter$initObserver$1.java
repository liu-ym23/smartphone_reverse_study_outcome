package com.larus.uaigc.music;

import com.larus.bmhome.actionbar.model.i0;
import com.larus.bmhome.actionbar.model.r;
import com.larus.bmhome.actionbar.model.w;
import com.larus.bmhome.music.instructions.g;
import com.larus.bmhome.view.actionbar.edit.c;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
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
import kotlinx.coroutines.flow.d1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.music.MusicInstructionBizAdapter$initObserver$1", f = "MusicInstructionBizAdapter.kt", i = {}, l = {118}, m = "invokeSuspend", n = {}, s = {})
final class MusicInstructionBizAdapter$initObserver$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ c $instructionEditorViewModel;
    int label;
    final /* synthetic */ b this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ c a;
        public final /* synthetic */ b b;

        public a(c r1, b r2) {
            this.a = r1;
            this.b = r2;
        }

        public final Object emit(Object r5, Continuation r6) {
            i0 r7 = (i0) r5;
            FLogger.a.d("MusicInstructionBizAdapter", "instructionTabSelected = " + r7);
            r r8 = this.a.getCurrentInstructionConf();
            int r0 = 0;
            if (r8 == null) goto L10;
            Integer r9 = r8.a;
            if (r9 == null) goto L10;
            if (r9.intValue() != 1) goto L10;
            boolean r10 = true;
        L11:
            if (r10 == false) goto L35;
            List r11 = r7.a;
            w r12 = null;
            T r13 = null;
            if (r11 == null) goto L27;
            Iterator<T> r14 = r11.iterator();
        L16:
            if (r14.hasNext() == false) goto L26;
            T r2 = r14.next();
            Integer r3 = ((w) r2).s;
            if (r3 != null) goto L21;
        L23:
            boolean r4 = false;
        L24:
            if (r4 == false) goto L16;
            r13 = r2;
            goto L26
        L21:
            if (r3.intValue() != 1) goto L23;
            r4 = true;
        L26:
            r12 = (w) r13;
        L27:
            if (r12 == null) goto L35;
            b r15 = this.b;
            Long r16 = r12.a;
            if (r16 == null) goto L31;
            r0 = (int) r16.longValue();
        L31:
            g r17 = r15.j;
            if (r17 == null) goto L35;
            r17.f(r0);
        L35:
            return Unit.INSTANCE;
        L10:
            r10 = false;
            goto L11
        }
    }

    public MusicInstructionBizAdapter$initObserver$1(c r1, b r2, Continuation<? super MusicInstructionBizAdapter$initObserver$1> r3) {
        this.$instructionEditorViewModel = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new MusicInstructionBizAdapter$initObserver$1(this.$instructionEditorViewModel, this.this$0, r4);
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
    L12:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        d1 r7 = this.$instructionEditorViewModel.getInstructionTabSelected();
        a r2 = new a(this.$instructionEditorViewModel, this.this$0);
        this.label = 1;
        if (r7.collect(r2, this) != r0) goto L12;
        return r0;
    }
}
