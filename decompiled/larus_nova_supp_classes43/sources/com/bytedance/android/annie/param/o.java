package com.bytedance.android.annie.param;

import kotlin.collections.AbstractList;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class o extends AbstractList<Object> {
    public final JSONArray a;
    public final int b;

    public final int getSize() {
        return this.b;
    }

    public o(JSONArray r10) {
        Intrinsics.checkNotNullParameter(r10, "delegate");
        this.a = r10;
        this.b = r10.length();
    }

    public final Object get(int r10) {
        Object r11 = this.a.opt(r10);
        if (r11 != null) goto L7;
        return null;
    L7:
        return UtilsKt.b(r11);
    }
}
