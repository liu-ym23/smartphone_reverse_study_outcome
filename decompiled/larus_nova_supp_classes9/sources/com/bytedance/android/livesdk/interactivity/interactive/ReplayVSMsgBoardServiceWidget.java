package com.bytedance.android.livesdk.interactivity.interactive;

import com.bytedance.android.livesdk.chatroom.vs_base.base.ReplayDataContext;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/interactive/ReplayVSMsgBoardServiceWidget;", "Lcom/bytedance/android/livesdk/interactivity/interactive/VSMsgBoardBaseWidget;", "<init>", "()V", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ReplayVSMsgBoardServiceWidget extends VSMsgBoardBaseWidget {
    @Override // com.bytedance.android.livesdk.interactivity.interactive.VSMsgBoardBaseWidget
    public final Map<String, String> wq() {
        Pair[] r0 = new Pair[2];
        r0[0] = TuplesKt.to("is_replay", "1");
        DataCenter r1 = ((Widget) this).dataCenter;
        if (r1 == null) goto L8;
        Episode r2 = com.bytedance.android.livesdk.chatroom.vs_base.util.h.a(r1);
        if (r2 == null) goto L8;
        String r3 = r2.attachRoomIdStr;
        if (r3 == null) goto L8;
    L9:
        r0[1] = TuplesKt.to("room_id", r3);
        return MapsKt.mutableMapOf(r0);
    L8:
        r3 = BuildConfig.FLAVOR;
        goto L9
    }

    public ReplayVSMsgBoardServiceWidget() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.interactive.VSMsgBoardBaseWidget
    public final com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.chatroom.msgboard.a> xq(DataCenter r3) {
        ReplayDataContext.a r4 = ReplayDataContext.Companion;
        DataCenter r0 = ((Widget) this).dataCenter;
        r4.getClass();
        ReplayDataContext r5 = ReplayDataContext.a.b(r0);
        if (r5 == null) goto L5;
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.chatroom.msgboard.a> r6 = r5.getVsMsgBoardDataContext();
    L7:
        if ((r6 instanceof com.bytedance.live.datacontext.j) == true) goto L10;
        return null;
    L10:
        return r6;
    L5:
        r6 = null;
        goto L7
    }

    @Override // com.bytedance.android.livesdk.interactivity.interactive.VSMsgBoardBaseWidget
    public final ylc.e yq(DataCenter r3) {
        ReplayDataContext.a r4 = ReplayDataContext.Companion;
        DataCenter r0 = ((Widget) this).dataCenter;
        r4.getClass();
        ReplayDataContext r5 = ReplayDataContext.a.b(r0);
        if (r5 == null) goto L7;
        com.bytedance.live.datacontext.j r6 = r5.getWrdsManager();
        if (r6 == null) goto L7;
        ylc.e r7 = (ylc.e) r6.getValue();
    L9:
        if ((r7 instanceof ylc.e) == true) goto L12;
        return null;
    L12:
        return r7;
    L7:
        r7 = null;
        goto L9
    }

    @Override // com.bytedance.android.livesdk.interactivity.interactive.VSMsgBoardBaseWidget
    public final void zq(String r3, Map<String, String> r4, String r5) {
        Intrinsics.checkNotNullParameter(r3, "name");
        Intrinsics.checkNotNullParameter(r5, "eventType");
        nm1.h r6 = pm1.f.f();
        if (r6 == null) goto L6;
        r6.g(((Widget) this).dataCenter, r3, r4, new Object[0]);
        return;
    }
}
