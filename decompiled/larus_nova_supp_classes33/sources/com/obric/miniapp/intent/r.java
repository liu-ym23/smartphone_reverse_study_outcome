package com.obric.miniapp.intent;

import com.larus.im.bean.message.Message;
import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class r<T> implements Comparator {
    public final /* synthetic */ Comparator a;

    public r(q r1) {
        this.a = r1;
    }

    @Override // java.util.Comparator
    public final int compare(T r3, T r4) {
        int r0 = this.a.compare(r3, r4);
        if (r0 == 0) goto L6;
        return r0;
    L6:
        return ComparisonsKt.compareValues(Long.valueOf(((Message) r3).getServerIndex()), Long.valueOf(((Message) r4).getServerIndex()));
    }
}
