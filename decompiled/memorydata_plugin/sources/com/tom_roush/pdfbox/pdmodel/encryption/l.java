package com.tom_roush.pdfbox.pdmodel.encryption;

import android.util.Log;
import com.bytedance.crypto.utils.CryptoConst;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes6.dex */
public abstract class l {
    private static final byte[] c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected short f16207a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected byte[] f16208b;
    private final j d;
    private boolean e;
    private SecureRandom f;
    private final Set<com.tom_roush.pdfbox.a.b> g;
    private boolean h;
    private f i;
    private a j;
    private com.tom_roush.pdfbox.a.i k;
    private com.tom_roush.pdfbox.a.i l;

    static {
        c = new byte[]{115, 65, 108, 84};
    }

    public l() {
        this.f16207a = 40;
        this.d = new j();
        this.g = Collections.newSetFromMap(new IdentityHashMap());
        this.i = null;
        this.j = null;
    }

    private Cipher a(byte[] r3, byte[] r4, boolean r5) {
        Cipher r2 = Cipher.getInstance("AES/CBC/PKCS5Padding");
        SecretKeySpec r0 = new SecretKeySpec(r3, CryptoConst.ALGORITHM_AES);
        IvParameterSpec r6 = new IvParameterSpec(r4);
        if (r5 == false) goto L5;
        int r7 = 2;
    L6:
        r2.init(r7, r0, r6);
        return r2;
    L5:
        r7 = 1;
        goto L6
    }

    private void a(long r3, long r5, InputStream r7, OutputStream r8, boolean r9) {
        if (this.h == true) goto L5;
    L7:
        byte[] r4 = a(r3, r5);
        if (this.h == false) goto L10;
        a(r4, r7, r8, r9);
    L11:
        r8.flush();
        return;
    L10:
        a(r4, r7, r8);
        goto L11
    L5:
        if (this.f16208b.length != 32) goto L7;
        a(r7, r8, r9);
        goto L11
    }

    private void a(com.tom_roush.pdfbox.a.a r9, long r10, long r12) {
        int r0 = 0;
    L4:
        if (r0 >= r9.b()) goto L6;
        a(r9.b(r0), r10, r12);
        r0 = r0 + 1;
        goto L4
    }

