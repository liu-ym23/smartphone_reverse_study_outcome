package l72;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.InteractionWidgetsPosContext;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.e;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.j;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.y;
import com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.adapter.LiveRoomEnvStateHolder;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.live.datacontext.m;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a implements com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.c {
    public final float c;
    public final float d;

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.f
    public final String d() {
        return "MatchAudienceRoomHeightAdjustStrategy";
    }

    public a() {
        this.c = s1.e(4.0f);
        this.d = s1.e(40.0f);
    }

    @Override // com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.c
    public final com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.d a(int r18, int r19, e r20, Room r21, LiveRoomEnvStateHolder r23) {
        Intrinsics.checkNotNullParameter(r20, "uiContext");
        Intrinsics.checkNotNullParameter(r21, "room");
        Intrinsics.checkNotNullParameter(r23, "roomStatus");
        com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.d r7 = null;
        if (r20.g1() == true) goto L5;
        boolean r1 = j.a;
        Intrinsics.checkNotNullParameter("MatchAudienceRoomHeightAdjustStrategy is Not Portrait View", "msg");
    L10:
        int r2 = 14;
        int r3 = 0;
    L17:
        if (r7 == null) goto L20;
        return r7;
    L20:
        return new com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.d(y.a(), r3, r2);
    L5:
        int r4 = r20.pT();
        int r5 = r20.WN();
        j r8 = j.c;
        r8.d("MatchAudienceRoomHeightAdjustStrategy ScreenHeight:" + s1.y() + " interactHeight:" + r4 + " videoBottom:" + r5);
        if (r5 >= ((((double) r4) * 0.2d) + ((((double) s1.y()) / 4.0d) * ((double) 3)))) goto L8;
        boolean r6 = true;
    L9:
        if (r6 == false) goto L10;
        float r9 = (((r4 - r5) - this.c) - r19) - this.d;
        r8.d("MatchAudienceRoomHeightAdjustStrategy publicScreenHeight:" + r9 + " videoGapWithoutGift:" + this.c + " currentMarginBottom:" + r19 + " tabHeight:" + this.d);
        InteractionWidgetsPosContext r10 = InteractionWidgetsPosContext.a.c(InteractionWidgetsPosContext.Companion, null, r21.getRoomId(), 1);
        if (r10 == null) goto L16;
        m r11 = r10.getMatchRoomGiftTrayPos();
        if (r11 == null) goto L16;
        r11.setValue(new ok1.a((int) r9, 1));
    L16:
        int r13 = (int) r9;
        r2 = 14;
        r3 = 0;
        r7 = new com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.d(r13, 0, 14);
        goto L17
    L8:
        r6 = false;
        goto L9
    }
}
