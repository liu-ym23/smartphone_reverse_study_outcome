package com.larus.bmhome.view.actionbar.edit.kmp;

import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class KmpInstructionEditorViewFactory$commandDispatcher$2$5 extends FunctionReferenceImpl implements Function0<ICoreInputAbility> {
    public KmpInstructionEditorViewFactory$commandDispatcher$2$5(Object r8) {
        super(0, r8, KmpInstructionEditorViewFactory.class, "coreInputAbility", "coreInputAbility()Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", 0);
    }

    public final ICoreInputAbility invoke() {
        KmpInstructionEditorViewFactory r0 = (KmpInstructionEditorViewFactory) ((CallableReference) this).receiver;
        int r1 = KmpInstructionEditorViewFactory.p;
        return s1a.d.a(r0.a).getAbility(ICoreInputAbility.class);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m29invoke() {
        return invoke();
    }
}
