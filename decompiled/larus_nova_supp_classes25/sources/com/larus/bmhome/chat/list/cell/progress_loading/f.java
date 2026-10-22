package com.larus.bmhome.chat.list.cell.progress_loading;

import com.larus.bmhome.chat.ChatParam;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class f implements Function0 {
    public final /* synthetic */ BaseProgressLoadingCell a;

    public /* synthetic */ f(BaseProgressLoadingCell r1) {
        this.a = r1;
    }

    public final Object invoke() {
        BaseProgressLoadingCell r0 = this.a;
        int r1 = BaseProgressLoadingCell.n;
        ChatParam r2 = (ChatParam) lf8.a.c(r0, ChatParam.class);
        if (r2 == null) goto L5;
        return r2;
    L5:
        return new ChatParam(null, null, null, null, null, 255);
    }
}
