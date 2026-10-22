package vp0;

import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b<T> implements Consumer {
    public final /* synthetic */ Function0 a;

    public b(Function0 r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        qo0.a.b("AnchorPrivateMsgContextService", "request /webcast/microapp/private_msg_tab/get/ fail", (Throwable) r3);
        Function0 r4 = this.a;
        if (r4 == null) goto L6;
        Unit r5 = (Unit) r4.invoke();
        return;
    }
}
