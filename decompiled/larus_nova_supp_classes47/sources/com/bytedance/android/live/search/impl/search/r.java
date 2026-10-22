package com.bytedance.android.live.search.impl.search;

import android.widget.EditText;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class r<T> implements Observer {
    public final /* synthetic */ LiveSearchResultFragment a;

    public r(LiveSearchResultFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        String r3 = (String) r2;
        if (r3 == null) goto L12;
        EditText r0 = this.a.g;
        if (r0 == null) goto L7;
        r0.setText(r3);
    L7:
        EditText r1 = this.a.g;
        if (r1 == null) goto L10;
        r1.setSelection(r3.length());
    L10:
        int r4 = com.bytedance.android.live.search.impl.search.helper.a.a;
        com.bytedance.android.live.search.impl.search.helper.a.b(this.a.g);
        return;
    }
}
