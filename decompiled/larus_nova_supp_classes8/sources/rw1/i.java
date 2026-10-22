package rw1;

import com.bytedance.android.livesdk.feed.adapter.FeedLiveAdapter;
import com.bytedance.android.livesdk.feed.dislike.DislikeApi;
import com.bytedance.android.livesdk.feed.fragment.FeedLiveFragment;
import com.bytedance.android.livesdk.feed.j;
import com.bytedance.android.livesdk.feed.tab.repository.l;
import com.bytedance.android.livesdk.feed.tab.repository.p;
import com.bytedance.android.livesdkapi.feed.ILiveRoomListDataSource;
import com.bytedance.android.livesdkapi.feed.LiveRoomListDataSource;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.functions.Function5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class i {
    public static Map<Integer, Function5<tv1.c, com.bytedance.android.livesdk.feed.f, j, ILiveRoomListDataSource, com.bytedance.android.livesdk.feed.h, b90.a>> h;
    public final FeedLiveFragment a;
    public final com.bytedance.android.livesdk.feed.f b;
    public final l c;
    public final LiveRoomListDataSource d;
    public final tv1.c e;
    public final FeedLiveFragment.a f;
    public final com.bytedance.android.livesdk.feed.h g;

    public class a implements com.bytedance.android.livesdk.feed.l {
        @Override // com.bytedance.android.livesdk.feed.l
        public final void a() {
        }

        public a() {
        }
    }

    public final FeedLiveAdapter a() {
        if (this.a == null) goto L7;
        return new FeedLiveAdapter(b(), this.b, this.a);
    L7:
        return new FeedLiveAdapter(b(), this.b, this.g);
    }

    public final Map<Integer, b90.a> b() {
        HashMap r0 = new HashMap();
        Map<Integer, Function5<tv1.c, com.bytedance.android.livesdk.feed.f, j, ILiveRoomListDataSource, com.bytedance.android.livesdk.feed.h, b90.a>> r1 = h;
        if (r1 == null) goto L8;
        Iterator r2 = ((HashMap) r1).keySet().iterator();
    L6:
        if (r2.hasNext() == false) goto L8;
        Integer r3 = (Integer) r2.next();
        r0.put(r3, (b90.a) ((Function5) ((HashMap) h).get(r3)).invoke(this.e, this.b, this.c, this.d, this.g));
    L8:
        final tv1.c r4 = this.e;
        final com.bytedance.android.livesdk.feed.f r5 = this.b;
        final l r6 = this.c;
        final LiveRoomListDataSource r7 = this.d;
        r0.put(2131566258, new rw1.a(this, r4, r5, r6, r7));
        final tv1.c r8 = this.e;
        final com.bytedance.android.livesdk.feed.f r9 = this.b;
        final l r10 = this.c;
        final LiveRoomListDataSource r11 = this.d;
        r0.put(2131566260, new d(this, r8, r9, r10, r11));
        final FeedLiveFragment.a r12 = this.f;
        r0.put(2131567663, new f(r12));
        final a r13 = new a();
        r0.put(2131567660, new g(r13));
        r0.put(2131567662, new c());
        r0.put(2131567661, new e());
        r0.put(2131566266, new h());
        final tv1.c r14 = this.e;
        final com.bytedance.android.livesdk.feed.f r15 = this.b;
        final l r16 = this.c;
        final LiveRoomListDataSource r17 = this.d;
        r0.put(2131566257, new b(r14, r15, r16, r17));
        return r0;
    }

    public i(FeedLiveFragment r4, com.bytedance.android.livesdk.feed.h r5) {
        this.e = new tv1.c((DislikeApi) com.bytedance.android.live.network.c.b().e(DislikeApi.class));
        this.b = com.bytedance.android.livesdk.feed.services.d.a();
        if (r4 != null) goto L5;
        l r0 = p.f();
    L6:
        this.c = r0;
        this.d = LiveRoomListDataSource.instance();
        this.a = r4;
        if (r4 == null) goto L9;
        this.f = r4.J;
    L9:
        this.g = r5;
        return;
    L5:
        r0 = r4.D;
        goto L6
    }
}
