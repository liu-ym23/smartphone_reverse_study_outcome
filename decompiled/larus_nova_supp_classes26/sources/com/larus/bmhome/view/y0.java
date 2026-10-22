package com.larus.bmhome.view;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class y0 implements ViewTreeObserver.OnPreDrawListener {
    public final /* synthetic */ ChatMessageList a;
    public final /* synthetic */ int b;
    public final /* synthetic */ int c;
    public final /* synthetic */ Function0<Unit> d;
    public final /* synthetic */ Function0<Unit> e;

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        this.a.getViewTreeObserver().removeOnPreDrawListener(this);
        int r0 = this.a.G(this.b);
        ChatMessageList r1 = this.a;
        int r2 = this.b;
        LinearLayoutManager r3 = r1.getLayoutManager();
        if ((r3 instanceof LinearLayoutManager) == false) goto L5;
        LinearLayoutManager r4 = r3;
    L7:
        if (r4 == null) goto L24;
        int r5 = r1.F(r2);
        if (r5 > r2) goto L25;
    L11:
        View r6 = r4.findViewByPosition(r5);
        if (r6 == null) goto L24;
        Rect r7 = new Rect();
        if (r6.getLocalVisibleRect(r7) == false) goto L24;
        if (r7.top > 0) goto L24;
        if (r7.bottom < r6.getHeight()) goto L24;
        if (r5 == r2) goto L25;
        r5 = r5 + 1;
    L25:
        boolean r8 = true;
    L26:
        FLogger.a.i("ChatMessageListpending-unread-resolve", "targetPosition=" + this.b + " groupHeight=" + r0 + " messageListHeight=" + this.c + " isGroupFullyVisible=" + r8);
        if (r0 > 0) goto L29;
    L32:
        this.e.invoke();
    L33:
        return false;
    L29:
        if (r0 > this.c) goto L32;
        if (r8 == false) goto L32;
        this.d.invoke();
    L24:
        r8 = false;
        goto L26
    L5:
        r4 = null;
        goto L7
    }

    public y0(ChatMessageList r1, int r2, int r3, com.larus.bmhome.chat.component.list.w0 r4, com.larus.bmhome.chat.component.list.x0 r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
