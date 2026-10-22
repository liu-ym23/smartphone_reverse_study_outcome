package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.experencepanel;

import am2.x;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c {
    public final a a;

    public final class a {
        public final /* synthetic */ c a;

        public a(c r1) {
            this.a = r1;
        }
    }

    public c() {
        this.a = new a(this);
    }

    public static final void a(c r3, String r4, String r5) {
        r3.getClass();
        Map r6 = MapsKt.mapOf(TuplesKt.to("cache_memory", r5));
        u.l().sendLog(r4, r6, new Object[]{IRoom.class, x.class});
    }
}
