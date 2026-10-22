package com.bytedance.android.livesdk.chatroom.viewmodule.shortterm;

import android.view.ViewTreeObserver;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b implements ViewTreeObserver.OnGlobalLayoutListener {
    public final /* synthetic */ BubbleComponent a;
    public final /* synthetic */ om3.e b;
    public final /* synthetic */ int[] c;
    public final /* synthetic */ Ref.IntRef d;
    public final /* synthetic */ Ref.IntRef e;

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        if (this.b.isShowing() == true) goto L6;
        this.a.d.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        return;
    L6:
        this.a.d.getLocationOnScreen(this.c);
        int[] r0 = this.c;
        if (r0.length == 2) goto L9;
        return;
    L9:
        Ref.IntRef r1 = this.d;
        int r2 = r1.element;
        if (r2 != (-1)) goto L14;
        r1.element = r0[0];
        Ref.IntRef r3 = this.e;
        r3.element = r0[1];
        return;
    L14:
        if (r2 == r0[0]) goto L16;
    L17:
        this.a.d.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        this.b.b();
        return;
    L16:
        if (this.e.element != r0[1]) goto L17;
    }

    public b(BubbleComponent r1, com.bytedance.android.livesdk.chatroom.view.k r2, int[] r3, Ref.IntRef r4, Ref.IntRef r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
