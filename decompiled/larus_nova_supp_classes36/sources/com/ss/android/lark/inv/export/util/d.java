package com.ss.android.lark.inv.export.util;

import android.R;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.base.fragment.BaseFragment;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d {
    public static void a(FragmentActivity r3, BaseFragment r4) {
        if (r3 != null) goto L6;
        Log.e("FragmentUtils", "activity is null");
        return;
    L6:
        FragmentManager r5 = r3.getSupportFragmentManager();
        if (r5 != null) goto L9;
        Log.e("FragmentUtils", "fm is null");
        return;
    L9:
        FragmentTransaction r0 = r5.beginTransaction();
        String r1 = r4.getClass().getName();
        Fragment r6 = r5.findFragmentByTag(r1);
        if (r6 == null) goto L15;
        if (r6.isAdded() == false) goto L15;
        r0.remove(r6);
    L15:
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r0, r4, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, r1, R.id.content) == true) goto L18;
        r0.add(R.id.content, r4, r1);
    L18:
        r0.commitNowAllowingStateLoss();
    }
}
