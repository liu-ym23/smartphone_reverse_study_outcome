package com.bytedance.android.live.profile.ui.component;

import android.view.View;
import androidx.fragment.app.FragmentActivity;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f implements View.OnClickListener {
    public final /* synthetic */ ProfileCommonComponent a;

    public f(ProfileCommonComponent r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        this.a.i.b().recordBusinessClick("user_name", null);
        ProfileCommonComponent r4 = this.a;
        FragmentActivity r0 = r4.a.getActivity();
        if (r0 == null) goto L6;
        r4.i.a().clickAvatar(r0);
        return;
    }
}
