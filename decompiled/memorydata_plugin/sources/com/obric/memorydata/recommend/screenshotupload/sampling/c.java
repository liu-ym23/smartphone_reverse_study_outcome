package com.obric.memorydata.recommend.screenshotupload.sampling;

import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.memorydata.recommend.useraction.recommend.TriggerUploadType;
import com.obric.memorydata.sdk.screencapture.rule.ScreenshotOption;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001Jd\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0018\u0010\n\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\f0\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000b2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0010H&J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0013"}, d2 = {"Lcom/obric/memorydata/recommend/screenshotupload/sampling/PeriodicScreenshotSampling;", "", CommonConsts.APM_INNER_EVENT_COST_START, "", "key", "", "appName", ObricMemoryConstants.KEY_PACKAGE_NAME, "triggerType", "Lcom/obric/memorydata/recommend/useraction/recommend/TriggerUploadType;", "extraMetaProvider", "Lkotlin/Function0;", "", "screenshotOptionProvider", "Lcom/obric/memorydata/sdk/screencapture/rule/ScreenshotOption;", "initialDelayMs", "", "intervalMs", "stop", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface c {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        public static /* synthetic */ void a(c r14, String r15, String r16, String r17, TriggerUploadType r18, Function0 r19, Function0 r20, long r21, long r23, int r25, Object r26) {
            c r3 = (c) ZeusTransformUtils.wrapperContextForParams(r14, c.class, "com.obric.memorydata.plugin");
            Function0<? extends Map<String, String>> r8 = (Function0) ZeusTransformUtils.wrapperContextForParams(r19, Function0.class, "com.obric.memorydata.plugin");
            Function0<ScreenshotOption> r9 = (Function0) ZeusTransformUtils.wrapperContextForParams(r20, Function0.class, "com.obric.memorydata.plugin");
            if (r26 != null) goto L15;
            if ((r25 & 64) == 0) goto L7;
            long r10 = 0;
        L9:
            if ((r25 & 128) == 0) goto L11;
            long r12 = e.f12587a.a();
        L12:
            r3.a(r15, r16, r17, r18, r8, r9, r10, r12);
            return;
        L11:
            r12 = r23;
            goto L12
        L7:
            r10 = r21;
            goto L9
        L15:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: start");
        }
    }

    void a(String r1);

    void a(String r1, String r2, String r3, TriggerUploadType r4, Function0<? extends Map<String, String>> r5, Function0<ScreenshotOption> r6, long r7, long r9);
}
