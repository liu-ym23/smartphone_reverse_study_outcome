package com.google.gson;

import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes2.dex */
public interface JsonSerializationContext {
    JsonElement serialize(Object r5);

    JsonElement serialize(Object r5, Type r10);
}
