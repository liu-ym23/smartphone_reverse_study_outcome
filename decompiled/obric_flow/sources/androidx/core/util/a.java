package androidx.core.util;

import androidx.core.content.IntentSanitizer;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements Predicate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f482a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Predicate f483b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f484c;

    public /* synthetic */ a(Predicate r5, Predicate r10, int r11) {
        this.f482a = r11;
        this.f483b = r5;
        this.f484c = r10;
    }

    @Override // androidx.core.util.Predicate
    public final boolean test(Object r5) {
        switch(this.f482a) {
            case 0: goto L9;
            case 1: goto L7;
            default: goto L5;
        };
    L5:
        return IntentSanitizer.Builder.e((Class) this.f484c, this.f483b, r5);
    L7:
        return Predicate.b(this.f483b, (Predicate) this.f484c, r5);
    L9:
        return Predicate.d(this.f483b, (Predicate) this.f484c, r5);
    }

    public /* synthetic */ a(Class r5, Predicate r10) {
        this.f482a = 2;
        this.f484c = r5;
        this.f483b = r10;
    }
}
