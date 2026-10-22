package com.larus.bmhome.chat.list.cell.search;

import com.larus.bmhome.chat.api.q0;
import com.larus.im.bean.message.Message;
import java.util.List;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class g implements Function0 {
    public final /* synthetic */ Message a;
    public final /* synthetic */ SearchListCell b;

    public /* synthetic */ g(Message r1, SearchListCell r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke() {
        Message r0 = this.a;
        SearchListCell r1 = this.b;
        int r2 = SearchListCell.o;
        q0 r3 = lf8.a.b(r1);
        if (r3 == null) goto L5;
        List r4 = r3.getCurrentList();
    L7:
        return Boolean.valueOf(xc8.m.b(r0, r4));
    L5:
        r4 = null;
        goto L7
    }
}
