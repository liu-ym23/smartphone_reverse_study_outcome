package com.ss.android.lark.officesdk.minutes.service.foundation.network;

import com.squareup.wire.Message;
import com.ss.android.lark.pb.improto.Command;
import kotlin.Result;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public interface b {
    <R> Object a(Command r1, Class<R> r2, Message<?, ?> r3, Continuation<? super Result<? extends R>> r4);

    <R> Object b(com.bytedance.lark.pb.basic.v1.Command r1, Class<R> r2, Message<?, ?> r3, Continuation<? super Result<? extends R>> r4);

    <R> Object c(Class<R> r1, gvb.a r2, Continuation<? super Result<? extends R>> r3);
}
