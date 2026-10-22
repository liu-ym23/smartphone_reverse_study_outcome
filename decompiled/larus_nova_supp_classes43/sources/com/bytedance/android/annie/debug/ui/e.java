package com.bytedance.android.annie.debug.ui;

import android.view.View;
import com.bytedance.common.utility.android.ClipboardCompat;
import com.bytedance.mt.protector.impl.collections.ListProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class e implements View.OnClickListener {
    public final /* synthetic */ UrlFormAdapter a;
    public final /* synthetic */ UrlFormViewHolder b;

    public e(UrlFormAdapter r1, UrlFormViewHolder r10) {
        this.a = r1;
        this.b = r10;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r10) {
        int r11 = this.a.a.size();
        int r0 = this.b.getAdapterPosition();
        if (r0 < 0) goto L6;
        if (r0 >= r11) goto L6;
        boolean r12 = true;
    L7:
        if (r12 == false) goto L10;
        g r13 = (g) ListProtector.get(this.a.a, this.b.getAdapterPosition());
        String r14 = r13.c + '=' + r13.d;
        UrlFormAdapter r1 = this.a;
        ClipboardCompat.setText(r1.b, "", r14);
        a8.d.a(r1.b, "已经复制到剪切板");
        return;
    L10:
        return;
    L6:
        r12 = false;
        goto L7
    }
}
