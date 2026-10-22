package com.google.protobuf;

import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface ListValueOrBuilder extends MessageOrBuilder {
    Value getValues(int r1);

    int getValuesCount();

    List<Value> getValuesList();

    ValueOrBuilder getValuesOrBuilder(int r1);

    List<? extends ValueOrBuilder> getValuesOrBuilderList();
}
