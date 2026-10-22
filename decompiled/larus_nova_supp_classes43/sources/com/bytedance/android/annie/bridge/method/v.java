package com.bytedance.android.annie.bridge.method;

import com.bytedance.android.annie.service.network.IAnnieNetworkService;
import com.bytedance.ies.web.jsbridge2.CallContext;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class v<T> implements Consumer {
    public final /* synthetic */ s a;
    public final /* synthetic */ CallContext b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;

    public v(s r1, CallContext r10, String r11, String r12) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
        this.d = r12;
    }

    public final void accept(Object r10) {
        Throwable r11 = (Throwable) r10;
        this.a.finishWithFailure(r11);
        IAnnieNetworkService r0 = this.a.c;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("service");
        r0 = null;
    L5:
        r0.handleFetchError(this.b.d, this.c, this.d, r11);
    }
}
