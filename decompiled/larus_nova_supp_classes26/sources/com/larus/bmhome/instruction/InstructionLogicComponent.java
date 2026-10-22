package com.larus.bmhome.instruction;

import androidx.lifecycle.ViewModelProvider;
import com.larus.bmhome.view.actionbar.edit.InstructionEditorViewModel;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0005\u0018\u00002\u00060\u0001j\u0002`\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016JB\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u000e\u0010\u001a\u001a\n\u0018\u00010\u001bj\u0004\u0018\u0001`\u001c2\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u001eH\u0016J\u0018\u0010\u001f\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u0013H\u0016J\"\u0010!\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u00112\u0006\u0010#\u001a\u00020$H\u0016J&\u0010%\u001a\u00020\u000f2\u0014\u0010&\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0013\u0018\u00010'2\u0006\u0010(\u001a\u00020\u0013H\u0016J\u0010\u0010)\u001a\u00020\u000f2\u0006\u0010(\u001a\u00020\u0013H\u0016J\n\u0010*\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010+\u001a\u00020\u0007H\u0016R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/larus/bmhome/instruction/InstructionLogicComponent;", "Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;", "Lcom/larus/ui/arch/component/external/Component;", "Lcom/larus/bmhome/instruction/IInstructionLogicAbility;", "<init>", "()V", "_instructionCoreAbility", "Lcom/larus/bmhome/instruction/IInstructionCoreHandler;", "get_instructionCoreAbility", "()Lcom/larus/bmhome/instruction/IInstructionCoreHandler;", "_instructionCoreAbility$delegate", "Lkotlin/Lazy;", "instructionEditorViewModel", "Lcom/larus/bmhome/view/actionbar/edit/InstructionEditorViewModel;", "onAttach", "", "getCustomActionBarItem", "Lcom/larus/bmhome/actionbar/model/CustomActionBarItem;", "botId", "", "onActionBarInstructionChanged", "actionBarItem", "instructionDefaultStateConf", "Lcom/larus/bmhome/actionbar/model/ActionBarInstructionConf;", "openFrom", "", "instructionExtraData", "Lcom/larus/bmhome/instruction/core/model/InstructionExtraData;", "Lcom/larus/bmhome/instruction/InstructionExtraData;", "onInstructionCallback", "Lkotlin/Function0;", "updateConversationId", "conversationId", "handleOpenSchema", "schemaUrl", "bundle", "Landroid/os/Bundle;", "setMessageExtMap", "messageExtMap", "", "tag", "tryClearMsgExtMap", "getMsgExtJsonString", "getInstructionCoreHandler", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InstructionLogicComponent extends ComponentFeature implements h {
    public final Lazy h;
    public InstructionEditorViewModel i;

    @Override // com.larus.bmhome.instruction.h
    public final f EI() {
        return (f) this.h.getValue();
    }

    @Override // com.larus.bmhome.instruction.h
    public final String S20() {
        InstructionEditorViewModel r0 = this.i;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getMessageExtMapJsonString();
    }

    public final void y2() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        this.i = (InstructionEditorViewModel) new ViewModelProvider(com.larus.ui.arch.component.internal.attach.a.b(this, this)).get(InstructionEditorViewModel.class);
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, h.class);
        ((f) this.h.getValue()).onAttach();
    }

    public InstructionLogicComponent() {
        this.h = LazyKt.lazy(new x1(this));
    }

    @Override // com.larus.bmhome.instruction.h
    public final com.larus.bmhome.actionbar.model.z0 Kp(String r2) {
        Intrinsics.checkNotNullParameter(r2, "botId");
        InstructionEditorViewModel r0 = this.i;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getCustomActionBarItem(r2);
    }

    @Override // com.larus.bmhome.instruction.h
    public final void nT(String r3) {
        Intrinsics.checkNotNullParameter(r3, "tag");
        InstructionEditorViewModel r0 = this.i;
        if (r0 == null) goto L10;
        Integer r1 = r0.getInstructionType();
        if (r1 == null) goto L10;
        if (r1.intValue() != 0) goto L10;
        boolean r2 = true;
    L12:
        if (r2 == true) goto L18;
        InstructionEditorViewModel r4 = this.i;
        if (r4 == null) goto L16;
        Integer r5 = r4.getInstructionType();
    L17:
        if (r5 == null) goto L18;
        return;
    L16:
        r5 = null;
    L18:
        InstructionEditorViewModel r6 = this.i;
        if (r6 == null) goto L23;
        r6.setMsgExtMap(null, r3);
        return;
    L23:
        return;
    L10:
        r2 = false;
        goto L12
    }

    @Override // com.larus.bmhome.instruction.h
    public final void qz(Map<String, String> r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "tag");
        InstructionEditorViewModel r0 = this.i;
        if (r0 == null) goto L6;
        r0.setMsgExtMap(r2, r3);
        return;
    }

    @Override // com.larus.bmhome.instruction.h
    public final void updateConversationId(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "botId");
        Intrinsics.checkNotNullParameter(r3, "conversationId");
        InstructionEditorViewModel r0 = this.i;
        if (r0 == null) goto L6;
        r0.updateConversationId(r2, r3);
        return;
    }

    @Override // com.larus.bmhome.instruction.h
    public final void h50(com.larus.bmhome.actionbar.model.z0 r10, int r11, aq8.e r12, Function0 r13) {
        Intrinsics.checkNotNullParameter(r10, "actionBarItem");
        InstructionEditorViewModel r0 = this.i;
        if (r0 == null) goto L6;
        com.larus.bmhome.view.actionbar.edit.c.a.a(r0, r10, null, r11, null, r12, null, r13, 40);
        return;
    }
}
