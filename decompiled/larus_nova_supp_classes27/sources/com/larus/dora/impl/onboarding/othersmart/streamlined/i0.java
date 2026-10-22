package com.larus.dora.impl.onboarding.othersmart.streamlined;

import android.os.Bundle;
import androidx.fragment.app.FragmentTransaction;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class i0<T> implements FlowCollector {
    public final /* synthetic */ DoraHStreamlinedWakeupFragment a;

    public i0(DoraHStreamlinedWakeupFragment r1) {
        this.a = r1;
    }

    public final Object emit(Object r6, Continuation r7) {
        boolean r8 = ((Boolean) r6).booleanValue();
        DoraHStreamlinedWakeupFragment r9 = this.a;
        int r0 = DoraHStreamlinedWakeupFragment.F;
        r9.getClass();
        float r1 = DoraHStreamlinedInterruptFragment.z;
        String r2 = r9.getTag();
        DoraHStreamlinedInterruptFragment r3 = new DoraHStreamlinedInterruptFragment();
        Bundle r4 = new Bundle();
        r4.putBoolean("arg_is_from_skip", !r8);
        r4.putString("arg_previous_fragment_tag", r2);
        r4.putBoolean("arg_use_shared_element_transition", false);
        r3.setArguments(r4);
        r9.E = true;
        if (r9.isAdded() == true) goto L5;
    L12:
        g49.d.e("DoraHStreamlinedWakeupFragment", "current fragment is not added or statedSaved, cannot navigate to interrupt overlay");
    L14:
        return Unit.INSTANCE;
    L5:
        if (r9.isStateSaved() == true) goto L12;
        FragmentTransaction r10 = r9.getParentFragmentManager().beginTransaction().setReorderingAllowed(true);
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r10, r3, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, "DoraHStreamlinedInterruptFragment", 2131373275) == true) goto L11;
        r10 = r10.add(2131373275, r3, "DoraHStreamlinedInterruptFragment");
    L11:
        r10.commitAllowingStateLoss();
        goto L14
    }
}
