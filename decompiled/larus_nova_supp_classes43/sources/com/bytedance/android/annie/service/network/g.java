package com.bytedance.android.annie.service.network;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class g {
    public final String a;
    public LinkedHashMap<String, String> b;
    public boolean c;
    public Map<String, String> d;
    public LinkedHashMap<String, File> e;

    public g(String r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
        this.a = r10;
    }
}
