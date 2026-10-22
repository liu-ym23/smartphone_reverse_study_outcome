package com.ss.android.lark.forwardv3.confirmdialog;

import android.view.View;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements View.OnClickListener {
    public final /* synthetic */ ForwardConfirmDialogAdapter.a a;
    public final /* synthetic */ SearchBaseInfo b;

    public a(ForwardConfirmDialogAdapter.a r1, SearchBaseInfo r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        this.a.a(this.b);
    }
}
