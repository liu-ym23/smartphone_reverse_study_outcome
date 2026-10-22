package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.view.clickhandler;

import android.text.Layout;
import android.widget.ScrollView;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class k implements com.ss.android.lark.widget.select.m.c {
    public int a;
    public int b;
    public final /* synthetic */ ContentLongClickListener c;
    public final /* synthetic */ com.ss.android.lark.widget.select.c d;
    public final /* synthetic */ com.ss.android.lark.widget.select.m e;

    public final void a() {
        ContentLongClickListener r0 = this.c;
        if (r0.l == false) goto L6;
        return;
    L6:
        if (this.d == null) goto L8;
        return;
    L8:
        com.ss.android.lark.widget.select.h r1 = this.e.l;
        int r2 = r1.a;
        int r3 = r1.b;
        int r4 = this.a;
        int r5 = this.b;
        ScrollView r6 = r0.h;
        if (r6 == null) goto L57;
        if (r2 != r4) goto L13;
        if (r3 != r5) goto L13;
        return;
    L13:
        if (r2 != r5) goto L16;
        if (r3 != r4) goto L16;
        return;
    L16:
        Layout r7 = r0.a.getLayout();
        if (r7 == null) goto L59;
        int r8 = r7.getLineTop(r7.getLineForOffset(r2)) + r0.a.getTop();
        int r9 = r7.getLineBottom(r7.getLineForOffset(r3)) + r0.a.getTop();
        int r10 = r6.getScrollY();
        int r11 = r6.getHeight();
        boolean r12 = false;
        if (r8 >= r10) goto L22;
    L29:
        r0.j = false;
        if (r2 == r4) goto L44;
        if (r2 == r5) goto L44;
        if (r3 == r5) goto L37;
        if (r3 == r4) goto L37;
        Log.w("ContentLongClickListener", "scrollOnMoveCursor, offset is invalid, old={" + r4 + ", " + r5 + "}, new={" + r2 + ", " + r3 + '}');
        return;
    L37:
        r6.smoothScrollBy(0, r8 - (r7.getLineTop(r7.getLineForOffset(r4)) + r0.a.getTop()));
        if (r9 > (r6.getHeight() + r6.getScrollY())) goto L40;
        r12 = true;
    L40:
        com.ss.android.lark.widget.select.m r13 = r0.d;
        if (r13 == null) goto L43;
        r13.m(true, r12);
    L43:
        r0.i = true;
        return;
    L44:
        r6.smoothScrollBy(0, r9 - (r7.getLineBottom(r7.getLineForOffset(r5)) + r0.a.getTop()));
        if (r8 < r6.getScrollY()) goto L47;
        r12 = true;
    L47:
        com.ss.android.lark.widget.select.m r14 = r0.d;
        if (r14 == null) goto L50;
        r14.m(r12, true);
    L50:
        r0.i = true;
        return;
    L22:
        if (r9 > (r11 + r10)) goto L29;
        if (r0.i == false) goto L53;
        com.ss.android.lark.widget.select.m r15 = r0.d;
        if (r15 == null) goto L28;
        r15.m(true, true);
    L28:
        r0.i = false;
        return;
    L53:
        return;
    L59:
        return;
    }

    public final void b() {
        com.ss.android.lark.widget.select.h r0 = this.e.l;
        this.a = r0.a;
        this.b = r0.b;
        ContentLongClickListener.c(this.c.t);
    }

    public k(ContentLongClickListener r1, com.ss.android.lark.widget.select.c r2, com.ss.android.lark.widget.select.m r3) {
        this.c = r1;
        this.d = r2;
        this.e = r3;
    }
}
