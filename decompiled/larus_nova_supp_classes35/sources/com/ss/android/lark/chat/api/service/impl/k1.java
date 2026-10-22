package com.ss.android.lark.chat.api.service.impl;

import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.im.v1.GetChannelThreadsRequest;
import com.bytedance.lark.pb.im.v1.GetThreadMessagesByPositionsRequest;
import com.bytedance.lark.pb.im.v1.GetThreadMessagesV2Request;
import com.bytedance.lark.pb.im.v1.UpdateThreadRequest;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.sdk.SdkSender;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class k1 implements a2b.m {

    public static final class a<T> implements SdkSender.IParser {
        public static final a<T> a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final /* bridge */ /* synthetic */ Object parse(byte[] r1) {
            return null;
        }
    }

    public k1() {
    }

    @Override // a2b.m
    public final l5b.a a(GetThreadMessagesByPositionsRequest.Builder r3, s1 r4) {
        Intrinsics.checkNotNullParameter(r3, "builder");
        Intrinsics.checkNotNullParameter(r4, "respMap");
        return (l5b.a) SdkSender.sendRequest(Command.GET_THREAD_MESSAGES_BY_POSITIONS, r3, new i1(r4));
    }

    @Override // a2b.m
    public final l5b.b b(GetChannelThreadsRequest.Builder r3, p1 r4) {
        Intrinsics.checkNotNullParameter(r3, "builder");
        Intrinsics.checkNotNullParameter(r4, "respMap");
        return (l5b.b) SdkSender.sendRequest(Command.GET_CHANNEL_THREADS, r3, new h1(r4));
    }

    @Override // a2b.m
    public final void c(UpdateThreadRequest.Builder r3, IGetDataCallback<Void> r4) {
        Intrinsics.checkNotNullParameter(r3, "builder");
        SdkSender.asynSendRequestNonWrap(Command.UPDATE_THREAD, r3, r4, a.a);
    }

    @Override // a2b.m
    public final l5b.a d(GetThreadMessagesV2Request.Builder r3, q1.a r4) {
        Intrinsics.checkNotNullParameter(r3, "builder");
        Intrinsics.checkNotNullParameter(r4, "respMap");
        return (l5b.a) SdkSender.sendRequest(Command.GET_THREAD_MESSAGES_V2, r3, new j1(r4));
    }
}
