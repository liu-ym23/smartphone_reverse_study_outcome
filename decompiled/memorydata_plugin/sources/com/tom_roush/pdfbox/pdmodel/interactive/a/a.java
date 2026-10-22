package com.tom_roush.pdfbox.pdmodel.interactive.a;

import com.tom_roush.pdfbox.b.b;
import java.io.Closeable;

/* JADX INFO: loaded from: classes6.dex */
public class a implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private b f16288a;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        b r0 = this.f16288a;
        if (r0 != null) goto L11;
        return;
    L11:
        r0.close();     // Catch: Throwable -> L7
        this.f16288a = null;
        return;
    L7:
        th = move-exception;
        this.f16288a = null;
        throw th;
    }
}
