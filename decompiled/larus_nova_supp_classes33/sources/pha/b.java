package pha;

import com.obric.assistant.settings.config.CompressParam;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class b {
    public static final b a = null;

    static {
        a = new b();
    }

    public b() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void a(Map<String, List<CompressParam>> r3, List<CompressParam> r4) {
        if (r4 == null) goto L15;
        Iterator<T> r5 = r4.iterator();
    L5:
        if (r5.hasNext() == false) goto L21;
        CompressParam r0 = (CompressParam) r5.next();
        if (r0 == null) goto L5;
        String r1 = r0.getScene();
        if (r1 != null) goto L11;
        r1 = "";
    L11:
        Object r2 = ((LinkedHashMap) r3).get(r1);
        if (r2 != null) goto L14;
        r2 = new ArrayList();
        r3.put(r1, r2);
    L14:
        ((List) r2).add(r0);
        goto L5
    L21:
        return;
    }
}
