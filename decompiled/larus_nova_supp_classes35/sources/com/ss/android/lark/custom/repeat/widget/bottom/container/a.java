package com.ss.android.lark.custom.repeat.widget.bottom.container;

import android.view.View;
import android.widget.AdapterView;
import com.larksuite.component.ui.toast.LKUIToast;
import com.ss.android.lark.utils.UIHelper;
import mab.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a implements AdapterView.OnItemClickListener {
    public final /* synthetic */ CustomRepeatBottomContainer a;

    public a(CustomRepeatBottomContainer r1) {
        this.a = r1;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> r1, View r2, int r3, long r4) {
        CustomRepeatBottomContainer r5 = this.a;
        nab.a r6 = r5.p;
        if (r6.e == false) goto L10;
        g r7 = r5.b;
        if (r7.c != r3) goto L10;
        if (r6.g == null) goto L12;
        String r8 = r7.a(r3);
        String r9 = UIHelper.mustacheFormat(this.a.p.g.intValue(), "Type", r8);
        LKUIToast.show(this.a.getContext(), r9);
        return;
    L12:
        return;
    L10:
        r5.b.e(r3);
        CustomRepeatBottomContainer r10 = this.a;
        r10.a(r10.b, r10.r);
    }
}
