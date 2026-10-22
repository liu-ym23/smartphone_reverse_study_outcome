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
import com.ss.android.lark.chat.utils.y0;
import com.ss.android.lark.chatwindow.statistics.ChatWindowHitPoint;
import com.ss.android.lark.flow.chat.FlowChatModule;
import com.ss.android.lark.log.Log;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import z5c.p3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class s implements yya.m {

    public static final class a {
    }

    public final class b implements yya.i {
        public final yya.a a;

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
            return true;
        }

        public MessageActionType getType() {
            return MessageActionType.FORWARD;
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

        public final void b(View r12, boolean r13) {
            Intrinsics.checkNotNullParameter(r12, "view");
            if (r13 == true) goto L5;
            return;
        L5:
            int r14 = y0.a;
            if (y0.c(this.a.getChat()) == true) goto L9;
            y0.g(this.a.getContext());
            return;
        L9:
            MessageInfo r15 = this.a.k();
            y6b.c r0 = null;
            if ((r15 instanceof MessageInfo) == false) goto L12;
            MessageInfo r16 = r15;
        L14:
            if (r16 != null) goto L17;
            Log.e("ReplyInThreadForward", "MessageInfo is null");
            return;
        L17:
            v5b.c r1 = this.a.m();
            if ((r1 instanceof y6b.c) == false) goto L20;
            r0 = (y6b.c) r1;
        L20:
            boolean r2 = false;
            if (r0 != null) goto L23;
        L25:
            boolean r8 = false;
        L26:
            Message r6 = r16.getMessage();
            Log.i("ReplyInThreadForward", "forward root message");
            Context r4 = this.a.getContext();
            if (r6 != null) goto L30;
        L39:
            r2 = true;
        L40:
            if (r2 == true) goto L53;
            if (r6 != null) goto L45;
        L48:
            int r17 = FlowChatModule.d;
            egb.e r3 = FlowChatModule.a.a().a().getForwardDependency();
            String r18 = r6.getSourceId();
            if (r18 != null) goto L51;
            r18 = "";
        L51:
            egb.d.a(r3, r4, 9, r6, r18, r8, this.a.d(), 64);
            return;
        L45:
            if (r6.getType() != Message.Type.STICKER) goto L48;
            ChatWindowHitPoint.a();
            goto L48
        L53:
            return;
        L30:
            if (r6.getType() != Message.Type.STICKER) goto L40;
            StickerContent r19 = r6.getContent();
            if (r19 == null) goto L40;
            if (r19.isPaid() == true) goto L40;
            LKUIToast.show(r4, 2131890423);
            goto L39
        L23:
            if (r0.Y() != true) goto L25;
            r8 = true;
            goto L26
        L12:
            r16 = null;
            goto L14
        }
    }

    static {
    }

    public s() {
    }

    public final String getTAG() {
        return "ReplyInThreadForward";
    }

    public final List<PageType> b() {
        return CollectionsKt.listOf(PageType.REPLY_IN_THREAD);
    }

    public final yya.i c(yya.a r2) {
        Intrinsics.checkNotNullParameter(r2, "actionContext");
        return new b(r2);
    }
}
