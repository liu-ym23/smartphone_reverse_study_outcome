package com.obric.eventkit.eventstaskmanager;

import android.net.Uri;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Type;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J&\u0010\u0007\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016R\u0016\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/obric/eventkit/eventstaskmanager/AppEventTypeAdapter;", "Lcom/google/gson/JsonDeserializer;", "Lcom/obric/eventkit/eventstaskmanager/AppEvent;", "()V", "mInnerJsonParser", "Lcom/google/gson/Gson;", "kotlin.jvm.PlatformType", "deserialize", "json", "Lcom/google/gson/JsonElement;", "typeOfT", "Ljava/lang/reflect/Type;", "context", "Lcom/google/gson/JsonDeserializationContext;", "eventstaskkit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AppEventTypeAdapter implements JsonDeserializer<AppEvent> {
    private final Gson mInnerJsonParser;

    public AppEventTypeAdapter() {
        this.mInnerJsonParser = new GsonBuilder().registerTypeAdapter(Uri.class, new UriTypeAdapter()).create();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.JsonDeserializer
    public AppEvent deserialize(JsonElement r5, Type r6, JsonDeserializationContext r7) {
        Type r8 = (Type) ZeusTransformUtils.wrapperContextForParams(r6, Type.class, "com.obric.memorydata.plugin");
        JsonDeserializationContext r9 = (JsonDeserializationContext) ZeusTransformUtils.wrapperContextForParams(r7, JsonDeserializationContext.class, "com.obric.memorydata.plugin");
        Object r10 = null;
        if (r5 == null) goto L5;
        JsonObject r11 = r5.getAsJsonObject();
    L6:
        if (r11 == null) goto L10;
        JsonElement r12 = r11.get("type");
        if (r12 == null) goto L10;
        String r13 = r12.getAsString();
    L11:
        Iterator<T> r0 = EventTypeKt.a().iterator();
    L13:
        if (r0.hasNext() == false) goto L17;
        Object r2 = r0.next();
        if (Intrinsics.areEqual(((Triple) ZeusTransformUtils.preCheckCast(r2, Triple.class, "com.obric.memorydata.plugin")).getFirst(), r13) == false) goto L13;
        r10 = r2;
    L17:
        Triple r14 = (Triple) ZeusTransformUtils.preCheckCast(r10, Triple.class, "com.obric.memorydata.plugin");
        if (r14 == null) goto L24;
        Class r15 = (Class) ZeusTransformUtils.preCheckCast(r14.getSecond(), Class.class, "com.obric.memorydata.plugin");
        if (r15 == null) goto L24;
        Object r4 = this.mInnerJsonParser.fromJson(r5, r15);
        Intrinsics.checkNotNullExpressionValue(r4, "mInnerJsonParser.fromJson(json, targetClass)");
        return (AppEvent) ZeusTransformUtils.preCheckCast(r4, AppEvent.class, "com.obric.memorydata.plugin");
    L24:
        throw new IllegalArgumentException("Unknown entity type: " + r13);
    L10:
        r13 = null;
        goto L11
    L5:
        r11 = null;
        goto L6
    }

    @Override // com.google.gson.JsonDeserializer
    public /* synthetic */ AppEvent deserialize(JsonElement r3, Type r4, JsonDeserializationContext r5) {
        return deserialize(r3, (Type) ZeusTransformUtils.wrapperContextForParams(r4, Type.class, "com.obric.memorydata.plugin"), (JsonDeserializationContext) ZeusTransformUtils.wrapperContextForParams(r5, JsonDeserializationContext.class, "com.obric.memorydata.plugin"));
    }
}
