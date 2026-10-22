package com.bytedance.android.livesdk.chatroom.ui;

import android.view.ViewParent;
import android.widget.FrameLayout;
import com.bytedance.android.livesdk.config.ex0;
import com.bytedance.android.livesdkapi.roomplayer.LivePlayerView;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class o6 implements Runnable {
    public final /* synthetic */ InteractPlayViewManager a;

    public o6(InteractPlayViewManager r1) {
        this.a = r1;
    }

    public final void a() {
        ViewParent r1 = null;
        if (ex0.a.getValue().booleanValue() == false) goto L32;
        DataCenter r0 = this.a.z;
        if (r0 == null) goto L9;
        Integer r2 = (Integer) r0.get("cmd_interact_player_view_height_change", 0);
        if (r2 == null) goto L9;
        int r3 = r2.intValue();
    L10:
        if (r3 == 0) goto L14;
        InteractPlayViewManager r4 = this.a;
        if (r3 == r4.p) goto L51;
        r4.p = r3;
        r4.e = 0;
        return;
    L51:
        return;
    L14:
        LivePlayerView r5 = this.a.i;
        if (r5 == null) goto L19;
        ViewParent r6 = r5.getParent();
        if (r6 == null) goto L19;
        ViewParent r7 = r6.getParent();
    L21:
        if ((r7 instanceof FrameLayout) == false) goto L24;
        r1 = r7;
    L24:
        FrameLayout r8 = (FrameLayout) r1;
        if (r8 == null) goto L27;
        int r9 = r8.getHeight();
    L28:
        if (r9 == 0) goto L53;
        InteractPlayViewManager r10 = this.a;
        if (r9 == r10.p) goto L54;
        r10.p = r9;
        r10.e = 0;
        return;
    L54:
        return;
    L53:
        return;
    L27:
        r9 = 0;
    L19:
        r7 = null;
    L9:
        r3 = 0;
        goto L10
    L32:
        LivePlayerView r11 = this.a.i;
        if (r11 == null) goto L37;
        ViewParent r12 = r11.getParent();
        if (r12 == null) goto L37;
        ViewParent r13 = r12.getParent();
    L39:
        if ((r13 instanceof FrameLayout) == false) goto L42;
        r1 = r13;
    L42:
        FrameLayout r14 = (FrameLayout) r1;
        if (r14 == null) goto L45;
        int r15 = r14.getHeight();
    L46:
        if (r15 == 0) goto L56;
        InteractPlayViewManager r16 = this.a;
        if (r15 == r16.p) goto L57;
        r16.p = r15;
        r16.e = 0;
        return;
    L57:
        return;
    L56:
        return;
    L45:
        r15 = 0;
    L37:
        r13 = null;
        goto L39
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
