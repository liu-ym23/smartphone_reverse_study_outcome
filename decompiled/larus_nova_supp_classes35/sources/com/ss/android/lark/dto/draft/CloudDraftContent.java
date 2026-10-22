package com.ss.android.lark.dto.draft;

import com.ss.android.lark.widget.richtext.RichText;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/dto/draft/CloudDraftContent;", "Ljava/io/Serializable;", "title", BuildConfig.FLAVOR, "content", "Lcom/ss/android/lark/widget/richtext/RichText;", "<init>", "(Ljava/lang/String;Lcom/ss/android/lark/widget/richtext/RichText;)V", "getTitle", "()Ljava/lang/String;", "getContent", "()Lcom/ss/android/lark/widget/richtext/RichText;", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CloudDraftContent implements Serializable {
    private final RichText content;
    private final String title;

    public final RichText getContent() {
        return this.content;
    }

    public final String getTitle() {
        return this.title;
    }

    public CloudDraftContent(String r1, RichText r2) {
        this.title = r1;
        this.content = r2;
    }
}
