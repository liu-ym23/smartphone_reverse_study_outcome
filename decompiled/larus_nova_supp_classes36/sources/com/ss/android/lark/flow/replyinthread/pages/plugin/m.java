package com.ss.android.lark.flow.replyinthread.pages.plugin;

import androidx.fragment.app.FragmentActivity;
import com.ss.android.lark.biz.officesdk.im.share.IOfficeSDKShareScene;
import com.ss.android.lark.flow.chat.page.flow.plugin.FlowChatReadablePlugin;
import com.ss.android.lark.flow.chat.page.flow.plugin.select.FlowMessageSelectPlugin;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class m extends com.ss.android.lark.flow.chat.page.flow.plugin.b {
    public m() {
    }

    @Override // com.ss.android.lark.flow.chat.page.flow.plugin.b
    public final List<com.ss.android.lark.chat.chatwindow.biz.plugin.core.d> a(FragmentActivity r2, com.ss.android.lark.chat.chatwindow.chat.v2.component.c r3) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "chatApp");
        List<com.ss.android.lark.chat.chatwindow.biz.plugin.core.d> r4 = CollectionsKt.toMutableList(super.a(r2, r3));
        r4.add(new ReplyInThreadMsgTipsPlugin());
        r4.add(new ReplyInThreadTitleBarPlugin());
        r4.add(new ReplyInThreadKeyboardPlugin());
        r4.add(new q());
        r4.add(new FlowChatReadablePlugin());
        r4.add(new FlowMessageSelectPlugin(IOfficeSDKShareScene.REPLY_IN_THREAD));
        return r4;
    }
}
