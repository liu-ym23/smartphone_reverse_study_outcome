package yn0;

import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.interactivity.api.like.datacontext.DiggContext;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.DataContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d implements l81.d {
    public final DataCenter a;

    public final com.bytedance.live.datacontext.m<Long> a() {
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, this.a, 0, 2);
        if (r0 == null) goto L7;
        DiggContext r1 = com.bytedance.android.livesdk.interactivity.api.like.datacontext.a.a(r0);
        if (r1 == null) goto L7;
        return r1.getDiggTime();
    L7:
        return null;
    }

    public d(DataCenter r1) {
        this.a = r1;
    }

    public final com.bytedance.live.datacontext.n<u32.k> b(DataCenter r5) {
        Intrinsics.checkNotNullParameter(r5, "dataCenter");
        DiggContext r6 = com.bytedance.android.livesdk.interactivity.api.like.datacontext.a.a(RoomContext.a.c(RoomContext.Companion, r5, 0, 2));
        if (r6 != null) goto L7;
        return null;
    L7:
        return r6.getDiggWidget();
    }

    public final com.bytedance.live.datacontext.m<Long> c(DataContext r3) {
        if ((r3 instanceof RoomContext) == true) goto L5;
        return null;
    L5:
        DiggContext r4 = com.bytedance.android.livesdk.interactivity.api.like.datacontext.a.a((MiddlewareRoomContext) r3);
        if (r4 != null) goto L8;
        return null;
    L8:
        return r4.getDiggTime();
    }

    public final com.bytedance.live.datacontext.m<Boolean> d(DataCenter r5) {
        Intrinsics.checkNotNullParameter(r5, "dataCenter");
        DiggContext r6 = com.bytedance.android.livesdk.interactivity.api.like.datacontext.a.a(RoomContext.a.c(RoomContext.Companion, r5, 0, 2));
        if (r6 != null) goto L7;
        return null;
    L7:
        return r6.getInDoubleLike();
    }
}
