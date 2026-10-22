package com.google.protobuf;

import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class MapFieldReflectionAccessor {
    public MapFieldReflectionAccessor() {
    }

    abstract List<Message> getList();

    abstract Message getMapEntryMessageDefaultInstance();

    abstract List<Message> getMutableList();
}
