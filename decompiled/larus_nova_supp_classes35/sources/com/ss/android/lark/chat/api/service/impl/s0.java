package com.ss.android.lark.chat.api.service.impl;

import com.larksuite.framework.utils.AndroidThrottle;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class s0 implements AndroidThrottle.d<u0> {
    public final HashSet<u0> a;

    public final void clear() {
    }

    public final Collection a() {
        List r0 = CollectionsKt.toList(this.a);
        this.a.clear();
        return r0;
    }

    public final int size() {
        return this.a.size();
    }

    public s0() {
        this.a = new HashSet();
    }

    public final void put(Object r2) {
        u0 r3 = (u0) r2;
        if (r3 == null) goto L6;
        this.a.add(r3);
        return;
    }
}
