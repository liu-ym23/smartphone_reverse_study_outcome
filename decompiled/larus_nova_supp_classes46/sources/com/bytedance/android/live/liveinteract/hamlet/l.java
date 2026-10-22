package com.bytedance.android.live.liveinteract.hamlet;

import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import io.reactivex.functions.Consumer;
import kotlin.Pair;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class l<T> implements Consumer {
    public final /* synthetic */ HamletAvatarWidget a;

    public l(HamletAvatarWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r7) {
        Pair r8 = (Pair) r7;
        HamletAvatarWidget r0 = this.a;
        com.bytedance.android.livesdk.chatroom.viewmodel.i r1 = (com.bytedance.android.livesdk.chatroom.viewmodel.i) r8.getFirst();
        com.bytedance.android.livesdk.chatroom.viewmodel.i r9 = (com.bytedance.android.livesdk.chatroom.viewmodel.i) r8.getSecond();
        int r2 = HamletAvatarWidget.T;
        DataCenter r3 = ((Widget) r0).dataCenter;
        Boolean r4 = Boolean.FALSE;
        Boolean r5 = (Boolean) r3.get("data_hamlet_avatar_status", r4);
        if (r1 != null) goto L5;
        return;
    L5:
        if (r1.b != 28) goto L32;
        if (r9 == null) goto L10;
        if (r9.b != 28) goto L10;
        return;
    L10:
        if (r5.booleanValue() == false) goto L29;
        com.bytedance.android.live.liveinteract.plantform.datamerge.handler.g r10 = r0.s;
        if (r10 == null) goto L14;
        r10.b = null;
        r10.c = null;
        r10.d = null;
        r10.c();
    L14:
        ((Widget) r0).dataCenter.put("data_hamlet_avatar_status", r4);
        HamletAvatarContext r11 = HamletAvatarContext.Companion.getContext();
        if (r11 == null) goto L21;
        com.bytedance.live.datacontext.m<Boolean> r12 = r11.isMultiAvatarMode();
        if (r12 == null) goto L21;
        Boolean r13 = (Boolean) r12.getValue();
        if (r13 == null) goto L21;
        boolean r14 = r13.booleanValue();
    L22:
        HamletAvatarContext r6 = r0.f;
        if (r6 == null) goto L25;
        r6.resetXplayState();
    L25:
        int r15 = vd0.a.g;
        vd0.a.C0284a.a(((Widget) r0).dataCenter).c();
        if (r14 == true) goto L28;
        r0.Nq("onVoiceChatRoomSubSceneChange");
        goto L29
    L28:
        r0.dr();
    L21:
        r14 = false;
    L29:
        r0.Sq(false, false);
        return;
    }
}
