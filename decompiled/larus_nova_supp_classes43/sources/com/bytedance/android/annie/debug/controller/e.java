package com.bytedance.android.annie.debug.controller;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class e {
    public final Context a;
    public final f b;
    public final String c;

    public e(Context r10, f r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "panel");
        Intrinsics.checkNotNullParameter(r12, "bizKey");
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "panel");
        this.a = r10;
        this.b = r11;
        this.c = "host";
        this.c = r12;
    }
}
