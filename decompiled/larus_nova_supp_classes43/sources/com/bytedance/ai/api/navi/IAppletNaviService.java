package com.bytedance.ai.api.navi;

import com.byted.mgl.merge.service.api.aweme.BdpAwemeConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0013Jn\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012H&¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ai/api/navi/IAppletNaviService;", "", "startThirdNaviOrPlan", "", BdpAwemeConstant.KEY_APP_NAME, "", "type", "olat", "", "olon", "origin", "dlat", "dlon", com.bytedance.android.ec.core.event.a.KEY_DESTINATION, "rideType", "startNaviDirectly", "", "callback", "Lcom/bytedance/ai/api/navi/IAppletNaviService$IStartThirdNaviOrPlanCallback;", "IStartThirdNaviOrPlanCallback", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IAppletNaviService {

    public interface a {

        /* JADX INFO: renamed from: com.bytedance.ai.api.navi.IAppletNaviService$a$a, reason: collision with other inner class name */
        public static final class C0014a {
            public static /* synthetic */ void a(a r10) {
                r10.onResult(-1, null);
            }
        }

        void onResult(int r1, String r10);
    }

    void a(String r1, String r10, float r11, float r12, String r13, float r14, float r15, String r16, String r17, boolean r18, a r19);
}
