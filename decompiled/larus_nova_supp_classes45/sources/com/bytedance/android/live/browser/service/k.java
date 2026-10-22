package com.bytedance.android.live.browser.service;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class k implements com.bytedance.android.annie.bridge.o {

    public static final class a implements com.bytedance.ies.web.jsbridge2.p {
        public final /* synthetic */ Function0 a;

        public a(Function0 r1) {
            this.a = r1;
        }

        public final void a() {
            this.a.invoke();
        }
    }

    public k() {
    }

    public final void h1(com.bytedance.ies.web.jsbridge2.o r2, Function0<Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "env");
        Intrinsics.checkNotNullParameter(r3, "block");
        r2.r = new a(r3);
    }
}
