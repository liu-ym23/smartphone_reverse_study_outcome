package com.ss.android.lark.flow.chat.menu.provider;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.biz.im.extension.PageType;
import com.ss.android.lark.biz.im.extension.message_action.MessageActionType;
import com.ss.android.lark.chat.chatwindow.chat.menu.handler.t;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.service.impl.MessageTenantConfService;
import com.ss.android.lark.chat.utils.r0;
import com.ss.android.lark.compose.foundation.toast.FlowToast;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import com.ss.android.lark.utils.UIHelper;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class FlowChatRecallActionProvider implements yya.m {
    public static final Lazy<List<PageType>> a = null;

    public static final class a {
    }

    public static final class b extends t {
        public b(FragmentActivity r1) {
            super(r1);
        }

        public final void a(FragmentActivity r2, String r3, boolean r4) {
            Intrinsics.checkNotNullParameter(r2, "context");
            Intrinsics.checkNotNullParameter(r3, INotificationHitPoint.NoticeType.MESSAGE);
            if (r4 == false) goto L5;
            FlowToast.d(r2, r3);
            return;
        L5:
            FlowToast.e(r2, r3, 2131235476);
        }
    }

    public final class c implements yya.i {
        public final yya.a a;
        public final Lazy b;
        public final Lazy c;
        public final Lazy d;

        public final Map<String, Object> R4() {
            return MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("click", "withdraw"), TuplesKt.to("target", "none")});
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

        public final void onHide() {
        }

        public final void onShow() {
        }

        public final boolean isEnable() {
            Chat r0 = this.a.getChat();
            boolean r1 = false;
            if (r0 != null) goto L6;
            return false;
        L6:
            if (com.ss.android.lark.chat.utils.k.d(r0) == false) goto L9;
            return true;
        L9:
            if (((jdb.g) this.d.getValue()).isEnable("messenger.message.mobile_message_menu_transformation") == true) goto L11;
            return true;
        L11:
            m6b.j r2 = (m6b.j) this.c.getValue();
            Long r3 = Long.valueOf(this.a.m().getCreateTime());
            MessageTenantConfService.c r4 = (MessageTenantConfService.c) r2.getConfig().getValue();
            if (r4 != null) goto L15;
            return true;
        L15:
            if (r4.a != (-1)) goto L18;
            return true;
        L18:
            if ((ChatCoreModule.a().getSettingDependency().a() - (r3.longValue() * 1000)) >= (r4.a * 1000)) goto L21;
            r1 = true;
        L21:
            return r1;
        }

        public final boolean isVisible() {
            Chat r0 = this.a.getChat();
            boolean r1 = false;
            if (r0 != null) goto L6;
            return false;
        L6:
            if (com.ss.android.lark.chat.utils.k.d(r0) == false) goto L9;
            return true;
        L9:
            if (this.a.m().getType() != Message.Type.DOUBAO) goto L22;
            g5b.a r2 = (g5b.a) this.a.m().n(g5b.a.class);
            String r3 = null;
            if (r2 == null) goto L13;
            Long r4 = Long.valueOf(r2.c);
        L14:
            if (r4 == null) goto L22;
            String r5 = r4.toString();
            Chatter r6 = this.a.u();
            if (r6 == null) goto L19;
            r3 = r6.getId();
        L19:
            if (Intrinsics.areEqual(r5, r3) == false) goto L22;
            return true;
        L13:
            r4 = null;
        L22:
            if (this.a.m().h() == false) goto L31;
            MessageTenantConfService.c r7 = (MessageTenantConfService.c) ((m6b.j) this.c.getValue()).getConfig().getValue();
            if (r7 != null) goto L27;
            return true;
        L27:
            if (r7.a == 0) goto L30;
            r1 = true;
        L30:
            return r1;
        L31:
            return false;
        }

        public MessageActionType getType() {
            return MessageActionType.RECALL;
        }

        public c(yya.a r2) {
            Intrinsics.checkNotNullParameter(r2, "actionContext");
            this.a = r2;
            this.b = LazyKt.lazy(new FlowChatRecallActionProvider$RecallMessageAction$chatContainer$2(this));
            this.c = LazyKt.lazy(new FlowChatRecallActionProvider$RecallMessageAction$messageConfigService$2(this));
            this.d = LazyKt.lazy(new FlowChatRecallActionProvider$RecallMessageAction$fgService$2(this));
        }

        public final void d(com.ss.android.lark.chat.message.menu.c r2) {
            Intrinsics.checkNotNullParameter(r2, "actionControl");
        }

        public final Drawable getIcon(Context r3) {
            Intrinsics.checkNotNullParameter(r3, "context");
            return UDIconUtils.getIconDrawable(r3, 2131255516, UDColorUtils.getColor(r3, 2131100799));
        }

        public final String getLabel(Context r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            return UIUtils.getString(r2, 2131891591);
        }

        public final View getView(Context r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            return null;
        }

        public final void b(View r7, boolean r8) {
            Intrinsics.checkNotNullParameter(r7, "view");
            String r0 = null;
            if (r8 == false) goto L30;
            y6b.a r9 = this.a.m();
            Intrinsics.checkNotNull(r9, "null cannot be cast to non-null type com.ss.android.lark.chat.vo.AbsMessageVO<out com.ss.android.lark.chat.export.vo.ContentVO<*>>");
            y6b.a r10 = r9;
            Chat r11 = this.a.getChat();
            if (r11 != null) goto L8;
            return;
        L8:
            if (r10.getType() == Message.Type.DOUBAO) goto L10;
        L24:
            Boolean r12 = null;
        L25:
            Log.i("FlowChatRecallActionProvider", "overrideIsFromMe: " + r12);
            FragmentActivity r2 = this.a.getActivity();
            b r1 = new b(r2);
            com.larksuite.component.ui.dialog.d r3 = new com.larksuite.component.ui.dialog.d(r2);
            r3.c.titleBold(true);
            if (r10.h() == false) goto L28;
            r3.j(2131891924);
            r3.c.titleLineCount(2);
        L29:
            r3.c.maskAlpha(0.3f);
            r3.a(2131378550, 2131891544, null);
            r3.a(2131378551, 2131891628, new com.ss.android.lark.chat.chatwindow.chat.menu.handler.s(r1, r10, r12));
            l7b.a.a(r3.i());
            return;
        L28:
            r3.j(2131891591);
            r3.h(UIHelper.mustacheFormat(2131891917, "msg_sender", r10.a().b));
            goto L29
        L10:
            if (com.ss.android.lark.chat.utils.k.d(r11) == true) goto L12;
            r12 = Boolean.TRUE;
            goto L25
        L12:
            g5b.a r13 = (g5b.a) r10.n(g5b.a.class);
            if (r13 == null) goto L15;
            Long r14 = Long.valueOf(r13.c);
        L16:
            if (r14 == null) goto L24;
            String r15 = r14.toString();
            Chatter r4 = this.a.u();
            if (r4 == null) goto L20;
            String r5 = r4.getId();
        L22:
            if (Intrinsics.areEqual(r15, r5) == false) goto L24;
            r12 = Boolean.TRUE;
            goto L25
        L20:
            r5 = null;
            goto L22
        L15:
            r14 = null;
            goto L16
        L30:
            MessageTenantConfService.c r16 = (MessageTenantConfService.c) ((m6b.j) this.c.getValue()).getConfig().getValue();
            if (r16 == null) goto L46;
            long r6 = r16.a;
            if (r6 == (-1)) goto L46;
            if (r6 != 0) goto L39;
            r0 = UIHelper.getString(2131891294);
            goto L46
        L39:
            Pair r17 = r0.a(r6);
            if (r17.getSecond() != TimeUnit.MINUTES) goto L43;
            r0 = UIHelper.mustacheFormat(2131891293, "num", ((Integer) r17.getFirst()).toString());
            goto L46
        L43:
            if (r17.getSecond() != TimeUnit.HOURS) goto L45;
            r0 = UIHelper.mustacheFormat(2131891292, "num", ((Integer) r17.getFirst()).toString());
            goto L46
        L45:
            r0 = UIHelper.getQuantityString(2131755066, ((Integer) r17.getFirst()).intValue());
        L46:
            if (r0 == null) goto L48;
            FlowToast.e(r7.getContext(), r0, 2131235476);
            return;
        L48:
            Log.e("FlowChatRecallActionProvider", "action is disabled, but we can't provide an recall tip");
        }
    }

    public FlowChatRecallActionProvider() {
    }

    public final String getTAG() {
        return "FlowChatRecallActionProvider";
    }

    static {
        a = LazyKt.lazy(FlowChatRecallActionProvider$Companion$supportedPageTypes$2.INSTANCE);
    }

    public final List<PageType> b() {
        return (List) a.getValue();
    }

    public final yya.i c(yya.a r2) {
        Intrinsics.checkNotNullParameter(r2, "actionContext");
        return new c(r2);
    }
}
