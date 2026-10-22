package lk0;

import android.content.Context;
import bn0.b;
import com.bytedance.android.live.livelink.guestlink.GuestLinkService;
import com.bytedance.android.live.livelink.multilink.MultiLinkService;
import com.bytedance.android.scope.o;
import kotlin.jvm.internal.Intrinsics;
import yz0.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a implements o, jb6.a {
    public final b a;
    public final g b;
    public final fc6.a c;

    public final void onStart() {
    }

    public final void onStop() {
    }

    public final GuestLinkService Bo(Context r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        return new GuestLinkService(r4, r5, this.c, this.a);
    }

    public final MultiLinkService wi(Context r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        return new MultiLinkService(r4, r5, this.c, this.a);
    }

    public a(b r2, g r3, fc6.a r4) {
        Intrinsics.checkNotNullParameter(r2, "multiLinkRoomScope");
        Intrinsics.checkNotNullParameter(r3, "roomDataService");
        Intrinsics.checkNotNullParameter(r4, "hostService");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
