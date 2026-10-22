package com.bytedance.android.live.core.utils;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class u1 implements com.bytedance.android.tools.superkv.e {
    public final SharedPreferences a;

    public final List b() {
        Intrinsics.checkNotNullParameter("__prefetch_cache_key_array", "key");
        if (this.a.contains("__prefetch_cache_key_array") == false) goto L7;
        Set<String> r0 = this.a.getStringSet("__prefetch_cache_key_array", SetsKt.emptySet());
        if (r0 == null) goto L7;
        return CollectionsKt.toMutableList(r0);
    L7:
        return null;
    }

    public final void a(Collection r3) {
        Intrinsics.checkNotNullParameter("__prefetch_cache_key_array", "key");
        Intrinsics.checkNotNullParameter(r3, "value");
        this.a.edit().putStringSet("__prefetch_cache_key_array", CollectionsKt.toSet(r3)).apply();
    }

    public final String getString(String r3) {
        Intrinsics.checkNotNullParameter(r3, "key");
        if (this.a.contains(r3) == true) goto L5;
        return null;
    L5:
        return this.a.getString(r3, "");
    }

    public final void remove(String r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        this.a.edit().remove(r2).apply();
    }

    public u1(Context r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "key");
        this.a = r2.getSharedPreferences(r3, 0);
    }

    public final void putString(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "value");
        this.a.edit().putString(r2, r3).apply();
    }
}
