package com.larksuite.framework.http.v2.internal.rust.stream;

import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class c implements g {
    public final File a;
    public final PolarisFileOutputStreamWrapper b;
    public final CountDownLatch c;
    public final AtomicReference<Throwable> d;
    public final AtomicBoolean e;
    public FileInputStream f;
    public final d g;
    public final e h;

    public static final class a {
    }

    public static final class b {
        public static final Set<String> b = null;
        public final File a;

        public static final class a {
        }

        static {
            b = Collections.synchronizedSet(new LinkedHashSet());
        }

        public b() {
            String r1 = System.getProperty("java.io.tmpdir");
            if (r1 != null) goto L5;
            r1 = ".";
        L5:
            this.a = new PolarisFileWrapper(r1);
        }

        public final c a(h r15) {
            Intrinsics.checkNotNullParameter(r15, "key");
            if (this.a.exists() == true) goto L5;
            this.a.mkdirs();
        L5:
            File r0 = this.a;
            Set<String> r1 = b;
            String r2 = r0.getCanonicalPath();     // Catch: IOException -> L8
            Intrinsics.checkNotNull(r2);     // Catch: IOException -> L8
        L10:
            if (r1.add(r2) == false) goto L21;
            File[] r3 = r0.listFiles();
            if (r3 == null) goto L21;
            int r4 = r3.length;
            int r5 = 0;
        L14:
            if (r5 >= r4) goto L21;
            File r6 = r3[r5];
            if (r6.isFile() == false) goto L20;
            if (StringsKt.startsWith$default(r6.getName(), "okhttp-request-body-cache-", false, 2, null) == false) goto L20;
            r6.delete();
        L20:
            r5 = r5 + 1;
        L21:
            File r7 = this.a;
            StringBuilder r8 = new StringBuilder("okhttp-request-body-cache-");
            byte[] r9 = MessageDigest.getInstance("SHA-256").digest((r15.a + '\n' + r15.b).getBytes(Charsets.UTF_8));
            Intrinsics.checkNotNull(r9);
            r8.append(ArraysKt.joinToString$default(r9, "", null, null, 0, null, FileRequestBodyCache$Factory$hash$1.INSTANCE, 30, null));
            r8.append(".tmp");
            return new c(new PolarisFileWrapper(r7, r8.toString()));
        L8:
            r2 = r0.getAbsolutePath();
            Intrinsics.checkNotNull(r2);
            goto L10
        }
    }

    static {
    }

    @Override // com.larksuite.framework.http.v2.internal.rust.stream.g
    public final void clean() {
        FileInputStream r1 = this.f;     // Catch: Throwable -> L7 IOException -> L12
        if (r1 == null) goto L10;
        r1.close();     // Catch: Throwable -> L7 IOException -> L12
    L7:
        th = move-exception;
        this.f = null;
        throw th;
    L10:
        this.f = null;
        this.a.delete();
    }

    @Override // com.larksuite.framework.http.v2.internal.rust.stream.g
    public final d a() {
        return this.g;
    }

    @Override // com.larksuite.framework.http.v2.internal.rust.stream.g
    public final e source() {
        return this.h;
    }

    public c(PolarisFileWrapper r2) {
        this.a = r2;
        this.b = new PolarisFileOutputStreamWrapper(r2);
        this.c = new CountDownLatch(1);
        this.d = new AtomicReference();
        this.e = new AtomicBoolean(false);
        this.g = new d(this);
        this.h = new e(this);
    }

    @Override // com.larksuite.framework.http.v2.internal.rust.stream.g
    public final void b(Throwable r3) {
        Intrinsics.checkNotNullParameter(r3, "throwable");
        AtomicReference<Throwable> r0 = this.d;
    L4:
        if (r0.compareAndSet(null, r3) == true) goto L9;
        if (r0.get() == null) goto L4;
    L9:
        if (this.e.compareAndSet(false, true) == false) goto L30;
        PolarisFileOutputStreamWrapper r4 = this.b;     // Catch: Throwable -> L18 IOException -> L23
        monitor-enter(r4);     // Catch: Throwable -> L18 IOException -> L23
        this.b.close();     // Catch: Throwable -> L15
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L15
        monitor-exit(r4);     // Catch: Throwable -> L18 IOException -> L23
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L18 IOException -> L23
    L18:
        th = move-exception;
        this.c.countDown();
        throw th;
    L21:
        this.c.countDown();
        return;
    }
}
