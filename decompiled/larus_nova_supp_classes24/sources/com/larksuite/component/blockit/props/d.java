package com.larksuite.component.blockit.props;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class d {
    public final Map<String, WeakReference<PropsView>> a;
    public final Map<String, List<a>> b;

    public d() {
        this.a = new ConcurrentHashMap();
        this.b = new ConcurrentHashMap();
    }

    public final void a(String r3, PropsView r4, a r5) {
        if (r4 == null) goto L4;
        Map<String, WeakReference<PropsView>> r0 = this.a;
        ConcurrentHashMap r1 = (ConcurrentHashMap) r0;
        r1.put(r3, new WeakReference(r4));
    L4:
        if (r5 == null) goto L10;
        List r6 = (List) ((ConcurrentHashMap) this.b).get(r3);
        if (r6 != null) goto L8;
        r6 = new ArrayList();
    L8:
        r6.add(r5);
        ((ConcurrentHashMap) this.b).put(r3, r6);
        return;
    }
}
