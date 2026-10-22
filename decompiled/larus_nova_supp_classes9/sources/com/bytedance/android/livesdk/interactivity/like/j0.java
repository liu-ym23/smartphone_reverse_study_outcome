package com.bytedance.android.livesdk.interactivity.like;

import com.bytedance.android.live.user.IUserService;
import com.bytedance.ies.sdk.widgets.Widget;
import io.reactivex.functions.Consumer;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class j0<T> implements Consumer {
    public final /* synthetic */ DiggWidget a;

    public j0(DiggWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        List r5 = (List) r4;
        jc1.k.n(IUserService.class).user().login(((Widget) this.a).context, new com.bytedance.android.livesdk.user.l(new com.bytedance.android.livesdk.user.l.a()));
    }
}
