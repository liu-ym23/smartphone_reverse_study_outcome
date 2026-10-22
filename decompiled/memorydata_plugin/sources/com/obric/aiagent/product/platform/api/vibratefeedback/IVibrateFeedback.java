package com.obric.aiagent.product.platform.api.vibratefeedback;

import com.obric.aiagent.platform.a.f;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\u0007H\u0002¨\u0006\n"}, d2 = {"Lcom/obric/aiagent/product/platform/api/vibratefeedback/IVibrateFeedback;", "", "performVibratorSmtFeedback", "", "feedbackType", "Lcom/obric/aiagent/product/platform/api/vibratefeedback/FeedbackType;", "feedbackTypeName", "", "getFeedbackType", "typeName", "product-platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface IVibrateFeedback {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        private static FeedbackType getFeedbackType(IVibrateFeedback r4, String r5) {
            IVibrateFeedback r6 = (IVibrateFeedback) ZeusTransformUtils.wrapperContextForParams(r4, IVibrateFeedback.class, "com.obric.memorydata.plugin");
            FeedbackType[] r7 = FeedbackType.values();
            int r0 = r7.length;
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L8;
            FeedbackType r2 = r7[r1];
            if (Intrinsics.areEqual(r2.getTypeName(), r5) == true) goto L12;
            r1 = r1 + 1;
            goto L3
        L12:
            return r2;
        L8:
            return null;
        }

        public static void performVibratorSmtFeedback(IVibrateFeedback r2, String r3) {
            IVibrateFeedback r4 = (IVibrateFeedback) ZeusTransformUtils.wrapperContextForParams(r2, IVibrateFeedback.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "feedbackTypeName");
            FeedbackType r0 = FeedbackType.Companion.getByTypeName(r3);
            if (r0 == null) goto L5;
            r4.performVibratorSmtFeedback(r0);
            return;
        L5:
            f.f5958b.c("IVibrateFeedback", "not found type for " + r3);
        }
    }

    void performVibratorSmtFeedback(FeedbackType r1);

    void performVibratorSmtFeedback(String r1);
}
