package com.ss.android.lark.chat.chatwindow.chat.menu.handler;

import androidx.fragment.app.FragmentActivity;
import com.ss.android.lark.appreciablelib.AppreciableKit;
import com.ss.android.lark.chameleon.api.PreloadConfig;
import com.ss.android.lark.chat.base.model.dispatch.ActionDispatcher;
import com.ss.android.lark.chat.chatwindow.chat.menu.reaction.ReactionEventDispatcher;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.statistics.Statistics;
import com.ss.android.lark.statistics.message.MessageHitPoint;
import com.ss.android.lark.statistics.reaction.ReactionHitPoint;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class ReactionHandler {
    public final FragmentActivity a;
    public final String b;
    public final m2b.a c;

    public ReactionHandler(FragmentActivity r1, String r2, m2b.a r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        r3.d();
    }

    public final void a(String r17, String r18, int r19) {
        f5b.b r14 = (f5b.b) ActionDispatcher.from(this.a).dispatchSyncQuery(new com.ss.android.lark.chat.base.model.dispatch.b(r17));
        if (r14 != null) goto L6;
        Log.e("ReactionHandler", "click reaction error: message info is null, message id = " + r17 + ", reaction key = " + r18 + ", reaction source = " + r19);
        return;
    L6:
        String r1 = ChatCoreModule.a().getLoginDependency().getUserId();
        m2b.a r2 = this.c;
        if (r2 == null) goto L9;
        Chat r3 = r2.getChat();
    L10:
        if (r3 == null) goto L16;
        String r4 = r3.getAnonymousId();
        if (r4 == null) goto L16;
        if (r4.isEmpty() == true) goto L16;
        r1 = r4;
    L16:
        boolean r13 = h7b.m.a(r14.getReactionInfoList(), r18, r1);
        boolean r5 = this.c.isSecretChat();
        if (this.c.getChat() == null) goto L19;
        int r6 = this.c.getChat().getType().getNumber();
    L20:
        final String r7 = ReactionHitPoint.d(r18, r17, r13, r5, r6, r14.getMessage().getType().getNumber());
        if ((!r13) == false) goto L30;
        Message r8 = r14.getMessage();
        long r9 = System.currentTimeMillis() - 0;
        if (r9 <= PreloadConfig.DEFAULT_TIMEOUT) goto L25;
        int r10 = 0;
    L26:
        int r15 = r10;
        String r11 = r18;
        MessageHitPoint.d(com.ss.android.lark.chat.chatwindow.chat.v2.push.w.a(this.c).j0(), r8.getId(), Integer.valueOf(r8.getType().getNumber()), r8.getChatId(), r18, Integer.valueOf(r19), r15, this.c.getChat());
        if (r14.getMessage().getType() != Message.Type.RED_PACKET) goto L29;
        y5c.a r12 = y5c.a.a;
        Statistics.sendEvent("mobile_hongbao_reaction");
    L29:
        LinkedHashMap<ReactionEventDispatcher.a, ReactionEventDispatcher.LifecycleBoundObserver> r16 = ReactionEventDispatcher.a;
        ReactionEventDispatcher.a(this.b, r14, r11);
    L31:
        Intrinsics.checkNotNullParameter(r7, "key");
        Intrinsics.checkNotNullParameter("sdk_cost", "span");
        AppreciableKit.Companion.getInstance().spanStart(r7, "sdk_cost");
        k2c.a.b().Ya(r17, r11, r13, new AnonymousClass1(this, r7));
        return;
    L25:
        r10 = (int) r9;
        goto L26
    L30:
        r11 = r18;
        goto L31
    L19:
        r6 = 0;
        goto L20
    L9:
        r3 = null;
        goto L10
    }
}
