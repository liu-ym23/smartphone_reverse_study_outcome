package lr0;

import android.os.Bundle;
import com.bytedance.android.live.openplatform.impl.minigamecommon.context.MiniGameContext;
import com.bytedance.android.live.openplatform.impl.minigamecommon.context.OnMiniGameLifecycleChangeListener;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d extends lr0.a {

    public static final class a {
    }

    static {
    }

    public d(MiniGameContext r2) {
        Intrinsics.checkNotNullParameter(r2, "miniGameContext");
        super(r2);
    }

    public final Bundle onEvent(Bundle r3) {
        if (r3 != null) goto L4;
        return null;
    L4:
        if (r3.containsKey("game_interrupt") == true) goto L6;
        return null;
    L6:
        if (r3.getBoolean("game_interrupt") == false) goto L8;
        this.a.notifyMiniGameLifecycleChange(OnMiniGameLifecycleChangeListener.MiniGameLifecycle.OnStop);
        this.a.tryClearMiniGameInstance(MiniGameContext.StopType.ON_MINI_GAME_STOP);
        return null;
    L8:
        this.a.notifyMiniGameLifecycleChange(OnMiniGameLifecycleChangeListener.MiniGameLifecycle.OnResume);
        return null;
    }
}
