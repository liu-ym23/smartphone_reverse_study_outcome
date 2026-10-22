package com.ss.android.lark.chat.chatwindow.chat.perload.loader;

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
import kotlin.jvm.internal.Intrinsics;
import q3b.n;
import u3b.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b implements c<u3b.c, e<ChatMessageResponse>> {
    public final p a;

    public b(p r1) {
        this.a = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v1, types: [T, com.ss.android.lark.chat.core.model.entity.ChatMessageResponse] */
    /* JADX WARN: Type inference failed for: r6v3, types: [T, com.ss.android.lark.chat.core.model.entity.ChatMessageResponse] */
    @Override // com.ss.android.lark.chat.chatwindow.chat.perload.loader.c
    public final e a(u3b.a r17) {
        u3b.c r1 = (u3b.c) r17;
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
        ?? r6 = this.a.x2(new com.ss.android.lark.im.sdk.service.a(r11));
        PerfLog.end("syncPullChatMessages", BuildConfig.FLAVOR);
        e r9 = new e();
        if (r6 == 0) goto L42;
        boolean r5 = CollectionUtils.isNotEmpty(r6.missingPositions);
        if (CollectionUtils.isNotEmpty(r6.messageInfoList) == true) goto L24;
        if (r5 == false) goto L24;
        if (r7 == true) goto L24;
        Log.i("ChatWindowDataPreLoader", "local data is empty, reload from net");
        PerfLog.start("syncPullNetMessages", BuildConfig.FLAVOR);
        r8 = ChannelDataFetcherStrategy.SYNC_SERVER_DATA;
        com.ss.android.lark.im.sdk.service.a.a r10 = new com.ss.android.lark.im.sdk.service.a.a();
        r10.a(r2);
        r10.b(r4);
        r10.c = r3;
        r10.d = 15;
        r10.e = 5;
        r10.f = 30;
        r10.g = true;
        r10.c(r8);
        Intrinsics.checkNotNullParameter(BuildConfig.FLAVOR, "contextId");
        r10.i = BuildConfig.FLAVOR;
        ?? r12 = this.a.x2(new com.ss.android.lark.im.sdk.service.a(r10));
        PerfLog.end("syncPullNetMessages", BuildConfig.FLAVOR);
        if (r12 != 0) goto L23;
        r9.b = new ErrorResult("preload data failed, task is：" + r1.a());
        ChatMessageResponse r13 = r12;
    L25:
        if (r13 != 0) goto L27;
    L40:
        if (r13 == 0) goto L43;
        n.g(r13.messageInfoList);
        ChatCoreModule.a().getPerfEnterChatMonitor().b(r13.sdkCost, r13.clientDataCost, r13.netCosts);
    L43:
        b(r2, false, r7);
        return r9;
    L27:
        if (r13.mFoldIntervals.isEmpty() == true) goto L40;
        Log.i("ChatWindowDataPreLoader", "response has fold messages, try to load pre page");
        Iterator<Pair<Integer, Integer>> r14 = r13.mFoldIntervals.iterator();
        int r15 = Integer.MAX_VALUE;
    L30:
        if (r14.hasNext() == false) goto L33;
        r15 = Math.min(((Integer) r14.next().first).intValue(), r15);
        goto L30
    L33:
        if (r13.messageInfoList.isEmpty() == true) goto L35;
        int r16 = 0;
        r15 = Math.min(((MessageInfo) ListProtector.get(r13.messageInfoList, 0)).getMessage().getPosition(), r15);
    L36:
        int r18 = Math.max(r16, r15);
        Log.i("ChatWindowDataPreLoader", "load prePage message, start position is minPos");
        PerfLog.start("syncPullNetMessages", "load prePage");
        com.ss.android.lark.im.sdk.service.a.a r19 = new com.ss.android.lark.im.sdk.service.a.a();
        r19.a(r2);
        r19.b(MessageFetchScene.PREVIOUS_PAGE);
        r19.c = r18;
        r19.d = 15;
        r19.e = 0;
        r19.f = 0;
        r19.g = true;
        r19.c(r8);
        Intrinsics.checkNotNullParameter(BuildConfig.FLAVOR, "contextId");
        r19.i = BuildConfig.FLAVOR;
        ChatMessageResponse r20 = this.a.x2(new com.ss.android.lark.im.sdk.service.a(r19));
        if (r20 == null) goto L39;
        r13.messageInfoList.addAll(0, r20.messageInfoList);
        Log.i("ChatWindowDataPreLoader", "load pre page , miss position is " + r20.missingPositions.toString());
        r13.missingPositions.addAll(r20.missingPositions);
    L39:
        PerfLog.end("syncPullNetMessages", "load prePage");
        goto L40
    L35:
        r16 = 0;
        goto L36
    L23:
        c(r4, r12.messageInfoList);
        r9.a = r12;
        r13 = r12;
    L24:
        c(r4, r6.messageInfoList);
        r9.a = r6;
        r13 = r6;
        goto L25
    L42:
        r9.b = new ErrorResult("preload data failed, task is：" + r1.a());
        goto L43
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

    public static void c(MessageFetchScene r3, List r4) {
        Log.i("ChatWindowDataPreLoader", "print first page data begin, scene:" + r3.getDesc() + ", count:" + r4.size());
        Iterator r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        Log.i("ChatWindowDataPreLoader", "load message:" + ((MessageInfo) r5.next()).getMessage());
        goto L4
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
