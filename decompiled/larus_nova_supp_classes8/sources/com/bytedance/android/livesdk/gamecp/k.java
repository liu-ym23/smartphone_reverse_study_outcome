package com.bytedance.android.livesdk.gamecp;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import androidx.lifecycle.ViewModel;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class k implements ov.a {

    public static final class a {
    }

    static {
    }

    public k() {
    }

    public final void N1() {
    }

    public final void U0() {
    }

    public final void a() {
    }

    public final void i2(String r2) {
        Intrinsics.checkNotNullParameter(r2, "reactId");
    }

    public final void isEnablePersonalRecommend() {
    }

    public final void s1() {
    }

    public final void u2() {
    }

    public final void x0() {
    }

    public final boolean hasToolbarShow() {
        ViewModel r4 = null;
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r0 == null) goto L7;
        com.bytedance.live.datacontext.j r1 = r0.getCommonSlotViewModel();
        if (r1 == null) goto L7;
        r4 = (ViewModel) r1.getValue();
    L7:
        if (r4 != null) goto L9;
        return false;
    L9:
        if ((r4 instanceof com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.m) == false) goto L13;
        return ((com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.m) r4).isComponentShowing(5);
    L13:
        if ((r4 instanceof ot2.c) == true) goto L15;
        return false;
    L15:
        return ((ot2.c) r4).isComponentShowing(5);
    }

    public final Dialog i0(Context r3, String r4, CharSequence r5, String r6, DialogInterface.OnClickListener r7, String r8, com.bytedance.android.gamecp.common.utils.j r9) {
        if (r3 != null) goto L5;
        return null;
    L5:
        com.bytedance.dux.dialog.alert.g r1 = new com.bytedance.dux.dialog.alert.g(r3);
        r1.h = r4;
        r1.i = r5;
        boolean r10 = false;
        if (r6 != null) goto L8;
    L16:
        if (r8 == null) goto L26;
        if (r8.length() <= 0) goto L20;
        r10 = true;
    L20:
        if (r10 == true) goto L23;
        r8 = null;
    L23:
        if (r8 == null) goto L26;
        com.bytedance.dux.dialog.alert.g.d(r1, r8, r9);
    L26:
        return r1.a();
    L8:
        if (r6.length() <= 0) goto L10;
        boolean r11 = true;
    L11:
        if (r11 == true) goto L14;
        r6 = null;
    L14:
        if (r6 == null) goto L16;
        Intrinsics.checkNotNullParameter(r6, "text");
        r1.n = r6;
        r1.o = r7;
        r1.p = null;
        goto L16
    L10:
        r11 = false;
        goto L11
    }
}
