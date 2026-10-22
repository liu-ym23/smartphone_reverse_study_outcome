package x20;

import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import io.reactivex.functions.Consumer;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d<T> implements Consumer {
    public final /* synthetic */ CompletionBlock a;
    public final /* synthetic */ a.b b;

    public d(CompletionBlock r1, a.b r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r5) {
        CompletionBlock r0 = this.a;
        a.c r1 = ne7.e.b(a.c.class);
        a.c r2 = r1;
        r2.setServiceID(this.b.getServiceID());
        r2.setStatusMsg(((Throwable) r5).getMessage());
        Unit r6 = Unit.INSTANCE;
        r0.onFailure(1, "sendRequestForResponse error", r1);
    }
}
