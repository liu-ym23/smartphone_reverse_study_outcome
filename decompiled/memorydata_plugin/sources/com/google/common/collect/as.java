package com.google.common.collect;

import java.lang.Comparable;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public interface as<K extends Comparable, V> {
    Map<Range<K>, V> asMapOfRanges();
}
