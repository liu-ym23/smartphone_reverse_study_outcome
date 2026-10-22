package com.obric.memorydata.sdk.screencapture.rule;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import com.obric.memorydata.sdk.screencapture.event.ScreenEvent;
import java.lang.reflect.Type;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\"\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/sdk/screencapture/rule/ScreenEventRuleDeserializerTypeAdapter;", "Lcom/google/gson/JsonDeserializer;", "Lcom/obric/memorydata/sdk/screencapture/rule/ScreenEventRule;", "<init>", "()V", "deserialize", "json", "Lcom/google/gson/JsonElement;", "typeOfT", "Ljava/lang/reflect/Type;", "context", "Lcom/google/gson/JsonDeserializationContext;", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class ScreenEventRuleDeserializerTypeAdapter implements JsonDeserializer<ScreenEventRule> {
    public ScreenEventRuleDeserializerTypeAdapter() {
    }

    public final Object deserialize(JsonElement r2, Type r3, JsonDeserializationContext r4) {
        Intrinsics.checkNotNullParameter(r2, "json");
        Intrinsics.checkNotNullParameter(r3, "typeOfT");
        Map<ScreenEvent.EventType, Class<? extends ScreenEventRule>> r5 = ScreenEventRule.a;
        String r6 = r2.toString();
        Intrinsics.checkNotNullParameter(r6, "json");
        String r7 = new JSONObject(r6).optString("eventType");
        Intrinsics.checkNotNull(r7);
        if (r7.length() != 0) goto L5;
        boolean r8 = true;
    L6:
        if (r8 == true) goto L10;
        ScreenEvent.EventType r9 = ScreenEvent.EventType.valueOf(r7);
        Class<? extends ScreenEventRule> r10 = ScreenEventRule.a.get(r9);
        if (r10 == null) goto L10;
        ScreenEventRule r11 = (ScreenEventRule) GsonProtectorUtils.fromJson(new Gson(), r6, r10);
    L12:
        if (r11 == null) goto L15;
        return r11;
    L15:
        throw new IllegalArgumentException("invalid json for ScreenEventRule");
    L10:
        r11 = null;
        goto L12
    L5:
        r8 = false;
        goto L6
    }
}
