package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.view.clickhandler;

import android.view.GestureDetector;
import android.view.MotionEvent;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.ss.android.lark.widget.light.LKUILightTextView;
import com.ss.android.lark.widget.select.SelectableView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class i extends GestureDetector.SimpleOnGestureListener {
    public final /* synthetic */ ContentLongClickListener a;

    public i(ContentLongClickListener r1) {
        this.a = r1;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onSingleTapUp(MotionEvent r4) {
        Intrinsics.checkNotNullParameter(r4, "e");
        ContentLongClickListener r5 = this.a;
        com.ss.android.lark.widget.select.m r0 = r5.d;
        if (r0 != null) goto L5;
    L15:
        LKUILightTextView r6 = r5.v;
        if (r6 == null) goto L18;
        SelectableView.State r7 = r6.getState();
    L20:
        if (r7 != SelectableView.State.SELECTED) goto L23;
        this.a.c.invoke();
        this.a.a.cancelLongPress();
        return true;
    L23:
        return false;
    L18:
        r7 = null;
        goto L20
    L5:
        if (r0.i != true) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == false) goto L15;
        ContentLongClickListener.c(r5.t);
        ContentLongClickListener r8 = this.a;
        com.ss.android.lark.widget.select.m r2 = r8.d;
        if (r2 == null) goto L13;
        UICallbackExecutor.post(new f(r2, r8));
    L13:
        this.a.a.cancelLongPress();
        return true;
    L7:
        r1 = false;
        goto L8
    }
}
