package com.ss.android.lark.chat.chatwindow.chat.preloaderv2.loader;

import android.util.Pair;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.core.model.ChannelDataFetcherStrategy;
import com.ss.android.lark.chat.core.model.MessageFetchScene;
import com.ss.android.lark.chat.core.model.entity.ChatMessageResponse;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.im.sdk.service.p;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import q3b.n;
import w3b.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b implements c<w3b.b, ChatMessageResponse> {
    public final p a;

    public static final class a {
    }

    static {
    }

    @Inject
    public b(p r2) {
        Intrinsics.checkNotNullParameter(r2, "messageService");
        this.a = r2;
    }

    public static void c(MessageFetchScene r3, List r4) {
        Log.i("ChatWindowDataPreLoaderV2", "print first page data begin, scene:" + r3.getDesc() + ", count:" + r4.size());
        Iterator r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        Log.i("ChatWindowDataPreLoaderV2", "load message:" + ((MessageInfo) r5.next()).getMessage());
        goto L4
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.preloaderv2.loader.c
    public final Object a(d r19, Continuation<? super Result<? extends ChatMessageResponse>> r20) {
        w3b.b r1 = (w3b.b) r19;
        String r2 = r1.a;
        int r3 = r1.b;
        if (r3 < 0) goto L5;
        MessageFetchScene r4 = MessageFetchScene.SPECIFIED_POSITION;
    L7:
        if (r3 < 0) goto L9;
        boolean r7 = true;
    L10:
        b(r2, true, r7);
        if (r7 == false) goto L13;
        ChannelDataFetcherStrategy r8 = ChannelDataFetcherStrategy.SYNC_SERVER_DATA;
    L14:
        PerfLog.start("syncPullChatMessages", BuildConfig.FLAVOR);
        com.ss.android.lark.im.sdk.service.a.a r11 = new com.ss.android.lark.im.sdk.service.a.a();
        r11.a(r2);
        r11.b(r4);
        r11.c = r3;
        r11.d = 15;
        r11.e = 5;
        r11.f = 30;
        r11.g = true;
        r11.c(r8);
        Intrinsics.checkNotNullParameter(BuildConfig.FLAVOR, "contextId");
        r11.i = BuildConfig.FLAVOR;
        ChatMessageResponse r5 = this.a.x2(new com.ss.android.lark.im.sdk.service.a(r11));
        PerfLog.end("syncPullChatMessages", BuildConfig.FLAVOR);
        if (r5 == null) goto L41;
        boolean r12 = CollectionUtils.isNotEmpty(r5.missingPositions);
        String r13 = "ChatWindowDataPreLoaderV2";
        Throwable r17 = null;
        if (CollectionUtils.isNotEmpty(r5.messageInfoList) == true) goto L24;
        if (r12 == false) goto L24;
        if (r7 == true) goto L24;
        Log.i("ChatWindowDataPreLoaderV2", "local data is empty, reload from net");
        PerfLog.start("syncPullNetMessages", BuildConfig.FLAVOR);
        r8 = ChannelDataFetcherStrategy.SYNC_SERVER_DATA;
        com.ss.android.lark.im.sdk.service.a.a r6 = new com.ss.android.lark.im.sdk.service.a.a();
        r6.a(r2);
        r6.b(r4);
        r6.c = r3;
        r6.d = 15;
        r6.e = 5;
        r6.f = 30;
        r6.g = true;
        r6.c(r8);
        Intrinsics.checkNotNullParameter(BuildConfig.FLAVOR, "contextId");
        r6.i = BuildConfig.FLAVOR;
        ChatMessageResponse r9 = this.a.x2(new com.ss.android.lark.im.sdk.service.a(r6));
        PerfLog.end("syncPullNetMessages", BuildConfig.FLAVOR);
        if (r9 != null) goto L23;
        r5 = r9;
        r17 = new ErrorResult("preload data failed, task is：" + r1.a());
    L25:
        if (r5 != null) goto L27;
    L39:
        if (r5 == null) goto L42;
        n.g(r5.messageInfoList);
        ChatCoreModule.a().getPerfEnterChatMonitor().b(r5.sdkCost, r5.clientDataCost, r5.netCosts);
    L42:
        b(r2, false, r7);
        if (r17 != null) goto L46;
        if (r5 == null) goto L46;
        return Result.constructor-impl(r5);
    L46:
        if (r17 != null) goto L48;
        r17 = new ErrorResult("preload data failed, task is：" + r1.a());
    L48:
        Result.Companion r10 = Result.Companion;
        return Result.constructor-impl(ResultKt.createFailure(r17));
    L27:
        if ((!r5.mFoldIntervals.isEmpty()) == false) goto L39;
        Log.i("ChatWindowDataPreLoaderV2", "response has fold messages, try to load pre page");
        Iterator<Pair<Integer, Integer>> r14 = r5.mFoldIntervals.iterator();
        int r15 = Integer.MAX_VALUE;
    L30:
        if (r14.hasNext() == false) goto L32;
        r15 = (int) Math.min(((Number) r14.next().first).intValue(), r15);
        r14 = r14;
        r13 = r13;
        goto L30
    L32:
        String r16 = r13;
        if ((!r5.messageInfoList.isEmpty()) == false) goto L35;
        r15 = (int) Math.min(((MessageInfo) ListProtector.get(r5.messageInfoList, 0)).getMessage().getPosition(), r15);
    L35:
        int r18 = (int) Math.max(0.0d, r15);
        Log.i(r16, "load prePage message, start position is minPos");
        PerfLog.start("syncPullNetMessages", "load prePage");
        com.ss.android.lark.im.sdk.service.a.a r110 = new com.ss.android.lark.im.sdk.service.a.a();
        r110.a(r2);
        r110.b(MessageFetchScene.PREVIOUS_PAGE);
        r110.c = r18;
        r110.d = 15;
        r110.e = 0;
        r110.f = 0;
        r110.g = true;
        r110.c(r8);
        Intrinsics.checkNotNullParameter(BuildConfig.FLAVOR, "contextId");
        r110.i = BuildConfig.FLAVOR;
        ChatMessageResponse r21 = this.a.x2(new com.ss.android.lark.im.sdk.service.a(r110));
        if (r21 == null) goto L38;
        r5.messageInfoList.addAll(0, r21.messageInfoList);
        Log.i(r16, "load pre page , miss position is " + r21.missingPositions);
        r5.missingPositions.addAll(r21.missingPositions);
    L38:
        PerfLog.end("syncPullNetMessages", "load prePage");
        goto L39
    L23:
        c(r4, r9.messageInfoList);
        r5 = r9;
    L24:
        c(r4, r5.messageInfoList);
        goto L25
    L41:
        r17 = new ErrorResult("preload data failed, task is：" + r1.a());
        goto L42
    L13:
        r8 = ChannelDataFetcherStrategy.RETURN_LOCAL_DATA;
        goto L14
    L9:
        r7 = false;
        goto L10
    L5:
        r4 = MessageFetchScene.FIRST_SCREEN;
        goto L7
    }

    public static void b(String r3, boolean r4, boolean r5) {
        if (r5 == false) goto L6;
        if (r4 == false) goto L5;
        ChatCoreModule.a().getPerfEnterChatMonitor().o(r3, com.ss.android.lark.sdk.a.a());
    L9:
        String r1 = "viaNetwork";
        if (r4 == false) goto L17;
        if (r5 == true) goto L15;
        r1 = "viaLocal";
    L15:
        PerfLog.start("chat_loadData_".concat(r1), BuildConfig.FLAVOR);
    L21:
        ChatCoreModule.a().getPerfEnterChatMonitor().n();
        return;
    L17:
        if (r5 == true) goto L20;
        r1 = "viaLocal";
    L20:
        PerfLog.end("chat_loadData_".concat(r1), BuildConfig.FLAVOR);
        goto L21
    L5:
        ChatCoreModule.a().getPerfEnterChatMonitor().s();
        goto L9
    L6:
        if (r4 == false) goto L8;
        ChatCoreModule.a().getPerfEnterChatMonitor().p(r3);
        goto L9
    L8:
        ChatCoreModule.a().getPerfEnterChatMonitor().m();
        goto L9
    }
}
