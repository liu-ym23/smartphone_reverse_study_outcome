package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.ies.web.jsbridge2.CallContext;
import io.reactivex.functions.Consumer;
import kotlin.Pair;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class va<T> implements Consumer {
    public final /* synthetic */ wa a;
    public final /* synthetic */ CallContext b;

    public va(wa r1, CallContext r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r3) {
        Pair r4 = (Pair) r3;
        String r0 = (String) r4.component1();
        com.ss.ugc.live.sdk.message.wrsc.data.a r5 = (com.ss.ugc.live.sdk.message.wrsc.data.a) r4.component2();
        wa.j(this.a, r5, this.b);
    }
}
