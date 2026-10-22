package com.larus.bmhome.view;

import android.view.ViewTreeObserver;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class ChatMessageList$j implements ViewTreeObserver.OnPreDrawListener {
    public final /* synthetic */ ViewTreeObserver a;
    public final /* synthetic */ ChatMessageList b;
    public final /* synthetic */ int c;

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        if (this.a.isAlive() == false) goto L5;
        this.a.removeOnPreDrawListener(this);
    L7:
        if (Intrinsics.areEqual(this.b.H, this) == false) goto L9;
        ChatMessageList r0 = this.b;
        r0.H = null;
        r0.I = null;
    L9:
        int r1 = this.c;
        ChatMessageList r2 = this.b;
        if (r1 == r2.F) goto L12;
        return true;
    L12:
        r2.G = false;
        FLogger.a.i("ChatMessageList", "scrollToLatestOnNextLayout run smooth offset=0 token=" + this.c);
        com.larus.bmhome.chat.api.b0.a.a(this.b, true, 0, null, null, 0, 24);
        return true;
    L5:
        this.b.getViewTreeObserver().removeOnPreDrawListener(this);
        goto L7
    }

    public ChatMessageList$j(ViewTreeObserver r1, ChatMessageList r2, int r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
