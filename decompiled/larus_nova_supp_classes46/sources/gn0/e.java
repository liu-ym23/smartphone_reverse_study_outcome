package gn0;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e<T> implements Consumer {
    public static final e a = null;

    static {
        a = new e();
    }

    public e() {
    }

    public final void accept(Object r4) {
        jy0.b.c("MultiControlService", "WebcastLinkMicMethod subscribe error " + ((Throwable) r4), null, 4);
    }
}
