package com.ss.android.lark.contact.customized.search.view;

import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentActivity;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c implements ViewTreeObserver.OnPreDrawListener {
    public final /* synthetic */ LinearLayout a;
    public final /* synthetic */ OfficeInviteExternalSearchFragment b;

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        this.a.getViewTreeObserver().removeOnPreDrawListener(this);
        FragmentActivity r0 = this.b.getActivity();
        if (r0 == null) goto L7;
        r0.startPostponedEnterTransition();
        return true;
    L7:
        return true;
    }

    public c(LinearLayout r1, OfficeInviteExternalSearchFragment r2) {
        this.a = r1;
        this.b = r2;
    }
}
