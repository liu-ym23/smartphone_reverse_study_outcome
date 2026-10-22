package com.bytedance.android.annie.bridge.method;

import android.content.Context;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.annie.bridge.method.abs.ConnectSocketResultModel;
import com.bytedance.android.annie.websocket.SocketManager;
import com.bytedance.frameworks.baselib.network.http.cronet.websocket.IMessageReceiveListener;
import com.bytedance.frameworks.baselib.network.http.cronet.websocket.IWsClient;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import java.util.HashMap;
import java.util.UUID;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@XBridgeMethod(biz = "webcast_sdk", name = "connectSocket")
public final class l extends e7.d<e7.e0, ConnectSocketResultModel> {
    public final IHybridComponent a;

    public l(m16.b r10) {
        Intrinsics.checkNotNullParameter(r10, "contextProviderFactory");
        IHybridComponent r11 = (IHybridComponent) r10.c(IHybridComponent.class);
        if (r11 == null) goto L6;
        this.a = r11;
        return;
    }

    public l(IHybridComponent r1) {
        this.a = r1;
    }

    public final void invoke(Object r10, CallContext r11) {
        e7.e0 r12 = (e7.e0) r10;
        Intrinsics.checkNotNullParameter(r12, "params");
        Intrinsics.checkNotNullParameter(r11, "context");
        String r0 = r12.c();
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L59;
        IHybridComponent r13 = this.a;
        Unit r14 = null;
        if (r13 == null) goto L13;
        String r15 = r13.containerId();
    L14:
        if (r15 != null) goto L16;
    L19:
        boolean r16 = true;
    L20:
        if (r16 == true) goto L59;
        HashMap<String, HashMap<String, ? super com.bytedance.android.annie.websocket.b>> r17 = SocketManager.a;
        SocketManager r18 = SocketManager.a.a();
        Context r19 = r11.getContext();
        IHybridComponent r20 = this.a;
        Intrinsics.checkNotNull(r20);
        String r21 = r20.containerId();
        String r22 = r12.c();
        Intrinsics.checkNotNull(r22);
        com.bytedance.android.annie.websocket.f r23 = new com.bytedance.android.annie.websocket.f(r22, r12.a(), r12.b());
        o2 r110 = new o2(r11);
        r18.getClass();
        Intrinsics.checkNotNullParameter(r19, "context");
        Intrinsics.checkNotNullParameter(r21, "containerID");
        Intrinsics.checkNotNullParameter(r23, "requestTask");
        Intrinsics.checkNotNullParameter(r110, "callback");
        int r111 = com.bytedance.android.annie.websocket.g.f;
        Intrinsics.checkNotNullParameter(r19, "context");
        Intrinsics.checkNotNullParameter(r23, "requestTask");
        com.bytedance.android.annie.websocket.g r112 = new com.bytedance.android.annie.websocket.g(r19, r23);
        com.bytedance.android.annie.websocket.h r24 = new com.bytedance.android.annie.websocket.h(r112);     // Catch: Throwable -> L33
        Class r25 = com.bytedance.android.annie.websocket.i.a();     // Catch: Throwable -> L26
    L27:
        if (r25 == null) goto L34;
        Object r26 = r25.getDeclaredConstructor(new Class[]{IMessageReceiveListener.class}).newInstance(new Object[]{r24});     // Catch: Throwable -> L33
        if ((r26 instanceof IWsClient) == false) goto L34;
        IWsClient r27 = (IWsClient) r26;     // Catch: Throwable -> L33
    L35:
        if (r27 == null) goto L37;
        r112.e = r27;
        Unit r28 = Unit.INSTANCE;
    L38:
        if (r28 != null) goto L40;
        r112 = null;
    L40:
        if (r112 == null) goto L54;
        String r29 = UUID.randomUUID().toString();
        r112.c = new SocketManager.b(r18, r21, r29, r110);
        HashMap<String, HashMap<String, ? super com.bytedance.android.annie.websocket.b>> r113 = SocketManager.a;
        monitor-enter(r113);
    L51:
        th = move-exception;
        throw th;
    L44:
        if (r113.containsKey(r21) == false) goto L48;
        HashMap<String, ? super com.bytedance.android.annie.websocket.b> r30 = r113.get(r21);     // Catch: Throwable -> L51
        if (r30 == null) goto L49;
        r30.put(r29, r112);     // Catch: Throwable -> L51
    L49:
        monitor-exit(r113);
        r112.f();
    L55:
        if (r29 == null) goto L57;
        ConnectSocketResultModel r114 = new ConnectSocketResultModel();
        r114.b(r29);
        r114.a(ConnectSocketResultModel.Code.Success);
        finishWithResult(r114);
        r14 = Unit.INSTANCE;
    L57:
        if (r14 != null) goto L66;
        finishWithFailure();
        return;
    L66:
        return;
    L48:
        HashMap<String, ? super com.bytedance.android.annie.websocket.b> r31 = new HashMap();     // Catch: Throwable -> L51
        r31.put(r29, r112);     // Catch: Throwable -> L51
        Unit r32 = Unit.INSTANCE;     // Catch: Throwable -> L51
        r113.put(r21, r31);     // Catch: Throwable -> L51
        goto L49
    L54:
        r29 = null;
        goto L55
    L37:
        r28 = null;
    L26:
        r25 = null;
    L34:
        r27 = null;
        goto L35
    L16:
        if (StringsKt.isBlank(r15) == true) goto L19;
        r16 = false;
        goto L20
    L13:
        r15 = null;
    L59:
        finishWithFailure();
        return;
    L5:
        if (StringsKt.isBlank(r0) == true) goto L8;
        r1 = false;
        goto L9
    }
}
