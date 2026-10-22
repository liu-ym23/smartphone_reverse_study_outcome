package com.bytedance.android.live.liveinteract.plantform.spatial;

import com.bytedance.android.live.liveinteract.spatial.SpatialAudioContext;
import com.bytedance.android.livesdk.model.y0;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class SpatialAudioStrategyManager implements lj0.a {
    public static SpatialAudioStrategyManager b;
    public static final a c = null;
    public final HashMap<Integer, com.bytedance.android.live.liveinteract.plantform.spatial.a> a;

    public static final class a {
        public a() {
        }

        public final synchronized SpatialAudioStrategyManager a() {
            monitor-enter(this);
        L6:
            th = move-exception;
            throw th;
        L4:
            if (SpatialAudioStrategyManager.b != null) goto L8;
            SpatialAudioStrategyManager.b = new SpatialAudioStrategyManager();     // Catch: Throwable -> L6
        L8:
            SpatialAudioStrategyManager r0 = SpatialAudioStrategyManager.b;     // Catch: Throwable -> L6
            Intrinsics.checkNotNull(r0);     // Catch: Throwable -> L6
            monitor-exit(this);
            return r0;
        }
    }

    static {
        c = new a();
    }

    @Override // lj0.a
    public final boolean q3() {
        return com.bytedance.android.live.liveinteract.spatial.a.e(9);
    }

    public SpatialAudioStrategyManager() {
        HashMap<Integer, com.bytedance.android.live.liveinteract.plantform.spatial.a> r0 = new HashMap();
        this.a = r0;
        r0.put(1, new g());
        r0.put(2, new c());
        r0.put(3, new e());
        r0.put(4, new f());
        r0.put(5, new d());
        r0.put(6, new b());
        r0.put(7, new h());
        r0.put(8, new i());
        r0.put(9, new j());
        com.bytedance.live.datacontext.b.a((SpatialAudioContext) com.bytedance.live.datacontext.d.a(SpatialAudioStrategyManager$pair$1.INSTANCE).getFirst(), SpatialAudioContext.class);
    }

    @Override // lj0.a
    public final aj6.b a(int r6) {
        com.bytedance.android.live.liveinteract.plantform.spatial.a r7 = this.a.get(Integer.valueOf(r6));
        if (r7 == null) goto L7;
        return r7.b();
    L7:
        return new aj6.b(new aj6.c(1.0f, 0.0f, 0.0f), new aj6.c(0.0f, 1.0f, 0.0f), new aj6.c(0.0f, 0.0f, 1.0f));
    }

    @Override // lj0.a
    public final y0 c(int r2) {
        com.bytedance.android.live.liveinteract.plantform.spatial.a r3 = this.a.get(Integer.valueOf(r2));
        if (r3 == null) goto L7;
        return r3.a();
    L7:
        return new y0(0, 0, 0);
    }

    @Override // lj0.a
    public final y0 b(int r1, int r2, int r3, HashMap<String, Object> r4) {
        com.bytedance.android.live.liveinteract.plantform.spatial.a r5 = this.a.get(Integer.valueOf(r1));
        if (r5 == null) goto L7;
        return r5.d(r2, r3);
    L7:
        return new y0(0, 0, 0);
    }
}
