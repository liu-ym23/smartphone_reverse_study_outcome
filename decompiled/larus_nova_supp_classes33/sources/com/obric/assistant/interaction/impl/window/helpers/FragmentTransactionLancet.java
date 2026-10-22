package com.obric.assistant.interaction.impl.window.helpers;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import me.ele.lancet.base.Origin;
import me.ele.lancet.base.This;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public class FragmentTransactionLancet {
    private static final int NO_CONTAINER_VIEW_ID = 0;

    public FragmentTransactionLancet() {
    }

    public FragmentTransaction add(int r4, Fragment r5) {
        Object r0 = This.get();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r0, r5, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, null, r4) == false) goto L7;
        return (FragmentTransaction) r0;
    L7:
        return (FragmentTransaction) Origin.call();
    }

    public FragmentTransaction replace(int r4, Fragment r5) {
        Object r0 = This.get();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r0, r5, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, r4) == false) goto L7;
        return (FragmentTransaction) r0;
    L7:
        return (FragmentTransaction) Origin.call();
    }

    public FragmentTransaction add(Fragment r4, String r5) {
        Object r0 = This.get();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r0, r4, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, r5, 0) == false) goto L7;
        return (FragmentTransaction) r0;
    L7:
        return (FragmentTransaction) Origin.call();
    }

    public FragmentTransaction add(int r3, Fragment r4, String r5) {
        Object r0 = This.get();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r0, r4, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, r5, r3) == false) goto L7;
        return (FragmentTransaction) r0;
    L7:
        return (FragmentTransaction) Origin.call();
    }

    public FragmentTransaction replace(int r3, Fragment r4, String r5) {
        Object r0 = This.get();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r0, r4, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, r5, r3) == false) goto L7;
        return (FragmentTransaction) r0;
    L7:
        return (FragmentTransaction) Origin.call();
    }
}
