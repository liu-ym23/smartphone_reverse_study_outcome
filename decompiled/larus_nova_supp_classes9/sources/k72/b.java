package k72;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.e;
import com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.adapter.LiveRoomEnvStateHolder;
import com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.roomtype.common.d;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b extends a {
    public static final b d = null;

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.f
    public final String d() {
        return "PadVideoLiveAnchorHeightAdjustStrategy";
    }

    static {
        d = new b();
    }

    @Override // k72.a
    public final Integer f() {
        float r0 = d.c;
        return Integer.valueOf((int) d.c);
    }

    @Override // k72.a
    public final int g() {
        return (int) (s1.w() * 0.28f);
    }

    public b() {
    }

    @Override // k72.a
    public final com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.d h(int r8, int r9, e r10, Room r11, LiveRoomEnvStateHolder r13) {
        Intrinsics.checkNotNullParameter(r10, "uiContext");
        Intrinsics.checkNotNullParameter(r11, "room");
        Intrinsics.checkNotNullParameter(r13, "roomStatus");
        return d.e.a(r8, r9, r10, r11, r13);
    }
}
