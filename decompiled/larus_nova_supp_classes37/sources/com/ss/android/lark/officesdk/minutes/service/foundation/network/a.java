package com.ss.android.lark.officesdk.minutes.service.foundation.network;

import com.ss.android.lark.pb.improto.Command;
import kotlinx.coroutines.flow.d1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public interface a {
    <R> d1<R> a(Command r1, Class<R> r2);

    <R> d1<R> b(com.bytedance.lark.pb.basic.v1.Command r1, Class<R> r2);

    void c(Command r1);

    void d(com.bytedance.lark.pb.basic.v1.Command r1);
}
