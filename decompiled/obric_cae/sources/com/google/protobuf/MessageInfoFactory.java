package com.google.protobuf;

/* JADX INFO: loaded from: classes.dex */
@CheckReturnValue
interface MessageInfoFactory {
    boolean isSupported(Class<?> r8);

    MessageInfo messageInfoFor(Class<?> r8);
}
