package g8;

import i2.g;
import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
public final class a implements Comparator<g> {
    @Override // java.util.Comparator
    public final int compare(g r8, g r10) {
        g r11 = r8;
        g r12 = r10;
        return Integer.compare((r12.f8133d + 1) * r12.f8131b, (r11.f8133d + 1) * r11.f8131b);
    }
}
