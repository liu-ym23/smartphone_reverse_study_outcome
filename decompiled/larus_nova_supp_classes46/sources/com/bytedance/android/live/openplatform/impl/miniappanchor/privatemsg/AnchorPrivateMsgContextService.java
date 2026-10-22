package com.bytedance.android.live.openplatform.impl.miniappanchor.privatemsg;

import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContextService;
import com.bytedance.android.live.openplatform.impl.base.utils.LiveOpenPlatformClient;
import com.bytedance.android.live.openplatform.impl.miniappanchor.api.AnchorPrivateMsgApi;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vp0.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0006B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/privatemsg/AnchorPrivateMsgContextService;", "Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContextService;", "Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;", "openPlatformContext", "<init>", "(Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;)V", "a", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorPrivateMsgContextService extends OpenPlatformContextService {

    public static final class a {
    }

    static {
    }

    public AnchorPrivateMsgContextService(OpenPlatformContext r2) {
        Intrinsics.checkNotNullParameter(r2, "openPlatformContext");
        super(r2);
    }

    public static void f(AnchorPrivateMsgContextService r3, String r4) {
        Intrinsics.checkNotNullParameter(r4, "appId");
        Lazy r0 = LiveOpenPlatformClient.c;
        r3.autoDispose(((AnchorPrivateMsgApi) LiveOpenPlatformClient.a.a().a(AnchorPrivateMsgApi.class)).getPrivateMsgTab(r4, r3.getOpenPlatformContext().getRoomId()).compose(RxUtil.rxSchedulerHelper()).subscribe(new vp0.a(null, null), new b(null)));
    }
}
