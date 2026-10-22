package vp0;

import com.bytedance.android.live.network.response.e;
import com.bytedance.android.live.openplatform.api.model.datacontext.AnchorMiniAppDataContext;
import com.bytedance.android.live.openplatform.impl.miniappanchor.api.response.n;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ Function0 b;
    public final /* synthetic */ Function0 c;

    public c(boolean r1, Function0 r2, Function0 r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void accept(Object r6) {
        n r7 = (n) ((e) r6).data;
        int r0 = qo0.a.a;
        qo0.a.c("AnchorPrivateMsgContextService", "request /webcast/microapp/private_msg_tab/update/ success, data = " + r7);
        AnchorMiniAppDataContext.Companion.getClass();
        AnchorMiniAppDataContext r1 = AnchorMiniAppDataContext.a.a();
        lo0.b r2 = null;
        if (r1 == null) goto L7;
        com.bytedance.live.datacontext.n<lo0.b> r3 = r1.getPrivateMsgTabInfo();
        if (r3 == null) goto L7;
        lo0.b r4 = (lo0.b) r3.getValue();
    L9:
        if (r7.a() != 0) goto L18;
        AnchorMiniAppDataContext r8 = AnchorMiniAppDataContext.a.a();
        if (r8 == null) goto L17;
        com.bytedance.live.datacontext.n<lo0.b> r9 = r8.getPrivateMsgTabInfo();
        if (r9 == null) goto L17;
        if (r4 == null) goto L16;
        r2 = new lo0.b(r4.a, this.a, r4.c, r4.d);
    L16:
        r9.setValue(r2);
    L17:
        this.b.invoke();
        return;
    L18:
        this.c.invoke();
        return;
    L7:
        r4 = null;
        goto L9
    }
}
