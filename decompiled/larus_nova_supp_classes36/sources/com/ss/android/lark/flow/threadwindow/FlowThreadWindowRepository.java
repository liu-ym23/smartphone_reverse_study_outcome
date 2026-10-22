package com.ss.android.lark.flow.threadwindow;

import android.text.TextUtils;
import com.bytedance.lark.pb.basic.v1.Channel;
import com.bytedance.lark.pb.im.v1.GetChannelThreadsRequest;
import com.ss.android.lark.biz.im.api.bundle.ChatBundle;
import com.ss.android.lark.chat.api.service.impl.p1;
import com.ss.android.lark.chat.api.service.impl.q1;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import com.ss.android.lark.chat.core.model.ChannelDataFetcherStrategy;
import com.ss.android.lark.chat.core.model.MessageFetchScene;
import com.ss.android.lark.image.api.Target;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class FlowThreadWindowRepository {
    public final ChatBundle a;
    public final v b;

    public static final class a {
    }

    static {
    }

    public FlowThreadWindowRepository(ChatBundle r2, v r3) {
        Intrinsics.checkNotNullParameter(r2, "chatBundle");
        Intrinsics.checkNotNullParameter(r3, "chatAppContainer");
        this.a = r2;
        this.b = r3;
    }

    public final Object b(String r6, Continuation<? super Result<? extends List<? extends n5b.a>>> r7) {
        if ((r7 instanceof FlowThreadWindowRepository$loadFirstPage$1) == false) goto L7;
        FlowThreadWindowRepository$loadFirstPage$1 r0 = (FlowThreadWindowRepository$loadFirstPage$1) r7;
        int r1 = r0.label;
        if ((r1 & Target.SIZE_ORIGINAL) == 0) goto L7;
        r0.label = r1 - Target.SIZE_ORIGINAL;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r8);
    L18:
        return ((Result) r8).unbox-impl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r8);
        CoroutineDispatcher r9 = Dispatchers.getIO();
        FlowThreadWindowRepository$loadFirstPage$2 r4 = new FlowThreadWindowRepository$loadFirstPage$2(this, r6, null);
        r0.label = 1;
        r8 = BuildersKt.withContext(r9, r4, r0);
        if (r8 != r2) goto L18;
        return r2;
    L7:
        r0 = new FlowThreadWindowRepository$loadFirstPage$1(this, r7);
        goto L8
    }

    public final Object c(String r6, int r7, Continuation<? super Result<? extends List<? extends n5b.a>>> r8) {
        if ((r8 instanceof FlowThreadWindowRepository$loadNextPage$1) == false) goto L7;
        FlowThreadWindowRepository$loadNextPage$1 r0 = (FlowThreadWindowRepository$loadNextPage$1) r8;
        int r1 = r0.label;
        if ((r1 & Target.SIZE_ORIGINAL) == 0) goto L7;
        r0.label = r1 - Target.SIZE_ORIGINAL;
    L8:
        Object r9 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r9);
    L18:
        return ((Result) r9).unbox-impl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r9);
        CoroutineDispatcher r10 = Dispatchers.getIO();
        FlowThreadWindowRepository$loadNextPage$2 r4 = new FlowThreadWindowRepository$loadNextPage$2(this, r6, r7, null);
        r0.label = 1;
        r9 = BuildersKt.withContext(r10, r4, r0);
        if (r9 != r2) goto L18;
        return r2;
    L7:
        r0 = new FlowThreadWindowRepository$loadNextPage$1(this, r8);
        goto L8
    }

    public final Object d(String r6, int r7, Continuation<? super Result<? extends List<? extends n5b.a>>> r8) {
        if ((r8 instanceof FlowThreadWindowRepository$loadPrePage$1) == false) goto L7;
        FlowThreadWindowRepository$loadPrePage$1 r0 = (FlowThreadWindowRepository$loadPrePage$1) r8;
        int r1 = r0.label;
        if ((r1 & Target.SIZE_ORIGINAL) == 0) goto L7;
        r0.label = r1 - Target.SIZE_ORIGINAL;
    L8:
        Object r9 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r9);
    L18:
        return ((Result) r9).unbox-impl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r9);
        CoroutineDispatcher r10 = Dispatchers.getIO();
        FlowThreadWindowRepository$loadPrePage$2 r4 = new FlowThreadWindowRepository$loadPrePage$2(this, r6, r7, null);
        r0.label = 1;
        r9 = BuildersKt.withContext(r10, r4, r0);
        if (r9 != r2) goto L18;
        return r2;
    L7:
        r0 = new FlowThreadWindowRepository$loadPrePage$1(this, r8);
        goto L8
    }

    public final Object e(String r6, int r7, Continuation<? super Result<? extends List<? extends n5b.a>>> r8) {
        if ((r8 instanceof FlowThreadWindowRepository$loadSpecificPage$1) == false) goto L7;
        FlowThreadWindowRepository$loadSpecificPage$1 r0 = (FlowThreadWindowRepository$loadSpecificPage$1) r8;
        int r1 = r0.label;
        if ((r1 & Target.SIZE_ORIGINAL) == 0) goto L7;
        r0.label = r1 - Target.SIZE_ORIGINAL;
    L8:
        Object r9 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r9);
    L18:
        return ((Result) r9).unbox-impl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r9);
        CoroutineDispatcher r10 = Dispatchers.getIO();
        FlowThreadWindowRepository$loadSpecificPage$2 r4 = new FlowThreadWindowRepository$loadSpecificPage$2(r7, this, r6, null);
        r0.label = 1;
        r9 = BuildersKt.withContext(r10, r4, r0);
        if (r9 != r2) goto L18;
        return r2;
    L7:
        r0 = new FlowThreadWindowRepository$loadSpecificPage$1(this, r8);
        goto L8
    }

    public static final l5b.b a(FlowThreadWindowRepository r6, String r7, MessageFetchScene r8, int r9) {
        r6.getClass();
        if (r8 != MessageFetchScene.FIRST_SCREEN) goto L5;
    L8:
        boolean r10 = true;
    L9:
        q1 r0 = q1.d.a;
        ChannelDataFetcherStrategy r1 = ChannelDataFetcherStrategy.SYNC_SERVER_DATA;
        int r2 = com.ss.android.lark.chat.core.model.a.b;
        if (TextUtils.isEmpty(r7) == true) goto L15;
        if (r9 < 0) goto L15;
        p1 r5 = new p1(System.currentTimeMillis(), r7);
        GetChannelThreadsRequest.Builder r3 = new GetChannelThreadsRequest.Builder();
        r3.channel(new Channel.Builder().id(r7).type(Channel.Type.CHAT).build()).scene(q1.b(r8)).count(15).redundancy_count(5).position(Integer.valueOf(r9)).strategy(q1.c(r1)).preload_count(Integer.valueOf(r2)).need_response(Boolean.TRUE).need_reply_prompt(Boolean.valueOf(r10));
        return r0.a.b(r3, r5);
    L15:
        return new l5b.b();
    L5:
        if (r8 == MessageFetchScene.SPECIFIED_POSITION) goto L8;
        r10 = false;
        goto L9
    }
}
