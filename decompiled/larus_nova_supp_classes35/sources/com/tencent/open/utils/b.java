package com.tencent.open.utils;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.ProtocolException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Properties;
import java.util.zip.ZipException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b {
    private static final n a = null;
    private static final o b = null;

    /* JADX INFO: renamed from: com.tencent.open.utils.b$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class a {
        Properties a;
        byte[] b;

        public String toString() {
            return "ApkExternalInfo [p=" + this.a + ", otherData=" + Arrays.toString(this.b) + "]";
        }

        private a() {
            this.a = new Properties();
        }

        public /* synthetic */ a(AnonymousClass1 r1) {
            this();
        }

        public void a(byte[] r8) throws IOException {
            if (r8 != null) goto L4;
            return;
        L4:
            ByteBuffer r0 = ByteBuffer.wrap(r8);
            int r1 = b.a().a().length;
            byte[] r2 = new byte[r1];
            r0.get(r2);
            if (b.a().equals(new o(r2)) == false) goto L17;
            if ((r8.length - r1) > 2) goto L9;
            return;
        L9:
            byte[] r3 = new byte[2];
            r0.get(r3);
            int r4 = new o(r3).b();
            if (((r8.length - r1) - 2) >= r4) goto L12;
            return;
        L12:
            byte[] r5 = new byte[r4];
            r0.get(r5);
            this.a.load(new ByteArrayInputStream(r5));
            int r9 = ((r8.length - r1) - r4) - 2;
            if (r9 <= 0) goto L18;
            byte[] r10 = new byte[r9];
            this.b = r10;
            r0.get(r10);
            return;
        L18:
            return;
        L17:
            throw new ProtocolException("unknow protocl [" + Arrays.toString(r8) + "]");
        }
    }

    static {
        a = new n(101010256);
        b = new o(38651);
    }

    public static /* synthetic */ o a() {
        return b;
    }

    private static byte[] a(RandomAccessFile r7) throws IOException {
        long r0 = r7.length() - 22;
        r7.seek(r0);
        byte[] r2 = a.a();
        int r3 = r7.read();
    L3:
        boolean r6 = false;
        if (r3 == (-1)) goto L15;
        if (r3 != r2[0]) goto L14;
        r6 = true;
        if (r7.read() != r2[1]) goto L14;
        if (r7.read() != r2[2]) goto L14;
        if (r7.read() == r2[3]) goto L15;
    L14:
        r0 = r0 - 1;
        r7.seek(r0);
        r3 = r7.read();
    L15:
        if (r6 == false) goto L23;
        r7.seek((r0 + 16) + 4);
        byte[] r1 = new byte[2];
        r7.readFully(r1);
        int r4 = new o(r1).b();
        if (r4 != 0) goto L20;
        return null;
    L20:
        byte[] r5 = new byte[r4];
        r7.read(r5);
        return r5;
    L23:
        throw new ZipException("archive is not a ZIP archive");
    }

    public static String a(File r1) throws IOException {
        return a(r1, "channelNo");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static String a(File r3, String r4) throws IOException {
        RandomAccessFile r0 = null;
        Object[] r1 = 0;
        RandomAccessFile r2 = new RandomAccessFile(r3, "r");     // Catch: Throwable -> L13
        byte[] r5 = a(r2);     // Catch: Throwable -> L11
        if (r5 != null) goto L8;
        r2.close();
        return null;
    L8:
        a r6 = new a(r1 == true ? 1 : 0);     // Catch: Throwable -> L11
        r6.a(r5);     // Catch: Throwable -> L11
        String r7 = r6.a.getProperty(r4);     // Catch: Throwable -> L11
        r2.close();
        return r7;
    L11:
        th = th;
        r0 = r2;
    L14:
        if (r0 == null) goto L16;
        r0.close();
    L16:
        throw th;
    L13:
        th = th;
        goto L14
    }
}
