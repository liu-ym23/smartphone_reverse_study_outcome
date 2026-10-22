package com.google.protobuf;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class MapFieldReflectionAccessor {
    public MapFieldReflectionAccessor() {
    }

    public abstract List<Message> getList();

    public abstract Message getMapEntryMessageDefaultInstance();

    public abstract List<Message> getMutableList();
}
