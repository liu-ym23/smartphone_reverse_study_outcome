package com.larksuite.component.ui.tag;

import com.larksuite.component.universe_design.tag.UDTagsDrawable;
import java.util.Comparator;
import kotlin.Pair;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class c<T> implements Comparator {
    public c() {
    }

    @Override // java.util.Comparator
    public final int compare(T r1, T r2) {
        return ComparisonsKt.compareValues(Integer.valueOf(((UDTagsDrawable.d) ((Pair) r1).getSecond()).a), Integer.valueOf(((UDTagsDrawable.d) ((Pair) r2).getSecond()).a));
    }
}
