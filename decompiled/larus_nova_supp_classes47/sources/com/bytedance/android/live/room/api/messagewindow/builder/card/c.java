package com.bytedance.android.live.room.api.messagewindow.builder.card;

import com.bytedance.android.live.room.api.messagewindow.state.CardAction;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c {
    public final b a;

    public final void a() {
        b r0 = this.a;
        r0.getClass();
        xs2.b.a().post(new z61.a(CardAction.DESTROY, r0));
    }

    public final void b() {
        b r0 = this.a;
        r0.getClass();
        xs2.b.a().post(new z61.a(CardAction.DESTROY_WITHOUT_DESTROY, r0));
    }

    public c(b r2) {
        Intrinsics.checkNotNullParameter(r2, "commonCard");
        this.a = r2;
    }

    public final void c(String r4) {
        b r0 = this.a;
        r0.g = r4;
        xs2.b.a().post(new z61.a(CardAction.REFRESH, r0));
    }
}
