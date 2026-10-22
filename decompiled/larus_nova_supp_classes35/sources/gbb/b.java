package gbb;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.log.Log;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b extends e {
    public static final /* synthetic */ int q = 0;
    public final File p;

    public final class a {
        public final File[] a;
        public final File[] b;
        public final Set<String> c;

        public a(b r7, String r8) {
            HashSet r0 = new HashSet(Arrays.asList(new String[]{"_th", "_mid", "_hd"}));
            this.c = r0;
            this.a = new File[1];
            this.b = new File[1];
            StringBuilder r1 = new StringBuilder(r8);
            int r2 = r1.length();
            Iterator r3 = r0.iterator();
        L4:
            if (r3.hasNext() == false) goto L8;
            String r4 = (String) r3.next();
            if (r8.endsWith(r4) == false) goto L4;
            String r5 = r8.substring(0, r8.length() - r4.length());
        L9:
            if (r5 == null) goto L12;
            r8 = r5;
        L12:
            PolarisFileWrapper r6 = new PolarisFileWrapper(r7.p, r8);
            if (r6.exists() == true) goto L15;
            r6.mkdirs();
        L15:
            this.a[0] = new PolarisFileWrapper(r6, r1.toString());
            r1.append(".tmp");
            this.b[0] = new PolarisFileWrapper(r6, r1.toString());
            r1.setLength(r2);
            return;
        L8:
            r5 = null;
            goto L9
        }
    }

    @Override // gbb.e, java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() throws IOException {
        monitor-enter(this);
        monitor-exit(this);
    }

    @Override // gbb.e
    public void delete() throws IOException {
        monitor-enter(this);
        monitor-exit(this);
        e.g.b(this.p);
    }

    @Override // gbb.e
    public final File e() {
        return this.p;
    }

    @Override // gbb.e
    public final synchronized e.C0226e d(String r1) throws IOException {
        monitor-enter(this);
        monitor-exit(this);
        return null;
    }

    @Override // gbb.e
    public final synchronized void l(String r1) throws IOException {
        monitor-enter(this);
        monitor-exit(this);
    }

    public final synchronized File q(String r5) throws IOException {
        monitor-enter(this);
        File r1 = new a(this, r5).a[0];     // Catch: Throwable -> L10
        Log.i("AvatarDiskLruCache", "getCacheFile, key is:" + r5 + ", file is:" + r1.getAbsolutePath() + ", file exist:" + r1.exists());     // Catch: Throwable -> L10
        if (r1.exists() == true) goto L8;
        r1 = null;
    L8:
        monitor-exit(this);
        return r1;
    L10:
        th = move-exception;
        throw th;
    }

    public b(File r1, int r2, long r3) {
        super(r1, r2, r3);
        this.p = r1;
    }
}
