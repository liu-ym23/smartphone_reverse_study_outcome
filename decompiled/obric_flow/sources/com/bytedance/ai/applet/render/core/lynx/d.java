package com.bytedance.ai.applet.render.core.lynx;

import com.bytedance.ai.bridge.protocol.model.ProtocolMessage;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.tasm.LynxView;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends i2.c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LynxView f1763c;
    public final l2.a d;

    public d(LynxView r5, l2.a r10) {
        Intrinsics.checkNotNullParameter(r5, "lynxView");
        Intrinsics.checkNotNullParameter(r10, "remoteMessageCache");
        this.f1763c = r5;
        this.d = r10;
    }

    public static JavaOnlyArray e(JsonArray r5) {
        JavaOnlyArray r10 = new JavaOnlyArray();
        Iterator<JsonElement> r11 = r5.iterator();
    L4:
        if (r11.hasNext() == false) goto L28;
        JsonElement r12 = r11.next();
        if ((r12 instanceof JsonNull) == true) goto L7;
        if ((r12 instanceof JsonObject) == true) goto L10;
        if ((r12 instanceof JsonArray) == true) goto L13;
        if ((r12 instanceof JsonPrimitive) == false) goto L4;
        JsonPrimitive r13 = (JsonPrimitive) r12;
        if (r13.isBoolean() == true) goto L18;
        if (r13.isString() == true) goto L21;
        if (r13.isNumber() == false) goto L4;
        if (StringsKt.f(r13.getAsNumber().toString(), '.') == true) goto L26;
        r10.add(Long.valueOf(r13.getAsNumber().longValue()));
        goto L4
    L26:
        r10.add(Double.valueOf(r13.getAsNumber().doubleValue()));
        goto L4
    L21:
        r10.add(r13.getAsString());
        goto L4
    L18:
        r10.add(Boolean.valueOf(r13.getAsBoolean()));
        goto L4
    L13:
        r10.add(e((JsonArray) r12));
        goto L4
    L10:
        r10.add(f((JsonObject) r12));
        goto L4
    L7:
        r10.add(null);
        goto L4
    L28:
        return r10;
    }

    public static JavaOnlyMap f(JsonObject r10) {
        JavaOnlyMap r5 = new JavaOnlyMap();
        Iterator<T> r11 = r10.keySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L28;
        String r12 = (String) r11.next();
        JsonElement r13 = r10.get(r12);
        if ((r13 instanceof JsonNull) == true) goto L7;
        if ((r13 instanceof JsonObject) == true) goto L10;
        if ((r13 instanceof JsonArray) == true) goto L13;
        if ((r13 instanceof JsonPrimitive) == false) goto L4;
        JsonPrimitive r14 = (JsonPrimitive) r13;
        if (r14.isBoolean() == true) goto L18;
        if (r14.isString() == true) goto L21;
        if (r14.isNumber() == false) goto L4;
        if (StringsKt.f(r14.getAsNumber().toString(), '.') == true) goto L26;
        r5.put(r12, Long.valueOf(r14.getAsNumber().longValue()));
        goto L4
    L26:
        r5.put(r12, Double.valueOf(r14.getAsNumber().doubleValue()));
        goto L4
    L21:
        r5.put(r12, r14.getAsString());
        goto L4
    L18:
        r5.put(r12, Boolean.valueOf(r14.getAsBoolean()));
        goto L4
    L13:
        r5.put(r12, e((JsonArray) r13));
        goto L4
    L10:
        r5.put(r12, f((JsonObject) r13));
        goto L4
    L7:
        r5.put(r12, null);
        goto L4
    L28:
        return r5;
    }

    @Override // i2.c
    public final void a() {
        super.a();
        this.d.a();
    }

    @Override // i2.c
    public final void b(i2.a r5) {
        Intrinsics.checkNotNullParameter(r5, "consumer");
        c r10 = new c(r5, 0);
        this.d.b(r10);
    }

    @Override // i2.c
    public final void d(j2.a r5) {
        Intrinsics.checkNotNullParameter(r5, "messageWrapper");
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L6
        LynxView r11 = this.f1763c;     // Catch: Throwable -> L6
        JsonObject r12 = com.lynx.tasm.utils.b.c((ProtocolMessage) r5.f22372b);     // Catch: Throwable -> L6
        if (r12 == null) goto L8;
        JavaOnlyMap r13 = f(r12);     // Catch: Throwable -> L6
    L9:
        r11.sendGlobalEvent("__APPLET_BRIDGE__", new JavaOnlyArray(Arrays.asList(new Object[]{r13})));     // Catch: Throwable -> L6
        Object r14 = Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L6
    L12:
        Throwable r15 = Result.m127exceptionOrNullimpl(r14);
        if (r15 == null) goto L18;
        String r16 = "[LynxAIBridgePort] post msg to lynx view error with msg:" + r15.getMessage();
        Intrinsics.checkNotNullParameter("ai_bridge", "tag");
        Intrinsics.checkNotNullParameter(r16, "msg");
        a1.a.f43a.e("ai_bridge", r16, null);
        return;
    L18:
        return;
    L8:
        r13 = new JavaOnlyMap();     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r14 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L12
    }
}
