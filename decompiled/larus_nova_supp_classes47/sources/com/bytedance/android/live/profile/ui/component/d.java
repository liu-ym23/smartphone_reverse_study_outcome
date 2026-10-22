package com.bytedance.android.live.profile.ui.component;

import android.content.Context;
import android.view.View;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d implements View.OnClickListener {
    public final /* synthetic */ py.k a;
    public final /* synthetic */ Map b;
    public final /* synthetic */ ProfileCommonComponent c;
    public final /* synthetic */ Context d;

    public d(py.k r1, Map r2, ProfileCommonComponent r3, Context r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        this.c.i.a().showGradePage(this.d, this.a.getSchema());
    }
}
