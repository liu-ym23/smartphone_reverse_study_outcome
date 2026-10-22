package com.google.protobuf;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@CheckReturnValue
interface ListFieldSchema {
    void makeImmutableListAt(Object r8, long r10);

    <L> void mergeListsAt(Object r8, Object r10, long r11);

    <L> List<L> mutableListAt(Object r8, long r10);
}
