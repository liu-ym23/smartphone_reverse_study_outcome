package com.ss.android.lark.flow.chat.menu.provider;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.ss.android.lark.biz.im.api.ThreadTopic;
import com.ss.android.lark.biz.im.extension.PageType;
import com.ss.android.lark.biz.im.extension.message_action.MessageActionType;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import com.ss.android.lark.utils.UIHelper;
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
public final class r implements yya.m {

    public static final class a {
    }

    public final class b implements yya.i {
        public final yya.a a;
        public final Lazy b;

        public final boolean c() {
            return false;
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

        public final Map<String, Object> R4() {
            int r0 = q.a;
            return MapsKt.mapOf(new Pair[]{TuplesKt.to("click", "withdraw"), TuplesKt.to("target", "none")});
        }

        public final boolean isVisible() {
            y6b.c r0 = this.a.m();
            ThreadTopic r2 = null;
            if ((r0 instanceof y6b.c) == false) goto L5;
            y6b.c r1 = r0;
        L6:
            int r3 = q.a;
            Chat r4 = this.a.getChat();
            v r5 = (v) this.b.getValue();
            if (r1 == null) goto L10;
            r2 = (ThreadTopic) r1.n(ThreadTopic.class);
        L10:
            return q.a(r4, r5, r2, this.a.g(), this.a.u(), j.a(this.a), r0.isPreMessage(), r0.h());
        L5:
            r1 = null;
            goto L6
        }

        public final Integer e() {
            return 2131102036;
        }

        public MessageActionType getType() {
            return MessageActionType.DELETE;
        }

        public b(yya.a r2) {
            Intrinsics.checkNotNullParameter(r2, "actionContext");
            this.a = r2;
            this.b = LazyKt.lazy(new FlowRecallTopicActionProvider$RecallTopicAction$chatContainer$2(this));
        }

        public final void d(com.ss.android.lark.chat.message.menu.c r2) {
            Intrinsics.checkNotNullParameter(r2, "actionControl");
        }

        public final Drawable getIcon(Context r3) {
            Intrinsics.checkNotNullParameter(r3, "context");
            return UDIconUtils.getIconDrawable(r3, 2131256063, UDColorUtils.getColor(r3, 2131100799));
        }

        public final String getLabel(Context r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            return UIHelper.getString(2131890408);
        }

        public final View getView(Context r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            return null;
        }

        public final void b(View r4, boolean r5) {
            Intrinsics.checkNotNullParameter(r4, "view");
            if (r5 == true) goto L5;
            return;
        L5:
            y6b.c r6 = this.a.m();
            if ((r6 instanceof y6b.c) == false) goto L8;
            y6b.c r7 = r6;
        L9:
            if (r7 == null) goto L18;
            String r8 = r7.Q1;
            if (r8 == null) goto L18;
            if (r8.length() <= 0) goto L15;
            boolean r0 = true;
        L16:
            if (r0 == false) goto L18;
        L19:
            if (r8 != null) goto L21;
            return;
        L21:
            int r1 = q.a;
            q.b(r4.getContext(), (v) this.b.getValue(), r8, INotificationHitPoint.ChatType.CHAT_TYPE_GROUP, null);
            return;
        L15:
            r0 = false;
        L18:
            r8 = null;
            goto L19
        L8:
            r7 = null;
            goto L9
        }
    }

    static {
    }

    public r() {
    }

    public final String getTAG() {
        return "FlowRecallTopicActionProvider";
    }

    public final List<PageType> b() {
        return CollectionsKt.listOf(PageType.THREAD_WINDOW);
    }

    public final yya.i c(yya.a r2) {
        Intrinsics.checkNotNullParameter(r2, "actionContext");
        return new b(r2);
    }
}
