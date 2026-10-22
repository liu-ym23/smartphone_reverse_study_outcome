package com.ss.android.lark.location.service;

import com.bytedance.i18n.claymore.ClaymoreServiceLoader;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final /* synthetic */ class f {
    static {
        int r0 = g.a;
    }

    public static g a() {
        ArrayList r0 = new ArrayList();
        Iterator r1 = ClaymoreServiceLoader.loadAll(g.class);
    L4:
        if (r1.hasNext() == false) goto L6;
        r0.add((g) r1.next());
        goto L4
    L6:
        Collections.sort(r0, new e());
        return (g) ListProtector.get(r0, 0);
    }
}
