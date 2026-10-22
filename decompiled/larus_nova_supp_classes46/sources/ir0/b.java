package ir0;

import android.os.Bundle;
import com.bytedance.android.live.openplatform.impl.minigameaudience.applog.RoomWatchDurationContextService;
import com.bytedance.android.live.openplatform.impl.minigamecommon.context.MiniGameContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b extends lr0.a {
    public b(MiniGameContext r2) {
        Intrinsics.checkNotNullParameter(r2, "miniGameContext");
        super(r2);
    }

    public final Bundle onEvent(Bundle r2) {
        RoomWatchDurationContextService r3 = (RoomWatchDurationContextService) this.a.getService(RoomWatchDurationContextService.class);
        r3.e = true;
        r3.f();
        return null;
    }
}
