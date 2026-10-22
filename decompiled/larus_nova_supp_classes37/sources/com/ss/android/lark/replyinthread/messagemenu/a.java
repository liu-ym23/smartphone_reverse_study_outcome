package com.ss.android.lark.replyinthread.messagemenu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.ss.android.lark.biz.im.extension.message_action.MessageActionType;
import com.ss.android.lark.chat.message.menu.c;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.utils.UIHelper;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import s5c.d;
import yya.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a implements i {
    public final Map<String, Object> R4() {
        return MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(PickerReporterConstants.KEY.CLICK, "reply"), TuplesKt.to(PickerReporterConstants.KEY.TARGET, "none")});
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

    public MessageActionType getType() {
        return MessageActionType.REPLY;
    }

    public final boolean isVisible() {
        throw null;
    }

    public final void d(c r2) {
        Intrinsics.checkNotNullParameter(r2, "actionControl");
    }

    public final Drawable getIcon(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        int r0 = d6b.a.a;
        return UDIconUtils.getIconDrawable(r3, 2131255541, UDColorUtils.getColor(r3, 2131100799));
    }

    public final String getLabel(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return UIHelper.getString(2131892131);
    }

    public final View getView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return null;
    }

    public final void b(View r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        if (r3 == true) goto L6;
        return;
    L6:
        throw null;
    }
}
