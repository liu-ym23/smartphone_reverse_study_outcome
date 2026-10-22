package com.bytedance.android.live.draggablecomponent;

import am2.x;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b implements c61.e {
    public static final b a = null;

    public b() {
    }

    static {
        a = new b();
    }

    public final void a(c61.a r6) {
        Intrinsics.checkNotNullParameter(r6, "params");
        u.l().sendLog(r6.a, r6.b, new Object[]{x.class, Room.class});
    }
}
