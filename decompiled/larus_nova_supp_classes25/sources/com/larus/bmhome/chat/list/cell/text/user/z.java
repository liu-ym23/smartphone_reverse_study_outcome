package com.larus.bmhome.chat.list.cell.text.user;

import android.view.View;
import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;
import com.larus.im.bean.message.Message;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class z implements View.OnClickListener {
    public final /* synthetic */ UserTextCell a;
    public final /* synthetic */ CustomMarkdownTextView b;

    public /* synthetic */ z(UserTextCell r1, CustomMarkdownTextView r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        UserTextCell r6 = this.a;
        CustomMarkdownTextView r0 = this.b;
        if (r6.y == true) goto L6;
        wg8.c r1 = r6.r;
        Message r7 = r6.h;
        int r2 = wg8.c.k;
        r1.a(r7, r0, 0);
        return;
    }
}
