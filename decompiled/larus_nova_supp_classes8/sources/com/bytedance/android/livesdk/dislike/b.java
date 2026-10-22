package com.bytedance.android.livesdk.dislike;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b<T> implements Consumer {
    public final /* synthetic */ ActionsManager a;
    public final /* synthetic */ Function1 b;
    public final /* synthetic */ Ref.LongRef c;

    public b(ActionsManager r1, Function1 r2, Ref.LongRef r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void accept(Object r4) {
        ALogger.e("ActionsManager", ((Throwable) r4).getMessage());
        this.b.invoke(Long.valueOf(this.c.element));
        HashMap r5 = bn2.k.a;
        Long r6 = Long.valueOf(this.c.element);
        Room r0 = this.a.d;
        if (r0 == null) goto L5;
        String r1 = r0.getOwnerUserIdString();
    L6:
        bn2.k.c(r6, r1, "long_press", false);
        return;
    L5:
        r1 = null;
        goto L6
    }
}
