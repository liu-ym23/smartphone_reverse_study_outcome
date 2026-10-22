package com.ss.android.lark.replyinthread.pages.component.message;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.biz.im.api.ThreadTopic;
import com.ss.android.lark.biz.im.api.y0;
import com.ss.android.lark.chat.core.model.ChannelDataFetcherStrategy;
import com.ss.android.lark.chat.core.model.MessageFetchScene;
import com.ss.android.lark.chat.core.model.PageLoader;
import com.ss.android.lark.chat.core.model.entity.ChatMessageResponse;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chatbase.BasePageStore;
import com.ss.android.lark.chatbase.model.FirstScreenLoader;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passport.signinsdk_api.base.NetworkErrorResult;
import com.ss.android.lark.threaddetail.model.d;
import com.ss.android.lark.threaddetail.model.f;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import q3b.q;
import x4b.i;
import x4b.k;
import x4b.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class ReplyInThreadRepository implements y0 {
    public final Function0<ThreadTopic> a;
    public final BasePageStore<MessageInfo, x4b.a<MessageInfo>> b;
    public final f c;
    public final Function1<ThreadTopic, d> d;
    public d e;

    public static final class a {
    }

    public static final class b implements PageLoader.c {
        public final /* synthetic */ ReplyInThreadRepository a;

        public b(ReplyInThreadRepository r1) {
            this.a = r1;
        }

        public final int getPosition() {
            return this.a.b.d;
        }
    }

    public static final class c implements PageLoader.c {
        public final /* synthetic */ ReplyInThreadRepository a;

        public c(ReplyInThreadRepository r1) {
            this.a = r1;
        }

        public final int getPosition() {
            return this.a.b.c;
        }
    }

    static {
    }

    public final boolean canLoadMore() {
        ThreadTopic r0 = (ThreadTopic) this.a.invoke();
        if (r0 != null) goto L6;
        Log.d("ReplyInThreadRepository", "Cannot load more, thread == null");
        return false;
    L6:
        int r2 = this.b.d;
        if (r2 >= (-1)) goto L9;
        return false;
    L9:
        if (r2 >= r0.getLastMsgPos()) goto L13;
        return true;
    L13:
        return false;
    }

    public final boolean canLoadPre() {
        if (((ThreadTopic) this.a.invoke()) != null) goto L7;
        Log.d("ReplyInThreadRepository", "Cannot load pre, thread == null");
        return false;
    L7:
        if (this.b.c != Integer.MAX_VALUE) goto L9;
        return false;
    L9:
        if (this.b.c <= 0) goto L13;
        return true;
    L13:
        return false;
    }

    public final void a(q<x4b.a<MessageInfo>, MessageInfo> r4) {
        Intrinsics.checkNotNullParameter(r4, "receiver");
        com.ss.android.lark.chat.core.model.c r0 = new com.ss.android.lark.chat.core.model.c(new c(this), 15);
        f r1 = this.c;
        r1.getClass();
        r1.a(new i(r1, r0, r4));
    }

    public final void c(final IGetDataCallback<ChatMessageResponse> r5) {
        Intrinsics.checkNotNullParameter(r5, "callback");
        Log.i("ReplyInThreadRepository", "loadFirstPage");
        ThreadTopic r0 = (ThreadTopic) this.a.invoke();
        if (r0 != null) goto L6;
        Exception r1 = new Exception("unknown error");
        ErrorResult r2 = new ErrorResult(0);
        ErrorResult.access$002(r2, -1);
        ErrorResult.access$102(r2, NetworkErrorResult.UNKNOWN_BIZ_CODE);
        ErrorResult.access$202(r2, 0);
        ErrorResult.access$302(r2, r1);
        ErrorResult.access$402(r2, "");
        ErrorResult.access$502(r2, "thread == null");
        ErrorResult.access$602(r2, "");
        ErrorResult.access$702(r2, "");
        ErrorResult.access$802(r2, 0);
        ErrorResult.access$902(r2, null);
        ErrorResult.access$1002(r2, null);
        ErrorResult.access$1102(r2, null);
        r5.onError(r2);
        return;
    L6:
        d r3 = this.e;
        if (r3 != null) goto L9;
        r3 = (d) this.d.invoke(r0);
        this.e = r3;
    L9:
        IGetDataCallback<com.ss.android.lark.chat.core.model.d<MessageInfo>> r4 = new ReplyInThreadRepository$loadFirstPage$1(r5);
        r3.h();
        ((FirstScreenLoader) r3).f = 15;
        r3.f(false, r4);
    }

    public final void e(q<x4b.a<MessageInfo>, MessageInfo> r4) {
        Intrinsics.checkNotNullParameter(r4, "receiver");
        com.ss.android.lark.chat.core.model.c r0 = new com.ss.android.lark.chat.core.model.c(new b(this), 15);
        f r1 = this.c;
        r1.getClass();
        r1.a(new k(r1, r0, r4));
    }

    public final void d(List<Integer> r1, IGetDataCallback<Boolean> r2) {
        y0.a.a(r1, r2);
    }

    public final void b(int r4, boolean r5, q<x4b.a<MessageInfo>, MessageInfo> r6) {
        Intrinsics.checkNotNullParameter(r6, "receiver");
        Log.i("ReplyInThreadRepository", "loadToPosition position:" + r4 + ",fromServer:" + r5);
        com.ss.android.lark.chat.core.model.c r7 = new com.ss.android.lark.chat.core.model.c(r4, 15, MessageFetchScene.SPECIFIED_POSITION, ChannelDataFetcherStrategy.SYNC_SERVER_DATA);
        f r8 = this.c;
        r8.getClass();
        r8.a(new l(r8, r7, r6));
    }

    public ReplyInThreadRepository(Function0<? extends ThreadTopic> r2, BasePageStore<MessageInfo, x4b.a<MessageInfo>> r3, f r4, Function1<? super ThreadTopic, ? extends d> r5) {
        Intrinsics.checkNotNullParameter(r2, "threadProvider");
        Intrinsics.checkNotNullParameter(r3, "pageStore");
        Intrinsics.checkNotNullParameter(r4, "pageLoader");
        Intrinsics.checkNotNullParameter(r5, "firstScreenLoaderFactory");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
