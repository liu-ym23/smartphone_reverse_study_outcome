package com.facebook.common.internal;

import com.facebook.infer.annotation.Nullsafe;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
@Nullsafe(Nullsafe.Mode.STRICT)
public abstract class Closeables {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Logger f7649a = null;

    static {
        f7649a = Logger.getLogger(Closeables.class.getName());
    }

    public static void a(Closeable r5) {
        if (r5 == null) goto L11;
        r5.close();     // Catch: IOException -> L6
        return;
    L6:
        e = move-exception;
        f7649a.log(Level.WARNING, "IOException thrown while closing Closeable.", e);
        return;
    }

    public static void a(InputStream r5) {
        a(r5);     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        throw new AssertionError(e);
    }
}
