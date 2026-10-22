package i1;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class f extends a {
    f(int r10, Set<String> r11, Map<String, List<Set<String>>> r12, Map<String, List<Map<String, Object>>> r13) {
        super(r10, r11, r12, r13);
    }

    @Override // i1.a
    boolean d(i r10) {
        int r11 = a();
        if (r11 >= 0) goto L6;
        return true;
    L6:
        if (r11 <= 0) goto L9;
        return false;
    L9:
        if (new Random().nextInt(10000) < this.f9363a) goto L12;
        return true;
    L12:
        return false;
    }
}
