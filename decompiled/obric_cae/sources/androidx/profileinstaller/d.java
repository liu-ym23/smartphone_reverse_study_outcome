package androidx.profileinstaller;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.AssetFileDescriptor;
import android.os.Build;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o.b<b> f2226a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Object f2227b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static b f2228c;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f2229a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f2230b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f2231c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f2232d;

        public a(int r8, int r10, long r11, long r12) {
            this.f2229a = r8;
            this.f2230b = r10;
            this.f2231c = r11;
            this.f2232d = r12;
        }

        public static a a(File r10) {
            DataInputStream r8 = new DataInputStream(new FileInputStream(r10));
            a r11 = new a(r8.readInt(), r8.readInt(), r8.readLong(), r8.readLong());     // Catch: Throwable -> L6
            r8.close();
            return r11;
        L6:
            th = move-exception;
            r8.close();     // Catch: Throwable -> L9
        L11:
            throw th;
        L9:
            th = move-exception;
            th.addSuppressed(th);
            goto L11
        }

        public final void b(File r8) {
            r8.delete();
            DataOutputStream r10 = new DataOutputStream(new FileOutputStream(r8));
            r10.writeInt(this.f2229a);     // Catch: Throwable -> L6
            r10.writeInt(this.f2230b);     // Catch: Throwable -> L6
            r10.writeLong(this.f2231c);     // Catch: Throwable -> L6
            r10.writeLong(this.f2232d);     // Catch: Throwable -> L6
            r10.close();
            return;
        L6:
            th = move-exception;
            r10.close();     // Catch: Throwable -> L9
        L11:
            throw th;
        L9:
            th = move-exception;
            th.addSuppressed(th);
            goto L11
        }

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if (r8 != null) goto L8;
        L21:
            return false;
        L8:
            if ((r8 instanceof a) == false) goto L21;
            a r10 = (a) r8;
            if (this.f2230b != r10.f2230b) goto L20;
            if (this.f2231c != r10.f2231c) goto L20;
            if (this.f2229a != r10.f2229a) goto L20;
            if (this.f2232d != r10.f2232d) goto L20;
            return true;
        L20:
            return false;
        }

        public final int hashCode() {
            return Objects.hash(new Object[]{Integer.valueOf(this.f2230b), Long.valueOf(this.f2231c), Integer.valueOf(this.f2229a), Long.valueOf(this.f2232d)});
        }
    }

    public static class b {
    }

    static {
        f2226a = new o.b();
        f2227b = new Object();
        f2228c = null;
    }

    public static long a(Context r8) {
        PackageManager r10 = r8.getApplicationContext().getPackageManager();
        if (Build.VERSION.SDK_INT < 33) goto L7;
        return r10.getPackageInfo(r8.getPackageName(), PackageManager.PackageInfoFlags.of(0)).lastUpdateTime;
    L7:
        return r10.getPackageInfo(r8.getPackageName(), 0).lastUpdateTime;
    }

    public static void b(Context r19, boolean r20) {
        if (r20 == false) goto L4;
    L6:
        Object r8 = f2227b;
        monitor-enter(r8);
        if (r20 == false) goto L106;
    L13:
        int r10 = 0;
        AssetFileDescriptor r11 = r19.getAssets().openFd("dexopt/baseline.prof");     // Catch: IOException -> L31 Throwable -> L53
        if (r11.getLength() <= 0) goto L19;
        boolean r12 = true;
    L20:
        r11.close();     // Catch: IOException -> L31 Throwable -> L53
    L32:
        File r13 = new File(new File("/data/misc/profiles/ref/", r19.getPackageName()), "primary.prof");     // Catch: Throwable -> L53
        long r14 = r13.length();     // Catch: Throwable -> L53
        if (r13.exists() == true) goto L35;
    L37:
        boolean r15 = false;
    L38:
        File r16 = new File(new File("/data/misc/profiles/cur/0/", r19.getPackageName()), "primary.prof");     // Catch: Throwable -> L53
        long r17 = r16.length();     // Catch: Throwable -> L53
        if (r16.exists() == true) goto L41;
    L43:
        boolean r18 = false;
    L110:
        long r110 = a(r19);     // Catch: Throwable -> L53 PackageManager.NameNotFoundException -> L94
        File r21 = new File(r19.getFilesDir(), "profileInstalled");     // Catch: Throwable -> L53
        if (r21.exists() == true) goto L107;
        a r111 = null;
    L59:
        if (r111 != null) goto L61;
    L66:
        if (r12 == true) goto L68;
        r10 = 327680;
    L72:
        if (r20 == false) goto L76;
        if (r18 == false) goto L76;
        if (r10 == 1) goto L76;
        r10 = 2;
    L76:
        if (r111 != null) goto L78;
    L83:
        int r112 = r10;
    L84:
        a r22 = new a(1, r112, r110, r17);     // Catch: Throwable -> L53
        if (r111 != null) goto L87;
    L104:
        r22.b(r21);     // Catch: Throwable -> L53 IOException -> L101
    L89:
        b r23 = new b();     // Catch: Throwable -> L53
        f2228c = r23;     // Catch: Throwable -> L53
        o.b<b> r24 = f2226a;     // Catch: Throwable -> L53
        r24.getClass();     // Catch: Throwable -> L53
        if (o.a.f9548p.b(r24, null, r23) == false) goto L92;
        o.a.c(r24);     // Catch: Throwable -> L53
    L92:
        monitor-exit(r8);     // Catch: Throwable -> L53
        return;
    L87:
        if (r111.equals(r22) == true) goto L89;
    L78:
        if (r111.f2230b != 2) goto L83;
        if (r10 != 1) goto L83;
        if (r14 >= r111.f2232d) goto L83;
        r112 = 3;
        goto L84
    L68:
        if (r15 == false) goto L70;
        r10 = 1;
        goto L72
    L70:
        if (r18 == false) goto L72;
        r10 = 2;
        goto L72
    L61:
        if (r111.f2231c != r110) goto L66;
        int r113 = r111.f2230b;     // Catch: Throwable -> L53
        if (r113 == 2) goto L66;
        r10 = r113;
        goto L72
    L107:
        r111 = a.a(r21);     // Catch: IOException -> L50 Throwable -> L53
    L50:
        b r25 = new b();     // Catch: Throwable -> L53
        f2228c = r25;     // Catch: Throwable -> L53
        o.b<b> r26 = f2226a;     // Catch: Throwable -> L53
        r26.getClass();     // Catch: Throwable -> L53
        if (o.a.f9548p.b(r26, null, r25) == false) goto L56;
        o.a.c(r26);     // Catch: Throwable -> L53
    L56:
        return;
    L94:
        b r27 = new b();     // Catch: Throwable -> L53
        f2228c = r27;     // Catch: Throwable -> L53
        o.b<b> r28 = f2226a;     // Catch: Throwable -> L53
        r28.getClass();     // Catch: Throwable -> L53
        if (o.a.f9548p.b(r28, null, r27) == false) goto L98;
        o.a.c(r28);     // Catch: Throwable -> L53
    L98:
        return;
    L53:
        th = move-exception;
        throw th;
    L41:
        if (r17 <= 0) goto L43;
        r18 = true;
        goto L110
    L35:
        if (r14 <= 0) goto L37;
        r15 = true;
        goto L38
    L19:
        r12 = false;
    L22:
        th = move-exception;
        if (r11 == null) goto L114;
        r11.close();     // Catch: Throwable -> L27
        throw th;     // Catch: IOException -> L31 Throwable -> L53
    L27:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L31 Throwable -> L53
        throw th;     // Catch: IOException -> L31 Throwable -> L53
    L114:
        throw th;     // Catch: IOException -> L31 Throwable -> L53
    L31:
        r12 = false;
        goto L32
    L106:
        if (f2228c == null) goto L13;
        monitor-exit(r8);     // Catch: Throwable -> L53
        return;
    L4:
        if (f2228c == null) goto L6;
    }
}
