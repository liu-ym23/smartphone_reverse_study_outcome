package com.google.gson;

import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes2.dex */
public interface JsonSerializer<T> {
    JsonElement serialize(T r5, Type r10, JsonSerializationContext r11);
}
