package com.ss.android.lark.chat.chatwindow.chat.message.actionimpl;

import android.app.Dialog;
import android.content.Context;
import com.ss.android.lark.appreciablelib.AppreciableKit;
import com.ss.android.lark.chameleon.api.PreloadConfig;
import com.ss.android.lark.chat.chatwindow.chat.menu.reaction.ReactionEventDispatcher;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.w;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.y;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.reaction.ReactionInfo;
import com.ss.android.lark.chatbase.l;
import com.ss.android.lark.dto.chat.ProfileSource;
import com.ss.android.lark.forsetiutils.ForsetiConfig;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.reaction.widget.detailwindow.ReactionPopupFacade;
import com.ss.android.lark.statistics.Statistics;
import com.ss.android.lark.statistics.message.MessageHitPoint;
import com.ss.android.lark.statistics.reaction.ReactionHitPoint;
import h7b.m;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import w4b.b0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class MessageReactionHandlerImpl implements mya.d {
    public final m2b.a a;
    public y b;

    public static final class a {
    }

    public static final class b implements ReactionPopupFacade.c {
        public final /* synthetic */ ReactionPopupFacade a;
        public final /* synthetic */ MessageReactionHandlerImpl b;
        public final /* synthetic */ Chat c;

        public b(ReactionPopupFacade r1, MessageReactionHandlerImpl r2, Chat r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void a(String r4) {
            Map<Integer, WeakReference<Dialog>> r0 = l7b.a.a;
            l7b.a.a(this.a.getDialog());
            b0 r1 = ChatCoreModule.a().getProfileDependency();
            Context r2 = this.b.a.getContext();
            if (ForsetiConfig.b() == false) goto L5;
            r2 = r2.getApplicationContext();
        L5:
            ProfileSource.a r3 = new ProfileSource.a();
            r3.e = r4;
            r3.d = this.c.getId();
            r3.b = 4;
            r1.e(r2, new ProfileSource(r3));
        }
    }

    static {
    }

    public MessageReactionHandlerImpl(s2b.d r2) {
        Intrinsics.checkNotNullParameter(r2, "chatContext");
        this.a = r2;
    }

    public final f5b.b c(String r5) {
        y r0 = this.b;
        Object r1 = null;
        if (r0 == null) goto L9;
        l<f5b.b> r2 = r0.stream();
        if (r2 == null) goto L9;
        l<f5b.b> r3 = r2.query(r5);
        if (r3 == null) goto L9;
        List<f5b.b> r4 = r3.toList();
    L10:
        if (r4 == null) goto L22;
        Iterator<T> r6 = r4.iterator();
    L13:
        if (r6.hasNext() == false) goto L18;
        Object r7 = r6.next();
        if (Intrinsics.areEqual(((f5b.b) r7).getId(), r5) == false) goto L13;
        r1 = r7;
    L18:
        return (f5b.b) r1;
    L22:
        return null;
    L9:
        r4 = null;
        goto L10
    }

    public final void t(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "messageId");
        Intrinsics.checkNotNullParameter(r4, "reactionKey");
        f5b.b r0 = c(r3);
        if (r0 != null) goto L6;
        Log.e("MessageReactionHandler", "click more reaction error: message info is null, message id = " + r3 + ", reaction key = " + r4);
        return;
    L6:
        Chat r5 = this.a.getChat();
        if (r5 != null) goto L9;
        return;
    L9:
        List<ReactionInfo> r1 = r0.getReactionInfoList();
        this.a.d();
        ReactionPopupFacade r6 = ReactionPopupFacade.S90(k7b.a.b(r1), r4, false);
        r6.f = new b(r6, this, r5);
        r6.U90(this.a.getContext().getSupportFragmentManager());
    }

    public final void d(String r18, String r19, int r20) {
        Intrinsics.checkNotNullParameter(r18, "messageId");
        Intrinsics.checkNotNullParameter(r19, "reactionKey");
        f5b.b r14 = c(r18);
        if (r14 != null) goto L6;
        Log.e("MessageReactionHandler", "click reaction error: message info is null, message id = " + r18 + ", reaction key = " + r19 + ", reaction source = " + r20);
        return;
    L6:
        String r1 = ChatCoreModule.a().getLoginDependency().getUserId();
        Chat r16 = this.a.getChat();
        if (r16 != null) goto L9;
        return;
    L9:
        String r2 = r16.getAnonymousId();
        if (r2 != null) goto L12;
    L17:
        boolean r13 = m.a(r14.getReactionInfoList(), r19, r1);
        boolean r4 = this.a.isSecretChat();
        if (this.a.getChat() == null) goto L20;
        Chat r3 = this.a.getChat();
        Intrinsics.checkNotNull(r3);
        int r5 = r3.getType().getNumber();
    L21:
        final String r6 = ReactionHitPoint.d(r19, r18, r13, r4, r5, r14.getMessage().getType().getNumber());
        if ((!r13) == false) goto L31;
        Message r7 = r14.getMessage();
        long r8 = System.currentTimeMillis() - 0;
        if (r8 <= PreloadConfig.DEFAULT_TIMEOUT) goto L26;
        int r9 = 0;
    L27:
        int r15 = r9;
        String r10 = r19;
        MessageHitPoint.d(w.a(this.a).j0(), r7.getId(), Integer.valueOf(r7.getType().getNumber()), r7.getChatId(), r19, Integer.valueOf(r20), r15, this.a.getChat());
        if (r14.getMessage().getType() != Message.Type.RED_PACKET) goto L30;
        y5c.a r11 = y5c.a.a;
        Statistics.sendEvent("mobile_hongbao_reaction");
    L30:
        LinkedHashMap<ReactionEventDispatcher.a, ReactionEventDispatcher.LifecycleBoundObserver> r12 = ReactionEventDispatcher.a;
        ReactionEventDispatcher.a(r16.getId(), r14, r10);
    L32:
        Intrinsics.checkNotNullParameter(r6, "key");
        Intrinsics.checkNotNullParameter("sdk_cost", "span");
        AppreciableKit.Companion.getInstance().spanStart(r6, "sdk_cost");
        k2c.a.b().Ya(r18, r10, r13, new MessageReactionHandlerImpl$onReaction$1(r6, this));
        return;
    L26:
        r9 = (int) r8;
        goto L27
    L31:
        r10 = r19;
        goto L32
    L20:
        r5 = 0;
        goto L21
    L12:
        if (r2.length() <= 0) goto L14;
        boolean r17 = true;
    L15:
        if (r17 == false) goto L17;
        r1 = r2;
        goto L17
    L14:
        r17 = false;
        goto L15
    }
}
