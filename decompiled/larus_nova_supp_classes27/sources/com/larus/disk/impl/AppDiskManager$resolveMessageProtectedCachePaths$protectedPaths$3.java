package com.larus.disk.impl;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class AppDiskManager$resolveMessageProtectedCachePaths$protectedPaths$3 extends FunctionReferenceImpl implements Function1<String, File> {
    public static final AppDiskManager$resolveMessageProtectedCachePaths$protectedPaths$3 INSTANCE = null;

    static {
        INSTANCE = new AppDiskManager$resolveMessageProtectedCachePaths$protectedPaths$3();
    }

    public AppDiskManager$resolveMessageProtectedCachePaths$protectedPaths$3() {
        super(1, File.class, "<init>", "<init>(Ljava/lang/String;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((String) r1);
    }

    public final File invoke(String r2) {
        return new PolarisFileWrapper(r2);
    }
}
