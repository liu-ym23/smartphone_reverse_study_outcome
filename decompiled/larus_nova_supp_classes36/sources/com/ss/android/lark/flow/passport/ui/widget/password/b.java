package com.ss.android.lark.flow.passport.ui.widget.password;

import android.animation.ValueAnimator;
import android.view.View;
import com.ss.android.lark.flow.passport.ui.widget.common.g;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b implements View.OnFocusChangeListener {
    public final /* synthetic */ PasswordEditText a;

    public b(PasswordEditText r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View r3, boolean r4) {
        PasswordEditText r0 = this.a;
        int r1 = PasswordEditText.k;
        r0.getClass();
        View.OnFocusChangeListener r2 = this.a.f;
        if (r2 == null) goto L5;
        r2.onFocusChange(r3, r4);
    L5:
        this.a.getClass();
        if (r4 == false) goto L8;
        g r5 = g.b;
    L9:
        PasswordEditText r6 = this.a;
        List<ValueAnimator> r7 = r6.i;
        ArrayList r8 = (ArrayList) r7;
        r8.add(r6.j.c(r5));
        return;
    L8:
        r5 = g.a;
        goto L9
    }
}
