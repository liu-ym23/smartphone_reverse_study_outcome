package com.ss.android.lark.inline.ai.api.creationai;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010$\u001a\u00020%H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR.\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011j\n\u0012\u0004\u0012\u00020\u0012\u0018\u0001`\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u0006&"}, d2 = {"Lcom/ss/android/lark/inline/ai/api/creationai/SubPanelInfo;", "Ljava/io/Serializable;", "<init>", "()V", "show", "", "getShow", "()Z", "setShow", "(Z)V", "header", "Lcom/ss/android/lark/inline/ai/api/creationai/Header;", "getHeader", "()Lcom/ss/android/lark/inline/ai/api/creationai/Header;", "setHeader", "(Lcom/ss/android/lark/inline/ai/api/creationai/Header;)V", "data", "Ljava/util/ArrayList;", "Lcom/ss/android/lark/inline/ai/api/creationai/MenuItem;", "Lkotlin/collections/ArrayList;", "getData", "()Ljava/util/ArrayList;", "setData", "(Ljava/util/ArrayList;)V", "dragBar", "Lcom/ss/android/lark/inline/ai/api/creationai/DragBar;", "getDragBar", "()Lcom/ss/android/lark/inline/ai/api/creationai/DragBar;", "setDragBar", "(Lcom/ss/android/lark/inline/ai/api/creationai/DragBar;)V", "status", "Lcom/ss/android/lark/inline/ai/api/creationai/StatusInfo;", "getStatus", "()Lcom/ss/android/lark/inline/ai/api/creationai/StatusInfo;", "setStatus", "(Lcom/ss/android/lark/inline/ai/api/creationai/StatusInfo;)V", "toString", "", "inline-ai-api_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class SubPanelInfo implements Serializable {
    private ArrayList<MenuItem> data;
    private DragBar dragBar;
    private Header header;
    private boolean show;
    private StatusInfo status;

    public SubPanelInfo() {
    }

    public String toString() {
        return "SubPanelInfo(show=" + this.show + ", header=" + this.header + ", data=" + this.data + ", dragBar=" + this.dragBar + ", status=" + this.status + ')';
    }

    public final ArrayList<MenuItem> getData() {
        return this.data;
    }

    public final DragBar getDragBar() {
        return this.dragBar;
    }

    public final Header getHeader() {
        return this.header;
    }

    public final boolean getShow() {
        return this.show;
    }

    public final StatusInfo getStatus() {
        return this.status;
    }

    public final void setData(ArrayList<MenuItem> r1) {
        this.data = r1;
    }

    public final void setDragBar(DragBar r1) {
        this.dragBar = r1;
    }

    public final void setHeader(Header r1) {
        this.header = r1;
    }

    public final void setShow(boolean r1) {
        this.show = r1;
    }

    public final void setStatus(StatusInfo r1) {
        this.status = r1;
    }
}
