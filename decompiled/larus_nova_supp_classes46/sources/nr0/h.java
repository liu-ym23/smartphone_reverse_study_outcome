package nr0;

import android.content.Context;
import com.bytedance.android.annie.util.ThreadUtils;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.profit.lottery.LotteryState;
import com.bytedance.android.live.profit.lottery.i;
import com.bytedance.android.live.profit.lottery.l;
import com.bytedance.android.live.profit.lottery.t;
import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livehostapi.business.IHostLiveOpenPlatform;
import com.bytedance.live.datacontext.n;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import io.reactivex.disposables.CompositeDisposable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class h {
    public static CompositeDisposable a;
    public static final Map<Long, Pair<Boolean, Boolean>> b = null;
    public static Long c;
    public static String d;
    public static final h e = null;

    public h() {
    }

    static {
        e = new h();
        b = new LinkedHashMap();
    }

    public static Integer c(String r7) {
        if (r7 != null) goto L24;
        return null;
    L24:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L21
        JSONArray r8 = new JSONObject(r7).optJSONArray("condition_list");     // Catch: Throwable -> L21
        if (r8 == null) goto L18;
        int r2 = r8.length();     // Catch: Throwable -> L21
        int r3 = 0;
        int r4 = 0;
    L8:
        if (r4 >= r2) goto L17;
        JSONObject r5 = JSONArrayProtectorUtils.getJSONObject(r8, r4);     // Catch: Throwable -> L21
        if (r5.optInt("type") == 53) goto L11;
        r4 = r4 + 1;     // Catch: Throwable -> L21
        goto L8
    L11:
        JSONObject r9 = r5.optJSONObject("game_play");     // Catch: Throwable -> L21
        if (r9 == null) goto L15;
        r3 = r9.optInt("play_seconds");     // Catch: Throwable -> L21
    L15:
        return Integer.valueOf(r3);
    L17:
        Unit r10 = Unit.INSTANCE;     // Catch: Throwable -> L21
    L19:
        Result.constructor-impl(r10);     // Catch: Throwable -> L21
    L23:
        return null;
    L18:
        r10 = null;
    L21:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L23
    }

    public final void b(Context r6) {
        Intrinsics.checkNotNullParameter(r6, "context");
        Long r0 = c;
        monitor-enter(this);
        Map<Long, Pair<Boolean, Boolean>> r1 = b;     // Catch: Throwable -> L37
        Pair r2 = (Pair) ((LinkedHashMap) r1).get(r0);     // Catch: Throwable -> L37
        monitor-exit(this);
        if (r2 == null) goto L27;
        boolean r3 = ((Boolean) r2.component1()).booleanValue();
        boolean r4 = ((Boolean) r2.component2()).booleanValue();
        if (r3 == true) goto L27;
        if (r4 == false) goto L12;
        ThreadUtils.a().postAtFrontOfQueue(new a("已成功参与福袋"));
        goto L27
    L12:
        i r5 = yt0.c.f();
        if (r5 == null) goto L23;
        n r7 = r5.getCurrentLottery();
        if (r7 == null) goto L23;
        com.bytedance.android.live.profit.lottery.g r8 = (com.bytedance.android.live.profit.lottery.g) r7.getValue();
        if (r8 == null) goto L23;
        LotteryState r9 = r8.getState();
        if (r9 == null) goto L23;
        t r10 = l.a(r9);
        if (r10 == null) goto L23;
        String r11 = r10.i;
    L24:
        Integer r12 = c(r11);
        if (r12 == null) goto L27;
        ThreadUtils.a().postAtFrontOfQueue(new a("未达成在小游戏停留" + r12.intValue() + 's'));
    L23:
        r11 = null;
    L27:
        ((LinkedHashMap) r1).clear();
        c = null;
        CompositeDisposable r13 = a;
        if (r13 == null) goto L30;
        r13.dispose();
    L30:
        a = null;
        String r14 = d;
        if (r14 != null) goto L33;
    L35:
        d = null;
        return;
    L33:
        if (com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class).mg(r6, UriProtector.parse(r14), null) != null) goto L35;
        ALogger.i("MiniGameLotteryEvent", "exit minigame open failed schema failed");
    L37:
        th = move-exception;
        throw th;
    }

    public static void d(String r3, JSONObject r4) {
        IHostLiveOpenPlatform r0 = TTLiveSDK.hostService().hostOpenPlatform();
        JSONObject r1 = new JSONObject();
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L5
        r1.put("to_state", r3);     // Catch: Throwable -> L5
        Result.constructor-impl(r1.put("extra", r4));     // Catch: Throwable -> L5
    L7:
        Unit r5 = Unit.INSTANCE;
        r0.dispatchMiniGameEvent("live_lottery_state", r1);
        return;
    L5:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    public static final void a(long r2, boolean r4, boolean r5) {
        h r0 = e;
        monitor-enter(r0);
        b.put(Long.valueOf(r2), new Pair(Boolean.valueOf(r4), Boolean.valueOf(r5)));     // Catch: Throwable -> L7
        monitor-exit(r0);
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
