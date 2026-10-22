package com.ss.android.lark.locationmessage.ui.navigation;

import android.view.View;
import androidx.fragment.app.FragmentActivity;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class p implements View.OnClickListener {
    public final /* synthetic */ NavigateView a;

    public p(NavigateView r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        NavigateView r3 = this.a;
        if ((r3.b instanceof NavigateResponsiveActivity) == false) goto L5;
        com.ss.android.lark.ui.component_container.a.d(((NavigateFragment.a) r3.c).a, null);
        return;
    L5:
        NavigateFragment r4 = ((NavigateFragment.a) r3.c).a;
        if (r4.h == false) goto L10;
        FragmentActivity r5 = r4.getActivity();
        if (r5 == null) goto L13;
        r5.onBackPressed();
        return;
    L13:
        return;
    L10:
        r4.finish();
    }
}
