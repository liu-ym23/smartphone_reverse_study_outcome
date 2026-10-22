package com.lynx.tasm.common;

import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a implements Map.Entry<Object, Object> {
    public final /* synthetic */ Map.Entry a;

    @Override // java.util.Map.Entry
    public final Object getKey() {
        Object r0 = this.a.getKey();
        if (r0 != NullableConcurrentHashMap.access$000()) goto L6;
        return null;
    L6:
        return r0;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        Object r0 = this.a.getValue();
        if (r0 != NullableConcurrentHashMap.access$000()) goto L6;
        return null;
    L6:
        return r0;
    }

    public a(Map.Entry r1) {
        this.a = r1;
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object r2) {
        Map.Entry r0 = this.a;
        if (r2 != null) goto L6;
        r2 = NullableConcurrentHashMap.access$000();
    L6:
        return r0.setValue(r2);
    }
}
