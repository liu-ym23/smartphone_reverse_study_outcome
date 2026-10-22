package okhttp3;

import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;
import okhttp3.internal.cache.DiskLruCache;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.io.FileSystem;

/* JADX INFO: loaded from: classes3.dex */
public final class g implements Closeable, Flushable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DiskLruCache f20646a;

    public g(File r10) {
        Intrinsics.checkNotNullParameter(r10, "directory");
        FileSystem r5 = FileSystem.SYSTEM;
        Intrinsics.checkNotNullParameter(r10, "directory");
        Intrinsics.checkNotNullParameter(r5, "fileSystem");
        this.f20646a = new DiskLruCache(r5, r10, 201105, 2, 10485760, TaskRunner.INSTANCE);
    }

    public final s0 b(Request r13) {
        Intrinsics.checkNotNullParameter(r13, "request");
        String r5 = z.g(r13.url());
        DiskLruCache.Snapshot r12 = this.f20646a.get(r5);     // Catch: IOException -> L28
        if (r12 == null) goto L27;
        e r10 = new e(r12.getSource(0));     // Catch: IOException -> L26
        c0 r11 = r10.f20633b;     // Catch: IOException -> L26
        String r14 = r10.f20634c;     // Catch: IOException -> L26
        String r15 = r10.f20632a;     // Catch: IOException -> L26
        Intrinsics.checkNotNullParameter(r12, "snapshot");
        c0 r16 = r10.g;
        String r17 = r16.b("Content-Type");
        String r18 = r16.b("Content-Length");
        n0 r19 = new n0();
        r19.g(r15);
        r19.d(r14, null);
        Intrinsics.checkNotNullParameter(r11, "headers");
        r19.f20715c = r11.d();
        Request r20 = r19.b();
        r0 r110 = new r0();
        Intrinsics.checkNotNullParameter(r20, "request");
        r110.f20735a = r20;
        r110.d(r10.d);
        r110.f20737c = r10.e;
        String r111 = r10.f;
        Intrinsics.checkNotNullParameter(r111, "message");
        r110.d = r111;
        r110.c(r16);
        r110.g = new d(r12, r17, r18);
        r110.e = r10.f20635h;
        r110.f20741k = r10.f20636i;
        r110.f20742l = r10.f20637j;
        s0 r112 = r110.a();
        Intrinsics.checkNotNullParameter(r13, "request");
        Intrinsics.checkNotNullParameter(r112, "response");
        if (Intrinsics.areEqual(r15, r13.url().f20644j) == true) goto L9;
    L22:
        w0 r113 = r112.f20748h;
        if (r113 == null) goto L25;
        Util.closeQuietly(r113);
    L25:
        return null;
    L9:
        if (Intrinsics.areEqual(r14, r13.method()) == false) goto L22;
        Intrinsics.checkNotNullParameter(r112, "cachedResponse");
        Intrinsics.checkNotNullParameter(r11, "cachedRequest");
        Intrinsics.checkNotNullParameter(r13, "newRequest");
        Set r21 = z.o(r112.g);
        if ((r21 instanceof Collection) == true) goto L13;
    L15:
        Iterator r22 = r21.iterator();
    L17:
        if (r22.hasNext() == false) goto L21;
        String r23 = (String) r22.next();
        if (Intrinsics.areEqual(r11.f(r23), r13.headers(r23)) == true) goto L17;
    L21:
        return r112;
    L13:
        if (r21.isEmpty() == false) goto L15;
    L26:
        Util.closeQuietly(r12);
    L27:
        return null;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f20646a.close();
    }

    @Override // java.io.Flushable
    public final void flush() {
        this.f20646a.flush();
    }
}
