package com.bytedance.android.live.liveinteract.videotalk;

import com.bytedance.android.live.liveinteract.utils.c1;
import com.bytedance.android.livesdkapi.depend.message.ClientUIInfo;
import com.bytedance.android.livesdkapi.model.SeiAppData;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a0<T> implements Consumer {
    public final /* synthetic */ MultiLinkVideoTalkRoomGuestWidget a;

    public a0(MultiLinkVideoTalkRoomGuestWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r7) {
        m81.a r8 = (m81.a) r7;
        com.bytedance.android.livesdk.chatroom.u r9 = com.bytedance.android.live.liveinteract.api.utils.m.e(this.a);
        ClientUIInfo r0 = null;
        if (r9 == null) goto L9;
        com.bytedance.live.datacontext.j r10 = r9.getVideoTalkRoomSubScene();
        if (r10 == null) goto L9;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r11 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r10.getValue();
        if (r11 == null) goto L9;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r12 = r11.t();
    L11:
        if (r12 == null) goto L13;
        int r2 = r12.a;
    L14:
        if (r12 == null) goto L16;
        int r3 = r12.c;
    L17:
        if (r12 == null) goto L20;
        List<Integer> r4 = r12.b;
        if (r4 == null) goto L20;
    L21:
        int r5 = c1.a;
        if (c1.a(0, Integer.valueOf(r3)) == false) goto L38;
        if (r12 == null) goto L26;
        r0 = r12.e;
    L26:
        if (this.a.isEngineOn() == false) goto L31;
        zj0.e r13 = this.a.X2;
        if (r13 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("layoutSwitcher");
    L30:
        r13.f(new zj0.c.d(r2, r3), r4, r0);
        return;
    L31:
        MultiLinkVideoTalkRoomGuestWidget r14 = this.a;
        SeiAppData r6 = r14.K2;
        if (r6 == null) goto L40;
        zj0.e r15 = r14.X2;
        if (r15 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("layoutSwitcher");
    L36:
        r15.f(new zj0.c.e(r6, this.a.L2), r4, r0);
        return;
    L40:
        return;
    L38:
        return;
    L20:
        r4 = CollectionsKt.emptyList();
        goto L21
    L16:
        r3 = 0;
        goto L17
    L13:
        r2 = 0;
    L9:
        r12 = null;
        goto L11
    }
}
