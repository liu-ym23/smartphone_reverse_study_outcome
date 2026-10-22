package com.ss.ugc.effectplatform.cache;

import a0.b;
import bytekn.foundation.io.file.FileManager;
import bytekn.foundation.io.file.g;
import bytekn.foundation.logger.Logger;
import c0.e;
import com.ss.ugc.effectplatform.download.d;
import com.ss.ugc.effectplatform.exception.CurrentEditingException;
import com.ss.ugc.effectplatform.exception.MD5Exception;
import com.ss.ugc.effectplatform.extension.ByteArrayExKt;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class c implements j {
    public final b<com.ss.ugc.effectplatform.cache.disklrucache.a> a;
    public final e b;
    public final String c;
    public final int d;
    public final int e;
    public final long f;
    public final com.ss.ugc.effectplatform.cache.disklrucache.e g;
    public final boolean h;
    public final boolean i;
    public final boolean j;

    public static final class a {
    }

    static {
    }

    @Override // com.ss.ugc.effectplatform.cache.j
    public void c(List<String> r1) {
    }

    public final com.ss.ugc.effectplatform.cache.disklrucache.a e() {
        e r1 = this.b;
        r1.a();
        Object r2 = this.a.a;     // Catch: Throwable -> L27
        if (r2 == null) goto L12;
        com.ss.ugc.effectplatform.cache.disklrucache.a r3 = (com.ss.ugc.effectplatform.cache.disklrucache.a) r2;     // Catch: Throwable -> L27
        String r4 = FileManager.a;     // Catch: Throwable -> L27
        if (FileManager.d(r3.n) == true) goto L8;
    L10:
        boolean r5 = false;
    L11:
        if (r5 != true) goto L12;
    L24:
        com.ss.ugc.effectplatform.cache.disklrucache.a r0 = (com.ss.ugc.effectplatform.cache.disklrucache.a) this.a.a;     // Catch: Throwable -> L27
        r1.b();
        return r0;
    L8:
        if (FileManager.c(r3.a) == false) goto L10;
        r5 = true;
    L12:
        f();     // Catch: Throwable -> L27
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L15
        com.ss.ugc.effectplatform.cache.disklrucache.a.C0011a r7 = com.ss.ugc.effectplatform.cache.disklrucache.a.w;     // Catch: Throwable -> L15
        String r8 = this.c;     // Catch: Throwable -> L15
        int r9 = this.d;     // Catch: Throwable -> L15
        int r10 = this.e;     // Catch: Throwable -> L15
        long r11 = this.f;     // Catch: Throwable -> L15
        com.ss.ugc.effectplatform.cache.disklrucache.e r12 = this.g;     // Catch: Throwable -> L15
        boolean r13 = this.h;     // Catch: Throwable -> L15
        boolean r14 = this.i;     // Catch: Throwable -> L15
        boolean r15 = this.j;     // Catch: Throwable -> L15
        r7.getClass();     // Catch: Throwable -> L15
        Object r16 = Result.constructor-impl(com.ss.ugc.effectplatform.cache.disklrucache.a.C0011a.a(r8, r9, r10, r11, r12, r13, r14, r15));     // Catch: Throwable -> L15
    L17:
        Throwable r17 = Result.exceptionOrNull-impl(r16);     // Catch: Throwable -> L27
        if (r17 == null) goto L20;
        Logger.e$default(Logger.INSTANCE, "DiskLruCacheImpl", "DiskLruCache.open fails, ex: " + r17, null, 4, null);     // Catch: Throwable -> L27
    L20:
        b<com.ss.ugc.effectplatform.cache.disklrucache.a> r18 = this.a;     // Catch: Throwable -> L27
        if (Result.isFailure-impl(r16) == false) goto L23;
        r16 = null;
    L23:
        r18.a = r16;     // Catch: Throwable -> L27
        goto L24
    L15:
        th = move-exception;
        Result.Companion r19 = Result.Companion;     // Catch: Throwable -> L27
        r16 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        r1.b();
        throw th;
    }

    public void f() {
        Logger.INSTANCE.d("DiskLruCacheImpl", this.c + " is creating");
    }

    @Override // com.ss.ugc.effectplatform.cache.j
    public void clear() {
        com.ss.ugc.effectplatform.cache.disklrucache.a r0 = e();     // Catch: Exception -> L9
        if (r0 == null) goto L5;
        r0.delete();     // Catch: Exception -> L9
    L5:
        com.ss.ugc.effectplatform.cache.disklrucache.a r1 = e();     // Catch: Exception -> L9
        if (r1 == null) goto L14;
        r1.m();     // Catch: Exception -> L9
        return;
    L14:
        return;
    L9:
        e = move-exception;
        Logger.INSTANCE.e("DiskLruCacheImpl", "clear: exception", e);
    }

    @Override // com.ss.ugc.effectplatform.cache.j
    public void d(String r2) {
        com.ss.ugc.effectplatform.cache.disklrucache.a.w.getClass();
        String r3 = com.ss.ugc.effectplatform.cache.disklrucache.a.C0011a.c(r2);
        com.ss.ugc.effectplatform.cache.disklrucache.a r0 = e();
        if (r0 == null) goto L6;
        r0.k(r3);
        return;
    }

    @Override // com.ss.ugc.effectplatform.cache.j
    public final boolean has(String r8) {
        com.ss.ugc.effectplatform.cache.disklrucache.a.w.getClass();
        String r9 = com.ss.ugc.effectplatform.cache.disklrucache.a.C0011a.c(r8);
        com.ss.ugc.effectplatform.cache.disklrucache.a r0 = e();
        boolean r1 = false;
        if (r0 == null) goto L28;
        e r4 = r0.g;
        r4.a();
        r0.c();     // Catch: Throwable -> L25
        if (com.ss.ugc.effectplatform.cache.disklrucache.a.s(r9) == false) goto L24;
        com.ss.ugc.effectplatform.cache.disklrucache.a.c r3 = (com.ss.ugc.effectplatform.cache.disklrucache.a.c) r0.k.get(r9);     // Catch: Throwable -> L25
        if (r3 != null) goto L10;
    L22:
        r4.b();
        goto L28
    L10:
        if (((Boolean) r3.b.a).booleanValue() == false) goto L22;
        r1 = true;
        b<Integer> r5 = r0.e;     // Catch: Exception -> L29 Throwable -> L25
        r5.a = Integer.valueOf(((Number) r5.a).intValue() + 1);     // Catch: Exception -> L29 Throwable -> L25
        bytekn.foundation.io.file.i r6 = (bytekn.foundation.io.file.i) r0.f.a;     // Catch: Exception -> L29 Throwable -> L25
        if (r6 == null) goto L16;
        r6.b("READ " + r9 + '\n');     // Catch: Exception -> L29 Throwable -> L25
    L16:
        r0.i(r3);     // Catch: Exception -> L29 Throwable -> L25
        bytekn.foundation.io.file.i r10 = (bytekn.foundation.io.file.i) r0.f.a;     // Catch: Exception -> L29 Throwable -> L25
        if (r10 == null) goto L20;
        r10.a();     // Catch: Exception -> L29 Throwable -> L25
    L20:
        if (r0.h() == false) goto L22;
        r0.l.execute(r0.m);     // Catch: Exception -> L29 Throwable -> L25
        goto L22
    L24:
        throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + r9 + "\"");     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        r4.b();
        throw th;
    L28:
        return r1;
    }

    @Override // com.ss.ugc.effectplatform.cache.j
    public final bytekn.foundation.io.file.b queryToStream(String r6) {
        com.ss.ugc.effectplatform.cache.disklrucache.a.w.getClass();
        String r0 = com.ss.ugc.effectplatform.cache.disklrucache.a.C0011a.c(r6);
        com.ss.ugc.effectplatform.cache.disklrucache.a r2 = e();     // Catch: Exception -> L7
        if (r2 == null) goto L9;
        com.ss.ugc.effectplatform.cache.disklrucache.a.d r7 = r2.e(r0);     // Catch: Exception -> L7
    L10:
        if (r7 != null) goto L12;
        return null;
    L12:
        return r7.b[0];
    L9:
        r7 = null;
    L7:
        e = move-exception;
        Logger.INSTANCE.e("DiskLruCacheImpl", "get key:" + r6 + " exception", e);
        goto L9
    }

    @Override // com.ss.ugc.effectplatform.cache.j
    public final String queryToValue(String r1) {
        bytekn.foundation.io.file.b r2 = queryToStream(r1);
        if (r2 != null) goto L5;
        return null;
    L5:
        return FileManager.h(r2);
    }

    @Override // com.ss.ugc.effectplatform.cache.j
    public final boolean remove(String r5) {
        com.ss.ugc.effectplatform.cache.disklrucache.a.w.getClass();
        String r0 = com.ss.ugc.effectplatform.cache.disklrucache.a.C0011a.c(r5);
        com.ss.ugc.effectplatform.cache.disklrucache.a r1 = e();     // Catch: Exception -> L7
        if (r1 == null) goto L9;
        return r1.q(r0);
    L9:
        return false;
    L7:
        e = move-exception;
        Logger.INSTANCE.e("DiskLruCacheImpl", "remove key:" + r5 + " exception", e);
        goto L9
    }

    @Override // com.ss.ugc.effectplatform.cache.j
    public final void removePattern(String r7) {
        if (r7 == null) goto L19;
        com.ss.ugc.effectplatform.cache.disklrucache.a.w.getClass();
        int r0 = r7.length();
        char[] r1 = new char[r0];
        int r3 = 0;
    L4:
        if (r3 >= r0) goto L9;
        char r4 = r7.charAt(r3);
        r1[r3] = r4;
        if (r4 != FileManager.a.charAt(0)) goto L8;
        r1[r3] = '_';
    L8:
        r3 = r3 + 1;
        goto L4
    L9:
        Regex r2 = new Regex(new String(r1));
        com.ss.ugc.effectplatform.cache.disklrucache.a r8 = e();
        if (r8 == null) goto L28;
        Set<String> r9 = r8.f();
        if (r9 == null) goto L29;
        Iterator<T> r10 = r9.iterator();
    L15:
        if (r10.hasNext() == false) goto L30;
        String r5 = (String) r10.next();
        if (r2.matches(r5) == false) goto L15;
        remove(r5);
        goto L15
    L30:
        return;
    L29:
        return;
    L28:
        return;
    }

    @Override // com.ss.ugc.effectplatform.cache.j
    public final void a(long r13, Function2<? super Integer, ? super Long, Unit> r15) {
        com.ss.ugc.effectplatform.cache.disklrucache.a r0 = e();
        if (r0 == null) goto L44;
        Logger.INSTANCE.d("DiskLruCache", "try to removeUnused");
        LinkedHashSet r1 = new LinkedHashSet();
        e r2 = r0.g;
        r2.a();
        r0.g();     // Catch: Throwable -> L41
        r0.c();     // Catch: Throwable -> L41
        Iterator r4 = r0.k.entrySet().iterator();     // Catch: Throwable -> L41
    L7:
        if (r4.hasNext() == false) goto L25;
        Map.Entry r5 = (Map.Entry) r4.next();     // Catch: Throwable -> L41
        if (((com.ss.ugc.effectplatform.cache.disklrucache.a.c) r5.getValue()).e.size() > 0) goto L11;
    L15:
        int r7 = b0.a.a;     // Catch: Throwable -> L41
        if ((System.currentTimeMillis() - ((Number) ((com.ss.ugc.effectplatform.cache.disklrucache.a.c) r5.getValue()).e.get(0)).longValue()) > r13) goto L17;
        Logger.INSTANCE.d("DiskLruCache", ((String) r5.getKey()) + " not exceeding the usage time");     // Catch: Throwable -> L41
        goto L7
    L17:
        com.ss.ugc.effectplatform.cache.disklrucache.e r6 = r0.r;     // Catch: Throwable -> L41
        if (r6 == null) goto L23;
        if (r6.isAllowed((String) r5.getKey()) == false) goto L23;
        Logger.INSTANCE.d("DiskLruCache", ((String) r5.getKey()) + " cannot remove because in allowlist");     // Catch: Throwable -> L41
    L23:
        r1.add(r5.getKey());     // Catch: Throwable -> L41
        goto L7
    L11:
        if (((Number) ((com.ss.ugc.effectplatform.cache.disklrucache.a.c) r5.getValue()).e.get(0)).longValue() > 0) goto L15;
        String r8 = FileManager.a;     // Catch: Throwable -> L41
        if (FileManager.c(((com.ss.ugc.effectplatform.cache.disklrucache.a.c) r5.getValue()).a(0)) == false) goto L15;
        r0.i((com.ss.ugc.effectplatform.cache.disklrucache.a.c) r5.getValue());     // Catch: Throwable -> L41
        goto L15
    L25:
        Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L41
        r2.b();
        Iterator r16 = r1.iterator();
        long r3 = 0;
        int r17 = 0;
    L28:
        if (r16.hasNext() == false) goto L40;
        String r9 = (String) r16.next();
        Logger.INSTANCE.d("DiskLruCache", "remove " + r9 + " because that have not been used for a period of time.");
        com.ss.ugc.effectplatform.cache.disklrucache.a.c r10 = (com.ss.ugc.effectplatform.cache.disklrucache.a.c) r0.k.get(r9);
        if (r10 == null) goto L36;
        z.a<Long> r11 = r10.a;
        if (r11 == null) goto L36;
        Long r12 = (Long) r11.get(0);
        if (r12 == null) goto L36;
        long r18 = r12.longValue();
    L38:
        if (r0.q(r9) == false) goto L28;
        r17 = r17 + 1;
        r3 = r3 + r18;
    L36:
        r18 = 0;
        goto L38
    L40:
        r15.invoke(Integer.valueOf(r17), Long.valueOf(r3));
        return;
    L41:
        th = move-exception;
        r2.b();
        throw th;
    }

    @Override // com.ss.ugc.effectplatform.cache.j
    public final long b(String r13, bytekn.foundation.io.file.b r14) {
        com.ss.ugc.effectplatform.cache.disklrucache.a.w.getClass();
        String r2 = com.ss.ugc.effectplatform.cache.disklrucache.a.C0011a.c(r13);
        long r3 = 0;
        com.ss.ugc.effectplatform.cache.disklrucache.a.b r5 = null;
        com.ss.ugc.effectplatform.cache.disklrucache.a r6 = e();     // Catch: Throwable -> L25 Exception -> L27
        if (r6 == null) goto L7;
        com.ss.ugc.effectplatform.cache.disklrucache.a.b r4 = r6.d(r2);     // Catch: Throwable -> L25 Exception -> L27
    L8:
        if (r4 != null) goto L54;
    L18:
        if (r5 == null) goto L22;
        r3 = ((bytekn.foundation.io.file.j) r5).b;     // Catch: Exception -> L16 Throwable -> L25
    L16:
        e = e;
    L21:
        com.ss.ugc.effectplatform.cache.disklrucache.a.b r11 = r5;
        r5 = r4;
        com.ss.ugc.effectplatform.cache.disklrucache.a.b r7 = r11;
    L48:
        Logger.INSTANCE.e("DiskLruCacheImpl", "save key:" + r13 + " exception", e);     // Catch: Throwable -> L38
        if (r5 != null) goto L49;
    L35:
        if (r7 == null) goto L37;
        r7.close();     // Catch: Exception -> L45
    L55:
        goto L37
    L49:
        r5.a();     // Catch: Exception -> L33 Throwable -> L38
    L33:
        e = move-exception;
        Logger.e$default(Logger.INSTANCE, "DiskLruCacheImpl", "abort :" + e, null, 4, null);     // Catch: Throwable -> L38
    L38:
        th = th;
        com.ss.ugc.effectplatform.cache.disklrucache.a.b r8 = r7;
    L40:
        r5 = r8;
    L41:
        if (r5 != null) goto L46;
    L43:
        throw th;
    L46:
        r5.close();     // Catch: Exception -> L44
    L22:
        if (r5 == null) goto L37;
        r5.close();     // Catch: Exception -> L45
        goto L55
    L54:
        r8 = new bytekn.foundation.io.file.j(r4.c());     // Catch: Exception -> L16 Throwable -> L25
        com.ss.ugc.effectplatform.util.i r9 = com.ss.ugc.effectplatform.util.i.a;     // Catch: Throwable -> L12 Exception -> L14
        com.ss.ugc.effectplatform.util.i.b(r14, r8, 0, null);     // Catch: Throwable -> L12 Exception -> L14
        r4.b();     // Catch: Throwable -> L12 Exception -> L14
        r5 = r8;
        goto L18
    L14:
        e = e;
        r5 = r8;
    L12:
        th = th;
        goto L40
    L7:
        r4 = null;
    L27:
        e = e;
        r7 = null;
    L25:
        th = th;
    L37:
        return r3;
    }

    @Override // com.ss.ugc.effectplatform.cache.j
    public final long save(String r13, String r14) {
        com.ss.ugc.effectplatform.cache.disklrucache.a.w.getClass();
        String r15 = com.ss.ugc.effectplatform.cache.disklrucache.a.C0011a.c(r13);
        long r2 = 0;
        com.ss.ugc.effectplatform.cache.disklrucache.a.b r4 = null;
        com.ss.ugc.effectplatform.cache.disklrucache.a r5 = e();     // Catch: Throwable -> L25 Exception -> L27
        if (r5 == null) goto L7;
        com.ss.ugc.effectplatform.cache.disklrucache.a.b r16 = r5.d(r15);     // Catch: Throwable -> L25 Exception -> L27
    L8:
        if (r16 != null) goto L51;
    L18:
        if (r4 == null) goto L22;
        r2 = ((bytekn.foundation.io.file.j) r4).b;     // Catch: Exception -> L16 Throwable -> L25
    L16:
        Exception e = e;
    L21:
        com.ss.ugc.effectplatform.cache.disklrucache.a.b r11 = r4;
        r4 = r16;
        com.ss.ugc.effectplatform.cache.disklrucache.a.b r17 = r11;
    L56:
        Logger.e$default(Logger.INSTANCE, "DiskLruCacheImpl", "save :" + e, null, 4, null);     // Catch: Throwable -> L38
        if (r4 != null) goto L58;
    L35:
        if (r17 != null) goto L52;
    L37:
        return 0;
    L52:
        r17.close();     // Catch: Exception -> L45
        goto L37
    L58:
        r4.a();     // Catch: Exception -> L33 Throwable -> L38
    L33:
        e = move-exception;
        Logger.e$default(Logger.INSTANCE, "DiskLruCacheImpl", "abort :" + e, null, 4, null);     // Catch: Throwable -> L38
    L38:
        th = move-exception;
        com.ss.ugc.effectplatform.cache.disklrucache.a.b r6 = r17;
        th = th;
    L40:
        r4 = r6;
    L41:
        if (r4 != null) goto L54;
    L43:
        throw th;
    L54:
        r4.close();     // Catch: Exception -> L44
    L22:
        if (r4 != null) goto L49;
    L24:
        return r2;
    L49:
        r4.close();     // Catch: Exception -> L46
        goto L24
    L51:
        r6 = new bytekn.foundation.io.file.j(r16.c());     // Catch: Exception -> L16 Throwable -> L25
        byte[] r18 = ByteArrayExKt.a(r14);     // Catch: Throwable -> L12 Exception -> L14
        r6.b(r18, r18.length);     // Catch: Throwable -> L12 Exception -> L14
        r6.a();     // Catch: Throwable -> L12 Exception -> L14
        r6.close();     // Catch: Throwable -> L12 Exception -> L14
        r16.b();     // Catch: Throwable -> L12 Exception -> L14
        r4 = r6;
        goto L18
    L14:
        e = e;
        r4 = r6;
    L12:
        th = th;
        goto L40
    L7:
        r16 = null;
    L25:
        th = th;
    L27:
        e = move-exception;
        e = e;
        r17 = null;
        goto L56
    }

    public final Pair g(String r16, d r17, String r18, long r19, Function2 r21) {
        g r2 = "editor in currently editing!, key: ";
        g r6 = null;
        com.ss.ugc.effectplatform.cache.disklrucache.a r7 = e();     // Catch: Throwable -> L36 Exception -> L38
        if (r7 == null) goto L7;
        g r8 = r7.d(r16);     // Catch: Throwable -> L36 Exception -> L38
    L8:
        if (r8 == null) goto L60;
        r2 = new bytekn.foundation.io.file.j(r8.c());     // Catch: Exception -> L27 Throwable -> L36
    L58:
        com.ss.ugc.effectplatform.util.i r9 = com.ss.ugc.effectplatform.util.i.a;     // Catch: Throwable -> L22 Exception -> L24
        String r10 = com.ss.ugc.effectplatform.util.i.c(r17, r2, r19, r21);     // Catch: Throwable -> L22 Exception -> L24
        if (Intrinsics.areEqual(r10, r18) == false) goto L18;
        r8.b();     // Catch: Throwable -> L22 Exception -> L24
        StringBuilder r3 = new StringBuilder();     // Catch: Throwable -> L22 Exception -> L24
    L14:
        r3.append(this.c);     // Catch: Exception -> L20 Throwable -> L44
        String r4 = FileManager.a;     // Catch: Exception -> L20 Throwable -> L44
        r3.append(FileManager.a);     // Catch: Exception -> L20 Throwable -> L44
        r3.append(r16);     // Catch: Exception -> L20 Throwable -> L44
        Pair r0 = new Pair(r3.toString(), Boolean.TRUE);     // Catch: Exception -> L20 Throwable -> L44
        FileManager.b(r2);
        return r0;
    L18:
        Logger.e$default(Logger.INSTANCE, "DiskLruCacheImpl", "write: " + r16 + " md5 not match! expected md: " + r18 + ", actual md5: " + r10, null, 4, null);     // Catch: Exception -> L20 Throwable -> L44
        throw new MD5Exception("write: " + r16 + " md5 not match! expected md: " + r18 + ", actual md5: " + r10);     // Catch: Exception -> L20 Throwable -> L44
    L20:
        e = e;
    L26:
        r6 = r2;
    L35:
        r6 = r8;
    L40:
        Logger.INSTANCE.e("DiskLruCacheImpl", "write: " + r16 + " ioException", e);     // Catch: Throwable -> L44
        if (r6 != null) goto L50;
    L43:
        throw e;     // Catch: Throwable -> L44
    L50:
        r6.a();     // Catch: Exception -> L49 Throwable -> L44
    L24:
        e = e;
    L22:
        th = th;
    L45:
        r6 = r2;
    L46:
        if (r6 == null) goto L48;
        String r1 = FileManager.a;
        FileManager.b(r6);
    L48:
        throw th;
    L27:
        e = e;
        goto L35
    L60:
        Logger.e$default(Logger.INSTANCE, "DiskLruCacheImpl", "editor in currently editing!, key: ".concat(r16), null, 4, null);     // Catch: Throwable -> L32 Exception -> L34
        throw new CurrentEditingException("editor in currently editing!, key: ".concat(r16));     // Catch: Throwable -> L32 Exception -> L34
    L34:
        e = e;
    L32:
        th = th;
        goto L46
    L7:
        r8 = null;
    L38:
        e = e;
    L36:
        th = th;
    L44:
        th = th;
        goto L45
    }

    public c(String r6, int r7, long r8, com.ss.ugc.effectplatform.cache.disklrucache.e r10, boolean r11, boolean r12, boolean r13, int r14) {
        if ((r14 & 2) == 0) goto L6;
        r7 = 0;
    L6:
        if ((r14 & 4) == 0) goto L8;
        int r0 = 1;
    L10:
        if ((r14 & 16) == 0) goto L13;
        r10 = null;
    L13:
        if ((r14 & 32) == 0) goto L16;
        r11 = false;
    L16:
        if ((r14 & 64) == 0) goto L19;
        r12 = true;
    L19:
        if ((r14 & 128) == 0) goto L21;
        r13 = false;
    L21:
        this.c = r6;
        this.d = r7;
        this.e = r0;
        this.f = r8;
        this.g = r10;
        this.h = r11;
        this.i = r12;
        this.j = r13;
        this.a = new b(null);
        this.b = new e();
        return;
    L8:
        r0 = 0;
        goto L10
    }
}
