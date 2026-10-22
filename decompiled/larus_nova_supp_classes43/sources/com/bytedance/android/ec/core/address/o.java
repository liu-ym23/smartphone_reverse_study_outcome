package com.bytedance.android.ec.core.address;

import io.reactivex.functions.Consumer;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class o<T> implements Consumer {
    public static final o a = null;

    static {
        a = new o();
    }

    public o() {
    }

    public final void accept(Object r10) {
        Unit r11 = (Unit) r10;
        w r12 = AddressSDK.a;
        AddressSDKLog.a("init success, setting_null=" + AddressSDK.a.g.b, false);
    }
}
