package com.larus.bmhome.utils;

import com.larus.business.markdown.impl.markwon.MarkwonContent;
import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class r2<T> implements Comparator {
    public final /* synthetic */ MarkwonContent a;

    public r2(MarkwonContent r1) {
        this.a = r1;
    }

    @Override // java.util.Comparator
    public final int compare(T r2, T r3) {
        return ComparisonsKt.compareValues(Integer.valueOf(this.a.a.getSpanStart(r3)), Integer.valueOf(this.a.a.getSpanStart(r2)));
    }
}
