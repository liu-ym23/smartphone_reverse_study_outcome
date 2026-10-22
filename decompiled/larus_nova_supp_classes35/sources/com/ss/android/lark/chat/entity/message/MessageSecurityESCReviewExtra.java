package com.ss.android.lark.chat.entity.message;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/MessageSecurityESCReviewExtra;", "Ljava/io/Serializable;", "tipText", BuildConfig.FLAVOR, "submitText", "feedBackUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getTipText", "()Ljava/lang/String;", "getSubmitText", "getFeedBackUrl", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MessageSecurityESCReviewExtra implements Serializable {
    private final String feedBackUrl;
    private final String submitText;
    private final String tipText;

    public final String getFeedBackUrl() {
        return this.feedBackUrl;
    }

    public final String getSubmitText() {
        return this.submitText;
    }

    public final String getTipText() {
        return this.tipText;
    }

    public MessageSecurityESCReviewExtra(String r1, String r2, String r3) {
        this.tipText = r1;
        this.submitText = r2;
        this.feedBackUrl = r3;
    }
}
