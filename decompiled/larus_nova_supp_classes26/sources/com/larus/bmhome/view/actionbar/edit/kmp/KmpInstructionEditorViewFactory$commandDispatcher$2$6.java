package com.larus.bmhome.view.actionbar.edit.kmp;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class KmpInstructionEditorViewFactory$commandDispatcher$2$6 extends FunctionReferenceImpl implements Function0<va8.o> {
    public KmpInstructionEditorViewFactory$commandDispatcher$2$6(Object r8) {
        super(0, r8, KmpInstructionEditorViewFactory.class, "chatInputUICoreAbility", "chatInputUICoreAbility()Lcom/larus/bmhome/ability/IChatInputUICoreAbility;", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final va8.o m30invoke() {
        return s1a.d.a(((KmpInstructionEditorViewFactory) ((CallableReference) this).receiver).a).getAbility(va8.o.class);
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return m30invoke();
    }
}
