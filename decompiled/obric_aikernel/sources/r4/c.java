package r4;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public final class c implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<a> f12659a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final byte[] f12660b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f12661c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f12662d;

    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final f f12663a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f12664b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f12665c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final boolean f12666d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final String f12667e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private byte[] f12668f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private byte[] f12669g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private boolean f12670h;

        public a(String r10, String r11, f r12, String r13, boolean r14) {
            this.f12664b = r10;
            this.f12665c = r11;
            this.f12663a = r12;
            this.f12666d = r14;
            this.f12667e = r13;
        }

        private void a() {
            if (this.f12670h == false) goto L5;
            return;
        L5:
            this.f12668f = c.c(this.f12667e, this.f12666d, false);
            this.f12669g = c.e(this.f12664b, this.f12665c, this.f12663a);
            this.f12670h = true;
        }

        public long b() {
            a();
            if (this.f12663a.length() > (-1)) goto L5;
            return -1;
        L5:
            return (this.f12663a.length() + ((long) this.f12668f.length)) + ((long) this.f12669g.length);
        }

        public void c(OutputStream r10) {
            a();
            r10.write(this.f12668f);
            r10.write(this.f12669g);
            this.f12663a.writeTo(r10);
        }
    }

    public c() {
        this(UUID.randomUUID().toString());
    }

    c(String r10) {
        this.f12659a = new LinkedList();
        this.f12661c = r10;
        byte[] r11 = h(r10, false, true);
        this.f12660b = r11;
        this.f12662d = r11.length;
    }

    static /* synthetic */ byte[] c(String r10, boolean r11, boolean r12) {
        return h(r10, r11, r12);
    }

    static /* synthetic */ byte[] e(String r10, String r11, f r12) {
        return i(r10, r11, r12);
    }

    private static byte[] h(String r10, boolean r11, boolean r12) {
        StringBuilder r13 = new StringBuilder(r10.length() + 8);     // Catch: IOException -> L12
        if (r11 == true) goto L7;
        r13.append("\r\n");     // Catch: IOException -> L12
    L7:
        r13.append("--");     // Catch: IOException -> L12
        r13.append(r10);     // Catch: IOException -> L12
        if (r12 == false) goto L10;
        r13.append("--");     // Catch: IOException -> L12
    L10:
        r13.append("\r\n");     // Catch: IOException -> L12
        return r13.toString().getBytes("UTF-8");
    L12:
        e = move-exception;
        throw new RuntimeException("Unable to write multipart boundary", e);
    }

    private static byte[] i(String r10, String r11, f r12) {
        StringBuilder r13 = new StringBuilder(128);     // Catch: IOException -> L10
        r13.append("Content-Disposition: form-data; name=\"");     // Catch: IOException -> L10
        r13.append(r10);     // Catch: IOException -> L10
        String r14 = r12.b();     // Catch: IOException -> L10
        if (r14 == null) goto L5;
        r13.append("\"; filename=\"");     // Catch: IOException -> L10
        r13.append(r14);     // Catch: IOException -> L10
    L5:
        r13.append("\"\r\nContent-Type: ");     // Catch: IOException -> L10
        r13.append(r12.a());     // Catch: IOException -> L10
        long r15 = r12.length();     // Catch: IOException -> L10
        if (r15 == (-1)) goto L8;
        r13.append("\r\nContent-Length: ");     // Catch: IOException -> L10
        r13.append(r15);     // Catch: IOException -> L10
    L8:
        r13.append("\r\nContent-Transfer-Encoding: ");     // Catch: IOException -> L10
        r13.append(r11);     // Catch: IOException -> L10
        r13.append("\r\n\r\n");     // Catch: IOException -> L10
        return r13.toString().getBytes("UTF-8");
    L10:
        e = move-exception;
        throw new RuntimeException("Unable to write multipart header", e);
    }

    @Override // r4.f
    public String a() {
        return "multipart/form-data; boundary=" + this.f12661c;
    }

    @Override // r4.f
    public String b() {
        return null;
    }

    @Override // r4.f
    public String d() {
        if (this.f12662d != (-1)) goto L31;
        return null;
    L31:
        ByteArrayOutputStream r10 = new ByteArrayOutputStream();     // Catch: Throwable -> L12
        writeTo(r10);     // Catch: Throwable -> L11
        ByteArrayInputStream r11 = new ByteArrayInputStream(r10.toByteArray());     // Catch: Throwable -> L11
        String r12 = r4.a.b(r11);     // Catch: Throwable -> L20
        r10.close();     // Catch: Throwable -> L18
    L27:
        r11.close();     // Catch: Throwable -> L19
    L10:
        return r12;
    L13:
        if (r10 != null) goto L35;
    L15:
        if (r11 != null) goto L25;
    L17:
        return null;
    L25:
        r11.close();     // Catch: Throwable -> L22
        goto L17
    L35:
        r10.close();     // Catch: Throwable -> L21
    L11:
        r11 = null;
    L12:
        r11 = null;
        r10 = null;
        goto L13
    }

    public void f(String r10, String r11, f r12) {
        Objects.requireNonNull(r10, "Part name must not be null.");
        Objects.requireNonNull(r11, "Transfer encoding must not be null.");
        Objects.requireNonNull(r12, "Part body must not be null.");
        a r13 = new a(r10, r11, r12, this.f12661c, this.f12659a.isEmpty());
        this.f12659a.add(r13);
        long r14 = r13.b();
        if (r14 != (-1)) goto L5;
        this.f12662d = -1;
        return;
    L5:
        long r15 = this.f12662d;
        if (r15 == (-1)) goto L10;
        this.f12662d = r15 + r14;
        return;
    }

    public void g(String r10, f r11) {
        f(r10, "binary", r11);
    }

    public int j() {
        return this.f12659a.size();
    }

    @Override // r4.f
    public long length() {
        return this.f12662d;
    }

    @Override // r4.f
    public void writeTo(OutputStream r10) {
        Iterator<a> r11 = this.f12659a.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r11.next().c(r10);
        goto L4
    L6:
        r10.write(this.f12660b);
    }
}
