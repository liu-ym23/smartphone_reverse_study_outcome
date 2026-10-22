package com.bytedance.android.livesdk.dislike.preload.datamanager;

import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a<T> implements Consumer {
    public final /* synthetic */ LLPanelPreprocessor a;

    public a(LLPanelPreprocessor r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        Long r3 = (Long) r2;
        Iterator<T> r4 = ((List) this.a.h.getValue()).iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        ((com.bytedance.android.livesdk.dislike.preload.loader.a) r4.next()).d();
        goto L4
    }
}
