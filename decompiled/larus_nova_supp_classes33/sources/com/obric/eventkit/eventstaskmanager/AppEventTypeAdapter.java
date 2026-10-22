package com.obric.eventkit.eventstaskmanager;

import android.net.Uri;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.lang.reflect.Type;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J&\u0010\u0007\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016R\u0016\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/obric/eventkit/eventstaskmanager/AppEventTypeAdapter;", "Lcom/google/gson/JsonDeserializer;", "Lcom/obric/eventkit/eventstaskmanager/AppEvent;", "()V", "mInnerJsonParser", "Lcom/google/gson/Gson;", "kotlin.jvm.PlatformType", "deserialize", "json", "Lcom/google/gson/JsonElement;", "typeOfT", "Ljava/lang/reflect/Type;", "context", "Lcom/google/gson/JsonDeserializationContext;", "eventstaskkit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AppEventTypeAdapter implements JsonDeserializer<AppEvent> {
    private final Gson mInnerJsonParser;

    public AppEventTypeAdapter() {
        this.mInnerJsonParser = new GsonBuilder().registerTypeAdapter(Uri.class, new UriTypeAdapter()).create();
    }

    public AppEvent deserialize(JsonElement r4, Type r5, JsonDeserializationContext r6) {
        Object r7 = null;
        if (r4 == null) goto L5;
        JsonObject r8 = r4.getAsJsonObject();
    L6:
        if (r8 == null) goto L10;
        JsonElement r9 = r8.get("type");
        if (r9 == null) goto L10;
        String r10 = r9.getAsString();
    L11:
        Iterator r0 = EventTypeKt.a().iterator();
    L13:
        if (r0.hasNext() == false) goto L17;
        Object r1 = r0.next();
        if (Intrinsics.areEqual(((Triple) r1).getFirst(), r10) == false) goto L13;
        r7 = r1;
    L17:
        Triple r11 = (Triple) r7;
        if (r11 == null) goto L24;
        Class r12 = (Class) r11.getSecond();
        if (r12 == null) goto L24;
        return (AppEvent) GsonProtectorUtils.fromJson(this.mInnerJsonParser, r4, r12);
    L24:
        throw new IllegalArgumentException("Unknown entity type: " + r10);
    L10:
        r10 = null;
        goto L11
    L5:
        r8 = null;
        goto L6
    }

    /* JADX INFO: renamed from: deserialize, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m46deserialize(JsonElement r1, Type r2, JsonDeserializationContext r3) {
        return deserialize(r1, r2, r3);
    }
}
