package gj0;

import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.revenue.starwish.net.StarWishApi;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.live.datacontext.m;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b<T> implements Consumer {
    public static final b a = null;

    static {
        a = new b();
    }

    public b() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void accept(Object r8) {
        DATA r9 = ((com.bytedance.android.live.network.response.e) r8).data;
        if (r9 == 0) goto L19;
        com.bytedance.android.live.liveinteract.revenue.starwish.net.a r10 = (com.bytedance.android.live.liveinteract.revenue.starwish.net.a) r9;
        if (r10.a() == null) goto L21;
        com.bytedance.android.live.liveinteract.revenue.starwish.net.b r0 = r10.a();
        Intrinsics.checkNotNull(r0);
        if (r0.c() != true) goto L16;
        f r1 = f.a;
        com.bytedance.android.live.liveinteract.revenue.starwish.net.b r2 = r10.a();
        Intrinsics.checkNotNull(r2);
        long r4 = r2.b();
        com.bytedance.android.live.liveinteract.revenue.starwish.net.b r11 = r10.a();
        Intrinsics.checkNotNull(r11);
        boolean r6 = r11.a();
        m r12 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r12 == null) goto L14;
        IRoom r13 = (IRoom) r12.getValue();
        if (r13 == null) goto L14;
        long r3 = r13.getId();
    L15:
        StarWishApi r5 = (StarWishApi) com.bytedance.android.live.network.c.b().e(StarWishApi.class);
        r5.openStarWish(r3, r4, r6).compose(RxUtil.rxSchedulerHelper()).subscribe(d.a, e.a);
        return;
    L14:
        r3 = 0;
        goto L15
    L16:
        f r14 = f.a;
        int r15 = h.a;
        h.b(s1.getContext(), null, 6);
        return;
    L21:
        return;
    L19:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.revenue.starwish.net.GetStarWishSettingResponse");
    }
}
