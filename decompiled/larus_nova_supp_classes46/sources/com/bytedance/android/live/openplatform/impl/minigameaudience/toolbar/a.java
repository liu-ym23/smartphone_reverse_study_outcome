package com.bytedance.android.live.openplatform.impl.minigameaudience.toolbar;

import com.bytedance.android.live.network.response.Response;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a<T> implements Consumer {
    public final /* synthetic */ CandyToolbarContextService a;
    public final /* synthetic */ Function1 b;
    public final /* synthetic */ Function0 c;

    public a(CandyToolbarContextService r1, Function1 r2, Function0 r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void accept(Object r4) {
        List<fr0.b.a> r5 = ((fr0.b) ((Response) r4).data).a();
        if (r5 != null) goto L5;
    L10:
        this.b.invoke("candy entrance error: entrance info list is null or empty.");
        return;
    L5:
        if ((!r5.isEmpty()) != true) goto L10;
        if (((fr0.b.a) ListProtector.get(r5, 0)).c() == false) goto L9;
        this.b.invoke("candy disable entrance is true.");
        this.a.b = null;
        return;
    L9:
        this.a.j((fr0.b.a) ListProtector.get(r5, 0), this.c, false);
    }
}
