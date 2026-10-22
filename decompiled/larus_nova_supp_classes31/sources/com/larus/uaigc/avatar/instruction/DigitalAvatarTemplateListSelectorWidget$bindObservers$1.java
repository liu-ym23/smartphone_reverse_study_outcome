package com.larus.uaigc.avatar.instruction;

import com.tencent.open.log.TraceLevel;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.d1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.avatar.instruction.DigitalAvatarTemplateListSelectorWidget$bindObservers$1", f = "DigitalAvatarTemplateListSelectorWidget.kt", i = {}, l = {366}, m = "invokeSuspend", n = {}, s = {})
final class DigitalAvatarTemplateListSelectorWidget$bindObservers$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ DigitalAvatarTemplateListSelectorWidget this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ DigitalAvatarTemplateListSelectorWidget a;

        public a(DigitalAvatarTemplateListSelectorWidget r1) {
            this.a = r1;
        }

        public final Object emit(Object r3, Continuation r4) {
            Triple r5 = (Triple) r3;
            DigitalAvatarTemplateListSelectorWidget.a r6 = this.a.j;
            ab8.a r0 = (ab8.a) r5.getFirst();
            ((Number) r5.getSecond()).intValue();
            String r7 = (String) r5.getThird();
            r6.getClass();
            Intrinsics.checkNotNullParameter(r0, "templateInfo");
            Intrinsics.checkNotNullParameter(r7, "enterFrom");
            DigitalAvatarTemplateListSelectorWidget r8 = r6.a;
            int r9 = DigitalAvatarTemplateListSelectorWidget.l;
            r8.u6(r0);
            return Unit.INSTANCE;
        }
    }

    public DigitalAvatarTemplateListSelectorWidget$bindObservers$1(DigitalAvatarTemplateListSelectorWidget r1, Continuation<? super DigitalAvatarTemplateListSelectorWidget$bindObservers$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new DigitalAvatarTemplateListSelectorWidget$bindObservers$1(this.this$0, r3);
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
        DigitalAvatarTemplateListSelectorWidget r6 = this.this$0;
        int r2 = DigitalAvatarTemplateListSelectorWidget.l;
        com.larus.bmhome.view.actionbar.edit.c r7 = r6.getViewModel();
        if (r7 == null) goto L18;
        d1 r8 = r7.getDigitalAvatarTemplateChooseFlow();
        if (r8 == null) goto L18;
        a r3 = new a(this.this$0);
        this.label = 1;
        if (r8.collect(r3, this) != r0) goto L16;
        return r0;
    L18:
        return Unit.INSTANCE;
    }
}
