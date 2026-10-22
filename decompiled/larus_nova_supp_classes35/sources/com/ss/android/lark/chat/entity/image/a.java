package com.ss.android.lark.chat.entity.image;

import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a {
    static {
    }

    @JvmStatic
    public static final boolean a(ImageSet r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r1.getResourceCleanScene() == null) goto L6;
        return true;
    L6:
        return r1.resourceIsCleaned;
    }
}
