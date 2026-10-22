package com.ss.android.lark.flow.replyinthread.pages.repo;

import androidx.lifecycle.MutableLiveData;
import com.larksuite.framework.callback.CallbackManager;
import com.ss.android.lark.biz.im.api.y0;
import com.ss.android.lark.biz.im.api.z0;
import com.ss.android.lark.chatbase.BasePageStore;
import com.ss.android.lark.flow.replyinthread.pages.viewmodel.MergeForwardReplyInThreadViewModel;
import kotlin.jvm.internal.Intrinsics;
import x4b.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b implements z0 {
    public final MergeForwardReplyInThreadViewModel a;

    public b(MergeForwardReplyInThreadViewModel r2) {
        Intrinsics.checkNotNullParameter(r2, "viewModel");
        this.a = r2;
    }

    public final y0 a(BasePageStore r7, d r8, d r9, CallbackManager r10, String r11, MutableLiveData r12, int r13) {
        Intrinsics.checkNotNullParameter(r7, "pageStore");
        Intrinsics.checkNotNullParameter(r8, "backgroundExecutor");
        Intrinsics.checkNotNullParameter(r9, "workExecutor");
        Intrinsics.checkNotNullParameter(r10, "callbackManager");
        Intrinsics.checkNotNullParameter(r11, "chatId");
        Intrinsics.checkNotNullParameter(r12, "currentChatLiveData");
        if ((r7 instanceof BasePageStore) == false) goto L7;
        final bib.c r14 = new bib.c(new bib.b(this.a.getParentMessageContent(), this.a.getThreadId(), r9), r7, r8, new x4b.b("reply-in-thread-vm"), r10);
        return new FlowMergeForwardReplyInThreadRepositoryFactory$create$1(r14);
    L7:
        throw new IllegalStateException("Unsupported dataStore:".concat(r7.getClass().getName()));
    }
}
