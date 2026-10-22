package com.bytedance.android.live.profile.ui.component.descriptioncomponent.mylive;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.profile.ui.component.descriptioncomponent.mylive.utils.TabDataHelper;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class l implements View.OnClickListener {
    public final /* synthetic */ TabItemAdapter.LoadingViewHolder a;
    public final /* synthetic */ TabDataHelper b;

    public l(TabItemAdapter.LoadingViewHolder r1, TabDataHelper r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        TextView r3 = this.a.b;
        if (r3 == null) goto L5;
        r3.setText(s1.B(2131922691));
    L5:
        ImageView r4 = this.a.c;
        if (r4 == null) goto L8;
        r4.setVisibility(8);
    L8:
        TabDataHelper r5 = this.b;
        if (r5 == null) goto L12;
        r5.c();
        return;
    }
}
