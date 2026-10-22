package com.bytedance.crash.upload;

import java.io.DataOutputStream;

/* JADX INFO: loaded from: classes2.dex */
public final class i extends DataOutputStream {
    public final void b() {
        super.close();
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }
}
