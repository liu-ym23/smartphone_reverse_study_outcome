package gr0;

import android.os.SystemClock;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.minigameaudience.applog.RoomWatchDurationContextService;
import com.bytedance.android.live.openplatform.impl.minigamecommon.context.MiniGameContext;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a<T> implements Consumer {
    public final /* synthetic */ RoomWatchDurationContextService a;

    public a(RoomWatchDurationContextService r1) {
        this.a = r1;
    }

    public final void accept(Object r6) {
        Boolean r7 = (Boolean) r6;
        int r0 = qo0.a.a;
        qo0.a.c(this.a.a, "isCandyToolbarShow: " + r7);
        if (r7.booleanValue() == false) goto L7;
        RoomWatchDurationContextService r8 = this.a;
        if ((-1) != r8.b) goto L13;
        r8.b = SystemClock.elapsedRealtime();
        return;
    L13:
        return;
    L7:
        this.a.f();
        OpenPlatformContext r9 = this.a.getOpenPlatformContext();
        if (r9 == null) goto L12;
        ((MiniGameContext) r9).setMiniGameInstance(null);
        this.a.dispose();
        RoomWatchDurationContextService r10 = this.a;
        r10.b = -1;
        r10.c = false;
        r10.e = false;
        return;
    L12:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.openplatform.impl.minigamecommon.context.MiniGameContext");
    }
}
