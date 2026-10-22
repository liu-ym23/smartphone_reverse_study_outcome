package com.larus.bmhome.view.actionbar.edit.component;

import com.larus.platform.kmp.chat.TemplateInfo;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.view.actionbar.edit.component.DropdownSelectorWidget$onBindView$1", f = "DropdownSelectorWidget.kt", i = {}, l = {143}, m = "invokeSuspend", n = {}, s = {})
final class DropdownSelectorWidget$onBindView$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ DropdownSelectorWidget this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ DropdownSelectorWidget a;

        public a(DropdownSelectorWidget r1) {
            this.a = r1;
        }

        public final Object emit(Object r5, Continuation r6) {
            TemplateInfo.TemplateInfo r7 = ((com.larus.bmhome.view.actionbar.edit.m) r5).a;
            if (CollectionsKt.contains(CollectionsKt.listOf(new Integer[]{Boxing.boxInt(2), Boxing.boxInt(1)}), DropdownSelectorWidget.s6(this.a)) == false) goto L8;
            long r8 = r7.g;
            if (r8 == (-1)) goto L16;
            this.a.r7(Boxing.boxLong(r8), "use_template");
        L15:
            return Unit.INSTANCE;
        L16:
            return Unit.INSTANCE;
        L8:
            Integer r9 = DropdownSelectorWidget.s6(this.a);
            if (r9 == null) goto L15;
            if (r9.intValue() != 4) goto L15;
            this.a.r7(Boxing.boxLong(r7.h), "use_template");
            goto L15
        }
    }

    public DropdownSelectorWidget$onBindView$1(DropdownSelectorWidget r1, Continuation<? super DropdownSelectorWidget$onBindView$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new DropdownSelectorWidget$onBindView$1(this.this$0, r3);
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
        DropdownSelectorWidget r6 = this.this$0;
        u1 r2 = DropdownSelectorWidget.q;
        com.larus.bmhome.view.actionbar.edit.c r7 = r6.getViewModel();
        if (r7 == null) goto L18;
        kotlinx.coroutines.flow.d1<com.larus.bmhome.view.actionbar.edit.m> r8 = r7.getInstructionPhotoTemplatePrompt();
        if (r8 == null) goto L18;
        a r3 = new a(this.this$0);
        this.label = 1;
        if (r8.collect(r3, this) != r0) goto L16;
        return r0;
    L18:
        return Unit.INSTANCE;
    }
}
