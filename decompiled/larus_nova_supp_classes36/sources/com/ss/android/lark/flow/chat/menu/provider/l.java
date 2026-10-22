package com.ss.android.lark.flow.chat.menu.provider;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.ss.android.lark.biz.im.extension.message_action.MessageActionType;
import com.ss.android.lark.chat.message.menu.provider.DeleteActionProvider;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class l extends DeleteActionProvider {

    public static final class a implements yya.i {
        public final yya.i a;

        public final Map<String, Object> R4() {
            return this.a.R4();
        }

        public final void b(View r2, boolean r3) {
            Intrinsics.checkNotNullParameter(r2, "view");
            this.a.b(r2, r3);
        }

        public final boolean c() {
            return this.a.c();
        }

        public final void d(com.ss.android.lark.chat.message.menu.c r2) {
            Intrinsics.checkNotNullParameter(r2, "actionControl");
            this.a.d(r2);
        }

        public final boolean f() {
            return this.a.f();
        }

        public final s5c.d g() {
            return this.a.g();
        }

        public final String getLabel(Context r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            return this.a.getLabel(r2);
        }

        public MessageActionType getType() {
            return this.a.getType();
        }

        public final View getView(Context r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            return this.a.getView(r2);
        }

        public final boolean isEnable() {
            return this.a.isEnable();
        }

        public final boolean isVisible() {
            return this.a.isVisible();
        }

        public final void onHide() {
            this.a.onHide();
        }

        public final void onShow() {
            this.a.onShow();
        }

        public final Integer e() {
            return 2131102036;
        }

        public a(DeleteActionProvider.b r2) {
            Intrinsics.checkNotNullParameter(r2, "superAction");
            this.a = r2;
        }

        public final Drawable getIcon(Context r3) {
            Intrinsics.checkNotNullParameter(r3, "context");
            return UDIconUtils.getIconDrawable(r3, 2131235474, UDColorUtils.getColor(r3, 2131100799));
        }
    }

    public l() {
    }

    public final yya.i c(yya.a r3) {
        Intrinsics.checkNotNullParameter(r3, "actionContext");
        Intrinsics.checkNotNullParameter(r3, "actionContext");
        return new a(new DeleteActionProvider.b(r3));
    }
}
