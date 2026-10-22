package com.google.protobuf;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface FieldMaskOrBuilder extends MessageOrBuilder {
    String getPaths(int r8);

    ByteString getPathsBytes(int r8);

    int getPathsCount();

    List<String> getPathsList();
}
