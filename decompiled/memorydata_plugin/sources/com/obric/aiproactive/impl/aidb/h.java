package com.obric.aiproactive.impl.aidb;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b`\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012J}\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00072\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000fH&¢\u0006\u0002\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/obric/aiproactive/impl/aidb/AiProactiveFeedbackReporter;", "", "appendEvent", "", "logId", "", "relatedType", "", "relatedInfo", "feedbackType", "feedbackReason", "feedbackText", "feedbackSource", "feedbackValue", "onResult", "Lkotlin/Function1;", "", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lkotlin/jvm/functions/Function1;)V", "Companion", "ai_proactive_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f6363a = null;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/obric/aiproactive/impl/aidb/AiProactiveFeedbackReporter$Companion;", "", "<init>", "()V", "RELATED_TYPE_RELATED", "", "RELATED_TYPE_NOT_RELATED", "FEEDBACK_TYPE_LIKE", "FEEDBACK_TYPE_DISLIKE", "ai_proactive_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f6364a = null;

        static {
            f6364a = new a();
        }

        private a() {
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class b {
        public static /* synthetic */ void a(h r13, String r14, int r15, String r16, Integer r17, String r18, String r19, String r20, Integer r21, Function1 r22, int r23, Object r24) {
            h r3 = (h) ZeusTransformUtils.wrapperContextForParams(r13, h.class, "com.obric.memorydata.plugin");
            Function1<? super Boolean, Unit> r1 = (Function1) ZeusTransformUtils.wrapperContextForParams(r22, Function1.class, "com.obric.memorydata.plugin");
            if (r24 != null) goto L35;
            if ((r23 & 4) == 0) goto L7;
            String r6 = null;
        L9:
            if ((r23 & 8) == 0) goto L11;
            Integer r7 = null;
        L13:
            if ((r23 & 16) == 0) goto L15;
            String r8 = null;
        L17:
            if ((r23 & 32) == 0) goto L19;
            String r9 = null;
        L21:
            if ((r23 & 64) == 0) goto L23;
            String r10 = null;
        L25:
            if ((r23 & 128) == 0) goto L27;
            Integer r11 = null;
        L29:
            if ((r23 & 256) == 0) goto L31;
            Function1<? super Boolean, Unit> r12 = null;
        L32:
            r3.a(r14, r15, r6, r7, r8, r9, r10, r11, r12);
            return;
        L31:
            r12 = r1;
            goto L32
        L27:
            r11 = r21;
            goto L29
        L23:
            r10 = r20;
            goto L25
        L19:
            r9 = r19;
            goto L21
        L15:
            r8 = r18;
            goto L17
        L11:
            r7 = r17;
            goto L13
        L7:
            r6 = r16;
            goto L9
        L35:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: appendEvent");
        }
    }

    static {
        f6363a = a.f6364a;
    }

    void a(String r1, int r2, String r3, Integer r4, String r5, String r6, String r7, Integer r8, Function1<? super Boolean, Unit> r9);
}
