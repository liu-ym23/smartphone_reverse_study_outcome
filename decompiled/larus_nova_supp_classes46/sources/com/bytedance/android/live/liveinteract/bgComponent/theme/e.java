package com.bytedance.android.live.liveinteract.bgComponent.theme;

import com.bytedance.retrofit2.mime.TypedOutput;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e implements TypedOutput {
    public final WeakReference<a> a;
    public long b;
    public long c;
    public final File d;
    public final String e;

    public interface a {
        void onProgress(long r1, long r3);
    }

    public final String md5Stub() {
        return null;
    }

    public final String fileName() {
        return this.d.getName();
    }

    public final long length() {
        return this.d.length();
    }

    public final String mimeType() {
        return this.e;
    }

    public final void writeTo(OutputStream r8) throws IOException {
        byte[] r0 = new byte[1024];
        PolarisFileInputStreamWrapper r1 = new PolarisFileInputStreamWrapper(this.d);
        this.c = length();
        this.b = 0;
    L14:
        int r2 = r1.read(r0);     // Catch: Throwable -> L11
        if (r2 == (-1)) goto L9;
        r8.write(r0, 0, r2);     // Catch: Throwable -> L11
        this.b += (long) r2;     // Catch: Throwable -> L11
        a r3 = this.a.get();     // Catch: Throwable -> L11
        if (r3 == null) goto L14;
        r3.onProgress(this.b, this.c);     // Catch: Throwable -> L11
        goto L14
    L9:
        r1.close();
        return;
    L11:
        th = move-exception;
        r1.close();
        throw th;
    }

    public e(j.f r3, PolarisFileWrapper r4) {
        this.b = 0;
        this.c = 0;
        this.a = new WeakReference(r3);
        this.d = r4;
        this.e = "multipart/form-data";
    }
}
