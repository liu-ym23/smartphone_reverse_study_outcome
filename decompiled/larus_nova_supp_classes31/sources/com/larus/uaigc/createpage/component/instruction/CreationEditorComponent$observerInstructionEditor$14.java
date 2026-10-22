package com.larus.uaigc.createpage.component.instruction;

import android.app.Application;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.component.instruction.CreationEditorComponent$observerInstructionEditor$14", f = "CreationEditorComponent.kt", i = {}, l = {2986}, m = "invokeSuspend", n = {}, s = {})
final class CreationEditorComponent$observerInstructionEditor$14 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ CreationEditorComponent this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ CreationEditorComponent a;

        public a(CreationEditorComponent r1) {
            this.a = r1;
        }

        public final Object emit(Object r3, Continuation r4) {
            if (((fq8.e) r3) == null) goto L25;
            CreationEditorComponent r5 = this.a;
            FLogger.a.d("CreationEditorComponent", "clicked imgInspiration");
            int r6 = CreationEditorComponent.g2;
            ry9.g r7 = r5.k4();
            if (r7 == null) goto L9;
            kotlinx.coroutines.flow.i1<ry9.j> r8 = r7.D20();
            if (r8 == null) goto L9;
            ry9.j r9 = (ry9.j) r8.getValue();
        L11:
            if ((r9 instanceof ry9.j.c) == false) goto L13;
        L21:
            r5.Z = true;
            r5.p0 = "image_gen_suggest";
            va8.o r10 = r5.X3();
            if (r10 == null) goto L25;
            r10.Vc();
            goto L25
        L13:
            if ((r9 instanceof ry9.j.b) == true) goto L21;
            if ((r9 instanceof ry9.j.f) == false) goto L19;
            t19.s r11 = t19.s.a;
            Application r0 = AppHost.a.getApplication();
            String r12 = r5.getContext().getString(2131899639);
            r11.getClass();
            t19.s.t(r0, r12);
            goto L25
        L19:
            if ((r9 instanceof ry9.j.h) == false) goto L25;
            t19.s r13 = t19.s.a;
            Application r1 = AppHost.a.getApplication();
            String r14 = r5.getContext().getString(2131899641);
            r13.getClass();
            t19.s.t(r1, r14);
        L9:
            r9 = null;
        L25:
            return Unit.INSTANCE;
        }
    }

    public CreationEditorComponent$observerInstructionEditor$14(CreationEditorComponent r1, Continuation<? super CreationEditorComponent$observerInstructionEditor$14> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new CreationEditorComponent$observerInstructionEditor$14(this.this$0, r3);
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
        CreationEditorComponent r6 = this.this$0;
        int r2 = CreationEditorComponent.g2;
        kotlinx.coroutines.flow.d1 r7 = r6.i4().getChosenImgInspirationFlow();
        a r3 = new a(this.this$0);
        this.label = 1;
        if (r7.collect(r3, this) != r0) goto L12;
        return r0;
    }
}
