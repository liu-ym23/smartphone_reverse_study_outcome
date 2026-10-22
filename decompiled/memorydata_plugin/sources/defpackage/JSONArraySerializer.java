package defpackage;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J&\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¨\u0006\f"}, d2 = {"LJSONArraySerializer;", "Lcom/google/gson/JsonSerializer;", "Lorg/json/JSONArray;", "<init>", "()V", "serialize", "Lcom/google/gson/JsonElement;", "src", "typeOfSrc", "Ljava/lang/reflect/Type;", "context", "Lcom/google/gson/JsonSerializationContext;", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class JSONArraySerializer implements JsonSerializer<JSONArray> {
    public JSONArraySerializer() {
    }

    public JsonElement a(JSONArray r8, Type r9, JsonSerializationContext r10) {
        Type r11 = (Type) ZeusTransformUtils.wrapperContextForParams(r9, Type.class, "com.obric.memorydata.plugin");
        JsonSerializationContext r12 = (JsonSerializationContext) ZeusTransformUtils.wrapperContextForParams(r10, JsonSerializationContext.class, "com.obric.memorydata.plugin");
        JsonArray r0 = new JsonArray();
        if (r8 == null) goto L29;
        int r2 = 0;
        int r3 = r8.length();
    L5:
        if (r2 >= r3) goto L29;
        Object r4 = r8.get(r2);
        if (ZeusTransformUtils.instanceOf(r4, JSONObject.class) == false) goto L11;
        JsonElement r5 = new JSONObjectSerializer().a((JSONObject) ZeusTransformUtils.preCheckCast(r4, JSONObject.class, "com.obric.memorydata.plugin"), r11, r12);
    L9:
        r0.add(r5);
    L27:
        r2 = r2 + 1;
        goto L5
    L11:
        if (ZeusTransformUtils.instanceOf(r4, JSONArray.class) == false) goto L14;
        r5 = a((JSONArray) ZeusTransformUtils.preCheckCast(r4, JSONArray.class, "com.obric.memorydata.plugin"), r11, r12);
        goto L9
    L14:
        if (ZeusTransformUtils.instanceOf(r4, Boolean.class) == false) goto L17;
        r0.add((Boolean) ZeusTransformUtils.preCheckCast(r4, Boolean.class, "com.obric.memorydata.plugin"));
        goto L27
    L17:
        if (ZeusTransformUtils.instanceOf(r4, Number.class) == false) goto L20;
        r0.add((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.memorydata.plugin"));
        goto L27
    L20:
        if (ZeusTransformUtils.instanceOf(r4, String.class) == false) goto L24;
        String r6 = (String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.memorydata.plugin");
    L22:
        r0.add(r6);
        goto L27
    L24:
        if (Intrinsics.areEqual(r4, JSONObject.NULL) == false) goto L26;
        r6 = null;
        goto L22
    L26:
        r6 = r4.toString();
    L29:
        return (JsonElement) ZeusTransformUtils.preCheckCast(r0, JsonElement.class, "com.obric.memorydata.plugin");
    }

    @Override // com.google.gson.JsonSerializer
    public /* synthetic */ JsonElement serialize(JSONArray r3, Type r4, JsonSerializationContext r5) {
        Type r6 = (Type) ZeusTransformUtils.wrapperContextForParams(r4, Type.class, "com.obric.memorydata.plugin");
        JsonSerializationContext r7 = (JsonSerializationContext) ZeusTransformUtils.wrapperContextForParams(r5, JsonSerializationContext.class, "com.obric.memorydata.plugin");
        return a((JSONArray) ZeusTransformUtils.preCheckCast(r3, JSONArray.class, "com.obric.memorydata.plugin"), r6, r7);
    }
}
