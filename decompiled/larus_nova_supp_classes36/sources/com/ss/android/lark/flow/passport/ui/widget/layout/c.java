package com.ss.android.lark.flow.passport.ui.widget.layout;

import android.view.View;
import androidx.lifecycle.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c<T> implements Observer {
    public final /* synthetic */ CommonContainerLayout a;

    public c(CommonContainerLayout r1) {
        this.a = r1;
    }

    public final void onChanged(Object r4) {
        uzb.b.b r5 = (uzb.b.b) r4;
        View r0 = this.a.findFocus();
        if (this.a.getIntercept() == true) goto L6;
        this.a.getOnImeChangeHandler().invoke(r0, Boolean.valueOf(r5.a), Integer.valueOf(r5.b));
        return;
    }
}
