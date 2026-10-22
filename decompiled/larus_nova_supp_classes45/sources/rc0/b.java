package rc0;

import com.bytedance.android.live.link.player.DeviceType;
import com.bytedance.android.live.revlink.api.ILinkService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b {
    public static final DeviceType a() {
        return com.bytedance.android.live.revenue.core.util.f.a(ILinkService.class).getMultiAnchorService().c().getDeviceType();
    }
}
