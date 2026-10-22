package com.bytedance.ai.api.navi;

import com.byted.mgl.merge.service.api.aweme.BdpAwemeConstant;
import com.bytedance.android.ec.core.event.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003Jh\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016¨\u0006\u0015"}, d2 = {"Lcom/bytedance/ai/api/navi/NoopAppletNaviService;", "Lcom/bytedance/ai/api/navi/IAppletNaviService;", "<init>", "()V", "startThirdNaviOrPlan", "", BdpAwemeConstant.KEY_APP_NAME, "", "type", "olat", "", "olon", "origin", "dlat", "dlon", a.KEY_DESTINATION, "rideType", "startNaviDirectly", "", "callback", "Lcom/bytedance/ai/api/navi/IAppletNaviService$IStartThirdNaviOrPlanCallback;", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NoopAppletNaviService implements IAppletNaviService {
    public static final NoopAppletNaviService a = null;

    static {
        a = new NoopAppletNaviService();
    }

    private NoopAppletNaviService() {
    }

    @Override // com.bytedance.ai.api.navi.IAppletNaviService
    public final void a(String r1, String r10, float r11, float r12, String r13, float r14, float r15, String r16, String r17, boolean r18, IAppletNaviService.a r19) {
        Intrinsics.checkNotNullParameter(r13, "origin");
        Intrinsics.checkNotNullParameter(r16, a.KEY_DESTINATION);
        if (r19 == null) goto L6;
        r19.onResult(-1, r1);
        return;
    }
}
