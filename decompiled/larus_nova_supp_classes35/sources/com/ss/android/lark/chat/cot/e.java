package com.ss.android.lark.chat.cot;

import com.ss.android.lark.chat.entity.message.CotEventType;
import java.util.Comparator;
import java.util.Map;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class e<T> implements Comparator {
    public e() {
    }

    @Override // java.util.Comparator
    public final int compare(T r1, T r2) {
        return ComparisonsKt.compareValues(((CotEventType) ((Map.Entry) r1).getKey()).name(), ((CotEventType) ((Map.Entry) r2).getKey()).name());
    }
}