    private void a(com.tom_roush.pdfbox.a.d r9, long r10, long r12) {
        if (r9.l(com.tom_roush.pdfbox.a.i.az) == null) goto L5;
        return;
    L5:
        com.tom_roush.pdfbox.a.b r0 = r9.a(com.tom_roush.pdfbox.a.i.iz);
        if (com.tom_roush.pdfbox.a.i.hp.equals(r0) == false) goto L8;
    L15:
        boolean r1 = true;
    L16:
        Iterator<Map.Entry<com.tom_roush.pdfbox.a.i, com.tom_roush.pdfbox.a.b>> r11 = r9.d().iterator();
    L18:
        if (r11.hasNext() == false) goto L31;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r11.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        if (r1 == false) goto L24;
        if (com.tom_roush.pdfbox.a.i.bi.equals(r2.getKey()) == true) goto L18;
    L24:
        com.tom_roush.pdfbox.a.b r3 = (com.tom_roush.pdfbox.a.b) ZeusTransformUtils.preCheckCast(r2.getValue(), com.tom_roush.pdfbox.a.b.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r3, com.tom_roush.pdfbox.a.o.class) == true) goto L30;
        if (ZeusTransformUtils.instanceOf(r3, com.tom_roush.pdfbox.a.a.class) == true) goto L30;
        if (ZeusTransformUtils.instanceOf(r3, com.tom_roush.pdfbox.a.d.class) == false) goto L18;
    L30:
        a(r3, r10, r12);
        goto L18
    L31:
        return;
    L8:
        if (com.tom_roush.pdfbox.a.i.cd.equals(r0) == true) goto L15;
        if (ZeusTransformUtils.instanceOf(r9.a(com.tom_roush.pdfbox.a.i.bi), com.tom_roush.pdfbox.a.o.class) == true) goto L12;
    L14:
        r1 = false;
        goto L16
    L12:
        if (ZeusTransformUtils.instanceOf(r9.a(com.tom_roush.pdfbox.a.i.ak), com.tom_roush.pdfbox.a.a.class) == false) goto L14;
        goto L14
    }

    private void a(com.tom_roush.pdfbox.a.o r10, long r11, long r13) {
        if (com.tom_roush.pdfbox.a.i.dL.equals(this.l) == false) goto L5;
        return;
    L5:
        InputStream r6 = new ByteArrayInputStream(r10.b());
        ByteArrayOutputStream r0 = new ByteArrayOutputStream();
        a(r11, r13, r6, r0, true);     // Catch: IOException -> L8
        r10.a(r0.toByteArray());     // Catch: IOException -> L8
        return;
    L8:
        e = move-exception;
        Log.e("PdfBox-Android", "Failed to decrypt COSString of length " + r10.b().length + " in object " + r11 + ": " + e.getMessage());
    }

    private void a(InputStream r3, OutputStream r4, boolean r5) {
        byte[] r0 = new byte[16];
        if (a(r5, r0, r3, r4) == true) goto L24;
        return;
    L24:
        CipherInputStream r6 = new CipherInputStream(r3, a(this.f16208b, r0, r5));
        com.tom_roush.pdfbox.io.a.a(r6, r4);     // Catch: Throwable -> L9 IOException -> L11
    L8:
        r6.close();
        return;
    L11:
        e = move-exception;
        if (ZeusTransformUtils.instanceOf(e.getCause(), GeneralSecurityException.class) == false) goto L16;
        Log.d("PdfBox-Android", "A GeneralSecurityException occurred when decrypting some stream data", e);     // Catch: Throwable -> L9
        goto L8
    L16:
        throw e;     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        r6.close();
        throw th;
    L19:
        e = move-exception;
        throw new IOException(e);
    }

    private void a(byte[] r3, InputStream r4, OutputStream r5, boolean r6) {
        byte[] r0 = new byte[16];
        if (a(r6, r0, r4, r5) == true) goto L16;
        return;
    L16:
        Cipher r2 = a(r3, r0, r6);     // Catch: GeneralSecurityException -> L13
        byte[] r7 = new byte[256];     // Catch: GeneralSecurityException -> L13
    L6:
        int r8 = r4.read(r7);     // Catch: GeneralSecurityException -> L13
        if (r8 == (-1)) goto L11;
        byte[] r9 = r2.update(r7, 0, r8);     // Catch: GeneralSecurityException -> L13
        if (r9 == null) goto L6;
        r5.write(r9);     // Catch: GeneralSecurityException -> L13
        goto L6
    L11:
        r5.write(r2.doFinal());     // Catch: GeneralSecurityException -> L13
        return;
    L13:
        e = move-exception;
        throw new IOException(e);
    }

    private boolean a(boolean r1, byte[] r2, InputStream r3, OutputStream r4) {
        if (r1 == false) goto L12;
        int r0 = (int) com.tom_roush.pdfbox.io.a.a(r3, r2);
        if (r0 != 0) goto L8;
        return false;
    L8:
        if (r0 != r2.length) goto L11;
        return true;
    L11:
        throw new IOException("AES initialization vector not fully read: only " + r0 + " bytes read instead of " + r2.length);
    L12:
        e().nextBytes(r2);
        r4.write(r2);
        return true;
    }

    private byte[] a(long r11, long r13) {
        byte[] r0 = this.f16208b;
        int r1 = r0.length + 5;
        byte[] r2 = new byte[r1];
        System.arraycopy(r0, 0, r2, 0, r0.length);
        r2[r1 - 5] = (byte) (r11 & 255);
        r2[r1 - 4] = (byte) ((r11 >> 8) & 255);
        r2[r1 - 3] = (byte) ((r11 >> 16) & 255);
        r2[r1 - 2] = (byte) (r13 & 255);
        r2[r1 - 1] = (byte) ((r13 >> 8) & 255);
        MessageDigest r12 = c.a();
        r12.update(r2);
        if (this.h == false) goto L5;
        r12.update(c);
    L5:
        byte[] r10 = r12.digest();
        int r14 = Math.min(r1, 16);
        byte[] r15 = new byte[r14];
        System.arraycopy(r10, 0, r15, 0, r14);
        return r15;
    }

    private SecureRandom e() {
        SecureRandom r0 = this.f;
        if (r0 == null) goto L6;
        return r0;
    L6:
        return new SecureRandom();
    }

    public void a(int r1) {
        this.f16207a = (short) r1;
    }

    public void a(com.tom_roush.pdfbox.a.b r7, long r8, long r10) {
        if (ZeusTransformUtils.instanceOf(r7, com.tom_roush.pdfbox.a.o.class) == false) goto L9;
        if (this.g.contains(r7) == false) goto L7;
        return;
    L7:
        this.g.add(r7);
        a((com.tom_roush.pdfbox.a.o) ZeusTransformUtils.preCheckCast(r7, com.tom_roush.pdfbox.a.o.class, "com.obric.memorydata.plugin"), r8, r10);
        return;
    L9:
        if (ZeusTransformUtils.instanceOf(r7, com.tom_roush.pdfbox.a.n.class) == false) goto L15;
        if (this.g.contains(r7) == false) goto L13;
        return;
    L13:
        this.g.add(r7);
        a((com.tom_roush.pdfbox.a.n) ZeusTransformUtils.preCheckCast(r7, com.tom_roush.pdfbox.a.n.class, "com.obric.memorydata.plugin"), r8, r10);
        return;
    L15:
        if (ZeusTransformUtils.instanceOf(r7, com.tom_roush.pdfbox.a.d.class) == false) goto L18;
        a((com.tom_roush.pdfbox.a.d) ZeusTransformUtils.preCheckCast(r7, com.tom_roush.pdfbox.a.d.class, "com.obric.memorydata.plugin"), r8, r10);
        return;
    L18:
        if (ZeusTransformUtils.instanceOf(r7, com.tom_roush.pdfbox.a.a.class) == false) goto L24;
        a((com.tom_roush.pdfbox.a.a) ZeusTransformUtils.preCheckCast(r7, com.tom_roush.pdfbox.a.a.class, "com.obric.memorydata.plugin"), r8, r10);
        return;
    }

    public void a(com.tom_roush.pdfbox.a.i r1) {
        this.l = r1;
    }

    public void a(com.tom_roush.pdfbox.a.n r11, long r12, long r14) {
        if (com.tom_roush.pdfbox.a.i.dL.equals(this.k) == false) goto L5;
        return;
    L5:
        com.tom_roush.pdfbox.a.i r0 = r11.b(com.tom_roush.pdfbox.a.i.iz);
        if (this.e == true) goto L11;
        if (com.tom_roush.pdfbox.a.i.eY.equals(r0) == false) goto L11;
        return;
    L11:
        if (com.tom_roush.pdfbox.a.i.jj.equals(r0) == false) goto L14;
        return;
    L14:
        if (com.tom_roush.pdfbox.a.i.eY.equals(r0) == false) goto L19;
        InputStream r1 = r11.g();
        byte[] r2 = new byte[10];
        com.tom_roush.pdfbox.io.a.a(r1, r2);
        r1.close();
        if (Arrays.equals(r2, "<?xpacket ".getBytes(com.tom_roush.pdfbox.util.a.d)) == false) goto L19;
        Log.w("PdfBox-Android", "Metadata is not encrypted, but was expected to be");
        Log.w("PdfBox-Android", "Read PDF specification about EncryptMetadata (default value: true)");
        return;
    L19:
        a(r11, r12, r14);
        ByteArrayInputStream r7 = new ByteArrayInputStream(com.tom_roush.pdfbox.io.a.a(r11.g()));
        OutputStream r13 = r11.i();
        a(r12, r14, r7, r13, true);     // Catch: Throwable -> L23 IOException -> L25
        r13.close();
        return;
    L25:
        e = move-exception;
        Log.e("PdfBox-Android", e.getClass().getSimpleName() + " thrown when decrypting object " + r12 + " " + r14 + " obj");     // Catch: Throwable -> L23
        throw e;     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        r13.close();
        throw th;
    }

    public void a(a r1) {
        this.j = r1;
    }

    public abstract void a(e r1, com.tom_roush.pdfbox.a.a r2, b r3);

    public void a(f r1) {
        this.i = r1;
    }

    public void a(boolean r1) {
        this.e = r1;
    }

    public void a(byte[] r1) {
        this.f16208b = r1;
    }

    public void a(byte[] r2, InputStream r3, OutputStream r4) {
        this.d.a(r2);
        this.d.a(r3, r4);
    }

    public void a(byte[] r2, byte[] r3, OutputStream r4) {
        this.d.a(r2);
        this.d.a(r3, r4);
    }

    public boolean a() {
        return this.e;
    }

    public int b() {
        return this.f16207a;
    }

    public void b(com.tom_roush.pdfbox.a.i r1) {
        this.k = r1;
    }

    public void b(boolean r1) {
        this.h = r1;
    }

    public a c() {
        return this.j;
    }

    public byte[] d() {
        return this.f16208b;
    }
}
