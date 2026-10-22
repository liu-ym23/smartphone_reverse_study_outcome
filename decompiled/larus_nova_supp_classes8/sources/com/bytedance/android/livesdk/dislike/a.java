package com.bytedance.android.livesdk.dislike;

import com.bytedance.android.live.base.model.user.FollowInfo;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a<T> implements Consumer {
    public final /* synthetic */ ActionsManager a;
    public final /* synthetic */ Ref.LongRef b;
    public final /* synthetic */ Function1 c;

    public a(ActionsManager r1, Ref.LongRef r2, Function1 r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void accept(Object r4) {
        Ref.LongRef r0 = this.b;
        FollowInfo r5 = ((User) ((BaseResponse) r4).data).getFollowInfo();
        if (r5 == null) goto L5;
        long r1 = r5.getPushStatus();
    L6:
        r0.element = r1;
        this.c.invoke(Long.valueOf(this.b.element));
        HashMap r6 = bn2.k.a;
        Long r7 = Long.valueOf(this.b.element);
        Room r2 = this.a.d;
        if (r2 == null) goto L9;
        String r3 = r2.getOwnerUserIdString();
    L10:
        bn2.k.c(r7, r3, "long_press", false);
        return;
    L9:
        r3 = null;
        goto L10
    L5:
        r1 = 0;
        goto L6
    }
}
