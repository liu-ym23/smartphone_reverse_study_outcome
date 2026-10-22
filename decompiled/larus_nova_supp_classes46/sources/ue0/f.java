package ue0;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class f<T> implements Consumer {
    public final /* synthetic */ d a;

    public f(d r1) {
        this.a = r1;
    }

    public final void accept(Object r5) {
        d r0 = this.a;
        r0.h.printALogger("LivePreviewMultiLinkOnlineUserListHandler", r0.hashCode(), ((Throwable) r5).toString(), true);
    }
}
