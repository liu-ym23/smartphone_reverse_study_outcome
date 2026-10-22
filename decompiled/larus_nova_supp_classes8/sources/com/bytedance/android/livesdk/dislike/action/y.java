package com.bytedance.android.livesdk.dislike.action;

import android.view.View;
import com.bytedance.android.livesdk.dislike.ActionsManager;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class y extends OptionAction {
    public final ActionsManager e;

    public y(ActionsManager r2) {
        Intrinsics.checkNotNullParameter(r2, "actionManager");
        super(r2);
        this.e = r2;
    }

    @Override // com.bytedance.android.livesdk.dislike.action.OptionAction
    public final void a(View r9) {
        Intrinsics.checkNotNullParameter(r9, "v");
        Object r10 = r9.getTag();
        if ((r10 instanceof pt1.a) == true) goto L5;
        r10 = null;
    L5:
        pt1.a r4 = (pt1.a) r10;
        if (r4 != null) goto L8;
        return;
    L8:
        xs2.b.a().post(new mt1.a(5, this.b, this.e.e, r4, false, 16));
        Map r11 = MapsKt.mapOf(TuplesKt.to("share_platform", "long_press"));
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_follower_share", r11, new Object[]{am2.x.class, Room.class});
    }
}
