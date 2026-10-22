package com.larus.uaigc.helper;

import android.net.Uri;
import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import java.util.LinkedList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class m {
    public static final m a = null;
    public static final Lazy b = null;
    public static final Keva c = null;
    public static final Lazy d = null;
    public static volatile a e;

    public static final class a {
        public final String a;
        public final String b;
        public final String c;
        public final long d;
        public final String e;
        public final String f;
        public final long g;

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof a) == true) goto L8;
            return false;
        L8:
            a r9 = (a) r8;
            if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r9.c) == true) goto L18;
            return false;
        L18:
            if (this.d == r9.d) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r9.e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f, r9.f) == true) goto L27;
            return false;
        L27:
            if (this.g == r9.g) goto L29;
            return false;
        L29:
            return true;
        }

        public final int hashCode() {
            int r0 = ((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
            long r1 = this.d;
            int r2 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
            String r3 = this.e;
            int r4 = 0;
            if (r3 != null) goto L5;
            int r5 = 0;
        L6:
            int r6 = (r2 + r5) * 31;
            String r7 = this.f;
            if (r7 == null) goto L10;
            r4 = r7.hashCode();
        L10:
            long r8 = this.g;
            return ((r6 + r4) * 31) + ((int) (r8 ^ (r8 >>> 32)));
        L5:
            r5 = r3.hashCode();
            goto L6
        }

        public final String toString() {
            return "ReuseRecord(candidateKey=" + this.a + ", sourceMd5=" + this.b + ", preprocessedFilePath=" + this.c + ", preprocessedFileSize=" + this.d + ", preprocessedFileType=" + this.e + ", preprocessedResultCode=" + this.f + ", createTimeMs=" + this.g + ')';
        }

        public a(String r4, String r5, String r6, long r7, String r9, String r10) {
            long r0 = System.currentTimeMillis();
            Intrinsics.checkNotNullParameter(r4, "candidateKey");
            Intrinsics.checkNotNullParameter(r5, "sourceMd5");
            Intrinsics.checkNotNullParameter(r6, "preprocessedFilePath");
            this.a = r4;
            this.b = r5;
            this.c = r6;
            this.d = r7;
            this.e = r9;
            this.f = r10;
            this.g = r0;
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"com/larus/uaigc/helper/CreationImagePreprocessReuseCache$getLruKeys$1$1", "Lcom/google/gson/reflect/TypeToken;", "", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    public static final class b extends TypeToken<List<? extends String>> {
        public b() {
        }
    }

    public m() {
    }

    static {
        a = new m();
        b = LazyKt.lazy(new k());
        c = Keva.getRepo("creation_image_preprocess_reuse_cache", 0);
        d = LazyKt.lazy(new l());
    }

    public static List c() {
        String r0 = c.getString("key_lru_keys", null);
        if (r0 == null) goto L5;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L8
        Object r2 = Result.constructor-impl((List) ((Gson) d.getValue()).fromJson(r0, new b().getType()));     // Catch: Throwable -> L8
    L11:
        if (Result.exceptionOrNull-impl(r2) == null) goto L15;
        r2 = CollectionsKt.emptyList();
    L15:
        return (List) r2;
    L8:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r2 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    L5:
        return CollectionsKt.emptyList();
    }

    public static boolean d(a r7) {
        PolarisFileWrapper r0 = new PolarisFileWrapper(r7.c);
        if (r0.exists() == true) goto L5;
    L16:
        return false;
    L5:
        if (r0.isFile() == false) goto L16;
        if (r0.length() <= 0) goto L16;
        long r3 = r7.d;
        if (r3 > 0) goto L12;
        return true;
    L12:
        if (r0.length() == r3) goto L17;
        return false;
    L17:
        return true;
    }

    public static String e(String r2) {
        return "key_record_" + r2;
    }

    public static void h(a r4) {
        c.storeString(e(r4.a), GsonProtectorUtils.toJson((Gson) d.getValue(), r4));
        LinkedList r0 = new LinkedList(c());
        r0.remove(r4.a);
        r0.addLast(r4.a);
    L4:
        if (r0.size() <= ((Number) b.getValue()).intValue()) goto L12;
        String r1 = (String) r0.removeFirst();
        Keva r2 = c;
        Intrinsics.checkNotNull(r1);
        r2.erase(e(r1));
        a r3 = e;
        if (r3 == null) goto L8;
        String r5 = r3.a;
    L10:
        if (Intrinsics.areEqual(r5, r1) == false) goto L4;
        e = null;
        goto L4
    L8:
        r5 = null;
        goto L10
    L12:
        c.storeString("key_lru_keys", GsonProtectorUtils.toJson((Gson) d.getValue(), r0));
        e = r4;
    }

    public final synchronized void f(String r5) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r5, "candidateKey");     // Catch: Throwable -> L15
        Keva r0 = c;     // Catch: Throwable -> L15
        r0.erase(e(r5));     // Catch: Throwable -> L15
        LinkedList r1 = new LinkedList(c());     // Catch: Throwable -> L15
        if (r1.remove(r5) == false) goto L6;
        r0.storeString("key_lru_keys", GsonProtectorUtils.toJson((Gson) d.getValue(), r1));     // Catch: Throwable -> L15
    L6:
        a r2 = e;     // Catch: Throwable -> L15
        if (r2 == null) goto L9;
        String r3 = r2.a;     // Catch: Throwable -> L15
    L11:
        if (Intrinsics.areEqual(r3, r5) == false) goto L13;
        e = null;     // Catch: Throwable -> L15
    L13:
        monitor-exit(this);
        return;
    L9:
        r3 = null;
    L15:
        th = move-exception;
        throw th;
    }

    public static String a(String r5, Long r6, String r7) {
        Intrinsics.checkNotNullParameter(r5, "uriString");
        Intrinsics.checkNotNullParameter(r7, "strategyHash");
        StringBuilder r0 = new StringBuilder();
        r0.append(r5);
        r0.append('#');
        if (r6 == null) goto L5;
        long r3 = r6.longValue();
    L6:
        r0.append(r3);
        r0.append('#');
        r0.append(r7);
        r0.append('#');
        f.a.getClass();
        Object r8 = ((kq9.h) f.c.getValue()).c();
        if (r8 != null) goto L9;
        r8 = -1L;
    L9:
        r0.append(r8);
        return r0.toString();
    L5:
        r3 = -1;
        goto L6
    }

    public final synchronized a b(Uri r4, Long r5, String r6) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r4, "uri");     // Catch: Throwable -> L36
        Intrinsics.checkNotNullParameter(r6, "strategyHash");     // Catch: Throwable -> L36
        String r7 = a(r4.toString(), r5, r6);     // Catch: Throwable -> L36
        a r8 = e;     // Catch: Throwable -> L36
        boolean r9 = false;
        if (r8 == null) goto L12;
        a.getClass();     // Catch: Throwable -> L36
        if (Intrinsics.areEqual(r8.a, r7) == true) goto L8;
        boolean r0 = false;
    L9:
        if (r0 == false) goto L12;
        monitor-exit(this);
        return r8;
    L8:
        r0 = d(r8);     // Catch: Throwable -> L36
    L12:
        String r10 = c.getString(e(r7), null);     // Catch: Throwable -> L36
        if (r10 != null) goto L41;
        a r11 = null;
    L23:
        if (r11 != null) goto L27;
        monitor-exit(this);
        return null;
    L27:
        if (Intrinsics.areEqual(r11.a, r7) == false) goto L30;
        r9 = d(r11);     // Catch: Throwable -> L36
    L30:
        if (r9 == true) goto L33;
        monitor-exit(this);
        return null;
    L33:
        e = r11;     // Catch: Throwable -> L36
        monitor-exit(this);
        return r11;
    L41:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L17
        Object r12 = Result.constructor-impl((a) ((Gson) d.getValue()).fromJson(r10, a.class));     // Catch: Throwable -> L17
    L20:
        if (Result.isFailure-impl(r12) == false) goto L22;
        r12 = null;
    L22:
        r11 = (a) r12;     // Catch: Throwable -> L36
    L17:
        th = move-exception;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L36
        r12 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        throw th;
    }

    public final synchronized void g(Uri r12, Long r13, String r14, String r15, String r16, String r17, String r18) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r12, "uri");     // Catch: Throwable -> L24
        Intrinsics.checkNotNullParameter(r14, "strategyHash");     // Catch: Throwable -> L24
        Intrinsics.checkNotNullParameter(r15, "sourceMd5");     // Catch: Throwable -> L24
        Intrinsics.checkNotNullParameter(r16, "preprocessedFilePath");     // Catch: Throwable -> L24
        if (StringsKt.isBlank(r15) == false) goto L9;
        monitor-exit(this);
        return;
    L9:
        if (StringsKt.isBlank(r16) == false) goto L12;
        monitor-exit(this);
        return;
    L12:
        PolarisFileWrapper r1 = new PolarisFileWrapper(r16);     // Catch: Throwable -> L24
        if (r1.exists() == true) goto L15;
    L22:
        monitor-exit(this);
        return;
    L15:
        if (r1.isFile() == false) goto L22;
        if (r1.length() <= 0) goto L22;
        a r9 = new a(a(r12.toString(), r13, r14), r15, r16, r1.length(), r17, r18);     // Catch: Throwable -> L24
        h(r9);     // Catch: Throwable -> L24
        FLogger.a.i("CreationImagePreprocessReuseCache", "savePreprocessResult: " + r9);     // Catch: Throwable -> L24
        monitor-exit(this);
        return;
    L24:
        th = move-exception;
        throw th;
    }
}
