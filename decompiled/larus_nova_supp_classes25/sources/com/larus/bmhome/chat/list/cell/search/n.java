package com.larus.bmhome.chat.list.cell.search;

import com.larus.bmhome.chat.component.cvs.y;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class n implements Function0 {
    public final /* synthetic */ SearchListCell a;

    public /* synthetic */ n(SearchListCell r1) {
        this.a = r1;
    }

    public final Object invoke() {
        final SearchListCell r0 = this.a;
        int r1 = SearchListCell.o;
        y r2 = lf8.a.a(r0, y.class);
        if (r2 == null) goto L5;
        r2.Z7(new d(r0));
        return r2;
    L5:
        return null;
    }
}
