package com.larus.disk.impl;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class AppDiskManager$resolveMessageProtectedCachePaths$protectedPaths$2 extends FunctionReferenceImpl implements Function1<String, Boolean> {
    public static final AppDiskManager$resolveMessageProtectedCachePaths$protectedPaths$2 INSTANCE = null;

    static {
        INSTANCE = new AppDiskManager$resolveMessageProtectedCachePaths$protectedPaths$2();
    }

    public AppDiskManager$resolveMessageProtectedCachePaths$protectedPaths$2() {
        super(1, StringsKt.class, "isNotEmpty", "isNotEmpty(Ljava/lang/CharSequence;)Z", 1);
    }

    public final Boolean invoke(String r2) {
        Intrinsics.checkNotNullParameter(r2, "p0");
        if (r2.length() <= 0) goto L5;
        boolean r3 = true;
    L7:
        return Boolean.valueOf(r3);
    L5:
        r3 = false;
        goto L7
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((String) r1);
    }
}
