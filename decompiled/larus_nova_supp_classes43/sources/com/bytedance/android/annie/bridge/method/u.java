package com.bytedance.android.annie.bridge.method;

import android.content.Context;
import com.bytedance.android.annie.bridge.FetchTimingSession;
import com.bytedance.android.annie.param.UtilsKt;
import com.bytedance.android.annie.service.network.IAnnieNetworkService;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.google.gson.JsonObject;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class u<T> implements Consumer {
    public final /* synthetic */ s a;
    public final /* synthetic */ CallContext b;
    public final /* synthetic */ JsonObject c;

    public u(s r1, CallContext r10, JsonObject r11) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
    }

    public final void accept(Object r10) {
        JsonObject r11 = (JsonObject) r10;
        s r0 = this.a;
        Context r1 = this.b.getContext();
        IAnnieNetworkService r12 = r0.c;
        if (r12 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("service");
        r12 = null;
    L5:
        r12.handleStatusCodeInterception(r11, r1);
        FetchTimingSession r13 = this.a.d;
        if (r13 == null) goto L8;
        r13.recordJsbEndTiming(r11);
    L8:
        int r14 = com.bytedance.android.annie.bridge.g.a;
        com.bytedance.android.annie.bridge.g.a(this.c, r11);
        s r15 = this.a;
        if (r15.b == false) goto L11;
        String r16 = UtilsKt.h(r11);
    L12:
        r15.finishWithResult(r16);
        return;
    L11:
        r16 = r11.toString();
        goto L12
    }
}
