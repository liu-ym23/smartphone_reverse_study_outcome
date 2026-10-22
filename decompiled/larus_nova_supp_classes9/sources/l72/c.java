package l72;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.e;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.k;
import com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.adapter.LiveRoomEnvStateHolder;
import com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.i;
import com.bytedance.android.livesdk.utils.e5;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c implements i {
    public static final c c = null;

    public c() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.f
    public final String d() {
        return "PadMatchRoomAudienceWidthAdjust";
    }

    static {
        c = new c();
    }

    @Override // com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.i
    public final k b(e r2, Room r3, LiveRoomEnvStateHolder r4) {
        Intrinsics.checkNotNullParameter(r2, "uiContext");
        Intrinsics.checkNotNullParameter(r3, "room");
        Intrinsics.checkNotNullParameter(r4, "roomStatus");
        if (e5.n() == false) goto L5;
        float r5 = s1.y();
        float r6 = 0.3f;
    L7:
        return new k((int) (r5 * r6), 0, 6);
    L5:
        r5 = s1.y();
        r6 = 0.6f;
        goto L7
    }
}
