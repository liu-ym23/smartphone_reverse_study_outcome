package r4;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class d implements e, f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f12671a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final File f12672b;

    public d(String r10, File r11) {
        if (r10 != null) goto L5;
        r10 = "application/octet-stream";
    L5:
        Objects.requireNonNull(r11, "file");
        this.f12671a = r10;
        this.f12672b = r11;
    }

    @Override // r4.e
    public String a() {
        return this.f12671a;
    }

    @Override // r4.f
    public String b() {
        return this.f12672b.getName();
    }

    @Override // r4.e
    public InputStream c() {
        return new FileInputStream(this.f12672b);
    }

    @Override // r4.f
    public String d() {
        return null;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof d) == true) goto L8;
        return false;
    L8:
        return this.f12672b.equals(((d) r10).f12672b);
    }

    public int hashCode() {
        return this.f12672b.hashCode();
    }

    @Override // r4.f
    public long length() {
        return this.f12672b.length();
    }

    public String toString() {
        return this.f12672b.getAbsolutePath() + " (" + a() + ")";
    }

    @Override // r4.f
    public void writeTo(OutputStream r10) {
        byte[] r11 = new byte[4096];
        FileInputStream r12 = new FileInputStream(this.f12672b);
    L12:
        int r13 = r12.read(r11);     // Catch: Throwable -> L9
        if (r13 == (-1)) goto L7;
        r10.write(r11, 0, r13);     // Catch: Throwable -> L9
        goto L12
    L7:
        r12.close();
        return;
    L9:
        th = move-exception;
        r12.close();
        throw th;
    }
}
