package fi;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j f16903a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f16904b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f16905c;
    public final boolean d;
    public final String e;
    public byte[] f;
    public byte[] g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f16906h;

    public e(String r5, String r10, j r11, String r12, boolean r13) {
        this.f16904b = r5;
        this.f16905c = r10;
        this.f16903a = r11;
        this.d = r13;
        this.e = r12;
    }

    public final void a() {
        if (this.f16906h == false) goto L5;
        return;
    L5:
        boolean r5 = this.d;
        this.f = f.e(this.e, r5, false);
        String r10 = this.f16904b;
        String r11 = this.f16905c;
        j r12 = this.f16903a;
        StringBuilder r13 = new StringBuilder(128);     // Catch: IOException -> L9
        r13.append("Content-Disposition: form-data; name=\"");     // Catch: IOException -> L9
        r13.append(r10);     // Catch: IOException -> L9
        String r14 = r12.b();     // Catch: IOException -> L9
        if (r14 == null) goto L11;
        r13.append("\"; filename=\"");     // Catch: IOException -> L9
        r13.append(r14);     // Catch: IOException -> L9
    L11:
        r13.append("\"\r\nContent-Type: ");     // Catch: IOException -> L9
        r13.append(r12.a());     // Catch: IOException -> L9
        long r15 = r12.length();     // Catch: IOException -> L9
        if (r15 == (-1)) goto L14;
        r13.append("\r\nContent-Length: ");     // Catch: IOException -> L9
        r13.append(r15);     // Catch: IOException -> L9
    L14:
        r13.append("\r\nContent-Transfer-Encoding: ");     // Catch: IOException -> L9
        r13.append(r11);     // Catch: IOException -> L9
        r13.append("\r\n\r\n");     // Catch: IOException -> L9
        this.g = r13.toString().getBytes("UTF-8");
        this.f16906h = true;
        return;
    L9:
        e = move-exception;
        throw new RuntimeException("Unable to write multipart header", e);
    }
}
