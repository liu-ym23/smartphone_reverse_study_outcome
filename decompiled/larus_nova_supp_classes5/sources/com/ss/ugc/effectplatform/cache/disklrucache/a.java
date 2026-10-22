package com.ss.ugc.effectplatform.cache.disklrucache;

import bytekn.foundation.concurrent.executor.AsyncExecutor;
import bytekn.foundation.io.file.ContentEncoding;
import bytekn.foundation.io.file.FileManager;
import bytekn.foundation.io.file.FileType;
import bytekn.foundation.io.file.IOException;
import bytekn.foundation.io.file.g;
import bytekn.foundation.io.file.h;
import bytekn.foundation.io.file.i;
import bytekn.foundation.logger.Logger;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class a {
    public static final Regex v = null;
    public static final C0011a w = null;
    public final bytekn.foundation.io.file.f a;
    public final bytekn.foundation.io.file.f b;
    public final bytekn.foundation.io.file.f c;
    public final a0.b<Long> d;
    public final a0.b<Integer> e;
    public final a0.b<i> f;
    public final c0.e g;
    public final a0.b<Boolean> h;
    public final a0.b<Boolean> i;
    public final a0.b<Long> j;
    public final z.b<String, c> k;
    public final AsyncExecutor l;
    public final e m;
    public final String n;
    public final int o;
    public final int p;
    public long q;
    public final com.ss.ugc.effectplatform.cache.disklrucache.e r;
    public final boolean s;
    public final boolean t;
    public final boolean u;

    /* JADX INFO: renamed from: com.ss.ugc.effectplatform.cache.disklrucache.a$a, reason: collision with other inner class name */
    public static final class C0011a {
        public C0011a() {
        }

        public static String c(String r6) {
            char[] r0 = new char[r6.length()];
            int r1 = r6.length();
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L19;
            char r3 = r6.charAt(r2);
            r0[r2] = r3;
            if (r3 == '_') goto L17;
            if (r3 == '-') goto L17;
            if (r3 < 'a') goto L13;
            if (r3 <= 'z') goto L17;
        L13:
            if (r3 >= '0') goto L15;
        L16:
            r0[r2] = '_';
            goto L17
        L15:
            if (r3 > '9') goto L16;
        L17:
            r2 = r2 + 1;
            goto L3
        L19:
            return new String(r0);
        }

        public static void b(bytekn.foundation.io.file.f r2, bytekn.foundation.io.file.f r3, boolean r4) {
            if (r4 == false) goto L10;
            String r5 = FileManager.a;
            if (FileManager.c(r3) == false) goto L10;
            if (FileManager.n(r3) == true) goto L10;
            throw new IOException("delete file exception occur,file = " + r3);
        L10:
            String r6 = FileManager.a;
            if (FileManager.p(r2, r3) == false) goto L14;
            return;
        L14:
            throw new IOException("rename file exception occur, from = " + r2 + ",to = " + r3);
        }

        public static a a(String r13, int r14, int r15, long r16, com.ss.ugc.effectplatform.cache.disklrucache.e r18, boolean r19, boolean r20, boolean r21) {
            if (r16 <= 0) goto L44;
            if (r15 <= 0) goto L42;
            String r0 = FileManager.a;
            if (FileManager.d(r13) == true) goto L10;
            FileManager.i(r13);
            if (FileManager.d(r13) == true) goto L10;
            Logger.e$default(Logger.INSTANCE, "DiskLruCache", "Cache directory error" + r13, null, 4, null);
        L10:
            bytekn.foundation.io.file.f r1 = null;
            if (r13 == null) goto L13;
            File r2 = new PolarisFileWrapper(r13).getAbsoluteFile();
        L14:
            if (r2 != null) goto L16;
            bytekn.foundation.io.file.f r3 = null;
        L17:
            if (r3 != null) goto L19;
        L33:
            a r12 = new a(r13, r14, r15, r16, r18, r19, r20, r21);
            if (FileManager.c(r12.a) == true) goto L45;
        L39:
            String r4 = FileManager.a;
            FileManager.i(r13);
            a r5 = new a(r13, r14, r15, r16, r18, r19, r20, r21);
            r5.p();
            return r5;
        L45:
            r12.n();     // Catch: Exception -> L37
            r12.l();     // Catch: Exception -> L37
            r12.h.a = Boolean.TRUE;     // Catch: Exception -> L37
            return r12;
        L37:
            e = move-exception;
            Logger.e$default(Logger.INSTANCE, "DiskLruCache", "DiskLruCache " + r13 + " is corrupt: " + e.getMessage() + ", removing", null, 4, null);
            r12.delete();
            goto L39
        L19:
            if (FileManager.c(r3) == false) goto L33;
            if (r13 == null) goto L22;
            File r6 = new PolarisFileWrapper(r13).getAbsoluteFile();
        L23:
            if (r6 == null) goto L26;
            r1 = new bytekn.foundation.io.file.f(new PolarisFileWrapper(r6.getAbsolutePath(), "journal").getAbsoluteFile().getAbsolutePath());
        L26:
            if (r1 == null) goto L33;
            if (FileManager.c(r1) == false) goto L33;
            if (FileManager.c(r1) == false) goto L32;
            FileManager.n(r3);
            goto L33
        L32:
            a.w.getClass();
            b(r3, r1, false);
            goto L33
        L22:
            r6 = null;
            goto L23
        L16:
            r3 = new bytekn.foundation.io.file.f(new PolarisFileWrapper(r2.getAbsolutePath(), "journal.bkp").getAbsoluteFile().getAbsolutePath());
            goto L17
        L13:
            r2 = null;
            goto L14
        L42:
            throw new IllegalArgumentException("valueCount <= 0");
        L44:
            throw new IllegalArgumentException("maxSize <= 0");
        }
    }

    public final class b {
        public final a0.b<boolean[]> a;
        public final a0.b<Boolean> b;
        public final a0.b<Boolean> c;
        public final c d;
        public final /* synthetic */ a e;

        public final void a() {
            a.a(this.e, this, false);
        }

        public final void b() {
            if (((Boolean) this.b.a).booleanValue() == false) goto L5;
            a.a(this.e, this, false);
            this.e.q(this.d.f);
        L6:
            a0.b<Boolean> r0 = this.c;
            r0.a = Boolean.TRUE;
            return;
        L5:
            a.a(this.e, this, true);
            goto L6
        }

        public final bytekn.foundation.io.file.e c() {
            a r0 = this.e;
            if (r0.p <= 0) goto L5;
            boolean r1 = true;
        L6:
            if (r1 == false) goto L33;
            c0.e r2 = r0.g;
            r2.a();
        L29:
            th = move-exception;
            r2.b();
            throw th;
        L9:
            if (Intrinsics.areEqual((b) this.d.c.a, this) == false) goto L28;
            if (((Boolean) this.d.b.a).booleanValue() == true) goto L13;
            boolean[] r3 = new boolean[this.e.p];     // Catch: Throwable -> L29
            r3[0] = true;     // Catch: Throwable -> L29
            this.a.a = r3;     // Catch: Throwable -> L29
        L13:
            bytekn.foundation.io.file.f r4 = this.d.b(0);     // Catch: Throwable -> L29
            String r5 = FileManager.a;     // Catch: Exception -> L16 Throwable -> L29
            bytekn.foundation.io.file.e r6 = FileManager.k(r4, false);     // Catch: Exception -> L16 Throwable -> L29
        L19:
            if (r6 != null) goto L21;
            Intrinsics.throwNpe();     // Catch: Throwable -> L29
        L21:
            com.ss.ugc.effectplatform.cache.disklrucache.d r7 = new com.ss.ugc.effectplatform.cache.disklrucache.d(r6, new DiskLruCache$Editor$newOutputStream$.inlined.synchronized.lambda.1(this, 0));     // Catch: Throwable -> L29
            r2.b();
            return r7;
        L16:
            String r8 = FileManager.a;     // Catch: Throwable -> L29
            FileManager.i(this.e.n);     // Catch: Throwable -> L29
            r6 = FileManager.k(r4, false);     // Catch: Exception -> L24 Throwable -> L29
        L24:
            com.ss.ugc.effectplatform.cache.disklrucache.c r9 = new com.ss.ugc.effectplatform.cache.disklrucache.c();     // Catch: Throwable -> L29
            r2.b();
            return r9;
        L28:
            throw new IllegalStateException("Check failed.".toString());     // Catch: Throwable -> L29
        L33:
            throw new IllegalArgumentException(("Expected index 0 to be greater than 0 and less than the maximum value count of " + this.e.p).toString());
        L5:
            r1 = false;
            goto L6
        }

        public b(a r1, c r2) {
            this.e = r1;
            this.d = r2;
            this.a = new a0.b(new boolean[r1.p]);
            Boolean r3 = Boolean.FALSE;
            this.b = new a0.b(r3);
            this.c = new a0.b(r3);
        }
    }

    public final class c {
        public final z.a<Long> a;
        public final a0.b<Boolean> b;
        public final a0.b<b> c;
        public final a0.b<Long> d;
        public final z.a<Long> e;
        public final String f;
        public final /* synthetic */ a g;

        public final String c() {
            StringBuilder r0 = new StringBuilder();
            Iterator r1 = this.a.iterator();
        L4:
            if (r1.hasNext() == false) goto L7;
            long r2 = ((Number) r1.next()).longValue();
            r0.append(' ');
            r0.append(r2);
            goto L4
        L7:
            return r0.toString();
        }

        public final String d() {
            StringBuilder r0 = new StringBuilder();
            Iterator r1 = this.e.iterator();
        L4:
            if (r1.hasNext() == false) goto L7;
            long r2 = ((Number) r1.next()).longValue();
            r0.append(' ');
            r0.append(r2);
            goto L4
        L7:
            return r0.toString();
        }

        public static void e(String[] r3) {
            throw new Exception("unexpected journal line: " + r3);
        }

        public final bytekn.foundation.io.file.f a(int r5) {
            if (r5 != 0) goto L12;
            String r6 = this.g.n;
            if (r6 == null) goto L7;
            File r7 = new PolarisFileWrapper(r6).getAbsoluteFile();
        L8:
            String r1 = this.f;
            if (r7 != null) goto L21;
            return null;
        L21:
            return new bytekn.foundation.io.file.f(new PolarisFileWrapper(r7.getAbsolutePath(), r1).getAbsoluteFile().getAbsolutePath());
        L7:
            r7 = null;
            goto L8
        L12:
            String r2 = this.g.n;
            if (r2 == null) goto L15;
            File r3 = new PolarisFileWrapper(r2).getAbsoluteFile();
        L16:
            String r8 = this.f + '.' + r5;
            if (r3 != null) goto L20;
            return null;
        L20:
            return new bytekn.foundation.io.file.f(new PolarisFileWrapper(r3.getAbsolutePath(), r8).getAbsoluteFile().getAbsolutePath());
        L15:
            r3 = null;
            goto L16
        }

        public final bytekn.foundation.io.file.f b(int r6) {
            if (r6 != 0) goto L12;
            String r7 = this.g.n;
            if (r7 == null) goto L7;
            File r8 = new PolarisFileWrapper(r7).getAbsoluteFile();
        L8:
            String r0 = this.f + ".tmp";
            if (r8 != null) goto L21;
            return null;
        L21:
            return new bytekn.foundation.io.file.f(new PolarisFileWrapper(r8.getAbsolutePath(), r0).getAbsoluteFile().getAbsolutePath());
        L7:
            r8 = null;
            goto L8
        L12:
            String r2 = this.g.n;
            if (r2 == null) goto L15;
            File r3 = new PolarisFileWrapper(r2).getAbsoluteFile();
        L16:
            String r9 = this.f + '.' + r6 + ".tmp";
            if (r3 != null) goto L20;
            return null;
        L20:
            return new bytekn.foundation.io.file.f(new PolarisFileWrapper(r3.getAbsolutePath(), r9).getAbsoluteFile().getAbsolutePath());
        L15:
            r3 = null;
            goto L16
        }

        public c(a r4, String r5) {
            this.g = r4;
            this.f = r5;
            int r0 = 0;
            this.a = new z.a(false);
            this.b = new a0.b(Boolean.FALSE);
            this.c = new a0.b(null);
            this.d = new a0.b(0L);
            this.e = new z.a(false);
            int r6 = r4.p;
        L3:
            if (r0 >= r6) goto L5;
            this.a.add(0L);
            this.e.add(0L);
            r0 = r0 + 1;
            goto L3
        }
    }

    public final class d implements g {
        public final bytekn.foundation.io.file.f[] a;
        public final bytekn.foundation.io.file.b[] b;

        public final void close() {
            g[] r0 = this.b;
            int r1 = r0.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L8;
            g r3 = r0[r2];
            if (r3 == null) goto L7;
            String r4 = FileManager.a;
            FileManager.b(r3);
        L7:
            r2 = r2 + 1;
            goto L3
        }

        public d(bytekn.foundation.io.file.f[] r1, bytekn.foundation.io.file.b[] r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class e implements Runnable {
        public final /* synthetic */ a a;

        public final void a() {
            c0.e r0 = this.a.g;
            r0.a();
        L18:
            th = move-exception;
            r0.b();
            throw th;
        L4:
            if (((Boolean) this.a.h.a).booleanValue() == true) goto L6;
            boolean r1 = true;
        L9:
            if ((r1 | ((Boolean) this.a.i.a).booleanValue()) == false) goto L12;
            r0.b();
            return;
        L12:
            this.a.r();     // Catch: Throwable -> L18
            if (this.a.h() == false) goto L15;
            this.a.p();     // Catch: Throwable -> L18
            this.a.e.a = 0;     // Catch: Throwable -> L18
        L15:
            Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L18
            r0.b();
            return;
        L6:
            r1 = false;
            goto L9
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public e(a r1) {
            this.a = r1;
        }
    }

    static {
        w = new C0011a();
        v = new Regex("[a-z0-9_-]{1,120}");
    }

    public final void c() {
        if (((Boolean) this.i.a).booleanValue() == true) goto L6;
        return;
    L6:
        throw new IllegalStateException("cache is closed");
    }

    public final void delete() {
        c0.e r0 = this.g;
        r0.a();
    L23:
        th = move-exception;
        r0.b();
        throw th;
    L4:
        if (((Boolean) this.h.a).booleanValue() == true) goto L6;
    L18:
        a0.b<Boolean> r1 = this.i;     // Catch: Throwable -> L23
        r1.a = Boolean.TRUE;     // Catch: Throwable -> L23
    L19:
        r0.b();
        if (com.ss.ugc.effectplatform.util.i.a.delete(this.n) == false) goto L32;
        String r2 = FileManager.a;
        FileManager.i(this.n);
        return;
    L32:
        return;
    L6:
        if (((Boolean) this.i.a).booleanValue() == true) goto L18;
        Iterator r3 = new ArrayList(this.k.values()).iterator();     // Catch: Throwable -> L23
    L10:
        if (r3.hasNext() == false) goto L14;
        b r4 = (b) ((c) r3.next()).c.a;     // Catch: Throwable -> L23
        if (r4 == null) goto L10;
        r4.a();     // Catch: Throwable -> L23
        goto L10
    L14:
        r();     // Catch: Throwable -> L23
        i r5 = (i) this.f.a;     // Catch: Throwable -> L23
        if (r5 == null) goto L17;
        r5.close();     // Catch: Throwable -> L23
    L17:
        this.f.a = null;     // Catch: Throwable -> L23
        a0.b<Boolean> r6 = this.i;     // Catch: Throwable -> L23
        r6.a = Boolean.TRUE;     // Catch: Throwable -> L23
        Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L23
        goto L19
    }

    public final Set<String> f() {
        c0.e r0 = this.g;
        r0.a();
        Set<String> r1 = CollectionsKt.toSet(new LinkedHashSet(this.k.keySet()));     // Catch: Throwable -> L6
        r0.b();
        return r1;
    L6:
        th = move-exception;
        r0.b();
        throw th;
    }

    public final void g() {
        if (((Boolean) this.h.a).booleanValue() == false) goto L5;
        return;
    L5:
        c0.e r2 = this.g;
        r2.a();
        String r3 = FileManager.a;     // Catch: Throwable -> L33
        if (FileManager.c(this.c) == false) goto L19;
        if (FileManager.c(this.a) == true) goto L11;
        C0011a r0 = w;     // Catch: Throwable -> L33
        bytekn.foundation.io.file.f r4 = this.c;     // Catch: Throwable -> L33
        bytekn.foundation.io.file.f r5 = this.a;     // Catch: Throwable -> L33
        r0.getClass();     // Catch: Throwable -> L33
        C0011a.b(r4, r5, false);     // Catch: Throwable -> L33
        goto L19
    L11:
        if (FileManager.n(this.c) == false) goto L19;
        if (FileManager.c(this.c) == false) goto L19;
        throw new IOException("failed to delete " + this.c);     // Catch: Throwable -> L33
    L19:
        if (FileManager.c(this.a) == true) goto L36;
    L30:
        p();     // Catch: Throwable -> L33
        this.h.a = Boolean.TRUE;     // Catch: Throwable -> L33
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L33
        r2.b();
        return;
    L36:
        n();     // Catch: IOException -> L23 Throwable -> L33
        l();     // Catch: IOException -> L23 Throwable -> L33
        this.h.a = Boolean.TRUE;     // Catch: IOException -> L23 Throwable -> L33
        r2.b();     // Catch: IOException -> L23
        return;
    L23:
        e = move-exception;
        Logger.e$default(Logger.INSTANCE, "DiskLruCache", "DiskLruCache " + this.n + " is corrupt: " + e.getMessage() + ", removing", null, 4, null);     // Catch: Throwable -> L33
        delete();     // Catch: Throwable -> L27
        this.i.a = Boolean.FALSE;     // Catch: Throwable -> L33
        goto L30
    L27:
        th = move-exception;
        this.i.a = Boolean.FALSE;     // Catch: Throwable -> L33
        throw th;     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        r2.b();
        throw th;
    }

    public final boolean h() {
        Logger.INSTANCE.d("DiskLruCache", "journalRebuildRequired, redundantOpCount:" + ((Number) this.e.a).intValue() + ", lruEntries.size:" + this.k.size());
        if (((Number) this.e.a).intValue() >= 2000) goto L5;
    L7:
        return false;
    L5:
        if (((Number) this.e.a).intValue() < this.k.size()) goto L7;
        return true;
    }

    public final void l() {
        String r0 = FileManager.a;
        FileManager.n(this.b);
        Iterator r1 = this.k.values().iterator();
    L3:
        int r3 = 0;
        if (r1.hasNext() == false) goto L15;
        c r2 = (c) r1.next();
        a0.b<b> r4 = r2.c;
        if (r4.a == null) goto L7;
        r4.a = null;
        int r5 = this.p;
    L11:
        if (r3 >= r5) goto L13;
        com.ss.ugc.effectplatform.util.i r6 = com.ss.ugc.effectplatform.util.i.a;
        r6.delete(r2.a(r3));
        r6.delete(r2.b(r3));
        r3 = r3 + 1;
        goto L11
    L13:
        r1.remove();
        goto L3
    L7:
        int r7 = this.p;
    L8:
        if (r3 >= r7) goto L3;
        a0.b<Long> r8 = this.d;
        r8.a = Long.valueOf(((Number) r8.a).longValue() + ((Number) r2.a.get(r3)).longValue());
        r3 = r3 + 1;
        goto L8
    L15:
        if (this.t == false) goto L17;
        return;
    L17:
        Iterator r9 = this.k.entrySet().iterator();
    L19:
        if (r9.hasNext() == false) goto L37;
        Map.Entry r10 = (Map.Entry) r9.next();
        if (((c) r10.getValue()).e.size() <= 0) goto L19;
        long r11 = 0;
        if (((Number) ((c) r10.getValue()).e.get(0)).longValue() > 0) goto L19;
        String r12 = FileManager.a;
        if (FileManager.c(((c) r10.getValue()).a(0)) == false) goto L19;
        bytekn.foundation.io.file.f r13 = ((c) r10.getValue()).a(0);
        if (r13 == null) goto L31;
        String r14 = r13.b;
        if (r14 == null) goto L31;
        bytekn.foundation.io.file.d r15 = FileManager.a(new PolarisFileWrapper(r14));
    L32:
        if (r15 == null) goto L36;
        Double r16 = r15.e;
        if (r16 == null) goto L36;
        r11 = (long) r16.doubleValue();
    L36:
        Logger.INSTANCE.d("DiskLruCache", ((String) r10.getKey()) + ":modifiedAt:" + r11);
        ((c) r10.getValue()).e.set(0, Long.valueOf(r11));
    L31:
        r15 = null;
        goto L32
    }

    public final void m() {
        c0.e r1 = this.g;
        r1.a();
        String r2 = FileManager.a;     // Catch: Throwable -> L26
        if (FileManager.c(this.c) == false) goto L10;
        if (FileManager.c(this.a) == false) goto L8;
        FileManager.n(this.c);     // Catch: Throwable -> L26
        goto L10
    L8:
        C0011a r3 = w;     // Catch: Throwable -> L26
        bytekn.foundation.io.file.f r4 = this.c;     // Catch: Throwable -> L26
        bytekn.foundation.io.file.f r5 = this.a;     // Catch: Throwable -> L26
        r3.getClass();     // Catch: Throwable -> L26
        C0011a.b(r4, r5, false);     // Catch: Throwable -> L26
    L10:
        if (FileManager.c(this.a) == true) goto L29;
    L20:
        String r0 = FileManager.a;     // Catch: Throwable -> L26
        if (FileManager.d(this.n) == true) goto L23;
        FileManager.i(this.n);     // Catch: Throwable -> L26
    L23:
        p();     // Catch: Throwable -> L26
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L26
        r1.b();
        return;
    L29:
        n();     // Catch: Exception -> L14 Throwable -> L26
        l();     // Catch: Exception -> L14 Throwable -> L26
        r1.b();     // Catch: Exception -> L14
        return;
    L14:
        e = move-exception;
        Logger.e$default(Logger.INSTANCE, "DiskLruCache", "DiskLruCache " + this.n + " is corrupt: " + e.getMessage() + ", removing", null, 4, null);     // Catch: Throwable -> L26
        delete();     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        r1.b();
        throw th;
    }

    public final void n() {
        bytekn.foundation.io.file.f r2 = this.a;
        String r3 = FileManager.a;
        if (r2 == null) goto L7;
        String r4 = r2.b;
        if (r4 == null) goto L7;
        bytekn.foundation.io.file.b r5 = FileManager.j(r4);
    L8:
        if (r5 == null) goto L69;
        f r6 = new f(r5, ContentEncoding.Ascii);
        String r7 = r6.b();     // Catch: Throwable -> L60 Exception -> L62
        String r8 = r6.b();     // Catch: Throwable -> L60 Exception -> L62
        String r9 = r6.b();     // Catch: Throwable -> L60 Exception -> L62
        String r10 = r6.b();     // Catch: Throwable -> L60 Exception -> L62
        String r11 = r6.b();     // Catch: Throwable -> L60 Exception -> L62
        boolean r12 = false;
        if (this.u == false) goto L13;
        boolean r13 = false;
    L15:
        if ((!Intrinsics.areEqual("libcore.io.DiskLruCache", r7)) == true) goto L65;
        if ((!Intrinsics.areEqual("1", r8)) == true) goto L65;
        if (r13 == true) goto L65;
        if ((!Intrinsics.areEqual(String.valueOf(this.p), r10)) == true) goto L65;
        if ((!Intrinsics.areEqual(r11, "")) == true) goto L65;
        int r0 = 0;
    L71:
        String r1 = r6.b();     // Catch: Exception -> L70 Throwable -> L60
        if (r1 == null) goto L31;
        if (o(r1) == false) goto L31;
        r0 = r0 + 1;
    L31:
        Collection r14 = this.k.values();     // Catch: Throwable -> L60 Exception -> L62
        if ((r14 instanceof Collection) == true) goto L34;
    L36:
        Iterator r15 = r14.iterator();     // Catch: Throwable -> L60 Exception -> L62
        int r16 = 0;
    L38:
        if (r15.hasNext() == false) goto L49;
        c r17 = (c) r15.next();     // Catch: Throwable -> L60 Exception -> L62
        if (r17.e.size() > 0) goto L42;
    L44:
        boolean r18 = false;
    L45:
        if (r18 == false) goto L38;
        r16 = r16 + 1;     // Catch: Throwable -> L60 Exception -> L62
        if (r16 >= 0) goto L38;
        CollectionsKt.throwCountOverflow();     // Catch: Throwable -> L60 Exception -> L62
        goto L38
    L42:
        if (((Number) r17.e.get(0)).longValue() <= 0) goto L44;
        r18 = true;
    L49:
        this.e.a = Integer.valueOf((r0 - this.k.size()) - r16);     // Catch: Throwable -> L60 Exception -> L62
        if (r6.c != (-1)) goto L52;
        r12 = true;
    L52:
        if (r12 == false) goto L54;
        p();     // Catch: Throwable -> L60 Exception -> L62
    L58:
        String r19 = FileManager.a;
        FileManager.b(r6);
        return;
    L54:
        a0.b<i> r20 = this.f;     // Catch: Throwable -> L60 Exception -> L62
        String r21 = FileManager.a;     // Catch: Throwable -> L60 Exception -> L62
        bytekn.foundation.io.file.e r22 = FileManager.k(this.a, true);     // Catch: Throwable -> L60 Exception -> L62
        if (r22 != null) goto L57;
        Intrinsics.throwNpe();     // Catch: Throwable -> L60 Exception -> L62
    L57:
        ContentEncoding r23 = ContentEncoding.Utf8;     // Catch: Throwable -> L60 Exception -> L62
        r20.a = new h(r22);     // Catch: Throwable -> L60 Exception -> L62
        goto L58
    L34:
        if (r14.isEmpty() == false) goto L36;
        r16 = 0;
    L65:
        throw new IOException("unexpected journal header: [" + r7 + ", " + r8 + ", " + r10 + ", " + r11 + "]");     // Catch: Throwable -> L60 Exception -> L62
    L13:
        r13 = !Intrinsics.areEqual(String.valueOf(this.o), r9);     // Catch: Throwable -> L60 Exception -> L62
    L62:
        e = move-exception;
        throw e;     // Catch: Throwable -> L60
    L60:
        th = move-exception;
        String r24 = FileManager.a;
        FileManager.b(r6);
        throw th;
    L69:
        return;
    L7:
        r5 = null;
        goto L8
    }

    public final void p() {
        Logger.INSTANCE.d("DiskLruCache", "rebuildJournal");
        c0.e r1 = this.g;
        r1.a();
        i r2 = (i) this.f.a;     // Catch: Throwable -> L49
        if (r2 == null) goto L54;
        r2.close();     // Catch: Throwable -> L49
    L54:
        String r3 = FileManager.a;     // Catch: Exception -> L9 Throwable -> L49
        bytekn.foundation.io.file.e r4 = FileManager.k(this.b, false);     // Catch: Exception -> L9 Throwable -> L49
    L13:
        if (r4 == null) goto L47;
        ContentEncoding r5 = ContentEncoding.Utf8;     // Catch: Throwable -> L49
        FileOutputStream r6 = r4.a;     // Catch: Throwable -> L49
        if (r6 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("outputStream");     // Catch: Throwable -> L49
    L17:
        OutputStreamWriter r7 = new OutputStreamWriter(r6);     // Catch: Throwable -> L49
        r7.write("libcore.io.DiskLruCache");     // Catch: Throwable -> L44
        r7.write("\n");     // Catch: Throwable -> L44
        r7.write("1");     // Catch: Throwable -> L44
        r7.write("\n");     // Catch: Throwable -> L44
        if (this.u == false) goto L21;
        r7.write(String.valueOf(0));     // Catch: Throwable -> L44
    L22:
        r7.write("\n");     // Catch: Throwable -> L44
        r7.write(String.valueOf(this.p));     // Catch: Throwable -> L44
        r7.write("\n");     // Catch: Throwable -> L44
        r7.write("\n");     // Catch: Throwable -> L44
        Iterator r0 = this.k.values().iterator();     // Catch: Throwable -> L44
    L23:
        if (r0.hasNext() == false) goto L35;
        c r8 = (c) r0.next();     // Catch: Throwable -> L44
        if (r8.c.a == null) goto L28;
        r7.write("DIRTY " + r8.f + '\n');     // Catch: Throwable -> L44
    L30:
        if (r8.e.size() <= 0) goto L23;
        if (((Number) r8.e.get(0)).longValue() <= 0) goto L23;
        r7.write("USE " + r8.f + r8.d() + '\n');     // Catch: Throwable -> L44
        goto L23
    L28:
        r7.write("CLEAN " + r8.f + r8.c() + '\n');     // Catch: Throwable -> L44
        goto L30
    L35:
        r7.close();     // Catch: Throwable -> L49
        String r9 = FileManager.a;     // Catch: Throwable -> L49
        if (FileManager.c(this.a) == false) goto L38;
        C0011a r10 = w;     // Catch: Throwable -> L49
        bytekn.foundation.io.file.f r11 = this.a;     // Catch: Throwable -> L49
        bytekn.foundation.io.file.f r12 = this.c;     // Catch: Throwable -> L49
        r10.getClass();     // Catch: Throwable -> L49
        C0011a.b(r11, r12, true);     // Catch: Throwable -> L49
    L38:
        C0011a r13 = w;     // Catch: Throwable -> L49
        bytekn.foundation.io.file.f r14 = this.b;     // Catch: Throwable -> L49
        bytekn.foundation.io.file.f r15 = this.a;     // Catch: Throwable -> L49
        r13.getClass();     // Catch: Throwable -> L49
        C0011a.b(r14, r15, false);     // Catch: Throwable -> L49
        FileManager.n(this.c);     // Catch: Throwable -> L49
        a0.b<i> r16 = this.f;     // Catch: Throwable -> L49
        bytekn.foundation.io.file.e r17 = FileManager.k(this.a, true);     // Catch: Throwable -> L49
        if (r17 != null) goto L41;
        Intrinsics.throwNpe();     // Catch: Throwable -> L49
    L41:
        ContentEncoding r18 = ContentEncoding.Utf8;     // Catch: Throwable -> L49
        r16.a = new h(r17);     // Catch: Throwable -> L49
        Unit r19 = Unit.INSTANCE;     // Catch: Throwable -> L49
        r1.b();
        return;
    L21:
        r7.write(String.valueOf(this.o));     // Catch: Throwable -> L44
    L44:
        th = move-exception;
        r7.close();     // Catch: Throwable -> L49
        throw th;     // Catch: Throwable -> L49
    L47:
        r1.b();
        return;
    L9:
        String r20 = FileManager.a;     // Catch: Throwable -> L49
        String r21 = this.b.b;     // Catch: Throwable -> L49
        if (r21 == null) goto L12;
        new PolarisFileWrapper(r21).getAbsoluteFile().createNewFile();     // Catch: Throwable -> L49
    L12:
        r4 = FileManager.k(this.b, false);     // Catch: Throwable -> L49
    L49:
        th = move-exception;
        r1.b();
        throw th;
    }

    public final void r() {
    L3:
        if (((Number) this.d.a).longValue() <= this.q) goto L29;
        int r0 = this.k.size();
        Iterator r1 = this.k.entrySet().iterator();
        int r2 = 0;
    L6:
        if (r1.hasNext() == false) goto L3;
        Map.Entry r3 = (Map.Entry) r1.next();
        com.ss.ugc.effectplatform.cache.disklrucache.e r4 = this.r;
        if (r4 == null) goto L13;
        if (r4.isAllowed((String) r3.getKey()) == false) goto L13;
        r2 = r2 + 1;
    L13:
        if ((r0 - r2) >= 10) goto L28;
        c0.e r5 = this.g;
        r5.a();
        long r6 = this.q;     // Catch: Throwable -> L25
        r5.b();
        long r7 = r6 * ((long) 2);
        c0.e r8 = this.g;
        r8.a();
        this.q = r7;     // Catch: Throwable -> L22
        if (((Boolean) this.h.a).booleanValue() == false) goto L20;
        this.l.execute(this.m);     // Catch: Throwable -> L22
    L20:
        Unit r9 = Unit.INSTANCE;     // Catch: Throwable -> L22
        r8.b();
    L22:
        th = move-exception;
        r8.b();
        throw th;
    L25:
        th = move-exception;
        r5.b();
        throw th;
    L28:
        Logger.INSTANCE.d("DiskLruCache", "remove " + ((String) r3.getKey()) + " because exceed to maxSize(" + this.q + ')');
        q((String) r3.getKey());
        goto L3
    }

    public static boolean s(String r1) {
        return v.matches(r1);
    }

    public final void b(String r13) {
        c0.e r3 = this.g;
        r3.a();
        c();     // Catch: Throwable -> L52
        if (s(r13) == false) goto L51;
        c r2 = (c) this.k.get(r13);     // Catch: Throwable -> L52
        if (r2 != null) goto L9;
        r2 = new c(this, r13);     // Catch: Throwable -> L52
        this.k.put(r13, r2);     // Catch: Throwable -> L52
    L13:
        bytekn.foundation.io.file.f r4 = r2.a(0);     // Catch: Throwable -> L52
        String r5 = FileManager.a;     // Catch: Throwable -> L52
        if (FileManager.c(r4) == false) goto L45;
        long r7 = ((Number) r2.a.get(0)).longValue();     // Catch: Throwable -> L52
        if (r4 == null) goto L20;
        String r6 = r4.b;     // Catch: Throwable -> L52
        if (r6 == null) goto L20;
        bytekn.foundation.io.file.d r8 = FileManager.a(new PolarisFileWrapper(r6));     // Catch: Throwable -> L52
    L21:
        if (r8 == null) goto L25;
        Long r9 = r8.f;     // Catch: Throwable -> L52
        if (r9 == null) goto L25;
        long r10 = r9.longValue();     // Catch: Throwable -> L52
    L26:
        if (r8 != null) goto L28;
    L34:
        r2.a.set(0, Long.valueOf(r10));     // Catch: Throwable -> L52
        a0.b<Long> r14 = this.d;     // Catch: Throwable -> L52
        r14.a = Long.valueOf((((Number) r14.a).longValue() - r7) + r10);     // Catch: Throwable -> L52
        a0.b<Integer> r15 = this.e;     // Catch: Throwable -> L52
        r15.a = Integer.valueOf(((Number) r15.a).intValue() + 1);     // Catch: Throwable -> L52
        r2.c.a = null;     // Catch: Throwable -> L52
        r2.b.a = Boolean.TRUE;     // Catch: Throwable -> L52
        i r16 = (i) this.f.a;     // Catch: Throwable -> L52
        if (r16 == null) goto L37;
        r16.b("CLEAN " + r2.f + r2.c() + '\n');     // Catch: Throwable -> L52
    L37:
        a0.b<Long> r17 = this.j;     // Catch: Throwable -> L52
        r17.a = Long.valueOf(((Number) r17.a).longValue() + 1);     // Catch: Throwable -> L52
        r2.d.a = this.j.a;     // Catch: Throwable -> L52
        i r18 = (i) this.f.a;     // Catch: Throwable -> L52
        if (r18 == null) goto L41;
        r18.a();     // Catch: Throwable -> L52
    L41:
        if (((Number) this.d.a).longValue() <= this.q) goto L43;
    L44:
        this.l.execute(this.m);     // Catch: Throwable -> L52
    L48:
        r3.b();
        return;
    L43:
        if (h() == false) goto L48;
    L28:
        if (r8.getType() != FileType.Directory) goto L34;
        com.ss.ugc.effectplatform.util.i r11 = com.ss.ugc.effectplatform.util.i.a;     // Catch: Throwable -> L52
        if (r4 == null) goto L32;
        String r12 = r4.b;     // Catch: Throwable -> L52
    L33:
        r10 = com.ss.ugc.effectplatform.util.i.f(r12);     // Catch: Throwable -> L52
        goto L34
    L32:
        r12 = null;
    L25:
        r10 = 0;
    L20:
        r8 = null;
        goto L21
    L45:
        this.k.remove(r2.f);     // Catch: Throwable -> L52
        i r19 = (i) this.f.a;     // Catch: Throwable -> L52
        if (r19 == null) goto L48;
        r19.b("REMOVE " + r2.f + '\n');     // Catch: Throwable -> L52
        goto L48
    L9:
        if (r2.c.a == null) goto L13;
        r3.b();
        return;
    L51:
        throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + r13 + "\"");     // Catch: Throwable -> L52
    L52:
        th = move-exception;
        r3.b();
        throw th;
    }

    public final b d(String r6) {
        c0.e r3 = this.g;
        r3.a();
        g();     // Catch: Throwable -> L22
        c();     // Catch: Throwable -> L22
        if (s(r6) == false) goto L21;
        c r2 = (c) this.k.get(r6);     // Catch: Throwable -> L22
        if (r2 != null) goto L9;
        r2 = new c(this, r6);     // Catch: Throwable -> L22
        this.k.put(r6, r2);     // Catch: Throwable -> L22
    L11:
        b r1 = new b(this, r2);     // Catch: Throwable -> L22
        r2.c.a = r1;     // Catch: Throwable -> L22
        i r4 = (i) this.f.a;     // Catch: Throwable -> L22
        if (r4 == null) goto L14;
        r4.b("DIRTY " + r6 + '\n');     // Catch: Throwable -> L22
    L14:
        i r7 = (i) this.f.a;     // Catch: Throwable -> L22
        if (r7 == null) goto L17;
        r7.a();     // Catch: Throwable -> L22
    L17:
        b r8 = r1;
    L18:
        r3.b();
        return r8;
    L9:
        if (r2.c.a == null) goto L11;
        Logger.INSTANCE.d("DiskLruCache", "key: " + r6 + " is now in editing, return null!");     // Catch: Throwable -> L22
        r8 = null;
        goto L18
    L21:
        throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + r6 + "\"");     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        r3.b();
        throw th;
    }

    public final d e(String r11) {
        if (r11 == null) goto L48;
        c0.e r2 = this.g;
        r2.a();
        g();     // Catch: Throwable -> L45
        c();     // Catch: Throwable -> L45
        if (s(r11) == false) goto L43;
        c r0 = (c) this.k.get(r11);     // Catch: Throwable -> L45
        if (r0 != null) goto L10;
        r2.b();
        return null;
    L10:
        if (((Boolean) r0.b.a).booleanValue() == true) goto L13;
        r2.b();
        return null;
    L13:
        int r3 = this.p;     // Catch: Throwable -> L45
        g[] r4 = new bytekn.foundation.io.file.b[r3];     // Catch: Throwable -> L45
        bytekn.foundation.io.file.f[] r5 = new bytekn.foundation.io.file.f[r3];     // Catch: Throwable -> L45
        int r6 = 0;
        int r7 = 0;
    L15:
        if (r7 >= r3) goto L32;
        bytekn.foundation.io.file.f r8 = r0.a(r7);     // Catch: Exception -> L49 Throwable -> L45
        r5[r7] = r8;     // Catch: Exception -> L49 Throwable -> L45
        if (r8 == null) goto L23;
        String r9 = FileManager.a;     // Catch: Exception -> L49 Throwable -> L45
        String r10 = r8.b;     // Catch: Exception -> L49 Throwable -> L45
        if (r10 == null) goto L21;
        bytekn.foundation.io.file.b r12 = FileManager.j(r10);     // Catch: Exception -> L49 Throwable -> L45
    L22:
        r4[r7] = r12;     // Catch: Exception -> L49 Throwable -> L45
        goto L23
    L21:
        r12 = null;
    L23:
        r7 = r7 + 1;
    L25:
        if (r6 >= this.p) goto L30;
        g r13 = r4[r6];     // Catch: Throwable -> L45
        if (r13 == null) goto L30;
        String r1 = FileManager.a;     // Catch: Throwable -> L45
        FileManager.b(r13);     // Catch: Throwable -> L45
        r6 = r6 + 1;
    L30:
        r2.b();
        return null;
    L32:
        a0.b<Integer> r14 = this.e;     // Catch: Throwable -> L45
        r14.a = Integer.valueOf(((Number) r14.a).intValue() + 1);     // Catch: Throwable -> L45
        i r15 = (i) this.f.a;     // Catch: Throwable -> L45
        if (r15 == null) goto L35;
        r15.a.append("READ " + r11 + '\n');     // Catch: Throwable -> L45
    L35:
        i(r0);     // Catch: Throwable -> L45
        if (h() == false) goto L38;
        this.l.execute(this.m);     // Catch: Throwable -> L45
    L38:
        ((Number) r0.d.a).longValue();     // Catch: Throwable -> L45
        CollectionsKt.toLongArray(r0.a);     // Catch: Throwable -> L45
        d r16 = new d(r5, r4);     // Catch: Throwable -> L45
        r2.b();
        return r16;
    L43:
        q(r11);     // Catch: Throwable -> L45
        throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + r11 + "\"");     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        r2.b();
        throw th;
    L48:
        return null;
    }

    public final void i(c r3) {
        if (this.s == true) goto L5;
        j(r3);
        return;
    L5:
        if (a0.a.a() == true) goto L7;
        j(r3);
        return;
    L7:
        this.l.execute(new com.ss.ugc.effectplatform.cache.disklrucache.b(this, r3));
    }

    public final void j(c r6) {
        c0.e r1 = this.g;     // Catch: Exception -> L15
        r1.a();     // Catch: Exception -> L15
        z.a<Long> r2 = r6.e;     // Catch: Throwable -> L7
        int r3 = b0.a.a;     // Catch: Throwable -> L7
        r2.set(0, Long.valueOf(System.currentTimeMillis()));     // Catch: Throwable -> L7
        i r4 = (i) this.f.a;     // Catch: Throwable -> L7
        if (r4 == null) goto L9;
        r4.b("USE " + r6.f + r6.d() + '\n');     // Catch: Throwable -> L7
    L9:
        i r7 = (i) this.f.a;     // Catch: Throwable -> L7
        if (r7 == null) goto L12;
        r7.a();     // Catch: Throwable -> L7
        Unit r8 = Unit.INSTANCE;     // Catch: Throwable -> L7
    L12:
        r1.b();     // Catch: Exception -> L15
        return;
    L7:
        th = move-exception;
        r1.b();     // Catch: Exception -> L15
        throw th;     // Catch: Exception -> L15
    L15:
        e = move-exception;
        Logger.INSTANCE.e("DiskLruCache", "markEntryUsedSync ", e);
    }

    public final void k(String r5) {
        c0.e r1 = this.g;
        r1.a();
        g();     // Catch: Throwable -> L13
        c();     // Catch: Throwable -> L13
        if (s(r5) == false) goto L12;
        c r0 = (c) this.k.get(r5);     // Catch: Throwable -> L13
        if (r0 != null) goto L8;
        r0 = new c(this, r5);     // Catch: Throwable -> L13
        this.k.put(r5, r0);     // Catch: Throwable -> L13
    L8:
        i(r0);     // Catch: Throwable -> L13
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L13
        r1.b();
        return;
    L12:
        throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + r5 + "\"");     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        r1.b();
        throw th;
    }

    public final boolean o(String r19) {
        int r8 = StringsKt.indexOf$default(r19, ' ', 0, false, 6, null);
        int r9 = 0;
        if (r8 != (-1)) goto L5;
        return false;
    L5:
        int r11 = r8 + 1;
        int r1 = StringsKt.indexOf$default(r19, ' ', r11, false, 4, null);
        if (r1 != (-1)) goto L13;
        String r5 = r19.substring(r11);
        if (r8 == 6) goto L10;
    L14:
        c r6 = (c) this.k.get(r5);
        if (r6 != null) goto L18;
        r6 = new c(this, r5);
        this.k.put(r5, r6);
    L18:
        if (r1 == (-1)) goto L36;
        if (r8 != 5) goto L36;
        if (StringsKt.startsWith$default(r19, "CLEAN", false, 2, null) == false) goto L36;
        Object[] r2 = StringsKt.split$default(r19.substring(r1 + 1), new String[]{" "}, false, 0, 6, null).toArray(new String[0]);
        if (r2 == null) goto L35;
        String[] r3 = (String[]) r2;
        a0.b<Boolean> r4 = r6.b;
        r4.a = Boolean.TRUE;
        r6.c.a = null;
        if (r3.length == r6.g.p) goto L70;
        c.e(r3);
        throw null;
    L70:
        int r7 = r3.length;     // Catch: NumberFormatException -> L30
    L27:
        if (r9 >= r7) goto L66;
        r6.a.set(r9, Long.valueOf(CastLongProtector.parseLong(r3[r9])));     // Catch: NumberFormatException -> L30
        r9 = r9 + 1;
    L66:
        return true;
    L30:
        c.e(r3);
        throw null;
    L35:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    L36:
        if (r1 != (-1)) goto L38;
    L55:
        if (r1 != (-1)) goto L60;
        if (r8 != 5) goto L60;
        if (StringsKt.startsWith$default(r19, "DIRTY", false, 2, null) == false) goto L60;
        a0.b<b> r10 = r6.c;
        r10.a = new b(this, r6);
    L60:
        if (r1 == (-1)) goto L62;
    L67:
        return false;
    L62:
        if (r8 != 4) goto L67;
        if (StringsKt.startsWith$default(r19, "READ", false, 2, null) == true) goto L66;
    L38:
        if (r8 != 3) goto L55;
        if (StringsKt.startsWith$default(r19, "USE", false, 2, null) == false) goto L55;
        Object[] r12 = StringsKt.split$default(r19.substring(r1 + 1), new String[]{" "}, false, 0, 6, null).toArray(new String[0]);
        if (r12 == null) goto L54;
        String[] r13 = (String[]) r12;
        if (r13.length == r6.g.p) goto L68;
        c.e(r13);
        throw null;
    L68:
        int r14 = r13.length;     // Catch: NumberFormatException -> L49
    L46:
        if (r9 >= r14) goto L66;
        r6.e.set(r9, Long.valueOf(CastLongProtector.parseLong(r13[r9])));     // Catch: NumberFormatException -> L49
        r9 = r9 + 1;
    L49:
        c.e(r13);
        throw null;
    L54:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    L10:
        if (StringsKt.startsWith$default(r19, "REMOVE", false, 2, null) == false) goto L14;
        this.k.remove(r5);
        return true;
    L13:
        r5 = r19.substring(r11, r1);
        goto L14
    }

    public final boolean q(String r10) {
        int r2 = 0;
        if (r10 == null) goto L37;
        c0.e r3 = this.g;
        r3.a();
        g();     // Catch: Throwable -> L34
        c();     // Catch: Throwable -> L34
        if (s(r10) == false) goto L33;
        c r1 = (c) this.k.get(r10);     // Catch: Throwable -> L34
        if (r1 != null) goto L10;
    L30:
        r3.b();
        return false;
    L10:
        if (r1.c.a != null) goto L30;
        a0.b<Integer> r4 = this.e;     // Catch: Throwable -> L34
        r4.a = Integer.valueOf(((Number) r4.a).intValue() + 1);     // Catch: Throwable -> L34
        i r5 = (i) this.f.a;     // Catch: Throwable -> L34
        if (r5 == null) goto L15;
        r5.a.append("REMOVE " + r10 + '\n');     // Catch: Throwable -> L34
    L15:
        i r0 = (i) this.f.a;     // Catch: Throwable -> L34
        if (r0 == null) goto L18;
        r0.a();     // Catch: Throwable -> L34
    L18:
        this.k.remove(r10);     // Catch: Throwable -> L34
        int r11 = this.p;     // Catch: Throwable -> L34
    L19:
        if (r2 >= r11) goto L26;
        bytekn.foundation.io.file.f r6 = r1.a(r2);     // Catch: Throwable -> L34
        com.ss.ugc.effectplatform.util.i.a.delete(r6);     // Catch: Exception -> L23 Throwable -> L34
        a0.b<Long> r7 = this.d;     // Catch: Throwable -> L34
        r7.a = Long.valueOf(((Number) r7.a).longValue() - ((Number) r1.a.get(r2)).longValue());     // Catch: Throwable -> L34
        r1.a.set(r2, 0L);     // Catch: Throwable -> L34
        r2 = r2 + 1;     // Catch: Throwable -> L34
        goto L19
    L24:
        throw new Exception("failed to delete " + r6);     // Catch: Throwable -> L34
    L26:
        if (h() == false) goto L28;
        this.l.execute(this.m);     // Catch: Throwable -> L34
    L28:
        r3.b();
        return true;
    L33:
        throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + r10 + "\"");     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        r3.b();
        throw th;
    L37:
        return false;
    }

    public static final void a(a r10, b r11, boolean r12) {
        c0.e r0 = r10.g;
        r0.a();
        c r1 = r11.d;     // Catch: Throwable -> L65
        if ((!Intrinsics.areEqual((b) r1.c.a, r11)) == true) goto L64;
        int r2 = 0;
        if (r12 == true) goto L8;
    L21:
        int r13 = r10.p;     // Catch: Throwable -> L65
    L22:
        bytekn.foundation.io.file.d r3 = null;
        if (r2 >= r13) goto L42;
        bytekn.foundation.io.file.f r4 = r1.b(r2);     // Catch: Throwable -> L65
        if (r4 == null) goto L41;
        if (r12 == false) goto L40;
        String r5 = FileManager.a;     // Catch: Throwable -> L65
        if (FileManager.c(r4) == false) goto L41;
        bytekn.foundation.io.file.f r6 = r1.a(r2);     // Catch: Throwable -> L65
        FileManager.p(r4, r6);     // Catch: Throwable -> L65
        long r7 = ((Number) r1.a.get(r2)).longValue();     // Catch: Throwable -> L65
        if (r6 == null) goto L34;
        String r8 = r6.b;     // Catch: Throwable -> L65
        if (r8 == null) goto L34;
        r3 = FileManager.a(new PolarisFileWrapper(r8));     // Catch: Throwable -> L65
    L34:
        if (r3 == null) goto L38;
        Long r9 = r3.f;     // Catch: Throwable -> L65
        if (r9 == null) goto L38;
        long r14 = r9.longValue();     // Catch: Throwable -> L65
    L39:
        r1.a.set(r2, Long.valueOf(r14));     // Catch: Throwable -> L65
        a0.b<Long> r15 = r10.d;     // Catch: Throwable -> L65
        r15.a = Long.valueOf((((Number) r15.a).longValue() - r7) + r14);     // Catch: Throwable -> L65
    L38:
        r14 = 0;
        goto L39
    L40:
        com.ss.ugc.effectplatform.util.i.a.delete(r4);     // Catch: Throwable -> L65
    L41:
        r2 = r2 + 1;     // Catch: Throwable -> L65
        goto L22
    L42:
        a0.b<Integer> r16 = r10.e;     // Catch: Throwable -> L65
        r16.a = Integer.valueOf(((Number) r16.a).intValue() + 1);     // Catch: Throwable -> L65
        r1.c.a = null;     // Catch: Throwable -> L65
        if ((((Boolean) r1.b.a).booleanValue() | r12) == false) goto L49;
        r1.b.a = Boolean.TRUE;     // Catch: Throwable -> L65
        i r17 = (i) r10.f.a;     // Catch: Throwable -> L65
        if (r17 == null) goto L47;
        r17.b("CLEAN " + r1.f + r1.c() + '\n');     // Catch: Throwable -> L65
    L47:
        if (r12 == false) goto L52;
        a0.b<Long> r18 = r10.j;     // Catch: Throwable -> L65
        r18.a = Long.valueOf(((Number) r18.a).longValue() + 1);     // Catch: Throwable -> L65
        r1.d.a = r10.j.a;     // Catch: Throwable -> L65
    L52:
        i r19 = (i) r10.f.a;     // Catch: Throwable -> L65
        if (r19 == null) goto L56;
        r19.a();     // Catch: Throwable -> L65
    L56:
        if (((Number) r10.d.a).longValue() <= r10.q) goto L58;
    L59:
        r10.l.execute(r10.m);     // Catch: Throwable -> L65
    L60:
        Unit r110 = Unit.INSTANCE;     // Catch: Throwable -> L65
    L61:
        r0.b();
        return;
    L58:
        if (r10.h() == false) goto L60;
    L49:
        r10.k.remove(r1.f);     // Catch: Throwable -> L65
        i r111 = (i) r10.f.a;     // Catch: Throwable -> L65
        if (r111 == null) goto L52;
        r111.b("REMOVE " + r1.f + '\n');     // Catch: Throwable -> L65
        goto L52
    L8:
        if (((Boolean) r1.b.a).booleanValue() == true) goto L21;
        int r20 = r10.p;     // Catch: Throwable -> L65
        int r21 = 0;
    L10:
        if (r21 >= r20) goto L21;
        if (((boolean[]) r11.a.a)[r21] == false) goto L19;
        if (r1.b(r21) == null) goto L18;
        String r22 = FileManager.a;     // Catch: Throwable -> L65
        if (FileManager.c(r1.b(r21)) == true) goto L18;
        r11.a();     // Catch: Throwable -> L65
    L18:
        r21 = r21 + 1;     // Catch: Throwable -> L65
        goto L10
    L19:
        r11.a();     // Catch: Throwable -> L65
        throw new IllegalStateException("Newly created entry didn't create value for index " + r21);     // Catch: Throwable -> L65
    L64:
        throw new IllegalStateException();     // Catch: Throwable -> L65
    L65:
        th = move-exception;
        r0.b();
        throw th;
    }

    public a(String r1, int r2, int r3, long r4, com.ss.ugc.effectplatform.cache.disklrucache.e r6, boolean r7, boolean r8, boolean r9) {
        this.n = r1;
        this.o = r2;
        this.p = r3;
        this.q = r4;
        this.r = r6;
        this.s = r7;
        this.t = r8;
        this.u = r9;
        this.d = new a0.b(0L);
        this.e = new a0.b(0);
        bytekn.foundation.io.file.f r5 = null;
        this.f = new a0.b(null);
        this.g = new c0.e();
        Boolean r10 = Boolean.FALSE;
        this.h = new a0.b(r10);
        this.i = new a0.b(r10);
        this.j = new a0.b(0L);
        this.k = new z.b(false);
        this.l = new AsyncExecutor();
        this.m = new e(this);
        if (r1 == null) goto L5;
        File r11 = new PolarisFileWrapper(r1).getAbsoluteFile();
    L6:
        if (r11 != null) goto L8;
        bytekn.foundation.io.file.f r12 = null;
    L9:
        if (r12 != null) goto L11;
        Intrinsics.throwNpe();
    L11:
        this.a = r12;
        if (r1 == null) goto L14;
        File r13 = new PolarisFileWrapper(r1).getAbsoluteFile();
    L15:
        if (r13 != null) goto L17;
        bytekn.foundation.io.file.f r14 = null;
    L18:
        if (r14 != null) goto L20;
        Intrinsics.throwNpe();
    L20:
        this.b = r14;
        if (r1 == null) goto L23;
        File r15 = new PolarisFileWrapper(r1).getAbsoluteFile();
    L24:
        if (r15 == null) goto L27;
        r5 = new bytekn.foundation.io.file.f(new PolarisFileWrapper(r15.getAbsolutePath(), "journal.bkp").getAbsoluteFile().getAbsolutePath());
    L27:
        if (r5 != null) goto L29;
        Intrinsics.throwNpe();
    L29:
        this.c = r5;
        return;
    L23:
        r15 = null;
        goto L24
    L17:
        r14 = new bytekn.foundation.io.file.f(new PolarisFileWrapper(r13.getAbsolutePath(), "journal.tmp").getAbsoluteFile().getAbsolutePath());
        goto L18
    L14:
        r13 = null;
        goto L15
    L8:
        r12 = new bytekn.foundation.io.file.f(new PolarisFileWrapper(r11.getAbsolutePath(), "journal").getAbsoluteFile().getAbsolutePath());
        goto L9
    L5:
        r11 = null;
        goto L6
    }
}
