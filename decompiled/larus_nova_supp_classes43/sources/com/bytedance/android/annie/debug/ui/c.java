package com.bytedance.android.annie.debug.ui;

import android.content.Context;
import android.view.View;
import com.bytedance.common.utility.android.ClipboardCompat;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c implements View.OnLongClickListener {
    public final /* synthetic */ DialogItem a;
    public final /* synthetic */ DialogAdapter b;

    public c(DialogItem r1, DialogAdapter r10) {
        this.a = r1;
        this.b = r10;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View r10) {
        String r11 = this.a.b;
        if (r11 == null) goto L9;
        DialogAdapter r0 = this.b;
        ClipboardCompat.setText(r0.b, "", r11);
        Context r12 = r0.b;
        if (r12 == null) goto L11;
        a8.d.a(r12, "已经复制到剪切板");
        return true;
    L11:
        return true;
    L9:
        return false;
    }
}
