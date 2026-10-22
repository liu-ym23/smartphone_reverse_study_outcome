package org.bouncycastle.est;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes7.dex */
public class ESTException extends IOException {
    private static final long MAX_ERROR_BODY = 8192;
    private InputStream body;
    private Throwable cause;
    private int statusCode;

    public ESTException(String r2) {
        this(r2, null);
    }

    public ESTException(String r1, Throwable r2) {
        super(r1);
        this.cause = r2;
        this.body = null;
        this.statusCode = 0;
    }

    public ESTException(String r6, Throwable r7, int r8, InputStream r9) {
        super(r6);
        this.cause = r7;
        this.statusCode = r8;
        if (r9 == null) goto L13;
        byte[] r10 = new byte[8192];
        ByteArrayOutputStream r11 = new ByteArrayOutputStream();
    L16:
        int r0 = r9.read(r10);     // Catch: Exception -> L15
        if (r0 < 0) goto L11;
        if ((r11.size() + r0) > 8192) goto L9;
        r11.write(r10, 0, r0);     // Catch: Exception -> L15
        goto L16
    L9:
        r11.write(r10, 0, 8192 - r11.size());     // Catch: Exception -> L15
    L11:
        r11.flush();     // Catch: Exception -> L15
        r11.close();     // Catch: Exception -> L15
        this.body = new ByteArrayInputStream(r11.toByteArray());     // Catch: Exception -> L15
        r9.close();     // Catch: Exception -> L15
        return;
    L21:
        return;
    L13:
        this.body = null;
    }

    public InputStream getBody() {
        InputStream r0 = this.body;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return new AnonymousClass1(this);
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.cause;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return super.getMessage() + " HTTP Status Code: " + this.statusCode;
    }

    public int getStatusCode() {
        return this.statusCode;
    }
}
