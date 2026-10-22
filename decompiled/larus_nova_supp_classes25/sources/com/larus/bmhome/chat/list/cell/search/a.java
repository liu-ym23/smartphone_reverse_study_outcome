package com.larus.bmhome.chat.list.cell.search;

import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.layout.item.SearchListBox;
import com.larus.bmhome.chat.layout.item.x3;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class a implements Function0 {
    public final /* synthetic */ Message a;
    public final /* synthetic */ SearchListCell b;
    public final /* synthetic */ BotModel c;

    public /* synthetic */ a(Message r1, SearchListCell r2, BotModel r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final Object invoke() {
        Message r1 = this.a;
        SearchListCell r2 = this.b;
        BotModel r3 = this.c;
        int r4 = SearchListCell.o;
        int r5 = oi8.f.a;
        ChatParam r6 = r2.t();
        SearchListBox r7 = r2.e;
        if (r7 == null) goto L7;
        x3 r8 = r7.getSearchDetailBox();
        if (r8 == null) goto L7;
        Boolean r9 = Boolean.valueOf(r8.b);
    L8:
        String r10 = oi8.f.e(r9, null);
        String r11 = r3.getBotId();
        if (r11 != null) goto L11;
        r11 = "";
    L11:
        oi8.f.j(r1, r6, 0, -1, null, null, "think_process", r10, r11, null, null, 0, 0, 15920);
        return Unit.INSTANCE;
    L7:
        r9 = null;
        goto L8
    }
}
