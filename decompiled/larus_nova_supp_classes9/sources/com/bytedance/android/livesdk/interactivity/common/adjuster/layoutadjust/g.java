package com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust;

import com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.adapter.LiveRoomEnvStateHolder;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public interface g extends com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.f {
    public static final a a = null;

    public static final class a {
        public static final Map<String, g> a = null;
        public static final /* synthetic */ a b = null;

        public a() {
        }

        static {
            b = new a();
            a = new HashMap();
        }

        public static void a(String r1, g r2) {
            Intrinsics.checkNotNullParameter(r1, "key");
            Intrinsics.checkNotNullParameter(r2, "universalHeightStateManager");
            ((HashMap) a).put(r1, r2);
        }
    }

    static {
        a = a.b;
    }

    com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.d a(int r1, int r2, com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.e r3, Room r4, LiveRoomEnvStateHolder r5);

    boolean c(LiveRoomEnvStateHolder r1);
}
