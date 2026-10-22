package com.obric.aiproactive.api;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ba;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u008f\u0001\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\n2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00130\u00122\u0016\b\u0002\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0012¢\u0006\u0002\u0010\u0015R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/obric/aiproactive/api/AiProactiveFeedbackEventUploader;", "", "<init>", "()V", "TAG", "", "appendEventAsync", "", "logId", "relatedType", "", "relatedInfo", "feedbackType", "feedbackReason", "feedbackText", "feedbackSource", "feedbackValue", "shouldUploadFeedback", "Lkotlin/Function1;", "", "onResult", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "ai_proactive_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q f6270a = null;

    static {
        f6270a = new q();
    }

    private q() {
    }

    public final void a(String r16, int r17, String r18, Integer r19, String r20, String r21, String r22, Integer r23, Function1<? super String, Boolean> r24, Function1<? super Boolean, Unit> r25) {
        Function1 r4 = (Function1) ZeusTransformUtils.wrapperContextForParams(r24, Function1.class, "com.obric.memorydata.plugin");
        Function1 r5 = (Function1) ZeusTransformUtils.wrapperContextForParams(r25, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r16, "logId");
        Intrinsics.checkNotNullParameter(r4, "shouldUploadFeedback");
        kotlinx.coroutines.i.a(am.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin")), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AiProactiveFeedbackEventUploader$appendEventAsync$1(r23, r4, r5, r16, r17, r18, r19, r20, r21, r22, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }
}
