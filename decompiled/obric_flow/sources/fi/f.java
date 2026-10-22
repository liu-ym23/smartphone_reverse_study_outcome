package fi;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
public final class f implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedList f16907a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f16908b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f16909c;
    public long d;

    public f() {
        String r5 = UUID.randomUUID().toString();
        this.f16907a = new LinkedList();
        this.f16909c = r5;
        byte[] r10 = e(r5, false, true);
        this.f16908b = r10;
        this.d = r10.length;
    }

    public static byte[] e(String r5, boolean r10, boolean r11) {
        StringBuilder r12 = new StringBuilder(r5.length() + 8);     // Catch: IOException -> L7
        if (r10 == true) goto L9;
        r12.append("\r\n");     // Catch: IOException -> L7
    L9:
        r12.append("--");     // Catch: IOException -> L7
        r12.append(r5);     // Catch: IOException -> L7
        if (r11 == false) goto L12;
        r12.append("--");     // Catch: IOException -> L7
    L12:
        r12.append("\r\n");     // Catch: IOException -> L7
        return r12.toString().getBytes("UTF-8");
    L7:
        e = move-exception;
        throw new RuntimeException("Unable to write multipart boundary", e);
    }

    @Override // fi.j
    public final String a() {
        return "multipart/form-data; boundary=" + this.f16909c;
    }

    @Override // fi.j
    public final String b() {
        return null;
    }

    public final void c(String r10, String r11, j r12) {
        if (r10 == null) goto L21;
        if (r11 == null) goto L19;
        if (r12 == null) goto L17;
        LinkedList r13 = this.f16907a;
        e r14 = new e(r10, r11, r12, this.f16909c, r13.isEmpty());
        r13.add(r14);
        r14.a();
        if (r12.length() <= (-1)) goto L8;
        long r15 = (r12.length() + ((long) r14.f.length)) + ((long) r14.g.length);
    L10:
        if (r15 != (-1)) goto L12;
        this.d = -1;
        return;
    L12:
        long r5 = this.d;
        if (r5 == (-1)) goto L23;
        this.d = r5 + r15;
        return;
    L23:
        return;
    L8:
        r15 = -1;
        goto L10
    L17:
        throw new NullPointerException("Part body must not be null.");
    L19:
        throw new NullPointerException("Transfer encoding must not be null.");
    L21:
        throw new NullPointerException("Part name must not be null.");
    }

    @Override // fi.j
    public final String d() {
        String r5 = null;
        if (this.d != (-1)) goto L33;
        return null;
    L33:
        ByteArrayOutputStream r10 = new ByteArrayOutputStream();     // Catch: Throwable -> L16
        writeTo(r10);     // Catch: Throwable -> L23
        ByteArrayInputStream r11 = new ByteArrayInputStream(r10.toByteArray());     // Catch: Throwable -> L23
        MessageDigest r12 = MessageDigest.getInstance("MD5");     // Catch: Throwable -> L20
        byte[] r13 = new byte[1024];     // Catch: Throwable -> L20
        int r14 = r11.read(r13, 0, 1024);     // Catch: Throwable -> L20
    L9:
        if (r14 <= (-1)) goto L11;
        r12.update(r13, 0, r14);     // Catch: Throwable -> L20
        r14 = r11.read(r13, 0, 1024);     // Catch: Throwable -> L20
        goto L9
    L11:
        r5 = new String(b.a(r12.digest(), b.f16900a));     // Catch: Throwable -> L20
    L29:
        r10.close();     // Catch: Throwable -> L21
    L31:
        r11.close();     // Catch: Throwable -> L22
    L15:
        return r5;
    L17:
        if (r10 != null) goto L25;
    L19:
        return null;
    L25:
        r10.close();     // Catch: Throwable -> L24
    L16:
        r10 = null;
        goto L17
    }

    @Override // fi.j
    public final long length() {
        return this.d;
    }

    @Override // fi.j
    public final void writeTo(OutputStream r5) {
        Iterator r10 = this.f16907a.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        e r11 = (e) r10.next();
        r11.a();
        r5.write(r11.f);
        r5.write(r11.g);
        r11.f16903a.writeTo(r5);
        goto L4
    L6:
        r5.write(this.f16908b);
    }
}
