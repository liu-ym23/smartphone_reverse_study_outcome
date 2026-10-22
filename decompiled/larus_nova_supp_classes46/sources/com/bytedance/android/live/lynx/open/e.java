package com.bytedance.android.live.lynx.open;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.net.URL;
import kotlin.io.ByteStreamsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e extends d8a.b {

    public static final class a<T, R> implements Function {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final Object apply(Object r2) {
            String r3 = (String) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            return Observable.just(ByteStreamsKt.readBytes(new URL(r3).openStream()));
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ d8a.b.a a;

        public b(d8a.b.a r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            byte[] r3 = (byte[]) r2;
            d8a.b.a r0 = this.a;
            if (r0 == null) goto L6;
            r0.onSuccess(r3);
            return;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ d8a.b.a a;

        public c(d8a.b.a r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Throwable r3 = (Throwable) r2;
            d8a.b.a r4 = this.a;
            if (r4 == null) goto L6;
            r4.onFailed("loadTemplate failed");
            return;
        }
    }

    public e() {
    }

    public final void loadTemplate(String r3, d8a.b.a r4) {
        Intrinsics.checkNotNullParameter(r3, "url");
        Observable.just(r3).subscribeOn(Schedulers.io()).flatMap(a.a).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(r4), new c(r4));
    }
}
