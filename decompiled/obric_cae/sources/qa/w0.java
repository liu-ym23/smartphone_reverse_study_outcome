package qa;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class w0 extends c1 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ByteArrayOutputStream f11172c;

    public w0(a1 r8) {
        super(r8);
        this.f11172c = new ByteArrayOutputStream();
    }

    @Override // qa.c1
    public final byte[] b(byte[] r8) {
        byte[] r10 = this.f11172c.toByteArray();
        this.f11172c.close();     // Catch: IOException -> L5
    L7:
        this.f11172c = new ByteArrayOutputStream();
        return r10;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    @Override // qa.c1
    public final void c(byte[] r8) {
        this.f11172c.write(r8);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }
}
