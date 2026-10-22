package com.ss.android.lark.integrator.ccm.dependency.di;

import android.content.Context;
import com.bytedance.ee.bear.bitable.card.view.cell.chatter.MentionGroupSelectPanel;
import com.ss.android.lark.pb.chats.PullChatLinkTokenRequest;
import com.ss.android.lark.pb.improto.Command;
import com.ss.android.lark.sdk.SdkSender;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Singleton
public final class w0 implements com.bytedance.ee.bear.lark.dependency.n {

    public static final class a {
    }

    static {
    }

    @Inject
    public w0() {
    }

    public final void n(Context r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "chatId");
    }

    public final void p(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "ctx");
    }

    public final void q(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
    }

    public final void o(String r4, final MentionGroupSelectPanel.afterChatterSelected.1.1 r5) {
        Intrinsics.checkNotNullParameter(r4, "chatId");
        Intrinsics.checkNotNullParameter(r5, "callback");
        ((com.bytedance.ee.bear.share.export.a) org.koin.java.a.c(com.bytedance.ee.bear.share.export.a.class, null, null, 6)).Y9().getClass();
        boolean r0 = km5.c.d();
        PullChatLinkTokenRequest.Builder r6 = new PullChatLinkTokenRequest.Builder().chat_id(r4).expired_day(0);
        if (r0 == false) goto L5;
        String r1 = "Lark";
    L6:
        PullChatLinkTokenRequest.Builder r7 = r6.app_name(r1).is_unlimited(Boolean.TRUE);
        SdkSender.sendPassThroughRequest(Command.PULL_CHAT_LINK_TOKEN, r7, new OfficeIMChatDependencyImpl$getGroupChatLinkToken$1(r5), x0.a);
        return;
    L5:
        r1 = "Feishu";
        goto L6
    }
}
