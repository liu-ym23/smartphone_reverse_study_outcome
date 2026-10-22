package com.ss.android.lark.chat.message.menu.provider;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.bytedance.lark.pb.basic.v1.Message;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.biz.im.api.OpenApp;
import com.ss.android.lark.biz.im.api.l1;
import com.ss.android.lark.biz.im.extension.PageType;
import com.ss.android.lark.biz.im.extension.message_action.MessageActionType;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chat.utils.ReplyInThreadUtil;
import com.ss.android.lark.statistics.chat.ChatHitPointExtraParams;
import java.util.List;
import java.util.Map;
import jdb.g;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import s5c.d;
import v5b.c;
import yya.i;
import yya.m;
import z5c.p3;
import z5c.r;
import z5c.t3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class GoToReplyInThreadActionProvider implements m {
    public static final /* synthetic */ int a = 0;

    public final class GoToReplyInThreadMessageAction implements i {
        public final yya.a a;
        public final boolean b;
        public final boolean c;
        public final Lazy d;
        public final /* synthetic */ GoToReplyInThreadActionProvider e;

        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[ReplyInThreadUtil.ReplyOptimizeFGState.values().length];
                r0[ReplyInThreadUtil.ReplyOptimizeFGState.ONLINE_STATE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
            L11:
                r0[ReplyInThreadUtil.ReplyOptimizeFGState.EXP1_STATE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
            L15:
                r0[ReplyInThreadUtil.ReplyOptimizeFGState.EXP2_STATE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
            L6:
                a = r0;
            }
        }

        public final Map<String, Object> R4() {
            return null;
        }

        public final boolean c() {
            return false;
        }

        public final Integer e() {
            return null;
        }

        public final boolean f() {
            return false;
        }

        public final boolean isEnable() {
            return true;
        }

        public final void onHide() {
        }

        public final void onShow() {
        }

        public final d g() {
            c r0 = this.a.m();
            ReplyInThreadUtil.ReplyOptimizeFGState r1 = ReplyInThreadUtil.e((g) this.d.getValue(), this.a.getChat());
            int r2 = a.a[r1.ordinal()];
            if (r2 == 1) goto L13;
            if (r2 != 2) goto L7;
        L11:
            ChatHitPointExtraParams.Click r3 = ChatHitPointExtraParams.Click.REPLY_IN_THREAD;
        L17:
            return r3.plus(p3.g).plus(t3.c.a(r0.getId()));
        L7:
            if (r2 == 3) goto L11;
            throw new NoWhenBranchMatchedException();
        L13:
            if (this.b == false) goto L15;
            r3 = r.q;
            goto L17
        L15:
            r3 = r.p;
            goto L17
        }

        public final boolean isVisible() {
            GoToReplyInThreadActionProvider r0 = this.e;
            ChatReplyActionProvider.c r1 = this.a;
            int r2 = GoToReplyInThreadActionProvider.a;
            r0.getClass();
            ChatCoreModule.a().getChatDependency().v(r1, Message.DisabledAction.Action.REPLY_IN_THREAD);
            c r3 = r1.m();
            Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.ss.android.lark.chat.vo.ChatMessageVO<*>");
            if (ReplyInThreadUtil.b((y6b.c) r3) == true) goto L49;
            Chat r4 = r1.getChat();
            if (r4 != null) goto L9;
        L19:
            boolean r5 = false;
        L21:
            if (r5 == false) goto L46;
            Chatter r6 = r1.q();
            if (r6 != null) goto L26;
        L28:
            boolean r7 = false;
        L29:
            if (r7 == true) goto L46;
            Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type com.ss.android.lark.chat.message.menu.provider.ChatReplyActionProvider.ReplyContext");
            OpenApp r8 = r1.e();
            if (r8 != null) goto L35;
        L43:
            boolean r9 = false;
        L45:
            if (r9 == false) goto L46;
            return true;
        L35:
            if (r8.getState() == null) goto L40;
            if (r8.getState() != OpenApp.State.USABLE) goto L43;
        L40:
            if (r8.getChatable() != null) goto L42;
        L44:
            r9 = true;
            goto L45
        L42:
            if (r8.getChatable() != OpenApp.Chatable.UNCHATABLE) goto L44;
        L26:
            if (r6.isDimission() != true) goto L28;
            r7 = true;
        L46:
            return false;
        L9:
            if (r4.isSuper() == true) goto L19;
            if (r4.isOnCall() == true) goto L19;
            if (r4.isChatable() == false) goto L19;
            if (r4.isAllowPost() == false) goto L19;
            r5 = true;
            goto L21
        L49:
            return true;
        }

        public MessageActionType getType() {
            return MessageActionType.REPLY_IN_THREAD;
        }

        public final void d(com.ss.android.lark.chat.message.menu.c r2) {
            Intrinsics.checkNotNullParameter(r2, "actionControl");
        }

        public final Drawable getIcon(Context r3) {
            Intrinsics.checkNotNullParameter(r3, "context");
            return UDIconUtils.getIconDrawable(r3, 2131255999, UDColorUtils.getColor(r3, 2131100799));
        }

        public final String getLabel(Context r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            Chat r3 = this.a.getChat();
            ReplyInThreadUtil.ReplyOptimizeFGState r4 = ReplyInThreadUtil.e((g) this.d.getValue(), r3);
            int r5 = a.a[r4.ordinal()];
            if (r5 == 1) goto L15;
            if (r5 == 2) goto L13;
            if (r5 != 3) goto L11;
            return UIUtils.getString(this.a.getContext(), 2131891290);
        L11:
            throw new NoWhenBranchMatchedException();
        L13:
            return UIUtils.getString(this.a.getContext(), 2131891302);
        L15:
            if (this.b == false) goto L17;
        L20:
            String r6 = UIUtils.getString(this.a.getContext(), 2131891393);
            Intrinsics.checkNotNull(r6);
            return r6;
        L17:
            if (this.c == true) goto L20;
            String r7 = UIUtils.getString(this.a.getContext(), 2131891386);
            Intrinsics.checkNotNull(r7);
            return r7;
        }

        public final View getView(Context r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            return null;
        }

        public GoToReplyInThreadMessageAction(GoToReplyInThreadActionProvider r4, yya.a r5) {
            Intrinsics.checkNotNullParameter(r5, "actionContext");
            this.e = r4;
            this.a = r5;
            p5b.c r6 = r5.k();
            if ((r6 instanceof MessageInfo) == false) goto L5;
            MessageInfo r7 = (MessageInfo) r6;
        L6:
            this.b = ReplyInThreadUtil.a(r7);
            if (r7 == null) goto L14;
            com.ss.android.lark.chat.entity.message.Message r8 = r7.getMessage();
            if (r8.getSyncToChatMessageType() != com.ss.android.lark.chat.entity.message.Message.SyncToChatMessageType.SYNC_TO_CHAT_TARGET_MESSAGE) goto L14;
            if (r8.getSyncToChatThreadRootId() == 0) goto L14;
            boolean r9 = true;
        L15:
            this.c = r9;
            this.d = LazyKt.lazy(new GoToReplyInThreadActionProvider$GoToReplyInThreadMessageAction$fgService$2(this));
            return;
        L14:
            r9 = false;
            goto L15
        L5:
            r7 = null;
            goto L6
        }

        public final void b(View r9, boolean r10) {
            Intrinsics.checkNotNullParameter(r9, "view");
            if (r10 == true) goto L5;
            return;
        L5:
            c r11 = this.a.m();
            Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type com.ss.android.lark.chat.vo.ChatMessageVO<*>");
            y6b.c r12 = (y6b.c) r11;
            String r13 = r12.Q1;
            if (r13 != null) goto L8;
        L11:
            boolean r14 = true;
        L12:
            if (r14 == false) goto L19;
            long r3 = r12.G1;
            if (r12.H1 == com.ss.android.lark.chat.entity.message.Message.SyncToChatMessageType.SYNC_TO_CHAT_TARGET_MESSAGE) goto L16;
        L18:
            String r4 = r12.c;
        L20:
            yya.a r5 = this.a;
            View r6 = r5.a;
            String r15 = r12.e;
            Fragment r7 = r5.d();
            Boolean r8 = ReplyInThreadUtil.a;
            Intrinsics.checkNotNullParameter(r6, "view");
            Intrinsics.checkNotNullParameter(r15, "chatId");
            Intrinsics.checkNotNullParameter(r6, "view");
            Intrinsics.checkNotNullParameter(r15, "chatId");
            l1.a r0 = new l1.a();
            r0.e = r4;
            r0.l = r15;
            r0.n = !r14;
            r0.o = false;
            r0.d = false;
            l1 r16 = new l1(r0);
            Context r17 = r6.getContext();
            Intrinsics.checkNotNull(r16);
            ReplyInThreadUtil.c(r17, r16, r7);
            return;
        L16:
            if (r3 == 0) goto L18;
            r4 = String.valueOf(r3);
            goto L20
        L19:
            r4 = r12.Q1;
            goto L20
        L8:
            if (r13.length() == 0) goto L11;
            r14 = false;
            goto L12
        }
    }

    public static final class a {
    }

    static {
    }

    public GoToReplyInThreadActionProvider() {
    }

    public final String getTAG() {
        return "GoToReplyInThreadAction";
    }

    public final List<PageType> b() {
        return CollectionsKt.listOf(PageType.CHAT_WINDOW);
    }

    public final i c(yya.a r2) {
        Intrinsics.checkNotNullParameter(r2, "actionContext");
        return new GoToReplyInThreadMessageAction(this, r2);
    }
}
