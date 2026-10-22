package com.bytedance.android.live.browser.jsbridge.state.annieObservable;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import io.reactivex.functions.Consumer;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d<T> implements Consumer {
    public final /* synthetic */ e a;

    public d(e r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        e r0 = this.a;
        JsonObject r1 = new JsonObject();
        r1.add("tabInfo", (JsonElement) sh6.c.b((sh6.b) r4));
        Unit r5 = Unit.INSTANCE;
        r0.i(r1);
    }
}
