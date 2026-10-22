package defpackage;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Type;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J&\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¨\u0006\f"}, d2 = {"LJSONObjectSerializer;", "Lcom/google/gson/JsonSerializer;", "Lorg/json/JSONObject;", "<init>", "()V", "serialize", "Lcom/google/gson/JsonElement;", "src", "typeOfSrc", "Ljava/lang/reflect/Type;", "context", "Lcom/google/gson/JsonSerializationContext;", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class JSONObjectSerializer implements JsonSerializer<JSONObject> {
    public JSONObjectSerializer() {
    }

    public JsonElement a(JSONObject r8, Type r9, JsonSerializationContext r10) {
        Type r11 = (Type) ZeusTransformUtils.wrapperContextForParams(r9, Type.class, "com.obric.memorydata.plugin");
        JsonSerializationContext r12 = (JsonSerializationContext) ZeusTransformUtils.wrapperContextForParams(r10, JsonSerializationContext.class, "com.obric.memorydata.plugin");
        JsonObject r0 = new JsonObject();
        if (r8 == null) goto L30;
        Iterator<String> r2 = r8.keys();
        if (r2 == null) goto L30;
    L7:
        if (r2.hasNext() == false) goto L30;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r2.next(), String.class, "com.obric.memorydata.plugin");
        Object r4 = r8.get(r3);
        if (ZeusTransformUtils.instanceOf(r4, JSONObject.class) == true) goto L10;
        if (ZeusTransformUtils.instanceOf(r4, JSONArray.class) == true) goto L14;
        if (ZeusTransformUtils.instanceOf(r4, Boolean.class) == false) goto L19;
        r0.addProperty(r3, (Boolean) ZeusTransformUtils.preCheckCast(r4, Boolean.class, "com.obric.memorydata.plugin"));
        goto L7
    L19:
        if (ZeusTransformUtils.instanceOf(r4, Number.class) == false) goto L22;
        r0.addProperty(r3, (Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.memorydata.plugin"));
        goto L7
    L22:
        if (ZeusTransformUtils.instanceOf(r4, String.class) == true) goto L23;
        if (Intrinsics.areEqual(r4, JSONObject.NULL) == true) goto L27;
        String r5 = r4.toString();
    L24:
        r0.addProperty(r3, r5);
        goto L7
    L27:
        JsonElement r6 = null;
    L11:
        r0.add(r3, r6);
        goto L7
    L23:
        r5 = (String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.memorydata.plugin");
        goto L24
    L14:
        r6 = new JSONArraySerializer().a((JSONArray) ZeusTransformUtils.preCheckCast(r4, JSONArray.class, "com.obric.memorydata.plugin"), r11, r12);
        goto L11
    L10:
        r6 = a((JSONObject) ZeusTransformUtils.preCheckCast(r4, JSONObject.class, "com.obric.memorydata.plugin"), r11, r12);
    L30:
        return (JsonElement) ZeusTransformUtils.preCheckCast(r0, JsonElement.class, "com.obric.memorydata.plugin");
    }

    @Override // com.google.gson.JsonSerializer
    public /* synthetic */ JsonElement serialize(JSONObject r3, Type r4, JsonSerializationContext r5) {
        Type r6 = (Type) ZeusTransformUtils.wrapperContextForParams(r4, Type.class, "com.obric.memorydata.plugin");
        JsonSerializationContext r7 = (JsonSerializationContext) ZeusTransformUtils.wrapperContextForParams(r5, JsonSerializationContext.class, "com.obric.memorydata.plugin");
        return a((JSONObject) ZeusTransformUtils.preCheckCast(r3, JSONObject.class, "com.obric.memorydata.plugin"), r6, r7);
    }
}
