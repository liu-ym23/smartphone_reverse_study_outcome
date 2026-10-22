package com.bytedance.android.live.browser.jsbridge.prefetch;

import com.bytedance.android.live.core.utils.statusbar.IESStatusBarUtil;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livehostapi.foundation.IHostContext;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class i implements com.bytedance.android.live.browser.jsbridge.g {

    public static final class a<T, R> implements Function {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final Object apply(Object r3) {
            File r4 = (File) r3;
            Intrinsics.checkNotNullParameter(r4, "it");
            return new PolarisFileWrapper(r4, "test.prefetch.json");
        }
    }

    public static final class b<T> implements Predicate {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final boolean test(Object r2) {
            File r3 = (File) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            return r3.exists();
        }
    }

    public static final class c<T, R> implements Function {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final Object apply(Object r3) {
            File r4 = (File) r3;
            Intrinsics.checkNotNullParameter(r4, "file");
            Reader r1 = new InputStreamReader(new PolarisFileInputStreamWrapper(r4), Charsets.UTF_8);
            if ((r1 instanceof BufferedReader) == false) goto L5;
            BufferedReader r2 = (BufferedReader) r1;
        L14:
            String r5 = TextStreamsKt.readText(r2);     // Catch: Throwable -> L9
            CloseableKt.closeFinally(r2, null);
            return new com.bytedance.android.live.browser.jsbridge.g.a(null, r5);
        L9:
            th = move-exception;
            throw th;     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            CloseableKt.closeFinally(r2, th);
            throw th;
        L5:
            r2 = new BufferedReader(r1, IESStatusBarUtil.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            goto L14
        }
    }

    public i() {
    }

    @Override // com.bytedance.android.live.browser.jsbridge.g
    public final Observable<com.bytedance.android.live.browser.jsbridge.g.a> getConfig() {
        File r0 = jc1.k.n(IHostContext.class).context().getExternalCacheDir();
        if (r0 == null) goto L12;
        if (v.a() == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L12;
        Observable<com.bytedance.android.live.browser.jsbridge.g.a> r1 = Observable.just(r0).subscribeOn(Schedulers.io()).map(a.a).filter(b.a).map(c.a);
        if (r1 == null) goto L12;
        return r1;
    L12:
        return Observable.empty();
    }
}
