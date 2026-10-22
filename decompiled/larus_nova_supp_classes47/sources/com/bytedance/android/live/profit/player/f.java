package com.bytedance.android.live.profit.player;

import com.bytedance.android.live.profit.player.jsb.DressPlayFinishResultModel;
import com.bytedance.ies.web.jsbridge2.CallContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f implements com.bytedance.ies.web.jsbridge2.f.b {
    public final /* synthetic */ LynxAlphaPlayerWidget a;

    public static final class a extends tu0.b<tu0.d, DressPlayFinishResultModel> {
        public final /* synthetic */ f a;

        public a(f r1) {
            this.a = r1;
        }

        public final void invoke(Object r2, CallContext r3) {
            tu0.d r4 = (tu0.d) r2;
            Intrinsics.checkNotNullParameter(r4, "params");
            Intrinsics.checkNotNullParameter(r3, "context");
            if (Intrinsics.areEqual(r4.b(), Boolean.TRUE) == false) goto L5;
            LynxAlphaPlayerWidget r5 = this.a.a;
            int r6 = LynxAlphaPlayerWidget.i;
            r5.zq(true, null);
            return;
        L5:
            LynxAlphaPlayerWidget r7 = this.a.a;
            String r8 = r4.a();
            int r0 = LynxAlphaPlayerWidget.i;
            r7.zq(false, r8);
        }
    }

    public f(LynxAlphaPlayerWidget r1) {
        this.a = r1;
    }

    public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
        return new a(this);
    }
}
