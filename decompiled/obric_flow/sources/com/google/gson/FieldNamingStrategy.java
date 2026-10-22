package com.google.gson;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface FieldNamingStrategy {
    default List<String> alternateNames(Field r5) {
        return Collections.emptyList();
    }

    String translateName(Field r5);
}
