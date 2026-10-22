package sp0;

import com.bytedance.android.live.liveinteract.api.MultiLinkOpenSource;
import com.bytedance.android.live.openplatform.api.model.datacontext.AnchorMiniAppDataContext;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.livesdk.message.model.qh;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.live.datacontext.m;
import kotlin.jvm.internal.Intrinsics;
import tlc.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a extends ro0.b<qh> {
    @Override // ro0.b
    public final MessageType a() {
        return MessageType.OPEN_PLATFORM_LIVE_BIND_MICRO_APP_MESSAGE;
    }

    public a(OpenPlatformContext r2) {
        Intrinsics.checkNotNullParameter(r2, "openPlatformContext");
        super(r2);
    }

    @Override // ro0.b
    public final void b(d r2) {
        qh r3 = (qh) r2;
        Intrinsics.checkNotNullParameter(r3, MultiLinkOpenSource.MESSAGE);
        AnchorMiniAppDataContext.Companion.getClass();
        AnchorMiniAppDataContext r0 = AnchorMiniAppDataContext.a.a();
        if (r0 == null) goto L8;
        m<Boolean> r1 = r0.getMicroAppMountPunishing();
        if (r1 == null) goto L9;
        r1.setValue(Boolean.valueOf(!r3.canBind));
        return;
    L9:
        return;
    }
}
