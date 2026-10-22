package com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg;

import android.view.ViewGroup;
import com.bytedance.android.live.base.model.message.m0;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.topcontainer.CleanStrategy;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.topcontainer.ConflictStrategy;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.topcontainer.DiscardReason;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.topcontainer.NativePSTopViewType;
import com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg.ui.LikeEggView;
import com.bytedance.ies.sdk.widgets.DataCenter;
import f52.j;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class LikeEggPSTopView extends j<com.bytedance.android.livesdk.chatroom.likeegg.a> {
    public CompositeImagePreviewDialog n;
    public final DataCenter o;
    public final LikeEggView p;

    @Override // f52.c
    public final void a(DiscardReason r3) {
        Intrinsics.checkNotNullParameter(r3, "reason");
        com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg.utils.c.a("LikeEggPSTopView onDiscard due to " + r3 + " id=" + this.a);
    }

    @Override // f52.c
    public final void h(final f52.b r4) {
        Intrinsics.checkNotNullParameter(r4, "container");
        com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg.utils.c.a("LikeEggPSTopView onShow id=" + this.a);
        int r0 = com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg.utils.b.a;
        LinkedHashMap r1 = new LinkedHashMap();
        r1.put("sequence_type", "like_scene");
        com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg.utils.b.b("livesdk_live_message_collection_show", r1);
        this.p.setFinishAction(new LikeEggPSTopView$onShow$1(this, r4));
        this.p.e((com.bytedance.android.livesdk.chatroom.likeegg.a) this.m);
        r4.b(this, this.p, new ViewGroup.LayoutParams(-1, -1));
    }

    @Override // f52.c
    public final CleanStrategy i(f52.b r2) {
        Intrinsics.checkNotNullParameter(r2, "container");
        com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg.utils.c.a("LikeEggPSTopView onShowFinish id=" + this.a);
        return CleanStrategy.REMOVE_WRAP_VIEW;
    }

    public static final void n(LikeEggPSTopView r0, String r1) {
        r0.getClass();
        int r2 = com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg.utils.c.a;
        Intrinsics.checkNotNullParameter(r1, "info");
        ALogger.d("LikeEggTracer", r1);
    }

    @Override // f52.c
    public final CleanStrategy b(f52.b r2, f52.c r3) {
        Intrinsics.checkNotNullParameter(r2, "container");
        StringBuilder r4 = new StringBuilder("LikeEggPSTopView onInterrupt by ");
        if (r3 == null) goto L5;
        String r5 = r3.getId();
    L6:
        r4.append(r5);
        r4.append(" id=");
        r4.append(this.a);
        com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg.utils.c.a(r4.toString());
        this.p.setFinishAction(null);
        this.p.f();
        return CleanStrategy.REMOVE_WRAP_VIEW;
    L5:
        r5 = null;
        goto L6
    }

    public LikeEggPSTopView(com.bytedance.android.livesdk.chatroom.likeegg.a r19, long r20, DataCenter r23, LikeEggView r24) {
        Intrinsics.checkNotNullParameter(r19, "msg");
        Intrinsics.checkNotNullParameter(r24, "likeEggView");
        StringBuilder r0 = new StringBuilder("like_egg_");
        m0 r1 = r19.commonData;
        if (r1 == null) goto L5;
        Object r2 = Long.valueOf(r1.getMessageId());
    L6:
        r0.append(r2);
        String r3 = r0.toString();
        NativePSTopViewType r4 = NativePSTopViewType.LikeEgg;
        ConflictStrategy r11 = ConflictStrategy.DISCARD;
        super(r3, r4, r20, Integer.MAX_VALUE, 0, 0, 0, r11, r11, ConflictStrategy.INTERRUPT, false, r19.highlightAreaPriorityConfig, r19);
        this.o = r23;
        this.p = r24;
        return;
    L5:
        r2 = Integer.valueOf(r19.hashCode());
        goto L6
    }
}
