package com.bytedance.android.live.browser.jsbridge.state.observable;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import io.reactivex.functions.Consumer;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b<T> implements Consumer {
    public final /* synthetic */ d a;

    public b(d r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        d r0 = this.a;
        JsonObject r1 = new JsonObject();
        r1.add("matchInfo", (JsonElement) sh6.c.b((sh6.b) r4));
        Unit r5 = Unit.INSTANCE;
        r0.h(r1);
    }
}
