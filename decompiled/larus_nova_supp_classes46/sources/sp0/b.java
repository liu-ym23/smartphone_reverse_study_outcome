package sp0;

import com.bytedance.android.live.liveinteract.api.MultiLinkOpenSource;
import com.bytedance.android.live.openplatform.api.model.datacontext.AnchorMiniAppDataContext;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.livesdk.message.model.pf;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.live.datacontext.n;
import kotlin.jvm.internal.Intrinsics;
import tlc.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b extends ro0.b<pf> {
    @Override // ro0.b
    public final MessageType a() {
        return MessageType.LIVE_MOUNT_MICRO_APP_LIMIT_DATA_MESSAGE;
    }

    public b(OpenPlatformContext r2) {
        Intrinsics.checkNotNullParameter(r2, "openPlatformContext");
        super(r2);
    }

    @Override // ro0.b
    public final void b(d r2) {
        pf r3 = (pf) r2;
        Intrinsics.checkNotNullParameter(r3, MultiLinkOpenSource.MESSAGE);
        AnchorMiniAppDataContext.Companion.getClass();
        AnchorMiniAppDataContext r0 = AnchorMiniAppDataContext.a.a();
        if (r0 == null) goto L8;
        n<pf.a> r1 = r0.getMicroAppLiveMountLimitData();
        if (r1 == null) goto L9;
        r1.setValue(r3.data);
        return;
    L9:
        return;
    }
}
