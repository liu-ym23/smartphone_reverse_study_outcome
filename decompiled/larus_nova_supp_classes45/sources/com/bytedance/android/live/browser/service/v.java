package com.bytedance.android.live.browser.service;

import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class v implements com.bytedance.android.annie.bridge.r {

    public static final class a implements com.bytedance.ies.web.jsbridge2.v {
        public final /* synthetic */ Function2 a;

        public a(Function2 r1) {
            this.a = r1;
        }

        public final void a(String r2, String r3) {
            if (Intrinsics.areEqual("host", r2) == false) goto L6;
            this.a.invoke(r2, r3);
            return;
        }
    }

    public v() {
    }

    public final void K0(com.bytedance.ies.web.jsbridge2.d0 r2, Function2<? super String, ? super String, Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "jsBridge2");
        Intrinsics.checkNotNullParameter(r3, "block");
        r2.a.j = new a(r3);
    }
}
