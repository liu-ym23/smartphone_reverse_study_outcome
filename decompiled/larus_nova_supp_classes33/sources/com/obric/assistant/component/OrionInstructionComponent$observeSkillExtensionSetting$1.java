package com.obric.assistant.component;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.component.OrionInstructionComponent$observeSkillExtensionSetting$1", f = "OrionInstructionComponent.kt", i = {}, l = {412}, m = "invokeSuspend", n = {}, s = {})
final class OrionInstructionComponent$observeSkillExtensionSetting$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ OrionInstructionComponent this$0;

    /* JADX INFO: renamed from: com.obric.assistant.component.OrionInstructionComponent$observeSkillExtensionSetting$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "state", "Lcom/obric/assistant/special_input/SkillExtensionSettingState;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.component.OrionInstructionComponent$observeSkillExtensionSetting$1$1", f = "OrionInstructionComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<com.obric.assistant.special_input.t0, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ OrionInstructionComponent this$0;

        public AnonymousClass1(OrionInstructionComponent r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            AnonymousClass1 r0 = new AnonymousClass1(this.this$0, r4);
            r0.L$0 = r3;
            return r0;
        }

        public final Object invoke(com.obric.assistant.special_input.t0 r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((com.obric.assistant.special_input.t0) r1, (Continuation) r2);
        }

        public final Object invokeSuspend(Object r4) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L16;
            ResultKt.throwOnFailure(r4);
            com.obric.assistant.special_input.t0 r5 = (com.obric.assistant.special_input.t0) this.L$0;
            OrionInstructionComponent r0 = this.this$0;
            Boolean r1 = r0.b1;
            Integer r2 = r0.g1;
            if (Intrinsics.areEqual(r1, Boxing.boxBoolean(r5.a)) == false) goto L13;
            int r3 = r5.e;
            if (r2 == null) goto L13;
            if (r2.intValue() != r3) goto L13;
            return Unit.INSTANCE;
        L13:
            OrionInstructionComponent r6 = this.this$0;
            r6.b1 = Boxing.boxBoolean(r5.a);
            OrionInstructionComponent r7 = this.this$0;
            r7.g1 = Boxing.boxInt(r5.e);
            this.this$0.v4("skill_extension_switch_changed");
            return Unit.INSTANCE;
        L16:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public OrionInstructionComponent$observeSkillExtensionSetting$1(OrionInstructionComponent r1, Continuation<? super OrionInstructionComponent$observeSkillExtensionSetting$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new OrionInstructionComponent$observeSkillExtensionSetting$1(this.this$0, r3);
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
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        kotlinx.coroutines.flow.b1 r7 = com.obric.assistant.special_input.j.a;
        AnonymousClass1 r2 = new AnonymousClass1(this.this$0, null);
        this.label = 1;
        if (kotlinx.coroutines.flow.e.i(r7, r2, this) != r0) goto L12;
        return r0;
    }
}
