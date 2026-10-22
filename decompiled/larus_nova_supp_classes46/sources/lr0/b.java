package lr0;

import android.os.Bundle;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.openplatform.api.minigame.datacontext.MiniGameDataContext;
import com.bytedance.android.live.openplatform.impl.minigamecommon.context.MiniGameContext;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.live.datacontext.m;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b extends a {
    public final MiniGameContext b;

    public b(MiniGameContext r2) {
        Intrinsics.checkNotNullParameter(r2, "miniGameContext");
        super(r2);
        this.b = r2;
    }

    public final Bundle onEvent(Bundle r5) {
        ALogger.d("OnLiveInstantPlayStatusEventListener", "onEvent");
        Bundle r6 = new Bundle();
        Room r0 = this.b.getRoom();
        LiveMode r1 = null;
        if (r0 == null) goto L5;
        LiveMode r2 = r0.getStreamType();
    L6:
        int r3 = 0;
        if (r2 == LiveMode.VIDEO) goto L15;
        Room r4 = this.b.getRoom();
        if (r4 == null) goto L12;
        r1 = r4.getStreamType();
    L12:
        if (r1 == LiveMode.THIRD_PARTY) goto L15;
        boolean r7 = false;
    L16:
        r6.putBoolean("instant_play_is_video_live", r7);
        r6.putBoolean("instant_play_is_anchor", this.b.isAnchor());
        MiniGameDataContext.Companion.getClass();
        MiniGameDataContext r8 = MiniGameDataContext.a.a();
        if (r8 == null) goto L23;
        m<Integer> r9 = r8.getInstantPlayToggleStatus();
        if (r9 == null) goto L23;
        Integer r10 = (Integer) r9.getValue();
        if (r10 == null) goto L23;
        int r11 = r10.intValue();
    L24:
        r6.putInt("instant_play_toggle_status", r11);
        MiniGameDataContext r12 = MiniGameDataContext.a.a();
        if (r12 == null) goto L31;
        m<Integer> r13 = r12.getInstantPlayOpenStatus();
        if (r13 == null) goto L31;
        Integer r14 = (Integer) r13.getValue();
        if (r14 == null) goto L31;
        r3 = r14.intValue();
    L31:
        r6.putInt("instant_play_open_status", r3);
        return r6;
    L23:
        r11 = 0;
    L15:
        r7 = true;
        goto L16
    L5:
        r2 = null;
        goto L6
    }
}
