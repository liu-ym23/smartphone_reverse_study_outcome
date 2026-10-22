package l72;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.e;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.y;
import com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.adapter.LiveRoomEnvStateHolder;
import com.bytedance.android.livesdk.utils.e5;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b implements com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.c {
    public static final float c = 0.0f;
    public static final float d = 0.0f;
    public static final float e = 0.0f;
    public static final b f = null;

    public b() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.f
    public final String d() {
        return "PadMatchRoomAudienceHeightAdjust";
    }

    static {
        f = new b();
        c = s1.e(64.0f);
        d = s1.e(4.0f);
        e = s1.e(40.0f);
    }

    @Override // com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.c
    public final com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.d a(int r7, int r8, e r9, Room r10, LiveRoomEnvStateHolder r11) {
        Intrinsics.checkNotNullParameter(r9, "uiContext");
        Intrinsics.checkNotNullParameter(r10, "room");
        Intrinsics.checkNotNullParameter(r11, "roomStatus");
        if (e5.n() == true) goto L5;
        int r13 = r9.pT();
        int r14 = r9.WN();
        if (r14 >= ((((double) r13) * 0.2d) + ((((double) s1.y()) / 4.0d) * ((double) 3)))) goto L9;
        boolean r15 = true;
    L11:
        if (r15 == true) goto L15;
        return new com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.d(y.a(), 0, 14);
    L15:
        return new com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.d((int) ((((r13 - r14) - d) - r8) - e), 0, 14);
    L9:
        r15 = false;
        goto L11
    L5:
        return new com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.d((int) (s1.w() * 0.28f), (int) c, 12);
    }
}
