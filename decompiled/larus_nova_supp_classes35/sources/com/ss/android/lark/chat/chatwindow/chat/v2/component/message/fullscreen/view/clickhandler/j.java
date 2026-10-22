package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.view.clickhandler;

import android.widget.PopupWindow;
import com.ss.android.lark.chat.entity.message.PartialReplyInfo;
import com.ss.android.lark.chat.utils.u;
import com.ss.android.lark.widget.light.LKUILightTextView;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class j implements com.ss.android.lark.widget.select.m.d {
    public final /* synthetic */ ContentLongClickListener a;

    public j(ContentLongClickListener r1) {
        this.a = r1;
    }

    public final void a(com.ss.android.lark.widget.select.g r10) {
        Intrinsics.checkNotNullParameter(r10, "it");
        ContentLongClickListener r0 = this.a;
        if (r0.l == false) goto L5;
        return;
    L5:
        u r1 = u.a.a;
        r1.c = r10.g;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.view.clickhandler.menu.a r2 = r0.s;
        CharSequence r3 = r10.a;
        CharSequence r4 = r0.a.getContentText();
        boolean r5 = this.a.k;
        boolean r6 = r10.g;
        PartialReplyInfo.PartialContentRelativePosition.a r7 = PartialReplyInfo.PartialContentRelativePosition.Companion;
        int r8 = r10.h.getValue();
        r7.getClass();
        f4b.f r9 = new f4b.f(r3, r4, r5, r6, PartialReplyInfo.PartialContentRelativePosition.a.a(r8));
        r2.getClass();
        Intrinsics.checkNotNullParameter(r9, "selectData");
        if (r2.a == null) goto L8;
        Intrinsics.checkNotNullParameter(r9, "<set-?>");
    L8:
        ContentLongClickListener.c(this.a.t);
        ContentLongClickListener r11 = this.a;
        r11.t = r11.s.a();
        ContentLongClickListener r12 = this.a;
        LKUILightTextView r13 = r12.a;
        PopupWindow r14 = r12.t;
        ((Number) ((Pair) r12.u.getValue()).getFirst()).intValue();
        ((Number) ((Pair) this.a.u.getValue()).getSecond()).intValue();
        ContentLongClickListener.a(r12, r10, r13, r14);
    }
}
