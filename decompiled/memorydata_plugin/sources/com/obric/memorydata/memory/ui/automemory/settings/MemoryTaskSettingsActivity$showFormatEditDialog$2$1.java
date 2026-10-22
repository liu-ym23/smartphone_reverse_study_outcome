package com.obric.memorydata.memory.ui.automemory.settings;

import android.content.DialogInterface;
import android.widget.TextView;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.al;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.memory.ui.automemory.settings.MemoryTaskSettingsActivity$showFormatEditDialog$2$1", f = "MemoryTaskSettingsActivity.kt", i = {}, l = {545}, m = "invokeSuspend", n = {}, s = {})
final class MemoryTaskSettingsActivity$showFormatEditDialog$2$1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.BooleanRef $auditing;
    final /* synthetic */ DialogInterface $dialog;
    final /* synthetic */ Ref.ObjectRef<TextView> $errorRef;
    final /* synthetic */ boolean $isTitle;
    final /* synthetic */ int $kind;
    final /* synthetic */ String $sectionTitle;
    final /* synthetic */ Ref.ObjectRef<Function1<Boolean, Unit>> $setInputErrorState;
    final /* synthetic */ String $text;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MemoryTaskSettingsActivity this$0;

    MemoryTaskSettingsActivity$showFormatEditDialog$2$1(Ref.BooleanRef r3, Ref.ObjectRef<TextView> r4, MemoryTaskSettingsActivity r5, Ref.ObjectRef<Function1<Boolean, Unit>> r6, int r7, String r8, DialogInterface r9, boolean r10, String r11, Continuation<? super MemoryTaskSettingsActivity$showFormatEditDialog$2$1> r12) {
        MemoryTaskSettingsActivity r13 = (MemoryTaskSettingsActivity) ZeusTransformUtils.wrapperContextForParams(r5, MemoryTaskSettingsActivity.class, "com.obric.memorydata.plugin");
        DialogInterface r14 = (DialogInterface) ZeusTransformUtils.wrapperContextForParams(r9, DialogInterface.class, "com.obric.memorydata.plugin");
        Continuation r15 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r12, Continuation.class, "com.obric.memorydata.plugin");
        this.$auditing = r3;
        this.$errorRef = r4;
        this.this$0 = r13;
        this.$setInputErrorState = r6;
        this.$kind = r7;
        this.$text = r8;
        this.$dialog = r14;
        this.$isTitle = r10;
        this.$sectionTitle = r11;
        super(2, r15);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r14, Continuation<?> r15) {
        Continuation r12 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r15, Continuation.class, "com.obric.memorydata.plugin");
        MemoryTaskSettingsActivity$showFormatEditDialog$2$1 r16 = new MemoryTaskSettingsActivity$showFormatEditDialog$2$1(this.$auditing, this.$errorRef, this.this$0, this.$setInputErrorState, this.$kind, this.$text, this.$dialog, this.$isTitle, this.$sectionTitle, r12);
        r16.L$0 = r14;
        return (Continuation) ZeusTransformUtils.preCheckCast(r16, Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((MemoryTaskSettingsActivity$showFormatEditDialog$2$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), MemoryTaskSettingsActivity$showFormatEditDialog$2$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r9) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L9;
        if (r1 != 1) goto L8;
        ResultKt.throwOnFailure(r9);     // Catch: Throwable -> L19
    L17:
        Object r10 = Result.m1421constructorimpl((FormatAuditResult) ZeusTransformUtils.preCheckCast(r9, FormatAuditResult.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L19
    L21:
        Throwable r2 = Result.m1424exceptionOrNullimpl(r10);
        if (r2 == null) goto L25;
        RunLog.INSTANCE.error("MemoryTaskSettings", "audit format input failed", r2);
        r10 = FormatAuditResult.SERVICE_FAILED;
    L25:
        FormatAuditResult r11 = (FormatAuditResult) ZeusTransformUtils.preCheckCast(r10, FormatAuditResult.class, "com.obric.memorydata.plugin");
        this.$auditing.element = false;
        if (r11 == FormatAuditResult.PASSED) goto L38;
        TextView r3 = (TextView) ZeusTransformUtils.preCheckCast(this.$errorRef.element, TextView.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L30;
        MemoryTaskSettingsActivity r4 = this.this$0;
        r3.setText((CharSequence) ZeusTransformUtils.preCheckCast(r4.getString(MemoryTaskSettingsActivity.access$formatAuditMessageRes(r4, r11)), CharSequence.class, "com.obric.memorydata.plugin"));
    L30:
        TextView r12 = (TextView) ZeusTransformUtils.preCheckCast(this.$errorRef.element, TextView.class, "com.obric.memorydata.plugin");
        if (r12 == null) goto L33;
        r12.setVisibility(0);
    L33:
        Function1 r8 = (Function1) ZeusTransformUtils.preCheckCast(this.$setInputErrorState.element, Function1.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L37;
        r8.invoke(Boxing.boxBoolean(true));
    L37:
        return Unit.INSTANCE;
    L38:
        MemoryTaskSettingsActivity.access$applyDialogResult(this.this$0, this.$kind, this.$text);
        this.$dialog.dismiss();
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r9);
        al r13 = (al) ZeusTransformUtils.preCheckCast(this.L$0, al.class, "com.obric.memorydata.plugin");
        MemoryTaskSettingsActivity r14 = this.this$0;
        boolean r5 = this.$isTitle;
        String r6 = this.$sectionTitle;
        String r7 = this.$text;
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L19
        MemoryTaskSettingsViewModel r16 = MemoryTaskSettingsActivity.access$getViewModel(r14);     // Catch: Throwable -> L19
        if (r5 == false) goto L13;
        boolean r17 = true;
    L14:
        this.label = 1;     // Catch: Throwable -> L19
        r9 = r16.auditFormatInput(r17, r6, r7, this);     // Catch: Throwable -> L19
        if (r9 != r0) goto L17;
        return r0;
    L13:
        r17 = false;
    L19:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r10 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L21
    }
}
