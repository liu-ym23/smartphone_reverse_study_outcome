package com.bytedance.ai.bridge.protocol.model;

import com.bytedance.ai.applet.base.gson.c;
import com.bytedance.ai.applet.base.gson.e;
import com.bytedance.ai.event.MessageIndication;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u0000 22\u00020\u0001:\u0003234BM\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010!\u001a\u0004\u0018\u00010\u0000\"\u0004\b\u0000\u0010\"2\u0006\u0010\u0004\u001a\u0002H\"¢\u0006\u0002\u0010#J\u0006\u0010$\u001a\u00020\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010'\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0015J\u000b\u0010(\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\t\u0010*\u001a\u00020\rHÆ\u0003JT\u0010+\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\rHÆ\u0001¢\u0006\u0002\u0010,J\u0013\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00100\u001a\u00020\u0007HÖ\u0001J\t\u00101\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\f\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u001e8F¢\u0006\u0006\u001a\u0004\b\u001f\u0010 ¨\u00065"}, d2 = {"Lcom/bytedance/ai/bridge/protocol/model/ProtocolMessage;", "", com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME, "", "params", "Lcom/google/gson/JsonObject;", "callbackId", "", "target", "Lcom/bytedance/ai/bridge/protocol/model/TargetEntity;", "type", "Lcom/bytedance/ai/bridge/protocol/model/ProtocolMessage$Type;", "timestamp", "", "<init>", "(Ljava/lang/String;Lcom/google/gson/JsonObject;Ljava/lang/Integer;Lcom/bytedance/ai/bridge/protocol/model/TargetEntity;Lcom/bytedance/ai/bridge/protocol/model/ProtocolMessage$Type;J)V", "getName", "()Ljava/lang/String;", "getParams", "()Lcom/google/gson/JsonObject;", "getCallbackId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTarget", "()Lcom/bytedance/ai/bridge/protocol/model/TargetEntity;", "getType", "()Lcom/bytedance/ai/bridge/protocol/model/ProtocolMessage$Type;", "getTimestamp", "()J", "callbackParams", "Lcom/bytedance/ai/bridge/protocol/model/ProtocolMessage$CallbackParams;", "getCallbackParams", "()Lcom/bytedance/ai/bridge/protocol/model/ProtocolMessage$CallbackParams;", "createCallback", "T", "(Ljava/lang/Object;)Lcom/bytedance/ai/bridge/protocol/model/ProtocolMessage;", "toJSONString", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Lcom/google/gson/JsonObject;Ljava/lang/Integer;Lcom/bytedance/ai/bridge/protocol/model/TargetEntity;Lcom/bytedance/ai/bridge/protocol/model/ProtocolMessage$Type;J)Lcom/bytedance/ai/bridge/protocol/model/ProtocolMessage;", "equals", "", "other", "hashCode", "toString", "Companion", "Type", "CallbackParams", "applet-bridge_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ProtocolMessage {
    public static final /* synthetic */ int a = 0;

    @SerializedName("callbackId")
    private final Integer callbackId;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME)
    private final String name;

    @SerializedName("params")
    private final JsonObject params;

    @SerializedName("target")
    private final TargetEntity target;

    @SerializedName("timestamp")
    private final long timestamp;

    @SerializedName("type")
    private final Type type;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ai/bridge/protocol/model/ProtocolMessage$Type;", "", "<init>", "(Ljava/lang/String;I)V", "Call", "Callback", "Event", "applet-bridge_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Type extends Enum<Type> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ Type[] $VALUES = null;

        @SerializedName("call")
        public static final Type Call = null;

        @SerializedName("callback")
        public static final Type Callback = null;

        @SerializedName("event")
        public static final Type Event = null;

        private static final /* synthetic */ Type[] $values() {
            return new Type[]{Call, Callback, Event};
        }

        public static EnumEntries<Type> getEntries() {
            return $ENTRIES;
        }

        static {
            Call = new Type("Call", 0);
            Callback = new Type("Callback", 1);
            Event = new Type("Event", 2);
            Type[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = EnumEntriesKt.enumEntries(r0);
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }

        public static Type valueOf(String r1) {
            return (Type) r27.a.a(Type.class, r1);
        }

        private Type(String r1, int r10) {
            super(r1, r10);
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tR\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ai/bridge/protocol/model/ProtocolMessage$CallbackParams;", "", "code", "", MessageIndication.MESSAGE_TYPE_MSG, "", "data", "Lcom/google/gson/JsonObject;", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Lcom/google/gson/JsonObject;)V", "getCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMsg", "()Ljava/lang/String;", "getData", "()Lcom/google/gson/JsonObject;", "applet-bridge_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a {

        @SerializedName("code")
        private final Integer code;

        @SerializedName("data")
        private final JsonObject data;

        @SerializedName(MessageIndication.MESSAGE_TYPE_MSG)
        private final String msg;

        public a() {
            this.code = 0;
            this.msg = "";
            this.data = null;
        }

        public final Integer a() {
            return this.code;
        }

        public final JsonObject b() {
            return this.data;
        }

        public final String c() {
            return this.msg;
        }
    }

    public static final class b {
        @JvmStatic
        public static ProtocolMessage a(JsonObject r10) {
            Intrinsics.checkNotNullParameter(r10, "raw");
            Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
            Lazy r1 = e.a;     // Catch: Throwable -> L5
            Object r11 = Result.constructor-impl((ProtocolMessage) GsonProtectorUtils.fromJson(c.a(), r10, ProtocolMessage.class));     // Catch: Throwable -> L5
        L7:
            Throwable r12 = Result.exceptionOrNull-impl(r11);
            if (r12 == null) goto L11;
            com.bytedance.ai.applet.base.log.b r13 = com.bytedance.ai.applet.base.log.a.a;
            com.bytedance.ai.applet.base.log.a.b("ai_bridge", "deserializer json to ProtocolMessage error " + r12.getMessage(), null);
        L11:
            if (Result.isFailure-impl(r11) == false) goto L14;
            r11 = null;
        L14:
            return (ProtocolMessage) r11;
        L5:
            th = move-exception;
            Result.Companion r14 = Result.Companion;
            r11 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L7
        }

        @JvmStatic
        public static ProtocolMessage b(String r10) {
            Intrinsics.checkNotNullParameter(r10, "raw");
            Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
            Lazy r1 = e.a;     // Catch: Throwable -> L5
            Object r11 = Result.constructor-impl((ProtocolMessage) e.a(r10, ProtocolMessage.class));     // Catch: Throwable -> L5
        L7:
            Throwable r12 = Result.exceptionOrNull-impl(r11);
            if (r12 == null) goto L11;
            com.bytedance.ai.applet.base.log.b r13 = com.bytedance.ai.applet.base.log.a.a;
            com.bytedance.ai.applet.base.log.a.b("ai_bridge", "deserializer string to ProtocolMessage error " + r12.getMessage(), null);
        L11:
            if (Result.isFailure-impl(r11) == false) goto L14;
            r11 = null;
        L14:
            return (ProtocolMessage) r11;
        L5:
            th = move-exception;
            Result.Companion r14 = Result.Companion;
            r11 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L7
        }

        @JvmStatic
        public static JsonObject c(ProtocolMessage r10) {
            Intrinsics.checkNotNullParameter(r10, "protocolMessage");
            Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
            Object r11 = Result.constructor-impl(e.d(r10));     // Catch: Throwable -> L5
        L7:
            Throwable r1 = Result.exceptionOrNull-impl(r11);
            if (r1 == null) goto L11;
            com.bytedance.ai.applet.base.log.b r12 = com.bytedance.ai.applet.base.log.a.a;
            com.bytedance.ai.applet.base.log.a.b("ai_bridge", "serializer ProtocolMessage error " + r1.getMessage(), null);
        L11:
            if (Result.isFailure-impl(r11) == false) goto L14;
            r11 = null;
        L14:
            return (JsonObject) r11;
        L5:
            th = move-exception;
            Result.Companion r13 = Result.Companion;
            r11 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L7
        }
    }

    static {
    }

    public ProtocolMessage() {
        this(null, null, null, null, null, 63);
    }

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof ProtocolMessage) == true) goto L8;
        return false;
    L8:
        ProtocolMessage r11 = (ProtocolMessage) r10;
        if (Intrinsics.areEqual(this.name, r11.name) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.params, r11.params) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.callbackId, r11.callbackId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.target, r11.target) == true) goto L21;
        return false;
    L21:
        if (this.type == r11.type) goto L24;
        return false;
    L24:
        if (this.timestamp == r11.timestamp) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        String r0 = this.name;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r10 = 0;
    L6:
        int r11 = r10 * 31;
        JsonObject r12 = this.params;
        if (r12 != null) goto L9;
        int r13 = 0;
    L10:
        int r14 = (r11 + r13) * 31;
        Integer r15 = this.callbackId;
        if (r15 != null) goto L13;
        int r16 = 0;
    L14:
        int r17 = (r14 + r16) * 31;
        TargetEntity r18 = this.target;
        if (r18 != null) goto L17;
        int r19 = 0;
    L18:
        int r20 = (r17 + r19) * 31;
        Type r21 = this.type;
        if (r21 == null) goto L22;
        r1 = r21.hashCode();
    L22:
        int r22 = (r20 + r1) * 31;
        long r23 = this.timestamp;
        return r22 + ((int) (r23 ^ (r23 >>> 32)));
    L17:
        r19 = r18.hashCode();
        goto L18
    L13:
        r16 = r15.hashCode();
        goto L14
    L9:
        r13 = r12.hashCode();
        goto L10
    L5:
        r10 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "ProtocolMessage(name=" + this.name + ", params=" + this.params + ", callbackId=" + this.callbackId + ", target=" + this.target + ", type=" + this.type + ", timestamp=" + this.timestamp + ')';
    }

    public final a d() {
        Object r10 = null;
        if (this.type != Type.Callback) goto L18;
        JsonObject r0 = this.params;
        if (r0 == null) goto L19;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L8
        Lazy r11 = e.a;     // Catch: Throwable -> L8
        Object r12 = Result.constructor-impl((a) GsonProtectorUtils.fromJson(c.a(), r0, a.class));     // Catch: Throwable -> L8
    L11:
        if (Result.isFailure-impl(r12) == true) goto L15;
        r10 = r12;
    L15:
        return (a) r10;
    L8:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    L19:
        return null;
    L18:
        return null;
    }

    public final String i() {
        JsonObject r0 = this.params;
        if (r0 == null) goto L7;
        boolean r10 = true;
        if (r0.has("extras") != true) goto L7;
    L8:
        if (r10 == false) goto L20;
        JsonObject r1 = e.d(this);
        if (r1 == null) goto L14;
        JsonObject r11 = r1.getAsJsonObject("params");
        if (r11 == null) goto L14;
        r11.remove("extras");
    L14:
        if (r1 == null) goto L18;
        String r12 = r1.toString();
        if (r12 == null) goto L18;
        return r12;
    L18:
        return e.c(this);
    L20:
        return e.c(this);
    L7:
        r10 = false;
        goto L8
    }

    public final Integer c() {
        return this.callbackId;
    }

    public final String e() {
        return this.name;
    }

    public final JsonObject f() {
        return this.params;
    }

    public final TargetEntity g() {
        return this.target;
    }

    public final Type getType() {
        return this.type;
    }

    public final long h() {
        return this.timestamp;
    }

    public final <T> ProtocolMessage b(T r11) {
        JsonObject r10 = null;
        if (this.type == Type.Call) goto L6;
        return null;
    L6:
        if ((r11 instanceof JsonObject) == false) goto L9;
        r10 = (JsonObject) r11;
    L8:
        JsonObject r12 = r10;
        String r13 = null;
        return new ProtocolMessage(r13, r12, this.callbackId, this.target, Type.Callback, 33);
    L9:
        if (r11 == null) goto L8;
        r10 = e.d(r11);
        goto L8
    }

    public static ProtocolMessage a(ProtocolMessage r10, Integer r11) {
        String r1 = r10.name;
        JsonObject r12 = r10.params;
        TargetEntity r13 = r10.target;
        Type r14 = r10.type;
        long r15 = r10.timestamp;
        r10.getClass();
        return new ProtocolMessage(r1, r12, r11, r13, r14, r15);
    }

    public /* synthetic */ ProtocolMessage(String r11, JsonObject r12, Integer r13, TargetEntity r14, Type r15, int r16) {
        if ((r16 & 1) == 0) goto L5;
        String r10 = null;
    L7:
        if ((r16 & 2) == 0) goto L9;
        JsonObject r17 = null;
    L11:
        if ((r16 & 4) == 0) goto L13;
        Integer r18 = null;
    L15:
        if ((r16 & 8) == 0) goto L17;
        TargetEntity r19 = null;
    L19:
        if ((r16 & 16) == 0) goto L21;
        Type r20 = null;
    L23:
        if ((r16 & 32) == 0) goto L25;
        long r0 = System.currentTimeMillis();
    L26:
        this(r10, r17, r18, r19, r20, r0);
        return;
    L25:
        r0 = 0;
        goto L26
    L21:
        r20 = r15;
        goto L23
    L17:
        r19 = r14;
        goto L19
    L13:
        r18 = r13;
        goto L15
    L9:
        r17 = r12;
        goto L11
    L5:
        r10 = r11;
        goto L7
    }

    public ProtocolMessage(String r1, JsonObject r10, Integer r11, TargetEntity r12, Type r13, long r14) {
        this.name = r1;
        this.params = r10;
        this.callbackId = r11;
        this.target = r12;
        this.type = r13;
        this.timestamp = r14;
    }
}
