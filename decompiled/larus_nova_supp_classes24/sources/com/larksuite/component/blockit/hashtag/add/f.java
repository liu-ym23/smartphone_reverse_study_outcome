package com.larksuite.component.blockit.hashtag.add;

import android.view.View;
import android.widget.EditText;
import com.ss.android.lark.widget.listener.OnSingleClickListener;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class f extends OnSingleClickListener {
    public final /* synthetic */ b a;

    public f(b r1) {
        this.a = r1;
    }

    public final void onSingleClick(View r5) {
        b r6 = this.a;
        EditText r0 = (EditText) r6.a.findViewById(2131371788);
        r0.setFocusable(true);
        r0.setFocusableInTouchMode(true);
        r0.requestFocus();
        r6.a.postDelayed(new h(r6), 150);
    }
}
