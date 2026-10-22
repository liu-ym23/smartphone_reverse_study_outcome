package com.larus.bmhome.view.actionbar.edit;

import com.larus.bmhome.actionbar.model.e2;
import com.larus.bmhome.actionbar.model.r;
import com.larus.bmhome.actionbar.model.y;
import com.larus.uaigc.service.ICreationAvatarService;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\n"}, d2 = {"<anonymous>", "", "position", "", "avatarChosen", "<unused var>", "Lcom/larus/bmhome/view/actionbar/edit/SelectedModelInfo;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.view.actionbar.edit.InstructionEditorViewModel$jumpToCompleteVideoAvatarEvent$1", f = "InstructionEditorViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class InstructionEditorViewModel$jumpToCompleteVideoAvatarEvent$1 extends SuspendLambda implements Function5<Integer, Boolean, p, p, Continuation<? super Boolean>, Object> {
    /* synthetic */ int I$0;
    /* synthetic */ boolean Z$0;
    int label;
    final /* synthetic */ InstructionEditorViewModel this$0;

    public InstructionEditorViewModel$jumpToCompleteVideoAvatarEvent$1(InstructionEditorViewModel r1, Continuation<? super InstructionEditorViewModel$jumpToCompleteVideoAvatarEvent$1> r2) {
        this.this$0 = r1;
        super(5, r2);
    }

    public final Object invoke(int r1, boolean r2, p r3, p r4, Continuation<? super Boolean> r5) {
        InstructionEditorViewModel$jumpToCompleteVideoAvatarEvent$1 r6 = new InstructionEditorViewModel$jumpToCompleteVideoAvatarEvent$1(this.this$0, r5);
        r6.I$0 = r1;
        r6.Z$0 = r2;
        return r6.invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r7, Object r8, Object r9, Object r10, Object r11) {
        return invoke(((Number) r7).intValue(), ((Boolean) r8).booleanValue(), (p) r9, (p) r10, (Continuation) r11);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L33;
        ResultKt.throwOnFailure(r5);
        int r6 = this.I$0;
        boolean r0 = this.Z$0;
        FLogger.a.d("InstructionEditorViewModel", "trigger jumpToCompleteVideoAvatarEvent position = " + r6 + " avatarChosen = " + r0);
        InstructionEditorViewModel r7 = this.this$0;
        boolean r8 = InstructionEditorViewModel.access$selectedVideoMenu(r7, ((Number) r7.getInstructionSelectMenuPosition().getValue()).intValue());
        r r1 = this.this$0.getCurrentInstructionConf();
        if (r1 == null) goto L13;
        y r2 = r1.i;
        if (r2 == null) goto L13;
        Long r3 = this.this$0.getSelectedVideoModelId();
        if (r3 == null) goto L11;
        long r4 = r3.longValue();
    L12:
        e2 r9 = r2.d(r4);
    L14:
        boolean r10 = false;
        if (r8 == false) goto L31;
        if (r0 == false) goto L31;
        if (ICreationAvatarService.a.U() == false) goto L31;
        if (r9 == null) goto L27;
        Integer r11 = r9.e;
        if (r11 == null) goto L27;
        if (r11.intValue() != 1) goto L27;
        boolean r12 = true;
    L28:
        if (r12 == false) goto L31;
        r10 = true;
    L27:
        r12 = false;
    L31:
        return Boxing.boxBoolean(r10);
    L11:
        r4 = 0;
    L13:
        r9 = null;
        goto L14
    L33:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
