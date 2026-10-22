package e7a;

import java.util.Comparator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class e implements Comparator<f.b> {
    public e() {
    }

    @Override // java.util.Comparator
    public final int compare(f.b r1, f.b r2) {
        return Integer.compare(Math.abs(r1.c), Math.abs(r2.c));
    }
}
