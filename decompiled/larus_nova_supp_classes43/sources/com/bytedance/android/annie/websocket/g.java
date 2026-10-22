package com.bytedance.android.annie.websocket;

import android.content.Context;
import com.bytedance.ai.event.MessageIndication;
import com.bytedance.frameworks.baselib.network.http.cronet.websocket.IWsClient;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class g extends com.bytedance.android.annie.websocket.a {
    public static final /* synthetic */ int f = 0;
    public IWsClient e;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.annie.websocket.a
    public final void g() {
        String r0 = this.b.a;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L8:
        boolean r10 = true;
    L9:
        if (r10 == false) goto L11;
        return;
    L11:
        IWsClient r11 = this.e;
        if (r11 == null) goto L70;
        HashMap r12 = new HashMap();
        HashMap r13 = new HashMap();
        Unit r14 = null;
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L35
        JsonObject r16 = this.b.b;     // Catch: Throwable -> L35
        if (r16 == null) goto L32;
        Iterator r17 = r16.keySet().iterator();     // Catch: Throwable -> L35
    L18:
        if (r17.hasNext() == false) goto L31;
        String r18 = (String) r17.next();     // Catch: Throwable -> L35
        if (r18.length() != 0) goto L22;
        boolean r19 = true;
    L23:
        if (r19 == true) goto L18;
        JsonElement r20 = r16.get(r18);     // Catch: Throwable -> L35
        if (r20 == null) goto L29;
        String r21 = r20.toString();     // Catch: Throwable -> L35
        if (r21 == null) goto L29;
    L30:
        r13.put(r18, r21);     // Catch: Throwable -> L35
    L29:
        r21 = "";
        goto L30
    L22:
        r19 = false;
        goto L23
    L31:
        Unit r22 = Unit.INSTANCE;     // Catch: Throwable -> L35
    L33:
        Result.constructor-impl(r22);     // Catch: Throwable -> L35
    L59:
        List<String> r23 = this.b.c;     // Catch: Throwable -> L53
        if (r23 == null) goto L51;
        int r24 = r23.size();     // Catch: Throwable -> L53
        StringBuilder r25 = new StringBuilder();     // Catch: Throwable -> L53
        int r26 = 0;
    L40:
        if (r26 >= r24) goto L45;
        r25.append((String) ListProtector.get(r23, r26));     // Catch: Throwable -> L53
        if (r26 == (r24 - 1)) goto L44;
        r25.append(",");     // Catch: Throwable -> L53
    L44:
        r26 = r26 + 1;     // Catch: Throwable -> L53
        goto L40
    L45:
        String r27 = r25.toString();     // Catch: Throwable -> L53
        if (r27.length() <= 0) goto L48;
        r1 = true;
    L48:
        if (r1 == false) goto L50;
        r13.put("Sec-WebSocket-Protocol", r27);     // Catch: Throwable -> L53
    L50:
        r14 = Unit.INSTANCE;     // Catch: Throwable -> L53
    L51:
        Result.constructor-impl(r14);     // Catch: Throwable -> L53
    L55:
        r11.openConnection(r12, r13, CollectionsKt.listOf(this.b.a), false, false);
        return;
    L53:
        th = move-exception;
        Result.Companion r28 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L55
    L32:
        r22 = null;
    L35:
        th = move-exception;
        Result.Companion r29 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L59
    L70:
        return;
    L5:
        if (StringsKt.isBlank(r0) == true) goto L8;
        r10 = false;
        goto L9
    }

    @Override // com.bytedance.android.annie.websocket.a
    public final void h() {
        IWsClient r0 = this.e;     // Catch: Throwable -> L7
        if (r0 == null) goto L5;
        r0.stopConnection();     // Catch: Throwable -> L7
    L5:
        d();
    }

    @Override // com.bytedance.android.annie.websocket.b
    public final String b(String r10) {
        Intrinsics.checkNotNullParameter(r10, MessageIndication.MESSAGE_TYPE_MSG);
        IWsClient r0 = this.e;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        boolean r11 = false;
    L8:
        if (r11 == false) goto L17;
        monitor-enter(this);
        int r12 = this.d;     // Catch: Throwable -> L14
        monitor-exit(this);
        if (r12 != 1) goto L17;
        r1 = true;
    L14:
        th = move-exception;
        throw th;
    L17:
        if (r1 == true) goto L29;
        return "the socket is disconnected";
    L29:
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L25
        IWsClient r14 = this.e;     // Catch: Throwable -> L25
        if (r14 == null) goto L22;
        Boolean r15 = Boolean.valueOf(r14.sendMessage(r10.getBytes(StandardCharsets.UTF_8), 1));     // Catch: Throwable -> L25
    L23:
        Result.constructor-impl(r15);     // Catch: Throwable -> L25
        return null;
    L22:
        r15 = null;
    L25:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        return null;
    L5:
        if (r0.isConnected() != true) goto L7;
        r11 = true;
        goto L8
    }

    @Override // com.bytedance.android.annie.websocket.b
    public final String sendMessage(byte[] r10) {
        Intrinsics.checkNotNullParameter(r10, "byteData");
        IWsClient r0 = this.e;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        boolean r11 = false;
    L8:
        if (r11 == false) goto L17;
        monitor-enter(this);
        int r12 = this.d;     // Catch: Throwable -> L14
        monitor-exit(this);
        if (r12 != 1) goto L17;
        r1 = true;
    L14:
        th = move-exception;
        throw th;
    L17:
        if (r1 == true) goto L29;
        return "the socket is disconnected";
    L29:
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L25
        IWsClient r14 = this.e;     // Catch: Throwable -> L25
        if (r14 == null) goto L22;
        Boolean r15 = Boolean.valueOf(r14.sendMessage(r10, 2));     // Catch: Throwable -> L25
    L23:
        Result.constructor-impl(r15);     // Catch: Throwable -> L25
        return null;
    L22:
        r15 = null;
    L25:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        return null;
    L5:
        if (r0.isConnected() != true) goto L7;
        r11 = true;
        goto L8
    }

    public g(Context r10, f r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "requestTask");
        super(r10, r11);
    }
}
