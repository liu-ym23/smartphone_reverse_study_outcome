package com.ss.android.lark.chat.chatwindow.chat.v2.component.message;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.larksuite.framework.callback.CallbackManager;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.biz.im.api.y0;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.ChatWindowViewModel;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.titlebar.viewmodel.TitlebarViewModel;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.x;
import com.ss.android.lark.chat.core.model.ChannelDataFetcherStrategy;
import com.ss.android.lark.chat.core.model.MessageFetchScene;
import com.ss.android.lark.chat.core.model.PageLoader;
import com.ss.android.lark.chat.core.model.entity.ChatMessageResponse;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttvideoengine.utils.Error;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Result;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import q3b.q;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class j implements y0 {
    public final q3b.m a;
    public final v b;
    public final fxa.b c;
    public final LiveData<Chat> d;
    public final int e;
    public final c f;
    public l g;
    public final q3b.n h;
    public final Lazy i;

    public static final class a implements PageLoader.c {
        public final /* synthetic */ j a;

        public a(j r1) {
            this.a = r1;
        }

        @Override // com.ss.android.lark.chat.core.model.PageLoader.c
        public final int getPosition() {
            return this.a.a.d;
        }
    }

    public static final class b implements PageLoader.c {
        public final /* synthetic */ j a;

        public b(j r1) {
            this.a = r1;
        }

        @Override // com.ss.android.lark.chat.core.model.PageLoader.c
        public final int getPosition() {
            return this.a.a.c;
        }
    }

    public final boolean canLoadMore() {
        int r0 = this.a.d;
        if (r0 < 0) goto L10;
        Chat r1 = (Chat) this.d.getValue();
        if (r1 == null) goto L7;
        int r2 = r1.getLastVisibleMessagePosition();
    L8:
        if (r0 >= r2) goto L10;
        return true;
    L7:
        r2 = -1;
    L10:
        return false;
    }

    public final boolean canLoadPre() {
        int r0 = this.a.c;
        Chat r1 = (Chat) this.d.getValue();
        if (r1 != null) goto L6;
        return false;
    L6:
        if (r0 <= (r1.getFirstMessagePosition() + 1)) goto L12;
        if (r0 > 0) goto L9;
        return false;
    L9:
        if (r0 == Integer.MAX_VALUE) goto L14;
        return true;
    L14:
        return false;
    L12:
        return false;
    }

    public final void a(final q<x4b.a<MessageInfo>, MessageInfo> r4) {
        Intrinsics.checkNotNullParameter(r4, "receiver");
        final com.ss.android.lark.chat.core.model.c r0 = new com.ss.android.lark.chat.core.model.c(new b(this), com.ss.android.lark.chat.core.model.a.b);
        final q3b.n r1 = this.h;
        r1.getClass();
        r1.a(new x4b.i(r1, r0, r4));
    }

    public final void c(final IGetDataCallback<ChatMessageResponse> r18) {
        Intrinsics.checkNotNullParameter(r18, "callback");
        if (this.c.a() == true) goto L11;
        IGetDataCallback<u3b.e<Object>> r0 = new DefaultMessageListRepository$loadFirstPageV1$wrappedCallback$1(r18);
        Chat r2 = (Chat) this.d.getValue();
        if (r2 == null) goto L10;
        String r3 = r2.getId();
        if (r3 == null) goto L10;
        PerfLog.start("chat_fetch_first_page_data", BuildConfig.FLAVOR);
        u3b.c r1 = this.g.a(r3, this.e);
        com.ss.android.lark.chat.chatwindow.chat.perload.c.a.a.a(r1, r0);
        return;
    L10:
        Exception r4 = new Exception("unknown error");
        ErrorResult r5 = new ErrorResult(0);
        ErrorResult.access$002(r5, -1);
        ErrorResult.access$102(r5, Error.ParameterNull);
        ErrorResult.access$202(r5, 0);
        ErrorResult.access$302(r5, r4);
        ErrorResult.access$402(r5, BuildConfig.FLAVOR);
        ErrorResult.access$502(r5, "chat id is null");
        ErrorResult.access$602(r5, BuildConfig.FLAVOR);
        ErrorResult.access$702(r5, BuildConfig.FLAVOR);
        ErrorResult.access$802(r5, 0);
        ErrorResult.access$902(r5, null);
        ErrorResult.access$1002(r5, null);
        ErrorResult.access$1102(r5, null);
        r18.onError(r5);
        return;
    L11:
        Log.i(ChatWindowViewModel.LAUNCHER_TAG, "fetch chat window list data use preload v2");
        x r6 = this.b.H();
        Chat r7 = (Chat) this.d.getValue();
        if (r7 == null) goto L32;
        String r8 = r7.getId();
        if (r8 == null) goto L32;
        u3b.c r9 = this.g.a(r8, this.e);
        Object r10 = ((Result) BuildersKt.runBlocking(Dispatchers.getIO(), new DefaultMessageListRepository$loadFirstPageV2$result$1(r9, r6, r8, this, null))).unbox-impl();
        if (Result.isSuccess-impl(r10) == false) goto L29;
        PerfLog.end("chat_fetch_first_page_data", BuildConfig.FLAVOR);
        if (Result.isFailure-impl(r10) == false) goto L21;
        Object r11 = null;
    L22:
        if (r11 != null) goto L25;
        Log.e(TitlebarViewModel.LOG_TAG, "load first page error, result data is not ChatMessageResponse");
        Exception r12 = new Exception("unknown error");
        ErrorResult r13 = new ErrorResult(0);
        ErrorResult.access$002(r13, -1);
        ErrorResult.access$102(r13, Error.ParameterNull);
        ErrorResult.access$202(r13, 0);
        ErrorResult.access$302(r13, r12);
        ErrorResult.access$402(r13, BuildConfig.FLAVOR);
        ErrorResult.access$502(r13, "load first page error, result data is not ChatMessageResponse");
        ErrorResult.access$602(r13, BuildConfig.FLAVOR);
        ErrorResult.access$702(r13, BuildConfig.FLAVOR);
        ErrorResult.access$802(r13, 0);
        ErrorResult.access$902(r13, null);
        ErrorResult.access$1002(r13, null);
        ErrorResult.access$1102(r13, null);
        r18.onError(r13);
        return;
    L25:
        if (Result.isFailure-impl(r10) == false) goto L27;
        Object r14 = null;
    L28:
        Intrinsics.checkNotNull(r14, "null cannot be cast to non-null type com.ss.android.lark.chat.core.model.entity.ChatMessageResponse");
        r18.onSuccess((ChatMessageResponse) r14);
        return;
    L27:
        r14 = r10;
        goto L28
    L21:
        r11 = r10;
        goto L22
    L29:
        ErrorResult r15 = Result.exceptionOrNull-impl(r10);
        if (r15 == null) goto L38;
        r18.onError(r15);
        return;
    L38:
        return;
    L32:
        Exception r16 = new Exception("unknown error");
        ErrorResult r17 = new ErrorResult(0);
        ErrorResult.access$002(r17, -1);
        ErrorResult.access$102(r17, Error.ParameterNull);
        ErrorResult.access$202(r17, 0);
        ErrorResult.access$302(r17, r16);
        ErrorResult.access$402(r17, BuildConfig.FLAVOR);
        ErrorResult.access$502(r17, "chat id is null");
        ErrorResult.access$602(r17, BuildConfig.FLAVOR);
        ErrorResult.access$702(r17, BuildConfig.FLAVOR);
        ErrorResult.access$802(r17, 0);
        ErrorResult.access$902(r17, null);
        ErrorResult.access$1002(r17, null);
        ErrorResult.access$1102(r17, null);
        r18.onError(r17);
    }

    public final void e(final q<x4b.a<MessageInfo>, MessageInfo> r4) {
        Intrinsics.checkNotNullParameter(r4, "receiver");
        final com.ss.android.lark.chat.core.model.c r0 = new com.ss.android.lark.chat.core.model.c(new a(this), com.ss.android.lark.chat.core.model.a.b);
        final q3b.n r1 = this.h;
        r1.getClass();
        r1.a(new x4b.k(r1, r0, r4));
    }

    public final void d(List<Integer> r2, IGetDataCallback<Boolean> r3) {
        Intrinsics.checkNotNullParameter(r2, "missingPositions");
        Intrinsics.checkNotNullParameter(r3, "callback");
        ((q3b.d) this.i.getValue()).e(r2, r3);
    }

    public final void b(int r4, boolean r5, q<x4b.a<MessageInfo>, MessageInfo> r6) {
        Intrinsics.checkNotNullParameter(r6, "receiver");
        int r7 = Math.max(r4, -1);
        if (r7 < 0) goto L5;
        MessageFetchScene r0 = MessageFetchScene.SPECIFIED_POSITION;
    L6:
        if (r5 == false) goto L8;
        ChannelDataFetcherStrategy r8 = ChannelDataFetcherStrategy.SYNC_SERVER_DATA;
    L9:
        com.ss.android.lark.chat.core.model.c r1 = new com.ss.android.lark.chat.core.model.c(r7, 15, r0, r8);
        q3b.n r9 = this.h;
        r9.getClass();
        r9.a(new x4b.l(r9, r1, r6));
        return;
    L8:
        r8 = ChannelDataFetcherStrategy.RETURN_LOCAL_DATA;
        goto L9
    L5:
        r0 = MessageFetchScene.FIRST_SCREEN;
        goto L6
    }

    public j(q3b.m r2, v r3, fxa.b r4, final x4b.d r5, final x4b.d r6, final CallbackManager r7, String r8, MutableLiveData r9, int r10) {
        Intrinsics.checkNotNullParameter(r2, "dataStore");
        Intrinsics.checkNotNullParameter(r3, "chatContainer");
        Intrinsics.checkNotNullParameter(r4, "chatBundle");
        Intrinsics.checkNotNullParameter(r5, "backgroundExecutor");
        Intrinsics.checkNotNullParameter(r6, "workExecutor");
        Intrinsics.checkNotNullParameter(r7, "callbackManager");
        Intrinsics.checkNotNullParameter(r8, "chatId");
        Intrinsics.checkNotNullParameter(r9, "currentChatLiveData");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r9;
        this.e = r10;
        c r11 = new c();
        this.f = r11;
        this.g = r11;
        this.h = new q3b.n(r3.w(), r6, r8);
        this.i = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new DefaultMessageListRepository$firstScreenLoader$2(this, r5, r6, r7));
    }
}
