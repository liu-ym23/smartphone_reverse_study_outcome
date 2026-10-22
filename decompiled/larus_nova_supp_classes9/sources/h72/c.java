package h72;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.e;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.k;
import com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.adapter.LiveRoomEnvStateHolder;
import com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.i;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c implements i {
    public static final int c = 0;
    public static final c d = null;

    public c() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.f
    public final String d() {
        return "AudioLiveWidthPublicScreenAdjust";
    }

    static {
        d = new c();
        c = s1.j(2131169061);
    }

    @Override // com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.i
    public final k b(e r3, Room r4, LiveRoomEnvStateHolder r5) {
        Intrinsics.checkNotNullParameter(r3, "uiContext");
        Intrinsics.checkNotNullParameter(r4, "room");
        Intrinsics.checkNotNullParameter(r5, "roomStatus");
        if (r5.n0() == true) goto L14;
        if (r3.o70() == true) goto L14;
        if (r5.e0() == true) goto L12;
        return new k(c, 0, 6);
    L12:
        return new k(0, 0, 7);
    L14:
        return new k(c, 0, 6);
    }
}
