package com.larus.platform.model.action;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.tencent.open.log.TraceLevel;
import iq9.d;
import java.lang.reflect.Type;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J$\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/larus/platform/model/action/SuggestedActionOperationDeserializer;", "Lcom/google/gson/JsonDeserializer;", "Lcom/larus/platform/model/action/SuggestedActionOperation;", "<init>", "()V", "deserialize", "json", "Lcom/google/gson/JsonElement;", "typeOfT", "Ljava/lang/reflect/Type;", "context", "Lcom/google/gson/JsonDeserializationContext;", "Companion", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class SuggestedActionOperationDeserializer implements JsonDeserializer<com.larus.platform.model.action.a> {
    public static final Lazy<Gson> a = null;

    public static final class a {
        public static final Gson a() {
            Lazy<Gson> r0 = SuggestedActionOperationDeserializer.a;
            return (Gson) SuggestedActionOperationDeserializer.a.getValue();
        }

        public a() {
        }
    }

    public SuggestedActionOperationDeserializer() {
    }

    static {
        new a();
        a = LazyKt.lazy(new d());
    }

    public final Object deserialize(JsonElement r2, Type r3, JsonDeserializationContext r4) {
        Intrinsics.checkNotNullParameter(r2, "json");
        JsonObject r5 = r2.getAsJsonObject();
        if (r5 == null) goto L7;
        JsonPrimitive r6 = r5.getAsJsonPrimitive("op_type");
        if (r6 == null) goto L7;
        Integer r7 = Integer.valueOf(r6.getAsInt());
    L8:
        if (r7 != null) goto L11;
    L13:
        if (r7 != null) goto L16;
    L18:
        if (r7 != null) goto L21;
    L23:
        if (r7 != null) goto L26;
    L28:
        if (r7 != null) goto L31;
    L33:
        if (r7 != null) goto L36;
    L38:
        if (r7 != null) goto L41;
    L43:
        Object r8 = GsonProtectorUtils.fromJson(a.a(), r5, com.larus.platform.model.action.a.class);
        Intrinsics.checkNotNull(r8);
        return (com.larus.platform.model.action.a) r8;
    L41:
        if (r7.intValue() != 60) goto L43;
        Object r9 = GsonProtectorUtils.fromJson(a.a(), r5, com.larus.platform.model.action.a.f.class);
        Intrinsics.checkNotNull(r9);
        return (com.larus.platform.model.action.a) r9;
    L36:
        if (r7.intValue() != 50) goto L38;
        Object r10 = GsonProtectorUtils.fromJson(a.a(), r5, com.larus.platform.model.action.a.e.class);
        Intrinsics.checkNotNull(r10);
        return (com.larus.platform.model.action.a) r10;
    L31:
        if (r7.intValue() != 41) goto L33;
        Object r11 = GsonProtectorUtils.fromJson(a.a(), r5, com.larus.platform.model.action.a.c.C0010a.class);
        Intrinsics.checkNotNull(r11);
        return (com.larus.platform.model.action.a) r11;
    L26:
        if (r7.intValue() != 40) goto L28;
        Object r12 = GsonProtectorUtils.fromJson(a.a(), r5, com.larus.platform.model.action.a.c.class);
        Intrinsics.checkNotNull(r12);
        return (com.larus.platform.model.action.a) r12;
    L21:
        if (r7.intValue() != 30) goto L23;
        Object r13 = GsonProtectorUtils.fromJson(a.a(), r5, com.larus.platform.model.action.a.d.class);
        Intrinsics.checkNotNull(r13);
        return (com.larus.platform.model.action.a) r13;
    L16:
        if (r7.intValue() != 20) goto L18;
        Object r14 = GsonProtectorUtils.fromJson(a.a(), r5, com.larus.platform.model.action.a.b.class);
        Intrinsics.checkNotNull(r14);
        return (com.larus.platform.model.action.a) r14;
    L11:
        if (r7.intValue() != 10) goto L13;
        Object r15 = GsonProtectorUtils.fromJson(a.a(), r5, com.larus.platform.model.action.a.C0009a.class);
        Intrinsics.checkNotNull(r15);
        return (com.larus.platform.model.action.a) r15;
    L7:
        r7 = null;
        goto L8
    }
}
