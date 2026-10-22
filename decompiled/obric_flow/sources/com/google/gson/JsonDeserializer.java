package com.google.gson;

import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes2.dex */
public interface JsonDeserializer<T> {
    T deserialize(JsonElement r5, Type r10, JsonDeserializationContext r11) throws JsonParseException;
}
