package io.reactivex.internal.functions;

import java.util.Comparator;

/* JADX INFO: loaded from: classes3.dex */
final enum Functions$NaturalComparator extends Enum<Functions$NaturalComparator> implements Comparator<Object> {
    public static final Functions$NaturalComparator INSTANCE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Functions$NaturalComparator[] f17613a = null;

    static {
        Functions$NaturalComparator r5 = new Functions$NaturalComparator("INSTANCE", 0);
        INSTANCE = r5;
        f17613a = new Functions$NaturalComparator[]{r5};
    }

    public static Functions$NaturalComparator valueOf(String r5) {
        return (Functions$NaturalComparator) Enum.valueOf(Functions$NaturalComparator.class, r5);
    }

    public static Functions$NaturalComparator[] values() {
        return (Functions$NaturalComparator[]) f17613a.clone();
    }

    @Override // java.util.Comparator
    public int compare(Object r5, Object r10) {
        return ((Comparable) r5).compareTo(r10);
    }
}
