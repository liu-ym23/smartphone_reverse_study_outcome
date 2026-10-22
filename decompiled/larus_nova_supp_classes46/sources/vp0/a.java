package vp0;

import com.bytedance.android.live.network.response.e;
import com.bytedance.android.live.openplatform.api.model.datacontext.AnchorMiniAppDataContext;
import com.bytedance.android.live.openplatform.impl.miniappanchor.api.response.f;
import com.bytedance.live.datacontext.n;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a<T> implements Consumer {
    public final /* synthetic */ Function1 a;
    public final /* synthetic */ Function0 b;

    public a(Function1 r1, Function0 r2) {
        this.a = r1;
        this.b = r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void accept(Object r7) {
        f r8 = (f) ((e) r7).data;
        int r0 = qo0.a.a;
        qo0.a.c("AnchorPrivateMsgContextService", "request /webcast/microapp/private_msg_tab/get/ success, data = " + r8);
        if (r8.b() != 0) goto L12;
        AnchorMiniAppDataContext.Companion.getClass();
        AnchorMiniAppDataContext r1 = AnchorMiniAppDataContext.a.a();
        if (r1 == null) goto L9;
        n<lo0.b> r2 = r1.getPrivateMsgTabInfo();
        if (r2 == null) goto L9;
        r2.setValue(new lo0.b(r8.d(), r8.e(), r8.c(), r8.a()));
    L9:
        Function1 r3 = this.a;
        if (r3 == null) goto L16;
        Unit r9 = (Unit) r3.invoke(r8);
        return;
    L16:
        return;
    L12:
        Function0 r10 = this.b;
        if (r10 == null) goto L18;
        Unit r11 = (Unit) r10.invoke();
        return;
    }
}
