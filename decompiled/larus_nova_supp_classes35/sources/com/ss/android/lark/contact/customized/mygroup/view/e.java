package com.ss.android.lark.contact.customized.mygroup.view;

import android.view.View;
import androidx.fragment.app.FragmentActivity;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class e implements View.OnClickListener {
    public final /* synthetic */ OfficeMyJoinGroupFragment a;

    public e(OfficeMyJoinGroupFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r1) {
        FragmentActivity r2 = this.a.getActivity();
        if (r2 == null) goto L6;
        r2.finish();
        return;
    }
}
