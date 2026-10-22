package com.ss.android.lark.flow.replyinthread.pages.repo;

import androidx.lifecycle.MutableLiveData;
import com.larksuite.framework.callback.CallbackManager;
import com.ss.android.lark.biz.im.api.y0;
import com.ss.android.lark.biz.im.api.z0;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import com.ss.android.lark.chatbase.BasePageStore;
import com.ss.android.lark.flow.replyinthread.pages.viewmodel.FlowBaseReplyInThreadViewModel;
import com.ss.android.lark.replyinthread.pages.component.message.ReplyInThreadRepository;
import com.ss.android.lark.threaddetail.model.f;
import kotlin.jvm.internal.Intrinsics;
import x4b.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c implements z0 {
    public final v a;
    public final FlowBaseReplyInThreadViewModel b;

    public c(v r2, FlowBaseReplyInThreadViewModel r3) {
        Intrinsics.checkNotNullParameter(r2, "chatAppContainer");
        Intrinsics.checkNotNullParameter(r3, "viewModel");
        this.a = r2;
        this.b = r3;
    }

    public final y0 a(final BasePageStore r7, final d r8, d r9, final CallbackManager r10, String r11, MutableLiveData r12, int r13) {
        Intrinsics.checkNotNullParameter(r7, "pageStore");
        Intrinsics.checkNotNullParameter(r8, "backgroundExecutor");
        Intrinsics.checkNotNullParameter(r9, "workExecutor");
        Intrinsics.checkNotNullParameter(r10, "callbackManager");
        Intrinsics.checkNotNullParameter(r11, "chatId");
        Intrinsics.checkNotNullParameter(r12, "currentChatLiveData");
        if ((r7 instanceof BasePageStore) == false) goto L7;
        final f r14 = new f(this.a.K(), this.b.getThreadId(), r9);
        return new ReplyInThreadRepository(new FlowReplyInThreadRepositoryFactory$create$1(this.b.getThreadTopicLiveData()), r7, r14, new FlowReplyInThreadRepositoryFactory$create$2(r14, r7, r8, r10, this));
    L7:
        throw new IllegalStateException("Unsupported dataStore:".concat(r7.getClass().getName()));
    }
}
