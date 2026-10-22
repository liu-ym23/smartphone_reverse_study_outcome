package com.bytedance.android.livesdk.interactivity.interactive;

import com.bytedance.android.livesdk.chatroom.vs_base.base.ReplayDataContext;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/interactive/VSMsgBoardServiceWidget;", "Lcom/bytedance/android/livesdk/interactivity/interactive/VSMsgBoardBaseWidget;", "<init>", "()V", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VSMsgBoardServiceWidget extends VSMsgBoardBaseWidget {
    @Override // com.bytedance.android.livesdk.interactivity.interactive.VSMsgBoardBaseWidget
    public final Map<String, String> wq() {
        return MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("is_replay", "0")});
    }

    public VSMsgBoardServiceWidget() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.interactive.VSMsgBoardBaseWidget
    public final com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.chatroom.msgboard.a> xq(DataCenter r4) {
        vr1.u r1 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.u(r4, null, 2);
        if (r1 == null) goto L5;
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.chatroom.msgboard.a> r2 = r1.h();
    L7:
        if ((r2 instanceof com.bytedance.live.datacontext.j) == true) goto L9;
        r2 = null;
    L9:
        if (r2 != null) goto L19;
        ReplayDataContext.Companion.getClass();
        ReplayDataContext r5 = ReplayDataContext.a.b(r4);
        if (r5 == null) goto L13;
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.chatroom.msgboard.a> r6 = r5.getVsMsgBoardDataContext();
    L15:
        if ((r6 instanceof com.bytedance.live.datacontext.j) == true) goto L20;
        return null;
    L20:
        return r6;
    L13:
        r6 = null;
        goto L15
    L19:
        return r2;
    L5:
        r2 = null;
        goto L7
    }

    @Override // com.bytedance.android.livesdk.interactivity.interactive.VSMsgBoardBaseWidget
    public final ylc.e yq(DataCenter r3) {
        vr1.u r4 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.u(r3, null, 2);
        if (r4 != null) goto L5;
        return null;
    L5:
        return r4.N0();
    }

    @Override // com.bytedance.android.livesdk.interactivity.interactive.VSMsgBoardBaseWidget
    public final void zq(String r8, Map<String, String> r9, String r10) {
        Intrinsics.checkNotNullParameter(r8, "name");
        Intrinsics.checkNotNullParameter(r10, "eventType");
        com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.l().s(r8, MapsKt.toMap(r9), "live", r10, "live_detail");
    }
}
