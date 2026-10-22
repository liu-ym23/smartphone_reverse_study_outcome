package wgb;

import android.content.Context;
import android.view.ViewGroup;
import com.larksuite.framework.utils.ICUUtils;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.utils.UIHelper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class f<T> extends com.ss.android.lark.chatwindow.view.tip.c<T> {
    public final int c() {
        return ((com.ss.android.lark.chatwindow.view.tip.c) this).g - ((com.ss.android.lark.chatwindow.view.tip.c) this).h;
    }

    public final String d() {
        return ICUUtils.icuFormat(UIUtils.getQuantityString(((com.ss.android.lark.chatwindow.view.tip.a) this).c, 2131755048, ((com.ss.android.lark.chatwindow.view.tip.c) this).g - ((com.ss.android.lark.chatwindow.view.tip.c) this).h), "num", Long.valueOf(((com.ss.android.lark.chatwindow.view.tip.c) this).g - ((com.ss.android.lark.chatwindow.view.tip.c) this).h));
    }

    public final void k(ViewGroup.LayoutParams r3) {
        Intrinsics.checkNotNullParameter(r3, "layoutParams");
        if ((r3 instanceof ViewGroup.MarginLayoutParams) == false) goto L5;
        ViewGroup.MarginLayoutParams r4 = (ViewGroup.MarginLayoutParams) r3;
    L6:
        if (r4 == null) goto L9;
        r4.topMargin = UIHelper.dp2px(8.0f) + ((com.ss.android.lark.chatwindow.view.tip.a) this).b.j();
        return;
    L9:
        return;
    L5:
        r4 = null;
        goto L6
    }

    public f(Context r2, r7b.c r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "dataStrategy");
        super(r2, r3);
    }

    public final String a(Message r6, String r7) {
        String r0 = super/*com.ss.android.lark.chatwindow.view.tip.a*/.a(r6, r7);
        if (r6.getType() == Message.Type.DOUBAO) goto L18;
        boolean r2 = false;
        if (r6.isAtAll() != true) goto L8;
        boolean r1 = true;
    L10:
        if (r1 == false) goto L13;
        return ICUUtils.icuFormat(UIUtils.getString(((com.ss.android.lark.chatwindow.view.tip.a) this).c, 2131890165), "name", r7);
    L13:
        if (r6.isOtherAtMe() != true) goto L15;
        r2 = true;
    L15:
        if (r2 == true) goto L17;
        return r0;
    L17:
        return ICUUtils.icuFormat(UIUtils.getString(((com.ss.android.lark.chatwindow.view.tip.a) this).c, 2131890166), "name", r7);
    L8:
        r1 = false;
        goto L10
    L18:
        return ICUUtils.icuFormat(UIUtils.getString(((com.ss.android.lark.chatwindow.view.tip.a) this).c, 2131890137), "brandName", r7);
    }
}
