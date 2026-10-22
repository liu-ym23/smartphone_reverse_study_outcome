package com.ss.android.lark.desktopmode.app;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class DesktopCompatFragmentWrapper extends DesktopCompatFragment {
    public Fragment d;

    public DesktopCompatFragmentWrapper() {
        this.d = null;
    }

    public final void onDestroy() {
        super.onDestroy();
        getChildFragmentManager().beginTransaction().remove(this.d).commitAllowingStateLoss();
    }

    @Override // com.ss.android.lark.desktopmode.app.DesktopCompatFragment
    public final void onActivityCreated(Bundle r5) {
        super.onActivityCreated(r5);
        FragmentTransaction r6 = getChildFragmentManager().beginTransaction();
        Fragment r0 = this.d;
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r6, r0, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, null, 2131373287) == true) goto L6;
        r6.add(2131373287, r0);
    L6:
        r6.commitAllowingStateLoss();
    }

    @Override // com.ss.android.lark.desktopmode.app.DesktopCompatFragment
    public final View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        FrameLayout r4 = new FrameLayout(r1.getContext());
        r4.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        r4.setId(2131373287);
        r4.setBackgroundColor(-1);
        return r4;
    }
}
