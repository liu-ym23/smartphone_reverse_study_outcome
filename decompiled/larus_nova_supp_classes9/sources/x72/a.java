package x72;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a implements b.a {
    public final List<b> a;
    public final u72.a b;
    public final int c;

    public final boolean a(k32.a r6) {
        if (this.c >= this.a.size()) goto L6;
        int r1 = this.c;
        List<b> r3 = this.a;
        a r0 = new a(r1 + 1, r3, this.b);
        return ((b) ListProtector.get(r3, r1)).a(r0, r6);
    L6:
        return false;
    }

    public a(int r1, List<b> r2, u72.a r3) {
        this.c = r1;
        this.a = r2;
        this.b = r3;
    }
}
