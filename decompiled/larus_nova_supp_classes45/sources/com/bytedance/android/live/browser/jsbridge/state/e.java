package com.bytedance.android.live.browser.jsbridge.state;

import com.bytedance.android.live.browser.jsbridge.i;
import com.google.gson.JsonElement;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e<T> extends a<T> {
    public final i.f<T> c;
    public final T d;
    public final JsonElement e;

    @Override // com.bytedance.android.live.browser.jsbridge.state.a
    public final Object b() {
        return this.d;
    }

    @Override // com.bytedance.android.live.browser.jsbridge.state.a
    public final i.f<T> d() {
        return this.c;
    }

    @Override // com.bytedance.android.live.browser.jsbridge.state.a
    public final JsonElement e(String r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        if (this.e.isJsonObject() == true) goto L7;
        return this.e;
    L7:
        return f(r2, this.e);
    }

    public e(a<T> r2, T r3, JsonElement r4) {
        Intrinsics.checkNotNullParameter(r2, "delegate");
        Intrinsics.checkNotNullParameter(r4, "jsonElement");
        super(0);
        this.d = r3;
        this.e = r4;
        this.c = r2.d();
    }
}
