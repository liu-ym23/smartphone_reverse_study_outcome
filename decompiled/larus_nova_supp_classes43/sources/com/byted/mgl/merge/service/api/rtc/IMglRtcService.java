package com.byted.mgl.merge.service.api.rtc;

import android.content.Context;
import com.byted.cast.sink.api.IAPI;
import com.byted.mgl.merge.service.api.aweme.BdpAwemeConstant;
import com.bytedance.bdp.bdpbase.service.IBdpService;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bg\u0018\u00002\u00020\u0001J.\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007H&J\b\u0010\u000b\u001a\u00020\fH&¨\u0006\r"}, d2 = {"Lcom/byted/mgl/merge/service/api/rtc/IMglRtcService;", "Lcom/bytedance/bdp/bdpbase/service/IBdpService;", "createRtcEngine", "Lcom/byted/mgl/merge/service/api/rtc/IMglRtcEngine;", "context", "Landroid/content/Context;", BdpAwemeConstant.KEY_APP_ID, "", "handler", "Lcom/byted/mgl/merge/service/api/rtc/IMglRtcEventHandler;", "businessId", "isFeatureSupport", "", "bdp-service-api_release"}, k = 1, mv = {1, 1, IAPI.OPTION_AUTH_CALLBACK})
public interface IMglRtcService extends IBdpService {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, IAPI.OPTION_AUTH_CALLBACK})
    public static final class DefaultImpls {
        public static /* synthetic */ IMglRtcEngine createRtcEngine$default(IMglRtcService r0, Context r1, String r10, IMglRtcEventHandler r11, String r12, int r13, Object r14) {
            if (r14 != null) goto L9;
            if ((r13 & 8) == 0) goto L7;
            r12 = null;
        L7:
            return r0.createRtcEngine(r1, r10, r11, r12);
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createRtcEngine");
        }
    }

    IMglRtcEngine createRtcEngine(Context r1, String r10, IMglRtcEventHandler r11, String r12);

    boolean isFeatureSupport();
}
