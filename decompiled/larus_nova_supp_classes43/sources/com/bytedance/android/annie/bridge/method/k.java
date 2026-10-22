package com.bytedance.android.annie.bridge.method;

import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.annie.bridge.method.abs.CloseSocketResultModel;
import com.bytedance.android.annie.websocket.SocketManager;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@XBridgeMethod(biz = "webcast_sdk", name = "closeSocket")
public final class k extends e7.c<e7.d0, CloseSocketResultModel> {
    public final IHybridComponent a;

    public k(m16.b r10) {
        Intrinsics.checkNotNullParameter(r10, "contextProviderFactory");
        IHybridComponent r11 = (IHybridComponent) r10.c(IHybridComponent.class);
        if (r11 == null) goto L6;
        this.a = r11;
        return;
    }

    public k(IHybridComponent r1) {
        this.a = r1;
    }

    public final void invoke(Object r10, CallContext r11) {
        e7.d0 r12 = (e7.d0) r10;
        Intrinsics.checkNotNullParameter(r12, "params");
        Intrinsics.checkNotNullParameter(r11, "context");
        IHybridComponent r13 = this.a;
        if (r13 == null) goto L5;
        String r14 = r13.containerId();
    L6:
        boolean r0 = false;
        if (r14 != null) goto L9;
    L12:
        boolean r15 = true;
    L13:
        if (r15 == true) goto L25;
        String r16 = r12.a();
        if (r16 != null) goto L17;
    L18:
        r0 = true;
    L19:
        if (r0 == true) goto L25;
        HashMap<String, HashMap<String, ? super com.bytedance.android.annie.websocket.b>> r17 = SocketManager.a;
        SocketManager r18 = SocketManager.a.a();
        IHybridComponent r1 = this.a;
        Intrinsics.checkNotNull(r1);
        String r19 = r1.containerId();
        String r20 = r12.a();
        Intrinsics.checkNotNull(r20);
        r18.getClass();
        if (SocketManager.b(r19, r20) == null) goto L24;
        finishWithFailure();
        return;
    L24:
        CloseSocketResultModel r21 = new CloseSocketResultModel();
        r21.a(CloseSocketResultModel.Code.Success);
        finishWithResult(r21);
        return;
    L17:
        if (StringsKt.isBlank(r16) == false) goto L19;
    L25:
        finishWithFailure();
        return;
    L9:
        if (StringsKt.isBlank(r14) == true) goto L12;
        r15 = false;
        goto L13
    L5:
        r14 = null;
        goto L6
    }
}
