package com.larus.bmhome.view;

import android.view.ViewTreeObserver;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class z0 implements ViewTreeObserver.OnPreDrawListener {
    public final /* synthetic */ ChatMessageList a;
    public final /* synthetic */ int b;
    public final /* synthetic */ int c;
    public final /* synthetic */ boolean d;

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        this.a.getViewTreeObserver().removeOnPreDrawListener(this);
        ChatMessageList$c r0 = this.a.J(this.b, this.c);
        if (r0 == null) goto L6;
        FLogger.a.i("ChatMessageList", "retry pending unread progress success, position=" + r0.a + " visibleHeight=" + r0.b);
        this.a.g0(r0.a, r0.b);
        return false;
    L6:
        if (this.d == true) goto L11;
        FLogger.a.i("ChatMessageList", "retry pending unread progress fallback to target");
        ChatMessageList r1 = this.a;
        int r2 = this.b;
        if (this.d == false) goto L10;
        r1.f0(r2);
        return false;
    L10:
        r1.e(r2);
        return false;
    L11:
        FLogger.a.i("ChatMessageList", "retry pending unread progress skipped fallback to keep saved progress");
        return false;
    }

    public z0(ChatMessageList r1, int r2, int r3, boolean r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
