package okhttp3;

import cvc.c;
import dvc.d;
import dvc.e;
import dvc.i;
import evc.f;
import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.util.Iterator;
import javax.annotation.Nullable;
import okhttp3.internal.io.FileSystem;
import okio.BufferedSource;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class Cache implements Closeable, Flushable {
    private static final int ENTRY_BODY = 1;
    private static final int ENTRY_COUNT = 2;
    private static final int ENTRY_METADATA = 0;
    private static final int VERSION = 201105;
    final e cache;
    private int hitCount;
    final i internalCache;
    private int networkCount;
    private int requestCount;
    int writeAbortCount;
    int writeSuccessCount;

    public synchronized int hitCount() {
        monitor-enter(this);
        int r0 = this.hitCount;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized int networkCount() {
        monitor-enter(this);
        int r0 = this.networkCount;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized int requestCount() {
        monitor-enter(this);
        int r0 = this.requestCount;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void trackConditionalCacheHit() {
        monitor-enter(this);
        this.hitCount++;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized int writeAbortCount() {
        monitor-enter(this);
        int r0 = this.writeAbortCount;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized int writeSuccessCount() {
        monitor-enter(this);
        int r0 = this.writeSuccessCount;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.cache.close();
    }

    public void delete() throws IOException {
        this.cache.delete();
    }

    public File directory() {
        return this.cache.b;
    }

    public void evictAll() throws IOException {
        this.cache.e();
    }

    @Override // java.io.Flushable
    public void flush() throws IOException {
        this.cache.flush();
    }

    public void initialize() throws IOException {
        this.cache.g();
    }

    public boolean isClosed() {
        return this.cache.isClosed();
    }

    public long maxSize() {
        e r0 = this.cache;
        monitor-enter(r0);
        long r1 = r0.g;     // Catch: Throwable -> L7
        monitor-exit(r0);
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public long size() throws IOException {
        e r0 = this.cache;
        monitor-enter(r0);
        r0.g();     // Catch: Throwable -> L7
        long r1 = r0.i;     // Catch: Throwable -> L7
        monitor-exit(r0);
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public Iterator<String> urls() throws IOException {
        return new b(this);
    }

    private void abortQuietly(@Nullable e.b r1) {
        if (r1 == null) goto L8;
        r1.a();     // Catch: IOException -> L5
        return;
    L9:
        return;
    }

    public static String key(HttpUrl r0) {
        return ByteString.encodeUtf8(r0.toString()).md5().hex();
    }

    public static int readInt(BufferedSource r6) throws IOException {
        long r1 = r6.readDecimalLong();     // Catch: NumberFormatException -> L13
        String r7 = r6.readUtf8LineStrict();     // Catch: NumberFormatException -> L13
        if (r1 < 0) goto L12;
        if (r1 > 2147483647L) goto L12;
        if (r7.isEmpty() == false) goto L12;
        return (int) r1;
    L12:
        throw new IOException("expected an int but was \"" + r1 + r7 + "\"");     // Catch: NumberFormatException -> L13
    L13:
        e = move-exception;
        throw new IOException(e.getMessage());
    }

    @Nullable
    public Response get(Request r9) {
        String r0 = key(r9.url());
        e.d r1 = this.cache.f(r0);     // Catch: IOException -> L26
        if (r1 != null) goto L29;
        return null;
    L29:
        boolean r4 = false;
        e r2 = new e(r1.c[0]);     // Catch: IOException -> L24
        String r3 = r2.g.get("Content-Type");
        String r5 = r2.g.get("Content-Length");
        Request r6 = new Request.Builder().url(r2.a).method(r2.c, null).headers(r2.b).build();
        Response r7 = new Response$Builder().request(r6).protocol(r2.d).code(r2.e).message(r2.f).headers(r2.g).body(new d(r1, r3, r5)).handshake(r2.h).sentRequestAtMillis(r2.i).receivedResponseAtMillis(r2.j).build();
        if (r2.a.equals(r9.url().toString()) == true) goto L10;
    L20:
        if (r4 == true) goto L23;
        c.e(r7.body());
        return null;
    L23:
        return r7;
    L10:
        if (r2.c.equals(r9.method()) == false) goto L20;
        Headers r8 = r2.b;
        ByteString r10 = evc.e.a;
        Iterator r11 = evc.e.i(r7.headers()).iterator();
    L13:
        if (r11.hasNext() == false) goto L17;
        String r12 = (String) r11.next();
        if (c.k(r8.values(r12), r9.headers(r12)) == true) goto L13;
        boolean r13 = false;
    L18:
        if (r13 == false) goto L20;
        r4 = true;
        goto L20
    L17:
        r13 = true;
    L24:
        c.e(r1);
    L25:
        return null;
    }

    @Nullable
    public dvc.c put(Response r6) {
        String r0 = r6.request().method();
        if (f.a(r6.request().method()) == false) goto L7;
        remove(r6.request());     // Catch: IOException -> L22
    L5:
        return null;
    L7:
        if (r0.equals("GET") == true) goto L9;
        return null;
    L9:
        ByteString r1 = evc.e.a;
        if (evc.e.i(r6.headers()).contains("*") == false) goto L12;
        return null;
    L12:
        e r2 = new e(r6);
        e.b r7 = this.cache.d(key(r6.request().url()), -1);     // Catch: IOException -> L18
        if (r7 != null) goto L23;
        return null;
    L23:
        r2.c(r7);     // Catch: IOException -> L21
        return new c(this, r7);
    L19:
        abortQuietly(r7);
        return null;
    L18:
        r7 = null;
        goto L19
    }

    public void remove(Request r2) throws IOException {
        this.cache.m(key(r2.url()));
    }

    public synchronized void trackResponse(d r2) {
        monitor-enter(this);
        this.requestCount++;     // Catch: Throwable -> L11
        if (r2.a == null) goto L7;
        this.networkCount++;     // Catch: Throwable -> L11
    L9:
        monitor-exit(this);
        return;
    L7:
        if (r2.b == null) goto L9;
        this.hitCount++;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public Cache(File r2, long r3) {
        this(r2, r3, FileSystem.SYSTEM);
    }

    public void update(Response r5, Response r6) {
        e r0 = new e(r6);
        e.d r7 = r5.body().a;
        e.b r8 = r7.d.d(r7.a, r7.b);     // Catch: IOException -> L7
        if (r8 == null) goto L15;
        r0.c(r8);     // Catch: IOException -> L10
        r8.b();     // Catch: IOException -> L10
        return;
    L8:
        abortQuietly(r8);
        return;
    L15:
        return;
    L7:
        r8 = null;
        goto L8
    }

    public Cache(File r8, long r9, FileSystem r11) {
        this.internalCache = new a(this);
        this.cache = e.c(r11, r8, VERSION, 2, r9);
    }
}
