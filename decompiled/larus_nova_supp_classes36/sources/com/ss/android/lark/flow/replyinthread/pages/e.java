package com.ss.android.lark.flow.replyinthread.pages;

import com.ss.android.lark.biz.im.api.ThreadTopic;
import com.ss.android.lark.biz.im.api.s0;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.flow.replyinthread.pages.viewmodel.FlowBaseReplyInThreadViewModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class e implements s0 {
    public final /* synthetic */ FlowReplyInThreadFragment a;

    public e(FlowReplyInThreadFragment r1) {
        this.a = r1;
    }

    public final Integer a(Chat r2) {
        FlowBaseReplyInThreadViewModel r3 = this.a.r;
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r3 = null;
    L5:
        ThreadTopic r4 = (ThreadTopic) r3.getThreadTopicLiveData().getValue();
        if (r4 != null) goto L8;
        return null;
    L8:
        return Integer.valueOf(r4.getLastMsgPos());
    }
}
