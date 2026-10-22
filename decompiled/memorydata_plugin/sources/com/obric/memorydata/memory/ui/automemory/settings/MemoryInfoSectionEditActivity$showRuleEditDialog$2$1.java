package com.obric.memorydata.memory.ui.automemory.settings;

import android.content.Context;
import android.content.DialogInterface;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.plugin.R;
import com.obric.oui.forms.OInputLayout;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.al;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.memory.ui.automemory.settings.MemoryInfoSectionEditActivity$showRuleEditDialog$2$1", f = "MemoryInfoSectionEditActivity.kt", i = {}, l = {460}, m = "invokeSuspend", n = {}, s = {})
final class MemoryInfoSectionEditActivity$showRuleEditDialog$2$1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.BooleanRef $auditing;
    final /* synthetic */ DialogInterface $dialog;
    final /* synthetic */ Integer $editIndex;
    final /* synthetic */ Ref.ObjectRef<TextView> $errorRef;
    final /* synthetic */ Ref.ObjectRef<OInputLayout> $inputRef;
    final /* synthetic */ boolean $isEdit;
    final /* synthetic */ List<String> $items;
    final /* synthetic */ f $state;
    final /* synthetic */ String $text;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MemoryInfoSectionEditActivity this$0;

    MemoryInfoSectionEditActivity$showRuleEditDialog$2$1(Ref.BooleanRef r3, Ref.ObjectRef<TextView> r4, boolean r5, MemoryInfoSectionEditActivity r6, Integer r7, String r8, DialogInterface r9, Ref.ObjectRef<OInputLayout> r10, f r11, List<String> r12, Continuation<? super MemoryInfoSectionEditActivity$showRuleEditDialog$2$1> r13) {
        MemoryInfoSectionEditActivity r14 = (MemoryInfoSectionEditActivity) ZeusTransformUtils.wrapperContextForParams(r6, MemoryInfoSectionEditActivity.class, "com.obric.memorydata.plugin");
        DialogInterface r15 = (DialogInterface) ZeusTransformUtils.wrapperContextForParams(r9, DialogInterface.class, "com.obric.memorydata.plugin");
        List<String> r16 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.memorydata.plugin");
        Continuation r17 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r13, Continuation.class, "com.obric.memorydata.plugin");
        this.$auditing = r3;
        this.$errorRef = r4;
        this.$isEdit = r5;
        this.this$0 = r14;
        this.$editIndex = r7;
        this.$text = r8;
        this.$dialog = r15;
        this.$inputRef = r10;
        this.$state = r11;
        this.$items = r16;
        super(2, r17);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r16, Continuation<?> r17) {
        Continuation r14 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r17, Continuation.class, "com.obric.memorydata.plugin");
        MemoryInfoSectionEditActivity$showRuleEditDialog$2$1 r1 = new MemoryInfoSectionEditActivity$showRuleEditDialog$2$1(this.$auditing, this.$errorRef, this.$isEdit, this.this$0, this.$editIndex, this.$text, this.$dialog, this.$inputRef, this.$state, this.$items, r14);
        r1.L$0 = r16;
        return (Continuation) ZeusTransformUtils.preCheckCast(r1, Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((MemoryInfoSectionEditActivity$showRuleEditDialog$2$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), MemoryInfoSectionEditActivity$showRuleEditDialog$2$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L9;
        if (r1 != 1) goto L8;
        ResultKt.throwOnFailure(r12);     // Catch: Throwable -> L15
    L13:
        Object r13 = Result.m1421constructorimpl((j) ZeusTransformUtils.preCheckCast(r12, j.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L15
    L17:
        MemoryInfoSectionEditActivity r2 = this.this$0;
        Throwable r3 = Result.m1424exceptionOrNullimpl(r13);
        if (r3 == null) goto L21;
        RunLog.INSTANCE.error("MemoryInfoSectionEdit", "audit rule input failed", r3);
        r13 = new j(false, r2.getString(ZeusTransformUtils.mapRes(R.string.memory_info_section_audit_service_failed, TypedValues.Custom.S_STRING, "memory_info_section_audit_service_failed")));
    L21:
        j r14 = (j) ZeusTransformUtils.preCheckCast(r13, j.class, "com.obric.memorydata.plugin");
        this.$auditing.element = false;
        if (r14.a() == true) goto L35;
        TextView r4 = (TextView) ZeusTransformUtils.preCheckCast(this.$errorRef.element, TextView.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L29;
        String r15 = r14.b();
        if (r15 != null) goto L28;
        r15 = "";
    L28:
        r4.setText((CharSequence) ZeusTransformUtils.preCheckCast(r15, CharSequence.class, "com.obric.memorydata.plugin"));
    L29:
        TextView r11 = (TextView) ZeusTransformUtils.preCheckCast(this.$errorRef.element, TextView.class, "com.obric.memorydata.plugin");
        if (r11 == null) goto L33;
        r11.setVisibility(0);
    L33:
        return Unit.INSTANCE;
    L35:
        if (this.$isEdit == false) goto L37;
        MemoryInfoSectionEditViewModel r16 = MemoryInfoSectionEditActivity.access$getViewModel(this.this$0);
        Integer r5 = this.$editIndex;
        Intrinsics.checkNotNull(r5);
        r16.updateItem(r5.intValue(), this.$text);
    L38:
        Toast.makeText((Context) ZeusTransformUtils.preCheckCast(this.this$0, Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.string.memory_info_section_add_success, TypedValues.Custom.S_STRING, "memory_info_section_add_success"), 0).show();
        MemoryInfoSectionEditActivity r17 = this.this$0;
        DialogInterface r6 = this.$dialog;
        Intrinsics.checkNotNull(r6);
        MemoryInfoSectionEditActivity.access$dismissWithKeyboardHidden(r17, r6, (OInputLayout) ZeusTransformUtils.preCheckCast(this.$inputRef.element, OInputLayout.class, "com.obric.memorydata.plugin"));
        return Unit.INSTANCE;
    L37:
        MemoryInfoSectionEditActivity.access$getViewModel(this.this$0).addItem(this.$text);
        goto L38
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r12);
        al r18 = (al) ZeusTransformUtils.preCheckCast(this.L$0, al.class, "com.obric.memorydata.plugin");
        MemoryInfoSectionEditActivity r7 = this.this$0;
        f r19 = this.$state;
        List<String> r8 = this.$items;
        Integer r9 = this.$editIndex;
        String r10 = this.$text;
        Result.Companion r20 = Result.Companion;     // Catch: Throwable -> L15
        String r21 = r19.a();     // Catch: Throwable -> L15
        e r22 = r19.b();     // Catch: Throwable -> L15
        this.label = 1;     // Catch: Throwable -> L15
        r12 = MemoryInfoSectionEditActivity.access$auditRuleInput(r7, r21, r22, r8, r9, r10, this);     // Catch: Throwable -> L15
        if (r12 != r0) goto L13;
        return r0;
    L15:
        th = move-exception;
        Result.Companion r23 = Result.Companion;
        r13 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L17
    }
}
