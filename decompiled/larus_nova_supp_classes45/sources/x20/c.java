package x20;

import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.internal.Reflection;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ CompletionBlock a;
    public final /* synthetic */ a.b b;

    public c(CompletionBlock r1, a.b r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r7) {
        com.ss.ugc.live.sdk.msg.network.g r8 = (com.ss.ugc.live.sdk.msg.network.g) r7;
        CompletionBlock r0 = this.a;
        a.c r1 = ne7.e.c(Reflection.getOrCreateKotlinClass(a.c.class));
        a.c r2 = r1;
        r2.setServiceID(this.b.getServiceID());
        r2.setPayload(new String(r8.d, Charsets.UTF_8));
        r2.setStatusCode(Integer.valueOf(r8.a));
        r2.setStatusMsg(r8.b);
        Unit r9 = Unit.INSTANCE;
        CompletionBlock.DefaultImpls.onSuccess$default(r0, r1, null, 2, null);
    }
}
