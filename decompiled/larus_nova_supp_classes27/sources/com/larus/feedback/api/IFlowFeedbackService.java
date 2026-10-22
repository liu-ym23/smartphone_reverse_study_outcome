package com.larus.feedback.api;

import androidx.fragment.app.DialogFragment;
import com.larus.feedback.api.model.FlowDislikePanelConfig;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import o99.a;
import p99.d;
import q99.c;
import q99.i;
import q99.m;
import tc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0096@¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0003H&J\u0012\u0010\f\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH&J\u0018\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H&J.\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00172\u001c\b\u0002\u0010\u0018\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u001a\u0012\u0004\u0012\u00020\n\u0018\u00010\u0019H&J\u001c\u0010\u001b\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u001c2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001eH&¨\u0006\u001f"}, d2 = {"Lcom/larus/feedback/api/IFlowFeedbackService;", "", "collectRecentMessagesExtra", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "bindChatPage", "Lcom/larus/feedback/api/manager/BaseIMFeedbackManager;", "host", "Lcom/larus/feedback/api/model/FlowFeedbackHost;", "unbindChatPage", "", "cvsId", "onReceiveInAppNotification", "notify", "Lcom/larus/im/bean/InAppBannerNotify;", "tryQueryAndShowFeedbackNotification", "request", "Lcom/larus/feedback/api/model/FlowFeedbackContentRequest;", "createDislikeDialog", "Landroidx/fragment/app/DialogFragment;", "config", "Lcom/larus/feedback/api/model/FlowDislikePanelConfig;", "reportFeedback", "Lcom/larus/feedback/api/model/FlowFeedbackSubmitRequest;", "callback", "Lkotlin/Function1;", "Lcom/larus/network/bean/HttpDataResult;", "submitMessageFeedback", "Lcom/larus/feedback/api/model/FlowMessageFeedbackRequest;", "listener", "Lcom/larus/feedback/api/listener/IFeedbackListener;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IFlowFeedbackService {
    void a(c r1, i r2);

    void b(String r1);

    void c(e r1);

    DialogFragment d(FlowDislikePanelConfig r1);

    d e(i r1);

    Object f(Continuation<? super String> r1);

    void g(m r1, a r2);
}
