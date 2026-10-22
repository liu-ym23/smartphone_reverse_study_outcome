package androidx.work;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class OverwritingInputMerger extends j {
    public OverwritingInputMerger() {
    }

    @Override // androidx.work.j
    public final e a(ArrayList r8) {
        e.a r10 = new e.a();
        HashMap r11 = new HashMap();
        Iterator r12 = r8.iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        r11.putAll(Collections.unmodifiableMap(((e) r12.next()).f2824a));
        goto L4
    L6:
        r10.b(r11);
        return r10.a();
    }
}
