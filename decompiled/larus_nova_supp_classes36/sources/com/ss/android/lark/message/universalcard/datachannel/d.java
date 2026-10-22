package com.ss.android.lark.message.universalcard.datachannel;

import com.ss.android.lark.sdk.g;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d implements g.b {
    public static final d a = null;

    static {
        a = new d();
    }

    public d() {
    }

    public final void a(byte[] r3) {
        Iterator r0 = ((ArrayList) MessageCardDataService.d).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((g.b) r0.next()).a(r3);
        goto L4
    }
}
