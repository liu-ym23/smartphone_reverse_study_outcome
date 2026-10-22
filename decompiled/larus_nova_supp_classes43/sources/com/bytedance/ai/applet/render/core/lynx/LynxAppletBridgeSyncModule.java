package com.bytedance.ai.applet.render.core.lynx;

import android.content.Context;
import com.bytedance.ai.bridge.ContainerType;
import com.bytedance.ai.bridge.core.AIBridgeMethod;
import com.bytedance.ai.bridge.protocol.model.ProtocolMessage;
import com.bytedance.ai.bridge.protocol.model.TargetEntity;
import com.bytedance.ai.event.MessageIndication;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.lynx.jsbridge.LynxMethod;
import com.lynx.jsbridge.LynxModule;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableMap;
import d3.a0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 (2\u00020\u0001:\u0002()B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\n\u001a\u00020\u000b2\u000e\u0010\f\u001a\n\u0018\u00010\rj\u0004\u0018\u0001`\u000eH\u0007J \u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00112\u000e\u0010\u0012\u001a\n\u0018\u00010\rj\u0004\u0018\u0001`\u000eH\u0002J \u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0010\u0010\u001a\u001a\u00020\u0019*\u00060\rj\u0002`\u000eH\u0002J\f\u0010\u001b\u001a\u00020\u000b*\u00020\u0019H\u0002J\f\u0010\u001c\u001a\u00020\u001d*\u00020\u001eH\u0002J\u001a\u0010\u001f\u001a\u00020\u000b2\b\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020\u000bH\u0002J$\u0010#\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00112\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u0005H\u0002R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/bytedance/ai/applet/render/core/lynx/LynxAppletBridgeSyncModule;", "Lcom/lynx/jsbridge/LynxModule;", "context", "Landroid/content/Context;", "remoteParams", "", "<init>", "(Landroid/content/Context;Ljava/lang/Object;)V", LynxAppletBridgeSyncModule.KEY_PARAMS, "Lcom/bytedance/ai/applet/render/core/lynx/LynxAppletBridgeSyncModule$Params;", "call", "Lcom/lynx/react/bridge/JavaOnlyMap;", com.bytedance.android.ec.core.event.a.KEY_MSG, "Lcom/lynx/react/bridge/ReadableMap;", "Lcom/bytedance/ai/applet/render/core/lynx/LynxReadableMap;", "handleSyncBridgeMethod", "methodName", "", "methodParams", "invokeBridgeMethodSync", "bridgeMethod", "Lcom/bytedance/ai/bridge/core/AIBridgeMethod;", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "methodInput", "Lcom/google/gson/JsonObject;", "toJsonObject", "toLynxJavaOnlyMap", "toLynxJavaOnlyArray", "Lcom/lynx/react/bridge/JavaOnlyArray;", "Lcom/google/gson/JsonArray;", "wrapProtocolMessage", "protocolMessage", "Lcom/bytedance/ai/bridge/protocol/model/ProtocolMessage;", "callbackParams", "createErrorResult", "code", "", MessageIndication.MESSAGE_TYPE_MSG, LynxAppletBridgeSyncModule.KEY_DATA, "Companion", "Params", "applet-render-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LynxAppletBridgeSyncModule extends LynxModule {
    public static final a Companion = null;
    private static final String KEY_DATA = "data";
    private static final String KEY_METHOD = "name";
    private static final String KEY_PARAMS = "params";
    public static final String NAME = "AppletBridgeSyncModule";
    private static final long SYNC_METHOD_TIMEOUT_MS = 3000;
    private static final String TAG = "LynxAppletBridgeSyncModule";
    private final b params;

    public static final class a {
        public a() {
        }
    }

    public static final class b {
        public final Function0<e3.d> a;

        /* JADX WARN: Multi-variable type inference failed */
        public b(Function0<? extends e3.d> r1) {
            this.a = r1;
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ void a(Ref.ObjectRef r0, AIBridgeMethod.Error r1) {
        invokeBridgeMethodSync$lambda$2$lambda$1(r0, r1);
    }

    public static /* synthetic */ void b(Ref.ObjectRef r0, JsonObject r1) {
        invokeBridgeMethodSync$lambda$2$lambda$0(r0, r1);
    }

    public static /* synthetic */ void c(Runnable r0, CountDownLatch r1) {
        invokeBridgeMethodSync$lambda$3(r0, r1);
    }

    public static /* synthetic */ void d(AIBridgeMethod r0, e3.d r1, JsonObject r10, Ref.ObjectRef r11, Ref.ObjectRef r12) {
        invokeBridgeMethodSync$lambda$2(r0, r1, r10, r11, r12);
    }

    private final JsonObject toJsonObject(ReadableMap r10) {
        return GsonProtectorUtils.toJsonTree(com.bytedance.ai.applet.base.gson.c.a(), r10.asHashMap()).getAsJsonObject();
    }

    private final JavaOnlyArray toLynxJavaOnlyArray(JsonArray r10) {
        JavaOnlyArray r0 = new JavaOnlyArray();
        Iterator r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L28;
        JsonPrimitive r1 = (JsonElement) r11.next();
        if ((r1 instanceof JsonNull) == true) goto L7;
        if ((r1 instanceof JsonObject) == true) goto L10;
        if ((r1 instanceof JsonArray) == true) goto L13;
        if ((r1 instanceof JsonPrimitive) == false) goto L4;
        JsonPrimitive r12 = r1;
        if (r12.isBoolean() == true) goto L18;
        if (r12.isString() == true) goto L21;
        if (r12.isNumber() == false) goto L4;
        if (StringsKt.contains$default(r12.getAsNumber().toString(), '.', false, 2, null) == true) goto L26;
        r0.add(Long.valueOf(r12.getAsNumber().longValue()));
        goto L4
    L26:
        r0.add(Double.valueOf(r12.getAsNumber().doubleValue()));
        goto L4
    L21:
        r0.add(r12.getAsString());
        goto L4
    L18:
        r0.add(Boolean.valueOf(r12.getAsBoolean()));
        goto L4
    L13:
        r0.add(toLynxJavaOnlyArray((JsonArray) r1));
        goto L4
    L10:
        r0.add(toLynxJavaOnlyMap((JsonObject) r1));
        goto L4
    L7:
        r0.add(null);
        goto L4
    L28:
        return r0;
    }

    private final JavaOnlyMap toLynxJavaOnlyMap(JsonObject r10) {
        JavaOnlyMap r0 = new JavaOnlyMap();
        Iterator r1 = r10.keySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L28;
        String r11 = (String) r1.next();
        JsonPrimitive r12 = r10.get(r11);
        if ((r12 instanceof JsonNull) == true) goto L7;
        if ((r12 instanceof JsonObject) == true) goto L10;
        if ((r12 instanceof JsonArray) == true) goto L13;
        if ((r12 instanceof JsonPrimitive) == false) goto L4;
        JsonPrimitive r13 = r12;
        if (r13.isBoolean() == true) goto L18;
        if (r13.isString() == true) goto L21;
        if (r13.isNumber() == false) goto L4;
        if (StringsKt.contains$default(r13.getAsNumber().toString(), '.', false, 2, null) == true) goto L26;
        r0.put(r11, Long.valueOf(r13.getAsNumber().longValue()));
        goto L4
    L26:
        r0.put(r11, Double.valueOf(r13.getAsNumber().doubleValue()));
        goto L4
    L21:
        r0.put(r11, r13.getAsString());
        goto L4
    L18:
        r0.put(r11, Boolean.valueOf(r13.getAsBoolean()));
        goto L4
    L13:
        r0.put(r11, toLynxJavaOnlyArray((JsonArray) r12));
        goto L4
    L10:
        r0.put(r11, toLynxJavaOnlyMap((JsonObject) r12));
        goto L4
    L7:
        r0.put(r11, null);
        goto L4
    L28:
        return r0;
    }

    @LynxMethod
    public final JavaOnlyMap call(ReadableMap r10) {
        com.bytedance.ai.applet.base.log.b r0 = com.bytedance.ai.applet.base.log.a.a;
        com.bytedance.ai.applet.base.log.a.a(TAG, "LynxMethod call --> " + r10);
        if (r10 == null) goto L5;
        JsonObject r1 = toJsonObject(r10);
    L6:
        if (r1 == null) goto L8;
        int r11 = ProtocolMessage.a;
        ProtocolMessage r12 = ProtocolMessage.b.a(r1);
    L9:
        if (r10 == null) goto L11;
        String r13 = r10.getString("name", null);
        if (e.a.contains(r13) == false) goto L15;
        Intrinsics.checkNotNull(r13);
        JavaOnlyMap r14 = handleSyncBridgeMethod(r13, r10.getMap(KEY_PARAMS));
    L19:
        return wrapProtocolMessage(r12, r14);
    L15:
        if (r13 != null) goto L17;
        r14 = createErrorResult$default(this, -3, "method is NULL", null, 4, null);
        goto L19
    L17:
        r14 = createErrorResult$default(this, -2, "unsupported sync method", null, 4, null);
        goto L19
    L11:
        return wrapProtocolMessage(null, createErrorResult$default(this, -3, "message is NULL", null, 4, null));
    L8:
        r12 = null;
        goto L9
    L5:
        r1 = null;
        goto L6
    }

    public LynxAppletBridgeSyncModule(Context r10, Object r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10);
        if ((r11 instanceof b) == false) goto L6;
        b r12 = (b) r11;
    L11:
        this.params = r12;
        return;
    L6:
        if ((r11 instanceof ArrayList) == false) goto L10;
        Object r13 = CollectionsKt.firstOrNull((List) r11);
        if ((r13 instanceof b) == false) goto L10;
        r12 = (b) r13;
    L10:
        r12 = null;
        goto L11
    }

    private final JavaOnlyMap handleSyncBridgeMethod(String r10, ReadableMap r11) {
        b r0 = this.params;
        if (r0 == null) goto L25;
        Function0<e3.d> r1 = r0.a;
        if (r1 == null) goto L25;
        e3.d r12 = (e3.d) r1.invoke();
        if (r12 == null) goto L25;
        a0 r13 = r12.getContainerContext();
        if (r13 == null) goto L13;
        ContainerType r14 = r13.getContainerType();
        if (r14 == null) goto L13;
    L14:
        AIBridgeMethod r15 = f3.k.b.a(r10, r14);
        if (r15 == null) goto L17;
        if (r11 == null) goto L21;
        JsonObject r16 = toJsonObject(r11);
        if (r16 == null) goto L21;
    L22:
        JavaOnlyMap r17 = invokeBridgeMethodSync(r15, r12, r16);
        com.bytedance.ai.applet.base.log.b r18 = com.bytedance.ai.applet.base.log.a.a;
        com.bytedance.ai.applet.base.log.a.a(TAG, "sync bridge method:" + r10 + " result --> " + r17);
        return r17;
    L21:
        r16 = new JsonObject();
        goto L22
    L17:
        return createErrorResult$default(this, -2, "unsupported sync method", null, 4, null);
    L13:
        r14 = ContainerType.NONE;
    L25:
        return createErrorResult$default(this, 0, "bridgeContext is NULL", null, 4, null);
    }

    private static final void invokeBridgeMethodSync$lambda$2$lambda$0(Ref.ObjectRef r0, JsonObject r1) {
        r0.element = r1;
    }

    private static final void invokeBridgeMethodSync$lambda$2$lambda$1(Ref.ObjectRef r0, AIBridgeMethod.Error r1) {
        r0.element = r1;
    }

    private static final void invokeBridgeMethodSync$lambda$3(Runnable r0, CountDownLatch r1) {
        r0.run();     // Catch: Throwable -> L5
        r1.countDown();
        return;
    L5:
        th = move-exception;
        r1.countDown();
        throw th;
    }

    private final JavaOnlyMap wrapProtocolMessage(ProtocolMessage r10, JavaOnlyMap r11) {
        JsonObject r12 = toJsonObject(r11);
        if (r10 == null) goto L6;
        ProtocolMessage r0 = r10.b(r12);
        if (r0 == null) goto L6;
    L15:
        int r13 = ProtocolMessage.a;
        JsonObject r14 = ProtocolMessage.b.c(r0);
        if (r14 != null) goto L19;
        r14 = new JsonObject();
        r14.add(KEY_PARAMS, r12);
        r14.addProperty("callbackId", r0.c());
        r14.addProperty("type", "Callback".toLowerCase(Locale.ROOT));
    L19:
        return toLynxJavaOnlyMap(r14);
    L6:
        if (r10 == null) goto L10;
        Integer r1 = r10.c();
        if (r1 == null) goto L10;
        int r15 = r1.intValue();
    L11:
        if (r10 == null) goto L13;
        TargetEntity r16 = r10.g();
    L14:
        ProtocolMessage.Type r17 = ProtocolMessage.Type.Callback;
        Integer r18 = Integer.valueOf(r15);
        r0 = new ProtocolMessage(null, r12, r18, r16, r17, 33);
        goto L15
    L13:
        r16 = null;
    L10:
        r15 = 0;
        goto L11
    }

    private final JavaOnlyMap createErrorResult(int r10, String r11, Object r12) {
        JavaOnlyMap r0 = new JavaOnlyMap();
        r0.put("code", Integer.valueOf(r10));
        r0.put(MessageIndication.MESSAGE_TYPE_MSG, r11);
        r0.put(KEY_DATA, r12);
        return r0;
    }

    /* JADX WARN: Type inference failed for: r8v0, types: [com.bytedance.ai.applet.render.core.lynx.h] */
    private final JavaOnlyMap invokeBridgeMethodSync(final AIBridgeMethod r10, final e3.d r11, final JsonObject r12) {
        final Ref.ObjectRef r13 = new Ref.ObjectRef();
        final Ref.ObjectRef r14 = new Ref.ObjectRef();
        final ?? r15 = new h(r10, r11, r12, r13, r14);
        if (r10.mustRunInMain() == true) goto L5;
    L10:
        r15.run();
    L11:
        Object r16 = r13.element;
        if (r16 == null) goto L14;
        Intrinsics.checkNotNull(r16);
        return toLynxJavaOnlyMap((JsonObject) r16);
    L14:
        Object r17 = r14.element;
        if (r17 == null) goto L25;
        int r18 = ((AIBridgeMethod.Error) r17).getCode();
        String r19 = ((AIBridgeMethod.Error) r14.element).getMsg();
        if (r19 != null) goto L19;
        r19 = "";
    L19:
        JsonObject r110 = ((AIBridgeMethod.Error) r14.element).getData();
        if (r110 == null) goto L22;
        JavaOnlyMap r111 = toLynxJavaOnlyMap(r110);
    L27:
        return createErrorResult(r18, r19, r111);
    L22:
        r111 = null;
        goto L27
    L25:
        return createErrorResult$default(this, 0, "sync method did not return immediately", null, 4, null);
    L5:
        if (p2.c.b() == true) goto L10;
        final CountDownLatch r112 = new CountDownLatch(1);
        p2.c.d(new i(r15, r112));
        if (r112.await(SYNC_METHOD_TIMEOUT_MS, TimeUnit.MILLISECONDS) == true) goto L11;
        return createErrorResult$default(this, 0, "sync method timeout", null, 4, null);
    }

    private static final void invokeBridgeMethodSync$lambda$2(AIBridgeMethod r1, e3.d r10, JsonObject r11, final Ref.ObjectRef r12, final Ref.ObjectRef r13) {
        r1.realHandle(r10, r11, new f(r12), new g(r13));
    }

    public static /* synthetic */ JavaOnlyMap createErrorResult$default(LynxAppletBridgeSyncModule r0, int r1, String r10, Object r11, int r12, Object r13) {
        if ((r12 & 4) == 0) goto L6;
        r11 = null;
    L6:
        return r0.createErrorResult(r1, r10, r11);
    }
}
