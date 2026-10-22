package com.ss.android.lark.inline.ai.ui.operates;

import android.view.View;
import com.ss.android.lark.inline.ai.api.ui.Operate;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements View.OnClickListener {
    public final /* synthetic */ OperatesAdapter a;
    public final /* synthetic */ Operate b;

    public a(OperatesAdapter r1, Operate r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        OperatesAdapter.b r3 = this.a.b;
        if (r3 == null) goto L6;
        r3.a(this.b);
        return;
    }
}
