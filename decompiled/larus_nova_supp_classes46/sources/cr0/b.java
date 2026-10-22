package cr0;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b<T> implements Consumer {
    public static final b a = null;

    static {
        a = new b();
    }

    public b() {
    }

    public final void accept(Object r3) {
        qo0.a.b("PreviewMiniGameContext", "preview page switch task fail: ", (Throwable) r3);
    }
}
