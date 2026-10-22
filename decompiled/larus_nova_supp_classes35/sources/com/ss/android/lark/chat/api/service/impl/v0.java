package com.ss.android.lark.chat.api.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class v0 extends tcb.a<Boolean> {
    public final /* synthetic */ PreviewCache a;
    public final /* synthetic */ ConcurrentHashMap<String, ArrayList<String>> b;

    @Override // tcb.a
    public final Boolean a() {
        ConcurrentHashMap<tya.a, Object> r0 = this.a.e;
        ConcurrentHashMap<String, ArrayList<String>> r1 = this.b;
        Iterator<Map.Entry<tya.a, Object>> r2 = r0.entrySet().iterator();
    L4:
        if (r2.hasNext() == false) goto L7;
        r2.next().getKey().a(r1);
        goto L4
    L7:
        return Boolean.TRUE;
    }

    public v0(PreviewCache r1, ConcurrentHashMap<String, ArrayList<String>> r2) {
        this.a = r1;
        this.b = r2;
    }
}
