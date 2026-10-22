package com.obric.assistant.spi.feedback;

import com.larus.bmhome.auth.ReportReason;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import dx7.b;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0096\u0001Jr\u0010\t\u001a\u00020\u00052\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00072\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u00072\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u00072\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u000bH\u0096\u0001¢\u0006\u0002\u0010\u0013J\u0011\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0016H\u0096\u0001J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\rH\u0096\u0001J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\rH\u0096\u0001¨\u0006\u0019"}, d2 = {"Lcom/obric/assistant/spi/feedback/FeedbackServiceDelegate;", "Lcom/obric/assistant/spi/feedback/IFeedbackService;", "<init>", "()V", "cacheReasonList", "", "metaList", "", "Lcom/larus/bmhome/auth/ReportReason;", "feedback", "reasonIds", "", "tagList", "", "content", "urlList", "messageIdList", "filePathList", "reportType", "(Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/Integer;)V", "feedbackReadableMap", "params", "", "getSubmitFeedbackSuccessText", "getSubmitFeedbackText", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FeedbackServiceDelegate implements IFeedbackService {
    public static final FeedbackServiceDelegate b = null;
    public final /* synthetic */ IFeedbackService a;

    static {
        b = new FeedbackServiceDelegate();
    }

    @Override // com.obric.assistant.spi.feedback.IFeedbackService
    public final String a() {
        return this.a.a();
    }

    @Override // com.obric.assistant.spi.feedback.IFeedbackService
    public final void b(List<Integer> r9, List<String> r10, String r11, List<String> r12, List<String> r13, List<String> r14, Integer r15) {
        this.a.b(r9, r10, r11, r12, r13, r14, r15);
    }

    @Override // com.obric.assistant.spi.feedback.IFeedbackService
    public final void c(List<ReportReason> r2) {
        Intrinsics.checkNotNullParameter(r2, "metaList");
        this.a.c(r2);
    }

    @Override // com.obric.assistant.spi.feedback.IFeedbackService
    public final String d() {
        return this.a.d();
    }

    @Override // com.obric.assistant.spi.feedback.IFeedbackService
    public final void e(b r2) {
        Intrinsics.checkNotNullParameter(r2, "params");
        this.a.e(r2);
    }

    private FeedbackServiceDelegate() {
        IFeedbackService r0 = (IFeedbackService) ServiceManager.get().getService(IFeedbackService.class);
        if (r0 != null) goto L5;
        r0 = new DefaultFeedbackServiceImpl();
    L5:
        this.a = r0;
    }
}
