package com.obric.assistant.util;

import android.view.KeyEvent;
import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class r1 implements View.OnKeyListener {
    public final /* synthetic */ ObricMentionHighlightHelper.a a;

    public /* synthetic */ r1(ObricMentionHighlightHelper.a r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View r4, int r5, KeyEvent r6) {
        ObricMentionHighlightHelper.a r0 = this.a;
        if (r5 == 67) goto L5;
    L9:
        View.OnKeyListener r1 = r0.m;
        if (r1 != null) goto L12;
    L14:
        return false;
    L12:
        if (r1.onKey(r4, r5, r6) != true) goto L14;
        return true;
    L5:
        if (r6.getAction() != 0) goto L9;
        if (r0.d() == false) goto L9;
        return true;
    }
}
