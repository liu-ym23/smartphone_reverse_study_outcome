package com.larus.dora.obric.device_management.setting.earbuds.broadcast;

import android.text.Editable;
import androidx.core.os.BundleKt;
import androidx.fragment.app.FragmentManager;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.obric.oui.forms.OEditText;
import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class k<T> implements FlowCollector {
    public final /* synthetic */ DoraObricEarbudsAddRuleInputSheet a;

    public k(DoraObricEarbudsAddRuleInputSheet r1) {
        this.a = r1;
    }

    public final Object emit(Object r6, Continuation r7) {
        List r8 = (List) r6;
        DoraObricEarbudsAddRuleInputSheet r9 = this.a;
        int r0 = DoraObricEarbudsAddRuleInputSheet.i;
        if (r9.U90() == null) goto L5;
        boolean r10 = true;
    L6:
        if (r10 == true) goto L23;
        List r11 = r8;
        if ((!r11.isEmpty()) == false) goto L23;
        OEditText r2 = this.a.e;
        if (r2 == null) goto L14;
        Editable r3 = r2.getText();
        if (r3 == null) goto L14;
        String r4 = r3.toString();
    L15:
        if (r4 != null) goto L17;
        r4 = "";
    L17:
        int r5 = DoraObricEarbudsConfirmRulesSheet.g;
        Intrinsics.checkNotNullParameter(r4, "originalDesc");
        Intrinsics.checkNotNullParameter(r8, "generatedRules");
        DoraObricEarbudsConfirmRulesSheet r12 = new DoraObricEarbudsConfirmRulesSheet();
        r12.setArguments(BundleKt.bundleOf(new Pair[]{TuplesKt.to("arg_original_desc", r4), TuplesKt.to("arg_generated_rules", new ArrayList(r11))}));
        FragmentManager r13 = this.a.getParentFragmentManager();
        LandscapeRestrictionOperation r1 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r12, "DoraObricEarbudsConfirmRulesSheet", r1);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r13, r12, r1) == true) goto L23;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L24
    L21:
        r12.show(r13, "DoraObricEarbudsConfirmRulesSheet");
    L14:
        r4 = null;
    L23:
        return Unit.INSTANCE;
    L5:
        r10 = false;
        goto L6
    }
}
