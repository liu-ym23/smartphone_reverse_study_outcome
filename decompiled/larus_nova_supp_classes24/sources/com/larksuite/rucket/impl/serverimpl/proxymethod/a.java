package com.larksuite.rucket.impl.serverimpl.proxymethod;

import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.rustclient.api.d;
import com.bytedance.lark.rustclient.api.l;
import com.larksuite.rucket.impl.serverimpl.annotation.ServerCall;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import java.lang.reflect.Method;
import java.util.ArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a extends com.larksuite.rucket.impl.base.request.a<ServerCall> {
    @Override // com.larksuite.rucket.core.proxymethod.BaseProxyMethod
    public final Class<ServerCall> b() {
        return ServerCall.class;
    }

    @Override // com.larksuite.rucket.impl.base.request.a
    public final d<Message<?, ?>> f(Object[] r10) {
        Intrinsics.checkNotNullParameter(r10, "args");
        ArrayList r0 = new ArrayList();
        int r1 = r10.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L8;
        Object r3 = r10[r2];
        if ((r3 instanceof Message) == false) goto L7;
        r0.add(r3);
    L7:
        r2 = r2 + 1;
        goto L3
    L8:
        Message r11 = (Message) CollectionsKt.first(r0);
        Command r4 = Command.POST_GATEWAY;
        return new d(r11.newBuilder(), ProtoAdapter.get(e()), r4, null, null, com.ss.android.lark.pb.improto.Command.fromValue(((ServerCall) c()).value()), null, 184);
    }

    public a(l r2, Method r3) {
        Intrinsics.checkNotNullParameter(r2, "client");
        Intrinsics.checkNotNullParameter(r3, "origin");
        super(r2, r3);
    }
}
