package v01;

import com.bytedance.android.live.gift.IRoomStateService;
import com.bytedance.android.live.link.ILinkServiceExternal;
import com.bytedance.android.livesdk.gift.platform.core.download.RoomStateService;
import jc1.k;
import u01.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b implements q01.a {
    public b() {
    }

    @Override // q01.a
    public final void d() {
    }

    @Override // q01.a
    public final void b() {
        k.l(ILinkServiceExternal.class, new g());
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
