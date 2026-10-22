package wv1;

import androidx.fragment.app.Fragment;
import com.bytedance.android.livehostapi.business.depend.feed.IDrawerFeedAction;
import com.bytedance.android.livesdk.feed.IFeedActionCallback;
import com.bytedance.android.livesdk.feed.dislike.DislikeApi;
import com.bytedance.android.livesdk.feed.drawerfeed.DrawerFeedLiveAdapter;
import com.bytedance.android.livesdk.feed.drawerfeed.DrawerFeedLiveFragment;
import com.bytedance.android.livesdk.feed.drawerfeed.utils.FeedItemDiffChecker;
import com.bytedance.android.livesdk.feed.tab.repository.newtab.NewTabRepository;
import com.bytedance.android.livesdkapi.feed.LiveRoomListDataSource;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class q {
    public final com.bytedance.android.livesdk.feed.h a;
    public final IFeedActionCallback b;
    public final com.bytedance.android.livesdk.feed.f c;
    public final NewTabRepository d;
    public final LiveRoomListDataSource e;
    public final tv1.c f;
    public final qv1.c g;
    public final String h;
    public final Fragment i;
    public final IDrawerFeedAction j;
    public final Function0<Unit> k;

    public final DrawerFeedLiveAdapter a(FeedItemDiffChecker r12) {
        HashMap r8 = new HashMap();
        final tv1.c r2 = this.f;
        final com.bytedance.android.livesdk.feed.f r3 = this.c;
        final NewTabRepository r4 = this.d;
        final LiveRoomListDataSource r5 = this.e;
        r8.put(2131566258, new c(this, r2, r3, r4, r5));
        final tv1.c r6 = this.f;
        final com.bytedance.android.livesdk.feed.f r7 = this.c;
        final NewTabRepository r9 = this.d;
        final LiveRoomListDataSource r10 = this.e;
        r8.put(2131565985, new l(this, r6, r7, r9, r10));
        final IFeedActionCallback r1 = this.b;
        r8.put(2131567663, new f(r1));
        r8.put(2131565981, new m());
        r8.put(2131565980, new j());
        final p r11 = new p();
        r8.put(2131566007, new n(r11));
        r8.put(2131567662, new h());
        r8.put(2131567661, new k());
        r8.put(2131566266, new g());
        final tv1.c r13 = this.f;
        final com.bytedance.android.livesdk.feed.f r14 = this.c;
        final NewTabRepository r15 = this.d;
        final LiveRoomListDataSource r16 = this.e;
        r8.put(2131566257, new o(r13, r14, r15, r16));
        final tv1.c r17 = this.f;
        final com.bytedance.android.livesdk.feed.f r18 = this.c;
        final NewTabRepository r19 = this.d;
        final LiveRoomListDataSource r20 = this.e;
        r8.put(2131565989, new d(this, r17, r18, r19, r20));
        final tv1.c r21 = this.f;
        final com.bytedance.android.livesdk.feed.f r22 = this.c;
        final NewTabRepository r23 = this.d;
        final LiveRoomListDataSource r24 = this.e;
        final IFeedActionCallback r25 = this.b;
        r8.put(2131565984, new i(this, r21, r22, r23, r24, r25));
        r8.put(2131565968, new e(this));
        return new DrawerFeedLiveAdapter(r12, r8, this.c, this.a, this.h, this.k);
    }

    public q(com.bytedance.android.livesdk.feed.h r4, qv1.c r5, String r6, IFeedActionCallback r7, Fragment r8, IDrawerFeedAction r9, DrawerFeedLiveFragment.b r10) {
        this.f = new tv1.c((DislikeApi) com.bytedance.android.live.network.c.b().e(DislikeApi.class));
        this.c = com.bytedance.android.livesdk.feed.services.d.a();
        boolean r0 = com.bytedance.android.livesdk.feed.x0.d;
        this.d = com.bytedance.android.livesdk.feed.x0.a.a();
        this.e = LiveRoomListDataSource.instance();
        this.a = r4;
        this.b = r7;
        this.g = r5;
        this.h = r6;
        this.i = r8;
        this.j = r9;
        this.k = r10;
    }
}
