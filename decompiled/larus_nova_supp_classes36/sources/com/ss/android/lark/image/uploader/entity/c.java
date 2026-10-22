package com.ss.android.lark.image.uploader.entity;

import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c {
    public final String a;
    public List<String> b;
    public final Map<String, Integer> c;

    public c(String r2) {
        Intrinsics.checkNotNullParameter(r2, "uploadToken");
        this.a = r2;
        this.b = CollectionsKt.emptyList();
        this.c = MapsKt.emptyMap();
    }
}
