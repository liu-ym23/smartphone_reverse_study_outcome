package com.bytedance.android.ec.core.address;

import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class l<T> implements Consumer {
    public final /* synthetic */ String a;
    public final /* synthetic */ int b;
    public final /* synthetic */ Function2 c;

    public l(String r1, int r10, Function2 r11) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
    }

    public final void accept(Object r10) {
        Throwable r11 = (Throwable) r10;
        s.b(false, null, "read_address", null);
        w r0 = AddressSDK.a;
        AddressSDK.g("fetch address error id=" + this.a + " type=" + this.b, r11, 4);
        Function2 r1 = this.c;
        StringBuilder r12 = new StringBuilder("请求失败：");
        if (r11 == null) goto L5;
        String r13 = r11.getMessage();
    L6:
        r12.append(r13);
        r1.invoke(null, r12.toString());
        return;
    L5:
        r13 = null;
        goto L6
    }
}
