package com.google.protobuf;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface ListValueOrBuilder extends MessageOrBuilder {
    Value getValues(int r8);

    int getValuesCount();

    List<Value> getValuesList();

    ValueOrBuilder getValuesOrBuilder(int r8);

    List<? extends ValueOrBuilder> getValuesOrBuilderList();
}
