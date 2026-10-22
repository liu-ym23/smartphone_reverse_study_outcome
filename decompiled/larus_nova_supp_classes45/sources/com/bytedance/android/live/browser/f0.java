package com.bytedance.android.live.browser;

import kotlin.collections.AbstractList;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class f0 extends AbstractList<Object> {
    public final int a;
    public final JSONArray b;

    public final int getSize() {
        return this.a;
    }

    public f0(JSONArray r2) {
        Intrinsics.checkNotNullParameter(r2, "delegate");
        this.b = r2;
        this.a = r2.length();
    }

    public final Object get(int r2) {
        Object r3 = this.b.opt(r2);
        if (r3 != null) goto L7;
        return null;
    L7:
        return UtilsKt.a(r3);
    }
}
