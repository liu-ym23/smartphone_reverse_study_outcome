package mv1;

import com.bytedance.android.livesdk.feed.fragment.AppointmentListFragment;
import com.bytedance.android.livesdk.feed.tab.repository.p;
import com.bytedance.android.livesdkapi.feed.LiveRoomListDataSource;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c {
    public final com.bytedance.android.livesdk.feed.f a;
    public final com.bytedance.android.livesdk.feed.tab.repository.l b;
    public final AppointmentListFragment c;

    public c(AppointmentListFragment r2) {
        Intrinsics.checkNotNullParameter(r2, "feedLiveFragment");
        this.c = r2;
        this.a = com.bytedance.android.livesdk.feed.services.d.a();
        this.b = p.f();
        LiveRoomListDataSource.instance();
    }
}
