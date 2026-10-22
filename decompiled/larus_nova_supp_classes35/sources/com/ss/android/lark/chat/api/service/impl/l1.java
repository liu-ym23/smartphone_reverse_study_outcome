package com.ss.android.lark.chat.api.service.impl;

import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.im.v1.GetChannelThreadsRequest;
import com.bytedance.lark.pb.im.v1.GetChannelThreadsResponse;
import com.bytedance.lark.pb.im.v1.GetThreadMessagesByPositionsRequest;
import com.bytedance.lark.pb.im.v1.GetThreadMessagesByPositionsResponse;
import com.bytedance.lark.pb.im.v1.GetThreadMessagesV2Request;
import com.bytedance.lark.pb.im.v1.GetThreadMessagesV2Response;
import com.bytedance.lark.pb.im.v1.UpdateThreadRequest;
import com.bytedance.lark.pb.im.v1.UpdateThreadResponse;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.passportc.dwarf.UserScope;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@UserScope
public final class l1 implements a2b.m {
    public final com.bytedance.lark.rustclient.api.l a;

    @Inject
    public l1(com.bytedance.lark.rustclient.api.l r2) {
        Intrinsics.checkNotNullParameter(r2, "userClient");
        this.a = r2;
    }

    @Override // a2b.m
    public final l5b.a a(GetThreadMessagesByPositionsRequest.Builder r11, final s1 r12) {
        Intrinsics.checkNotNullParameter(r11, "builder");
        Intrinsics.checkNotNullParameter(r12, "respMap");
        com.bytedance.lark.rustclient.api.d r0 = new com.bytedance.lark.rustclient.api.d(r11, GetThreadMessagesByPositionsResponse.ADAPTER, Command.GET_THREAD_MESSAGES_BY_POSITIONS, null, null, null, null, 248);
        return (l5b.a) com.bytedance.lark.rustclient.api.t.c(com.bytedance.lark.rustclient.api.t.e(this.a.h(r0).execute(), new ThreadRepositoryV2$getThreadMessageByPositions$1(r12)), null);
    }

    @Override // a2b.m
    public final l5b.b b(GetChannelThreadsRequest.Builder r11, final p1 r12) {
        Intrinsics.checkNotNullParameter(r11, "builder");
        Intrinsics.checkNotNullParameter(r12, "respMap");
        com.bytedance.lark.rustclient.api.d r0 = new com.bytedance.lark.rustclient.api.d(r11, GetChannelThreadsResponse.ADAPTER, Command.GET_CHANNEL_THREADS, null, null, null, null, 248);
        return (l5b.b) com.bytedance.lark.rustclient.api.t.c(com.bytedance.lark.rustclient.api.t.e(this.a.h(r0).execute(), new ThreadRepositoryV2$getChannelThreads$1(r12)), null);
    }

    @Override // a2b.m
    public final void c(UpdateThreadRequest.Builder r11, IGetDataCallback<Void> r12) {
        Intrinsics.checkNotNullParameter(r11, "builder");
        com.bytedance.lark.rustclient.api.d r0 = new com.bytedance.lark.rustclient.api.d(r11, UpdateThreadResponse.ADAPTER, Command.UPDATE_THREAD, null, null, null, null, 248);
        Observable r13 = com.bytedance.lark.rustclient.api.t.b(this.a.h(r0).a());
        Intrinsics.checkNotNullParameter(r13, "<this>");
        r13.subscribe(new com.ss.android.lark.im.sdk.utils.c(r12), new com.ss.android.lark.im.sdk.utils.d(r12));
    }

    @Override // a2b.m
    public final l5b.a d(GetThreadMessagesV2Request.Builder r11, final q1.a r12) {
        Intrinsics.checkNotNullParameter(r11, "builder");
        Intrinsics.checkNotNullParameter(r12, "respMap");
        com.bytedance.lark.rustclient.api.d r0 = new com.bytedance.lark.rustclient.api.d(r11, GetThreadMessagesV2Response.ADAPTER, Command.GET_THREAD_MESSAGES_V2, null, null, null, null, 248);
        return (l5b.a) com.bytedance.lark.rustclient.api.t.c(com.bytedance.lark.rustclient.api.t.e(this.a.h(r0).execute(), new ThreadRepositoryV2$getThreadMessageV2$1(r12)), null);
    }
}
