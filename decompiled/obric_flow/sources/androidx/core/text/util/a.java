package androidx.core.text.util;

import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements Comparator {
    @Override // java.util.Comparator
    public final int compare(Object r5, Object r10) {
        return LinkifyCompat.a((LinkifyCompat.LinkSpec) r5, (LinkifyCompat.LinkSpec) r10);
    }
}
