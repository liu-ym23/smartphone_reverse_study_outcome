package com.bytedance.android.livesdk.chatroom.ui.framework.widget.room;

import com.bytedance.android.livesdk.chatroom.ui.l8;
import com.bytedance.android.livesdk.chatroom.ui.m8;
import com.bytedance.android.livesdk.closeroom.CloseRoomInterceptList;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class i implements kf1.a {
    public final /* synthetic */ RoomCloseInterceptorWidget a;

    public final String tag() {
        return "QuitWithTaskInterceptor";
    }

    public final CloseRoomInterceptList config() {
        return CloseRoomInterceptList.DEFAULT;
    }

    public i(RoomCloseInterceptorWidget r1) {
        this.a = r1;
    }

    public final boolean qa(Runnable r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "afterInterceptRunnable");
        RoomCloseInterceptorWidget r5 = this.a;
        boolean r0 = RoomCloseInterceptorWidget.g;
        if (r5.getRoom() != null) goto L5;
        return false;
    L5:
        if (l8.c() == false) goto L20;
        m8 r6 = new m8(this.a.getContext(), this.a.d, r3);
        if (DialogLancet.shouldBlockDialogShow(r6) == false) goto L17;
        DialogLancet.handleBlockedDialogShow(r6);
        return true;
    L17:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L16
    L11:
        DialogLancet.beforeDialogShow(r6);
        r6.show();
        DialogLancet.afterDialogShow(r6);
        return true;
    L20:
        return false;
    }
}
