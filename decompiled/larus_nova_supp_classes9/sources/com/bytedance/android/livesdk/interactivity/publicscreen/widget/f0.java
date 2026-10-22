package com.bytedance.android.livesdk.interactivity.publicscreen.widget;

import android.view.View;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.pin.PublicScreenPinType;
import com.bytedance.android.livesdk.interactivity.publicscreen.adapter.MessageListAdapter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f0 implements v92.c {
    public final /* synthetic */ TextMessageWidget a;

    public f0(TextMessageWidget r1) {
        this.a = r1;
    }

    public final void a(com.bytedance.android.livesdk.interactivity.textmessage.model.c0 r8) {
        TextMessageWidget r0 = this.a;
        if (r0.l != null) goto L6;
        return;
    L6:
        if (r0.o.getChildAt(0) == null) goto L49;
        com.bytedance.android.livesdk.interactivity.publicscreen.pin.c r1 = r0.l;
        PublicScreenPinType r3 = PublicScreenPinType.ROOM_NOTICE;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, "type");
        u42.b r2 = r1.a;
        u42.b r5 = null;
        if (r2 == null) goto L11;
        PublicScreenPinType r4 = r2.getType();
    L13:
        if (r4 != r3) goto L15;
        boolean r6 = true;
    L16:
        if (r6 == false) goto L32;
        com.bytedance.android.livesdk.interactivity.publicscreen.pin.c r7 = r0.l;
        r7.getClass();
        Intrinsics.checkNotNullParameter(r3, "type");
        Intrinsics.checkNotNullParameter(r8, "message");
        u42.b r9 = r7.a;
        if (r9 != null) goto L20;
        return;
    L20:
        if (r9.getType() != r3) goto L22;
        boolean r10 = true;
    L23:
        if (r10 == false) goto L25;
        r5 = r9;
    L25:
        if (r5 == null) goto L42;
        u42.f.a("update current. type=" + r3);
        View r11 = r7.e.getChildAt(0);
        if (r11 != null) goto L29;
        Intrinsics.checkNotNullParameter("no view available", "info");
        ALogger.i("PublicScreenPinContainer", "no view available");
        return;
    L29:
        r5.d(r8);
        long r13 = r5.j(new u42.i(r8, r11, r7.d, r7.g.e.m));
        if (r13 <= 0) goto L44;
        r7.b().removeMessages(1);
        r7.b().sendEmptyMessageDelayed(1, r13);
        return;
    L44:
        return;
    L42:
        return;
    L22:
        r10 = false;
        goto L23
    L32:
        r0.f.removeMessages(5);
        r0.f.sendEmptyMessageDelayed(5, r8.b.i());
        int r14 = r0.r.d();
        if (r14 < 0) goto L46;
        com.bytedance.android.livesdk.interactivity.publicscreen.utils.n r15 = r0.Z;
        if (r15 == null) goto L47;
        MessageListAdapter r16 = r0.p;
        if (r16 == null) goto L50;
        r15.b(new com.bytedance.android.livesdk.interactivity.publicscreen.utils.o(r16, r14), "NotifyItemChanged");
        return;
    L50:
        return;
    L47:
        return;
    L46:
        return;
    L15:
        r6 = false;
        goto L16
    L11:
        r4 = null;
        goto L13
    }
}
