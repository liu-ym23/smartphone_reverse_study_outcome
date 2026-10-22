package com.google.protobuf;

/* JADX INFO: loaded from: classes3.dex */
@CheckReturnValue
interface MessageInfoFactory {
    boolean isSupported(Class<?> r1);

    MessageInfo messageInfoFor(Class<?> r1);
}
