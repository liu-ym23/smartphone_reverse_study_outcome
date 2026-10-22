package com.bytedance.android.livesdk.interactivity.like.utils;

import am2.x;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.message.model.d4;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.message.Text;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import u32.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c implements l.a {
    public static final c a = null;

    public c() {
    }

    static {
        a = new c();
    }

    public static void a(com.bytedance.android.livesdk.interactivity.api.like.model.a r9) {
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r0 == null) goto L9;
        com.bytedance.live.datacontext.i r1 = r0.isAnchor();
        if (r1 == null) goto L9;
        Boolean r2 = (Boolean) r1.getValue();
        if (r2 == null) goto L9;
        boolean r3 = r2.booleanValue();
    L10:
        com.bytedance.android.livesdk.log.g r4 = u.l();
        Pair[] r5 = new Pair[4];
        r5[0] = TuplesKt.to("double_like_ID", String.valueOf(r9.c()));
        r5[1] = TuplesKt.to("order", String.valueOf(r9.b()));
        r5[2] = TuplesKt.to("trigger_ucnt", String.valueOf(r9.d()));
        if (r3 == false) goto L13;
        String r10 = "anchor";
    L14:
        r5[3] = TuplesKt.to("user_type", r10);
        r4.sendLog("livesdk_double_like_trigger", MapsKt.mapOf(r5), new Object[]{Room.class, x.class});
        return;
    L13:
        r10 = "audience";
    L9:
        r3 = false;
        goto L10
    }

    @Override // u32.l.a
    public final void b(l r2, com.bytedance.android.livesdk.interactivity.api.like.model.a r3) {
        Intrinsics.checkNotNullParameter(r2, "vm");
        Intrinsics.checkNotNullParameter(r3, "detail");
        a(r3);
    }

    @Override // u32.l.a
    public final void e(l r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "vm");
        Intrinsics.checkNotNullParameter(r1, "vm");
    }

    @Override // u32.l.a
    public final void k(l r3, List<d4> r4) {
        Intrinsics.checkNotNullParameter(r3, "vm");
        Intrinsics.checkNotNullParameter(r4, "userRank");
        Intrinsics.checkNotNullParameter(r3, "vm");
        Intrinsics.checkNotNullParameter(r4, "userRank");
    }

    @Override // u32.l.a
    public final void l(l r2, com.bytedance.android.livesdk.interactivity.api.like.model.a r3) {
        Intrinsics.checkNotNullParameter(r2, "vm");
        Intrinsics.checkNotNullParameter(r3, "detail");
        a(r3);
    }

    @Override // u32.l.a
    public final void d(l r2, int r3, int r4, Text r5, Text r6) {
        Intrinsics.checkNotNullParameter(r2, "vm");
        Intrinsics.checkNotNullParameter(r5, "normalText");
        Intrinsics.checkNotNullParameter(r6, "joinText");
        Intrinsics.checkNotNullParameter(r2, "vm");
        Intrinsics.checkNotNullParameter(r5, "normalText");
        Intrinsics.checkNotNullParameter(r6, "joinText");
    }
}
