package com.larus.bmhome.chat.component.list;

import com.larus.im.bean.message.Message;
import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class o5<T> implements Comparator {
    public o5() {
    }

    @Override // java.util.Comparator
    public final int compare(T r3, T r4) {
        return ComparisonsKt.compareValues(Long.valueOf(((Message) r3).getLocalIndex()), Long.valueOf(((Message) r4).getLocalIndex()));
    }
}
