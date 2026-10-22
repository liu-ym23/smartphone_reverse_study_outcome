package ai;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f172b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f173c = null;
    public static final a d = null;
    public static final a e = null;
    public static final a f = null;
    public static final a g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f174h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final a f175i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final a f176j = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f177a;

    static {
        f172b = new a(0);
        f173c = new a(1);
        d = new a(2);
        e = new a(3);
        f = new a(4);
        g = new a(5);
        f174h = new a(6);
        f175i = new a(7);
        f176j = new a(8);
    }

    public /* synthetic */ a(int r5) {
        this.f177a = r5;
    }

    @Override // ai.i
    public final Object convert(Object r10) {
        switch(this.f177a) {
            case 0: goto L25;
            case 1: goto L24;
            case 2: goto L52;
            case 3: goto L22;
            case 4: goto L20;
            case 5: goto L18;
            case 6: goto L8;
            case 7: goto L7;
            default: goto L4;
        };
    L4:
        ((fi.i) r10).c().close();
        return null;
    L8:
        fi.i r11 = (fi.i) r10;
        if ((r11 instanceof fi.g) == false) goto L15;
        String r5 = ((fi.g) r11).f16910a;
        if (r5 == null) goto L13;
        String r12 = fi.d.a(r5);
    L51:
        return new String(((fi.g) r11).f16911b, r12);
    L13:
        r12 = "UTF-8";
        goto L51
    L15:
        return null;
    L25:
        fi.i r13 = (fi.i) r10;
        if (r13 != null) goto L28;
        return r13;
    L28:
        if ((r13 instanceof fi.g) == true) goto L54;
        String r14 = r13.a();
        InputStream r15 = r13.c();
        ByteArrayOutputStream r16 = new ByteArrayOutputStream();     // Catch: Throwable -> L38
        byte[] r17 = new byte[4096];     // Catch: Throwable -> L38
    L32:
        int r18 = r15.read(r17);     // Catch: Throwable -> L38
        if (r18 == (-1)) goto L35;
        r16.write(r17, 0, r18);     // Catch: Throwable -> L38
        goto L32
    L35:
        fi.g r19 = new fi.g(r14, r16.toByteArray(), new String[0]);     // Catch: Throwable -> L38
        r15.close();     // Catch: IOException -> L42
    L53:
        return r19;
    L38:
        th = move-exception;
        r15.close();     // Catch: IOException -> L43
    L40:
        throw th;
    L54:
        return r13;
    L52:
        return r10;
    L7:
        return String.valueOf(r10);
    L18:
        return (String) r10;
    L20:
        return (fi.i) r10;
    L22:
        return (fi.j) r10;
    L24:
        return (bi.c) r10;
    }
}
