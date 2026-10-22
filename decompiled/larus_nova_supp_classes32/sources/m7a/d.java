package m7a;

import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.JavaOnlyMap;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class d extends a {
    public final void d(JavaOnlyArray r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        ArrayList r0 = new ArrayList();
        int r1 = 0;
    L6:
        if (r1 >= r5.size()) goto L14;
        JavaOnlyMap r2 = r5.getMap(r1);
        if (r2 == null) goto L13;
        if (r2.isEmpty() == true) goto L13;
        r0.add(r2);
    L13:
        r1 = r1 + 1;
        goto L6
    L14:
        a("attachedCells", r0);
    }

    public d(int r1, String r2) {
        super(r1, r2);
    }
}
