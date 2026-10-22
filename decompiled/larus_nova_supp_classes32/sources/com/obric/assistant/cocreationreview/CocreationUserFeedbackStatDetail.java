package com.obric.assistant.cocreationreview;

import com.google.gson.annotations.SerializedName;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001BC\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003JE\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001f"}, d2 = {"Lcom/obric/assistant/cocreationreview/CocreationUserFeedbackStatDetail;", NameKeys.UnloadStrategy_No_Strategy, "module", NameKeys.UnloadStrategy_No_Strategy, "total", "completed", "skipped", "likes", "unlikes", "<init>", "(IIIIII)V", "getModule", "()I", "getTotal", "getCompleted", "getSkipped", "getLikes", "getUnlikes", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", NameKeys.UnloadStrategy_No_Strategy, "other", "hashCode", "toString", NameKeys.UnloadStrategy_No_Strategy, "cocreationreview_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CocreationUserFeedbackStatDetail {

    @SerializedName("completed")
    private final int completed;

    @SerializedName("likes")
    private final int likes;

    @SerializedName("module")
    private final int module;

    @SerializedName("skipped")
    private final int skipped;

    @SerializedName("total")
    private final int total;

    @SerializedName("unlikes")
    private final int unlikes;

    public CocreationUserFeedbackStatDetail() {
        this(0, 0, 0, 0, 0, 0, 63, null);
    }

    public static /* synthetic */ CocreationUserFeedbackStatDetail copy$default(CocreationUserFeedbackStatDetail r4, int r5, int r6, int r7, int r8, int r9, int r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.module;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.total;
    L8:
        int r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = r4.completed;
    L11:
        int r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        r8 = r4.skipped;
    L14:
        int r1 = r8;
        if ((r11 & 16) == 0) goto L17;
        r9 = r4.likes;
    L17:
        int r2 = r9;
        if ((r11 & 32) == 0) goto L20;
        r10 = r4.unlikes;
    L20:
        int r14 = r5;
        return r4.copy(r14, r13, r0, r1, r2, r10);
    }

    public final int component1() {
        return this.module;
    }

    public final int component2() {
        return this.total;
    }

    public final int component3() {
        return this.completed;
    }

    public final int component4() {
        return this.skipped;
    }

    public final int component5() {
        return this.likes;
    }

    public final int component6() {
        return this.unlikes;
    }

    public final CocreationUserFeedbackStatDetail copy(int r9, int r10, int r11, int r12, int r13, int r14) {
        return new CocreationUserFeedbackStatDetail(r9, r10, r11, r12, r13, r14);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof CocreationUserFeedbackStatDetail) == true) goto L8;
        return false;
    L8:
        CocreationUserFeedbackStatDetail r6 = (CocreationUserFeedbackStatDetail) r5;
        if (this.module == r6.module) goto L12;
        return false;
    L12:
        if (this.total == r6.total) goto L15;
        return false;
    L15:
        if (this.completed == r6.completed) goto L18;
        return false;
    L18:
        if (this.skipped == r6.skipped) goto L21;
        return false;
    L21:
        if (this.likes == r6.likes) goto L24;
        return false;
    L24:
        if (this.unlikes == r6.unlikes) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        return (((((((((this.module * 31) + this.total) * 31) + this.completed) * 31) + this.skipped) * 31) + this.likes) * 31) + this.unlikes;
    }

    public String toString() {
        return "CocreationUserFeedbackStatDetail(module=" + this.module + ", total=" + this.total + ", completed=" + this.completed + ", skipped=" + this.skipped + ", likes=" + this.likes + ", unlikes=" + this.unlikes + ')';
    }

    public final int getCompleted() {
        return this.completed;
    }

    public final int getLikes() {
        return this.likes;
    }

    public final int getModule() {
        return this.module;
    }

    public final int getSkipped() {
        return this.skipped;
    }

    public final int getTotal() {
        return this.total;
    }

    public final int getUnlikes() {
        return this.unlikes;
    }

    public CocreationUserFeedbackStatDetail(int r1, int r2, int r3, int r4, int r5, int r6) {
        this.module = r1;
        this.total = r2;
        this.completed = r3;
        this.skipped = r4;
        this.likes = r5;
        this.unlikes = r6;
    }

    public /* synthetic */ CocreationUserFeedbackStatDetail(int r6, int r7, int r8, int r9, int r10, int r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 1) == 0) goto L5;
        int r14 = 0;
    L7:
        if ((r12 & 2) == 0) goto L9;
        int r1 = 0;
    L11:
        if ((r12 & 4) == 0) goto L13;
        int r2 = 0;
    L15:
        if ((r12 & 8) == 0) goto L17;
        int r3 = 0;
    L19:
        if ((r12 & 16) == 0) goto L21;
        int r4 = 0;
    L23:
        if ((r12 & 32) == 0) goto L25;
        int r15 = 0;
    L26:
        this(r14, r1, r2, r3, r4, r15);
        return;
    L25:
        r15 = r11;
        goto L26
    L21:
        r4 = r10;
        goto L23
    L17:
        r3 = r9;
        goto L19
    L13:
        r2 = r8;
        goto L15
    L9:
        r1 = r7;
        goto L11
    L5:
        r14 = r6;
        goto L7
    }
}
