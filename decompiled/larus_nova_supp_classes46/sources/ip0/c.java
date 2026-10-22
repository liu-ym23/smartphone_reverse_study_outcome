package ip0;

import com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.list.repository.MiniAppListRepository;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c<T, R> implements Function {
    public final /* synthetic */ MiniAppListRepository a;

    public c(MiniAppListRepository r1) {
        this.a = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object apply(Object r3) {
        com.bytedance.android.live.network.response.e r4 = (com.bytedance.android.live.network.response.e) r3;
        Intrinsics.checkNotNullParameter(r4, "response");
        int r0 = qo0.a.a;
        qo0.a.c("choose_list", "fetch list success, no update: " + ((com.bytedance.android.live.openplatform.impl.miniappanchor.choose.model.b) r4.data).noUpdate + ", hash: " + ((com.bytedance.android.live.openplatform.impl.miniappanchor.choose.model.b) r4.data).hash);
        com.bytedance.android.live.openplatform.impl.miniappanchor.choose.model.b r1 = (com.bytedance.android.live.openplatform.impl.miniappanchor.choose.model.b) r4.data;
        if (r1.noUpdate == false) goto L13;
        com.bytedance.android.live.openplatform.impl.miniappanchor.choose.model.b r2 = this.a.a.a;
        if (r2 == null) goto L7;
        boolean r5 = true;
    L8:
        if (r5 == true) goto L11;
        r2 = null;
    L11:
        if (r2 == null) goto L16;
        return r2;
    L16:
        return (com.bytedance.android.live.openplatform.impl.miniappanchor.choose.model.b) r4.data;
    L7:
        r5 = false;
        goto L8
    L13:
        this.a.a.a = r1;
        return (com.bytedance.android.live.openplatform.impl.miniappanchor.choose.model.b) r4.data;
    }
}
