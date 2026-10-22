package b20;

import androidx.viewpager.widget.ViewPager;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b extends e {
    public b() {
    }

    @Override // b20.e
    public final boolean a(long r3, Map<String, ? extends Object> r5) {
        if (r5 == null) goto L4;
        Object r6 = r5.get("selected_group_id");
    L6:
        if ((r6 instanceof Long) == true) goto L9;
    L11:
        return false;
    L9:
        if (r3 != ((Long) r6).longValue()) goto L11;
        return true;
    L4:
        r6 = null;
        goto L6
    }

    @Override // b20.e
    public final boolean b(List r2, ViewPager r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "data");
        if (r3 != null) goto L5;
    L7:
        if (r3 == null) goto L9;
        r3.post(new a(r3, r4));
    L9:
        return true;
    L5:
        if (r3.getCurrentItem() != r4) goto L7;
        return true;
    }
}
