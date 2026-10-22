package com.obric.assistant.feedback.impl;

import android.os.IBinder;
import com.obric.aiagent.assistant.idl.IFlowFeedbackIDLSPI;
import com.obric.aiagent.assistant.idl.bean.FeedbackBean;
import com.obric.assistant.feedback.IObricFeedbackService;
import java.util.ArrayList;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/obric/assistant/feedback/impl/FlowFeedbackIDLStub;", "Lcom/obric/aiagent/assistant/idl/IFlowFeedbackIDLSPI;", "<init>", "()V", "onFeedback", "", "data", "Lcom/obric/aiagent/assistant/idl/bean/FeedbackBean;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FlowFeedbackIDLStub implements IFlowFeedbackIDLSPI {
    public FlowFeedbackIDLStub() {
    }

    public IBinder asBinder() {
        return null;
    }

    public void onFeedback(FeedbackBean r24) {
        IObricFeedbackService.a.getClass();
        IObricFeedbackService r0 = IObricFeedbackService.a.a();
        if (r0 == null) goto L23;
        ArrayList r1 = null;
        if (r24 == null) goto L7;
        String r3 = r24.getDescription();
    L9:
        if (r24 == null) goto L11;
        r1 = r24.getFilePath();
    L11:
        ArrayList r13 = r1;
        if (r24 == null) goto L14;
        boolean r14 = r24.getLaunchReportAppWhenNoPermission();
    L15:
        if (r24 == null) goto L17;
        boolean r16 = r24.getNeedReportVoc();
    L18:
        if (r24 == null) goto L20;
        boolean r21 = r24.getNeedShowToast();
    L21:
        r0.a(new IObricFeedbackService.c(null, r3, null, null, null, null, null, null, null, null, false, r13, r14, r16, r21, null, false, null, 493552));
        return;
    L20:
        r21 = false;
        goto L21
    L17:
        r16 = false;
        goto L18
    L14:
        r14 = false;
        goto L15
    L7:
        r3 = null;
        goto L9
    }
}
