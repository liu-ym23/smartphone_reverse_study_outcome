package com.larksuite.component.blockit.hashtag.add;

import android.text.Editable;
import android.widget.ImageView;
import com.ss.android.lark.utils.q0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class c extends q0 {
    public final /* synthetic */ b a;

    public c(b r1) {
        this.a = r1;
    }

    public final void afterTextChanged(Editable r5) {
        String r6 = String.valueOf(r5);
        b r0 = this.a;
        if (r6.length() != 0) goto L5;
        boolean r1 = true;
    L7:
        if (r1 == false) goto L11;
        ((ImageView) r0.a.findViewById(2131375940)).setVisibility(8);
        j.a r2 = r0.e;
        if (r2 == null) goto L15;
        r2.r7(r6);
        return;
    L15:
        return;
    L11:
        ((ImageView) r0.a.findViewById(2131375940)).setVisibility(0);
        j.a r3 = r0.e;
        if (r3 == null) goto L17;
        r3.r7(r6);
        return;
    L17:
        return;
    L5:
        r1 = false;
        goto L7
    }
}
