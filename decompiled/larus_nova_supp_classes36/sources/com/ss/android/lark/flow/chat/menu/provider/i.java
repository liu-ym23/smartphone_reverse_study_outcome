package com.ss.android.lark.flow.chat.menu.provider;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.ss.android.lark.biz.im.api.ThreadTopic;
import com.ss.android.lark.biz.im.extension.PageType;
import com.ss.android.lark.biz.im.extension.message_action.MessageActionType;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.utils.UIHelper;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class i implements yya.m {

    public final class a implements yya.i {
        public final yya.a a;
        public final y6b.c<?> b;
        public final ThreadTopic c;
        public final boolean d;

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
            v5b.c r0 = this.a.m();
            int r1 = FlowCloseTopicActionHelper.a;
            return FlowCloseTopicActionHelper.a(this.a.getChat(), this.c, this.a.g(), this.a.u(), j.a(this.a), r0.isPreMessage(), r0.h());
        }

        public MessageActionType getType() {
            return MessageActionType.CLOSE_TOPIC;
        }

        public a(yya.a r3) {
            Intrinsics.checkNotNullParameter(r3, "actionContext");
            this.a = r3;
            y6b.c<?> r4 = r3.m();
            ThreadTopic r1 = null;
            if ((r4 instanceof y6b.c) == false) goto L5;
            y6b.c<?> r5 = r4;
        L6:
            this.b = r5;
            if (r5 == null) goto L9;
            r1 = (ThreadTopic) r5.n(ThreadTopic.class);
        L9:
            this.c = r1;
            if (r5 == null) goto L14;
            boolean r0 = true;
            if (r5.V2 != true) goto L14;
        L15:
            this.d = r0;
            return;
        L14:
            r0 = false;
            goto L15
        L5:
            r5 = null;
            goto L6
        }

        public final void d(com.ss.android.lark.chat.message.menu.c r2) {
            Intrinsics.checkNotNullParameter(r2, "actionControl");
        }

        public final Drawable getIcon(Context r3) {
            Intrinsics.checkNotNullParameter(r3, "context");
            if (this.d == false) goto L5;
            int r0 = 2131256306;
        L7:
            return UDIconUtils.getIconDrawable(r3, r0, UDColorUtils.getColor(r3, 2131100799));
        L5:
            r0 = 2131255224;
            goto L7
        }

        public final String getLabel(Context r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            if (this.d == false) goto L5;
            String r3 = UIHelper.getString(2131890430);
            Intrinsics.checkNotNull(r3);
            return r3;
        L5:
            String r4 = UIHelper.getString(2131890879);
            Intrinsics.checkNotNull(r4);
            return r4;
        }

        public final View getView(Context r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            return null;
        }

        public final void b(View r3, boolean r4) {
            Intrinsics.checkNotNullParameter(r3, "view");
            if (r4 == true) goto L5;
            return;
        L5:
            y6b.c<?> r5 = this.b;
            String r0 = null;
            if (r5 == null) goto L15;
            String r6 = r5.c;
            if (r6 == null) goto L15;
            if (r6.length() <= 0) goto L12;
            boolean r1 = true;
        L13:
            if (r1 == false) goto L15;
        L16:
            if (r6 != null) goto L18;
            return;
        L18:
            Chat r2 = this.a.getChat();
            if (r2 == null) goto L21;
            r0 = r2.getId();
        L21:
            if (r0 != null) goto L23;
            r0 = "";
        L23:
            int r7 = FlowCloseTopicActionHelper.a;
            FlowCloseTopicActionHelper.b(r3.getContext(), r0, r6, this.d);
            return;
        L12:
            r1 = false;
        L15:
            r6 = null;
            goto L16
        }
    }

    public static final class b {
    }

    static {
    }

    public i() {
    }

    public final String getTAG() {
        return "FlowCloseTopicActionProvider";
    }

    public final List<PageType> b() {
        return CollectionsKt.listOf(PageType.THREAD_WINDOW);
    }

    public final yya.i c(yya.a r2) {
        Intrinsics.checkNotNullParameter(r2, "actionContext");
        return new a(r2);
    }
}
