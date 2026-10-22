package com.bytedance.android.live.liveinteract.plantform.widgt;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.chatroom.utils.g0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdkapi.model.MultiLinkFrequencyOptConfig;
import io.reactivex.functions.Consumer;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ AudioSceneBasicBusinessContentWidget a;

    public c(AudioSceneBasicBusinessContentWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r11) {
        com.bytedance.android.livesdk.chatroom.viewmodel.i r12 = (com.bytedance.android.livesdk.chatroom.viewmodel.i) r11;
        AudioSceneBasicBusinessContentWidget r0 = this.a;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.m r1 = null;
        if (r12 == null) goto L83;
        x00.c r2 = r0.d;
        if (r2 == null) goto L62;
        if (r12.a != 5) goto L62;
        if (r12.b == 28) goto L62;
        int r4 = 2;
        r2.q(2);
        MultiLinkFrequencyOptConfig r3 = com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.f.a;
        if (com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.f.j(Integer.valueOf(r12.b)) == false) goto L15;
        x00.c r5 = r0.d;
        if (r5 == null) goto L18;
        IVoiceLiveTheme r6 = r5.q(5);
    L19:
        IRoom r7 = r0.e;
        if (r6 == null) goto L62;
        if (r7 == null) goto L62;
        int r8 = com.bytedance.android.live.liveinteract.plantform.utils.d.a;
        Intrinsics.checkNotNullParameter(r12, "switchSceneEvent");
        int r9 = r12.b;
        if (((Boolean) vm2.d.M7.getValue(null, vm2.d.a[451(0x1c3, float:6.32E-43)])).booleanValue() == false) goto L53;
        com.bytedance.android.livesdk.chatroom.u r10 = com.bytedance.android.live.liveinteract.api.utils.m.d();
        boolean r13 = false;
        if (r10 != null) goto L27;
    L47:
        int r14 = 0;
    L49:
        if (ArraysKt.contains(vm2.d.H0(), Integer.valueOf(r14)) == false) goto L51;
    L52:
        r13 = true;
    L54:
        if (r13 == true) goto L62;
        if (com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.f.j(Integer.valueOf(r12.b)) == false) goto L58;
        r4 = 5;
    L58:
        x00.c r15 = r0.d;
        if (r15 == null) goto L62;
        r15.m(r7.getRoomId(), r6, r4);
        goto L62
    L51:
        if (ArraysKt.contains(vm2.d.H0(), Integer.valueOf(r9)) == false) goto L54;
    L27:
        if (r10.s() == null) goto L47;
        com.bytedance.live.datacontext.j r16 = r10.s();
        if (r16 == null) goto L31;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r17 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r16.getValue();
    L32:
        if (r17 == null) goto L47;
        com.bytedance.live.datacontext.j r18 = r10.s();
        if (r18 == null) goto L38;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r19 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r18.getValue();
        if (r19 == null) goto L38;
        com.bytedance.android.livesdk.chatroom.viewmodel.i r20 = r19.g();
    L39:
        if (r20 == null) goto L47;
        com.bytedance.live.datacontext.j r21 = r10.s();
        if (r21 == null) goto L47;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r22 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r21.getValue();
        if (r22 == null) goto L47;
        com.bytedance.android.livesdk.chatroom.viewmodel.i r23 = r22.g();
        if (r23 == null) goto L47;
        r14 = r23.b;
    L38:
        r20 = null;
        goto L39
    L31:
        r17 = null;
        goto L32
    L53:
        r13 = ArraysKt.contains(vm2.d.H0(), Integer.valueOf(r9));
    L18:
        r6 = null;
        goto L19
    L15:
        x00.c r24 = r0.d;
        if (r24 == null) goto L18;
        r6 = r24.q(2);
    L62:
        if (r12.a == 9) goto L64;
    L77:
        int r25 = r12.a;
        if (r25 == 0) goto L80;
    L82:
        g0.c(r25);
        g0.d(r12.b);
    L85:
        if (vm2.d.y() == true) goto L87;
        return;
    L87:
        if (vm2.d.x() == false) goto L99;
        if (r12 != null) goto L90;
        return;
    L90:
        if (r12.a != 0) goto L101;
        com.bytedance.live.datacontext.j r110 = com.bytedance.android.live.liveinteract.api.utils.m.i().getCompactTbLoader();
        if (r110 == null) goto L94;
        r1 = (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.m) r110.getValue();
    L94:
        if (r1 == null) goto L96;
        r1.refreshExistComponent(26);
    L96:
        ALogger.i("AudioSceneBasicBusinessContentWidget", "[LinkmicIconDoubleCheck] radioWidget load refresh icon");
        return;
    L101:
        return;
    L99:
        return;
    L80:
        if (r12.b != 0) goto L82;
        g0.c(5);
        g0.b();
        goto L85
    L64:
        if (r12.b != 61) goto L77;
        x00.c r26 = r0.d;
        if (r26 == null) goto L68;
        IVoiceLiveTheme r27 = r26.q(100);
    L69:
        if (r27 == null) goto L77;
        x00.c r28 = r0.d;
        if (r28 == null) goto L77;
        IRoom r29 = r0.e;
        if (r29 == null) goto L75;
        long r30 = r29.getRoomId();
    L76:
        r28.m(r30, r27, 100);
        goto L77
    L75:
        r30 = 0;
        goto L76
    L68:
        r27 = null;
        goto L69
    L83:
        int r31 = AudioSceneBasicBusinessContentWidget.s;
        r0.getClass();
        goto L85
    }
}
