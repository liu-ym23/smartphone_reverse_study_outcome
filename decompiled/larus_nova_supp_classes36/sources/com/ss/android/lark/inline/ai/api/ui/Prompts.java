package com.ss.android.lark.inline.ai.api.ui;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u001c\b\u0002\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\b¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0015\u001a\u00020\u0016H\u0016J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u0019\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\bHÆ\u0003J;\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u001c\b\u0002\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\bHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u00032\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR.\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006 "}, d2 = {"Lcom/ss/android/lark/inline/ai/api/ui/Prompts;", "Ljava/io/Serializable;", "show", "", "overlap", "data", "Ljava/util/ArrayList;", "Lcom/ss/android/lark/inline/ai/api/ui/PromptGroup;", "Lkotlin/collections/ArrayList;", "<init>", "(ZZLjava/util/ArrayList;)V", "getShow", "()Z", "setShow", "(Z)V", "getOverlap", "setOverlap", "getData", "()Ljava/util/ArrayList;", "setData", "(Ljava/util/ArrayList;)V", "toString", "", "component1", "component2", "component3", "copy", "equals", INotificationHitPoint.NoticeType.OTHER, "", "hashCode", "", "inline-ai-api_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class Prompts implements Serializable {
    private ArrayList<PromptGroup> data;
    private boolean overlap;
    private boolean show;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Prompts copy$default(Prompts r0, boolean r1, boolean r2, ArrayList r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.show;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.overlap;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.data;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final boolean component1() {
        return this.show;
    }

    public final boolean component2() {
        return this.overlap;
    }

    public final ArrayList<PromptGroup> component3() {
        return this.data;
    }

    public final Prompts copy(boolean r2, boolean r3, ArrayList<PromptGroup> r4) {
        return new Prompts(r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof Prompts) == true) goto L8;
        return false;
    L8:
        Prompts r6 = (Prompts) r5;
        if (this.show == r6.show) goto L12;
        return false;
    L12:
        if (this.overlap == r6.overlap) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.data, r6.data) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r1 = 1231;
        if (this.show == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = r0 * 31;
        if (this.overlap == true) goto L10;
        r1 = 1237;
    L10:
        int r3 = (r2 + r1) * 31;
        ArrayList<PromptGroup> r4 = this.data;
        if (r4 != null) goto L13;
        int r5 = 0;
    L15:
        return r3 + r5;
    L13:
        r5 = r4.hashCode();
        goto L15
    L5:
        r0 = 1237;
        goto L6
    }

    public String toString() {
        return "Prompts(show=" + this.show + ", data=" + this.data + ')';
    }

    public final ArrayList<PromptGroup> getData() {
        return this.data;
    }

    public final boolean getOverlap() {
        return this.overlap;
    }

    public final boolean getShow() {
        return this.show;
    }

    public final void setData(ArrayList<PromptGroup> r1) {
        this.data = r1;
    }

    public final void setOverlap(boolean r1) {
        this.overlap = r1;
    }

    public final void setShow(boolean r1) {
        this.show = r1;
    }

    public Prompts(boolean r1, boolean r2, ArrayList<PromptGroup> r3) {
        this.show = r1;
        this.overlap = r2;
        this.data = r3;
    }

    public /* synthetic */ Prompts(boolean r1, boolean r2, ArrayList r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = null;
    L5:
        this(r1, r2, r3);
    }
}
