package nz0;

import am2.n;
import am2.q;
import am2.u;
import am2.y;
import am2.z;
import com.bytedance.android.live.revenue.platform.log.impl.filterimpl.PlatformPageSourceFilter;
import com.bytedance.android.live.revenue.platform.log.impl.filterimpl.b;
import com.bytedance.android.live.saas.middleware.store.FileUtils;
import com.bytedance.android.livesdk.log.filter.s;
import com.bytedance.android.livesdk.log.filter.t;
import com.bytedance.android.livesdk.log.filter.v;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.log.model.FollowLog;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdk.revenue.log.LogCommonInstance;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.PadLoggerData;
import com.bytedance.android.scope.o;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import mz0.c;
import mz0.h;
import mz0.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a implements c, i, h, o {
    public final Map<LogCommon, Class<? extends Object>> a;
    public final Map<LogCommonInstance, n> b;

    public final void onStart() {
    }

    public final void onStop() {
    }

    public a() {
        this.a = MapsKt.mapOf(new Pair[]{TuplesKt.to(LogCommon.ROOM, IRoom.class), TuplesKt.to(LogCommon.LIVE_SHARE_LOG, u.class), TuplesKt.to(LogCommon.PAGE_SOURCE_LOG, t.class), TuplesKt.to(LogCommon.FOLLOW_LOG, FollowLog.class), TuplesKt.to(LogCommon.RECOMMEND_SOURCE_LOG, y.class), TuplesKt.to(LogCommon.LIVE_END_PAGE_LOG, q.class), TuplesKt.to(LogCommon.DRAWER_LOG, am2.o.class), TuplesKt.to(LogCommon.LIVE_AD_LOG, n.class), TuplesKt.to(LogCommon.GAME_PARAM_ITEM, com.bytedance.android.live.broadcastgame.api.c.class), TuplesKt.to(LogCommon.LIVE_SEARCH_LOG, am2.t.class), TuplesKt.to(LogCommon.LINKMIC_SCENE_DATA, com.bytedance.android.livesdk.log.filter.y.class), TuplesKt.to(LogCommon.REMOVE_STAGING_FLAG_LOG, z.class), TuplesKt.to(LogCommon.PAD_DATA_LOG, PadLoggerData.class)});
        this.b = MapsKt.mapOf(TuplesKt.to(LogCommonInstance.LIVE_AD_LOG, n.f()));
    }

    @Override // mz0.c
    public final com.bytedance.android.live.revenue.platform.log.impl.filterimpl.a W2(LogCommon r3) {
        Intrinsics.checkNotNullParameter(r3, "logCommon");
        j0 r0 = j0.l();
        Class<?> r4 = e0(r3);
        if (r4 != null) goto L5;
        return null;
    L5:
        com.bytedance.android.livesdk.log.filter.o r5 = r0.c(r4);
        if (r5 != null) goto L9;
        return null;
    L9:
        if ((r5 instanceof t) == false) goto L12;
        return new PlatformPageSourceFilter(r5);
    L12:
        if ((r5 instanceof com.bytedance.android.livesdk.log.filter.u) == false) goto L15;
        return new b(r5);
    L15:
        if ((r5 instanceof s) == false) goto L18;
        return new com.bytedance.android.live.revenue.platform.log.impl.filterimpl.c(r5);
    L18:
        return new com.bytedance.android.live.revenue.platform.log.impl.filterimpl.a(r5);
    }

    @Override // mz0.c
    public final Class<?> e0(LogCommon r2) {
        Intrinsics.checkNotNullParameter(r2, "enumLog");
        return this.a.get(r2);
    }

    @Override // mz0.i
    public final v removeSendLogFilter(Object r2) {
        Intrinsics.checkNotNullParameter(r2, "uniqueId");
        return j0.l().removeSendLogFilter(r2);
    }

    @Override // mz0.c
    public final Object t5(LogCommonInstance r2) {
        Intrinsics.checkNotNullParameter(r2, "instance");
        return this.b.get(r2);
    }

    @Override // mz0.i
    public final void addSendLogFilter(Object r2, v r3) {
        Intrinsics.checkNotNullParameter(r2, "uniqueId");
        Intrinsics.checkNotNullParameter(r3, FileUtils.FILTER);
        j0.l().addSendLogFilter(r2, r3);
    }

    @Override // mz0.h
    public final void sendLog(String r6, Map<String, String> r7) {
        Intrinsics.checkNotNullParameter(r6, "eventName");
        Intrinsics.checkNotNullParameter(r7, "params");
        j0 r0 = j0.l();
        Object[] r1 = CollectionsKt.listOfNotNull(new Class[]{e0(LogCommon.ROOM), e0(LogCommon.PAGE_SOURCE_LOG)}).toArray(new Class[0]);
        if (r1 == null) goto L7;
        r0.sendLog(r6, r7, Arrays.copyOf(r1, r1.length));
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    @Override // mz0.i
    public final void w3(String r3, Map<String, String> r4, List<? extends Object> r5) {
        Intrinsics.checkNotNullParameter(r3, "eventName");
        Intrinsics.checkNotNullParameter(r4, "params");
        Intrinsics.checkNotNullParameter(r5, FileUtils.FILTER);
        j0 r0 = j0.l();
        Object[] r6 = r5.toArray(new Object[0]);
        if (r6 == null) goto L7;
        r0.sendLog(r3, r4, Arrays.copyOf(r6, r6.length));
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }
}
