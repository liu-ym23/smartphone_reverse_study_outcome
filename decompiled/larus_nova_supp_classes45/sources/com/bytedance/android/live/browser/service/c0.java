package com.bytedance.android.live.browser.service;

import com.bytedance.android.live.browser.IBrowserService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c0 implements v9.c {

    public static final class a implements com.bytedance.android.live.schema.api.d.a {
        public final /* synthetic */ v9.b a;

        public a(v9.b r1) {
            this.a = r1;
        }

        public final void onSuccess(String r2) {
            Intrinsics.checkNotNullParameter(r2, "finalSchema");
            v9.b r0 = this.a;
            if (r0 == null) goto L6;
            r0.onSuccess(r2);
            return;
        }

        public final void onFail(int r2, String r3) {
            Intrinsics.checkNotNullParameter(r3, "msg");
            v9.b r0 = this.a;
            if (r0 == null) goto L6;
            r0.onFail(r2, r3);
            return;
        }
    }

    public c0() {
    }

    public final void X0(String r3, v9.b r4) {
        com.bytedance.android.live.schema.api.b r5 = com.bytedance.android.live.schema.api.utils.b.b(r3);
        if (r5 == null) goto L5;
        ((IBrowserService) jc1.k.n(IBrowserService.class)).createRedirectProcessor().a(r5, new a(r4));
        return;
    L5:
        if (r4 == null) goto L9;
        r4.onFail(1002, "illegal redirect schema");
        return;
    }
}
