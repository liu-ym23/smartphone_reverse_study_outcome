package com.obric.assistant.cocreationreview;

import com.google.gson.annotations.SerializedName;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.tasm.event.LynxTouchEvent;
import com.obric.aivoice.core.data.NameKeys;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0081\b\u0018\u00002\u00020\u0001Be\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006\u0012\u0012\b\u0002\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0006HÆ\u0003J\t\u0010 \u001a\u00020\u0006HÆ\u0003J\t\u0010!\u001a\u00020\u0006HÆ\u0003J\u0013\u0010\"\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\fHÆ\u0003Jg\u0010#\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u00062\u0012\b\u0002\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\fHÆ\u0001J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020\u0006HÖ\u0001J\t\u0010(\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0016\u0010\b\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0016\u0010\t\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0016\u0010\n\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R \u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006)"}, d2 = {"Lcom/obric/assistant/cocreationreview/CocreationUserFeedbackStatRequest;", NameKeys.UnloadStrategy_No_Strategy, "uniqId", NameKeys.UnloadStrategy_No_Strategy, "date", "total", NameKeys.UnloadStrategy_No_Strategy, "completed", "skipped", "likes", "unlikes", LynxResourceModule.DETAIL_KEY, NameKeys.UnloadStrategy_No_Strategy, "Lcom/obric/assistant/cocreationreview/CocreationUserFeedbackStatDetail;", "<init>", "(Ljava/lang/String;Ljava/lang/String;IIIIILjava/util/List;)V", "getUniqId", "()Ljava/lang/String;", "getDate", "getTotal", "()I", "getCompleted", "getSkipped", "getLikes", "getUnlikes", "getDetails", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", NameKeys.UnloadStrategy_No_Strategy, "other", "hashCode", "toString", "cocreationreview_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CocreationUserFeedbackStatRequest {

    @SerializedName("completed")
    private final int completed;

    @SerializedName("date")
    private final String date;

    @SerializedName(LynxResourceModule.DETAIL_KEY)
    private final List<CocreationUserFeedbackStatDetail> details;

    @SerializedName("likes")
    private final int likes;

    @SerializedName("skipped")
    private final int skipped;

    @SerializedName("total")
    private final int total;

    @SerializedName("uniq_id")
    private final String uniqId;

    @SerializedName("unlikes")
    private final int unlikes;

    public CocreationUserFeedbackStatRequest() {
        this(null, null, 0, 0, 0, 0, 0, null, 255, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CocreationUserFeedbackStatRequest copy$default(CocreationUserFeedbackStatRequest r9, String r10, String r11, int r12, int r13, int r14, int r15, int r16, List r17, int r18, Object r19) {
        if ((r18 & 1) == 0) goto L5;
        String r2 = r9.uniqId;
    L7:
        if ((r18 & 2) == 0) goto L9;
        String r3 = r9.date;
    L11:
        if ((r18 & 4) == 0) goto L13;
        int r4 = r9.total;
    L15:
        if ((r18 & 8) == 0) goto L17;
        int r5 = r9.completed;
    L19:
        if ((r18 & 16) == 0) goto L21;
        int r6 = r9.skipped;
    L23:
        if ((r18 & 32) == 0) goto L25;
        int r7 = r9.likes;
    L27:
        if ((r18 & 64) == 0) goto L29;
        int r8 = r9.unlikes;
    L31:
        if ((r18 & LynxTouchEvent.kPseudoStateFocusTransition) == 0) goto L33;
        List r1 = r9.details;
    L35:
        return r9.copy(r2, r3, r4, r5, r6, r7, r8, r1);
    L33:
        r1 = r17;
        goto L35
    L29:
        r8 = r16;
        goto L31
    L25:
        r7 = r15;
        goto L27
    L21:
        r6 = r14;
        goto L23
    L17:
        r5 = r13;
        goto L19
    L13:
        r4 = r12;
        goto L15
    L9:
        r3 = r11;
        goto L11
    L5:
        r2 = r10;
        goto L7
    }

    public final String component1() {
        return this.uniqId;
    }

    public final String component2() {
        return this.date;
    }

    public final int component3() {
        return this.total;
    }

    public final int component4() {
        return this.completed;
    }

    public final int component5() {
        return this.skipped;
    }

    public final int component6() {
        return this.likes;
    }

    public final int component7() {
        return this.unlikes;
    }

    public final List<CocreationUserFeedbackStatDetail> component8() {
        return this.details;
    }

    public final CocreationUserFeedbackStatRequest copy(String r11, String r12, int r13, int r14, int r15, int r16, int r17, List<CocreationUserFeedbackStatDetail> r18) {
        return new CocreationUserFeedbackStatRequest(r11, r12, r13, r14, r15, r16, r17, r18);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof CocreationUserFeedbackStatRequest) == true) goto L8;
        return false;
    L8:
        CocreationUserFeedbackStatRequest r6 = (CocreationUserFeedbackStatRequest) r5;
        if (Intrinsics.areEqual(this.uniqId, r6.uniqId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.date, r6.date) == true) goto L15;
        return false;
    L15:
        if (this.total == r6.total) goto L18;
        return false;
    L18:
        if (this.completed == r6.completed) goto L21;
        return false;
    L21:
        if (this.skipped == r6.skipped) goto L24;
        return false;
    L24:
        if (this.likes == r6.likes) goto L27;
        return false;
    L27:
        if (this.unlikes == r6.unlikes) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.details, r6.details) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        String r0 = this.uniqId;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.date;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (((((((((((r3 + r5) * 31) + this.total) * 31) + this.completed) * 31) + this.skipped) * 31) + this.likes) * 31) + this.unlikes) * 31;
        List<CocreationUserFeedbackStatDetail> r7 = this.details;
        if (r7 == null) goto L15;
        r1 = r7.hashCode();
    L15:
        return r6 + r1;
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "CocreationUserFeedbackStatRequest(uniqId=" + this.uniqId + ", date=" + this.date + ", total=" + this.total + ", completed=" + this.completed + ", skipped=" + this.skipped + ", likes=" + this.likes + ", unlikes=" + this.unlikes + ", details=" + this.details + ')';
    }

    public final int getCompleted() {
        return this.completed;
    }

    public final String getDate() {
        return this.date;
    }

    public final List<CocreationUserFeedbackStatDetail> getDetails() {
        return this.details;
    }

    public final int getLikes() {
        return this.likes;
    }

    public final int getSkipped() {
        return this.skipped;
    }

    public final int getTotal() {
        return this.total;
    }

    public final String getUniqId() {
        return this.uniqId;
    }

    public final int getUnlikes() {
        return this.unlikes;
    }

    public CocreationUserFeedbackStatRequest(String r1, String r2, int r3, int r4, int r5, int r6, int r7, List<CocreationUserFeedbackStatDetail> r8) {
        this.uniqId = r1;
        this.date = r2;
        this.total = r3;
        this.completed = r4;
        this.skipped = r5;
        this.likes = r6;
        this.unlikes = r7;
        this.details = r8;
    }

    public /* synthetic */ CocreationUserFeedbackStatRequest(String r11, String r12, int r13, int r14, int r15, int r16, int r17, List r18, int r19, DefaultConstructorMarker r20) {
        List r2 = null;
        if ((r19 & 1) == 0) goto L5;
        String r1 = null;
    L7:
        if ((r19 & 2) == 0) goto L9;
        String r3 = null;
    L10:
        int r5 = 0;
        if ((r19 & 4) == 0) goto L13;
        int r4 = 0;
    L15:
        if ((r19 & 8) == 0) goto L17;
        int r6 = 0;
    L19:
        if ((r19 & 16) == 0) goto L21;
        int r7 = 0;
    L23:
        if ((r19 & 32) == 0) goto L25;
        int r8 = 0;
    L27:
        if ((r19 & 64) != 0) goto L31;
        r5 = r17;
    L31:
        if ((r19 & LynxTouchEvent.kPseudoStateFocusTransition) != 0) goto L34;
        r2 = r18;
    L34:
        this(r1, r3, r4, r6, r7, r8, r5, r2);
        return;
    L25:
        r8 = r16;
        goto L27
    L21:
        r7 = r15;
        goto L23
    L17:
        r6 = r14;
        goto L19
    L13:
        r4 = r13;
        goto L15
    L9:
        r3 = r12;
        goto L10
    L5:
        r1 = r11;
        goto L7
    }
}
