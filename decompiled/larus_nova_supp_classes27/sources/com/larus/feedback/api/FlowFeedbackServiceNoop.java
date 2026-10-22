package com.larus.feedback.api;

import androidx.fragment.app.DialogFragment;
import com.larus.feedback.api.model.FlowDislikePanelConfig;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import o99.a;
import p99.d;
import q99.c;
import q99.i;
import q99.m;
import tc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0012\u0010\f\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J,\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u00172\u001a\u0010\u0018\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u001a\u0012\u0004\u0012\u00020\t\u0018\u00010\u0019H\u0016J\u001a\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016¨\u0006\u001f"}, d2 = {"Lcom/larus/feedback/api/FlowFeedbackServiceNoop;", "Lcom/larus/feedback/api/IFlowFeedbackService;", "<init>", "()V", "bindChatPage", "Lcom/larus/feedback/api/manager/BaseIMFeedbackManager;", "host", "Lcom/larus/feedback/api/model/FlowFeedbackHost;", "unbindChatPage", "", "cvsId", "", "onReceiveInAppNotification", "notify", "Lcom/larus/im/bean/InAppBannerNotify;", "tryQueryAndShowFeedbackNotification", "request", "Lcom/larus/feedback/api/model/FlowFeedbackContentRequest;", "createDislikeDialog", "Landroidx/fragment/app/DialogFragment;", "config", "Lcom/larus/feedback/api/model/FlowDislikePanelConfig;", "reportFeedback", "Lcom/larus/feedback/api/model/FlowFeedbackSubmitRequest;", "callback", "Lkotlin/Function1;", "Lcom/larus/network/bean/HttpDataResult;", "submitMessageFeedback", "Lcom/larus/feedback/api/model/FlowMessageFeedbackRequest;", "listener", "Lcom/larus/feedback/api/listener/IFeedbackListener;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FlowFeedbackServiceNoop implements IFlowFeedbackService {
    public FlowFeedbackServiceNoop() {
    }

    @Override // com.larus.feedback.api.IFlowFeedbackService
    public final void a(c r2, i r3) {
        Intrinsics.checkNotNullParameter(r2, "request");
        Intrinsics.checkNotNullParameter(r3, "host");
    }

    @Override // com.larus.feedback.api.IFlowFeedbackService
    public final void b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "cvsId");
    }

    @Override // com.larus.feedback.api.IFlowFeedbackService
    public final void c(e r1) {
    }

    @Override // com.larus.feedback.api.IFlowFeedbackService
    public final Object f(Continuation<? super String> r1) {
        return null;
    }

    @Override // com.larus.feedback.api.IFlowFeedbackService
    public final void g(m r1, a r2) {
        Intrinsics.checkNotNullParameter(r1, "request");
    }

    @Override // com.larus.feedback.api.IFlowFeedbackService
    public final DialogFragment d(FlowDislikePanelConfig r2) {
        Intrinsics.checkNotNullParameter(r2, "config");
        return new DialogFragment();
    }

    @Override // com.larus.feedback.api.IFlowFeedbackService
    public final d e(i r2) {
        Intrinsics.checkNotNullParameter(r2, "host");
        return new d.a(r2);
    }
}
