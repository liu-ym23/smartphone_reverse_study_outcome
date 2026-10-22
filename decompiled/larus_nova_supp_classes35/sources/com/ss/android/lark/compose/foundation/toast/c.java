package com.ss.android.lark.compose.foundation.toast;

import android.view.View;
import com.larksuite.component.universe_design.toast.UDToast;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c implements View.OnClickListener {
    public final /* synthetic */ UDToast.b a;
    public final /* synthetic */ b b;

    public c(FlowToast.c r1, b r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        this.a.a(this.b);
    }
}
