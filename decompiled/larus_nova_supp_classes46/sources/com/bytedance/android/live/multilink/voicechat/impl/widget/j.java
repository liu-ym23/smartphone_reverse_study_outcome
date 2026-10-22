package com.bytedance.android.live.multilink.voicechat.impl.widget;

import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.model.n0;
import com.bytedance.android.livesdk.chatroom.utils.g0;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.common.utility.Lists;
import com.bytedance.ies.sdk.widgets.Widget;
import hh1.w0;
import io.reactivex.subjects.BehaviorSubject;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class j extends com.bytedance.android.live.liveinteract.plantform.base.i.d {
    public final /* synthetic */ MultiLinkVoiceChatRoomAnchorWidget a;

    public j(MultiLinkVoiceChatRoomAnchorWidget r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.i.d, com.bytedance.android.live.liveinteract.plantform.base.i.b
    public final void onOnlineListChanged(List<? extends ILinkPlayerInfoBridge> r4) {
        Intrinsics.checkNotNullParameter(r4, "list");
        this.a.y1.clear();
        List<? extends ILinkPlayerInfoBridge> r1 = r4;
        this.a.y1.addAll(r1);
        ArrayList r0 = new ArrayList(r1);
        ((Widget) this.a).dataCenter.put("data_online_changed_list", r0);
        bn0.b r2 = this.a.getMultiLinkRoomScope();
        if (r2 == null) goto L9;
        jn0.b r3 = jn0.c.a(r2);
        if (r3 == null) goto L9;
        BehaviorSubject<List<ILinkPlayerInfoBridge>> r5 = r3.Xh();
        if (r5 == null) goto L9;
        r5.onNext(r0);
    L9:
        com.bytedance.android.live.liveinteract.plantform.utils.t.a(r4);
        if (this.a.Qq() == 16) goto L13;
        g0.e(r4.size());
    L13:
        if (r4.size() <= tc0.c.h().d) goto L15;
        tc0.c r6 = tc0.c.h();
        r6.d = r4.size();
    L15:
        this.a.J.k(r4);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.i.d, com.bytedance.android.live.liveinteract.plantform.base.i.b
    public final void d(List<? extends ILinkPlayerInfoBridge> r3, List<? extends ILinkPlayerInfoBridge> r4) {
        Intrinsics.checkNotNullParameter(r3, "list");
        Intrinsics.checkNotNullParameter(r4, "peerList");
        this.a.G1.clear();
        this.a.G1.addAll(r4);
        g0.e(r3.size() + r4.size());
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.base.i.d, com.bytedance.android.live.liveinteract.plantform.base.i.b
    public final void n(List<ILinkPlayerInfoBridge> r3, long r4, n0 r6) {
        String r5 = "";
        if (Lists.isEmpty(r3) == false) goto L5;
        ((Widget) this.a).dataCenter.put("data_audio_talk_dot_with_number_show", "");
    L18:
        w0 r7 = this.a.H;
        if (r7 == null) goto L23;
        if (r3 == null) goto L24;
        r7.O6(r3);
        return;
    L24:
        return;
    L23:
        return;
    L5:
        MultiLinkVoiceChatRoomAnchorWidget r8 = this.a;
        int r0 = MultiLinkVoiceChatRoomAnchorWidget.E2;
        int r9 = ((ArrayList) r8.yq().V4()).size();
        if (r9 > 99) goto L8;
        r9 = r9 + fj0.e.a();
    L8:
        String r1 = String.valueOf(r9);
        if (r9 <= 99) goto L11;
        r1 = "99+";
    L11:
        if (r9 <= 0) goto L15;
        r5 = r1;
    L15:
        if (r2.a(r5) == false) goto L17;
        this.a.getClass();
    L17:
        ((Widget) this.a).dataCenter.put("data_audio_talk_dot_with_number_show", r5);
        goto L18
    }
}
