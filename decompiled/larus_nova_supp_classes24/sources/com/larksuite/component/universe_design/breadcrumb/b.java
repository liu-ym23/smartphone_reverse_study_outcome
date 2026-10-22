package com.larksuite.component.universe_design.breadcrumb;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class b implements View.OnClickListener {
    public final /* synthetic */ UDBreadcrumbAdapter a;
    public final /* synthetic */ int b;

    public b(UDBreadcrumbAdapter r1, int r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        this.a.b.onItemClick(this.b);
    }
}
