package com.larus.disk.impl.handler;

import com.larus.disk.impl.i0;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class ManagedCacheDirectoryHandler$4 extends FunctionReferenceImpl implements Function1<File, Long> {
    public ManagedCacheDirectoryHandler$4(Object r8) {
        super(1, r8, i0.class, "lastObservedAccessTimeMs", "lastObservedAccessTimeMs(Ljava/io/File;)Ljava/lang/Long;", 0);
    }

    public final Long invoke(File r2) {
        Intrinsics.checkNotNullParameter(r2, "p0");
        ((i0) ((CallableReference) this).receiver).getClass();
        return i0.c(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((File) r1);
    }
}
