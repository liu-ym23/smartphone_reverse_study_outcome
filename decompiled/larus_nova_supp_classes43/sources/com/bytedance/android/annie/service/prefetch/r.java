package com.bytedance.android.annie.service.prefetch;

import com.bytedance.android.annie.Annie;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class r implements o {

    public final class a {
        public final n a;
        public final String b;

        public a(n r10, String r11) {
            Intrinsics.checkNotNullParameter(r10, "loader");
            Intrinsics.checkNotNullParameter(r11, "channel");
            this.a = r10;
            this.b = r11;
        }
    }

    public static final class b<T, R> implements Function {
        public final /* synthetic */ r a;

        public b(r r1) {
            this.a = r1;
        }

        public final Object apply(Object r10) {
            n r11 = (n) r10;
            Intrinsics.checkNotNullParameter(r11, "loader");
            return Observable.fromIterable(((com.bytedance.android.annie.service.resource.f) Annie.getService$default(com.bytedance.android.annie.service.resource.f.class, null, 2, null)).r()).map(new s(this.a, r11));
        }
    }

    public static final class c<T, R> implements Function {
        public final /* synthetic */ r a;

        public c(r r1) {
            this.a = r1;
        }

        public final Object apply(Object r10) {
            a r11 = (a) r10;
            Intrinsics.checkNotNullParameter(r11, "channelLoader");
            n r0 = r11.a;
            String r12 = r11.b;
            this.a.getClass();
            InputStream r1 = r0.a("prefetch." + r12 + ".json", r12);
            if (r1 == null) goto L18;
            Reader r13 = new InputStreamReader(r1, Charsets.UTF_8);
            if ((r13 instanceof BufferedReader) == false) goto L7;
            BufferedReader r14 = (BufferedReader) r13;
        L21:
            String r15 = TextStreamsKt.readText(r14);     // Catch: Throwable -> L12
            CloseableKt.closeFinally(r14, null);
            if (r15 == null) goto L18;
            return new o.a(r12, r15);
        L12:
            th = move-exception;
            throw th;     // Catch: Throwable -> L14
        L14:
            th = move-exception;
            CloseableKt.closeFinally(r14, th);
            throw th;
        L7:
            r14 = new BufferedReader(r13, 8192);
        L18:
            return o.a.c;
        }
    }

    public static final class d<T, R> implements Function {
        public static final d<T, R> a = null;

        static {
            a = new d();
        }

        public d() {
        }

        public final Object apply(Object r10) {
            Intrinsics.checkNotNullParameter((Throwable) r10, "it");
            return o.a.c;
        }
    }

    public static final class e<T> implements Predicate {
        public static final e<T> a = null;

        static {
            a = new e();
        }

        public e() {
        }

        public final boolean test(Object r10) {
            o.a r11 = (o.a) r10;
            Intrinsics.checkNotNullParameter(r11, "it");
            if (r11 == o.a.c) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public r() {
    }

    @Override // com.bytedance.android.annie.service.prefetch.o
    public final Observable<o.a> getConfig() {
        return Observable.fromIterable(((p) Annie.getService$default(p.class, null, 2, null)).o()).flatMap(new b(this)).subscribeOn(Schedulers.io()).map(new c(this)).onErrorReturn(d.a).filter(e.a);
    }
}
