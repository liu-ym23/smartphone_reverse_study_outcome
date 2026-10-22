package com.bytedance.android.ec.core.hybrid.utils;

import io.reactivex.functions.Consumer;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class n<T> implements Consumer {
    public final /* synthetic */ String a;

    public n(String r1) {
        this.a = r1;
    }

    public final void accept(Object r10) {
        Throwable r11 = (Throwable) r10;
        JSONObject r12 = p.a;
        p.e(new q("", 2), this.a);
        p.a();
    }
}
