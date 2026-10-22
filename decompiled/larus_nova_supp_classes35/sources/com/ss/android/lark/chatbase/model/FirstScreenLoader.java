package com.ss.android.lark.chatbase.model;

import com.larksuite.framework.callback.CallbackManager;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.core.model.ChannelDataFetcherStrategy;
import com.ss.android.lark.chat.core.model.MessageFetchScene;
import com.ss.android.lark.chat.core.model.d;
import com.ss.android.lark.chatbase.BasePageStore;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.statistics.message.MessageHitPoint;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import f5b.b;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import x4b.a;
import x4b.j;
import x4b.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public abstract class FirstScreenLoader<T extends f5b.b, PageData extends x4b.a<T>> {
    public final com.ss.android.lark.chat.core.model.a<T, PageData> a;
    public final BasePageStore<T, PageData> b;
    public final Executor c;
    public final Executor d;
    public final CallbackManager e;
    public int f;

    public abstract String a();

    public abstract String b();

    public abstract boolean d();

    public abstract void e(List<Integer> r1, IGetDataCallback<Boolean> r2);

    public abstract void g();

    public final void f(final boolean r6, final IGetDataCallback<d<T>> r7) {
        int r0 = this.f;
        if (r0 > 0) goto L6;
        r0 = 15;
    L6:
        MessageFetchScene r1 = MessageFetchScene.FIRST_SCREEN;
        if (r6 == false) goto L9;
        ChannelDataFetcherStrategy r2 = ChannelDataFetcherStrategy.SYNC_SERVER_DATA;
    L10:
        com.ss.android.lark.chat.core.model.c r3 = new com.ss.android.lark.chat.core.model.c(0, r0, r1, r2);
        IGetDataCallback<PageData> r4 = new AnonymousClass1(this, r6, r7);
        com.ss.android.lark.chat.core.model.a<T, PageData> r8 = this.a;
        com.ss.android.lark.chatbase.a r9 = new com.ss.android.lark.chatbase.a(this.b, this.e.wrapAndAddCallback(r4));
        r8.getClass();
        r8.a(new l(r8, r3, r9));
        return;
    L9:
        r2 = ChannelDataFetcherStrategy.RETURN_LOCAL_DATA;
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void c(PageData r5, d<T> r6, List<Integer> r7, final IGetDataCallback<d<T>> r8) {
        boolean r9 = CollectionUtils.isNotEmpty(r7);
        boolean r0 = CollectionUtils.isNotEmpty(r6);
        Log.i(b(), "dataList size is:" + ((ArrayList) r6).size() + ", missingPos:" + r7);
        if (r9 == true) goto L5;
        Log.i(b(), "data completely");
        r8.onSuccess(r6);
        g();
        MessageHitPoint.c(a(), false, false);
        return;
    L5:
        if (r0 == false) goto L7;
        Log.i(b(), "partly completly load missingPos:" + r7);
        r8.onSuccess(r6);
        e(r7, null);
        g();
        return;
    L7:
        Log.i(b(), "no data back, get net data");
        IGetDataCallback<d<T>> r10 = new AnonymousClass2(this, r8);
        ChatCoreModule.a().getPerfEnterChatMonitor().j(true);
        PerfLog.start("chat_loadData_viaNetwork", BuildConfig.FLAVOR);
        if (d() == false) goto L10;
        final com.ss.android.lark.chat.core.model.c r11 = new com.ss.android.lark.chat.core.model.c(0, 15, MessageFetchScene.FIRST_SCREEN, ChannelDataFetcherStrategy.SYNC_SERVER_DATA);
        final com.ss.android.lark.chat.core.model.a<T, PageData> r12 = this.a;
        final b r1 = new b(this, r10);
        Executor r13 = this.d;
        r12.getClass();
        r13.execute(new j(r12, r11, r1));
    L11:
        MessageHitPoint.c(a(), true, true);
        return;
    L10:
        f(true, r10);
        goto L11
    }

    public FirstScreenLoader(com.ss.android.lark.chat.core.model.a<T, PageData> r1, BasePageStore<T, PageData> r2, Executor r3, Executor r4, CallbackManager r5) {
        this.a = r1;
        this.b = r2;
        this.d = r3;
        this.c = r4;
        this.e = r5;
    }
}
