package com.ss.android.lark.chat.message.menu.provider;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.ss.android.lark.biz.im.extension.PageType;
import com.ss.android.lark.biz.im.extension.message_action.MessageActionType;
import com.ss.android.lark.chat.message.menu.c;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import s5c.d;
import yya.i;
import yya.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class ReactionActionProvider implements m {

    public static final class ReactionMessageAction implements i {
        public final yya.a a;
        public final Lazy b;
        public final FragmentActivity c;

        public final Map<String, Object> R4() {
            return null;
        }

        public final void b(View r1, boolean r2) {
            Intrinsics.checkNotNullParameter(r1, "view");
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

        public final String getLabel(Context r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            return BuildConfig.FLAVOR;
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

        public final FragmentActivity getActivity() {
            return this.c;
        }

        public MessageActionType getType() {
            return MessageActionType.ADD_REACTION;
        }

        public ReactionMessageAction(yya.a r2) {
            Intrinsics.checkNotNullParameter(r2, "actionContext");
            this.a = r2;
            this.b = LazyKt.lazy(new ReactionActionProvider$ReactionMessageAction$container$2(this));
            this.c = r2.getActivity();
        }

        public final void d(c r2) {
            Intrinsics.checkNotNullParameter(r2, "actionControl");
        }

        public final Drawable getIcon(Context r3) {
            Intrinsics.checkNotNullParameter(r3, "context");
            return UDIconUtils.getIconDrawable(r3, 2131254165, UDColorUtils.getColor(r3, 2131100799));
        }

        public final View getView(Context r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            return null;
        }
    }

    public static final class a {
    }

    static {
    }

    public ReactionActionProvider() {
    }

    public final String getTAG() {
        return "ReactionActionProvider";
    }

    public final List<PageType> b() {
        return vya.a.a;
    }

    public final i c(yya.a r2) {
        Intrinsics.checkNotNullParameter(r2, "actionContext");
        return new ReactionMessageAction(r2);
    }
}
