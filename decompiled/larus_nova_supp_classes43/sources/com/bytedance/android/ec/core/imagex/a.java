package com.bytedance.android.ec.core.imagex;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public final String a;
    public final String b;
    public final String c;
    public final Map<String, String> d;

    public a(String r10, String r11, String r12, Map<String, String> r13) {
        Intrinsics.checkNotNullParameter(r10, "cleanUrl");
        Intrinsics.checkNotNullParameter(r11, "sceneTag");
        Intrinsics.checkNotNullParameter(r13, "extraMap");
        this.a = r10;
        this.b = r11;
        this.c = r12;
        this.d = r13;
    }
}
