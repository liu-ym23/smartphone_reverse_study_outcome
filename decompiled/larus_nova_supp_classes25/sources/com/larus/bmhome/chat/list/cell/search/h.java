package com.larus.bmhome.chat.list.cell.search;

import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.search.LruSet;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class h implements Function0 {
    public final /* synthetic */ SearchListCell a;
    public final /* synthetic */ Message b;
    public final /* synthetic */ BotModel c;

    public /* synthetic */ h(SearchListCell r1, Message r2, BotModel r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final Object invoke() {
        SearchListCell r1 = this.a;
        Message r3 = this.b;
        BotModel r2 = this.c;
        int r4 = SearchListCell.o;
        int r5 = oi8.f.a;
        q0 r6 = lf8.a.b(r1);
        if (r6 == null) goto L5;
        LruSet<String> r7 = r6.E7();
    L6:
        ChatParam r8 = r1.t();
        String r9 = r2.getBotId();
        if (r9 != null) goto L9;
        r9 = "";
    L9:
        String r10 = r9;
        oi8.f.k(r7, r3, r8, 0, -1, null, null, "think_process", r10, null, null, 0, 0, null, 15968);
        return Unit.INSTANCE;
    L5:
        r7 = null;
        goto L6
    }
}
