package com.google.protobuf;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public interface StructOrBuilder extends MessageOrBuilder {
    boolean containsFields(String r8);

    @Deprecated
    Map<String, Value> getFields();

    int getFieldsCount();

    Map<String, Value> getFieldsMap();

    Value getFieldsOrDefault(String r8, Value r10);

    Value getFieldsOrThrow(String r8);
}
