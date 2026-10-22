package com.bytedance.android.live.openplatform.impl.miniappaudience.privatemsg;

import com.bytedance.android.live.openplatform.api.model.datacontext.AudienceMiniAppDataContext;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfInfo;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContextService;
import com.bytedance.live.datacontext.n;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0006B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappaudience/privatemsg/AudiencePrivateMsgContextService;", "Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContextService;", "Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;", "openPlatformContext", "<init>", "(Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;)V", "a", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AudiencePrivateMsgContextService extends OpenPlatformContextService {
    public String a;

    public static final class a {
    }

    static {
    }

    public final void g() {
        AudienceMiniAppDataContext.Companion.getClass();
        AudienceMiniAppDataContext r0 = AudienceMiniAppDataContext.a.a();
        if (r0 == null) goto L8;
        n<ShelfInfo> r1 = r0.m618getShelfInfo();
        if (r1 == null) goto L9;
        i80.a.b(r1, new AudiencePrivateMsgContextService$initPrivateMsg$1(this));
        return;
    L9:
        return;
    }

    public AudiencePrivateMsgContextService(OpenPlatformContext r2) {
        Intrinsics.checkNotNullParameter(r2, "openPlatformContext");
        super(r2);
    }

    public static final void f(AudiencePrivateMsgContextService r1) {
        r1.getClass();
        AudienceMiniAppDataContext.Companion.getClass();
        AudienceMiniAppDataContext r2 = AudienceMiniAppDataContext.a.a();
        if (r2 == null) goto L8;
        n<lo0.a> r3 = r2.getPrivateMsgEntranceInfo();
        if (r3 == null) goto L9;
        r3.setValue(null);
        return;
    L9:
        return;
    }
}
