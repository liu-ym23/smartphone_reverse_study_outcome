package com.bytedance.android.annie.bridge.method;

import android.util.Base64;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.annie.bridge.method.abs.SendSocketDataResultModel;
import com.bytedance.android.annie.websocket.SocketManager;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import java.util.HashMap;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@XBridgeMethod(biz = "webcast_sdk", name = "sendSocketData")
public final class d2 extends e7.z<e7.v0, SendSocketDataResultModel> {
    public final IHybridComponent a;

    public d2(m16.b r10) {
        Intrinsics.checkNotNullParameter(r10, "contextProviderFactory");
        IHybridComponent r11 = (IHybridComponent) r10.c(IHybridComponent.class);
        if (r11 == null) goto L6;
        this.a = r11;
        return;
    }

    public d2(IHybridComponent r1) {
        this.a = r1;
    }

    public final void invoke(Object r10, CallContext r11) {
        e7.v0 r12 = (e7.v0) r10;
        Intrinsics.checkNotNullParameter(r12, "params");
        Intrinsics.checkNotNullParameter(r11, "context");
        IHybridComponent r13 = this.a;
        String r0 = null;
        if (r13 == null) goto L5;
        String r14 = r13.containerId();
    L6:
        boolean r1 = true;
        if (r14 != null) goto L9;
    L12:
        boolean r15 = true;
    L13:
        if (r15 == true) goto L75;
        String r16 = r12.c();
        if (r16 != null) goto L17;
    L20:
        boolean r17 = true;
    L21:
        if (r17 == true) goto L75;
        Ref.ObjectRef r18 = new Ref.ObjectRef();
        String r19 = r12.b();
        if (Intrinsics.areEqual(r19, "string") == false) goto L29;
        String r20 = r12.a();
        if (r20 == null) goto L40;
        r0 = r20;
    L40:
        if (r0 != null) goto L42;
    L44:
        boolean r21 = false;
    L45:
        String r22 = "The socketTaskID doesn't exist";
        if (r21 == false) goto L55;
        HashMap<String, HashMap<String, ? super com.bytedance.android.annie.websocket.b>> r23 = SocketManager.a;
        SocketManager r24 = SocketManager.a.a();
        IHybridComponent r25 = this.a;
        Intrinsics.checkNotNull(r25);
        String r26 = r25.containerId();
        String r27 = r12.c();
        Intrinsics.checkNotNull(r27);
        Intrinsics.checkNotNull(r0);
        r24.getClass();
        Intrinsics.checkNotNullParameter(r26, "containerID");
        Intrinsics.checkNotNullParameter(r27, "socketTaskID");
        Intrinsics.checkNotNullParameter(r0, "txt");
        List r28 = SocketManager.c(r26, r27);
        if (r28 == null) goto L53;
        com.bytedance.android.annie.websocket.b r29 = (com.bytedance.android.annie.websocket.b) ListProtector.get(r28, 0);
        if (r29 == null) goto L53;
        r22 = r29.b(r0);
    L53:
        if (r22 == null) goto L74;
        finishWithFailure();
        return;
    L74:
        SendSocketDataResultModel r30 = new SendSocketDataResultModel();
        r30.a(SendSocketDataResultModel.Code.Success);
        finishWithResult(r30);
        return;
    L55:
        byte[] r31 = (byte[]) r18.element;
        if (r31 != null) goto L58;
    L64:
        r1 = false;
    L65:
        if (r1 == false) goto L74;
        HashMap<String, HashMap<String, ? super com.bytedance.android.annie.websocket.b>> r32 = SocketManager.a;
        SocketManager r33 = SocketManager.a.a();
        IHybridComponent r34 = this.a;
        Intrinsics.checkNotNull(r34);
        String r35 = r34.containerId();
        String r36 = r12.c();
        Intrinsics.checkNotNull(r36);
        Object r37 = r18.element;
        Intrinsics.checkNotNull(r37);
        byte[] r38 = (byte[]) r37;
        r33.getClass();
        Intrinsics.checkNotNullParameter(r35, "containerID");
        Intrinsics.checkNotNullParameter(r36, "socketTaskID");
        Intrinsics.checkNotNullParameter(r38, "byteData");
        List r39 = SocketManager.c(r35, r36);
        if (r39 == null) goto L72;
        com.bytedance.android.annie.websocket.b r40 = (com.bytedance.android.annie.websocket.b) ListProtector.get(r39, 0);
        if (r40 == null) goto L72;
        r22 = r40.sendMessage(r38);
    L72:
        if (r22 == null) goto L74;
        finishWithFailure();
        return;
    L58:
        if (r31.length != 0) goto L60;
        boolean r41 = true;
    L62:
        if ((!r41) != true) goto L64;
    L60:
        r41 = false;
        goto L62
    L42:
        if ((!StringsKt.isBlank(r0)) != true) goto L44;
        r21 = true;
        goto L45
    L29:
        if (Intrinsics.areEqual(r19, "base64") == false) goto L40;
        String r42 = r12.a();
        if (r42 == null) goto L40;
        Result.Companion r43 = Result.Companion;     // Catch: Throwable -> L34
        Object r44 = Result.constructor-impl(Base64.decode(r42, 0));     // Catch: Throwable -> L34
    L37:
        if (Result.isFailure-impl(r44) == false) goto L39;
        r44 = null;
    L39:
        r18.element = r44;
    L34:
        th = move-exception;
        Result.Companion r45 = Result.Companion;
        r44 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L37
    L17:
        if (StringsKt.isBlank(r16) == true) goto L20;
        r17 = false;
    L75:
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
