package com.bytedance.android.live.openplatform.impl.miniappaudience.explaincard;

import com.bytedance.android.live.openplatform.api.model.datacontext.MiniAppDataContext;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContextService;
import com.bytedance.android.live.openplatform.impl.miniappaudience.applog.AudienceMiniAppAppLogContextService;
import com.bytedance.android.live.openplatform.impl.miniappaudience.toolbar.SnowToolbarContextService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0006B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappaudience/explaincard/AudienceLynxExplainCardContextService;", "Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContextService;", "Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;", "openPlatformContext", "<init>", "(Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;)V", "a", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AudienceLynxExplainCardContextService extends OpenPlatformContextService {
    public static final /* synthetic */ int c = 0;
    public com.bytedance.android.live.room.api.messagewindow.builder.card.c a;
    public boolean b;

    public static final class a {
    }

    static {
    }

    public AudienceLynxExplainCardContextService(OpenPlatformContext r2) {
        Intrinsics.checkNotNullParameter(r2, "openPlatformContext");
        super(r2);
    }

    public static void f(final AudienceLynxExplainCardContextService r2, final boolean r3, final JSONObject r4, int r5) {
        if ((r5 & 1) == 0) goto L6;
        r3 = false;
    L6:
        if ((r5 & 2) == 0) goto L8;
        r4 = null;
    L8:
        ((AudienceMiniAppAppLogContextService) r2.getOpenPlatformContext().getService(AudienceMiniAppAppLogContextService.class)).reportMpLivePopupCardShowAnimStart(r3, true, ExplainCardAnimType.SMALL_CARD);
        SnowToolbarContextService r6 = (SnowToolbarContextService) r2.getOpenPlatformContext().getService(SnowToolbarContextService.class);
        MiniAppDataContext.Companion.getClass();
        r6.j(r3, com.bytedance.android.live.openplatform.api.model.shelf.g.c(MiniAppDataContext.a.b()), new AudienceLynxExplainCardContextService$showExplainCard$1(r2, r3, r4));
    }
}
