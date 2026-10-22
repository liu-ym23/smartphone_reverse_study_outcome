package com.google.protobuf;

import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public interface StructOrBuilder extends MessageOrBuilder {
    boolean containsFields(String r10);

    @Deprecated
    Map<String, Value> getFields();

    int getFieldsCount();

    Map<String, Value> getFieldsMap();

    Value getFieldsOrDefault(String r10, Value r11);

    Value getFieldsOrThrow(String r10);
}
