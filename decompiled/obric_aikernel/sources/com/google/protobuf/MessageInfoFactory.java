package com.google.protobuf;

/* JADX INFO: loaded from: classes2.dex */
@CheckReturnValue
interface MessageInfoFactory {
    boolean isSupported(Class<?> r10);

    MessageInfo messageInfoFor(Class<?> r10);
}
