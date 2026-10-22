package com.ss.android.lark.chat.message.menu.provider;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.ss.android.lark.biz.im.extension.PageType;
import com.ss.android.lark.biz.im.extension.message_action.MessageActionType;
import com.ss.android.lark.chat.chatwindow.chat.menu.handler.j;
import com.ss.android.lark.chat.message.menu.c;
import com.ss.android.lark.utils.UIHelper;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import s5c.d;
import yya.g;
import yya.i;
import yya.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a implements m {

    /* JADX INFO: renamed from: com.ss.android.lark.chat.message.menu.provider.a$a, reason: collision with other inner class name */
    public static final class C0102a {
    }

    public final class b implements i {
        public final yya.a a;

        public final Map<String, Object> R4() {
            return MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("click", "multi_select"), TuplesKt.to("target", "im_msg_multi_select_view")});
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

        public final boolean isVisible() {
            return true;
        }

        public final void onHide() {
        }

        public final void onShow() {
        }

        public MessageActionType getType() {
            return MessageActionType.MULTI_SELECT;
        }

        public b(yya.a r2) {
            Intrinsics.checkNotNullParameter(r2, "actionContext");
            this.a = r2;
        }

        public final void d(c r2) {
            Intrinsics.checkNotNullParameter(r2, "actionControl");
        }

        public final Drawable getIcon(Context r3) {
            Intrinsics.checkNotNullParameter(r3, "context");
            return UDIconUtils.getIconDrawable(r3, 2131255177, UDColorUtils.getColor(r3, 2131100799));
        }

        public final String getLabel(Context r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            if (this.a.Y() == false) goto L5;
            String r3 = UIHelper.getString(2131891909);
            Intrinsics.checkNotNull(r3);
            return r3;
        L5:
            String r4 = UIHelper.getString(2131890401);
            Intrinsics.checkNotNull(r4);
            return r4;
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
            j r4 = this.a;
            if ((r4 instanceof g) == true) goto L8;
            return;
        L8:
            Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type com.ss.android.lark.chat.chatwindow.chat.menu.handler.IMultiSelectMenuHandler");
            r4.R(this.a.d.b());
        }
    }

    static {
    }

    public a() {
    }

    public final List<PageType> b() {
        return CollectionsKt.listOf(new PageType[]{PageType.CHAT_WINDOW, PageType.REPLY_IN_THREAD});
    }

    public final String getTAG() {
        return "ChatMultiSelectActionProvider";
    }

    public final i c(yya.a r2) {
        Intrinsics.checkNotNullParameter(r2, "actionContext");
        return new b(r2);
    }
}
