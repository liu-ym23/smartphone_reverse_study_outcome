package com.obric.capabilitykit.common;

import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.capabilitykit.entity.meta.MetaValue;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/obric/capabilitykit/entity/MetaValueSerializerTypeAdapter;", "Lcom/google/gson/JsonSerializer;", "Lcom/obric/capabilitykit/entity/meta/MetaValue;", "()V", "serialize", "Lcom/google/gson/JsonElement;", "src", "typeOfSrc", "Ljava/lang/reflect/Type;", "context", "Lcom/google/gson/JsonSerializationContext;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class i implements JsonSerializer<MetaValue> {
    public i() {
    }

    public JsonElement a(MetaValue r2, Type r3, JsonSerializationContext r4) {
        Type r1 = (Type) ZeusTransformUtils.wrapperContextForParams(r3, Type.class, "com.obric.memorydata.plugin");
        JsonSerializationContext r5 = (JsonSerializationContext) ZeusTransformUtils.wrapperContextForParams(r4, JsonSerializationContext.class, "com.obric.memorydata.plugin");
        JsonElement r6 = EntityExtKt.getInnerEntityGson().toJsonTree(r2);
        Intrinsics.checkNotNullExpressionValue(r6, "innerEntityGson.toJsonTree(src)");
        return r6;
    }

    @Override // com.google.gson.JsonSerializer
    public /* synthetic */ JsonElement serialize(MetaValue r3, Type r4, JsonSerializationContext r5) {
        Type r6 = (Type) ZeusTransformUtils.wrapperContextForParams(r4, Type.class, "com.obric.memorydata.plugin");
        JsonSerializationContext r7 = (JsonSerializationContext) ZeusTransformUtils.wrapperContextForParams(r5, JsonSerializationContext.class, "com.obric.memorydata.plugin");
        return a((MetaValue) ZeusTransformUtils.preCheckCast(r3, MetaValue.class, "com.obric.memorydata.plugin"), r6, r7);
    }
}
