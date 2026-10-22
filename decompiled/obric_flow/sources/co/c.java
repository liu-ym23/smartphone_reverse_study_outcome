package co;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends e {
    public final long d;
    public final HashMap e;

    public c(HashMap r5) {
        super(r5);
        if (r5.get("sizeBytes") == null) goto L5;
        long r10 = ((Long) r5.get("sizeBytes")).longValue();
    L6:
        this.d = r10;
        if (r5.get("detail") == null) goto L9;
        HashMap r11 = (HashMap) r5.get("detail");
    L10:
        this.e = new HashMap();
        Iterator r12 = r11.entrySet().iterator();
    L12:
        if (r12.hasNext() == false) goto L14;
        Map.Entry r13 = (Map.Entry) r12.next();
        this.e.put(r13.getKey(), new d((HashMap) r13.getValue()));
        goto L12
    L14:
        return;
    L9:
        r11 = new HashMap();
        goto L10
    L5:
        r10 = -1;
        goto L6
    }
}
