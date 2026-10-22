package com.bytedance.android.livesdk.chatroom.ui.framework.widget;

import android.widget.TextView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.widget.CountDownView;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.Widget;
import com.larus.apm.impl.protector.RunnableProtector;
import java.security.SecureRandom;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class g1 implements Runnable {
    public final /* synthetic */ ShowCountDownWidget a;

    public g1(ShowCountDownWidget r1) {
        this.a = r1;
    }

    public final void a() {
        ShowCountDownWidget r0 = this.a;
        com.bytedance.android.livesdk.chatroom.ui.framework.c r1 = r0.c;
        Room r2 = null;
        if (r1 == null) goto L5;
        LiveMode r3 = r1.getLiveMode();
    L6:
        boolean r4 = true;
        if (r3 != null) goto L9;
    L10:
        com.bytedance.android.livesdk.log.filter.n0 r5 = com.bytedance.android.livesdk.log.u.l().c(am2.x.class);
        if ((r5 instanceof com.bytedance.android.livesdk.log.filter.n0) == false) goto L13;
        r5.getClass();
    L13:
        CountDownView r6 = r0.d;
        if (r6 == null) goto L16;
        r6.setVisibility(0);
    L16:
        CountDownView r7 = r0.d;
        if (r7 == null) goto L19;
        r7.setNeedAccessibility(true);
    L19:
        r3.p(r0.d);
        CountDownView r8 = r0.d;
        if (r8 == null) goto L22;
        r8.setCountDownListener(new j1(r0));
    L22:
        CountDownView r9 = r0.d;
        if (r9 == null) goto L26;
        r9.c(true);
    L26:
        if (ms1.h.a() == false) goto L52;
        RoomContext r10 = RoomContext.a.c(RoomContext.Companion, ((Widget) r0).dataCenter, 0, 2);
        if (r10 == null) goto L36;
        com.bytedance.live.datacontext.j r11 = r10.getAnchorRoomScopeViewModel();
        if (r11 == null) goto L36;
        nz.l r12 = (nz.l) r11.getValue();
        if (r12 == null) goto L36;
        com.bytedance.android.live.broadcast.api.scope.service.f r13 = (com.bytedance.android.live.broadcast.api.scope.service.f) r12.a();
        if (r13 == null) goto L36;
        String r14 = r13.a();
    L37:
        if (r14 != null) goto L39;
    L42:
        if (r4 == true) goto L49;
        TextView r15 = r0.e;
        if (r15 == null) goto L46;
        r15.setText(r14);
    L46:
        TextView r16 = r0.e;
        if (r16 == null) goto L52;
        r16.setVisibility(0);
        goto L52
    L49:
        TextView r17 = r0.e;
        if (r17 == null) goto L52;
        r17.setVisibility(8);
        goto L52
    L39:
        if (r14.length() == 0) goto L42;
        r4 = false;
    L36:
        r14 = null;
    L52:
        com.bytedance.android.livesdk.chatroom.ui.framework.c r18 = r0.c;
        if (r18 == null) goto L55;
        Room r19 = r18.getRoom();
    L56:
        if (r19 == null) goto L75;
        com.bytedance.android.livesdk.chatroom.ui.framework.c r20 = r0.c;
        if (r20 == null) goto L60;
        r2 = r20.getRoom();
    L60:
        if (r2 != null) goto L62;
        return;
    L62:
        if (r2.getVisibilityRange() != 11) goto L77;
        String[] r21 = s1.D();
        if (r21 != null) goto L66;
    L70:
        TextView r22 = r0.e;
        if (r22 == null) goto L78;
        r22.setVisibility(0);
        return;
    L78:
        return;
    L66:
        if (r21.length <= 0) goto L70;
        String r23 = r21[new SecureRandom().nextInt(r21.length)];
        TextView r24 = r0.e;
        if (r24 == null) goto L70;
        r24.setText("小贴士：" + r23);
        goto L70
    L77:
        return;
    L75:
        return;
    L55:
        r19 = null;
        goto L56
    L9:
        if (r3.isStreamingBackground() != true) goto L10;
        return;
    L5:
        r3 = null;
        goto L6
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
