package gj0;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c<T> implements Consumer {
    public static final c a = null;

    static {
        a = new c();
    }

    public c() {
    }

    public final void accept(Object r3) {
        i.a("StarWishOutService", "fastOpen error " + ((Throwable) r3).getMessage());
    }
}
