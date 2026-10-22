package com.larksuite.component.blockit.hashtag.add;

import android.view.View;
import android.widget.EditText;
import com.ss.android.lark.widget.listener.OnSingleClickListener;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class e extends OnSingleClickListener {
    public final /* synthetic */ b a;

    public e(b r1) {
        this.a = r1;
    }

    public final void onSingleClick(View r2) {
        ((EditText) this.a.a.findViewById(2131371788)).setText("");
    }
}
