package fi;

import ai.j0;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes2.dex */
public final class h implements i, j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f16913a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final File f16914b;

    public h(File r5) {
        this.f16913a = "application/octet-stream";
        this.f16914b = r5;
    }

    @Override // fi.i, fi.j
    public final String a() {
        return this.f16913a;
    }

    @Override // fi.j
    public final String b() {
        return this.f16914b.getName();
    }

    @Override // fi.i
    public final InputStream c() {
        return new FileInputStream(this.f16914b);
    }

    @Override // fi.j
    public final String d() {
        return null;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof h) == true) goto L8;
        return false;
    L8:
        return this.f16914b.equals(((h) r5).f16914b);
    }

    public final int hashCode() {
        return this.f16914b.hashCode();
    }

    @Override // fi.j
    public final long length() {
        return this.f16914b.length();
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder();
        r5.append(this.f16914b.getAbsolutePath());
        r5.append(" (");
        return j0.q(r5, this.f16913a, ")");
    }

    @Override // fi.j
    public final void writeTo(OutputStream r5) {
        byte[] r10 = new byte[4096];
        FileInputStream r11 = new FileInputStream(this.f16914b);
    L13:
        int r12 = r11.read(r10);     // Catch: Throwable -> L7
        if (r12 == (-1)) goto L9;
        r5.write(r10, 0, r12);     // Catch: Throwable -> L7
        goto L13
    L9:
        r11.close();
        return;
    L7:
        th = move-exception;
        r11.close();
        throw th;
    }
}
