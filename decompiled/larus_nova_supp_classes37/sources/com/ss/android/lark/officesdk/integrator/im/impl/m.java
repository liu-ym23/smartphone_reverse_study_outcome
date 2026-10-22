package com.ss.android.lark.officesdk.integrator.im.impl;

import com.ss.android.lark.integrator.im.extension.ExtensionManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class m implements pmb.g {
    public m() {
    }

    public final void a(List<r5b.e<?, ?, ?>> r4) {
        Iterator r0 = ExtensionManager.a().b.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ArrayList r2 = (ArrayList) r4;
        r2.addAll(((rxa.a) r0.next()).a());
        goto L4
    }
}
