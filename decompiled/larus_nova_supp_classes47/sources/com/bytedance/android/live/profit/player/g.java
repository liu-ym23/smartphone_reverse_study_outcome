package com.bytedance.android.live.profit.player;

import com.bytedance.android.live.profit.player.jsb.DressPlayClickResultModel;
import com.bytedance.ies.web.jsbridge2.CallContext;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class g implements com.bytedance.ies.web.jsbridge2.f.b {
    public final /* synthetic */ LynxAlphaPlayerWidget a;

    public static final class a extends tu0.a<tu0.c, DressPlayClickResultModel> {
        public final /* synthetic */ g a;

        public a(g r1) {
            this.a = r1;
        }

        public final void invoke(Object r2, CallContext r3) {
            Intrinsics.checkNotNullParameter((tu0.c) r2, "params");
            Intrinsics.checkNotNullParameter(r3, "context");
            com.bytedance.android.live.profit.player.a r4 = this.a.a.b;
            if (r4 == null) goto L8;
            Function0<Unit> r5 = r4.f;
            if (r5 == null) goto L9;
            Unit r6 = (Unit) r5.invoke();
            return;
        L9:
            return;
        }
    }

    public g(LynxAlphaPlayerWidget r1) {
        this.a = r1;
    }

    public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
        return new a(this);
    }
}
