package k72;

import com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.d;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.e;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.PublicScreenStyleHelper;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.y;
import com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.adapter.LiveRoomEnvStateHolder;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c extends a {
    public static boolean d;
    public static final c e = null;

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.f
    public final String d() {
        return "VideoLiveAnchorHeightAdjustStrategy";
    }

    static {
        e = new c();
        d = true;
    }

    @Override // k72.a
    public final Integer f() {
        if (d == true) goto L7;
        return null;
    L7:
        return Integer.valueOf(PublicScreenStyleHelper.a);
    }

    @Override // k72.a
    public final int g() {
        return y.a();
    }

    public c() {
    }

    @Override // k72.a, com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.c
    public final d a(int r2, int r3, e r4, Room r5, LiveRoomEnvStateHolder r6) {
        Intrinsics.checkNotNullParameter(r4, "uiContext");
        Intrinsics.checkNotNullParameter(r5, "room");
        Intrinsics.checkNotNullParameter(r6, "roomStatus");
        d = true;
        return super.a(r2, r3, r4, r5, r6);
    }

    @Override // k72.a
    public final d h(int r8, int r9, e r10, Room r11, LiveRoomEnvStateHolder r13) {
        Intrinsics.checkNotNullParameter(r10, "uiContext");
        Intrinsics.checkNotNullParameter(r11, "room");
        Intrinsics.checkNotNullParameter(r13, "roomStatus");
        return com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.roomtype.common.a.c.a(r8, r9, r10, r11, r13);
    }
}
