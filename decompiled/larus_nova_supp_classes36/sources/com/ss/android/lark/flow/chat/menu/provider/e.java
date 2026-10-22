package com.ss.android.lark.flow.chat.menu.provider;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.larksuite.component.ui.toast.LKUIToast;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.biz.im.extension.PageType;
import com.ss.android.lark.biz.im.extension.message_action.MessageActionType;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chat.entity.message.content.StickerContent;
import com.ss.android.lark.chat.utils.ReplyInThreadUtil;
import com.ss.android.lark.chat.utils.y0;
import com.ss.android.lark.chatwindow.statistics.ChatWindowHitPoint;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.flow.chat.FlowChatModule;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import z5c.p3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class e implements yya.m {

    public static final class a {
    }

    public final class b implements yya.i {
        public final yya.a a;
        public final Lazy b;

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

        public final s5c.d g() {
            s5c.a r0 = z5c.r.g;
            s5c.a r1 = p3.d;
            r0.getClass();
            return s5c.d.b.b(r0, r1);
        }

        public final boolean isVisible() {
            if (this.a.l() != Message.Type.DOUBAO) goto L6;
            return false;
        L6:
            MessageInfo r0 = this.a.k();
            if ((r0 instanceof MessageInfo) == false) goto L9;
            MessageInfo r1 = r0;
        L11:
            if (r1 != null) goto L13;
            return true;
        L13:
            mya.b r2 = (mya.b) this.b.getValue();
            if (r2 == null) goto L17;
            return r2.k();
        L17:
            return !ReplyInThreadUtil.a(r1);
        L9:
            r1 = null;
            goto L11
        }

        public MessageActionType getType() {
            return MessageActionType.FORWARD;
        }

        public b(yya.a r2) {
            Intrinsics.checkNotNullParameter(r2, "actionContext");
            this.a = r2;
            this.b = LazyKt.lazy(new FlowChatForwardActionProvider$ForwardMessageAction$messageActionHandler$2(this));
        }

        public final void d(com.ss.android.lark.chat.message.menu.c r2) {
            Intrinsics.checkNotNullParameter(r2, "actionControl");
        }

        public final Drawable getIcon(Context r3) {
            Intrinsics.checkNotNullParameter(r3, "context");
            return UDIconUtils.getIconDrawable(r3, 2131254801, UDColorUtils.getColor(r3, 2131100799));
        }

        public final String getLabel(Context r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            return UIUtils.getString(r2, 2131891907);
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
            int r12 = y0.a;
            if (y0.c(this.a.getChat()) == true) goto L9;
            y0.g(this.a.getContext());
            return;
        L9:
            MessageInfo r13 = this.a.k();
            com.ss.android.lark.chat.message.menu.context.b r0 = null;
            if ((r13 instanceof MessageInfo) == false) goto L12;
            MessageInfo r14 = r13;
        L13:
            if (r14 != null) goto L15;
            return;
        L15:
            Message r4 = r14.getMessage();
            Context r2 = this.a.getContext();
            boolean r15 = false;
            if (r4 != null) goto L19;
        L28:
            boolean r1 = true;
        L29:
            if (r1 == false) goto L31;
            return;
        L31:
            if (r4 != null) goto L34;
        L40:
            yya.a r3 = this.a;
            if ((r3 instanceof com.ss.android.lark.chat.message.menu.context.b) == false) goto L43;
            r0 = (com.ss.android.lark.chat.message.menu.context.b) r3;
        L43:
            if (r0 == null) goto L49;
            m2b.a r5 = r0.f;
            if (r5 == null) goto L49;
            if (r5.I() != true) goto L49;
            r15 = true;
        L49:
            if (r15 == true) goto L53;
            String r16 = r4.getSourceId();
            if (r16 == null) goto L53;
        L54:
            String r6 = r16;
            int r17 = FlowChatModule.d;
            egb.d.a(FlowChatModule.a.a().a().getForwardDependency(), r2, 1, r4, r6, false, this.a.d(), 80);
            return;
        L53:
            r16 = "";
            goto L54
        L34:
            if (r4.getType() != Message.Type.STICKER) goto L40;
            if (r4.getContent() == null) goto L40;
            ChatWindowHitPoint.a();
            goto L40
        L19:
            if (r4.getType() != Message.Type.STICKER) goto L26;
            StickerContent r7 = r4.getContent();
            if (r7 == null) goto L26;
            if (r7.isPaid() == true) goto L26;
            LKUIToast.show(r2, 2131890423);
        L26:
            r1 = false;
            goto L29
        L12:
            r14 = null;
            goto L13
        }
    }

    static {
    }

    public e() {
    }

    public final String getTAG() {
        return "ChatForwardActionProvider";
    }

    public final List<PageType> b() {
        if (FeatureGatingModule.getFeatureGatingService().isEnable("messenger.combine_forward.forward") == false) goto L6;
        return CollectionsKt.listOf(new PageType[]{PageType.CHAT_WINDOW, PageType.CHAT_THREAD, PageType.MERGE_FORWARD});
    L6:
        return CollectionsKt.listOf(new PageType[]{PageType.CHAT_WINDOW, PageType.CHAT_THREAD});
    }

    public final yya.i c(yya.a r2) {
        Intrinsics.checkNotNullParameter(r2, "actionContext");
        return new b(r2);
    }
}
