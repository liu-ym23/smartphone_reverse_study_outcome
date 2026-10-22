package com.larus.bmhome.view.actionbar.edit.kmp;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class KmpInstructionEditorViewFactory$commandDispatcher$2$4 extends FunctionReferenceImpl implements Function0<com.larus.bmhome.instruction.g> {
    public KmpInstructionEditorViewFactory$commandDispatcher$2$4(Object r8) {
        super(0, r8, KmpInstructionEditorViewFactory.class, "instructionInputAbility", "instructionInputAbility()Lcom/larus/bmhome/instruction/IInstructionInputAbility;", 0);
    }

    public final com.larus.bmhome.instruction.g invoke() {
        KmpInstructionEditorViewFactory r0 = (KmpInstructionEditorViewFactory) ((CallableReference) this).receiver;
        int r1 = KmpInstructionEditorViewFactory.p;
        return s1a.d.a(r0.a).getAbility(com.larus.bmhome.instruction.g.class);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m28invoke() {
        return invoke();
    }
}
