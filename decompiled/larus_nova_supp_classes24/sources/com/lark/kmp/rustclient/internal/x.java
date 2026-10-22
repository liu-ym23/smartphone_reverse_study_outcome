package com.lark.kmp.rustclient.internal;

import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class x implements com.lark.kmp.rustclient.api.e {
    public final Map<String, Long> a;

    public x() {
        this.a = new LinkedHashMap();
    }

    @Override // com.lark.kmp.rustclient.api.e
    public final Long a(String r2) {
        if (r2 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        if (r0 == false) goto L12;
        return null;
    L12:
        return (Long) ((LinkedHashMap) this.a).get(r2);
    L4:
        if (r2.length() == 0) goto L7;
        r0 = false;
        goto L8
    }
}
