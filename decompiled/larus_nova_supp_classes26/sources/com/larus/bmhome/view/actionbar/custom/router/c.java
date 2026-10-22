package com.larus.bmhome.view.actionbar.custom.router;

import com.larus.bmhome.view.actionbar.api.IActionBarProvider;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class c {
    public static final ArrayList<b> a = null;

    static {
        ArrayList<b> r0 = CollectionsKt.arrayListOf(new b[]{new e(), new d()});
        Iterator r1 = ServiceManager.get().getServices(IActionBarProvider.class, true).iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r0.addAll(((IActionBarProvider) r1.next()).a());
        goto L4
    L6:
        r0.add(new f());
        r0.add(new a());
        a = r0;
    }
}
