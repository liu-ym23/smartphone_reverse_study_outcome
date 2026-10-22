package org.apache.commons.collections4;

import java.util.Comparator;
import org.apache.commons.collections4.comparators.ComparableComparator;

/* JADX INFO: loaded from: classes6.dex */
public class ComparatorUtils {
    public static final Comparator NATURAL_COMPARATOR = null;

    static {
        NATURAL_COMPARATOR = ComparableComparator.comparableComparator();
    }
}
