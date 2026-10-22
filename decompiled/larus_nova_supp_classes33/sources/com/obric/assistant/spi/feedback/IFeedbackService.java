package com.obric.assistant.spi.feedback;

import com.larus.bmhome.auth.ReportReason;
import dx7.b;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0001H&J\u007f\u0010\t\u001a\u00020\u00032\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00052\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u00052\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u00052\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000bH&¢\u0006\u0002\u0010\u0013J\n\u0010\u0014\u001a\u0004\u0018\u00010\rH&J\n\u0010\u0015\u001a\u0004\u0018\u00010\rH&¨\u0006\u0016"}, d2 = {"Lcom/obric/assistant/spi/feedback/IFeedbackService;", "", "cacheReasonList", "", "metaList", "", "Lcom/larus/bmhome/auth/ReportReason;", "feedbackReadableMap", "params", "feedback", "reasonIds", "", "tagList", "", "content", "urlList", "messageIdList", "filePathList", "reportType", "(Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/Integer;)V", "getSubmitFeedbackText", "getSubmitFeedbackSuccessText", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IFeedbackService {

    public static final class a {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void a(IFeedbackService r10, List r11, String r12, List r13, List r14, Integer r15, int r16) {
            if ((r16 & 1) == 0) goto L5;
            List r3 = null;
        L7:
            if ((r16 & 4) == 0) goto L9;
            String r5 = null;
        L11:
            if ((r16 & 8) == 0) goto L13;
            List r6 = null;
        L15:
            if ((r16 & 16) == 0) goto L17;
            List r7 = null;
        L19:
            if ((r16 & 64) == 0) goto L21;
            Integer r9 = null;
        L22:
            r10.b(r3, null, r5, r6, r7, null, r9);
            return;
        L21:
            r9 = r15;
            goto L22
        L17:
            r7 = r14;
            goto L19
        L13:
            r6 = r13;
            goto L15
        L9:
            r5 = r12;
            goto L11
        L5:
            r3 = r11;
            goto L7
        }
    }

    String a();

    void b(List<Integer> r1, List<String> r2, String r3, List<String> r4, List<String> r5, List<String> r6, Integer r7);

    void c(List<ReportReason> r1);

    String d();

    void e(b r1);
}
