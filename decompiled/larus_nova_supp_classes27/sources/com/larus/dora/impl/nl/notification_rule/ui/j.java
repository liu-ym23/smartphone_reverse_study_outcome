package com.larus.dora.impl.nl.notification_rule.ui;

import android.os.Bundle;
import android.text.Editable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.fragment.app.FragmentTransaction;
import com.larus.bmhome.utils.x1;
import com.larus.dora.impl.databinding.LarusDoraFragmentAddRuleInputBinding;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class j<T> implements FlowCollector {
    public final /* synthetic */ AddRuleInputFragment a;

    public j(AddRuleInputFragment r1) {
        this.a = r1;
    }

    public final Object emit(Object r7, Continuation r8) {
        List r9 = (List) r7;
        List r10 = r9;
        if ((!r10.isEmpty()) == false) goto L27;
        x1 r0 = this.a.f;
        if (r0 == null) goto L7;
        r0.a(true);
    L7:
        LarusDoraFragmentAddRuleInputBinding r1 = this.a.d;
        if (r1 == null) goto L15;
        AppCompatEditText r2 = r1.i;
        if (r2 == null) goto L15;
        Editable r3 = r2.getText();
        if (r3 == null) goto L15;
        String r4 = r3.toString();
        if (r4 == null) goto L15;
    L16:
        NotificationRuleBottomSheet r5 = this.a.getParentFragment();
        if ((r5 instanceof NotificationRuleBottomSheet) == false) goto L19;
        NotificationRuleBottomSheet r6 = r5;
    L20:
        if (r6 == null) goto L27;
        Intrinsics.checkNotNullParameter(r4, "userInput");
        Intrinsics.checkNotNullParameter(r9, "clarifiedDesc");
        int r11 = AddRuleClarificationFragment.h;
        Intrinsics.checkNotNullParameter(r4, "userInput");
        Intrinsics.checkNotNullParameter(r9, "clarifiedDesc");
        AddRuleClarificationFragment r12 = new AddRuleClarificationFragment();
        Bundle r13 = new Bundle();
        r13.putString("user_input", r4);
        r13.putStringArrayList("clarified_desc", new ArrayList(r10));
        r12.setArguments(r13);
        FragmentTransaction r14 = r6.getChildFragmentManager().beginTransaction();
        int r15 = NotificationRuleBottomSheet.f;
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r14, r12, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, 2131367728) == true) goto L25;
        r14 = r14.replace(2131367728, r12);
    L25:
        r14.addToBackStack(null).commit();
        goto L27
    L19:
        r6 = null;
    L15:
        r4 = "";
    L27:
        return Unit.INSTANCE;
    }
}
