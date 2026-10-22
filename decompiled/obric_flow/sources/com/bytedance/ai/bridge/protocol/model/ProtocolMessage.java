package com.bytedance.ai.bridge.protocol.model;

import androidx.annotation.Keep;
import androidx.core.app.NotificationCompat;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.lynx.jsbridge.LynxResourceModule;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001:\u0003#$\u0003R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\r\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u00198\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\"\u001a\u00020\u001e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u001f\u001a\u0004\b \u0010!¨\u0006%"}, d2 = {"Lcom/bytedance/ai/bridge/protocol/model/ProtocolMessage;", "", "", "a", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "name", "Lcom/google/gson/JsonObject;", "b", "Lcom/google/gson/JsonObject;", "f", "()Lcom/google/gson/JsonObject;", LynxResourceModule.PARAMS_KEY, "", "c", "Ljava/lang/Integer;", "()Ljava/lang/Integer;", "callbackId", "Lcom/bytedance/ai/bridge/protocol/model/TargetEntity;", "d", "Lcom/bytedance/ai/bridge/protocol/model/TargetEntity;", "g", "()Lcom/bytedance/ai/bridge/protocol/model/TargetEntity;", "target", "Lcom/bytedance/ai/bridge/protocol/model/ProtocolMessage$Type;", "Lcom/bytedance/ai/bridge/protocol/model/ProtocolMessage$Type;", "i", "()Lcom/bytedance/ai/bridge/protocol/model/ProtocolMessage$Type;", "type", "", "J", "h", "()J", "timestamp", "com/lynx/tasm/utils/b", "Type", "applet-bridge_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ProtocolMessage {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("name")
    private final String f2024a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName(LynxResourceModule.PARAMS_KEY)
    private final JsonObject f2025b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName("callbackId")
    private final Integer f2026c;

    @SerializedName("target")
    private final TargetEntity d;

    @SerializedName("type")
    private final Type e;

    @SerializedName("timestamp")
    private final long f;

    @Keep
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ai/bridge/protocol/model/ProtocolMessage$Type;", "", "<init>", "(Ljava/lang/String;I)V", "Call", "Callback", "Event", "applet-bridge_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final enum Type extends Enum<Type> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ Type[] $VALUES = null;

        @SerializedName(NotificationCompat.CATEGORY_CALL)
        public static final Type Call = null;

        @SerializedName("callback")
        public static final Type Callback = null;

        @SerializedName("event")
        public static final Type Event = null;

        private static final /* synthetic */ Type[] $values() {
            return new Type[]{Call, Callback, Event};
        }

        static {
            Call = new Type("Call", 0);
            Callback = new Type("Callback", 1);
            Event = new Type("Event", 2);
            Type[] r5 = $values();
            $VALUES = r5;
            $ENTRIES = EnumEntriesKt.enumEntries(r5);
        }

        private Type(String r5, int r10) {
            super(r5, r10);
        }

        public static EnumEntries<Type> getEntries() {
            return $ENTRIES;
        }

        public static Type valueOf(String r5) {
            return (Type) Enum.valueOf(Type.class, r5);
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\b\u0010\nR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ai/bridge/protocol/model/ProtocolMessage$a;", "", "", "a", "Ljava/lang/Integer;", "()Ljava/lang/Integer;", "code", "", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "msg", "Lcom/google/gson/JsonObject;", "c", "Lcom/google/gson/JsonObject;", "getData", "()Lcom/google/gson/JsonObject;", "data", "applet-bridge_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName("code")
        private final Integer f2027a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @SerializedName("msg")
        private final String f2028b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @SerializedName("data")
        private final JsonObject f2029c;

        public a() {
            this.f2027a = 0;
            this.f2028b = "";
            this.f2029c = null;
        }

        public final Integer a() {
            return this.f2027a;
        }

        public final String b() {
            return this.f2028b;
        }
    }

    public ProtocolMessage() {
        String r5 = null;
        JsonObject r10 = null;
        Integer r11 = null;
        TargetEntity r12 = null;
        this(r5, r10, r11, r12, null, 63);
    }

    public static ProtocolMessage a(ProtocolMessage r10, Integer r11) {
        return new ProtocolMessage(r10.f2024a, r10.f2025b, r11, r10.d, r10.e, r10.f);
    }

    public final ProtocolMessage b(Object r11) {
        JsonObject r5 = null;
        if (this.e == Type.Call) goto L6;
        return null;
    L6:
        if ((r11 instanceof JsonObject) == false) goto L9;
        r5 = (JsonObject) r11;
    L8:
        JsonObject r10 = r5;
        String r12 = null;
        return new ProtocolMessage(r12, r10, this.f2026c, this.d, Type.Callback, 33);
    L9:
        if (r11 == null) goto L8;
        Intrinsics.checkNotNullParameter(r11, "value");
        r5 = z0.a.a().toJsonTree(r11).getAsJsonObject();
        goto L8
    }

    public final Integer c() {
        return this.f2026c;
    }

    public final a d() {
        Object r5 = null;
        if (this.e != Type.Callback) goto L18;
        JsonObject r10 = this.f2025b;
        if (r10 == null) goto L19;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L8
        Object r12 = Result.m124constructorimpl((a) z0.a.a().fromJson(r10, a.class));     // Catch: Throwable -> L8
    L11:
        if (Result.m130isFailureimpl(r12) == true) goto L15;
        r5 = r12;
    L15:
        return (a) r5;
    L8:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r12 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L11
    L19:
        return null;
    L18:
        return null;
    }

    public final String e() {
        return this.f2024a;
    }

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof ProtocolMessage) == true) goto L8;
        return false;
    L8:
        ProtocolMessage r11 = (ProtocolMessage) r10;
        if (Intrinsics.areEqual(this.f2024a, r11.f2024a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f2025b, r11.f2025b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f2026c, r11.f2026c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r11.d) == true) goto L21;
        return false;
    L21:
        if (this.e == r11.e) goto L24;
        return false;
    L24:
        if (this.f == r11.f) goto L26;
        return false;
    L26:
        return true;
    }

    public final JsonObject f() {
        return this.f2025b;
    }

    public final TargetEntity g() {
        return this.d;
    }

    public final long h() {
        return this.f;
    }

    public final int hashCode() {
        String r5 = this.f2024a;
        int r10 = 0;
        if (r5 != null) goto L5;
        int r11 = 0;
    L6:
        int r12 = r11 * 31;
        JsonObject r13 = this.f2025b;
        if (r13 != null) goto L9;
        int r14 = 0;
    L10:
        int r15 = (r12 + r14) * 31;
        Integer r16 = this.f2026c;
        if (r16 != null) goto L13;
        int r17 = 0;
    L14:
        int r18 = (r15 + r17) * 31;
        TargetEntity r19 = this.d;
        if (r19 != null) goto L17;
        int r20 = 0;
    L18:
        int r21 = (r18 + r20) * 31;
        Type r22 = this.e;
        if (r22 == null) goto L23;
        r10 = r22.hashCode();
    L23:
        return Long.hashCode(this.f) + ((r21 + r10) * 31);
    L17:
        r20 = r19.hashCode();
        goto L18
    L13:
        r17 = r16.hashCode();
        goto L14
    L9:
        r14 = r13.hashCode();
        goto L10
    L5:
        r11 = r5.hashCode();
        goto L6
    }

    public final Type i() {
        return this.e;
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("ProtocolMessage(name=");
        r5.append(this.f2024a);
        r5.append(", params=");
        r5.append(this.f2025b);
        r5.append(", callbackId=");
        r5.append(this.f2026c);
        r5.append(", target=");
        r5.append(this.d);
        r5.append(", type=");
        r5.append(this.e);
        r5.append(", timestamp=");
        return androidx.room.jarjarred.org.antlr.runtime.a.t(r5, this.f, ')');
    }

    public ProtocolMessage(String r5, JsonObject r10, Integer r11, TargetEntity r12, Type r13, long r14) {
        this.f2024a = r5;
        this.f2025b = r10;
        this.f2026c = r11;
        this.d = r12;
        this.e = r13;
        this.f = r14;
    }

    public /* synthetic */ ProtocolMessage(String r11, JsonObject r12, Integer r13, TargetEntity r14, Type r15, int r16) {
        if ((r16 & 1) == 0) goto L5;
        String r5 = null;
    L7:
        if ((r16 & 2) == 0) goto L9;
        JsonObject r10 = null;
    L11:
        if ((r16 & 4) == 0) goto L13;
        Integer r17 = null;
    L15:
        if ((r16 & 8) == 0) goto L17;
        TargetEntity r18 = null;
    L19:
        if ((r16 & 16) == 0) goto L21;
        Type r19 = null;
    L22:
        this(r5, r10, r17, r18, r19, System.currentTimeMillis());
        return;
    L21:
        r19 = r15;
        goto L22
    L17:
        r18 = r14;
        goto L19
    L13:
        r17 = r13;
        goto L15
    L9:
        r10 = r12;
        goto L11
    L5:
        r5 = r11;
        goto L7
    }
}
