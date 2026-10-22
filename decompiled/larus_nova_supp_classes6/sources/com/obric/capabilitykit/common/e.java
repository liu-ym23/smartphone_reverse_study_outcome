package com.obric.capabilitykit.common;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.EntityClassData;
import com.obric.capabilitykit.entity.app.EntityType;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import java.lang.reflect.Type;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/obric/capabilitykit/entity/AppEntityDeserializerTypeAdapter;", "Lcom/google/gson/JsonDeserializer;", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "()V", "deserialize", "json", "Lcom/google/gson/JsonElement;", "typeOfT", "Ljava/lang/reflect/Type;", "context", "Lcom/google/gson/JsonDeserializationContext;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class e implements JsonDeserializer<AppEntity> {
    public e() {
    }

    public final Object deserialize(JsonElement r2, Type r3, JsonDeserializationContext r4) {
        Integer r5 = null;
        if (r2 == null) goto L5;
        JsonObject r6 = r2.getAsJsonObject();
    L6:
        if (r6 == null) goto L10;
        JsonElement r7 = r6.get("type");
        if (r7 == null) goto L10;
        r5 = Integer.valueOf(r7.getAsInt());
    L10:
        EntityClassData<? extends AppEntity> r8 = EntityType.INSTANCE.getClassMap().get(r5);
        if (r8 == null) goto L17;
        Class<T> r9 = r8.getClazz();
        if (r9 == 0) goto L17;
        return (AppEntity) GsonProtectorUtils.fromJson(EntityExtKt.a, r2, r9);
    L17:
        throw new IllegalArgumentException("Unknown entity type: " + r5);
    L5:
        r6 = null;
        goto L6
    }
}
