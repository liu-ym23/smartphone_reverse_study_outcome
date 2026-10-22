package com.ss.android.lark.chat.message.menu.provider;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larksuite.component.universe_design.toast.UDToast;
import com.ss.android.lark.biz.im.extension.PageType;
import com.ss.android.lark.biz.im.extension.message_action.MessageActionType;
import com.ss.android.lark.chat.base.view.vo.ThreadMessageVO;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageEditInfo;
import com.ss.android.lark.chat.entity.message.content.PostContent;
import com.ss.android.lark.chat.service.impl.MessageTenantConfService;
import com.ss.android.lark.chat.utils.r0;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.UIHelper;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import m6b.j;
import s5c.d;
import y6b.c;
import yya.g;
import yya.i;
import yya.m;
import z5c.p3;
import z5c.r;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class ChatEditMsgActionProvider implements m {
    public final Lazy a;
    public final Lazy b;

    public final class MessageReEditAction implements i {
        public final yya.a a;
        public final Lazy b;
        public final /* synthetic */ ChatEditMsgActionProvider c;

        public final Map<String, Object> R4() {
            return null;
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

        public final boolean c() {
            x2b.a r0 = this.a;
            Message r1 = r0.g();
            x2b.a r2 = null;
            if (r1 == null) goto L7;
            MessageEditInfo r3 = r1.getEditInfo();
            if (r3 == null) goto L7;
            String r4 = r3.getEditDraftId();
        L9:
            if (r4 != null) goto L11;
        L14:
            boolean r5 = true;
        L15:
            boolean r6 = !r5;
            if ((r0 instanceof x2b.a) == false) goto L18;
            r2 = r0;
        L18:
            String r7 = BuildConfig.FLAVOR;
            if (r2 == null) goto L24;
            m2b.a r8 = r2.a();
            if (r8 == null) goto L24;
            String r9 = r8.D8();
            if (r9 == null) goto L24;
        L25:
            if (r6 == false) goto L36;
            Message r10 = r0.g();
            if (r10 == null) goto L33;
            String r11 = r10.getId();
            if (r11 == null) goto L33;
            r7 = r11;
        L33:
            if (Intrinsics.areEqual(r9, r7) == true) goto L37;
            return true;
        L37:
            return false;
        L36:
            return false;
        L24:
            r9 = BuildConfig.FLAVOR;
            goto L25
        L11:
            if (r4.length() == 0) goto L14;
            r5 = false;
        L7:
            r4 = null;
            goto L9
        }

        public final d g() {
            s5c.a r0 = r.C;
            s5c.a r1 = p3.c;
            r0.getClass();
            return d.b.b(r0, r1);
        }

        public final boolean isVisible() {
            if (((Boolean) this.c.a.getValue()).booleanValue() == true) goto L5;
            return false;
        L5:
            Message.Type r0 = this.a.l();
            if (r0 != Message.Type.TEXT) goto L8;
        L10:
            ChatEditMsgActionProvider r1 = this.c;
            yya.a r2 = this.a;
            r1.getClass();
            if (r0.e(((v) r2.get()).f0(), r2.g()) == false) goto L91;
            Chat r3 = r2.getChat();
            if (r3 != null) goto L16;
        L18:
            boolean r4 = false;
        L19:
            String r5 = null;
            c r6 = null;
            if (r4 == false) goto L36;
            v5b.c r7 = r2.m();
            if ((r7 instanceof c) == false) goto L25;
            r6 = (c) r7;
        L25:
            if (r2.r() != PageType.THREAD_DETAIL) goto L33;
            if (r6 != null) goto L28;
        L30:
            boolean r8 = false;
        L31:
            if (r8 == true) goto L33;
            boolean r9 = true;
        L34:
            if (r9 == false) goto L87;
        L85:
            return true;
        L87:
            return false;
        L28:
            if (r6.Z() != true) goto L30;
            r8 = true;
        L33:
            r9 = false;
            goto L34
        L36:
            v5b.c r10 = r2.m();
            if ((r10 instanceof ThreadMessageVO) == false) goto L39;
            ThreadMessageVO r11 = (ThreadMessageVO) r10;
        L39:
            v5b.c r12 = r2.m();
            if ((r12 instanceof c) == false) goto L42;
            c r13 = (c) r12;
        L43:
            if (r13 != null) goto L45;
        L47:
            boolean r14 = false;
        L48:
            if (r14 == true) goto L92;
            Message r15 = r2.g();
            if (r15 == null) goto L53;
            Message.Type r16 = r15.getType();
        L55:
            if (r16 == Message.Type.POST) goto L57;
        L59:
            boolean r17 = false;
        L60:
            if (r17 == false) goto L62;
            Log.i("ChatEditMsgActionProvider", "shouldShowAction: message is group announcement , method return.");
            return false;
        L62:
            if (r15 == null) goto L64;
            String r18 = r15.getFromId();
        L66:
            if (Intrinsics.areEqual(r18, ChatCoreModule.a().getLoginDependency().getUserId()) == true) goto L85;
            if (r15 == null) goto L69;
            String r19 = r15.getFromId();
        L70:
            if (r19 != null) goto L72;
        L75:
            boolean r20 = true;
        L76:
            if (r20 == true) goto L89;
            if (r15 == null) goto L79;
            String r21 = r15.getFromId();
        L80:
            Chat r22 = r2.getChat();
            if (r22 == null) goto L84;
            r5 = r22.getAnonymousId();
        L84:
            if (Intrinsics.areEqual(r21, r5) == true) goto L85;
            return false;
        L79:
            r21 = null;
            goto L80
        L89:
            return false;
        L72:
            if (r19.length() == 0) goto L75;
            r20 = false;
            goto L76
        L69:
            r19 = null;
            goto L70
        L64:
            r18 = null;
            goto L66
        L57:
            if (((PostContent) r15.getContent()).isGroupAnnouncement() == false) goto L59;
            r17 = true;
            goto L60
        L53:
            r16 = null;
            goto L55
        L92:
            return false;
        L45:
            if (r13.V2 != true) goto L47;
            r14 = true;
            goto L48
        L42:
            r13 = null;
            goto L43
        L16:
            if (r3.isAllowPost() == true) goto L18;
            r4 = true;
            goto L19
        L91:
            return false;
        L8:
            if (r0 == Message.Type.POST) goto L10;
            return false;
        }

        public MessageActionType getType() {
            return MessageActionType.REEDIT;
        }

        public final void d(com.ss.android.lark.chat.message.menu.c r2) {
            Intrinsics.checkNotNullParameter(r2, "actionControl");
        }

        public final Drawable getIcon(Context r3) {
            Intrinsics.checkNotNullParameter(r3, "context");
            return UDIconUtils.getIconDrawable(r3, 2131254285, UDColorUtils.getColor(r3, 2131100799));
        }

        public final String getLabel(Context r5) {
            Intrinsics.checkNotNullParameter(r5, "context");
            Context r6 = this.a.getContext();
            PageType r0 = this.a.r();
            if (r0 != PageType.THREAD_WINDOW) goto L7;
            return r6.getString(2131891089);
        L7:
            if (r0 != PageType.THREAD_DETAIL) goto L22;
            v5b.c r1 = this.a.m();
            if ((r1 instanceof c) == false) goto L11;
            c r2 = (c) r1;
        L12:
            boolean r3 = false;
            if (r2 != null) goto L15;
        L17:
            if (r3 == false) goto L19;
            String r7 = r6.getString(2131891089);
            Intrinsics.checkNotNull(r7);
            return r7;
        L19:
            String r8 = r6.getString(2131891088);
            Intrinsics.checkNotNull(r8);
            return r8;
        L15:
            if (r2.Z() != true) goto L17;
            r3 = true;
            goto L17
        L11:
            r2 = null;
            goto L12
        L22:
            return r6.getString(2131891065);
        }

        public final View getView(Context r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            return null;
        }

        public MessageReEditAction(ChatEditMsgActionProvider r2, yya.a r3) {
            Intrinsics.checkNotNullParameter(r3, "actionContext");
            this.c = r2;
            this.a = r3;
            this.b = LazyKt.lazy(new ChatEditMsgActionProvider$MessageReEditAction$messageConfigService$2(this));
        }

        public final void b(View r7, boolean r8) {
            Intrinsics.checkNotNullParameter(r7, "view");
            if (r8 == true) goto L5;
            return;
        L5:
            yya.a r9 = this.a;
            if ((r9 instanceof g) == true) goto L8;
            return;
        L8:
            Message r10 = r9.g();
            if (r10 != null) goto L13;
            Log.e("ChatEditMsgActionProvider", "ChatEditMsgActionProvider: onClick, get a null msg , method return.");
            return;
        L13:
            if (r0.e((j) this.b.getValue(), r10) == true) goto L28;
            Log.i("ChatEditMsgActionProvider", "current message is created more than 24 hours, method return");
            Context r11 = this.a.getContext();
            MessageTenantConfService.c r12 = (MessageTenantConfService.c) ((j) this.b.getValue()).getConfig().getValue();
            if (r12 != null) goto L17;
            String r13 = UIHelper.mustacheFormat(2131891062, "num", "24");
        L27:
            UDToast.show(r11, r13);
            return;
        L17:
            long r2 = r12.b;
            if (r2 != 0) goto L20;
            r13 = UIHelper.getString(2131891064);
            goto L27
        L20:
            Pair<Integer, TimeUnit> r14 = r0.a(r2);
            if (r14.getSecond() != TimeUnit.MINUTES) goto L24;
            r13 = UIHelper.mustacheFormat(2131891063, "num", ((Integer) r14.getFirst()).toString());
            goto L27
        L24:
            if (r14.getSecond() != TimeUnit.HOURS) goto L26;
            r13 = UIHelper.mustacheFormat(2131891062, "num", ((Integer) r14.getFirst()).toString());
            goto L27
        L26:
            r13 = UIHelper.getQuantityString(2131755061, ((Integer) r14.getFirst()).intValue());
            goto L27
        L28:
            com.ss.android.lark.chat.chatwindow.chat.menu.handler.i r15 = this.a;
            Intrinsics.checkNotNull(r15, "null cannot be cast to non-null type com.ss.android.lark.chat.chatwindow.chat.menu.handler.IEditMsgMenuHandler");
            r15.X(r10.getId(), this.a.d.b());
        }
    }

    public static final class a {
    }

    static {
    }

    public final String getTAG() {
        return "ChatEditMsgActionProvider";
    }

    public final List<PageType> b() {
        return (List) this.b.getValue();
    }

    public ChatEditMsgActionProvider() {
        this.a = LazyKt.lazy(ChatEditMsgActionProvider$isFgEnable$2.INSTANCE);
        this.b = LazyKt.lazy(ChatEditMsgActionProvider$supportedPageTypes$2.INSTANCE);
    }
}
