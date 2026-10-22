package com.larus.bmhome.chat.list.cell.text.user;

import android.view.View;
import com.larus.bmhome.chat.list.cell.text.highlight.SearchLandingHighlightHelper;
import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class a0 implements View.OnLongClickListener {
    public final /* synthetic */ UserTextCell a;
    public final /* synthetic */ CustomMarkdownTextView b;
    public final /* synthetic */ CustomMarkdownTextView c;

    public /* synthetic */ a0(UserTextCell r1, CustomMarkdownTextView r2, CustomMarkdownTextView r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View r77) {
        UserTextCell r1 = this.a;
        CustomMarkdownTextView r2 = this.b;
        CustomMarkdownTextView r7 = this.c;
        int r3 = UserTextCell.z;
        com.larus.bmhome.chat.component.cvs.y r4 = r1.B();
        if (r4 == null) goto L6;
        BotModel r5 = r4.j0();
        if (r5 == null) goto L6;
    L7:
        BotModel r6 = r5;
        SearchLandingHighlightHelper r8 = SearchLandingHighlightHelper.a;
        r2.getClass();
        r8.getClass();
        SearchLandingHighlightHelper.d(r2);
        Message r9 = r1.h;
        if (r9 == null) goto L14;
        String r10 = r9.getMessageId();
        if (r10 == null) goto L14;
        va8.p r11 = r1.C();
        if (r11 == null) goto L14;
        r11.mi(r10);
    L14:
        if (r7 == null) goto L18;
        wg8.f.a(r1.f, r1.h, r6, r7, r7, lf8.a.b(r1), null, null, null, 224);
        return true;
    L18:
        return true;
    L6:
        r5 = new BotModel("unknown", null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -2, Integer.MAX_VALUE, null);
        goto L7
    }
}
