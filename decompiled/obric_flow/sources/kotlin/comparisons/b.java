package kotlin.comparisons;

import java.util.Comparator;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class b implements Comparator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f18732a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Comparator f18733b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Comparator f18734c;

    public /* synthetic */ b(Comparator r5, Comparator r10, int r11) {
        this.f18732a = r11;
        this.f18733b = r5;
        this.f18734c = r10;
    }

    @Override // java.util.Comparator
    public final int compare(Object r5, Object r10) {
        switch(this.f18732a) {
            case 0: goto L7;
            default: goto L5;
        };
    L5:
        return ComparisonsKt__ComparisonsKt.d(this.f18733b, this.f18734c, r5, r10);
    L7:
        return ComparisonsKt__ComparisonsKt.b(this.f18733b, this.f18734c, r5, r10);
    }
}
