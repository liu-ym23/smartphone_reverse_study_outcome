package gr0;

import android.os.SystemClock;
import com.bytedance.android.live.openplatform.api.minigame.datacontext.AudienceMiniGameDataContext;
import com.bytedance.android.live.openplatform.impl.minigameaudience.applog.RoomWatchDurationContextService;
import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livehostapi.business.IHostLiveOpenPlatform;
import com.bytedance.live.datacontext.m;
import io.reactivex.functions.Consumer;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b<T> implements Consumer {
    public final /* synthetic */ RoomWatchDurationContextService a;

    public b(RoomWatchDurationContextService r1) {
        this.a = r1;
    }

    public final void accept(Object r6) {
        Boolean r7 = (Boolean) r6;
        int r0 = qo0.a.a;
        qo0.a.c(this.a.a, "isRoomBackground: " + r7);
        this.a.d = r7.booleanValue();
        if (r7.booleanValue() == true) goto L10;
        IHostLiveOpenPlatform r1 = TTLiveSDK.hostService().hostOpenPlatform();
        JSONObject r2 = new JSONObject();
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L7
        Result.constructor-impl(r2.put("event", "onResume"));     // Catch: Throwable -> L7
    L9:
        Unit r4 = Unit.INSTANCE;
        r1.dispatchMiniGameEvent("live_room_lifecycle_event", r2);
    L7:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    L10:
        AudienceMiniGameDataContext.Companion.getClass();
        AudienceMiniGameDataContext r8 = AudienceMiniGameDataContext.a.a();
        if (r8 == null) goto L18;
        m<Boolean> r9 = r8.isCandyToolbarShow();
        if (r9 == null) goto L18;
        if (((Boolean) r9.getValue()).booleanValue() == true) goto L18;
        return;
    L18:
        if (r7.booleanValue() == false) goto L23;
        RoomWatchDurationContextService r10 = this.a;
        if (r10.c == true) goto L32;
        r10.f();
        return;
    L32:
        return;
    L23:
        RoomWatchDurationContextService r11 = this.a;
        if ((-1) != r11.b) goto L30;
        r11.b = SystemClock.elapsedRealtime();
        return;
    }
}
