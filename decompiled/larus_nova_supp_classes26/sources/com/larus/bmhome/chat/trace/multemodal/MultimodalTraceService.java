package com.larus.bmhome.chat.trace.multemodal;

import com.larus.bmhome.chat.api.IMultimodalTraceService;
import com.larus.bmhome.chat.trace.multimodal.AttachmentAreaType;
import com.larus.bmhome.chat.trace.multimodal.MultimodalCommonParamManager;
import com.larus.bmhome.chat.trace.multimodal.MultimodalSendCostTrace;
import com.larus.bmhome.chat.trace.multimodal.a;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.bmhome.utils.c;
import com.larus.platform.service.o;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J.\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u0007H\u0016J.\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007H\u0016J8\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\u0011"}, d2 = {"Lcom/larus/bmhome/chat/trace/multemodal/MultimodalTraceService;", "Lcom/larus/bmhome/chat/api/IMultimodalTraceService;", "<init>", "()V", "onProcessStart", "", "fileIdentifier", "", "localSendMsgId", "cvsId", "scene", "onLoadVideoSuccess", "msgID", "videoParam", "enterMethod", "onLoadVideoFail", "errorMsg", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MultimodalTraceService implements IMultimodalTraceService {
    public MultimodalTraceService() {
    }

    public final void b(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "fileIdentifier");
        int r0 = MultimodalSendCostTrace.a;
        MultimodalSendCostTrace.c(r3, null, r4, null, AttachmentAreaType.NO_ATTACHMENT);
    }

    public final void c(String r3, String r4, String r5, String r6) {
        Intrinsics.checkNotNullParameter(r3, "fileIdentifier");
        int r1 = MultimodalSendCostTrace.a;
        Intrinsics.checkNotNullParameter(r3, "fileIdentifier");
        MultimodalSendCostTrace.LoadVideoStepRecord r0 = new MultimodalSendCostTrace.LoadVideoStepRecord(r4, r5, r6);
        MultimodalCommonParamManager.CommonParam r7 = MultimodalCommonParamManager.a(r3);
        if (r7 == null) goto L5;
        r7.setProcessSuccessTime(Long.valueOf(r0.getStepTime()));
    L5:
        r0.report(r3);
        MultimodalCommonParamManager.b(r3);
    }

    public final void a(String r4, String r5, String r6, String r7, String r8) {
        Intrinsics.checkNotNullParameter(r4, "fileIdentifier");
        int r1 = a.a;
        Intrinsics.checkNotNullParameter(r4, "fileIdentifier");
        MultimodalCommonParamManager.CommonParam r0 = MultimodalCommonParamManager.a(r4);
        JSONObject r2 = new JSONObject();
        r2.put("error_msg", r6);
        r2.put(MusicAppletPage.KEY_MESSAGE_ID, r5);
        r2.put("video_param", r7);
        r2.put("enter_method", r8);
        JSONObject r9 = com.larus.bmhome.chat.trace.appreciable.a.b(r0, r2);
        FLogger.a.d("MultimodalSendFailTrace", "onSendFailed, event=message_video_load_error, param=" + r9);
        o.a.reportEvent("message_video_load_error", r9);
        c.a("message_image_load_error", r9, true);
        MultimodalCommonParamManager.b(r4);
    }
}
