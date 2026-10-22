package vp0;

import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d<T> implements Consumer {
    public final /* synthetic */ Function0 a;

    public d(Function0 r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        qo0.a.b("AnchorPrivateMsgContextService", "request /webcast/microapp/private_msg_tab/update/ fail", (Throwable) r3);
        this.a.invoke();
    }
}
