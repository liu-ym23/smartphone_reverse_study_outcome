package com.bytedance.android.live.profit.vote;

import com.bytedance.android.live.core.utils.h1;
import com.bytedance.android.live.core.utils.i1;
import com.bytedance.android.livesdkapi.depend.model.live.ILiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKt_androidKt;
import com.bytedance.android.scope.o;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f implements o {
    public final com.bytedance.android.live.profit.vote.model.f a;
    public final yz0.g b;
    public final er2.a c;

    public final void onStart() {
    }

    public final void onStop() {
    }

    public final void a(Map<String, String> r3) {
        Intrinsics.checkNotNullParameter(r3, "$this$putFunctionType");
        if (this.c.q() == false) goto L6;
        r3.put("function_type", "ktv");
        return;
    }

    public final void c(Map<String, String> r3) {
        Intrinsics.checkNotNullParameter(r3, "$this$putLiveType");
        ILiveMode r0 = IRoomKt_androidKt.getStreamType(this.b.mo444getRoom());
        int r1 = h1.a;
        r3.put("live_type", i1.a(r0));
    }

    public final void d(Map<String, String> r3) {
        Intrinsics.checkNotNullParameter(r3, "$this$putUserType");
        if (this.b.isAnchor() == false) goto L5;
        String r0 = "anchor";
    L6:
        r3.put("user_type", r0);
        return;
    L5:
        r0 = "user";
        goto L6
    }

    public f(com.bytedance.android.live.profit.vote.model.f r2, yz0.g r3, er2.a r4) {
        Intrinsics.checkNotNullParameter(r2, "voteRepository");
        Intrinsics.checkNotNullParameter(r3, "roomDataService");
        Intrinsics.checkNotNullParameter(r4, "ktvRoomService");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
