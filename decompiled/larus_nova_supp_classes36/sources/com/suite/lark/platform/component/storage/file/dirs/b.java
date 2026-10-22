package com.suite.lark.platform.component.storage.file.dirs;

import android.content.Context;
import kotlin.Deprecated;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Deprecated(message = " temporary using, may refactor in the future")
public final class b {

    public static final class a {
    }

    static {
    }

    @JvmStatic
    public static final String a(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r4, "context");
        String r5 = com.ss.android.lark.storage.f.f.a(r4, "databases");
        if (StringsKt.endsWith$default(r5, "/", false, 2, null) == true) goto L7;
        r5 = r5 + '/';
    L7:
        return c.a(r5, "");
    }
}
