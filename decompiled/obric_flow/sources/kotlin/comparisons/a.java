package kotlin.comparisons;

import java.util.Comparator;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class a implements Comparator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f18730a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f18731b;

    public /* synthetic */ a(Object r5, int r10) {
        this.f18730a = r10;
        this.f18731b = r5;
    }

    @Override // java.util.Comparator
    public final int compare(Object r5, Object r10) {
        int r11 = this.f18730a;
        Object r12 = this.f18731b;
        switch(r11) {
            case 0: goto L9;
            case 1: goto L7;
            default: goto L5;
        };
    L5:
        return ComparisonsKt__ComparisonsKt.c((Function1[]) r12, r5, r10);
    L7:
        return ComparisonsKt__ComparisonsKt.e((Comparator) r12, r5, r10);
    L9:
        return ComparisonsKt__ComparisonsKt.a((Comparator) r12, r5, r10);
    }
}
