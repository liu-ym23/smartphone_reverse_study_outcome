package com.ss.android.lark.flow.chat.menu.provider;

import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.biz.im.api.message.params.y;
import com.ss.android.lark.biz.im.extension.PageType;
import com.ss.android.lark.biz.im.extension.message_action.MessageActionType;
import com.ss.android.lark.biz.officesdk.im.message.menu.IDoubaoTextSelectService;
import com.ss.android.lark.chat.base.view.vo.message.AudioContentVO;
import com.ss.android.lark.chat.base.view.vo.message.BaseTextContentVO;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.PartialReplyInfo;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.widget.light.LKUILightTextView;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class SelectTextActionProvider implements yya.m {

    public final class SelectTextAction implements yya.i {
        public final yya.a a;
        public final List<Message.Type> b;

        public final Map<String, Object> R4() {
            return MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("click", "select_text"), TuplesKt.to("target", "none")});
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
            return this.b.contains(this.a.l());
        }

        public MessageActionType getType() {
            return MessageActionType.SELECT_TEXT;
        }

        public SelectTextAction(yya.a r3) {
            Intrinsics.checkNotNullParameter(r3, "actionContext");
            this.a = r3;
            this.b = CollectionsKt.listOf(new Message.Type[]{Message.Type.TEXT, Message.Type.POST, Message.Type.DOUBAO, Message.Type.AUDIO});
        }

        public final void d(com.ss.android.lark.chat.message.menu.c r2) {
            Intrinsics.checkNotNullParameter(r2, "actionControl");
        }

        public final Drawable getIcon(Context r3) {
            Intrinsics.checkNotNullParameter(r3, "context");
            return UDIconUtils.getIconDrawable(r3, 2131235471, UDColorUtils.getColor(r3, 2131100799));
        }

        public final String getLabel(Context r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            return UIUtils.getString(r2, 2131890173);
        }

        public final View getView(Context r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            return null;
        }

        public final void b(View r10, boolean r11) {
            Intrinsics.checkNotNullParameter(r10, "view");
            Message.Type r12 = this.a.l();
            if (this.b.contains(r12) == true) goto L5;
            return;
        L5:
            yya.g r13 = this.a;
            y6b.a r1 = null;
            if ((r13 instanceof yya.g) == false) goto L8;
            yya.g r14 = r13;
        L9:
            if (r14 == null) goto L66;
            final yya.o r15 = r14.d;
            if (r15 != null) goto L14;
            return;
        L14:
            if (r12 != Message.Type.DOUBAO) goto L28;
            String r16 = ((yzb.b) LarkContext.spiByDwarf(yzb.b.class)).d();
            y6b.a r0 = this.a.m();
            if ((r0 instanceof y6b.a) == false) goto L18;
            r1 = r0;
        L18:
            if (r1 != null) goto L20;
            return;
        L20:
            IDoubaoTextSelectService r17 = OfficeSDKManager.getHostUserService(r16, IDoubaoTextSelectService.class);
            if (r17 != null) goto L23;
            return;
        L23:
            View r2 = r15.a();
            Point r18 = r15.c();
            if (r18 != null) goto L26;
            r18 = new Point();
        L26:
            r17.a1(r1, r2, r18);
            return;
        L28:
            if ((r15 instanceof yya.o) == false) goto L30;
            yya.o r19 = r15;
        L31:
            if (r19 != null) goto L33;
            return;
        L33:
            LKUILightTextView r3 = r19.e();
            if (r3 != null) goto L36;
            return;
        L36:
            com.ss.android.lark.chat.message.menu.context.b r110 = this.a;
            if ((r110 instanceof com.ss.android.lark.chat.message.menu.context.b) == false) goto L39;
            com.ss.android.lark.chat.message.menu.context.b r4 = r110;
        L40:
            if (r4 == null) goto L68;
            m2b.a r5 = r4.f;
            if (r5 == null) goto L71;
            y6b.c r111 = r110.m();
            if ((r111 instanceof y6b.c) == false) goto L47;
            final y6b.c r112 = r111;
        L48:
            if (r112 != null) goto L50;
            return;
        L50:
            Function3<CharSequence, Boolean, PartialReplyInfo.PartialContentRelativePosition, Unit> r6 = new SelectTextActionProvider$SelectTextAction$onClick$1(this);
            Function0<Unit> r7 = new SelectTextActionProvider$SelectTextAction$onClick$2(this, r112, r15);
            y r8 = r5.d0(y.class);
            if (r8 == null) goto L59;
            com.ss.android.lark.biz.im.api.message.params.o r9 = r8.j;
            if (r9 == null) goto L59;
            if (r112.i == false) goto L57;
            int r20 = r9.a;
        L58:
            Integer r21 = Integer.valueOf(UIUtils.getColor(r3.getContext(), r20));
        L60:
            com.ss.android.lark.chat.message.menu.a.d(r3, r5, false, r6, r7, r21, 64);
            y6b.a r22 = this.a;
            if ((r22 instanceof com.ss.android.lark.chat.chatwindow.chat.menu.handler.m) == false) goto L63;
            r1 = (com.ss.android.lark.chat.chatwindow.chat.menu.handler.m) r22;
        L63:
            if (r1 == null) goto L69;
            r1.b(r112, r15);
            return;
        L69:
            return;
        L57:
            r20 = r9.b;
        L59:
            r21 = null;
            goto L60
        L47:
            r112 = null;
            goto L48
        L71:
            return;
        L68:
            return;
        L39:
            r4 = null;
            goto L40
        L30:
            r19 = null;
            goto L31
        L66:
            return;
        L8:
            r14 = null;
            goto L9
        }
    }

    public static final class a {
    }

    public static final class b {
        public final y6b.a<?> a;

        public b(y6b.a<?> r1) {
            this.a = r1;
        }

        public final void update(CharSequence r3, boolean r4, PartialReplyInfo.PartialContentRelativePosition r5) {
            Intrinsics.checkNotNullParameter(r3, "copyText");
            Intrinsics.checkNotNullParameter(r5, "partialContentRelativePosition");
            y6b.a<?> r0 = this.a;
            if (r0 != null) goto L5;
            return;
        L5:
            BaseTextContentVO r1 = r0.b();
            if ((r1 instanceof BaseTextContentVO) == false) goto L9;
            BaseTextContentVO r2 = r1;
            r2.t = r3;
            r2.u = r3;
            r2.v = r5;
            r2.y = r4;
            return;
        L9:
            if ((r1 instanceof AudioContentVO) == false) goto L21;
            com.ss.android.lark.chat.base.view.vo.message.e r6 = ((AudioContentVO) r1).h;
            if (r6 == null) goto L13;
            ((BaseTextContentVO) r6).t = r3;
        L13:
            if (r6 == null) goto L15;
            ((BaseTextContentVO) r6).u = r3;
        L15:
            if (r6 == null) goto L17;
            ((BaseTextContentVO) r6).v = r5;
        L17:
            if (r6 == null) goto L22;
            ((BaseTextContentVO) r6).y = r4;
            return;
        L22:
            return;
        }
    }

    static {
    }

    public SelectTextActionProvider() {
    }

    public final List<PageType> b() {
        return CollectionsKt.listOf(new PageType[]{PageType.CHAT_WINDOW, PageType.REPLY_IN_THREAD, PageType.MERGE_FORWARD, PageType.THREAD_FORWARD, PageType.THREAD_WINDOW});
    }

    public final String getTAG() {
        return "SelectTextActionProvider";
    }

    public final yya.i c(yya.a r2) {
        Intrinsics.checkNotNullParameter(r2, "actionContext");
        return new SelectTextAction(r2);
    }
}
