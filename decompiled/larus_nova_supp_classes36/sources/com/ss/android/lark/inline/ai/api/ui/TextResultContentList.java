package com.ss.android.lark.inline.ai.api.ui;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/inline/ai/api/ui/TextResultContentList;", "Lcom/ss/android/lark/inline/ai/api/ui/BaseTextContentList;", "Lcom/ss/android/lark/inline/ai/api/ui/ParamResultDetail;", "displayContent", "", "<init>", "(Ljava/lang/String;)V", "getDisplayContent", "()Ljava/lang/String;", "setDisplayContent", "inline-ai-api_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class TextResultContentList extends BaseTextContentList<ParamResultDetail> {
    private String displayContent;

    public TextResultContentList() {
        String r0 = null;
        this(r0, 1, r0);
    }

    public final String getDisplayContent() {
        return this.displayContent;
    }

    public TextResultContentList(String r3) {
        super(null, null, 3, null);
        this.displayContent = r3;
    }

    public final void setDisplayContent(String r1) {
        this.displayContent = r1;
    }

    public /* synthetic */ TextResultContentList(String r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = "";
    L5:
        this(r1);
    }
}
