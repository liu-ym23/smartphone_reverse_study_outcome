package com.larus.uaigc.helper;

import java.util.Map;
import java.util.Set;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class i {
    public static final Set<String> a = null;

    static {
        a = SetsKt.setOf(new String[]{"jpg", "jpeg", "png", "webp", "heic", "heif"});
    }

    public static final Map a(CreationLocalDetectState r1) {
        return MapsKt.mapOf(TuplesKt.to("local_detect", r1.getValue()));
    }
}
