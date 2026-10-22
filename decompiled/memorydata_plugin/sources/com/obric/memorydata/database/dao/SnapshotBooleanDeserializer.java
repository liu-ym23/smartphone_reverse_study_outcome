package com.obric.memorydata.database.dao;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Type;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J+\u0010\u0005\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Lcom/obric/memorydata/database/dao/SnapshotBooleanDeserializer;", "Lcom/google/gson/JsonDeserializer;", "", "<init>", "()V", "deserialize", "json", "Lcom/google/gson/JsonElement;", "typeOfT", "Ljava/lang/reflect/Type;", "context", "Lcom/google/gson/JsonDeserializationContext;", "(Lcom/google/gson/JsonElement;Ljava/lang/reflect/Type;Lcom/google/gson/JsonDeserializationContext;)Ljava/lang/Boolean;", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class SnapshotBooleanDeserializer implements JsonDeserializer<Boolean> {
    public static final SnapshotBooleanDeserializer INSTANCE = null;

    static {
        INSTANCE = new SnapshotBooleanDeserializer();
    }

    private SnapshotBooleanDeserializer() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.JsonDeserializer
    public Boolean deserialize(JsonElement r2, Type r3, JsonDeserializationContext r4) {
        Type r1 = (Type) ZeusTransformUtils.wrapperContextForParams(r3, Type.class, "com.obric.memorydata.plugin");
        JsonDeserializationContext r5 = (JsonDeserializationContext) ZeusTransformUtils.wrapperContextForParams(r4, JsonDeserializationContext.class, "com.obric.memorydata.plugin");
        boolean r6 = false;
        if (r2 == null) goto L46;
        if (r2.isJsonPrimitive() == true) goto L8;
        r2 = null;
    L8:
        if (r2 == null) goto L46;
        JsonPrimitive r7 = r2.getAsJsonPrimitive();
        if (r7 == null) goto L46;
        if (r7.isBoolean() == false) goto L16;
        r6 = r7.getAsBoolean();
    L44:
        return Boolean.valueOf(r6);
    L16:
        if (r7.isNumber() == false) goto L21;
        if (r7.getAsInt() == 0) goto L44;
    L19:
        r6 = true;
        goto L44
    L21:
        if (r7.isString() == false) goto L44;
        String r8 = r7.getAsString();
        Intrinsics.checkNotNullExpressionValue(r8, "getAsString(...)");
        String r9 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin")).toString().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(r9, "toLowerCase(...)");
        int r10 = r9.hashCode();
        if (r10 != 0) goto L25;
        String r11 = "";
    L37:
        r9.equals(r11);
        goto L44
    L25:
        if (r10 == 3569038) goto L40;
        if (r10 != 97196323) goto L29;
        r11 = "false";
        goto L37
    L29:
        if (r10 != 48) goto L31;
        r11 = "0";
        goto L37
    L31:
        if (r10 != 49) goto L44;
        if (r9.equals("1") == true) goto L19;
    L40:
        if (r9.equals("true") == true) goto L19;
    L46:
        return false;
    }

    @Override // com.google.gson.JsonDeserializer
    public /* synthetic */ Boolean deserialize(JsonElement r3, Type r4, JsonDeserializationContext r5) {
        return deserialize(r3, (Type) ZeusTransformUtils.wrapperContextForParams(r4, Type.class, "com.obric.memorydata.plugin"), (JsonDeserializationContext) ZeusTransformUtils.wrapperContextForParams(r5, JsonDeserializationContext.class, "com.obric.memorydata.plugin"));
    }
}
