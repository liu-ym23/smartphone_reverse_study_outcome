package com.bytedance.android.live.broadcastgame.opengame.service;

import am2.x;
import com.bytedance.android.live.broadcastgame.opengame.runtime.PluginContext;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.log.filter.n0;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import java.util.LinkedHashMap;
import java.util.Map;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001:\u0001\u0006B\u0011\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/service/TrackCommonService;", "Ly10/a;", "Lcom/bytedance/android/live/broadcastgame/opengame/runtime/PluginContext;", "pluginContext", "<init>", "(Lcom/bytedance/android/live/broadcastgame/opengame/runtime/PluginContext;)V", "a", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class TrackCommonService implements y10.a {
    public static final /* synthetic */ int d = 0;
    public long a;
    public final Lazy b;
    public final PluginContext c;

    public static final class a {
    }

    static {
    }

    @Override // y10.a
    public final void g() {
    }

    public final void c() {
        com.bytedance.android.livesdk.log.g r0 = u.l();
        LinkedHashMap r1 = new LinkedHashMap();
        r1.putAll((Map) this.b.getValue());
        r1.put("duration", String.valueOf(System.currentTimeMillis() - this.a));
        a(r1);
        Unit r2 = Unit.INSTANCE;
        r0.sendLog("livesdk_small_program_duration", r1, new Object[]{Room.class});
    }

    public final void d() {
        com.bytedance.android.livesdk.log.g r0 = u.l();
        LinkedHashMap r1 = new LinkedHashMap();
        r1.putAll((Map) this.b.getValue());
        a(r1);
        Unit r2 = Unit.INSTANCE;
        r0.sendLog("livesdk_live_small_program_end", r1, new Object[]{Room.class});
    }

    public final void e() {
        com.bytedance.android.livesdk.log.g r0 = u.l();
        LinkedHashMap r1 = new LinkedHashMap();
        r1.putAll((Map) this.b.getValue());
        a(r1);
        Unit r2 = Unit.INSTANCE;
        r0.sendLog("livesdk_live_small_program_start", r1, new Object[]{Room.class});
    }

    public PluginContext b() {
        return this.c;
    }

    public TrackCommonService(PluginContext r2) {
        Intrinsics.checkNotNullParameter(r2, "pluginContext");
        this.c = r2;
        this.b = LazyKt.lazy(new TrackCommonService$commonParams$2(this));
    }

    public final void a(Map<String, String> r6) {
        Intrinsics.checkNotNullParameter(r6, "data");
        if (b().o == false) goto L5;
        String r0 = "anchor";
    L6:
        r6.put("user_type", r0);
        String r1 = k.n(IUserService.class).user().b().getIdString();
        if (b().o == false) goto L9;
        r6.put("anchor_id", r1);
        return;
    L9:
        r6.put("user_id", r1);
        String[] r2 = {"enter_from_merge", "enter_method"};
        Intrinsics.checkNotNullParameter(r6, "params");
        Intrinsics.checkNotNullParameter(r2, "keys");
        n0 r3 = u.l().c(x.class);
        if (r3 == null) goto L22;
        n0 r4 = r3;
        int r5 = 0;
    L13:
        if (r5 >= 2) goto L27;
        String r7 = r2[r5];
        if (((com.bytedance.android.livesdk.log.filter.a) r4).b.containsKey(r7) == false) goto L19;
        String r8 = (String) ((com.bytedance.android.livesdk.log.filter.a) r4).b.get(r7);
        if (r8 == null) goto L19;
        r6.put(r7, r8);
    L19:
        r5 = r5 + 1;
        goto L13
    L27:
        return;
    L22:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.log.filter.PageSourceFilter");
    L5:
        r0 = "user";
        goto L6
    }
}
