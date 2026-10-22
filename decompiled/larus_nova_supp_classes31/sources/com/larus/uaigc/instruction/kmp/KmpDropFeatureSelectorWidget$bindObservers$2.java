package com.larus.uaigc.instruction.kmp;

import com.larus.bmhome.actionbar.model.w;
import com.larus.uaigc.instruction.DropFeatureSelectorFragment;
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
@DebugMetadata(c = "com.larus.uaigc.instruction.kmp.KmpDropFeatureSelectorWidget$bindObservers$2", f = "KmpDropFeatureSelectorWidget.kt", i = {}, l = {314}, m = "invokeSuspend", n = {}, s = {})
final class KmpDropFeatureSelectorWidget$bindObservers$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ KmpDropFeatureSelectorWidget this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ KmpDropFeatureSelectorWidget a;

        public a(KmpDropFeatureSelectorWidget r1) {
            this.a = r1;
        }

        public final Object emit(Object r5, Continuation r6) {
            List<w> r7 = (List) r5;
            if (this.a.isAttachedToWindow() == false) goto L50;
            KmpDropFeatureSelectorWidget r8 = this.a;
            com.larus.bmhome.actionbar.model.h r0 = r8.l;
            if (r0 == null) goto L8;
            r0.e = r7;
        L8:
            DropFeatureSelectorFragment r9 = r8.g;
            boolean r1 = false;
            if (r9 == null) goto L11;
            r9.S90(r7, false);
        L11:
            com.larus.bmhome.view.actionbar.edit.c r10 = this.a.j;
            if (r10 == null) goto L14;
            r10.setCurImageList(r7);
        L14:
            com.larus.bmhome.actionbar.model.h r11 = KmpDropFeatureSelectorWidget.Y5(this.a);
            Object r2 = null;
            if (r11 == null) goto L31;
            List r12 = r11.e;
            if (r12 == null) goto L31;
            Iterator<T> r13 = r12.iterator();
        L20:
            if (r13.hasNext() == false) goto L30;
            T r3 = r13.next();
            Integer r4 = ((w) r3).s;
            if (r4 != null) goto L25;
        L27:
            boolean r14 = false;
        L28:
            if (r14 == false) goto L20;
            r2 = r3;
            goto L30
        L25:
            if (r4.intValue() != 1) goto L27;
            r14 = true;
        L30:
            r2 = (w) r2;
        L31:
            KmpDropFeatureSelectorWidget r15 = this.a;
            cq8.k r16 = r15.h;
            if (r16 != null) goto L34;
        L36:
            boolean r17 = false;
        L37:
            if (r17 == false) goto L43;
            com.larus.bmhome.view.actionbar.edit.c r18 = r15.j;
            if (r18 == null) goto L43;
            if (r2 == null) goto L42;
            r1 = true;
        L42:
            r18.setImageStyleRadioSelected(r1);
        L43:
            this.a.Z5();
            return Unit.INSTANCE;
        L34:
            if (r16.h != true) goto L36;
            r17 = true;
            goto L37
        L50:
            return Unit.INSTANCE;
        }
    }

    public KmpDropFeatureSelectorWidget$bindObservers$2(KmpDropFeatureSelectorWidget r1, Continuation<? super KmpDropFeatureSelectorWidget$bindObservers$2> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new KmpDropFeatureSelectorWidget$bindObservers$2(this.this$0, r3);
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
    L16:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        com.larus.bmhome.view.actionbar.edit.c r6 = this.this$0.j;
        if (r6 == null) goto L18;
        d1 r7 = r6.getImageListSelectorWithMoreRefreshFlow();
        if (r7 == null) goto L18;
        a r2 = new a(this.this$0);
        this.label = 1;
        if (r7.collect(r2, this) != r0) goto L16;
        return r0;
    L18:
        return Unit.INSTANCE;
    }
}
