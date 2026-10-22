package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.view.clickhandler;

import android.text.Layout;
import android.view.ViewTreeObserver;
import android.widget.ScrollView;
import com.larksuite.framework.callback.UICallbackExecutor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class h implements ViewTreeObserver.OnScrollChangedListener {
    public final /* synthetic */ ContentLongClickListener a;

    public h(ContentLongClickListener r1) {
        this.a = r1;
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final void onScrollChanged() {
        ContentLongClickListener r0 = this.a;
        if (r0.j == false) goto L29;
        r0.g = true;
        ScrollView r1 = r0.h;
        if (r1 == null) goto L34;
        r0.f.removeCallbacks(r0.w);
        ContentLongClickListener.c(r0.t);
        com.ss.android.lark.widget.select.m r2 = r0.d;
        if (r2 == null) goto L35;
        Layout r3 = r0.a.getLayout();
        if (r3 == null) goto L36;
        com.ss.android.lark.widget.select.h r4 = r2.l;
        int r5 = r4.a;
        int r6 = r4.b;
        if (r5 == 0) goto L16;
    L18:
        int r7 = r3.getLineForOffset(r5);
        int r8 = r3.getLineForOffset(r6);
        int r9 = r3.getLineTop(r7) + r0.a.getTop();
        int r10 = r3.getLineBottom(r8) + r0.a.getTop();
        int r11 = r1.getScrollY();
        int r12 = r1.getHeight();
        if (r9 >= r11) goto L21;
        if (r10 >= r11) goto L21;
    L24:
        com.ss.android.lark.widget.select.m r13 = r0.d;
        if (r13 == null) goto L37;
        UICallbackExecutor.post(new f(r13, r0));
        return;
    L37:
        return;
    L21:
        int r14 = r11 + r12;
        if (r9 <= r14) goto L28;
        if (r10 > r14) goto L24;
    L28:
        r2.f();
        r0.f.postDelayed(r0.w, 200);
        return;
    L16:
        if (r6 != r3.getText().length()) goto L18;
        r2.f();
        r0.f.postDelayed(r0.w, 200);
        return;
    L36:
        return;
    L35:
        return;
    L34:
        return;
    L29:
        r0.j = true;
    }
}
