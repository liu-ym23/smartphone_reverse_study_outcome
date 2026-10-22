package com.obric.aiproactive.ui.preference;

import com.obric.aiproactive.api.AiRuleItemDto;
import com.obric.aiproactive.api.IProactiveService;
import com.obric.oui.forms.OInputLayout;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.al;
import kotlinx.coroutines.ba;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.aiproactive.ui.preference.AiRuleActivity$showEditDialog$2$1", f = "AiRuleActivity.kt", i = {}, l = {378}, m = "invokeSuspend", n = {}, s = {})
final class AiRuleActivity$showEditDialog$2$1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.obric.oui.dialog.v2.alert.a $dialog;
    final /* synthetic */ OInputLayout $inputLayout;
    final /* synthetic */ boolean $isAiGenerated;
    final /* synthetic */ String $newContent;
    final /* synthetic */ AiRuleItemDto $rule;
    int label;
    final /* synthetic */ AiRuleActivity this$0;

    /* JADX INFO: renamed from: com.obric.aiproactive.ui.preference.AiRuleActivity$showEditDialog$2$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/obric/aiproactive/api/AiRuleItemDto;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.aiproactive.ui.preference.AiRuleActivity$showEditDialog$2$1$1", f = "AiRuleActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<al, Continuation<? super AiRuleItemDto>, Object> {
        final /* synthetic */ boolean $isAiGenerated;
        final /* synthetic */ String $newContent;
        final /* synthetic */ AiRuleItemDto $rule;
        int label;
        final /* synthetic */ AiRuleActivity this$0;

        AnonymousClass1(AiRuleActivity r3, AiRuleItemDto r4, String r5, boolean r6, Continuation<? super AnonymousClass1> r7) {
            AiRuleActivity r8 = (AiRuleActivity) ZeusTransformUtils.wrapperContextForParams(r3, AiRuleActivity.class, "com.obric.memorydata.plugin");
            Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r8;
            this.$rule = r4;
            this.$newContent = r5;
            this.$isAiGenerated = r6;
            super(2, r9);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r9, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.this$0, this.$rule, this.$newContent, this.$isAiGenerated, r6), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super AiRuleItemDto> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super AiRuleItemDto> r4) {
            return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r4) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L14;
            ResultKt.throwOnFailure(r4);
            IProactiveService r5 = AiRuleActivity.access$getProactiveService(this.this$0);
            if (r5 == null) goto L11;
            String r0 = this.$rule.getId();
            String r1 = this.$newContent;
            if (this.$isAiGenerated == false) goto L9;
            AiRuleItemDto.RuleType r3 = AiRuleItemDto.RuleType.CUSTOM;
        L15:
            return r5.updateAiRule(r0, r1, r3);
        L9:
            r3 = this.$rule.getType();
            goto L15
        L11:
            return null;
        L14:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.obric.aiproactive.ui.preference.AiRuleActivity$showEditDialog$2$1$2, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function0<Unit> {
        AnonymousClass2(Object r8) {
            super(0, r8, AiRuleActivity.class, "loadData", "loadData()V", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            AiRuleActivity.access$loadData((AiRuleActivity) ZeusTransformUtils.preCheckCast(this.receiver, AiRuleActivity.class, "com.obric.memorydata.plugin"));
        }
    }

    AiRuleActivity$showEditDialog$2$1(AiRuleActivity r3, com.obric.oui.dialog.v2.alert.a r4, OInputLayout r5, AiRuleItemDto r6, String r7, boolean r8, Continuation<? super AiRuleActivity$showEditDialog$2$1> r9) {
        AiRuleActivity r10 = (AiRuleActivity) ZeusTransformUtils.wrapperContextForParams(r3, AiRuleActivity.class, "com.obric.memorydata.plugin");
        Continuation r11 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r9, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r10;
        this.$dialog = r4;
        this.$inputLayout = r5;
        this.$rule = r6;
        this.$newContent = r7;
        this.$isAiGenerated = r8;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r11, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new AiRuleActivity$showEditDialog$2$1(this.this$0, this.$dialog, this.$inputLayout, this.$rule, this.$newContent, this.$isAiGenerated, r8), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((AiRuleActivity$showEditDialog$2$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AiRuleActivity$showEditDialog$2$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r11);
    L11:
        AiRuleActivity r12 = this.this$0;
        com.obric.oui.dialog.v2.alert.a r2 = this.$dialog;
        OInputLayout r3 = this.$inputLayout;
        Intrinsics.checkNotNull(r3);
        AiRuleActivity.access$performRuleEditorCloseActions(r12, r2, r3, a.b(), (Function0) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this.this$0), Function0.class, "com.obric.memorydata.plugin"));
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r11);
        CoroutineContext r13 = (CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin");
        Function2 r4 = (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.this$0, this.$rule, this.$newContent, this.$isAiGenerated, null), Function2.class, "com.obric.memorydata.plugin");
        Continuation r5 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 1;
        if (kotlinx.coroutines.i.a(r13, r4, r5) != r0) goto L11;
        return r0;
    }
}
