package com.ss.android.lark.flow.chat.menu.provider;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.biz.im.api.ThreadTopic;
import com.ss.android.lark.biz.im.extension.PageType;
import com.ss.android.lark.biz.im.extension.message_action.MessageActionType;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.utils.ReplyInThreadUtil;
import com.ss.android.lark.chat.utils.y0;
import com.ss.android.lark.flow.chat.FlowChatModule;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class n implements yya.m {

    public static final class a {
    }

    public final class b implements yya.i {
        public final yya.a a;

        public final Map<String, Object> R4() {
            return MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("click", "forward"), TuplesKt.to("target", "none")});
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
            if (this.a.r() != PageType.THREAD_WINDOW) goto L20;
            y6b.a r0 = this.a.m();
            if ((r0 instanceof y6b.a) == false) goto L7;
            y6b.a r1 = r0;
        L9:
            if (r1 == null) goto L21;
            String r2 = r1.M();
            if (r2 != null) goto L13;
            return false;
        L13:
            if (r2.length() <= 0) goto L15;
            boolean r3 = true;
        L16:
            if (r3 != true) goto L23;
            return true;
        L23:
            return false;
        L15:
            r3 = false;
            goto L16
        L21:
            return false;
        L7:
            r1 = null;
            goto L9
        L20:
            return ReplyInThreadUtil.a(this.a.k());
        }

        public MessageActionType getType() {
            return MessageActionType.FORWARD_REPLY_IN_THREAD;
        }

        public b(yya.a r2) {
            Intrinsics.checkNotNullParameter(r2, "actionContext");
            this.a = r2;
        }

        public final void d(com.ss.android.lark.chat.message.menu.c r2) {
            Intrinsics.checkNotNullParameter(r2, "actionControl");
        }

        public final Drawable getIcon(Context r3) {
            Intrinsics.checkNotNullParameter(r3, "context");
            return UDIconUtils.getIconDrawable(r3, 2131235449, UDColorUtils.getColor(r3, 2131100799));
        }

        public final String getLabel(Context r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            return UIUtils.getString(r2, 2131891382);
        }

        public final View getView(Context r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            return null;
        }

        public final void b(View r10, boolean r11) {
            Intrinsics.checkNotNullParameter(r10, "view");
            if (r11 == true) goto L5;
            return;
        L5:
            p5b.c r12 = this.a.k();
            String r13 = null;
            if (r12 == null) goto L8;
            p5b.b r14 = r12.getMessage();
        L9:
            boolean r1 = false;
            if ((r14 instanceof Message) == false) goto L17;
            Message r15 = (Message) r14;
            if (r15.getType() != Message.Type.MERGE_FORWARD) goto L17;
            if (r15.getContent().getThread() == null) goto L17;
            UDToast.show(this.a.getContext(), 2131891223);
            boolean r16 = true;
        L18:
            if (r16 == false) goto L20;
            return;
        L20:
            int r17 = y0.a;
            if (y0.c(this.a.getChat()) == true) goto L24;
            y0.g(this.a.getContext());
            return;
        L24:
            y6b.a r18 = this.a.m();
            if ((r18 instanceof y6b.a) == false) goto L27;
            y6b.a r19 = r18;
        L28:
            String r0 = "";
            if (r19 == null) goto L34;
            String r110 = r19.M();
            if (r110 == null) goto L34;
            String r6 = r110;
        L35:
            new ArrayList().add(r6);
            Message r111 = this.a.g();
            if (r111 != null) goto L38;
            return;
        L38:
            ThreadTopic r3 = (ThreadTopic) this.a.m().n(ThreadTopic.class);
            if (r3 == null) goto L41;
            r13 = r3.getOwnerId();
        L41:
            if (r13 != null) goto L44;
            r13 = "";
        L44:
            if (r13.length() != 0) goto L46;
            r1 = true;
        L46:
            if (r1 == false) goto L52;
            String r112 = r111.getFromId();
            if (r112 == null) goto L51;
            r0 = r112;
        L51:
            String r7 = r0;
        L53:
            int r113 = FlowChatModule.d;
            FlowChatModule.a.a().a().getForwardDependency().c(this.a.getContext(), this.a.getChat(), r6, r7, this.a.d());
            return;
        L52:
            r7 = r13;
        L34:
            r6 = "";
            goto L35
        L27:
            r19 = null;
        L17:
            r16 = false;
            goto L18
        L8:
            r14 = null;
            goto L9
        }
    }

    static {
    }

    public n() {
    }

    public final List<PageType> b() {
        return CollectionsKt.listOf(new PageType[]{PageType.CHAT_WINDOW, PageType.MERGE_FORWARD, PageType.THREAD_WINDOW});
    }

    public final String getTAG() {
        return "ForwardReplyInThreadActionProvider";
    }

    public final yya.i c(yya.a r2) {
        Intrinsics.checkNotNullParameter(r2, "actionContext");
        return new b(r2);
    }
}
