package com.bytedance.ai.api.navi;

import com.byted.mgl.merge.service.api.aweme.BdpAwemeConstant;
import com.bytedance.android.ec.core.event.a;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003Ji\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0096\u0001¨\u0006\u0015"}, d2 = {"Lcom/bytedance/ai/api/navi/AppletNaviServiceDelegate;", "Lcom/bytedance/ai/api/navi/IAppletNaviService;", "<init>", "()V", "startThirdNaviOrPlan", "", BdpAwemeConstant.KEY_APP_NAME, "", "type", "olat", "", "olon", "origin", "dlat", "dlon", a.KEY_DESTINATION, "rideType", "startNaviDirectly", "", "callback", "Lcom/bytedance/ai/api/navi/IAppletNaviService$IStartThirdNaviOrPlanCallback;", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppletNaviServiceDelegate implements IAppletNaviService {
    public static final AppletNaviServiceDelegate b = null;
    public final /* synthetic */ IAppletNaviService a;

    static {
        b = new AppletNaviServiceDelegate();
    }

    @Override // com.bytedance.ai.api.navi.IAppletNaviService
    public final void a(String r14, String r15, float r16, float r17, String r18, float r19, float r20, String r21, String r22, boolean r23, IAppletNaviService.a r24) {
        Intrinsics.checkNotNullParameter(r18, "origin");
        Intrinsics.checkNotNullParameter(r21, a.KEY_DESTINATION);
        this.a.a(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24);
    }

    private AppletNaviServiceDelegate() {
        IAppletNaviService r0 = (IAppletNaviService) ServiceManager.get().getService(IAppletNaviService.class);
        if (r0 != null) goto L5;
        r0 = NoopAppletNaviService.a;
    L5:
        this.a = r0;
    }
}
