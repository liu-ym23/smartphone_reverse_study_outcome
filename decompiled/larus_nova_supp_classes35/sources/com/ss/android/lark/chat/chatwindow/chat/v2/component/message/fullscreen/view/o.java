package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.view;

import android.view.GestureDetector;
import android.view.MotionEvent;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.view.clickhandler.ContentLongClickListener;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class o extends GestureDetector.SimpleOnGestureListener {
    public final /* synthetic */ MessageFullScreenRichTextSetup a;
    public final /* synthetic */ com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.view.clickhandler.c b;

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onSingleTapUp(MotionEvent r5) {
        Intrinsics.checkNotNullParameter(r5, "e");
        MessageFullScreenRichTextSetup r6 = this.a;
        ContentLongClickListener r0 = r6.h;
        if (r0 == null) goto L12;
        com.ss.android.lark.widget.select.m r3 = r0.d;
        if (r3 != null) goto L7;
    L9:
        boolean r4 = false;
    L10:
        if (r4 != true) goto L12;
        boolean r7 = true;
    L13:
        if (r7 == false) goto L16;
        if (r0 == null) goto L41;
        r0.d();
    L41:
        return true;
    L16:
        ContentLongClickListener r1 = r6.i;
        if (r1 == null) goto L26;
        com.ss.android.lark.widget.select.m r8 = r1.d;
        if (r8 != null) goto L21;
    L23:
        boolean r9 = false;
    L24:
        if (r9 != true) goto L26;
        boolean r10 = true;
    L27:
        if (r10 == false) goto L31;
        if (r1 == null) goto L41;
        r1.d();
        goto L41
    L31:
        if (r6.b == true) goto L33;
        return false;
    L33:
        Fragment r11 = this.b.b;
        if (r11.isAdded() == false) goto L41;
        com.suite.lark.component.navroute.forseti.g r2 = com.suite.lark.component.navroute.forseti.f.b(r11);
        if (r2 == null) goto L38;
        r2.g(null);
        goto L41
    L38:
        FragmentActivity r12 = r11.getActivity();
        if (r12 == null) goto L41;
        r12.finish();
        goto L41
    L21:
        if (r8.i != true) goto L23;
        r9 = true;
    L26:
        r10 = false;
        goto L27
    L7:
        if (r3.i != true) goto L9;
        r4 = true;
    L12:
        r7 = false;
        goto L13
    }

    public o(MessageFullScreenRichTextSetup r1, com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.view.clickhandler.c r2) {
        this.a = r1;
        this.b = r2;
    }
}
