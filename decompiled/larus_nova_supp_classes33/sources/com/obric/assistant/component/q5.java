package com.obric.assistant.component;

import android.view.MotionEvent;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class q5 implements View.OnTouchListener {
    public final /* synthetic */ OrionChatWindowComponent a;

    public /* synthetic */ q5(OrionChatWindowComponent r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r2, MotionEvent r3) {
        OrionChatWindowComponent r4 = this.a;
        int r0 = OrionChatWindowComponent.T;
        laa.d r5 = r4.B3();
        if (r5 == null) goto L7;
        Intrinsics.checkNotNull(r3);
        r5.Yx(r3);
        return false;
    L7:
        return false;
    }
}
