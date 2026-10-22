package com.bytedance.android.annie.service.prefetch;

import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.Reader;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class q implements o {

    public static final class a<T, R> implements Function {
        public static final a<T, R> a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final Object apply(Object r10) {
            File r11 = (File) r10;
            Intrinsics.checkNotNullParameter(r11, "it");
            return new PolarisFileWrapper(r11, "test.prefetch.json");
        }
    }

    public static final class b<T> implements Predicate {
        public static final b<T> a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final boolean test(Object r10) {
            File r11 = (File) r10;
            Intrinsics.checkNotNullParameter(r11, "it");
            return r11.exists();
        }
    }

    public static final class c<T, R> implements Function {
        public static final c<T, R> a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final Object apply(Object r10) {
            File r11 = (File) r10;
            Intrinsics.checkNotNullParameter(r11, "file");
            Reader r1 = new InputStreamReader(new PolarisFileInputStreamWrapper(r11), Charsets.UTF_8);
            if ((r1 instanceof BufferedReader) == false) goto L5;
            BufferedReader r12 = (BufferedReader) r1;
        L14:
            String r13 = TextStreamsKt.readText(r12);     // Catch: Throwable -> L9
            CloseableKt.closeFinally(r12, null);
            return new o.a(null, r13);
        L9:
            th = move-exception;
            throw th;     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            CloseableKt.closeFinally(r12, th);
            throw th;
        L5:
            r12 = new BufferedReader(r1, 8192);
            goto L14
        }
    }

    public q() {
    }

    @Override // com.bytedance.android.annie.service.prefetch.o
    public final Observable<o.a> getConfig() {
        File r0 = com.bytedance.android.annie.ng.g.a().getExternalCacheDir();
        Observable<o.a> r1 = null;
        if (r0 != null) goto L5;
    L10:
        if (r1 == null) goto L12;
        return r1;
    L12:
        return Observable.empty();
    L5:
        if (com.bytedance.android.annie.ng.g.b().a.a == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L10;
        r1 = Observable.just(r0).subscribeOn(Schedulers.io()).map(a.a).filter(b.a).map(c.a);
        goto L10
    }
}
