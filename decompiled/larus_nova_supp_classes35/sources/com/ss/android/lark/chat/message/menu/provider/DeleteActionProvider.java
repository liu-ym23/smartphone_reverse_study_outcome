package com.ss.android.lark.chat.message.menu.provider;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.biz.im.extension.PageType;
import com.ss.android.lark.biz.im.extension.message_action.MessageActionType;
import com.ss.android.lark.chat.chatwindow.chat.menu.handler.g;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chat.utils.ChatParamUtils;
import com.ss.android.lark.chat.utils.ReplyInThreadUtil;
import com.ss.android.lark.statistics.chat.ChatHitPointNew;
import com.ss.android.lark.statistics.message.MessageHitPoint;
import com.ss.android.lark.utils.UIHelper;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import p5b.c;
import s5c.d;
import yya.i;
import yya.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class DeleteActionProvider implements m {
    public final Lazy a;

    public static final class a {
    }

    public final class b implements i {
        public final yya.a a;

        public final Map<String, Object> R4() {
            return MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("click", "delete"), TuplesKt.to("target", "none")});
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

        public final d g() {
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
            if (this.a.r() != PageType.REPLY_IN_THREAD) goto L17;
            c r0 = this.a.k();
            Boolean r1 = ReplyInThreadUtil.a;
            if (r0 != null) goto L8;
        L13:
            boolean r2 = false;
        L14:
            if (r2 == false) goto L16;
            return true;
        L16:
            return false;
        L8:
            if ((r0 instanceof MessageInfo) == false) goto L13;
            if (((MessageInfo) r0).getMessage().getThreadMessageType() != Message.ThreadMessageType.THREAD_ROOT_MESSAGE) goto L13;
            r2 = true;
            goto L14
        L17:
            return true;
        }

        public MessageActionType getType() {
            return MessageActionType.DELETE;
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
            return UDIconUtils.getIconDrawable(r3, 2131254201, UDColorUtils.getColor(r3, 2131100799));
        }

        public final String getLabel(Context r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            return UIHelper.getString(2131891662);
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
            FragmentActivity r12 = this.a.getActivity();
            final g r2 = new g(r12);
            v5b.c r13 = this.a.m();
            Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type com.ss.android.lark.chat.vo.ChatMessageVO<*>");
            final y6b.c r14 = (y6b.c) r13;
            final String r4 = r14.c;
            final Message.Type r7 = r14.getType();
            final boolean r5 = r14.isPreMessage();
            final boolean r6 = r14.U;
            com.larksuite.component.ui.dialog.i r0 = new com.larksuite.component.ui.dialog.i(r12);
            r0.j(2131891552);
            ((com.larksuite.component.ui.dialog.d) r0).c.titleLineCount(2);
            r0.n(new CharSequence[]{UIUtils.getString(r12, 2131891662)});
            ((com.larksuite.component.ui.dialog.b) r0).f = new com.ss.android.lark.chat.chatwindow.chat.menu.handler.d(r2, r14, r4, r5, r6, r7);
            ((com.larksuite.component.ui.dialog.b) r0).g.itemTextColor(2131102093);
            UDBaseDialogBuilder.ActionBuilder r15 = new UDBaseDialogBuilder.ActionBuilder();
            r15.actionResId(com.larksuite.component.ui.dialog.d.e.get(2131378548, 2131378548));
            r15.text(2131891541);
            r15.text(null);
            r15.textSize(0);
            r15.textColorRes(2131106622);
            r15.textColor(0);
            r15.bgColorRes(0);
            r15.bgDrawableRes(0);
            r15.onClickListener(null);
            ((com.larksuite.component.ui.dialog.d) r0).c.addActionButton(r15);
            r0.i();
            MessageHitPoint.a.a().sendEvent("message_delete", null);
            String r16 = r14.e;
            Map r17 = ChatParamUtils.i(r14);
            Lazy r1 = ChatHitPointNew.a;
            Intrinsics.checkNotNullParameter(r16, "chatId");
            Intrinsics.checkNotNullParameter(r17, "extraParams");
            Map<String, Object> r18 = ChatParamUtils.f(r16);
            if (r18 == null) goto L15;
            JSONObject r3 = new JSONObject(r18);
            Iterator r19 = r17.entrySet().iterator();
        L10:
            if (r19.hasNext() == false) goto L12;
            Map.Entry r110 = (Map.Entry) r19.next();
            r3.put((String) r110.getKey(), r110.getValue());
            goto L10
        L12:
            ChatHitPointNew.d().sendEvent("im_msg_delete_confirm_view", r3);
            return;
        }
    }

    static {
    }

    public final String getTAG() {
        return "DeleteActionProvider";
    }

    public final List<PageType> b() {
        return (List) this.a.getValue();
    }

    public DeleteActionProvider() {
        this.a = LazyKt.lazy(DeleteActionProvider$supportedPageTypes$2.INSTANCE);
    }
}
