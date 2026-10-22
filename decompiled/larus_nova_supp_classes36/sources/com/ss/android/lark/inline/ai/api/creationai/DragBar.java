package com.ss.android.lark.inline.ai.api.creationai;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\r\u001a\u00020\u000eH\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\u000f"}, d2 = {"Lcom/ss/android/lark/inline/ai/api/creationai/DragBar;", "Ljava/io/Serializable;", "<init>", "()V", "show", "", "getShow", "()Z", "setShow", "(Z)V", "doubleConfirm", "getDoubleConfirm", "setDoubleConfirm", "toString", "", "inline-ai-api_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class DragBar implements Serializable {
    private boolean doubleConfirm;
    private boolean show;

    public DragBar() {
    }

    public String toString() {
        return "DragBar(show=" + this.show + ", doubleConfirm=" + this.doubleConfirm + ')';
    }

    public final boolean getDoubleConfirm() {
        return this.doubleConfirm;
    }

    public final boolean getShow() {
        return this.show;
    }

    public final void setDoubleConfirm(boolean r1) {
        this.doubleConfirm = r1;
    }

    public final void setShow(boolean r1) {
        this.show = r1;
    }
}
