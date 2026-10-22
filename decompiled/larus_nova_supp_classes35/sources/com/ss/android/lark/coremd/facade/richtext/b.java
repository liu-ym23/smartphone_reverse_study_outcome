package com.ss.android.lark.coremd.facade.richtext;

import com.ss.android.lark.biz.im.api.extension.message.d;
import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b<T> implements Comparator {
    public b() {
    }

    @Override // java.util.Comparator
    public final int compare(T r1, T r2) {
        ((d.a) r1).getClass();
        ((d.a) r2).getClass();
        return ComparisonsKt.compareValues(0, 0);
    }
}
