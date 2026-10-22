package s01;

import com.bytedance.android.live.gift.IGiftService;
import com.bytedance.android.live.gift.IGiftServiceExternal;
import com.bytedance.android.live.gift.IRoomStateService;
import com.bytedance.android.live.revenue.service.gift.GiftServiceWrapper;
import com.bytedance.android.livesdk.gift.platform.core.download.RoomStateService;
import com.bytedance.android.livesdkapi.depend.live.ILiveGiftService;
import jc1.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b implements q01.a {
    public b() {
    }

    @Override // q01.a
    public final void d() {
    }

    @Override // q01.a
    public final void b() {
        GiftServiceWrapper r0 = new GiftServiceWrapper();
        k.l(IGiftService.class, r0.getRealInstance());
        k.l(ILiveGiftService.class, r0);
        k.l(IGiftServiceExternal.class, r0);
    }

    @Override // q01.a
    public final void c() {
        k.l(IRoomStateService.class, new RoomStateService());
    }

    @Override // q01.a
    public final void a() {
        b();
        c();
    }
}
