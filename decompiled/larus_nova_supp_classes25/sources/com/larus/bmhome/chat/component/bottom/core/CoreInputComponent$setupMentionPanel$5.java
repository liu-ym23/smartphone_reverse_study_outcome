package com.larus.bmhome.chat.component.bottom.core;

import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.input.impl.databinding.LarusWidgetInputBinding;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import oaa.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public /* synthetic */ class CoreInputComponent$setupMentionPanel$5 extends FunctionReferenceImpl implements Function1<Boolean, Unit> {
    public CoreInputComponent$setupMentionPanel$5(Object r8) {
        super(1, r8, CoreInputComponent.class, "updateTaskSkillPanelVisibility", "updateTaskSkillPanelVisibility(Z)V", 0);
    }

    public final void invoke(boolean r5) {
        CoreInputComponent r0 = (CoreInputComponent) ((CallableReference) this).receiver;
        boolean r1 = false;
        if (r5 == true) goto L5;
    L13:
        r0.v1 = r5;
        a r2 = r0.v4();
        if (r2 == null) goto L16;
        r2.U3(r5);
    L16:
        com.larus.bmhome.chat.component.bottom.attachment.g1 r3 = r0.l4().f70();
        if (r3 == null) goto L19;
        r3.Mi(r5);
    L19:
        if (r5 == false) goto L23;
        com.larus.bmhome.instruction.g r4 = r0.vc();
        if (r4 == null) goto L33;
        r4.p00();
    L33:
        if (s1a.a.e(r0) == false) goto L41;
        a r6 = r0.v4();
        if (r6 == null) goto L43;
        LarusWidgetInputBinding r7 = r0.W;
        if (r7 == null) goto L39;
        FrameLayout r8 = r7.A;
    L40:
        r6.yo(r5, r8);
        return;
    L39:
        r8 = null;
        goto L40
    L43:
        return;
    L41:
        r0.W6();
        return;
    L23:
        com.larus.bmhome.instruction.g r9 = r0.vc();
        if (r9 != null) goto L26;
    L28:
        if (r1 == false) goto L33;
        com.larus.bmhome.instruction.g r10 = r0.vc();
        if (r10 == null) goto L33;
        r10.LW();
        goto L33
    L26:
        if (r9.rA() != true) goto L28;
        r1 = true;
        goto L28
    L5:
        if (r0.v1 == true) goto L13;
        LarusWidgetInputBinding r11 = r0.W;
        if (r11 == null) goto L11;
        ConstraintLayout r12 = r11.I;
        if (r12 == null) goto L11;
        int r13 = r12.getPaddingTop();
    L12:
        r0.R = r13;
    L11:
        r13 = 0;
        goto L12
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke(((Boolean) r1).booleanValue());
        return Unit.INSTANCE;
    }
}
