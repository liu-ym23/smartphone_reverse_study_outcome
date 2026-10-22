package com.google.protobuf;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@CheckReturnValue
interface ListFieldSchema {
    void makeImmutableListAt(Object r10, long r11);

    <L> void mergeListsAt(Object r10, Object r11, long r12);

    <L> List<L> mutableListAt(Object r10, long r11);
}
