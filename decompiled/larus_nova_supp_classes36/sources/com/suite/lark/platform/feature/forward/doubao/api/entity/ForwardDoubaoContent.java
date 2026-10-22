package com.suite.lark.platform.feature.forward.doubao.api.entity;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR \u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/suite/lark/platform/feature/forward/doubao/api/entity/ForwardDoubaoContent;", "Ljava/io/Serializable;", "<init>", "()V", "textContent", "", "getTextContent", "()Ljava/lang/String;", "setTextContent", "(Ljava/lang/String;)V", "previewText", "getPreviewText", "setPreviewText", "doubaoMsgIds", "", "", "getDoubaoMsgIds", "()Ljava/util/List;", "setDoubaoMsgIds", "(Ljava/util/List;)V", "doubaoData", "", "getDoubaoData", "()[B", "setDoubaoData", "([B)V", "forward-doubao-api_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class ForwardDoubaoContent implements Serializable {
    private byte[] doubaoData;
    private List<Long> doubaoMsgIds;
    private String previewText;
    private String textContent;

    public ForwardDoubaoContent() {
        this.textContent = "";
        this.previewText = "";
        this.doubaoMsgIds = CollectionsKt.emptyList();
    }

    public final byte[] getDoubaoData() {
        return this.doubaoData;
    }

    public final List<Long> getDoubaoMsgIds() {
        return this.doubaoMsgIds;
    }

    public final String getPreviewText() {
        return this.previewText;
    }

    public final String getTextContent() {
        return this.textContent;
    }

    public final void setDoubaoData(byte[] r1) {
        this.doubaoData = r1;
    }

    public final void setDoubaoMsgIds(List<Long> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.doubaoMsgIds = r2;
    }

    public final void setPreviewText(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.previewText = r2;
    }

    public final void setTextContent(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.textContent = r2;
    }
}
