package com.ss.android.lark.flow.chat.menu.provider;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.biz.im.api.OpenApp;
import com.ss.android.lark.biz.im.extension.PageType;
import com.ss.android.lark.biz.im.extension.message_action.MessageActionType;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chat.message.menu.provider.ChatReplyActionProvider;
import com.ss.android.lark.chat.utils.ReplyInThreadUtil;
import com.ss.android.lark.chat.utils.u;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class FlowReplyInThreadReplyActionProvider implements yya.m {

    public static class ReplyAction implements yya.i {
        public final yya.a a;
        public final Lazy b;

        public final Map<String, Object> R4() {
            return MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("click", "reply"), TuplesKt.to("target", "none")});
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

        public final s5c.d g() {
            return null;
        }

        public final boolean isEnable() {
            return true;
        }

        public final void onHide() {
        }

        public final void onShow() {
        }

        public final boolean isVisible() {
            y6b.c r0 = this.a.m();
            OpenApp r2 = null;
            if ((r0 instanceof y6b.c) == false) goto L5;
            y6b.c r1 = r0;
        L6:
            boolean r3 = true;
            if (r1 != null) goto L9;
        L11:
            boolean r4 = false;
        L12:
            if (r4 == false) goto L15;
            return false;
        L15:
            if (this.a.get().C().isEnable("messenger.swipe.reply") == false) goto L23;
            b r5 = (b) this.b.getValue();
            ChatReplyActionProvider.c r6 = this.a;
            if ((r6 instanceof ChatReplyActionProvider.c) == false) goto L19;
            ChatReplyActionProvider.c r7 = r6;
        L20:
            if (r7 == null) goto L68;
            r2 = r7.e();
        L68:
            return r5.a(r2);
        L19:
            r7 = null;
            goto L20
        L23:
            OpenApp r8 = this.a;
            Chat r9 = r8.getChat();
            if (r9 == null) goto L65;
            MessageInfo r10 = r8.k();
            Boolean r11 = ReplyInThreadUtil.a;
            if (r10 != null) goto L30;
        L35:
            boolean r12 = false;
        L36:
            if (r12 == true) goto L65;
            if (r8.m().h() == true) goto L65;
            if (r9.isChatable() == false) goto L65;
            if (r9.isAllowPost() == false) goto L65;
            if ((r8 instanceof ChatReplyActionProvider.c) == false) goto L50;
            r2 = (ChatReplyActionProvider.c) r8;
        L50:
            if (r2 == null) goto L64;
            OpenApp r13 = r2.e();
            if (r13 == null) goto L64;
            if (r13.getState() == null) goto L59;
            if (r13.getState() != OpenApp.State.USABLE) goto L65;
        L59:
            if (r13.getChatable() == null) goto L64;
            if (r13.getChatable() == OpenApp.Chatable.UNCHATABLE) goto L65;
        L64:
            if (u.a.a.c == true) goto L65;
        L67:
            return r3;
        L30:
            if ((r10 instanceof MessageInfo) == false) goto L35;
            if (r10.getMessage().getThreadMessageType() != Message.ThreadMessageType.THREAD_ROOT_MESSAGE) goto L35;
            r12 = true;
        L65:
            r3 = false;
            goto L67
        L9:
            if (r1.V2 != true) goto L11;
            r4 = true;
            goto L12
        L5:
            r1 = null;
            goto L6
        }

        public MessageActionType getType() {
            return MessageActionType.REPLY;
        }

        public ReplyAction(yya.a r2) {
            Intrinsics.checkNotNullParameter(r2, "actionContext");
            this.a = r2;
            this.b = LazyKt.lazy(new FlowReplyInThreadReplyActionProvider$ReplyAction$rule$2(this));
        }

        public final void d(com.ss.android.lark.chat.message.menu.c r2) {
            Intrinsics.checkNotNullParameter(r2, "actionControl");
        }

        public final Drawable getIcon(Context r3) {
            Intrinsics.checkNotNullParameter(r3, "context");
            return UDIconUtils.getIconDrawable(r3, 2131235447, UDColorUtils.getColor(r3, 2131100799));
        }

        public final String getLabel(Context r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            return UIUtils.getString(r2, 2131892131);
        }

        public final View getView(Context r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            return null;
        }

        public final void b(View r2, boolean r3) {
            Intrinsics.checkNotNullParameter(r2, "view");
            if (r3 == true) goto L5;
            return;
        L5:
            String r4 = this.a.m().getId();
            com.ss.android.lark.chat.chatwindow.chat.menu.handler.k r5 = this.a;
            if ((r5 instanceof com.ss.android.lark.chat.chatwindow.chat.menu.handler.k) == false) goto L8;
            com.ss.android.lark.chat.chatwindow.chat.menu.handler.k r6 = r5;
        L9:
            if (r6 == null) goto L12;
            r6.c(r4);
            return;
        L12:
            return;
        L8:
            r6 = null;
            goto L9
        }
    }

    public static final class a {
    }

    public static final class b {
        public final Chat a;

        public b(Chat r1) {
            this.a = r1;
        }

        public final boolean a(OpenApp r4) {
            Chat r0 = this.a;
            if (r0 != null) goto L6;
            return false;
        L6:
            if (r0.isChatable() == true) goto L9;
            return false;
        L9:
            if (this.a.isAllowPost() == true) goto L11;
            return false;
        L11:
            if (r4 == null) goto L23;
            if (r4.getState() == null) goto L18;
            if (r4.getState() == OpenApp.State.USABLE) goto L18;
            return false;
        L18:
            if (r4.getChatable() == null) goto L23;
            if (r4.getChatable() != OpenApp.Chatable.UNCHATABLE) goto L23;
            return false;
        L23:
            if (u.a.a.c == false) goto L25;
            return false;
        L25:
            return true;
        }
    }

    static {
    }

    public FlowReplyInThreadReplyActionProvider() {
    }

    public final String getTAG() {
        return "ReplyInThreadReplyActionProvider";
    }

    public final List<PageType> b() {
        return CollectionsKt.listOf(PageType.REPLY_IN_THREAD);
    }

    public final yya.i c(yya.a r2) {
        Intrinsics.checkNotNullParameter(r2, "actionContext");
        return new ReplyAction(r2);
    }
}
