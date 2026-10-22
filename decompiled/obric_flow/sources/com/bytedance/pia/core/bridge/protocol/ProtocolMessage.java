package com.bytedance.pia.core.bridge.protocol;

import android.text.TextUtils;
import androidx.annotation.Keep;
import androidx.core.app.NotificationCompat;
import com.bytedance.pia.core.utils.i;
import com.bytedance.salamander.anniex.b0;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import l9.g;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u00002\u00020\u0001:\u0003 !\"R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\r\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\n\u001a\u0004\b\u001b\u0010\fR\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u0016\u001a\u0004\b\u001e\u0010\u0018¨\u0006#"}, d2 = {"Lcom/bytedance/pia/core/bridge/protocol/ProtocolMessage;", "", "Lcom/bytedance/pia/core/bridge/protocol/ProtocolMessage$Type;", "a", "Lcom/bytedance/pia/core/bridge/protocol/ProtocolMessage$Type;", "getType", "()Lcom/bytedance/pia/core/bridge/protocol/ProtocolMessage$Type;", "type", "", "b", "Ljava/lang/Integer;", "getId", "()Ljava/lang/Integer;", "id", "Lcom/google/gson/JsonObject;", "c", "Lcom/google/gson/JsonObject;", "getData", "()Lcom/google/gson/JsonObject;", "data", "", "d", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "name", "e", "getStatus", NotificationCompat.CATEGORY_STATUS, "f", "getMessage", "message", "l9/g", "com/bytedance/salamander/anniex/b0", "Type", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class ProtocolMessage {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("type")
    private final Type f7032a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("id")
    private final Integer f7033b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName("data")
    private final JsonObject f7034c;

    @SerializedName("name")
    private final String d;

    @SerializedName(NotificationCompat.CATEGORY_STATUS)
    private final Integer e;

    @SerializedName("err_msg")
    private final String f;

    @Keep
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/pia/core/bridge/protocol/ProtocolMessage$Type;", "", "(Ljava/lang/String;I)V", "Invocation", "Callback", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    public static final enum Type extends Enum<Type> {
        private static final /* synthetic */ Type[] $VALUES = null;

        @SerializedName("callback")
        public static final Type Callback = null;

        @SerializedName("invocation")
        public static final Type Invocation = null;

        private static final /* synthetic */ Type[] $values() {
            return new Type[]{Invocation, Callback};
        }

        static {
            Invocation = new Type("Invocation", 0);
            Callback = new Type("Callback", 1);
            $VALUES = $values();
        }

        private Type(String r5, int r10) {
            super(r5, r10);
        }

        public static Type valueOf(String r5) {
            return (Type) Enum.valueOf(Type.class, r5);
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }
    }

    public ProtocolMessage(Type r5, Integer r10, JsonObject r11, String r12, Integer r13, String r14) {
        this.f7032a = r5;
        this.f7033b = r10;
        this.f7034c = r11;
        this.d = r12;
        this.e = r13;
        this.f = r14;
    }

    public static final JsonObject a(b0 r10) {
        Object r5 = null;
        if (TextUtils.isEmpty((String) r10.f7247c) == false) goto L5;
        return null;
    L5:
        ProtocolMessage r11 = new ProtocolMessage(Type.Invocation, Integer.valueOf(r10.f7246b), (JsonObject) r10.d, (String) r10.f7247c, null, null);
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L8
        JsonElement r13 = i.a().toJsonTree(r11);     // Catch: Throwable -> L8
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type com.google.gson.JsonObject");     // Catch: Throwable -> L8
        Object r14 = Result.m124constructorimpl((JsonObject) r13);     // Catch: Throwable -> L8
    L11:
        if (Result.m130isFailureimpl(r14) == true) goto L15;
        r5 = r14;
    L15:
        return (JsonObject) r5;
    L8:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r14 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    public static final JsonObject b(g r10) {
        int r5 = r10.f19561b;
        Object r11 = null;
        if (r5 != 0) goto L5;
        return null;
    L5:
        Type r12 = Type.Callback;
        Integer r13 = Integer.valueOf(r5);
        Integer r14 = Integer.valueOf(r10.f19562c);
        ProtocolMessage r15 = new ProtocolMessage(r12, r13, (JsonObject) r10.d, null, r14, (String) r10.e);
        Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L8
        JsonElement r17 = i.a().toJsonTree(r15);     // Catch: Throwable -> L8
        Intrinsics.checkNotNull(r17, "null cannot be cast to non-null type com.google.gson.JsonObject");     // Catch: Throwable -> L8
        Object r18 = Result.m124constructorimpl((JsonObject) r17);     // Catch: Throwable -> L8
    L11:
        if (Result.m130isFailureimpl(r18) == true) goto L15;
        r11 = r18;
    L15:
        return (JsonObject) r11;
    L8:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        r18 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    public final g c() {
        if (Type.Callback == this.f7032a) goto L5;
        return null;
    L5:
        Integer r5 = this.f7033b;
        if (r5 != null) goto L8;
    L15:
        return null;
    L8:
        if (r5.intValue() == 0) goto L15;
        if (this.e != null) goto L14;
        return null;
    L14:
        return new g(this.f7033b.intValue(), this.e.intValue(), this.f7034c, this.f);
    }

    public final b0 d() {
        if (Type.Invocation == this.f7032a) goto L6;
        return null;
    L6:
        if (TextUtils.isEmpty(this.d) == false) goto L8;
        return null;
    L8:
        Integer r5 = this.f7033b;
        if (r5 != null) goto L11;
        return null;
    L11:
        int r10 = r5.intValue();
        String r11 = this.d;
        Intrinsics.checkNotNull(r11);
        return new b0(r10, r11, this.f7034c);
    }
}
