package com.ss.android.lark.chat.service.impl;

import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.im.v1.GetRepliesRequest;
import com.bytedance.lark.pb.im.v1.GetRepliesResponse;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.passportc.dwarf.UserScope;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@UserScope
public final class n1 implements m6b.l {
    public final com.bytedance.lark.rustclient.api.l a;

    @Inject
    public n1(com.bytedance.lark.rustclient.api.l r2) {
        Intrinsics.checkNotNullParameter(r2, "userClient");
        this.a = r2;
    }

    @Override // m6b.l
    public final void a(GetRepliesRequest.Builder r11, t1 r12, IGetDataCallback r13) {
        Intrinsics.checkNotNullParameter(r11, "builder");
        Intrinsics.checkNotNullParameter(r12, "respMap");
        com.bytedance.lark.rustclient.api.d r0 = new com.bytedance.lark.rustclient.api.d(r11, GetRepliesResponse.ADAPTER, Command.GET_REPLIES, null, null, null, null, 248);
        com.ss.android.lark.im.sdk.utils.e.a(com.bytedance.lark.rustclient.api.t.b(this.a.h(r0).a()).map(new m1(r12)), r13);
    }
}
