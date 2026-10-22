package com.bytedance.android.livesdk.chatroom.ui;

import com.bytedance.android.livesdk.closeroom.CloseRoomInterceptList;
import com.bytedance.android.livesdk.ktvapi.IKtvService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class p4 implements kf1.a {
    public final /* synthetic */ AbsInteractionFragment a;

    public final String tag() {
        return "AbsInteractionFragment_VsConcert";
    }

    public final CloseRoomInterceptList config() {
        return CloseRoomInterceptList.DEFAULT;
    }

    public p4(AbsInteractionFragment r1) {
        this.a = r1;
    }

    public final boolean qa(Runnable r3, boolean r4) {
        if (jc1.k.f(IKtvService.class) != null) goto L5;
    L11:
        return false;
    L5:
        if (jc1.k.f(IKtvService.class).getChorusConcertService() == null) goto L11;
        if (Boolean.valueOf(jc1.k.f(IKtvService.class).getChorusConcertService().b()).booleanValue() == true) goto L9;
        return false;
    L9:
        com.bytedance.android.livesdk.widget.x0.b r5 = new com.bytedance.android.livesdk.widget.x0.b(this.a.getContext(), 4);
        r5.m(2131923301);
        r5.l(2131923300);
        r5.i(0, 2131920806, new n4());
        r5.i(1, 2131915442, new o4());
        r5.n();
        return true;
    }
}
