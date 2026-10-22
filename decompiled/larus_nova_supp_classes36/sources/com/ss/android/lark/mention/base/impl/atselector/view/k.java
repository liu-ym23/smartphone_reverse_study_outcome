package com.ss.android.lark.mention.base.impl.atselector.view;

import androidx.recyclerview.widget.RecyclerView;
import com.larksuite.framework.utils.KeyboardUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class k extends RecyclerView.OnScrollListener {
    public final /* synthetic */ AtView a;

    public k(AtView r1) {
        this.a = r1;
    }

    public final void onScrollStateChanged(RecyclerView r1, int r2) {
        super.onScrollStateChanged(r1, r2);
        if (r2 != 1) goto L6;
        this.a.mSearchEt.clearFocus();
        KeyboardUtils.hideKeyboard(this.a.b);
        return;
    }
}
