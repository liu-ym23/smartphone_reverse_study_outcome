package com.ss.android.lark.flow.chat.titlebar;

import androidx.lifecycle.Observer;
import com.ss.android.lark.biz.im.api.extension.chat_window.TitleBarActionKey;
import com.ss.android.lark.flow.chat.titlebar.view.BadgeBackView;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c<T> implements Observer {
    public final /* synthetic */ FlowTitleBarComponent a;

    public c(FlowTitleBarComponent r1) {
        this.a = r1;
    }

    public final void onChanged(Object r5) {
        Integer r6 = (Integer) r5;
        FlowTitleBarComponent.LeftAreaImpl r0 = this.a.p;
        Intrinsics.checkNotNull(r6);
        int r7 = r6.intValue();
        Iterator<Map.Entry<TitleBarActionKey, com.ss.android.lark.biz.im.api.extension.chat_window.j>> r1 = r0.a.entrySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L15;
        Map.Entry<TitleBarActionKey, com.ss.android.lark.biz.im.api.extension.chat_window.j> r2 = r1.next();
        TitleBarActionKey r3 = r2.getKey();
        com.ss.android.lark.biz.im.api.extension.chat_window.j r4 = r2.getValue();
        Object r8 = r0.c(r3);
        if ((r8 instanceof BadgeBackView) == false) goto L8;
        BadgeBackView r9 = (BadgeBackView) r8;
    L9:
        if (r9 == null) goto L4;
        BadgeBackView.BadgeView r10 = r9.b;
        r10.a = r7;
        if (r7 <= 0) goto L13;
        int r11 = 0;
    L14:
        r10.setVisibility(r11);
        r10.requestLayout();
        goto L4
    L13:
        r11 = 8;
        goto L14
    L8:
        r9 = null;
        goto L9
    }
}
