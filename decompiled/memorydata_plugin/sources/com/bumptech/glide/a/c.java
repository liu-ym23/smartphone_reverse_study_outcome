package com.bumptech.glide.a;

import com.bytedance.rpc.internal.RpcUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes.dex */
final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final Charset f516a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final Charset f517b = null;

    static {
        f516a = Charset.forName("US-ASCII");
        f517b = Charset.forName(RpcUtils.CHARSET_UTF8);
    }

    static void a(Closeable r2) {
        Closeable r3 = (Closeable) ZeusTransformUtils.wrapperContextForParams(r2, Closeable.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L10;
        return;
    L10:
        r3.close();     // Catch: RuntimeException -> L6 Exception -> L9
        goto L13
    L12:
        return;
    L6:
        e = move-exception;
        throw e;
    }

    static void a(File r4) {
        File[] r0 = r4.listFiles();
        if (r0 == null) goto L16;
        int r5 = r0.length;
        int r1 = 0;
    L5:
        if (r1 >= r5) goto L14;
        File r2 = r0[r1];
        if (r2.isDirectory() == false) goto L10;
        a(r2);
    L10:
        if (r2.delete() == false) goto L13;
        r1 = r1 + 1;
        goto L5
    L13:
        throw new IOException("failed to delete file: " + r2);
    L14:
        return;
    L16:
        throw new IOException("not a readable directory: " + r4);
    }
}
