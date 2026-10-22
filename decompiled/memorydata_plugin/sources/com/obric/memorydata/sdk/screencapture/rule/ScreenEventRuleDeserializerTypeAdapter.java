package com.obric.memorydata.sdk.screencapture.rule;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\"\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/sdk/screencapture/rule/ScreenEventRuleDeserializerTypeAdapter;", "Lcom/google/gson/JsonDeserializer;", "Lcom/obric/memorydata/sdk/screencapture/rule/ScreenEventRule;", "<init>", "()V", "deserialize", "json", "Lcom/google/gson/JsonElement;", "typeOfT", "Ljava/lang/reflect/Type;", "context", "Lcom/google/gson/JsonDeserializationContext;", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ScreenEventRuleDeserializerTypeAdapter implements JsonDeserializer<ScreenEventRule> {
    public ScreenEventRuleDeserializerTypeAdapter() {
    }

    public ScreenEventRule a(JsonElement r2, Type r3, JsonDeserializationContext r4) {
        Type r1 = (Type) ZeusTransformUtils.wrapperContextForParams(r3, Type.class, "com.obric.memorydata.plugin");
        JsonDeserializationContext r5 = (JsonDeserializationContext) ZeusTransformUtils.wrapperContextForParams(r4, JsonDeserializationContext.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "json");
        Intrinsics.checkNotNullParameter(r1, "typeOfT");
        ScreenEventRule.a r6 = ScreenEventRule.Companion;
        String r7 = r2.toString();
        Intrinsics.checkNotNullExpressionValue(r7, "toString(...)");
        ScreenEventRule r8 = r6.a(r7);
        if (r8 == null) goto L6;
        return r8;
    L6:
        throw new IllegalArgumentException("invalid json for ScreenEventRule");
    }

    @Override // com.google.gson.JsonDeserializer
    public /* synthetic */ ScreenEventRule deserialize(JsonElement r3, Type r4, JsonDeserializationContext r5) {
        return a(r3, (Type) ZeusTransformUtils.wrapperContextForParams(r4, Type.class, "com.obric.memorydata.plugin"), (JsonDeserializationContext) ZeusTransformUtils.wrapperContextForParams(r5, JsonDeserializationContext.class, "com.obric.memorydata.plugin"));
    }
}
