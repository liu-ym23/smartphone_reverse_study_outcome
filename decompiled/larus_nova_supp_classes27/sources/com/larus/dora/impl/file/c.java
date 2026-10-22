package com.larus.dora.impl.file;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.security.MessageDigest;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import okio.Source;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class c {
    public static final String a(PolarisFileWrapper r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        int r0 = okio.s.c;
        Source r4 = Okio.source(r3);
        Intrinsics.checkNotNullParameter(r4, "source");
        Intrinsics.checkNotNullParameter(r4, "source");
        Intrinsics.checkNotNullParameter("MD5", "algorithm");
        okio.s r1 = new okio.s(r4, MessageDigest.getInstance("MD5"));
        BufferedSource r5 = Okio.buffer(r1);
        r5.readAll(Okio.blackhole());     // Catch: Throwable -> L10
        CloseableKt.closeFinally(r5, null);
        MessageDigest r6 = r1.a;
        if (r6 == null) goto L8;
        byte[] r7 = r6.digest();
        Intrinsics.checkNotNull(r7);
        return new ByteString(r7).hex();
    L8:
        Intrinsics.checkNotNull(null);
        throw null;
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        CloseableKt.closeFinally(r5, th);
        throw th;
    }
}
