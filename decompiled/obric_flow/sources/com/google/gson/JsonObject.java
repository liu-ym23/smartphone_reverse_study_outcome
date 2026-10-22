package com.google.gson;

import com.google.gson.internal.LinkedTreeMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class JsonObject extends JsonElement {
    private final LinkedTreeMap<String, JsonElement> members;

    public JsonObject() {
        this.members = new LinkedTreeMap(false);
    }

    public void add(String r5, JsonElement r10) {
        LinkedTreeMap<String, JsonElement> r11 = this.members;
        if (r10 != null) goto L5;
        r10 = JsonNull.INSTANCE;
    L5:
        r11.put(r5, r10);
    }

    public void addProperty(String r5, String r10) {
        if (r10 != null) goto L4;
        JsonElement r11 = JsonNull.INSTANCE;
    L5:
        add(r5, r11);
        return;
    L4:
        r11 = new JsonPrimitive(r10);
        goto L5
    }

    public Map<String, JsonElement> asMap() {
        return this.members;
    }

    @Override // com.google.gson.JsonElement
    public /* bridge */ /* synthetic */ JsonElement deepCopy() {
        return deepCopy();
    }

    public Set<Map.Entry<String, JsonElement>> entrySet() {
        return this.members.entrySet();
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L4;
    L9:
        return true;
    L4:
        if ((r5 instanceof JsonObject) == true) goto L6;
    L8:
        return false;
    L6:
        if (((JsonObject) r5).members.equals(this.members) == false) goto L8;
        goto L8
    }

    public JsonElement get(String r5) {
        return this.members.get(r5);
    }

    public JsonArray getAsJsonArray(String r5) {
        return (JsonArray) this.members.get(r5);
    }

    public JsonObject getAsJsonObject(String r5) {
        return (JsonObject) this.members.get(r5);
    }

    public JsonPrimitive getAsJsonPrimitive(String r5) {
        return (JsonPrimitive) this.members.get(r5);
    }

    public boolean has(String r5) {
        return this.members.containsKey(r5);
    }

    public int hashCode() {
        return this.members.hashCode();
    }

    public boolean isEmpty() {
        return this.members.isEmpty();
    }

    public Set<String> keySet() {
        return this.members.keySet();
    }

    public JsonElement remove(String r5) {
        return this.members.remove(r5);
    }

    public int size() {
        return this.members.size();
    }

    public void addProperty(String r5, Number r10) {
        if (r10 != null) goto L4;
        JsonElement r11 = JsonNull.INSTANCE;
    L5:
        add(r5, r11);
        return;
    L4:
        r11 = new JsonPrimitive(r10);
        goto L5
    }

    @Override // com.google.gson.JsonElement
    public JsonObject deepCopy() {
        JsonObject r5 = new JsonObject();
        Iterator<Map.Entry<String, JsonElement>> r10 = this.members.entrySet().iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        Map.Entry<String, JsonElement> r11 = r10.next();
        r5.add(r11.getKey(), r11.getValue().deepCopy());
        goto L4
    L6:
        return r5;
    }

    public void addProperty(String r5, Boolean r10) {
        if (r10 != null) goto L4;
        JsonElement r11 = JsonNull.INSTANCE;
    L5:
        add(r5, r11);
        return;
    L4:
        r11 = new JsonPrimitive(r10);
        goto L5
    }

    public void addProperty(String r5, Character r10) {
        if (r10 != null) goto L4;
        JsonElement r11 = JsonNull.INSTANCE;
    L5:
        add(r5, r11);
        return;
    L4:
        r11 = new JsonPrimitive(r10);
        goto L5
    }
}
