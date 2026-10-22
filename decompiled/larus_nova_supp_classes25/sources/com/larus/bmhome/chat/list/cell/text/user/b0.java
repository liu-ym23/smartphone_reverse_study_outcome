package com.larus.bmhome.chat.list.cell.text.user;

import android.view.View;
import com.larus.bmhome.chat.list.cell.text.highlight.SearchLandingHighlightHelper;
import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class b0 implements View.OnLongClickListener {
    public final /* synthetic */ UserTextCell a;
    public final /* synthetic */ CustomMarkdownTextView b;

    public /* synthetic */ b0(UserTextCell r1, CustomMarkdownTextView r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View r75) {
        UserTextCell r1 = this.a;
        CustomMarkdownTextView r5 = this.b;
        int r2 = UserTextCell.z;
        com.larus.bmhome.chat.component.cvs.y r3 = r1.B();
        if (r3 == null) goto L6;
        BotModel r4 = r3.j0();
        if (r4 == null) goto L6;
    L7:
        BotModel r6 = r4;
        SearchLandingHighlightHelper r7 = SearchLandingHighlightHelper.a;
        r5.getClass();
        r7.getClass();
        SearchLandingHighlightHelper.d(r5);
        Message r8 = r1.h;
        if (r8 == null) goto L14;
        String r9 = r8.getMessageId();
        if (r9 == null) goto L14;
        va8.p r10 = r1.C();
        if (r10 == null) goto L14;
        r10.mi(r9);
    L14:
        wg8.f.a(r1.f, r1.h, r6, r5, r1.e, lf8.a.b(r1), null, null, null, 224);
        return true;
    L6:
        r4 = new BotModel("unknown", null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -2, Integer.MAX_VALUE, null);
        goto L7
    }
}
