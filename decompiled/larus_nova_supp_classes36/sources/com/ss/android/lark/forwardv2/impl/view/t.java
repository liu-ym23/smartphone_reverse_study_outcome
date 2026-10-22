package com.ss.android.lark.forwardv2.impl.view;

import com.ss.android.lark.picker.base.view.SearchResultView;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class t implements SearchResultView.IOnBusinessConsumeItem {
    public final /* synthetic */ d0 a;

    public t(d0 r1) {
        this.a = r1;
    }

    public final SearchResultView.CheckBoxBindStatus onBusinessBindItemCheckBox(SearchBaseInfo r6) {
        d0 r1 = this.a;
        if (d0.p(r6, r1.h) == false) goto L5;
    L15:
        boolean r2 = true;
    L17:
        return new SearchResultView.CheckBoxBindStatus(r2, false, !d0.p(r6, this.a.h));
    L5:
        if (r1.f == 1) goto L7;
    L11:
        boolean r3 = false;
    L12:
        if (r3 == true) goto L15;
        r2 = false;
        goto L17
    L7:
        if (r6.isSelected() == true) goto L11;
        if (r1.d.H2(r1.l) == false) goto L11;
        r3 = true;
        goto L12
    }

    public final boolean onBusinessConsumeItemClick(SearchBaseInfo r2) {
        return d0.h(this.a, r2);
    }
}
