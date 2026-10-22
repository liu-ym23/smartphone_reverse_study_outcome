package com.larus.disk.impl;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class AppDiskManager$resolveMessageProtectedCachePaths$protectedPaths$1 extends FunctionReferenceImpl implements Function1<String, String> {
    public static final AppDiskManager$resolveMessageProtectedCachePaths$protectedPaths$1 INSTANCE = null;

    static {
        INSTANCE = new AppDiskManager$resolveMessageProtectedCachePaths$protectedPaths$1();
    }

    public AppDiskManager$resolveMessageProtectedCachePaths$protectedPaths$1() {
        super(1, StringsKt.class, "trim", "trim(Ljava/lang/String;)Ljava/lang/String;", 1);
    }

    public final String invoke(String r2) {
        Intrinsics.checkNotNullParameter(r2, "p0");
        return StringsKt.trim(r2).toString();
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((String) r1);
    }
}
