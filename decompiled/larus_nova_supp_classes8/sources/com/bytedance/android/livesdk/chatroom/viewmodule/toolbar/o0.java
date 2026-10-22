package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import io.reactivex.functions.Consumer;
import org.json.JSONArray;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class o0<T> implements Consumer {
    public final /* synthetic */ i0.e a;
    public final /* synthetic */ i0.f b;

    public o0(i0.e r1, i0.g r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r2) {
        i0.e r0 = this.a;
        r0.c = (JSONArray) r2;
        r0.d = true;
        this.b.onFinish();
    }
}
