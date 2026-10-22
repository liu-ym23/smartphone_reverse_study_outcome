package com.obric.aiagent.product.platform.impl.vibratefeedback;

import com.obric.aiagent.product.platform.api.vibratefeedback.FeedbackType;
import com.obric.aiagent.product.platform.api.vibratefeedback.IVibrateFeedback;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\t"}, d2 = {"Lcom/obric/aiagent/product/platform/impl/vibratefeedback/PacificVibrateFeedback;", "Lcom/obric/aiagent/product/platform/api/vibratefeedback/IVibrateFeedback;", "<init>", "()V", "performVibratorSmtFeedback", "", "feedbackType", "Lcom/obric/aiagent/product/platform/api/vibratefeedback/FeedbackType;", "Companion", "product-platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PacificVibrateFeedback implements IVibrateFeedback {
    public static final Companion Companion = null;
    private static final String TAG = "PacificVibrateFeedback";

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/aiagent/product/platform/impl/vibratefeedback/PacificVibrateFeedback$Companion;", "", "<init>", "()V", "TAG", "", "product-platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public PacificVibrateFeedback() {
    }

    @Override // com.obric.aiagent.product.platform.api.vibratefeedback.IVibrateFeedback
    public void performVibratorSmtFeedback(FeedbackType r1) {
        Intrinsics.checkNotNullParameter(r1, "feedbackType");
        SystemHiddenApiHelper.INSTANCE.performVibratorSmtFeedback(r1.getTypeName());
    }

    @Override // com.obric.aiagent.product.platform.api.vibratefeedback.IVibrateFeedback
    public void performVibratorSmtFeedback(String r1) {
        IVibrateFeedback.DefaultImpls.performVibratorSmtFeedback(this, r1);
    }
}
