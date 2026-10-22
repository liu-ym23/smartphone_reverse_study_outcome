package com.bytedance.android.live.liveinteract.videotalk;

import android.view.SurfaceView;
import android.view.View;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.live.liveinteract.plantform.permission.model.BaseCheckException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b0 implements qh0.d<rh0.a> {
    public final /* synthetic */ MultiLinkVideoTalkRoomGuestWidget a;
    public final /* synthetic */ lg6.a b;
    public final /* synthetic */ boolean c;

    @Override // qh0.d
    public final void b(BaseCheckException r2) {
        Intrinsics.checkNotNullParameter(r2, "exception");
        lg6.a r0 = this.b;
        if (r0 == null) goto L6;
        r0.onFailed(r2);
        return;
    }

    @Override // qh0.d
    public final void onResult(rh0.a r6) {
        if (this.c == true) goto L5;
        com.bytedance.android.live.liveinteract.linksecurity.b.m(com.bytedance.android.live.liveinteract.linksecurity.b.g);
    L5:
        lg6.a r7 = this.b;
        if (r7 == null) goto L8;
        r7.a(Unit.INSTANCE);
    L8:
        jg6.a r8 = this.a.Eq();
        int r0 = 1;
        if (r8 == null) goto L19;
        lh6.b r9 = r8.a();
        if (r9 == null) goto L19;
        if (je0.d.G() == false) goto L15;
    L17:
        boolean r1 = false;
    L18:
        ng6.c.a.a(r9, r1);
        goto L19
    L15:
        if (this.c == true) goto L17;
        r1 = true;
    L19:
        m00.g r10 = this.a.U;
        if (r10 == null) goto L22;
        r10.r();
    L22:
        tf0.o r11 = this.a.T;
        if (r11 == null) goto L25;
        r11.c(tc0.c.h().f, !this.c);
    L25:
        List r2 = null;
        if (this.c == false) goto L37;
        HashMap<String, View> r12 = this.a.h1;
        String r3 = tc0.c.h().f;
        m00.g r4 = this.a.U;
        if (r4 == null) goto L30;
        SurfaceView r5 = r4.getSurfaceView();
    L31:
        r12.put(r3, r5);
        tf0.o r13 = this.a.T;
        if (r13 == null) goto L37;
        String r14 = tc0.c.h().f;
        m00.g r15 = this.a.U;
        if (r15 == null) goto L36;
        r15.getSurfaceView();
    L36:
        r13.b(r14);
        goto L37
    L30:
        r5 = null;
    L37:
        com.bytedance.android.livesdk.sharedpref.e r16 = b6.p;
        if (this.c == false) goto L40;
        int r17 = 1;
    L41:
        r16.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r16, r17);
        com.bytedance.live.datacontext.j r18 = com.bytedance.android.live.liveinteract.api.utils.m.e(this.a).getVideoTalkRoomSubScene();
        if (r18 == null) goto L63;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r19 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r18.getValue();
        if (r19 == null) goto L64;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r20 = r19.t();
        if (r20 != null) goto L48;
        return;
    L48:
        if (r20.a != 12) goto L66;
        List r21 = r20.b;
        if (r21 != null) goto L52;
    L56:
        int r22 = 2;
    L57:
        Map r23 = (Map) b6.U.getValue();
        Integer r24 = Integer.valueOf(r22);
        if (this.c == true) goto L61;
        r0 = 2;
    L61:
        r23.put(r24, Integer.valueOf(r0));
        return;
    L52:
        if (r21.contains(1) == false) goto L54;
        r2 = r21;
    L54:
        if (r2 == null) goto L56;
        r22 = 1;
        goto L57
    L66:
        return;
    L64:
        return;
    L63:
        return;
    L40:
        r17 = 2;
        goto L41
    }

    public b0(MultiLinkVideoTalkRoomGuestWidget r1, lh6.c r2, boolean r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
