package com.ss.android.lark.image.entity;

import com.ss.android.lark.maintab.export.TabAppInfo;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c {
    public final String a;
    public final File b;

    public c(String r2, File r3) {
        Intrinsics.checkNotNullParameter(r2, TabAppInfo.IMAGE_JSON_KEY);
        Intrinsics.checkNotNullParameter(r3, "file");
        this.a = r2;
        this.b = r3;
    }
}
