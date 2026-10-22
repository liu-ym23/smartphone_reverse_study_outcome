package com.obric.capabilitykit.common;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.capabilitykit.entity.meta.MetaType;
import com.obric.capabilitykit.entity.meta.MetaValue;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/obric/capabilitykit/entity/MetaValueDeserializerTypeAdapter;", "Lcom/google/gson/JsonDeserializer;", "Lcom/obric/capabilitykit/entity/meta/MetaValue;", "()V", "deserialize", "json", "Lcom/google/gson/JsonElement;", "typeOfT", "Ljava/lang/reflect/Type;", "context", "Lcom/google/gson/JsonDeserializationContext;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class h implements JsonDeserializer<MetaValue> {
    public h() {
    }

    public MetaValue a(JsonElement r2, Type r3, JsonDeserializationContext r4) {
        Type r1 = (Type) ZeusTransformUtils.wrapperContextForParams(r3, Type.class, "com.obric.memorydata.plugin");
        JsonDeserializationContext r5 = (JsonDeserializationContext) ZeusTransformUtils.wrapperContextForParams(r4, JsonDeserializationContext.class, "com.obric.memorydata.plugin");
        Integer r6 = null;
        if (r2 == null) goto L5;
        JsonObject r7 = r2.getAsJsonObject();
    L6:
        if (r7 == null) goto L10;
        JsonElement r8 = r7.get("type");
        if (r8 == null) goto L10;
        r6 = Integer.valueOf(r8.getAsInt());
    L10:
        Class r9 = (Class) ZeusTransformUtils.preCheckCast(MetaType.INSTANCE.getClassMap().get(r6), Class.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L15;
        Object r10 = EntityExtKt.getInnerEntityGson().fromJson(r2, r9);
        Intrinsics.checkNotNullExpressionValue(r10, "innerEntityGson.fromJson(json, targetClass)");
        return (MetaValue) ZeusTransformUtils.preCheckCast(r10, MetaValue.class, "com.obric.memorydata.plugin");
    L15:
        throw new IllegalArgumentException("Unknown meta type: " + r6);
    L5:
        r7 = null;
        goto L6
    }

    @Override // com.google.gson.JsonDeserializer
    public /* synthetic */ MetaValue deserialize(JsonElement r3, Type r4, JsonDeserializationContext r5) {
        return a(r3, (Type) ZeusTransformUtils.wrapperContextForParams(r4, Type.class, "com.obric.memorydata.plugin"), (JsonDeserializationContext) ZeusTransformUtils.wrapperContextForParams(r5, JsonDeserializationContext.class, "com.obric.memorydata.plugin"));
    }
}
