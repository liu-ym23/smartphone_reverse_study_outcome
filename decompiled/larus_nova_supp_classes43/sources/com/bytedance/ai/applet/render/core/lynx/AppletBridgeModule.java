package com.bytedance.ai.applet.render.core.lynx;

import android.content.Context;
import androidx.core.util.Consumer;
import com.bytedance.ai.bridge.ContainerType;
import com.bytedance.ai.bridge.protocol.model.ProtocolMessage;
import com.bytedance.ai.bridge.protocol.model.TargetEntity;
import com.bytedance.ai.event.MessageIndication;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.JsonObject;
import com.lynx.jsbridge.LynxMethod;
import com.lynx.jsbridge.LynxModule;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableMap;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 &2\u00020\u00012\u00020\u0002:\u0002&'B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000b\u001a\u00020\f2\u000e\u0010\r\u001a\n\u0018\u00010\u000ej\u0004\u0018\u0001`\u000fH\u0007J\u001a\u0010\u0010\u001a\u00020\f2\u0010\u0010\u0011\u001a\f\u0012\b\u0012\u00060\u000ej\u0002`\u000f0\u0012H\u0016J\u001f\u0010\u0013\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0002\u0010\u0017J\u0018\u0010\u0018\u001a\u00020\u00142\u000e\u0010\r\u001a\n\u0018\u00010\u000ej\u0004\u0018\u0001`\u000fH\u0007J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0007J\u001a\u0010\u001d\u001a\u00020\u00142\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020\u0014H\u0002J$\u0010!\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u001c2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0006H\u0002R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/bytedance/ai/applet/render/core/lynx/AppletBridgeModule;", "Lcom/lynx/jsbridge/LynxModule;", "Lcom/bytedance/ai/applet/render/core/lynx/BridgeMessageDelegate;", "context", "Landroid/content/Context;", "remoteParams", "", "<init>", "(Landroid/content/Context;Ljava/lang/Object;)V", AppletBridgeModule.KEY_PARAMS, "Lcom/bytedance/ai/applet/render/core/lynx/AppletBridgeModule$Params;", "postMessage", "", com.bytedance.android.ec.core.event.a.KEY_MSG, "Lcom/lynx/react/bridge/ReadableMap;", "Lcom/bytedance/ai/applet/render/core/lynx/LynxReadableMap;", "setMessageHandle", "handle", "Landroidx/core/util/Consumer;", "sendMessage", "Lcom/lynx/react/bridge/JavaOnlyMap;", "msgId", "", "(Lcom/lynx/react/bridge/JavaOnlyMap;Ljava/lang/Long;)V", "postMessageSync", "canIUse", "", com.bytedance.android.ec.core.event.a.KEY_SCHEMA, "", "wrapProtocolMessage", "protocolMessage", "Lcom/bytedance/ai/bridge/protocol/model/ProtocolMessage;", "callbackParams", "createErrorResult", "code", "", MessageIndication.MESSAGE_TYPE_MSG, AppletBridgeModule.KEY_DATA, "Companion", "Params", "applet-render-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppletBridgeModule extends LynxModule implements com.bytedance.ai.applet.render.core.lynx.a {
    public static final a Companion = null;
    private static final String KEY_DATA = "data";
    private static final String KEY_PARAMS = "params";
    public static final String NAME = "AppletBridgeModule";
    public static final String TAG = "AppletBridgeModule";
    private final b params;

    public static final class a {
        public a() {
        }
    }

    public static final class b {
        public final Object a;
        public final Function2<String, ContainerType, Boolean> b;
        public final Function0<m4.c> c;
        public final ContainerType d;
        public final Function2<JavaOnlyMap, Long, Unit> e;

        public /* synthetic */ b(s4.c r10, Function2 r11, Function0 r12, ContainerType r13) {
            this(r10, r11, r12, r13, null);
        }

        public b(s4.c r10, Function2 r11, Function0 r12, ContainerType r13, Function2 r14) {
            Intrinsics.checkNotNullParameter(r13, "containerType");
            this.a = r10;
            this.b = r11;
            this.c = r12;
            this.d = r13;
            this.e = r14;
        }
    }

    static {
        Companion = new a();
    }

    @LynxMethod
    public final boolean canIUse(String r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
        com.bytedance.ai.applet.base.log.b r0 = com.bytedance.ai.applet.base.log.a.a;
        com.bytedance.ai.applet.base.log.a.a("AppletBridgeModule", "LynxMethod canIUse --> " + r10);
        b r1 = this.params;
        if (r1 != null) goto L6;
        com.bytedance.ai.applet.base.log.a.b("AppletBridgeModule", "params is NULL", null);
        return false;
    L6:
        Function2<String, ContainerType, Boolean> r11 = r1.b;
        if (r11 != null) goto L11;
        com.bytedance.ai.applet.base.log.a.b("AppletBridgeModule", "checkCanIUse is NULL", null);
        return false;
    L11:
        return ((Boolean) r11.invoke(r10, r1.d)).booleanValue();
    }

    @LynxMethod
    public final void postMessage(ReadableMap r10) {
        com.bytedance.ai.applet.base.log.b r0 = com.bytedance.ai.applet.base.log.a.a;
        com.bytedance.ai.applet.base.log.a.a("AppletBridgeModule", "LynxMethod postMessage --> " + r10);
        if (r10 != null) goto L5;
        return;
    L5:
        b r1 = this.params;
        if (r1 == null) goto L8;
        Object r11 = r1.a;
    L10:
        if ((r11 instanceof s4.c) == false) goto L12;
        s4.c r12 = (s4.c) r11;
    L13:
        if (r12 == null) goto L15;
        r12.b(r10);
        return;
    L15:
        com.bytedance.ai.applet.base.log.a.b("AppletBridgeModule", "remoteMessageCache is NULL", null);
        return;
    L12:
        r12 = null;
        goto L13
    L8:
        r11 = null;
        goto L10
    }

    @LynxMethod
    public final JavaOnlyMap postMessageSync(ReadableMap r10) {
        com.bytedance.ai.applet.base.log.b r0 = com.bytedance.ai.applet.base.log.a.a;
        com.bytedance.ai.applet.base.log.a.a("AppletBridgeModule", "LynxMethod postMessageSync --> " + r10);
        if (r10 == null) goto L5;
        Intrinsics.checkNotNullParameter(r10, "<this>");
        JsonObject r1 = GsonProtectorUtils.toJsonTree(com.bytedance.ai.applet.base.gson.c.a(), r10.asHashMap()).getAsJsonObject();
    L6:
        if (r1 == null) goto L8;
        int r11 = ProtocolMessage.a;
        ProtocolMessage r12 = ProtocolMessage.b.a(r1);
    L9:
        if (r10 == null) goto L11;
        b r13 = this.params;
        if (r13 == null) goto L32;
        Function0<m4.c> r14 = r13.c;
        if (r14 == null) goto L32;
        m4.c r15 = (m4.c) r14.invoke();
        if (r15 == null) goto L32;
        if (r1 != null) goto L21;
        r1 = new JsonObject();
    L21:
        com.bytedance.ai.bridge.core.a<JsonObject> r16 = r15.handleSyncMessage(r1);
        if ((r16 instanceof com.bytedance.ai.bridge.core.a.c) == false) goto L25;
        JavaOnlyMap r17 = j.b((JsonObject) ((com.bytedance.ai.bridge.core.a.c) r16).b);
    L28:
        return wrapProtocolMessage(r12, r17);
    L25:
        if ((r16 instanceof com.bytedance.ai.bridge.core.a.b) == false) goto L30;
        com.bytedance.ai.bridge.core.a.b r18 = (com.bytedance.ai.bridge.core.a.b) r16;
        r17 = createErrorResult(r18.b, r18.c, r18.d);
        goto L28
    L30:
        throw new NoWhenBranchMatchedException();
    L32:
        return wrapProtocolMessage(r12, createErrorResult$default(this, 0, "port is NULL", null, 4, null));
    L11:
        return wrapProtocolMessage(null, createErrorResult$default(this, -3, "message is NULL", null, 4, null));
    L8:
        r12 = null;
        goto L9
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.bytedance.ai.applet.render.core.lynx.a
    public void setMessageHandle(Consumer<ReadableMap> r10) {
        Intrinsics.checkNotNullParameter(r10, "handle");
        b r0 = this.params;
        s4.c r1 = null;
        if (r0 == null) goto L5;
        Object r11 = r0.a;
    L7:
        if ((r11 instanceof s4.c) == false) goto L9;
        r1 = (s4.c) r11;
    L9:
        if (r1 == null) goto L12;
        r1.d(r10);
        return;
    L12:
        return;
    L5:
        r11 = null;
        goto L7
    }

    public AppletBridgeModule(Context r10, Object r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10);
        if ((r11 instanceof b) == false) goto L5;
        b r12 = (b) r11;
    L6:
        this.params = r12;
        return;
    L5:
        r12 = null;
        goto L6
    }

    private final JavaOnlyMap wrapProtocolMessage(ProtocolMessage r10, JavaOnlyMap r11) {
        Intrinsics.checkNotNullParameter(r11, "<this>");
        JsonObject r12 = GsonProtectorUtils.toJsonTree(com.bytedance.ai.applet.base.gson.c.a(), r11.asHashMap()).getAsJsonObject();
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
        return j.b(r14);
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

    @Override // com.bytedance.ai.applet.render.core.lynx.a
    public void sendMessage(JavaOnlyMap r10, Long r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_MSG);
        b r0 = this.params;
        if (r0 == null) goto L8;
        Function2<JavaOnlyMap, Long, Unit> r1 = r0.e;
        if (r1 == null) goto L9;
        r1.invoke(r10, r11);
        return;
    L9:
        return;
    }

    private final JavaOnlyMap createErrorResult(int r10, String r11, Object r12) {
        JavaOnlyMap r0 = new JavaOnlyMap();
        r0.put("code", Integer.valueOf(r10));
        r0.put(MessageIndication.MESSAGE_TYPE_MSG, r11);
        r0.put(KEY_DATA, r12);
        return r0;
    }

    public static /* synthetic */ JavaOnlyMap createErrorResult$default(AppletBridgeModule r0, int r1, String r10, Object r11, int r12, Object r13) {
        if ((r12 & 4) == 0) goto L6;
        r11 = null;
    L6:
        return r0.createErrorResult(r1, r10, r11);
    }
}
