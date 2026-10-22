package com.larus.bmhome.view.actionbar.edit.kmp;

import aq8.c$a;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class KmpInstructionEditorViewFactory$commandDispatcher$2$1 extends FunctionReferenceImpl implements Function0<Unit> {
    public KmpInstructionEditorViewFactory$commandDispatcher$2$1(Object r8) {
        super(0, r8, KmpInstructionEditorViewFactory.class, "closeInstructionPanelAndEditor", "closeInstructionPanelAndEditor()V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m26invoke() {
        KmpInstructionEditorViewFactory r0 = (KmpInstructionEditorViewFactory) ((CallableReference) this).receiver;
        int r1 = KmpInstructionEditorViewFactory.p;
        ICoreInputAbility r2 = s1a.d.a(r0.a).getAbility(ICoreInputAbility.class);
        if (r2 == null) goto L5;
        ICoreInputAbility.b.a(r2, 2);
    L5:
        r0.q().ki(new c$a(r0.c));
        com.larus.bmhome.instruction.g r3 = s1a.d.a(r0.a).getAbility(com.larus.bmhome.instruction.g.class);
        if (r3 == null) goto L9;
        r3.A1();
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m26invoke();
        return Unit.INSTANCE;
    }
}
