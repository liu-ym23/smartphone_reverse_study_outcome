package com.larus.bmhome.debug;

import com.larus.im.bean.message.Message;
import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class m0<T> implements Comparator {
    public m0() {
    }

    @Override // java.util.Comparator
    public final int compare(T r3, T r4) {
        return ComparisonsKt.compareValues(Long.valueOf(((Message) r4).getCreateTime()), Long.valueOf(((Message) r3).getCreateTime()));
    }
}
