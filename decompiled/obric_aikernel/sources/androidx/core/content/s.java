package androidx.core.content;

import androidx.core.util.Predicate;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class s implements Predicate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f289a;

    public /* synthetic */ s(String r10) {
        this.f289a = r10;
    }

    @Override // androidx.core.util.Predicate
    public final boolean test(Object r10) {
        return this.f289a.equals((String) r10);
    }
}
