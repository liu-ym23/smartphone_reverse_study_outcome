package com.google.gson;

import com.google.gson.internal.LinkedTreeMap;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class JsonObject extends JsonElement {
    private final LinkedTreeMap<String, JsonElement> members;

    public JsonObject() {
        this.members = new LinkedTreeMap(false);
    }

    public void add(String r1, JsonElement r2) {
        LinkedTreeMap<String, JsonElement> r0 = this.members;
        if (r2 != null) goto L5;
        r2 = JsonNull.INSTANCE;
    L5:
        r0.put(r1, r2);
    }

    public void addProperty(String r2, Boolean r3) {
        if (r3 != null) goto L4;
        JsonElement r4 = JsonNull.INSTANCE;
    L5:
        add(r2, r4);
        return;
    L4:
        r4 = new JsonPrimitive(r3);
        goto L5
    }

    public void addProperty(String r2, Character r3) {
        if (r3 != null) goto L4;
        JsonElement r4 = JsonNull.INSTANCE;
    L5:
        add(r2, r4);
        return;
    L4:
        r4 = new JsonPrimitive(r3);
        goto L5
    }

    public void addProperty(String r2, Number r3) {
        if (r3 != null) goto L4;
        JsonElement r4 = JsonNull.INSTANCE;
    L5:
        add(r2, r4);
        return;
    L4:
        r4 = new JsonPrimitive(r3);
        goto L5
    }

    public void addProperty(String r2, String r3) {
        if (r3 != null) goto L4;
        JsonElement r4 = JsonNull.INSTANCE;
    L5:
        add(r2, r4);
        return;
    L4:
        r4 = new JsonPrimitive(r3);
        goto L5
    }

    public Map<String, JsonElement> asMap() {
        return this.members;
    }

    @Override // com.google.gson.JsonElement
    public /* bridge */ /* synthetic */ JsonElement deepCopy() {
        return deepCopy();
    }

    @Override // com.google.gson.JsonElement
    public JsonObject deepCopy() {
        JsonObject r0 = new JsonObject();
        Iterator<Map.Entry<String, JsonElement>> r5 = this.members.entrySet().iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r5.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        r0.add((String) ZeusTransformUtils.preCheckCast(r1.getKey(), String.class, "com.obric.memorydata.plugin"), ((JsonElement) ZeusTransformUtils.preCheckCast(r1.getValue(), JsonElement.class, "com.obric.memorydata.plugin")).deepCopy());
        goto L4
    L6:
        return r0;
    }

    public Set<Map.Entry<String, JsonElement>> entrySet() {
        return this.members.entrySet();
    }

    public boolean equals(Object r3) {
        if (r3 != this) goto L5;
    L10:
        return true;
    L5:
        if (ZeusTransformUtils.instanceOf(r3, JsonObject.class) == true) goto L7;
    L9:
        return false;
    L7:
        if (((JsonObject) ZeusTransformUtils.preCheckCast(r3, JsonObject.class, "com.obric.memorydata.plugin")).members.equals(this.members) == false) goto L9;
        goto L9
    }

    public JsonElement get(String r2) {
        return (JsonElement) ZeusTransformUtils.preCheckCast(this.members.get(r2), JsonElement.class, "com.obric.memorydata.plugin");
    }

    public JsonArray getAsJsonArray(String r2) {
        return (JsonArray) ZeusTransformUtils.preCheckCast(this.members.get(r2), JsonArray.class, "com.obric.memorydata.plugin");
    }

    public JsonObject getAsJsonObject(String r2) {
        return (JsonObject) ZeusTransformUtils.preCheckCast(this.members.get(r2), JsonObject.class, "com.obric.memorydata.plugin");
    }

    public JsonPrimitive getAsJsonPrimitive(String r2) {
        return (JsonPrimitive) ZeusTransformUtils.preCheckCast(this.members.get(r2), JsonPrimitive.class, "com.obric.memorydata.plugin");
    }

    public boolean has(String r1) {
        return this.members.containsKey(r1);
    }

    public int hashCode() {
        return this.members.hashCode();
    }

    public boolean isEmpty() {
        if (this.members.size() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public Set<String> keySet() {
        return this.members.keySet();
    }

    public JsonElement remove(String r2) {
        return (JsonElement) ZeusTransformUtils.preCheckCast(this.members.remove(r2), JsonElement.class, "com.obric.memorydata.plugin");
    }

    public int size() {
        return this.members.size();
    }
}
