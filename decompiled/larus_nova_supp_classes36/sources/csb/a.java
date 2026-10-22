package csb;

import java.util.Comparator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements Comparator<vu3.a.a> {
    public a() {
    }

    @Override // java.util.Comparator
    public final int compare(vu3.a.a r5, vu3.a.a r6) {
        return (int) ((r6.b * 100.0d) - (r5.b * 100.0d));
    }
}
